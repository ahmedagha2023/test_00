package com.example.myfirebase_1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        save.setOnClickListener {
            val name = PersonName.text.toString()
            val number = PersonNumber.text.toString()
            val address = PersonAddress.text.toString()


            val person = hashMapOf(
                "name" to name,
                "number" to number,
                "address" to address
            )

            db.collection("Persons")
                .add(person)
                .addOnSuccessListener { documentReference ->
                    Toast.makeText(applicationContext,"${documentReference.id}",Toast.LENGTH_SHORT).show()

                }
                .addOnFailureListener { e ->
                    Toast.makeText(applicationContext,"$e",Toast.LENGTH_SHORT).show()


                }


        }

    }
}