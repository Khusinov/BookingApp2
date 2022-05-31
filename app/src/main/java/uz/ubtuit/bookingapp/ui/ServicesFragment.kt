package uz.ubtuit.bookingapp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import uz.ubtuit.bookingapp.R
import uz.ubtuit.bookingapp.ViewBinding.viewBinding
import uz.ubtuit.bookingapp.databinding.FragmentServicesBinding
import uz.ubtuit.bookingapp.model.Services

class ServicesFragment: Fragment(R.layout.fragment_services) {
    private val binding: FragmentServicesBinding by viewBinding {FragmentServicesBinding.bind(it)}
    private lateinit var adapter: ServicesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.spesialistsRv.adapter = adapter

        adapter.submitList(listOf(Services(R.drawable.photo1, "Shaxriyor")),
        listOf(Services(R.drawable.photo2, "Madina")),
        listOf(Services(R.drawable.photo3, "Xosiyat")))
    }
}

