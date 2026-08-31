package com.hdulam.mediumcopy.data

import com.hdulam.mediumcopy.model.Article

object ArticleRepository {
    fun getList() = listOf<Article>(
        Article(
            name = "Juan Lopez",
            title = "Ver peliculas durante el entrenamiento es bueno",
            resume = "Ha habido un boom en los gimnasios que ponen peliculas en las salas de cardio, descubre por qué.",
            readTime = "4",
            date = "11 ene",
            isAuthorFollowed = true,
            isFeatured = false
        ),
        Article(
            name = "Jonathan Lopez",
            title = "El ajedrez deja de ser considerado un deporte",
            resume = "Según la nueva clasificación de la ONU, el ajedrez ya no es un deporte",
            readTime = "23",
            date = "22 dic",
            isAuthorFollowed = false,
            isFeatured = true
        ),
        Article(
            name = "Carlos Cardona",
            title = "Se inventan un nuevo deporte",
            resume = "¿Una combinacion de varios existentes o uno completamente nuevo? Esto es aún un debate abierto.",
            readTime = "10",
            date = "11 feb",
            isAuthorFollowed = true,
            isFeatured = true
        )
    )

}