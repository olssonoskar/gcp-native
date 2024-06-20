package com.olsson.gcp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.Instant;

@SpringBootApplication
@RestController
public class GcpApplication {

	private static Instant start;
	private Instant ready;

	public static void main(String[] args) {
		start = Instant.now();
		SpringApplication.run(GcpApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void setReady() {
		ready = Instant.now();
	}

	@GetMapping("/started")
	public String started() {
		return "Started in " + Duration.between(start, ready).toMillis() + " ms";
	}
}
