package com.example.minhastarefas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.minhastarefas.databinding.ActivityMainBinding
import com.example.minhastarefas.databinding.FragmentCriarTarefaBinding
import com.example.minhastarefas.databinding.FragmentListarTarefaBinding

class ListarTarefaFragment : Fragment() {

    private lateinit var binding: FragmentListarTarefaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListarTarefaBinding.inflate(inflater)

        binding.botaoCriarTarefa.setOnClickListener{
            novaTarefa.invoke()
        }

        return binding.root
    }

    companion object {
        private var novaTarefa: () -> Unit = {}

        @JvmStatic
        fun newInstance(novaTarefa: () -> Unit = {}, param2: String) =
            ListarTarefaFragment().apply {
                this@Companion.novaTarefa = novaTarefa
            }
    }
}