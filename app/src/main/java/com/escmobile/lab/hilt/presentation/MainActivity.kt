package com.escmobile.lab.hilt.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.escmobile.lab.hilt.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListeners()
    }

    override fun onStart() {
        super.onStart()
        viewModel.getAnotherCat()
    }

    private fun setListeners() {

        viewModel.catResponse.observe(this, Observer {
            Glide.with(this)
                    .load(it.url)
                    .centerCrop()
                    .into(imageView);
        })

        showAnother.setOnClickListener {
            viewModel.getAnotherCat()
        }
    }
}