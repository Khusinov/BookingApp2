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
        setContentView(R.layout.activity_sucsecfull)

        val intent = Intent()
        val text = intent.getStringExtra("dateAndTime")
        Toast.makeText(this, "$text", Toast.LENGTH_SHORT).show()

        binding.tvTime.text = text

    }
}