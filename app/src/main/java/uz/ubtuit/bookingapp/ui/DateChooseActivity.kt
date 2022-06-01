package uz.ubtuit.bookingapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import uz.ubtuit.bookingapp.R
import uz.ubtuit.bookingapp.databinding.ActivityDateChooseBinding
import uz.ubtuit.bookingapp.databinding.ActivityServicesBinding

class DateChooseActivity : AppCompatActivity() {
    lateinit var binding: ActivityDateChooseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDateChooseBinding.inflate(LayoutInflater.from(this))
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var intent = Intent()
        val positionId = intent.getStringExtra("id")
        Toast.makeText(this, "$positionId", Toast.LENGTH_SHORT).show()

        binding.test.text = positionId.toString()


    }
}