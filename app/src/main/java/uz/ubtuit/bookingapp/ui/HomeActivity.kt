package uz.ubtuit.bookingapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import uz.ubtuit.bookingapp.R
import uz.ubtuit.bookingapp.databinding.ActivityHomeBinding
import uz.ubtuit.bookingapp.navigationBottomFragments.AllUsersFragment
import uz.ubtuit.bookingapp.navigationBottomFragments.NewOrdersFragment

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    private val allUsersFragment = AllUsersFragment()
    private val newOrdersFragment = NewOrdersFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        replaceFragment(allUsersFragment)

        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId) {
               // R.id.ic_all_user -> replaceFragment(allUsersFragment)
               // R.id.ic_new_orders -> replaceFragment(newOrdersFragment)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        if(fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
        }
    }
}