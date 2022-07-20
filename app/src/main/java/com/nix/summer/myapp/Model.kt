package com.nix.summer.myapp

class Model {

    private var water: Int = 400
    private var milk: Int = 540
    private var coffeeBeans: Int = 120
    private var disposableCups: Int = 9
    private var money: Int = 550

    fun buy(drink: Drink): Response {
        if (drink.water > this.water) {
            return Response("Sorry, not enough water",
                "${this.water} ml of water\n" +
                        "${this.milk} ml of milk\n" +
                        "${this.coffeeBeans} g of coffee beans\n" +
                        "${this.disposableCups} disposable cups\n" +
                        "${this.money} money")
        }
        else if (drink.milk > this.milk) {
            return Response("Sorry, not enough milk",
                "${this.water} ml of water\n" +
                        "${this.milk} ml of milk\n" +
                        "${this.coffeeBeans} g of coffee beans\n" +
                        "${this.disposableCups} disposable cups\n" +
                        "${this.money} money")
        }
        else if (drink.coffeeBeans > this.coffeeBeans) {
            return Response("Sorry, not enough coffee beans",
                "${this.water} ml of water\n" +
                        "${this.milk} ml of milk\n" +
                        "${this.coffeeBeans} g of coffee beans\n" +
                        "${this.disposableCups} disposable cups\n" +
                        "${this.money} money")
        }
        else if (this.disposableCups < 1) {
            return Response("Sorry, not enough disposable cups",
                "${this.water} ml of water\n" +
                        "${this.milk} ml of milk\n" +
                        "${this.coffeeBeans} g of coffee beans\n" +
                        "${this.disposableCups} disposable cups\n" +
                        "${this.money} money")
        }

        this.water -= drink.water
        this.milk -= drink.milk
        this.coffeeBeans -= drink.coffeeBeans
        this.disposableCups -= 1
        this.money += drink.cost
        return Response("I have enough resources, making you a coffee!",
            "${this.water} ml of water\n" +
                    "${this.milk} ml of milk\n" +
                    "${this.coffeeBeans} g of coffee beans\n" +
                    "${this.disposableCups} disposable cups\n" +
                    "${this.money} money")
    }

    fun take(): Response {
        val info = Response("I've gave you ${this.money}",
            "${this.water} ml of water\n" +
                    "${this.milk} ml of milk\n" +
                    "${this.coffeeBeans} g of coffee beans\n" +
                    "${this.disposableCups} disposable cups\n" +
                    "0 money")
        this.money = 0
        return info
    }

    fun fill(resources: Resources): Response {
        this.water += resources.water
        this.milk += resources.milk
        this.coffeeBeans += resources.coffeeBeans
        this.disposableCups += resources.disposableCups
        return Response("Filled",
            "${this.water} ml of water\n" +
                    "${this.milk} ml of milk\n" +
                    "${this.coffeeBeans} g of coffee beans\n" +
                    "${this.disposableCups} disposable cups\n" +
                    "${this.money} money")
    }
}