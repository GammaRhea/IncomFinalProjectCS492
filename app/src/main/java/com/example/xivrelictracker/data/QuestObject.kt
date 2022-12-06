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
    val name: String,
    val textData: XIVAPIListText
)

data class XIVAPIListText(
    val toDo: XIVApiListToDos
)

data class XIVApiListToDos(
    val questText: String
)

class XIVApiJsonAdapter {
    @FromJson
    fun questObjectFromJson(list: XIVApiListJson) = QuestObject(
        name = list.name,
        firstToDo = list.textData.toDo.questText
    )
}
