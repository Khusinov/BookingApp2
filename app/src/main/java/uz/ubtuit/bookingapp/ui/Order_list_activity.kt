package uz.ubtuit.bookingapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import uz.ubtuit.bookingapp.R
import uz.ubtuit.bookingapp.databinding.ActivityOrderListBinding
import uz.ubtuit.bookingapp.databinding.AllUsersItemBinding
import uz.ubtuit.bookingapp.model.Datetime
import uz.ubtuit.bookingapp.model.User

class Order_list_activity : AppCompatActivity() {

    private val TAG = "Order_list_activity"
    lateinit var list: ArrayList<Datetime>
    lateinit var binding: ActivityOrderListBinding
    var date: String = "date"
    var time: String = "time"
    var n = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderListBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        list = ArrayList()
        val db = Firebase.firestore

        date = intent.getStringExtra("date").toString()
        time = intent.getStringExtra("time").toString()

        db.collection("orders")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d(TAG, "${document.id} => ${document.data}")
                    binding.numberOfClients.text = "O"

                    val datetime = Datetime()
                    datetime.date = document.data["date"].toString()
                    datetime.time = document.data["time"].toString()
                    list.add(datetime)
                }
                sortDateTime(list)
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents.", exception)
            }

    }

    private fun sortDateTime(arrayList: ArrayList<Datetime>) {
        for (i in 1 until arrayList.size) {
            if (arrayList[i].date == date) {
                n++
            }
        }
        binding.numberOfClients.text = n.toString()
    }

}