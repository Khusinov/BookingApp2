package uz.ubtuit.bookingapp.ui


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

import uz.ubtuit.bookingapp.databinding.ActivityDatePickerBinding
import uz.ubtuit.bookingapp.model.Datetime
import uz.ubtuit.bookingapp.utills.MySharedPreferences
import java.util.*
import kotlin.collections.ArrayList

class DatePickerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDatePickerBinding
    lateinit var firebaseFirestore: FirebaseFirestore
    private val TAG = "DatePickerActivity"
    lateinit var list: ArrayList<Datetime>
    var date: String = "null"
    var booked = false
    var salon :String = "Rayxon"
    lateinit var phoneNumber1: String
    var time1: String = "null"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDatePickerBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        MySharedPreferences.init(this)
        val id = intent.extras?.get("id")
        Log.d(TAG, "onCreateeeeee: $id")

        when (id) {
            1 -> salon = "Rayxon"
            2 -> salon = "Dilnoza"
            3 -> salon = "Anaxon"
            4 -> salon = "Fazilat"
        }


        list = ArrayList()


        val picker = binding.datePicker
        val today = Calendar.getInstance()

        picker.init(
            today.get(Calendar.YEAR), today.get(Calendar.MONTH),
            today.get(Calendar.DAY_OF_MONTH)
        ) { view, year, month, day ->
            val month = month + 1
            var dat = "$day/$month/$year"
            date = dat
        }

        var phoneNumber = MySharedPreferences.user
        phoneNumber1 = phoneNumber.toString()
        Toast.makeText(this, "$phoneNumber", Toast.LENGTH_SHORT).show()

        binding.timeTv1.setOnClickListener {
            var time = "08:00"
            time1 = time
            Toast.makeText(this, "Siz 08:00 ni tanladingiz!", Toast.LENGTH_SHORT).show()
        }
        binding.timeTv2.setOnClickListener {
            var time = "09:00"
            time1 = time
            Toast.makeText(this, "Siz 09:00 ni tanladingiz!", Toast.LENGTH_SHORT).show()

        }
        binding.timeTv3.setOnClickListener {
            var time = "10:00"
            time1 = time
            Toast.makeText(this, "Siz 10:00 ni tanladingiz!", Toast.LENGTH_SHORT).show()

        }
        binding.timeTv4.setOnClickListener {
            var time = "11:00"
            time1 = time
            Toast.makeText(this, "Siz 11:00 ni tanladingiz!", Toast.LENGTH_SHORT).show()

        }
        binding.timeTv5.setOnClickListener {
            var time = "12:00"
            time1 = time
            Toast.makeText(this, "Siz 12:00 ni tanladingiz!", Toast.LENGTH_SHORT).show()

        }
        binding.timeTv6.setOnClickListener {
            var time = "15:00"
            time1 = time
            Toast.makeText(this, "Siz 15:00 ni tanladingiz!", Toast.LENGTH_SHORT).show()

        }
        binding.timeTv7.setOnClickListener {
            var time = "16:00"
            time1 = time
            Toast.makeText(this, "Siz 16:00 ni tanladingiz!", Toast.LENGTH_SHORT).show()

        }
        binding.timeTv8.setOnClickListener {
            var time = "17:00"
            time1 = time
            Toast.makeText(this, "Siz 17:00 ni tanladingiz!", Toast.LENGTH_SHORT).show()
        }

        binding.bookingBtn.setOnClickListener {
            if (time1 == "null" || date == "null") {
                Toast.makeText(this, "Kun va vaqtni tanlashingiz kerak!", Toast.LENGTH_SHORT).show()
            } else {
                ButtonClicked(time1)
            }

        }

    }


    private fun ButtonClicked(time: String) {
        val db = Firebase.firestore

        val orders = hashMapOf(
            "date" to date,
            "name" to "Username",
            "phone" to phoneNumber1,
            "time" to time,
            "salon" to salon
        )

// Get all data
        list.clear()

        booked = false

        db.collection("orders")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d(
                        "orders",
                        "${document.id} => ${document.data["date"]} => ${document.data["time"]}"
                    )
                    val datetime = Datetime()
                    datetime.date = document.data["date"].toString()
                    datetime.time = document.data["time"].toString()
                    list.add(datetime)

                }

                for (i in list) {
                    if (date == i.date && time == i.time) {
                        booked = true
                        break
                    }
                }

                if (!booked) {
                    // Add a new document with a generated ID

                    if (time1 == "null" || date == "null") {
                        Toast.makeText(
                            this,
                            "Kun va vaqtni tanlashingiz kerak!",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {

                        db.collection("orders")
                            .add(orders)
                            .addOnSuccessListener { documentReference ->
                                Log.d(TAG, "DocumentSnapshot ID: ${documentReference.id}")


                                val intent = Intent(this, SucsecfullActivity::class.java)
                                intent.putExtra("date", date)
                                intent.putExtra("time", time)
                                startActivity(intent)

                            }
                            .addOnFailureListener { e ->
                                Log.w(TAG, "Error adding document", e)
                                Toast.makeText(
                                    this,
                                    "Internet bilan muammo bor.",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                            }
                    }
                } else {
                    Toast.makeText(
                        this,
                        "$time allaqachon band qilingan. Iltimos boshqa vaqtni tanlang!",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents.", exception)
            }
    }
}