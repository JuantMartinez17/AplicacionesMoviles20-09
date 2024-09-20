package com.example.clase20_09

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.clase20_09.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val PREFERENCES_NAME = "myprefs"
    private val KEY_NAME = "name"
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener{
            val name = binding.etName.text.toString()
            saveName(name)
        }

        binding.btnLoad.setOnClickListener {
            val name = loadName()
            binding.tvResult.text = name
        }
    }

    private fun saveName(name: String){
        val sharedPreferences = getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(KEY_NAME, name)
        editor.apply()
    }

    private fun loadName(): String? {
        val sharedPreferences = getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
        return sharedPreferences.getString(KEY_NAME, "No results found")
    }

}