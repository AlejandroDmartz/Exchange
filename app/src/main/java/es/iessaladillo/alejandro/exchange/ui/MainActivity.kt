package es.iessaladillo.alejandro.exchange.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import es.iessaladillo.alejandro.exchange.R
import es.iessaladillo.alejandro.exchange.databinding.ActivityMainBinding
import es.iessaladillo.alejandro.exchange.utils.*
import es.iessaladillo.alejandro.exchange.extensions.hideKeyboard
import es.iessaladillo.alejandro.exchange.extensions.snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var b: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)
        setupViews()
    }

    private fun setupViews() {
        b.rbFrom.setOnCheckedChangeListener { _, checkedId -> changeFrom(checkedId) }
        b.rbTo.setOnCheckedChangeListener { _, checkedId -> changeTo(checkedId) }
        b.btnExchange.setOnClickListener { currencyConverter() }
    }

    private fun currencyConverter() {
        val from = b.rbFrom.checkedRadioButtonId
        val to = b.rbTo.checkedRadioButtonId
        var result = 0.0
        val dollar = "$"
        val euro = "€"
        val pound = "₤"
        val yen = "¥"
        val won = "₩"
        var fromCurrency = ""
        var toCurrency = ""
        val value = b.txtAmount.text.toString().toDouble()

        hideKeyboard()

        when(from) {
            b.rbFromDollar.id -> {
                fromCurrency = dollar
                when(to) {
                    b.rbToDollar.id -> result = value
                    b.rbToEuro.id -> result = value * DOLLAR_EURO
                    b.rbToPound.id -> result = value * DOLLAR_POUND
                    b.rbToYen.id -> result = value * DOLLAR_YEN
                    b.rbToWon.id -> result = value * DOLLAR_WON
                }
            }
            b.rbFromEuro.id -> {
                fromCurrency = euro
                when(to) {
                    b.rbToEuro.id -> result = value
                    b.rbToDollar.id -> result = value * EURO_DOLLAR
                    b.rbToPound.id -> result = value * EURO_POUND
                    b.rbToYen.id -> result = value * EURO_YEN
                    b.rbToWon.id -> result = value * EURO_WON
                }
            }
            b.rbFromPound.id -> {
                fromCurrency = pound
                when(to) {
                    b.rbToPound.id -> result = value
                    b.rbToDollar.id -> result = value * POUND_DOLLAR
                    b.rbToEuro.id -> result = value * POUND_EURO
                    b.rbToYen.id -> result = value * POUND_YEN
                    b.rbToWon.id -> result = value * POUND_WON
                }
            }
            b.rbFromYen.id -> {
                fromCurrency = yen
                when(to) {
                    b.rbToYen.id -> result = value
                    b.rbToDollar.id -> result = value * YEN_DOLLAR
                    b.rbToEuro.id -> result = value * YEN_EURO
                    b.rbToPound.id -> result = value * YEN_POUND
                    b.rbToWon.id -> result = value * YEN_WON
                }
            }
            b.rbFromWon.id -> {
                fromCurrency = won
                when(to) {
                    b.rbToWon.id -> result = value
                    b.rbToDollar.id -> result = value * WON_DOLLAR
                    b.rbToEuro.id -> result = value * WON_EURO
                    b.rbToPound.id -> result = value * WON_POUND
                    b.rbToYen.id -> result = value * WON_YEN
                }
            }
        }

        when(to) {
            b.rbToDollar.id -> toCurrency = dollar
            b.rbToEuro.id -> toCurrency = euro
            b.rbToPound.id -> toCurrency = pound
            b.rbToYen.id -> toCurrency = yen
            b.rbToWon.id -> toCurrency = won
        }

        b.lblFrom.snackbar("$value$fromCurrency = $result$toCurrency")
    }

    private fun changeTo(checkedId: Int) {
        when (checkedId) {
            b.rbToDollar.id -> {
                b.rbToDollar.isEnabled = false
                b.rbToEuro.isEnabled = true
                b.rbToPound.isEnabled = true
                b.rbToYen.isEnabled = true
                b.rbToWon.isEnabled = true
                b.imgTo.setImageResource(R.drawable.ic_dollar)
            }
            b.rbToEuro.id -> {
                b.rbToEuro.isEnabled = false
                b.rbToDollar.isEnabled = true
                b.rbToPound.isEnabled = true
                b.rbToYen.isEnabled = true
                b.rbToWon.isEnabled = true
                b.imgTo.setImageResource(R.drawable.ic_euro)
            }
            b.rbToPound.id -> {
                b.rbToPound.isEnabled = false
                b.rbToDollar.isEnabled = true
                b.rbToEuro.isEnabled = true
                b.rbToYen.isEnabled = true
                b.rbToWon.isEnabled = true
                b.imgTo.setImageResource(R.drawable.ic_pound)
            }
            b.rbToYen.id -> {
                b.rbToYen.isEnabled = false
                b.rbToDollar.isEnabled = true
                b.rbToEuro.isEnabled = true
                b.rbToPound.isEnabled = true
                b.rbToWon.isEnabled = true
                b.imgTo.setImageResource(R.drawable.ic_yen)
            }
            b.rbToWon.id -> {
                b.rbToWon.isEnabled = false
                b.rbToDollar.isEnabled = true
                b.rbToEuro.isEnabled = true
                b.rbToPound.isEnabled = true
                b.rbToYen.isEnabled = true
                b.imgTo.setImageResource(R.drawable.ic_won)
            }
        }
    }

    private fun changeFrom(checkedId: Int) {
        when (checkedId) {
            b.rbFromDollar.id -> {
                b.rbFromDollar.isEnabled = false
                b.rbFromEuro.isEnabled = true
                b.rbFromPound.isEnabled = true
                b.rbFromYen.isEnabled = true
                b.rbFromWon.isEnabled = true
                b.imgFrom.setImageResource(R.drawable.ic_dollar)
            }
            b.rbFromEuro.id -> {
                b.rbFromEuro.isEnabled = false
                b.rbFromDollar.isEnabled = true
                b.rbFromPound.isEnabled = true
                b.rbFromYen.isEnabled = true
                b.rbFromWon.isEnabled = true
                b.imgFrom.setImageResource(R.drawable.ic_euro)
            }
            b.rbFromPound.id -> {
                b.rbFromPound.isEnabled = false
                b.rbFromDollar.isEnabled = true
                b.rbFromEuro.isEnabled = true
                b.rbFromYen.isEnabled = true
                b.rbFromWon.isEnabled = true
                b.imgFrom.setImageResource(R.drawable.ic_pound)
            }
            b.rbFromYen.id -> {
                b.rbFromYen.isEnabled = false
                b.rbFromDollar.isEnabled = true
                b.rbFromEuro.isEnabled = true
                b.rbFromPound.isEnabled = true
                b.rbFromWon.isEnabled = true
                b.imgFrom.setImageResource(R.drawable.ic_yen)
            }
            b.rbFromWon.id -> {
                b.rbFromWon.isEnabled = false
                b.rbFromDollar.isEnabled = true
                b.rbFromEuro.isEnabled = true
                b.rbFromPound.isEnabled = true
                b.rbFromYen.isEnabled = true
                b.imgFrom.setImageResource(R.drawable.ic_won)
            }
        }
    }

}
