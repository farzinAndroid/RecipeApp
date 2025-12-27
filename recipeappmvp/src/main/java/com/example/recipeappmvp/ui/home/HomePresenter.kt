package com.example.recipeappmvp.ui.home

import com.example.foodappmvp.utils.applyIoScheduler
import com.example.recipeappmvp.base.BasePresenterImpl
import com.example.recipeappmvp.data.repository.HomeRepository
import javax.inject.Inject

class HomePresenter @Inject constructor(
    private val repository: HomeRepository,
    val view: HomeContracts.View
) : BasePresenterImpl(), HomeContracts.Presenter {
    override fun getRandomFood() {
        if (view.checkInternet()) {
            disposable = repository.getRandomFood()
                .applyIoScheduler()
                .subscribe({ response ->
                    when (response.code()) {
                        in 200..202 -> {
                            response.body()?.let {
                                view.showRandomFood(it)
                            }
                        }

                        422 -> {

                        }

                        in 400..499 -> {

                        }

                        in 500..599 -> {

                        }
                    }

                }, {
                    view.serverError(it.message.toString())
                })
        }
    }

    override fun getCategoriesList() {
        if (view.checkInternet()) {
            view.showLoading()
            disposable = repository.getCategoriesFoodList()
                .applyIoScheduler()
                .subscribe({ response ->
                    view.hideLoading()
                    when (response.code()) {
                        in 200..202 -> {
                            response.body()?.let {
                                view.showCategoriesList(it)
                            }
                        }
                    }

                }, {
                    view.hideLoading()
                    view.serverError(it.message.toString())
                })
        }else{
            view.internetError(false)
        }
    }

}