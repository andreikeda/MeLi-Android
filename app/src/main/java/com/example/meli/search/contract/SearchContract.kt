package com.example.meli.search.contract

import com.example.meli.core.model.SearchResultModel
import com.example.meli.core.vo.GetSearchVO

interface SearchContract {
    interface Interactor {
        fun search(query: String)
        fun unregister()
    }

    interface InteractorOutput {
        fun onSearchQuerySubmitError(errorMessage: String)
        fun onSearchQuerySubmitSuccess(result: GetSearchVO)
    }

    interface Presenter {
        fun onSearchQuerySubmit(query: String)
        fun unregister()
    }

    interface View {
        fun hideLoading()
        fun showError(errorMessage: String)
        fun showLoading()
        fun populateRecyclerView(results: List<SearchResultModel>)
    }
}
