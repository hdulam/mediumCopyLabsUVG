package com.hdulam.mediumcopy.model

data class Article(
    val name: String,
    val resume: String,
    val date: String,
    val readTime: String,
    val title: String,
    val isAuthorFollowed: Boolean,
    val isFeatured: Boolean
)
