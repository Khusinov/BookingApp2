package uz.ubtuit.bookingapp.UI

import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import uz.ubtuit.bookingapp.R
import uz.ubtuit.bookingapp.databinding.ActivityDatePickerBinding
import uz.ubtuit.bookingapp.utills.MySharedPreferences
import java.util.*

class DatePickerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDatePickerBinding

    //    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_picker)

//        val picker = binding.datePicker
//        val today = Calendar.getInstance()
//
//        picker.init(
//            today.get(Calendar.YEAR), today.get(Calendar.MONTH),
//            today.get(Calendar.DAY_OF_MONTH)
//        ) { view, year, month, day ->
//            val month = month + 1
//            val toast = "You have selected: $day/$month/$year"
//            Toast.makeText(this, toast, Toast.LENGTH_SHORT).show()
//        }

        var phoneNumber = MySharedPreferences.user
        Toast.makeText(this, "$phoneNumber", Toast.LENGTH_SHORT).show()

    }
}