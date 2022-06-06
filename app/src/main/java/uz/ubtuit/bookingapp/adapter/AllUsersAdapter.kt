package uz.ubtuit.bookingapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.ubtuit.bookingapp.R
import uz.ubtuit.bookingapp.databinding.AllUsersItemBinding
import uz.ubtuit.bookingapp.model.AllUsers

class AllUsersAdapter(private var list: ArrayList<AllUsers>) :
    RecyclerView.Adapter<AllUsersAdapter.AllUsersHolder>() {

    class AllUsersHolder(private val binding: AllUsersItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(allUsers: AllUsers) {
            binding.apply {
                usersNumber.setText(allUsers.number)
                usersDate.setText(allUsers.date)
                usersTime.setText(allUsers.time)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllUsersHolder {
        val inflater = LayoutInflater.from(parent.context)
        return AllUsersHolder(AllUsersItemBinding.inflate(inflater))
    }

    override fun onBindViewHolder(holder: AllUsersHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
