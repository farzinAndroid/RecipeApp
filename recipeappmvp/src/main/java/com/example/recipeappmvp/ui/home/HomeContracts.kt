package com.example.recipeappmvp.ui.home

import com.example.recipeappmvp.base.BasePresenter
import com.example.recipeappmvp.base.BaseView
import com.example.recipeappmvp.data.model.ResponseCategoriesList
import com.example.recipeappmvp.data.model.ResponseFoodList
import okhttp3.Response

interface HomeContracts {
    interface View : BaseView {
        fun showRandomFood(data: ResponseFoodList)
        fun showCategoriesList(categoriesList: ResponseCategoriesList)
        fun showFoodsListByLetter(foodsList: ResponseFoodList)

    }

    interface Presenter : BasePresenter {
        fun getRandomFood()
        fun getCategoriesList()
        fun getFoodsListByLetter(letter: String)
    }
}