package com.nix.summer.myapp.data.repositories

import com.nix.summer.myapp.core.entity.Drink
import com.nix.summer.myapp.core.entity.Resources
import com.nix.summer.myapp.core.entity.Response

class FakeRepository: Repository {

    private object CoffeeMachine {
        var water: Int = 400
        var milk: Int = 540
        var coffeeBeans: Int = 120
        var disposableCups: Int = 9
        var money: Float = 550f
    }

    override fun buy(drink: Drink): Response {
            if (drink.water > CoffeeMachine.water) {
                return Response("Sorry, not enough water",
                    Resources(CoffeeMachine.water, CoffeeMachine.milk, CoffeeMachine.coffeeBeans, CoffeeMachine.disposableCups))
            }
            else if (drink.milk > CoffeeMachine.milk) {
                return Response("Sorry, not enough milk",
                    Resources(CoffeeMachine.water, CoffeeMachine.milk, CoffeeMachine.coffeeBeans, CoffeeMachine.disposableCups))
            }
            else if (drink.coffeeBeans > CoffeeMachine.coffeeBeans) {
                return Response("Sorry, not enough coffee beans",
                    Resources(CoffeeMachine.water, CoffeeMachine.milk, CoffeeMachine.coffeeBeans, CoffeeMachine.disposableCups))
            }
            else if (CoffeeMachine.disposableCups < 1) {
                return Response("Sorry, not enough disposable cups",
                    Resources(CoffeeMachine.water, CoffeeMachine.milk, CoffeeMachine.coffeeBeans, CoffeeMachine.disposableCups))
            }

            CoffeeMachine.water -= drink.water
            CoffeeMachine.milk -= drink.milk
            CoffeeMachine.coffeeBeans -= drink.coffeeBeans
            CoffeeMachine.disposableCups -= 1
            CoffeeMachine.money += drink.cost
            return Response("I have enough resources, making you a coffee!",
                Resources(CoffeeMachine.water, CoffeeMachine.milk, CoffeeMachine.coffeeBeans, CoffeeMachine.disposableCups))
    }

    override fun take(): Response {
        val info = Response("I've gave you ${CoffeeMachine.money}",
            Resources(CoffeeMachine.water, CoffeeMachine.milk, CoffeeMachine.coffeeBeans, CoffeeMachine.disposableCups))
        CoffeeMachine.money = 0f
        return info
    }

    override fun fill(resources: Resources): Response{
        CoffeeMachine.water += resources.water
        CoffeeMachine.milk += resources.milk
        CoffeeMachine.coffeeBeans += resources.coffeeBeans
        CoffeeMachine.disposableCups += resources.disposableCups
        return Response("Filled",
            Resources(CoffeeMachine.water, CoffeeMachine.milk, CoffeeMachine.coffeeBeans, CoffeeMachine.disposableCups))
    }

    override fun getResourses(): Response {
        return Response("Returned resources", Resources(CoffeeMachine.water,
                                                                        CoffeeMachine.milk,
                                                                        CoffeeMachine.coffeeBeans,
                                                                        CoffeeMachine.disposableCups))
    }
}