package com.movilesi.nivelacion_u4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.movilesi.nivelacion_u4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = Firebase.database
        val myRef = database.reference

        myRef.child("cancion").child("1").setValue(Songs("Two of Us", "The Beatles", 1970, "Rock", "Let it be", "3:35", "https://music.apple.com/us/album/let-it-be/1441164495?l=es",1))
        myRef.child("cancion").child("2").setValue(Songs("Dig a Pony", "The Beatles", 1970, "Rock", "Let it be", "3:51", "https://music.apple.com/us/album/let-it-be/1441164495?l=es",2))
        myRef.child("cancion").child("3").setValue(Songs("Across The Universe","The Beatles",1970,"Rock","Let it be","3:45","https://music.apple.com/us/album/let-it-be/1441164495?l=es",3))
        myRef.child("cancion").child("4").setValue(Songs("I Me Mine", "The Beatles", 1970, "Rock", "Let it be", "2:25", "https://music.apple.com/us/album/let-it-be/1441164495?l=es",4))
        myRef.child("cancion").child("5").setValue(Songs("Dig It", "The Beatles", 1970, "Rock", "Let it be", "0:50", "https://music.apple.com/us/album/let-it-be/1441164495?l=es", 5))


        myRef.child("cancion").child("1").get().addOnSuccessListener { response ->
            //TODO value
            //binding.tvShow.setText(myRef.setValue())
            Log.d("firebaseResponse", response.value.toString())
        }.addOnFailureListener {
            Log.e("firebaseResponse", "Error getting data", it)
        }


    }
}