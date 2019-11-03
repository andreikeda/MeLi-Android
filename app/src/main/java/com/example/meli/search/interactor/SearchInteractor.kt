package com.example.meli.search.interactor

import com.example.meli.core.repository.MeLiServiceAPI
import com.example.meli.core.vo.GetSearchVO
import com.example.meli.search.contract.SearchContract
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchInteractor(var mOutput: SearchContract.InteractorOutput?) : SearchContract.Interactor {

    override fun search(query: String) {
        MeLiServiceAPI()
            .create()
            .search(query)
            .enqueue(object : Callback<GetSearchVO> {
                override fun onFailure(call: Call<GetSearchVO>, t: Throwable) {
                    mOutput?.onSearchQuerySubmitError(t.localizedMessage)
                }

                override fun onResponse(call: Call<GetSearchVO>, response: Response<GetSearchVO>) {
                    response.body()?.let {
                        mOutput?.onSearchQuerySubmitSuccess(it)
                        return
                    }
                    response.errorBody()?.let {
                        mOutput?.onSearchQuerySubmitError(it.string())
                    }
                }
            })
    }

    override fun unregister() {
        mOutput = null
    }
}
