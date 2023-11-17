package com.example.ud06_3_guessgame

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {

    val words = listOf("Alfalfa","Callate","Comida", "Dinero")
    var secretWord = words.random().uppercase()
    // Palabra secreta que se mostrara
    //var secretWordDisplay = ""
    var secretWordDisplay = MutableLiveData<String>()
    // Numero de vidas
//    var numVidas = 7
    var lives = MutableLiveData<Int>(7)
    // Intentos del usuario. Caracteres
    var guesses = mutableListOf<Char>()

    init {
        secretWordDisplay.value = generateWordDisplay()
    }
    fun generateWordDisplay() = secretWord.map {
            if ( guesses.contains(it))   it
            else   "_"
        }.joinToString("")

    fun game(guess : Char) {
        guesses.add(guess.uppercaseChar())
        secretWordDisplay.value = generateWordDisplay()
        if (!secretWordDisplay.value.toString().contains(guess.uppercaseChar())) lives.value=
            lives.value?.toInt()?.minus(1)

    }
    fun win () = secretWord.equals(secretWordDisplay.value)
    fun lost () = lives.value==0
    fun restart() {
        secretWord = words.random().uppercase()
        guesses.clear()
        lives.value = 7
        secretWordDisplay.value = generateWordDisplay()
    }

}