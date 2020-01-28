package com.felipe.imc.extensions

import android.widget.EditText

fun EditText.value() = this.text.toString()
fun EditText.valueInt() = this.text.toString().toInt()
fun EditText.valueFloat() = this.text.toString().toFloat()
fun EditText.valueDouble() = this.text.toString().toDouble()