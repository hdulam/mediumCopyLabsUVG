package com.hdulam.mediumcopy.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hdulam.mediumcopy.model.Article
import com.hdulam.mediumcopy.ui.theme.Gray

@Composable
fun MediumArticle(
    article : Article,
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.weight(2f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .clip(CircleShape)
                        .background(Color.Red)
                ) {
                }
                Text(
                    text = article.name,
                    color = Gray
                )
            }
            Text(
                text = article.title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = article.resume
            )
            Text(
                text = ("${article.readTime} min de lectura · ${article.date}")
            )
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .aspectRatio(1f)
                .background(Color.LightGray)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MediumArticlePreview(){
    val name = "Ana Robles"
    val title = "Por qué su primera app se siente lenta"
    val resume = "Tres decisiones de arranque que nadie revisa hasta que ya es tarde."
    val readTime = "5"
    val date = "12 dic"

    Row() {
            Column(
                modifier = Modifier.weight(2f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(20.dp)
                            .clip(CircleShape)
                            .background(Color.Red)
                    ) {
                    }
                    Text(
                        text = name,
                        color = Gray
                    )
                }
                Text(
                    text = title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = resume
                )
                Text(
                    text = ("${readTime} min de lectura · ${date}")
                )
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f)
                    .background(Color.LightGray)
            )
        }
    }