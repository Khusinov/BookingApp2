package uz.ubtuit.bookingapp.navigationBottomFragments

import android.R.attr.phoneNumber
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import uz.ubtuit.bookingapp.R
import uz.ubtuit.bookingapp.ViewBinding.viewBinding
import uz.ubtuit.bookingapp.adapter.AllUsersAdapter
import uz.ubtuit.bookingapp.databinding.FragmentAllUsersBinding
import uz.ubtuit.bookingapp.model.AllUsers


class AllUsersFragment : Fragment(R.layout.fragment_all_users) {
    private val binding: FragmentAllUsersBinding by viewBinding { FragmentAllUsersBinding.bind(it) }
    private lateinit var adapter: AllUsersAdapter
    lateinit var list: ArrayList<AllUsers>
    lateinit var list2: ArrayList<AllUsers>
    private val TAG = "AllUsersFragment"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_users, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list = ArrayList()
        list2 = ArrayList()
        val db = Firebase.firestore

        

        list.clear()

        db.collection("orders")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d(TAG, "${document.id} => ${document.data}")
                    val allUsers = AllUsers()
                    allUsers.number = document.data["phone"].toString()
                    Log.d(TAG, "onViewCreated: ${allUsers.number}")
                    list.add(allUsers)
                }
                list2 = list.distinctBy {
                    it.number
                } as ArrayList<AllUsers>
                getUsers(list2)
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents.", exception)
            }

    }

    private fun getUsers(list: ArrayList<AllUsers>) {
        val adapter = AllUsersAdapter(list)
        binding.usersRv.layoutManager = LinearLayoutManager(requireContext())
        binding.usersRv.adapter = adapter
    }
}
