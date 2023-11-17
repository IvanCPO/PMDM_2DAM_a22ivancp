package com.example.ud06_3_guessgame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.example.ud06_3_guessgame.databinding.FragmentGameBinding

class GameFragment : Fragment() {

    private var _binding: FragmentGameBinding ? = null
    private val binding get() = _binding!!
    val gameModel : GameViewModel by viewModels(ownerProducer = {this.requireActivity()})
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_game, container, false)
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        update()
        val view = binding.root

        binding.buttonNext.setOnClickListener {
            //gameModel.secretWord = "Palabra de prueba"
            if (binding.txtGuess.text.isEmpty())
                Toast.makeText(activity,"Te falta introducir un caracter",Toast.LENGTH_SHORT).show()
            else{
                var l = binding.txtGuess.text.toString()[0]
                gameModel.game(l)
                update()
                if (gameModel.win() || gameModel.lost())
                    view.findNavController().navigate(R.id.action_gameFragment_to_resultFragment2)
            }
        }

        gameModel.lives.observe(viewLifecycleOwner, Observer {
                binding.contLife.setText("Te quedan $it vidas")})
        gameModel.secretWordDisplay.observe(viewLifecycleOwner, Observer {
                binding.txtWord.setText(it)})
        return view
    }

    private fun update() {
        //binding.contLife.setText("Te quedan ${gameModel.lives.toString()} vidas")
        //binding.txtWord.setText(gameModel.secretWordDisplay.value)
        binding.txtGuess.setText("")
    }

    override fun onDestroyView(){
        super.onDestroyView()
        _binding = null
    }

}