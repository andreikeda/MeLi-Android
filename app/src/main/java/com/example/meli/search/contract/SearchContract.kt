package com.example.meli.search.contract

import com.example.meli.core.model.SearchResultModel
import com.example.meli.core.vo.GetSearchVO

interface SearchContract {
    interface Interactor {
        /**
         * Method to start search request
         *
         * @param query - query param to be searched
         */
        fun search(query: String)

        /**
         * Method to dispose variables
         */
        fun unregister()
    }

    interface InteractorOutput {
        /**
         * Method to callback when error happens
         *
         * @param errorMessage - message to be shown
         */
        fun onSearchQuerySubmitError(errorMessage: String)

        /**
         * Method to callback result when success
         *
         * @param result - vo object
         */
        fun onSearchQuerySubmitSuccess(result: GetSearchVO)
    }

    interface Presenter {
        /**
         * Method to handle the query user has inputted
         *
         * @param query - String term to search
         */
        fun onSearchQuerySubmit(query: String)

        /**
         * Method to dispose variables
         */
        fun unregister()
    }

    interface View {
        /**
         * Method to hide loading progress bar
         */
        fun hideLoading()

        /**
         * Method to show error
         *
         * @param errorMessage - String message to be shown
         */
        fun showError(errorMessage: String)

        /**
         * Method to show loading progress bar
         */
        fun showLoading()

        /**
         * Method to populate recycler view with data from server
         */
        fun populateRecyclerView(results: List<SearchResultModel>)
    }
}
