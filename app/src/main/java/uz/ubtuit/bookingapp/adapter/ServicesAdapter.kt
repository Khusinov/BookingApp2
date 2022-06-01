package uz.ubtuit.bookingapp.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import uz.ubtuit.bookingapp.R
import uz.ubtuit.bookingapp.UI.DatePickerActivity
import uz.ubtuit.bookingapp.databinding.ItemBinding
import uz.ubtuit.bookingapp.model.Services

class ServicesAdapter(var list: List<Services>) :
    RecyclerView.Adapter<ServicesAdapter.ServicesHolder>() {

    class ServicesHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = ItemBinding.bind(item)

        fun onBind(services: Services, position: Int) {
            binding.specialistIV.setImageResource(services.imageId)
            binding.spesialitsName.text = services.name

            itemView.setOnClickListener {
                // Toast.makeText(it.context, position.toString(), Toast.LENGTH_SHORT).show()
                val intent = Intent(it.context, DatePickerActivity::class.java)
                intent.putExtra("id", "$position")
                it.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServicesHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)
        return ServicesHolder(view)
    }

    override fun onBindViewHolder(holder: ServicesHolder, position: Int) {
        holder.onBind(list[position], position)

    }

    override fun getItemCount(): Int {
        return list.size
    }

}