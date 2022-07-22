package com.nix.summer.myapp.ui.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.nix.summer.myapp.*
import com.nix.summer.myapp.ui.adapters.Contract
import com.nix.summer.myapp.ui.adapters.MainPresenter
import com.nix.summer.myapp.core.entity.Resources
import com.nix.summer.myapp.core.entity.Request
import com.nix.summer.myapp.core.entity.Response
import com.nix.summer.myapp.core.interactors.BuyInteractor
import com.nix.summer.myapp.core.interactors.FillResourcesInteractor
import com.nix.summer.myapp.core.interactors.TakeMoneyInteractor
import com.nix.summer.myapp.data.repositories.FakeRepository

class MainActivity : AppCompatActivity(), Contract.View {

    private lateinit var textVeiw: TextView
    private lateinit var resourcesView: TextView
    private lateinit var waterInput: TextInputEditText
    private lateinit var milkInput: TextInputEditText
    private lateinit var coffeeBeansInput: TextInputEditText
    private lateinit var disposableCupsInput: TextInputEditText

    private val presenter = MainPresenter(BuyInteractor(FakeRepository()),
                                            TakeMoneyInteractor(FakeRepository()),
                                            FillResourcesInteractor(FakeRepository()))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.attach(this)
    }

    fun buyEspresso(view: View) {
        presenter.buyChoice(1)
    }
    fun buyLatte(view: View) {
        presenter.buyChoice(2)
    }
    fun buyCappuccino(view: View) {
        presenter.buyChoice(3)
    }

    fun takeMoney(view: View) {
        presenter.takeCommand(Request("take"))
    }

    fun fillMachine(view: View) {
        waterInput = findViewById(R.id.waterInput)
        milkInput = findViewById(R.id.milkInput)
        coffeeBeansInput = findViewById(R.id.coffeeBeansInput)
        disposableCupsInput = findViewById(R.id.cupsInput)
        presenter.takeCommand(
            Request("fill"), Resources(waterInput.text.toString().toInt(),
                                                                    milkInput.text.toString().toInt(),
                                                                    coffeeBeansInput.text.toString().toInt(),
                                                                    disposableCupsInput.text.toString().toInt())
        )
    }

    override fun showInfo(response: Response) {
        textVeiw = findViewById(R.id.message)
        resourcesView = findViewById(R.id.Resources)
        textVeiw.text = response.responseMessage
        resourcesView.text = "${response.resources.water} ml of water\n" +
                "${response.resources.milk} ml of milk\n" +
                "${response.resources.coffeeBeans} g of coffee beans\n" +
                "${response.resources.disposableCups} disposable cups"
    }

}