package com.nix.summer.myapp.data.repositories

import com.nix.summer.myapp.core.entity.Drink
import com.nix.summer.myapp.core.entity.Resources
import com.nix.summer.myapp.core.entity.Response

interface Repository {

    fun buy(drink: Drink): Response

    fun take(): Response

    fun fill(resources: Resources): Response

    fun getResourses(): Response
}