package com.swapnil.tweets.controller

import com.swapnil.tweets.model.Tweet
import com.swapnil.tweets.repository.TweetRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/tweets")
class TweetController(@Autowired val repository: TweetRepository) {
    @GetMapping("")
    fun get() = repository.findAll()

    @PostMapping("")
    fun post(@RequestBody tweet: Tweet) = repository.save(tweet)
}