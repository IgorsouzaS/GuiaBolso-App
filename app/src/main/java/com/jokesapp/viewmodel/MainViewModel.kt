package com.jokesapp.viewmodel

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jokesapp.model.Category
import com.jokesapp.model.Response
import com.jokesapp.service.ChuckNorrisService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.awaitResponse
import java.util.*
import kotlin.concurrent.schedule

class MainViewModel : ViewModel() {

    private val service = ChuckNorrisService()
    private var _responseList = MutableLiveData<List<Category>>()
    private var _filter = MutableLiveData<Response>()

    val responseList: LiveData<List<Category>>
        get() = _responseList

    /*TODO*/
    val filter: LiveData<Response>
        get() = _filter


    fun fetchJokes() {
        viewModelScope.launch(Dispatchers.IO) {
            val res = service.getJokesList().awaitResponse()

            val body = res.body()

            if (res.isSuccessful) {
                withContext(Dispatchers.Main) {
                    _responseList.value = body
                }
            }
            if(!body.isNullOrEmpty()) {

            }
        }
    }

    /*TODO*/
    fun fetchJokeByText(filter: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val res = service.getByText(filter).awaitResponse()
            val body = res.body()!!

            if (res.isSuccessful) {
                withContext(Dispatchers.Main) {
                    _filter.value = res.body()
                }
            }
            /*if(!body.result.isEmpty()) {
                //TODO Mostrar mensagem de não encontrado
            }*/
        }
    }

    fun addSearchTextListener(edtSearch: EditText) {
        edtSearch.addTextChangedListener(object : TextWatcher {
            var timer = Timer()

            override fun beforeTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                timer.cancel()
                val sleep = 1000L
                timer = Timer()
                timer.schedule(sleep) {
                    /*if (s.isNullOrEmpty()) {
                        fetchRandomJoke()
                    } else {*/
                        fetchJokeByText(s.toString())
                    //}
                }
            }
        })
    }
}
