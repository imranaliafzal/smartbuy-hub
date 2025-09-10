package com.imranaliafzal.ai.platform.resiliance;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import io.github.resilience4j.common.circuitbreaker.configuration.CircuitBreakerConfigCustomizer;
import io.github.resilience4j.common.timelimiter.configuration.TimeLimiterConfigCustomizer;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;
import reactor.netty.transport.ProxyProvider;

@AutoConfiguration
@EnableConfigurationProperties(HttpClientProperties.class)
public class ResilienceAutoConfiguration {

    @Bean
    public WebClient.Builder resilientWebClientBuilder(HttpClientProperties props) {

        ConnectionProvider pool = ConnectionProvider.builder("acme-pool")
                .maxConnections(props.getMaxConnections())
                .pendingAcquireMaxCount(-1)
                .build();

        HttpClient httpClient = HttpClient.create(pool)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, props.getConnectTimeoutMs())
                .doOnConnected(conn -> conn
                        .addHandlerLast(new ReadTimeoutHandler(props.getResponseTimeoutMs(), TimeUnit.MILLISECONDS))
                        .addHandlerLast(new WriteTimeoutHandler(props.getResponseTimeoutMs(), TimeUnit.MILLISECONDS)))
                .compress(true);

        ExchangeStrategies strategies = ExchangeStrategies.builder()
                .codecs(cfg -> cfg.defaultCodecs().maxInMemorySize(4 * 1024 * 1024)) // 4MB
                .build();

        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .exchangeStrategies(strategies);
    }

    // Default CB/TL; can be overridden per instance via annotations or properties
    @Bean
    public CircuitBreakerConfigCustomizer defaultCircuitBreaker() {
        return CircuitBreakerConfigCustomizer
                .of("default", builder -> builder
                        .failureRateThreshold(50.0f)
                        .slowCallRateThreshold(50.0f)
                        .slowCallDurationThreshold(Duration.ofSeconds(4))
                        .slidingWindowSize(50)
                        .minimumNumberOfCalls(10)
                        .permittedNumberOfCallsInHalfOpenState(5)
                        .waitDurationInOpenState(Duration.ofSeconds(10))
                        .recordExceptions(Throwable.class));
    }

    @Bean
    public TimeLimiterConfigCustomizer defaultTimeLimiter() {
        return TimeLimiterConfigCustomizer
                .of("default", builder -> builder
                        .timeoutDuration(Duration.ofSeconds(8)));
    }
}
