package com.nix.summer.myapp.core.entity

enum class Drink(val water: Int, val milk: Int, val coffeeBeans: Int, val cost: Float, val currency: String) {
    ESPRESSO(250, 0, 15, 4f, "USD"),
    LATTE(350, 75, 20, 7f, "USD"),
    CAPPUCCINO(200, 100, 12, 6f, "USD");
}
