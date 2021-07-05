package com.example.linearlayout

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import com.example.linearlayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName = MyData("Kapil Joshi")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myData = myName

        setAddNickName()
    }

    private fun setAddNickName(){
        binding.doneButton.setOnClickListener {
            binding.apply {
                myData?.nickName = nickNameEditText.text.toString()
                nickNameEditText.isVisible = false
                doneButton.isVisible = false
                displayNickNameText.isVisible = true
                invalidateAll()
            }

            //Hide Keyboard
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(it.windowToken, 0)
        }

    }
}