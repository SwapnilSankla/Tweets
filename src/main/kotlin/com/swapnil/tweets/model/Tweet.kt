package com.swapnil.tweets.model

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.annotation.Version
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@Document("tweets")
class Tweet(val text: String) {
    @Id
    var id: String? = null
        private set

    @CreatedDate
    var createdAt: Instant? = null
        private set

    @LastModifiedDate
    var lastModifiedDate: Instant? = null
        private set

    @Version
    var version: Long? = null
        private set
}