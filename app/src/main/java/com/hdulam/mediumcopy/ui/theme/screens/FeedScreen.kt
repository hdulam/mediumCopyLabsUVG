package com.hdulam.mediumcopy.ui.theme.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hdulam.mediumcopy.data.ArticleRepository
import com.hdulam.mediumcopy.model.Article
import com.hdulam.mediumcopy.ui.theme.components.MediumArticle
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.Switch
import androidx.compose.material3.TextButton
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Preview(showSystemUi = true)
@Composable
fun FeedScreen(
    modifier: Modifier = Modifier
){
    val articles = ArticleRepository.getList()
    //usare rememberSaveable asi como vimos en clase para que aunque se rote la pantalla se pueda seguir guardando
    var searchQuery by rememberSaveable {
        mutableStateOf("")
    }
    var showShortReadsOnly by rememberSaveable {
        mutableStateOf(false)
    }

    var selectedTab by rememberSaveable {
        mutableStateOf("Para ti")
    }

    val filteredArticles = articles.filter { article ->
        val matchesSearch =
            article.title.contains(searchQuery, ignoreCase = true) ||
                    article.name.contains(searchQuery, ignoreCase = true)
        val matchesShortRead =
            !showShortReadsOnly || article.readTime.toInt() <= 5

        val matchesTab =
            if (selectedTab == "Siguiendo") {
                article.isAuthorFollowed
            } else if (selectedTab == "Destacados") {
                article.isFeatured
            } else {
                true
            }

        matchesSearch && matchesShortRead && matchesTab
    } //se guardara dependiendo si esta o no activado el solo lecturas cortas y si se relleno el buscar por titulo o autor
    val resultCountArticles = filteredArticles.size
    var applauseCount by rememberSaveable {
        mutableStateOf(0)
    }
    Column(
        modifier = modifier
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Text(
                text = "Para ti",
                modifier = Modifier.clickable {
                    selectedTab = "Para ti"
                },
                fontWeight = if (selectedTab == "Para ti") {
                    FontWeight.Bold
                } else {
                    FontWeight.Normal
                }
            )
            Text(
                text = "Siguiendo",
                modifier = Modifier.clickable {
                    selectedTab = "Siguiendo"
                },
                fontWeight = if (selectedTab == "Siguiendo") {
                    FontWeight.Bold
                } else {
                    FontWeight.Normal
                }
            )
            Text(
                text = "Destacados",
                modifier = Modifier.clickable {
                    selectedTab = "Destacados"
                },
                fontWeight = if (selectedTab == "Destacados") {
                    FontWeight.Bold
                } else {
                    FontWeight.Normal
                }
            )
        }
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { newText ->
                searchQuery = newText
            },
            label = {
                Text("Buscar por título o autor")
            }
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Switch(
                checked = showShortReadsOnly,
                onCheckedChange = { newValue ->
                    showShortReadsOnly = newValue
                }
            )

            Text("Solo lecturas cortas")
        }
        Text(
            text = if (resultCountArticles == 1) {
                "$resultCountArticles resultado"
            } else {
                "$resultCountArticles resultados"
            }
        )
        TextButton(
            onClick = {
                applauseCount++
            }
        ) {
            Text(
                text = "Aplaudir · $applauseCount"
            )
        }
        filteredArticles.forEachIndexed { index, article ->
            MediumArticle(
                article
            )
        }
    }
}