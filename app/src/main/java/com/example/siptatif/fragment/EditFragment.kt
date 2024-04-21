package com.example.siptatif.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.siptatif.R
import com.example.siptatif.Edit
import com.example.siptatif.FormActivity

class EditFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_edit, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        view.findViewById<View>(R.id.btn_form).setOnClickListener{
            onFormClicked()
        }
    }

    private fun onFormClicked(){
        val intent = Intent(requireActivity(), FormActivity::class.java)
        startActivity(intent)
    }

    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager

        val adapter = EditAdapter()
        recyclerView.adapter = adapter

        val editList = mutableListOf<Edit>()
        editList.add(Edit("14 Januari 2024", "Sistem ADATATIF", "Ditolak"))
        editList.add(Edit("14 Januari 2024", "Sistem ADATATIF", "Diterima"))
        editList.add(Edit("14 Januari 2024", "Sistem ADATATIF", "Menunggu"))

        adapter.submitList(editList)
    }

}