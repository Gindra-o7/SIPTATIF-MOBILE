package com.example.siptatif.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.siptatif.R
import com.example.siptatif.Status

class StatusFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_status, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager

        val adapter = StatusAdapter()
        recyclerView.adapter = adapter

        val statusList = mutableListOf<Status>()
        statusList.add(Status("14 Januari 2024", "Sistem ADATATIF", "Ditolak"))
        statusList.add(Status("14 Januari 2024", "Sistem ADATATIF", "Diterima"))
        statusList.add(Status("14 Januari 2024", "Sistem ADATATIF", "Menunggu"))

        adapter.submitList(statusList)
    }

}