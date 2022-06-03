package uz.ubtuit.bookingapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.ubtuit.bookingapp.adapter.HomeAdapter
import uz.ubtuit.bookingapp.databinding.ActivityHomeBinding
import uz.ubtuit.bookingapp.model.Home

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    private val adapter = HomeAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.usersRv.adapter = adapter
        adapter.submitList(listOf(Home("+998997155311", "03/06/2022", "17:00")),
        listOf(Home("145465654", "15151", "15:00")))
    }
}