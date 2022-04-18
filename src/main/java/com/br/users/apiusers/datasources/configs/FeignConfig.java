package com.br.users.apiusers.datasources.configs;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = {"com.br.users.apiusers.datasources.feign"})
public class FeignConfig {
}
