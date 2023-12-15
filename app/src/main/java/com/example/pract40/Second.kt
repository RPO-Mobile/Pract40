package com.example.pract40

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pract40.databinding.SecondActBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class Second : AppCompatActivity() {
    private lateinit var secondAct : SecondActBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        secondAct = SecondActBinding.inflate(layoutInflater)
        setContentView(secondAct.root)

        secondAct.btnCancel.setOnClickListener{
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        unpackIntent()
    }

    fun unpackIntent(){
        val message = intent.getSerializableExtra("Message") as Message
        secondAct.etText.text = message.text
        secondAct.tvId.text = message.id.toString()

        val date = Date(message.time)
        val sdf = SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault())
        val formattedDate = sdf.format(date)
        secondAct.tvTime.text = formattedDate
    }
}