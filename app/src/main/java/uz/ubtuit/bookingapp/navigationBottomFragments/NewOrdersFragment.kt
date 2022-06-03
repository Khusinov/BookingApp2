package uz.ubtuit.bookingapp.navigationBottomFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import uz.ubtuit.bookingapp.ViewBinding.viewBinding
import uz.ubtuit.bookingapp.adapter.NewOrdersAdapter
import uz.ubtuit.bookingapp.databinding.FragmentNewOrdersBinding
import uz.ubtuit.bookingapp.model.NewOrders


class NewOrdersFragment : Fragment() {
    private val binding: FragmentNewOrdersBinding by viewBinding { FragmentNewOrdersBinding.bind(it) }
    private lateinit var adapter: NewOrdersAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ordersRv.adapter = adapter

        adapter.submitList(listOf(
            NewOrders("+998997155311", "03/06/2022", "17:00")
        ),
        listOf(NewOrders("+998942331705", "04/06/2022", "16:00")))
    }
}