package com.percobaan.scissorrockpapergames

import android.annotation.SuppressLint
import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import com.percobaan.scissorrockpapergames.databinding.ActivityMainBinding

private val ImageButton.view: Any
    get() = Unit

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var option1: String
    private lateinit var option2: String
    private var state1: Boolean = false
    private var state2: Boolean = false
    private lateinit var selected1: View
    private lateinit var selected2: View

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.result.visibility = View.GONE

        binding.stone1.setOnClickListener {
            if (!state1) {
                state1 = true
                selected1 = it
                option1 = binding.stone1.view.toString()
                binding.stone1.background = getDrawable(R.drawable.bg_pilihan)
            } else {
                Toast.makeText(this, "Can't Select", Toast.LENGTH_SHORT).show()
            }
        }
        binding.paper1.setOnClickListener {
            if (!state1) {
                state1 = true
                selected1 = it
                option1 = binding.paper1.view.toString()
                binding.paper1.background = getDrawable(R.drawable.bg_pilihan)
            } else {
                Toast.makeText(this, "Can't Select", Toast.LENGTH_SHORT).show()
            }
        }
        binding.scissor1.setOnClickListener {
            if (!state1) {
                state1 = true
                selected1 = it
                option1 = binding.scissor1.view.toString()
                binding.scissor1.background = getDrawable(R.drawable.bg_pilihan)
            } else {
                Toast.makeText(this, "Can't Select", Toast.LENGTH_SHORT).show()
            }
        }
        binding.stone2.setOnClickListener {
            if (!state2) {
                state2 = true
                selected2 = it
                option2 = binding.stone2.view.toString()
                binding.stone2.background = getDrawable(R.drawable.bg_pilihan)
                checkOption(option1, option2)
            } else {
                Toast.makeText(this, "Can't Select", Toast.LENGTH_SHORT).show()
            }
        }
        binding.paper2.setOnClickListener {
            if (!state2) {
                state2 = true
                selected2 = it
                option2 = binding.paper2.view.toString()
                binding.paper2.background = getDrawable(R.drawable.bg_pilihan)
            } else {
                Toast.makeText(this, "Can't Select", Toast.LENGTH_SHORT).show()
            }
        }
        binding.scissor2.setOnClickListener {
            if (!state2) {
                state2 = true
                selected2 = it
                option2 = binding.scissor2.view.toString()
                binding.scissor2.background = getDrawable(R.drawable.bg_pilihan)
            } else {
                Toast.makeText(this, "Can't Select", Toast.LENGTH_SHORT).show()
            }
        }
        binding.refresh.setOnClickListener {
            resetState()
        }

    }

    private fun resetState() {
        option1 = ""
        option2 = ""
        state1 = false
        state2 = false
        selected1.background = getDrawable(R.drawable.bg_refresh)
        selected2.background = getDrawable(R.drawable.bg_refresh)
        binding.result.visibility = View.GONE
    }

    private fun checkOption(option1: String, option2: String) {
        binding.versus.visibility = View.GONE
        binding.result.visibility = View.VISIBLE
        if (option1 == option2) {
            binding.result.text = getString(R.string.equals)
        } else if (option1 == "stone" && option2 == "scissor") {
            binding.result.text = getString(R.string.player1win)
        } else if (option1 == "scissor" && option2 == "stone") {
            binding.result.text = getString(R.string.comwin)
        } else if (option1 == "paper" && option2 == "stone") {
            binding.result.text = getString(R.string.player1win)
        } else if (option1 == "stone" && option2 == "paper") {
            binding.result.text = getString(R.string.comwin)
        } else if (option1 == "scissor" && option2 == "paper") {
            binding.result.text = getString(R.string.player1win)
        } else if (option1 == "paper" && option2 == "scissor") {
            binding.result.text = getString(R.string.comwin)
        }
    }
}