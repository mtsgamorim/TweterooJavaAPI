package com.tweteroo.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.api.model.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
    public List<Tweet> findAllByUsername(String username);
}
