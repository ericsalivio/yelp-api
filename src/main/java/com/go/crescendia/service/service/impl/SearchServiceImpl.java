package com.go.crescendia.service.service.impl;

import com.go.crescendia.service.model.dto.BusinessSearchPayload;
import com.go.crescendia.service.service.ISearchApiService;
import com.go.crescendia.service.service.IYelpApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SearchServiceImpl implements ISearchApiService {


    private final IYelpApiService iYelpApiService;
    private static final String HTTPS_API_YELP_COM_V_3_BUSINESSES = "https://api.yelp.com/v3/businesses/";
    public static final String HTTPS_VISION_GOOGLEAPIS_COM_V_1_IMAGES_ANNOTATE = "https://vision.googleapis.com/v1/images:annotate";

    @Override
    public BusinessSearchPayload search(String url, String key) {
        BusinessSearchPayload bid = iYelpApiService.invoke(HTTPS_API_YELP_COM_V_3_BUSINESSES + url, BusinessSearchPayload.class,defaultHeader(), HttpMethod.GET);

        String reviewsUrl =  HTTPS_API_YELP_COM_V_3_BUSINESSES + bid.getBusinessId() + "/reviews";

        BusinessSearchPayload reviews =  iYelpApiService.invoke(reviewsUrl, BusinessSearchPayload.class,defaultHeader(), HttpMethod.GET);
        reviews.setBusinessId(bid.getBusinessId());
        reviews.setName(bid.getName());

        reviews.getReviews().stream().forEach( reviewsPayload -> {
            //consume api google vision face detection
        });

       return reviews;
    }
    private HttpHeaders defaultHeader(String key) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer "+key);
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
