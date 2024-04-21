package com.example.siptatif.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.siptatif.R
import com.example.siptatif.Dosen

class DosenAdapter : ListAdapter<Dosen, DosenAdapter.DosenViewHolder>(DosenDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DosenViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_dosen, parent, false)
        return DosenViewHolder(view)
    }

    override fun onBindViewHolder(holder: DosenViewHolder, position: Int) {
        val dosen = getItem(position)
        holder.bind(dosen)
    }

    class DosenViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val namaDosenTextView: TextView = itemView.findViewById(R.id.nama_dosen)
        private val nipTextView: TextView = itemView.findViewById(R.id.nip)
        private val jenisKelaminTextView: TextView = itemView.findViewById(R.id.jenis_kelamin)
        private val skillTextView: TextView = itemView.findViewById(R.id.skill)
        private val jumlahTextView: TextView = itemView.findViewById(R.id.jumlah)

        fun bind(dosen: Dosen) {
            namaDosenTextView.text = dosen.nama
            nipTextView.text = dosen.nip
            jenisKelaminTextView.text = dosen.jenisKelamin
            skillTextView.text = dosen.skill
            jumlahTextView.text = dosen.jumlah.toString()
        }
    }

    class DosenDiffCallback : DiffUtil.ItemCallback<Dosen>() {
        override fun areItemsTheSame(oldItem: Dosen, newItem: Dosen): Boolean {
            return oldItem.nip == newItem.nip
        }

        override fun areContentsTheSame(oldItem: Dosen, newItem: Dosen): Boolean {
            return oldItem == newItem
        }
    }
}
