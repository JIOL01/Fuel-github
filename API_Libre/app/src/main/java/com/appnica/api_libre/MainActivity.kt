package com.appnica.api_libre

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.appnica.api_libre.databinding.ActivityMainBinding
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

        Fuel.get("https://api.gameofthronesquotes.xyz/v1/houses")
            .response(){request, response, result ->

                val jsonBody = response.body().asString("application/json")
                val convertidor = Gson()

                listaHouse = convertidor.fromJson(jsonBody, Array<Houses>::class.java).toList()

                binding.txtText1.setText("Cantidad de Casas ${listaHouse.size}")

                binding.rvHouse.layoutManager = LinearLayoutManager(this)
                binding.rvHouse.adapter = HouseAdapter(listaHouse)


            }
    }
}