package com.example.viewmodel_livedatakotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodel_livedatakotlin.databinding.ActivityMainBinding
import com.example.viewmodel_livedatakotlin.viewModelLiveData.TestViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var viewModel: TestViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Owner(Dueño, Propietario)
        viewModel = ViewModelProvider(this).get(TestViewModel::class.java)

        viewModel.currentNumber.observe(this, Observer {
            binding.tvTextView.text = it.toString()
        })

        viewModel.currentBoolean.observe(this, Observer {
            binding.tvBooleanText.text = it.toString()
        })

        incrementText()
    }

    private fun incrementText(){
        binding.btnButton.setOnClickListener {
            //Value (El valor asignado al elemento)
            viewModel.currentNumber.value = ++viewModel.number
            viewModel.currentBoolean.value = viewModel.number % 2 == 0
        }
    }
}