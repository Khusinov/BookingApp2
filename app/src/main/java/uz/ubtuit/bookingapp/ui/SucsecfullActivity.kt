package uz.ubtuit.bookingapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import uz.ubtuit.bookingapp.R
import uz.ubtuit.bookingapp.databinding.ActivitySucsecfullBinding

class SucsecfullActivity : AppCompatActivity() {
    lateinit var binding: ActivitySucsecfullBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySucsecfullBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)


        val date = intent.getStringExtra("date")
        val time = intent.getStringExtra("time")
        Toast.makeText(this, "$date", Toast.LENGTH_SHORT).show()



        binding.tvTime1.text = "$date Vaqti: $time"


    }
}