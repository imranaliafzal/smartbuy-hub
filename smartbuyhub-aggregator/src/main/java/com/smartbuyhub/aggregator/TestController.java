package com.smartbuyhub.aggregator;	

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.*;

@RestController
public class TestController {
    @GetMapping("/test")
    public String test() {
        return "Aggregator is working";
    }
}