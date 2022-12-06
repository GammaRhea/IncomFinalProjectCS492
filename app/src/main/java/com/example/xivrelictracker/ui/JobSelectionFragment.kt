package com.example.xivrelictracker.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.xivrelictracker.R
import com.example.xivrelictracker.data.JobObject
import android.media.MediaPlayer
import androidx.navigation.fragment.findNavController

class JobSelectionFragment : Fragment(R.layout.job_selection) {
    //private val viewModel:
    private lateinit var jobAdapter: JobAdapter
    private lateinit var jobListRV: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        jobListRV = view.findViewById(R.id.rv_job_selection)

        jobAdapter = JobAdapter(::onJobItemClick)

        jobListRV.layoutManager = LinearLayoutManager(requireContext())
        jobListRV.setHasFixedSize(true)
        jobListRV.adapter = jobAdapter

        //var testList: List<JobObject> = List<JobObject>(JobObject(name = "Test", jobID = "test"))
        val testList = listOf<JobObject>(JobObject(name = "Warrior", jobID = "war", 0),
                                         JobObject(name = "Paladin", jobID = "pld", 1),
                                         JobObject(name = "Monk", jobID = "mnk", 2))

        jobAdapter.updateJobList(testList)
    }

    private fun onJobItemClick(jobObject: JobObject) {
        Log.d("JobSelectionFragment", jobObject.name)
        val directions = JobSelectionFragmentDirections.navigateToZodiacWeapon(jobObject)
        findNavController().navigate(directions)
    }
}