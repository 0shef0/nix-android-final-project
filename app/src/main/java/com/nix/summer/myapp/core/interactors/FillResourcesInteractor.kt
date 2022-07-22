package com.nix.summer.myapp.core.interactors

import com.nix.summer.myapp.core.entity.Resources
import com.nix.summer.myapp.core.entity.Response
import com.nix.summer.myapp.data.repositories.FakeRepository

class FillResourcesInteractor(private val repository: FakeRepository) {
    operator fun invoke(res: Resources): Response =
        with(repository.fill(res)) {
            Response(responseMessage, resources)
        }
}