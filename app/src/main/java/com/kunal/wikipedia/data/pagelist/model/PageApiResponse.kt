package com.kunal.wikipedia.data.pagelist.model

data class PageApiResponse(val query: Query)

data class Query(
    val pages: List<Page>
)

data class Page(
    val index: Int,
    val ns: Int,
    val pageid: Int,
    val terms: Terms,
    val thumbnail: Thumbnail,
    val title: String
)

data class Thumbnail(
    val height: Int,
    val source: String,
    val width: Int
)

data class Terms(
    val description: List<String>
)