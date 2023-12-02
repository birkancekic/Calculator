package com.birkancekic.hesapmakinesi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.birkancekic.hesapmakinesi.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonEqual.setOnClickListener {
            evaluateExpression()
        }

        binding.button0.setOnClickListener {

            binding.editTextNumbers.append("0")
        }

        binding.button1.setOnClickListener {

            binding.editTextNumbers.append("1")
        }
        binding.button2.setOnClickListener {

            binding.editTextNumbers.append("2")
        }
        binding.button3.setOnClickListener {

            binding.editTextNumbers.append("3")
        }
        binding.button4.setOnClickListener {

            binding.editTextNumbers.append("4")
        }
        binding.button5.setOnClickListener {

            binding.editTextNumbers.append("5")
        }
        binding.button6.setOnClickListener {

            binding.editTextNumbers.append("6")
        }
        binding.button7.setOnClickListener {

            binding.editTextNumbers.append("7")
        }
        binding.button8.setOnClickListener {

            binding.editTextNumbers.append("8")
        }
        binding.button9.setOnClickListener {

            binding.editTextNumbers.append("9")
        }
        binding.buttonAdd.setOnClickListener {

        binding.editTextNumbers.append("+")
    }
        binding.buttonMinus.setOnClickListener {

            binding.editTextNumbers.append("-")
        }
        binding.buttonDivide.setOnClickListener {

            binding.editTextNumbers.append("/")
        }
        binding.buttonMult.setOnClickListener {

            binding.editTextNumbers.append("*")
        }
        binding.buttonAc.setOnClickListener{
            binding.editTextNumbers.text=null
        }
        binding.buttonDelete.setOnClickListener {
            val expression = binding.editTextNumbers.text.toString()
            val length: Int = expression.length - 1
            if (expression.isNotEmpty()) {
                val updatedExpression = expression.substring(0, length)
                // Güncellenmiş ifadeyi kullanmak için
                binding.editTextNumbers.setText(updatedExpression)
            }
        }
        binding.buttonComma.setOnClickListener {

            binding.editTextNumbers.append(".")
        }



    }
    private fun evaluateExpression() {
        try {
            val expression = binding.editTextNumbers.text.toString()
            if (expression.isNotEmpty()) {
                val result = ExpressionBuilder(expression).build().evaluate()
                binding.editTextNumbers.setText(result.toString())
            }
        } catch (e: Exception) {
            // Matematik ifadesi değerlendirilemiyorsa veya hata oluşursa buraya düşer
            binding.editTextNumbers.setText("Error")
        }
    }



}
