package com.example.minhastarefas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.minhastarefas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        abrirListaTarefas()
    }

    private fun abrirListaTarefas(){
        val listaTarefaFragment = ListarTarefaFragment
            .newInstance({
                abrirCriarTarefa()
            }, "")

        supportFragmentManager.beginTransaction().replace(
            binding.frameLayout.id,
            listaTarefaFragment
        ).commit()
    }

    private fun abrirCriarTarefa(){
        val criarTarefaFragment = CriarTarefaFragment
            .newInstance {
                println(it)
            }

        supportFragmentManager.beginTransaction().replace(
            binding.frameLayout.id,
            criarTarefaFragment
        ).commit()
    }
}