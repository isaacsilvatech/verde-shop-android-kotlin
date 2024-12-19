package br.com.isaac.verdeshop.extension

import android.app.Activity
import android.content.Context
import android.content.Intent

inline fun <reified T : Activity> Context.startActivity(configure: Intent.() -> Unit = {}) {
    val intent = Intent(this, T::class.java)
    intent.configure()
    startActivity(intent)
}