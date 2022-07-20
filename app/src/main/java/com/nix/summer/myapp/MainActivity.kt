package com.nix.summer.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var textVeiw: TextView
    private lateinit var resourcesView: TextView
    private lateinit var waterInput: TextInputEditText
    private lateinit var milkInput: TextInputEditText
    private lateinit var coffeeBeansInput: TextInputEditText
    private lateinit var disposableCupsInput: TextInputEditText

    private var controller = Controller(Model())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        controller.attachView(this)
    }

    fun buyEspresso(view: View) {
        controller.buyChoice(1)
    }
    fun buyLatte(view: View) {
        controller.buyChoice(2)
    }
    fun buyCappuccino(view: View) {
        controller.buyChoice(3)
    }

    fun takeMoney(view: View) {
        controller.takeCommand(Request("take"))
    }

    fun fillMachine(view: View) {
        waterInput = findViewById(R.id.waterInput)
        milkInput = findViewById(R.id.milkInput)
        coffeeBeansInput = findViewById(R.id.coffeeBeansInput)
        disposableCupsInput = findViewById(R.id.cupsInput)
        controller.takeCommand(Request("fill"), Resources(waterInput.text.toString().toInt(),
                                                                    milkInput.text.toString().toInt(),
                                                                    coffeeBeansInput.text.toString().toInt(),
                                                                    disposableCupsInput.text.toString().toInt()))
    }

    fun showInfo(response: Response) {
        textVeiw = findViewById(R.id.message)
        resourcesView = findViewById(R.id.Resources)
        textVeiw.text = response.responseMessage
        resourcesView.text = response.resourcesString
    }


}