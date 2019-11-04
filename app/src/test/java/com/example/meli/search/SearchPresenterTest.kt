package com.example.meli.search

import com.example.meli.TestHelper
import com.example.meli.search.contract.SearchContract
import com.example.meli.search.presenter.SearchPresenter
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

class SearchPresenterTest {

    private val mView: SearchContract.View = mockk(relaxed = true)
    private val mInteractor: SearchContract.Interactor = mockk(relaxed = true)
    private val mPresenter: SearchContract.Presenter by lazy {
        SearchPresenter(mView)
    }

    @Test
    fun testSomething() {
        mPresenter.onSearchQuerySubmit(TestHelper.QUERY)
        verify {
            mView.showLoading()
            mInteractor.search(TestHelper.QUERY)
        }
    }
}