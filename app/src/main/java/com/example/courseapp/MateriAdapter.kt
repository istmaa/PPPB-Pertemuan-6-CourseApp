package com.example.courseapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.courseapp.databinding.ItemMateriBinding

class MateriAdapter(private val materiList: List<Materi>) :
    RecyclerView.Adapter<MateriAdapter.MateriViewHolder>() {

    inner class MateriViewHolder(val binding: ItemMateriBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MateriViewHolder {
        val binding = ItemMateriBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MateriViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MateriViewHolder, position: Int) {
        val item = materiList[position]
        holder.binding.tvMateriNumber.text = item.number
        holder.binding.tvMateriTitle.text = item.title
        holder.binding.tvMateriDesc.text = item.description

        holder.binding.root.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, DetailMateriActivity::class.java).apply {
                putExtra(DetailMateriActivity.EXTRA_NUMBER, item.number)
                putExtra(DetailMateriActivity.EXTRA_TITLE, item.title)
                putExtra(DetailMateriActivity.EXTRA_OVERVIEW, item.overview)
                putStringArrayListExtra(DetailMateriActivity.EXTRA_CONCEPTS, ArrayList(item.concepts))
                putExtra(DetailMateriActivity.EXTRA_PRACTICE, item.practice)
                putExtra(DetailMateriActivity.EXTRA_SUMMARY, item.summary)
                putExtra(DetailMateriActivity.EXTRA_IMAGE_RES, item.imageResId)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = materiList.size
}
