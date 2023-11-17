package com.example.ud06_3_guessgame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.ud06_3_guessgame.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    var _binding: FragmentResultBinding? = null
    val binding get() = _binding!!
    val gameModel : GameViewModel by viewModels( ownerProducer = {this.requireActivity()})
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_result, container, false)
        _binding = FragmentResultBinding.inflate(inflater,container,false)

        binding.txtResult.setText(resultMessage())
        val view = binding.root
        binding.buttonNewGame.setOnClickListener {
            //Toast.makeText(activity,gameModel.secretWord,Toast.LENGTH_SHORT).show()
            gameModel.restart()
            view.findNavController().navigate(R.id.action_resultFragment_to_gameFragment2)
        }
        return view
    }

    private fun resultMessage(): String {
        var res = ""
        if (gameModel.win())
            res += "HAS GANADO!!"
        else
            res += "HAS PERDIDO!!"
        res += System.lineSeparator() + "La palabra secreta era: ${gameModel.secretWord}"
        return res
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }
}