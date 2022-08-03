package com.github.rahulpoptani.prometheus.controller;

import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.Counter;
import io.prometheus.client.exporter.common.TextFormat;
import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.Writer;

@Controller
@SpringBootApplication
@EnablePrometheusEndpoint
public class HelloWorldController {

    private final Counter promRequestTotal = Counter.build().name("requests_total").help("Total number of requests").register();

    @RequestMapping(path = "/hello-world")
    public @ResponseBody String sayHello() {
        promRequestTotal.inc();
        return "Hello World!";
    }

//    @RequestMapping(path = "/prometheus")
//    public void metrics(Writer responseWriter) throws IOException {
//        TextFormat.write004(responseWriter, CollectorRegistry.defaultRegistry.metricFamilySamples());
//        responseWriter.close();
//    }

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldController.class, args);
    }
}
