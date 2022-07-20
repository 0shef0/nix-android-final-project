package com.nix.summer.myapp.adapters

import com.nix.summer.myapp.core.entity.Response

interface Contract {

    interface View {
        fun showInfo(response: Response)
    }

    interface Presenter {
        fun attach (view: View)

        fun detach()
    }
}