package com.example.ud05_1_pizza

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.chip.ChipGroup
import com.google.android.material.floatingactionbutton.FloatingActionButton

class OrderFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_order, container, false)

        val toolbar = view.findViewById<MaterialToolbar>(R.id.toolbar)

        (activity as AppCompatActivity).setSupportActionBar(toolbar)

        val radioGroup = view.findViewById<RadioGroup>(R.id.group_pizza_type)
        val sendPizza = view.findViewById<FloatingActionButton>(R.id.fab)
        val takeOptionals = view.findViewById<ChipGroup>(R.id.chip_group)
        sendPizza.setOnClickListener {
            val idr =radioGroup.checkedRadioButtonId
            val options = takeOptionals.checkedChipIds
            var msg = "";
            msg = when (idr){
                (-1) -> "Debes seleccionar una pizza"
                R.id.radio_margarita -> "La pizza es una Margarita"
                R.id.radio_alemana -> "La pizza es una Alemana"
                else -> {"Esta pizza no esta entre las opciones aun"}
            }
            if (!options.isEmpty()){
                msg+=" acompañado de "
                var index = 0
                while (index < options.size){
                    msg += when (options.get(index)){
                        R.id.chip_chorizo -> "chorizo"
                        R.id.chip_huevo -> "huevos"
                        R.id.chip_queso -> "queso"
                        R.id.chip_tomate_cherry -> "tomates-cherrys"
                        else-> {""}
                    }
                    index++
                    if ((options.size-index)>1)
                        msg+=", "
                    if ((options.size-index)==1)
                        msg+=" y "
                }

            }
            Toast.makeText(activity,msg,Toast.LENGTH_SHORT).show()
            radioGroup.clearCheck()
            takeOptionals.clearCheck()
        }


        return view
    }
}