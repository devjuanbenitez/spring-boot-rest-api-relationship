package com.dev.juanbe.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan("com.dev.juanbe.domain")
@EnableJpaRepositories("com.dev.juanbe.repos")
@EnableTransactionManagement
public class DomainConfig {
}
