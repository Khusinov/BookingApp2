package uz.ubtuit.bookingapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.ubtuit.bookingapp.R
import uz.ubtuit.bookingapp.databinding.NewOrdersItemBinding
import uz.ubtuit.bookingapp.model.NewOrders

class NewOrdersAdapter(): RecyclerView.Adapter<NewOrdersAdapter.NewOrdersHolder>() {
    private val list = mutableListOf<NewOrders>()

    fun submitList(list: List<NewOrders>, listOf: List<NewOrders>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    class NewOrdersHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = NewOrdersItemBinding.bind(item)

        fun onBind(newOrders: NewOrders) {
            binding.apply {
                ordersNumber.setText(newOrders.number)
                ordersDate.setText(newOrders.date)
                ordersTime.setText(newOrders.time)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewOrdersHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)
        return NewOrdersHolder(view)
    }

    override fun onBindViewHolder(holder: NewOrdersHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}