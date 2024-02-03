package com.group16.oauid

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.group16.oauid.data.Student
import com.group16.oauid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)
    private lateinit var navController: NavController

    private val fragmentLifecycleCallbacks = object : FragmentManager.FragmentLifecycleCallbacks() {
        override fun onFragmentResumed(fm: FragmentManager, f: Fragment) {
            super.onFragmentResumed(fm, f)

            (f as? BottomNavFragment)?.apply {
                if (f.showNavBar) {
                    binding.bottomNav.visibility = View.VISIBLE
                } else {
                    binding.bottomNav.visibility = View.GONE
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentNavHost) as NavHostFragment
        navController = navHostFragment.navController

        NavigationUI.setupWithNavController(binding.bottomNav, navController)

        (this as FragmentActivity).supportFragmentManager.registerFragmentLifecycleCallbacks(
            fragmentLifecycleCallbacks,
            true
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        (this as FragmentActivity).supportFragmentManager.unregisterFragmentLifecycleCallbacks(
            fragmentLifecycleCallbacks
        )
    }

    companion object {

        lateinit var loggedIn: Student

        val studentDatabase = arrayListOf(
            Student(
                name = "Oluwafemi Ojuri",
                matricNum = "CSC/2018/111",
                sex = "Male",
                level = 400,
                password = "qwerty",
                faculty = "Technology",
                department = "Computer Science & Engineering",
                image = R.drawable.femi,
                numberIdGenerated = 0
            ),
            Student(
                name = "Blessing Ese",
                matricNum = "PHL/2018/101",
                sex = "Female",
                level = 300,
                password = "blessing",
                faculty = "Arts",
                department = "Philosophy",
                image = R.drawable.oau,
                numberIdGenerated = 0
            ),
            Student(
                name = "David Lartey",
                matricNum = "MTH/2018/011",
                sex = "Male",
                level = 200,
                password = "lartey",
                faculty = "Technology",
                department = "Computer Science & Engineering",
                image = R.drawable.lart,
                numberIdGenerated = 0
            )
        )
    }

}