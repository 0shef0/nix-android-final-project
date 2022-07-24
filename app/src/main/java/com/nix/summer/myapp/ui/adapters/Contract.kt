package com.nix.summer.myapp.ui.adapters

import com.nix.summer.myapp.core.entity.Response

interface Contract {

    interface View {
        fun showPayment(response: Response)

        fun showInfo(response: Response)
    }

    interface Presenter {
        fun attach (view: View)

        fun detach()
    }
}