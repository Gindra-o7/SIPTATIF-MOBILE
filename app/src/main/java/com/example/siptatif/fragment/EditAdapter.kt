package com.example.siptatif.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.siptatif.Edit
import com.example.siptatif.R
import android.graphics.Color

class EditAdapter : ListAdapter<Edit, EditAdapter.EditViewHolder>(EditAdapter.EditDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EditViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_data, parent, false)
        return EditViewHolder(view)
    }

    override fun onBindViewHolder(holder: EditViewHolder, position: Int) {
        val edit = getItem(position)
        holder.bind(edit)
    }

    class EditViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tanggalTextView: TextView = itemView.findViewById(R.id.tanggal)
        private val judulTextView: TextView = itemView.findViewById(R.id.judul)
        private val waitTextView: TextView = itemView.findViewById(R.id.wait)

        fun bind(edit: Edit) {
            tanggalTextView.text = edit.tanggal
            judulTextView.text = edit.judul
            waitTextView.text = edit.wait

            when (edit.wait) {
                "Menunggu" -> {
                    waitTextView.setBackgroundColor(0xFFebc474.toInt())
                    waitTextView.setTextColor(Color.BLACK)
                }
                "Diterima" -> {
                    waitTextView.setBackgroundColor(0xFF86e49d.toInt())
                    waitTextView.setTextColor(0xFF006b21.toInt())
                }
                "Ditolak" -> {
                    waitTextView.setBackgroundColor(0xFFd893a3.toInt())
                    waitTextView.setTextColor(0xFFb30021.toInt())
                }
                else -> {
                    waitTextView.setBackgroundColor(Color.TRANSPARENT)
                    waitTextView.setTextColor(Color.BLACK)
                }
            }
        }
    }

    class EditDiffCallback : DiffUtil.ItemCallback<Edit>() {
        override fun areItemsTheSame(oldItem: Edit, newItem: Edit): Boolean {
            return oldItem.judul == newItem.judul
        }

        override fun areContentsTheSame(oldItem: Edit, newItem: Edit): Boolean {
            return oldItem == newItem
        }
    }

}