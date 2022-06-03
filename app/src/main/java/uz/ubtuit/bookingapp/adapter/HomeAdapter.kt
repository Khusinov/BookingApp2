package uz.ubtuit.bookingapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.ubtuit.bookingapp.R
import uz.ubtuit.bookingapp.databinding.HomeItemBinding
import uz.ubtuit.bookingapp.model.Home

class HomeAdapter(): RecyclerView.Adapter<HomeAdapter.HomeHolder>() {

    private val list = mutableListOf<Home>()

    fun submitList(list: List<Home>, listOf: List<Home>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }



    class HomeHolder(item: View): RecyclerView.ViewHolder(item) {
        private val binding = HomeItemBinding.bind(item)

        fun onBind(home: Home, position: Int) {
            binding.apply {
                //ochirib tashama
//                number.text = home.number
//                date.text = home.date
//                time.text = home.time
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)
        return HomeHolder(view)
    }

    override fun onBindViewHolder(holder: HomeHolder, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}