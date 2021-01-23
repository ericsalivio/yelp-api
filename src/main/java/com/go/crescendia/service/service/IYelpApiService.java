package com.go.crescendia.service.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

public interface IYelpApiService {
    <T> T invoke(String url, Class<T> responseType, HttpHeaders headers, HttpMethod method);
}
