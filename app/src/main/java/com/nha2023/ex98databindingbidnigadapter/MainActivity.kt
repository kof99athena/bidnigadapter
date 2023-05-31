package com.nha2023.ex98databindingbidnigadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.nha2023.ex98databindingbidnigadapter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        //4. this랑 R.layout과 연결해주세요
        binding.vm = MyViewModel()


    }
}