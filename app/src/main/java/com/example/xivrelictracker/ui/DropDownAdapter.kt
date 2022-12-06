package com.example.xivrelictracker.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.xivrelictracker.R
import com.example.xivrelictracker.data.QuestObject

class DropDownAdapter(private val onClick: (QuestObject) -> Unit) : RecyclerView.Adapter<DropDownAdapter.ViewHolder>() {
    var quests: List<QuestObject> = listOf()

    fun updateQuestList(newQuestList: List<QuestObject>) {
        quests = newQuestList ?: listOf()
        notifyDataSetChanged()
    }

    override fun getItemCount() = this.quests.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DropDownAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.drop_down_item, parent, false)
        return ViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(this.quests[position])
    }

    class ViewHolder(itemView: View, val onClick: (QuestObject) -> Unit) : RecyclerView.ViewHolder(itemView) {
        private val questNameTV: TextView = itemView.findViewById(R.id.tv_quest_name)

        val ctx = itemView.context

        private var currentQuest: QuestObject? = null

        init {
            itemView.setOnClickListener {
                currentQuest?.let(onClick)
            }
        }

        fun bind(questObject: QuestObject) {
            questNameTV.text = questObject.name
        }
    }
}