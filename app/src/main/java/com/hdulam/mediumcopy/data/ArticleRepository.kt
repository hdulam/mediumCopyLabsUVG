package com.hdulam.mediumcopy.data

import com.hdulam.mediumcopy.model.Article

object ArticleRepository {
    fun getList() = listOf<Article>(
        Article(
            name = "Juan Lopez",
            title = "Lorem ipsum",
            resume = "Lorem impsum resume",
            readTime = "23",
            date = "11 dic"
        ),
        Article(
            name = "Juan Lopez",
            title = "Lorem ipsum",
            resume = "Lorem impsum resume",
            readTime = "23",
            date = "11 dic"
        ),
        Article(
            name = "Juan Lopez",
            title = "Lorem ipsum",
            resume = "Lorem impsum resume",
            readTime = "23",
            date = "11 dic"
        )
    )

}