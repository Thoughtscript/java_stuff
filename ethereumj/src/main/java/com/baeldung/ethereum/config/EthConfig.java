package com.baeldung.ethereum.config;

import com.baeldung.ethereum.beans.EthBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executors;

@Configuration
public class EthConfig {

    @Bean
    EthBean ethBeanConfig() throws Exception {
        EthBean eBean = new EthBean();
        Executors.newSingleThreadExecutor().submit(eBean::start);
        return eBean;
    }
}