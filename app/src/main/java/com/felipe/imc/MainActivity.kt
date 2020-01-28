package com.felipe.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.felipe.imc.extensions.format
import com.felipe.imc.extensions.valueDouble
import com.felipe.imc.watchers.DecimalTextWatcher
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etPeso.addTextChangedListener(DecimalTextWatcher(etPeso, 3))
        etAltura.addTextChangedListener(DecimalTextWatcher(etAltura,2))

        btCalcular.setOnClickListener {
            calcular()
        }


    }

    private fun calcular() {
        val peso = etPeso.valueDouble()
        val altura = etAltura.valueDouble() * etAltura.valueDouble()
        val imc = peso / altura

        when(imc){
            in 0.0.. 18.5 -> configuraIMC(imc, R.drawable.masc_abaixo, R.string.magreza)
            in 18.6.. 24.9 -> configuraIMC(imc, R.drawable.masc_ideal, R.string.ideal)
            in 25.0.. 29.9 -> configuraIMC(imc, R.drawable.masc_sobre, R.string.sobre_peso)
            in 30.0.. 34.9 -> configuraIMC(imc, R.drawable.masc_obeso, R.string.obesidade_grau_I)
            in 35.0.. 39.9 -> configuraIMC(imc, R.drawable.masc_extremo_obeso, R.string.obesidade_grau_II)
            else -> configuraIMC(imc, R.drawable.masc_extremo_obeso, R.string.obesidade_grau_III)
        }

    }

    private fun configuraIMC(imc: Double, drawableId: Int, stringId:Int) {
        tvIMC.text = getString(R.string.seu_imc, imc.format(2))

        imgIMCStatus.setImageDrawable(
            ContextCompat.getDrawable(this, drawableId)
        )

        tvIMCStatus.text = getString(stringId)
    }
}
