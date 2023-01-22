package com.tweteroo.api.service;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tweteroo.api.model.Tweet;
import com.tweteroo.api.model.TweeteroUser;
import com.tweteroo.api.repository.TweetRepository;
import com.tweteroo.api.repository.UserRepository;


@Service
public class TweetService {
    
    @Autowired
    private TweetRepository tweetRepository;

    @Autowired
    private UserRepository userRepository;

    public void create(Tweet data) {
        System.out.println(data);
        Optional<TweeteroUser> tweeteroUser = userRepository.findByUsername(data.getUsername());
        System.out.println(tweeteroUser);

        if (tweeteroUser.isEmpty()) {
            System.out.println("Usuario não encontrado");
            return;
        }

        data.setAvatar(tweeteroUser.get().getAvatar());


        tweetRepository.save(data);
        
    }

    public List<Tweet> getTweets(Pageable page) {
        return tweetRepository.findAll(page).getContent();
    }
}
