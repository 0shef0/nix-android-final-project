package com.nix.summer.myapp.core.entity

enum class Drink(val water: Int, val milk: Int, val coffeeBeans: Int, val cost: Int) {
    ESPRESSO(250, 0, 15, 4),
    LATTE(350, 75, 20, 7),
    CAPPUCCINO(200, 100, 12, 6);
}
