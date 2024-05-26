package com.appnica.api_libre2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.appnica.api_libre2.databinding.ActivityMainBinding
import com.github.kittinunf.fuel.Fuel
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Fuel.get("https://thronesapi.com/api/v2/Characters")
            .response(){request, response, result ->

                val jsonBody = response.body().asString("application/json")
                val convertidor = Gson()

                listaMovies = convertidor.fromJson(jsonBody, Array<Datas>::class.java).toList()

                binding.txtText1.setText("Cantidad de Personajes ${listaMovies.size}")

                binding.rvMovies.layoutManager = LinearLayoutManager(this)
                binding.rvMovies.adapter = MovieAdapter(listaMovies)


            }
    }
}