package com.go.crescendia.service.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AppConfigProperties {

    private final RestTemplateBuilder restTemplateBuilder;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        int timeout = 60000;
        int readTimeout = 60000;
        HttpComponentsClientHttpRequestFactory httpRequestFactory =
                new HttpComponentsClientHttpRequestFactory();
        httpRequestFactory.setConnectionRequestTimeout(
                timeout);
        httpRequestFactory
                .setConnectTimeout(timeout);
        httpRequestFactory.setReadTimeout(readTimeout);

        return new RestTemplate(httpRequestFactory);

    }


}
