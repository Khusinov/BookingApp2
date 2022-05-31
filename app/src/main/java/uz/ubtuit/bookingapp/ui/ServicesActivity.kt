package uz.ubtuit.bookingapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Adapter
import uz.ubtuit.bookingapp.R
import uz.ubtuit.bookingapp.databinding.ActivityLoginBinding
import uz.ubtuit.bookingapp.databinding.ActivityServicesBinding
import uz.ubtuit.bookingapp.model.Services

class ServicesActivity : AppCompatActivity() {
    lateinit var binding: ActivityServicesBinding
    private lateinit var serviceAdapter: ServicesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityServicesBinding.inflate(LayoutInflater.from(this))
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val list = ArrayList<Services>()
        val user1 = Services(R.drawable.photo1, "Shaxriyor Xusinov")
        val user2 = Services(R.drawable.photo2, "Valijon Xusinov")
        val user3 = Services(R.drawable.photo3, "Saidjon Xusinov")
        val user4 = Services(R.drawable.photo1, "Nannfdn Xusinov")

        list.clear()
        list.add(user1)
        list.add(user2)
        list.add(user3)
        list.add(user4)


        serviceAdapter = ServicesAdapter(list)
        binding.specialRv.adapter = serviceAdapter
        serviceAdapter.notifyItemInserted(list.size)




    }
}