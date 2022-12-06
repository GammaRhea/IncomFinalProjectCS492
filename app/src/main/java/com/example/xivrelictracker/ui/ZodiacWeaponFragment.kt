package com.example.xivrelictracker.ui

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.xivrelictracker.R
import com.example.xivrelictracker.data.QuestObject
import androidx.fragment.app.viewModels

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

const val XIVAPI_APPID = "55b474c787a9403e83c162b32ea5324c6ac98ca2d44146c98ca11ce14c5c3bbb"

class ZodiacWeaponFragment : Fragment(R.layout.zodiac_weapon) {
    private val viewModel: ZodiacWeaponViewModel by viewModels()

    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var dropDownAdapter: DropDownAdapter

    private lateinit var dropDownListRV: RecyclerView
    private lateinit var loadingErrorTV: TextView

    private val args: ZodiacWeaponFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mediaPlayer = MediaPlayer.create(activity, R.raw.ffxiv_confirm)
        mediaPlayer.start()

        dropDownListRV = view.findViewById(R.id.rv_parent_items)
        loadingErrorTV = view.findViewById(R.id.tv_loading_error)

        dropDownAdapter = DropDownAdapter(::onDropDownItemClick)

        dropDownListRV.layoutManager = LinearLayoutManager(requireContext())
        dropDownListRV.setHasFixedSize(true)
        dropDownListRV.adapter = dropDownAdapter

        viewModel.questList.observe(viewLifecycleOwner) { quest ->
            if (quest != null) {
                val questList = listOf<QuestObject>(quest)
                dropDownAdapter.updateQuestList(questList)
                dropDownListRV.visibility = View.VISIBLE
                dropDownListRV.scrollToPosition(0)
            }
        }

        viewModel.error.observe(viewLifecycleOwner) { error ->
            if (error != null) {
                loadingErrorTV.text = getString(R.string.loading_error, error.message)
                loadingErrorTV.visibility = View.VISIBLE
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mediaPlayer.release()
    }

    override fun onResume() {
        super.onResume()
        val questId = 66655 + args.job.relicOffset

        viewModel.loadQuestList(questId.toString(), "en", "Name,TextData.ToDo", XIVAPI_APPID)
    }

    private fun onDropDownItemClick(questObject: QuestObject) {
        Log.d("ZodiacWeaponFragment", questObject.name)

    }
}