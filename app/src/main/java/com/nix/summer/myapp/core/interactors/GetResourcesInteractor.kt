package com.nix.summer.myapp.core.interactors

import com.nix.summer.myapp.core.entity.Resources
import com.nix.summer.myapp.core.entity.Response
import com.nix.summer.myapp.data.repositories.FakeRepository

class GetResourcesInteractor(private val repository: FakeRepository) {
    operator fun invoke(): Response =
        with(repository.getResourses()) {
            Response(responseMessage, resources)
        }
}