package com.nix.summer.myapp.core.interactors

import com.nix.summer.myapp.core.entity.Drink
import com.nix.summer.myapp.core.entity.Response
import com.nix.summer.myapp.data.repositories.FakeRepository

class BuyInteractor(private val repository: FakeRepository) {
    operator fun invoke(drink: Drink) : Response =
        with (repository.buy(drink)) {
            Response(responseMessage, resources)
        }
}