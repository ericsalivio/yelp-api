package com.go.crescendia.service.resource;

import com.go.crescendia.service.model.dto.BusinessSearchPayload;
import com.go.crescendia.service.service.ISearchApiService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/yelp")
public class SearchResource {

    @Autowired
    private ISearchApiService iSearchApiService;

    @ApiOperation(httpMethod = "GET",
            value = "Get reviews by url input", notes = "Get reviews by url input example: la-palma-mexicatessen-san-francisco ",
            response = BusinessSearchPayload.class)
    @ResponseBody
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getReviews(@ApiParam(value = "Get bussiness info and reviews", required = true)
                                                                                     @RequestParam ("url") String url,
                                     @ApiParam(value = "Use your YELP API key", required = true)
                                     @RequestParam ("key") String key) {
       return new ResponseEntity<>(iSearchApiService.search(url,key), HttpStatus.ACCEPTED);
    }

}
