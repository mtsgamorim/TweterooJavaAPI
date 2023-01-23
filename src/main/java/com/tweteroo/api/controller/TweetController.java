package com.tweteroo.api.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.model.Tweet;
import com.tweteroo.api.service.TweetService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class TweetController {
    @Autowired
    private TweetService service;

    @PostMapping("/tweets")
    public String create(@RequestBody @Valid TweetDTO req) {
        System.out.println(req);
        Tweet tweet = new Tweet(req);
        service.create(tweet); 
        return "OK";
    }

    @GetMapping("/tweets")
    public List<Tweet> list(@PageableDefault(sort = "id", direction = Sort.Direction.DESC  ,page = 0, size = 5 ) Pageable page) {
       return service.getTweets(page);
    }

    @GetMapping("/tweets/{username}")
    public List<Tweet> listByUsername(@PathVariable String username){
        List<Tweet> tweets = service.getTweetsByUsername(username);
        Collections.reverse(tweets);
        return tweets;
    }
}
