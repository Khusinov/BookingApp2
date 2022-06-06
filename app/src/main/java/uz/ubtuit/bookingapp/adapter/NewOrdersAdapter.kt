package uz.ubtuit.bookingapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.ubtuit.bookingapp.R
import uz.ubtuit.bookingapp.databinding.NewOrdersItemBinding
import uz.ubtuit.bookingapp.model.NewOrders

class NewOrdersAdapter(private var list: ArrayList<NewOrders>): RecyclerView.Adapter<NewOrdersAdapter.NewOrdersHolder>() {
//    private val list = mutableListOf<NewOrders>()
//
//    fun submitList(list: List<NewOrders>, listOf: List<NewOrders>) {
//        this.list.clear()
//        this.list.addAll(list)
//        notifyDataSetChanged()
//    }

    inner class NewOrdersHolder(private val binding: NewOrdersItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(newOrders: NewOrders) {
            binding.apply {
                ordersNumber.text = newOrders.number
                ordersDate.text = newOrders.date
                ordersTime.text = newOrders.time
                salon.text = newOrders.salon
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewOrdersHolder {
        val inflater = LayoutInflater.from(parent.context)
        return NewOrdersHolder(NewOrdersItemBinding.inflate(inflater))
    }

    override fun onBindViewHolder(holder: NewOrdersHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}