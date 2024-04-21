package com.example.siptatif.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.siptatif.R
import androidx.recyclerview.widget.RecyclerView
import com.example.siptatif.Dosen

class DospemFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dospem, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        setupRecyclerView()
    }

    private fun setupView() {
        val autoCompleteTextView: AutoCompleteTextView? = view?.findViewById(R.id.auto_complete)

        if (autoCompleteTextView != null) {
            val items = listOf(
                "Urutkan berdasar abjad",
                "Urutkan berdasar keahlian",
                "Urutkan berdasar kuota"
            )
            val adapter =
                ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, items)
            autoCompleteTextView.setAdapter(adapter)
        }
    }

    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager

        val adapter = DosenAdapter()
        recyclerView.adapter = adapter

        val dosenList = mutableListOf<Dosen>()
        dosenList.add(Dosen("Fulan,S.T.,M.Kom.", "1234567", "Laki-laki", "Mobile & Data Mining", 8))
        dosenList.add(Dosen("Fulanah,S.T.,M.Kom.", "1234567", "Perempuan", "Mobile & Data Mining", 7))
        dosenList.add(Dosen("Dr.Fulan bin Fulan,M.Kom.", "1234567", "Laki-laki", "Mobile & Data Mining", 8))
        dosenList.add(Dosen("Dr.Fulan bin Fulan,M.Kom.", "1234567", "Laki-laki", "Mobile & Data Mining", 8))
        dosenList.add(Dosen("Dr.Fulan bin Fulan,M.Kom.", "1234567", "Laki-laki", "Mobile & Data Mining", 8))

        adapter.submitList(dosenList)
    }

}