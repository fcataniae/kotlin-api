package com.franco.rest.api.components

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.franco.rest.api.entities.Review
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Component

@Component
class ReviewResolver (val mongoOperations: MongoOperations) : GraphQLQueryResolver {
    fun reviews(snackId: String): List<Review> {
        val query = Query()
        query.addCriteria(Criteria.where("snackId").`is`(snackId))
        return mongoOperations.find(query, Review::class.java)
    }
}