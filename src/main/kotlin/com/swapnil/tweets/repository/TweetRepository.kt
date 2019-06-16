package com.swapnil.tweets.repository

import com.swapnil.tweets.model.Tweet
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface TweetRepository: MongoRepository<Tweet, String>