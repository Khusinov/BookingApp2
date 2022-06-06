package uz.ubtuit.bookingapp.navigationBottomFragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import uz.ubtuit.bookingapp.R
import uz.ubtuit.bookingapp.ViewBinding.viewBinding
import uz.ubtuit.bookingapp.adapter.NewOrdersAdapter
import uz.ubtuit.bookingapp.databinding.FragmentNewOrdersBinding
import uz.ubtuit.bookingapp.model.NewOrders


class NewOrdersFragment : Fragment(R.layout.fragment_new_orders) {
    private val binding: FragmentNewOrdersBinding by viewBinding { FragmentNewOrdersBinding.bind(it) }
    private lateinit var adapter: NewOrdersAdapter
    lateinit var list: ArrayList<NewOrders>
    private val TAG = "NewOrdersFragment"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list = ArrayList()
        val db = Firebase.firestore

        db.collection("orders")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d(TAG, "${document.id} => ${document.data}")
                    val newOrders = NewOrders()
                    newOrders.date = document.data["date"].toString()
                    newOrders.time = document.data["time"].toString()
                    newOrders.number = document.data["phone"].toString()
                    newOrders.salon = document.data["salon"].toString()
                    list.add(newOrders)
                }
                getUsers(list)
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents.", exception)
            }

    }

    private fun getUsers(list: ArrayList<NewOrders>) {
        adapter = NewOrdersAdapter(list)
        binding.ordersRv.layoutManager = LinearLayoutManager(requireContext())
        binding.ordersRv.adapter = adapter
    }
}