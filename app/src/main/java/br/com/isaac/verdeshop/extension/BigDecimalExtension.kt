package br.com.isaac.verdeshop.extension

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.Locale

fun BigDecimal.toCurrency(locale: Locale = Locale("pt", "br")): String {
    return NumberFormat.getCurrencyInstance(locale).format(this)
}