package com.example.siptatif.fragment

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.siptatif.AcceptActivity
import com.example.siptatif.R
import com.example.siptatif.RejectActivity
import com.example.siptatif.Status

class StatusAdapter : ListAdapter<Status, StatusAdapter.StatusViewHolder>(StatusAdapter.StatusDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatusAdapter.StatusViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_status, parent, false)
        return StatusAdapter.StatusViewHolder(view)
    }

    override fun onBindViewHolder(holder: StatusAdapter.StatusViewHolder, position: Int) {
        val status = getItem(position)
        holder.bind(status)
    }

    class StatusViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tanggalTextView: TextView = itemView.findViewById(R.id.tanggal)
        private val judulTextView: TextView = itemView.findViewById(R.id.judul)
        private val waitTextView: TextView = itemView.findViewById(R.id.wait)

        fun bind(status: Status) {
            tanggalTextView.text = status.tanggal
            judulTextView.text = status.judul
            waitTextView.text = status.wait

            itemView.setOnClickListener {
                when (status.wait) {
                    "Ditolak" -> {
                        val intent = Intent(itemView.context, RejectActivity::class.java)
                        itemView.context.startActivity(intent)
                    }
                    "Diterima" -> {
                        val intent = Intent(itemView.context, AcceptActivity::class.java)
                        itemView.context.startActivity(intent)
                    }
                    else -> {
                    }
                }
            }

            when (status.wait) {
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

    class StatusDiffCallback : DiffUtil.ItemCallback<Status>() {
        override fun areItemsTheSame(oldItem: Status, newItem: Status): Boolean {
            return oldItem.judul == newItem.judul
        }

        override fun areContentsTheSame(oldItem: Status, newItem: Status): Boolean {
            return oldItem == newItem
        }
    }

}