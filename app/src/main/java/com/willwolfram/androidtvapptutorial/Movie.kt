package com.willwolfram.androidtvapptutorial

class Movie(id: Long, title: String, studio: String) {

    val id = id
    val title = title
    val studio = studio

    private val Tag: String = "Movie"
    val serialVersionUID = 727566175075960653L

    override fun toString(): String {
        return "Movie {" +
                " 'id': $id," +
                " 'title': '$title'," +
                " 'studio': '$studio' }"
    }
}