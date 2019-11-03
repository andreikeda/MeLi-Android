package com.example.meli.search.view

import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.meli.R
import com.example.meli.core.closeKeyboard
import com.example.meli.core.isInternetConnectionAvailable
import com.example.meli.core.model.SearchResultModel
import com.example.meli.core.showInternetConnectionErrorSnackBar
import com.example.meli.search.adapter.SearchItemAdapter
import com.example.meli.search.contract.SearchContract
import com.example.meli.search.presenter.SearchPresenter
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity(), SearchContract.View, SearchView.OnQueryTextListener {

    private var mPresenter: SearchContract.Presenter? = null

    override fun hideLoading() {
        progress_bar.visibility = View.GONE
    }

    override fun showError(errorMessage: String) {
    }

    override fun showLoading() {
        progress_bar.visibility = View.VISIBLE
    }

    override fun populateRecyclerView(results: List<SearchResultModel>) {
        recycler_view.apply {
            adapter = SearchItemAdapter(results, this@SearchActivity)
            layoutManager = LinearLayoutManager(this@SearchActivity)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        mPresenter = SearchPresenter(this)
    }

    override fun onResume() {
        super.onResume()

        if (!isInternetConnectionAvailable()) {
            showInternetConnectionErrorSnackBar(root_view)
        }
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        mPresenter?.onSearchQuerySubmit(query)
        closeKeyboard(currentFocus)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        return false
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        val searchView = menu.findItem(R.id.search_bar).actionView as SearchView
        searchView.apply {
            queryHint = getString(R.string.hint_query)
            isIconified = true
        }.also {
            it.setOnQueryTextListener(this)
        }
        return true
    }
}
