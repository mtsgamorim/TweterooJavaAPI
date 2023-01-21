package com.tweteroo.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.api.model.TweeteroUser;

public interface UserRepository extends JpaRepository<TweeteroUser, Long> {
    public Optional<TweeteroUser> findByUsername(String username);
}
