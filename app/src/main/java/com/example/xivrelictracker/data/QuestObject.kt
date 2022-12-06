package com.example.xivrelictracker.data

import com.squareup.moshi.FromJson
import java.io.Serializable

data class QuestObject(
    val name: String,
    //val toDos: List<QuToDo>
    val firstToDo: String
) : Serializable

data class QuToDo(val text: String, var completion: Boolean) : Serializable

//Data classes to represent structure
data class XIVApiListJson(
    val Name: String,
    val TextData: XIVAPIListText
)

data class XIVAPIListText(
    val ToDo: List<XIVApiListToDos>
)

data class XIVApiListToDos(
    val Text: String
)

class XIVApiJsonAdapter {
    @FromJson
    fun questObjectFromJson(list: XIVApiListJson) = QuestObject(
        name = list.Name,
        firstToDo = list.TextData.ToDo[0].Text
    )
}
