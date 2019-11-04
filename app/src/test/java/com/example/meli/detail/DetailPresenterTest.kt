package com.example.meli.detail

import com.example.meli.detail.contract.DetailContract
import com.example.meli.detail.presenter.DetailPresenter
import io.mockk.mockk
import org.junit.Test

class DetailPresenterTest {

    private val mView: DetailContract.View = mockk(relaxed = true)
    private val mPresenter: DetailContract.Presenter by lazy {
        DetailPresenter(mView)
    }

    @Test
    fun test() {
    }
}