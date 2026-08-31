package com.hdulam.mediumcopy.ui.theme.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hdulam.mediumcopy.data.ArticleRepository
import com.hdulam.mediumcopy.model.Article
import com.hdulam.mediumcopy.ui.theme.components.MediumArticle

@Preview(showSystemUi = true)
@Composable
fun FeedScreen(
    modifier: Modifier = Modifier
){
    val articles = ArticleRepository.getList()
    Column(
        modifier = modifier
    ) {
        articles.forEachIndexed { index, article ->
            MediumArticle(
                article
            )
        }
    }
}