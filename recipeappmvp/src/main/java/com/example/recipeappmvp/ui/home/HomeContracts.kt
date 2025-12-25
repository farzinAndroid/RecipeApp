package com.example.recipeappmvp.ui.home

import com.example.recipeappmvp.base.BasePresenter
import com.example.recipeappmvp.base.BaseView
import com.example.recipeappmvp.data.model.ResponseFoodList

interface HomeContracts {
    interface View : BaseView {
        fun showRandomFood(data: ResponseFoodList)
    }

    interface Presenter : BasePresenter {
        fun getRandomFood()
    }
}