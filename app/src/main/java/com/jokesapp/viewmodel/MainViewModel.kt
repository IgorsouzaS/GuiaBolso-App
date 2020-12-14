package com.jokesapp.viewmodel

import android.annotation.SuppressLint
import android.widget.EditText
import androidx.lifecycle.ViewModel
import com.jakewharton.rxbinding2.widget.RxTextView
import com.jokesapp.model.Category
import com.jokesapp.model.Result
import com.jokesapp.service.ChuckNorrisService
import com.jokesapp.view.RvAdapter
import com.jokesapp.view.RvAdapterCategories
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class MainViewModel : ViewModel() {

    private val service = ChuckNorrisService()
    private var _responseList = mutableListOf<Category>()
    private var _filterList = mutableListOf<Result>()

    val responseList: MutableList<Category>
        get() = _responseList

    val filterList: MutableList<Result>
        get() = _filterList


    fun fetchJokes(rvAdapterCategories: RvAdapterCategories): Disposable{

        return service.getJokesList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    list -> list.forEach({
                        responseList.add(it)
                     })
                    rvAdapterCategories.update(responseList)
                }, {
                        e -> e.printStackTrace()
                })
    }

    fun fetchJokeByText(rvAdapter: RvAdapter, filter: String) : Disposable{
        return service.getByText(filter)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                    list ->
                filterList.clear()
                list.result.forEach({
                filterList.add(it)
            })
                rvAdapter.update(filterList)
            }, {
                    e -> e.printStackTrace()
            })
    }

    @SuppressLint("CheckResult")
    fun addSearchTextListener(rvAdapter: RvAdapter, edtSearch: EditText) {
        RxTextView.textChangeEvents(edtSearch)
            .debounce(1, TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { edt -> fetchJokeByText(rvAdapter, edt.view().text.toString()) }
    }
}
