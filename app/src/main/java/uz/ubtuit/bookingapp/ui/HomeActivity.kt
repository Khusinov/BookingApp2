package uz.ubtuit.bookingapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import uz.ubtuit.bookingapp.R
import uz.ubtuit.bookingapp.databinding.ActivityHomeBinding
import uz.ubtuit.bookingapp.navigationBottomFragments.*

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    private val allUsersFragment = AllUsersFragment()
    private val newOrdersFragment = NewOrdersFragment()
    private val TAG = "HomeActivity"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        replaceFragment(newOrdersFragment)

        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.all_user -> replaceFragment(allUsersFragment)
                R.id.new_orders -> replaceFragment(newOrdersFragment)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        Log.d(TAG, "replaceFragment: Called............")
//        val transaction = supportFragmentManager.beginTransaction()
//        transaction.replace(R.id.fragment_container, fragment)
//        transaction.commit()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            commit()
        }
    }
}