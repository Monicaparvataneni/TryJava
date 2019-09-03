package com.monica.microservices.limits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {
	@Autowired
	Configuration configuration;
	@GetMapping("/limits")
	public LimitConfiguration retrivalLimistForConfiguration() {
		return new LimitConfiguration(configuration.getMin(), configuration.getMax());
	}
}
