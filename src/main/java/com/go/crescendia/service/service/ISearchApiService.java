package com.go.crescendia.service.service;

import com.go.crescendia.service.model.dto.BusinessSearchPayload;

public interface ISearchApiService {
    BusinessSearchPayload search(String url, String key);
}
