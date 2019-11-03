package com.example.meli.search.presenter

import android.util.Log
import com.example.meli.BuildConfig
import com.example.meli.core.model.SearchResultModel
import com.example.meli.core.vo.GetSearchVO
import com.example.meli.search.contract.SearchContract
import com.example.meli.search.interactor.SearchInteractor

class SearchPresenter(var mView: SearchContract.View?) : SearchContract.Presenter,
    SearchContract.InteractorOutput {

    private val TAG = javaClass.simpleName
    private var mInteractor: SearchContract.Interactor? = SearchInteractor(this)

    override fun onSearchQuerySubmitError(errorMessage: String) {
        if (BuildConfig.enableDebugLogging) {
            Log.e(TAG, errorMessage)
        }
        mView?.run {
            hideLoading()
            showError(errorMessage)
        }
    }

    override fun onSearchQuerySubmitSuccess(result: GetSearchVO) {
        val results = arrayListOf<SearchResultModel>()
        for (r in result.results) {
            if (BuildConfig.enableDebugLogging) {
                Log.i(TAG, "${r.id}. ${r.title}")
            }
            results.add(
                SearchResultModel().apply {
                    id = r.id
                    title = r.title
                    price = r.price
                    currency = r.currencyId
                    thumbnail = r.thumbnail
                }
            )
        }
        mView?.run {
            hideLoading()
            populateRecyclerView(results)
        }
    }

    override fun onSearchQuerySubmit(query: String) {
        mView?.showLoading()
        mInteractor?.search(query)
    }

    override fun unregister() {
        mInteractor?.unregister()
        mInteractor = null
        mView = null
    }
}
