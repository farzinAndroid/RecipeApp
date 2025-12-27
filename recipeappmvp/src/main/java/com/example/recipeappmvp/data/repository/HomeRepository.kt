package com.example.recipeappmvp.data.repository

import com.example.recipeappmvp.data.model.ResponseCategoriesList
import com.example.recipeappmvp.data.model.ResponseFoodList
import com.example.recipeappmvp.server.ApiServices
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import javax.inject.Inject

class HomeRepository @Inject constructor(private val api: ApiServices) {
    fun getRandomFood(): Single<Response<ResponseFoodList>> = api.getRandomFood()
    fun getCategoriesFoodList(): Single<Response<ResponseCategoriesList>> = api.getCategoriesFoodList()
    fun getFoodListByLetter(letter: String): Single<Response<ResponseFoodList>> = api.getFoodListByLetter(letter)
    fun searchFoodList(letter: String): Single<Response<ResponseFoodList>> = api.searchFoodList(letter)
    fun getFoodsByCategory(letter: String): Single<Response<ResponseFoodList>> = api.getFoodsByCategory(letter)
}