package com.example.recipeappmvp.ui.home

import com.example.recipeappmvp.base.BasePresenter
import com.example.recipeappmvp.base.BaseView
import com.example.recipeappmvp.data.model.ResponseCategoriesList
import com.example.recipeappmvp.data.model.ResponseFoodList

interface HomeContracts {
    interface View : BaseView {
        fun showRandomFood(data: ResponseFoodList)
        fun showCategoriesList(categoriesList: ResponseCategoriesList)
        fun showFoodsList(foodsList: ResponseFoodList)
        fun showEmptyList()

    }

    interface Presenter : BasePresenter {
        fun getRandomFood()
        fun getCategoriesList()
        fun getFoodsListByLetter(letter: String)
        fun searchFoodsList(letter: String)

        fun getFoodByCategory(category: String)
    }
}