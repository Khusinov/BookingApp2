package uz.ubtuit.bookingapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.ubtuit.bookingapp.R
import uz.ubtuit.bookingapp.databinding.ItemBinding
import uz.ubtuit.bookingapp.model.Services

class ServicesAdapter(): RecyclerView.Adapter<ServicesAdapter.ServicesHolder>() {
    private val list = mutableListOf<Services>()

    fun submitList(list: List<Services>, listOf: List<Services>, listOf1: List<Services>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    class ServicesHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = ItemBinding.bind(item)
        fun bind(services: Services) = binding.apply {
            specialistIV.setImageResource(services.imageId)
            spesialitsName.setText(services.name)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServicesHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)
        return ServicesHolder(view)
    }

    override fun onBindViewHolder(holder: ServicesHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}