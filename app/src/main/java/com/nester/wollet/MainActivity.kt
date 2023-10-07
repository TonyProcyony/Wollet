package com.nester.wollet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.nester.wollet.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())

        binding.bottomNavigationBar.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> replaceFragment(HomeFragment())
                R.id.categories -> replaceFragment(CategoriesFragments())
                R.id.payments -> replaceFragment(PaymentsFragment())
                R.id.savings -> replaceFragment(SavingsFragment())
                R.id.settings -> replaceFragment(SettingsFragment())

                else -> {}
            }
            true
        }

//        val exampleArray : ArrayList<ExpenseItem> = arrayListOf(
//            ExpenseItem("Grocery", "09/09/23", 3.4, null),
//            ExpenseItem("Car", "05/09/23", 10.0, "Gas"),
//            ExpenseItem("Eating Out", "12/09/23", 22.9, null),
//        )
//        val expenseAdapter = ExpenseItemAdapter(exampleArray)
//
//        val recyclerView: RecyclerView = findViewById(R.id.rv_expenses)
//        recyclerView.adapter = expenseAdapter
//        recyclerView.layoutManager = LinearLayoutManager(this)

    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransition = fragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.frame_layout, fragment)
        fragmentTransition.commit()
    }
}