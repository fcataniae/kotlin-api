package com.franco.rest.api.components

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.franco.rest.api.entities.Review
import com.franco.rest.api.repositories.ReviewRepository
import org.springframework.stereotype.Component


@Component
class ReviewMutationResolver(private val reviewRepository: ReviewRepository): GraphQLMutationResolver {
    fun newReview(snackId: String, rating: Int, text:String): Review {
        val review = Review(snackId, rating, text)
        reviewRepository.save(review)
        return review
    }
}