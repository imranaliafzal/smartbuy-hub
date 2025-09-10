package com.imranaliafzal.ai.platform.resiliance;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "acme.http")
public class HttpClientProperties {
    /**
     * Base connect timeout in milliseconds.
     */
    private int connectTimeoutMs = 3000;

    /**
     * Response timeout in milliseconds.
     */
    private int responseTimeoutMs = 10000;

    /**
     * Max connections in pool.
     */
    private int maxConnections = 200;

    public int getConnectTimeoutMs() { return connectTimeoutMs; }
    public void setConnectTimeoutMs(int v) { this.connectTimeoutMs = v; }

    public int getResponseTimeoutMs() { return responseTimeoutMs; }
    public void setResponseTimeoutMs(int v) { this.responseTimeoutMs = v; }

    public int getMaxConnections() { return maxConnections; }
    public void setMaxConnections(int v) { this.maxConnections = v; }
}
