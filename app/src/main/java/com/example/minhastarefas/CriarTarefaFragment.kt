package com.example.minhastarefas

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import com.example.minhastarefas.databinding.FragmentCriarTarefaBinding
import com.example.minhastarefas.databinding.FragmentListarTarefaBinding

class CriarTarefaFragment : Fragment() {

    private lateinit var binding: FragmentCriarTarefaBinding
    private var descricaoTarefa = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCriarTarefaBinding.inflate(inflater)

        binding.editTextTarefa.doOnTextChanged { text, _, _, _ ->
            descricaoTarefa = text.toString()
        }

        binding.buttonCriarTarefa.setOnClickListener{
            criarTarefa(descricaoTarefa)
        }

        return binding.root
    }

    companion object {
        private var criarTarefa: (String) -> Unit = {}
        @JvmStatic
        fun newInstance(criarTarefa: (String) -> Unit = {}, ) =
            CriarTarefaFragment().apply {
                this@Companion.criarTarefa = criarTarefa
            }
    }
}