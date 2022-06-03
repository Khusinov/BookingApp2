package uz.ubtuit.bookingapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.ubtuit.bookingapp.R
import uz.ubtuit.bookingapp.databinding.AllUsersItemBinding
import uz.ubtuit.bookingapp.model.AllUsers

class AllUsersAdapter(): RecyclerView.Adapter<AllUsersAdapter.AllUsersHolder>() {
    private val list = mutableListOf<AllUsers>()

    fun submitList(list: List<AllUsers>, listOf: List<AllUsers>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    class AllUsersHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = AllUsersItemBinding.bind(item)

        fun onBind(allUsers: AllUsers) {
            binding.apply {
                usersNumber.setText(allUsers.number)
                usersDate.setText(allUsers.date)
                usersTime.setText(allUsers.time)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllUsersHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)
        return AllUsersHolder(view)
    }

    override fun onBindViewHolder(holder: AllUsersHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
