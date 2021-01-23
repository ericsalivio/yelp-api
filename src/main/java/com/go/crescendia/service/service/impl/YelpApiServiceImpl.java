package com.go.crescendia.service.service.impl;

import com.go.crescendia.service.service.IYelpApiService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class YelpApiServiceImpl implements IYelpApiService {

    public static final Logger logger = LoggerFactory.getLogger(YelpApiServiceImpl.class);


    private final RestTemplate restTemplate;

    @Override
    public <T> T invoke(String url, Class<T> responseType,HttpHeaders headers,HttpMethod method) {
        logger.info("Consuming URL: {}", url);
        HttpEntity<String> entity = new HttpEntity<>( headers);
        return restTemplate.exchange(url, method, entity, responseType).getBody();
    }




}
