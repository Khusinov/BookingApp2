package uz.ubtuit.bookingapp.navigationBottomFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import uz.ubtuit.bookingapp.ViewBinding.viewBinding
import uz.ubtuit.bookingapp.adapter.AllUsersAdapter
import uz.ubtuit.bookingapp.databinding.FragmentAllUsersBinding
import uz.ubtuit.bookingapp.model.AllUsers


class AllUsersFragment : Fragment() {
    private val binding: FragmentAllUsersBinding by viewBinding { FragmentAllUsersBinding.bind(it) }
    private lateinit var adapter: AllUsersAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.usersRv.adapter = adapter

        adapter.submitList(listOf(AllUsers("+998997155311", "05/06/2022", "15:00")),
        listOf(AllUsers("+998942331705", "06/06/2022", "10:00")))
    }
}
