package com.anushka.coroutinesdemo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.anushka.coroutinesdemo1.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private var count = 0
    private lateinit var binding : ActivityMainBinding

    private lateinit var viewModel: UserDataManager3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this,).get(UserDataManager3::class.java)
        binding.btnCount.setOnClickListener {
            binding.tvCount.text = count++.toString()
        }
        binding.btnDownloadUserData.setOnClickListener {
           // viewModel.getUserData()
//            CoroutineScope(Dispatchers.IO).launch {
//                //downloadUserData()
//                binding.tvUserMessage.text = UserDataManager().getTotalUserCount().toString()
//            }
        }

        viewModel.liveData.observe(this, Observer {
            for(str in it){
                binding.tvUserMessage.text = binding.tvUserMessage.text.toString() + str
            }
        })

        lifecycleScope.launch{
            delay(3000)
            binding.progressCircular.visibility = View.VISIBLE
            delay(3000)
            binding.progressCircular.visibility = View.GONE
        }

    }

    private suspend fun downloadUserData() {
        for (i in 1..200000) {
            withContext(Dispatchers.Main){
                binding.tvUserMessage.text = i.toString() + Thread.currentThread().name
                Log.i("MyTag", "Downloading user $i in ${Thread.currentThread().name}")
            }

        }

    }
}
