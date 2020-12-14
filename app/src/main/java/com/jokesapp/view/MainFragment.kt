package com.jokesapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jokesapp.R
import com.jokesapp.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    //private val rvAdapterCategories = RvAdapterCategories(arrayListOf())
    private val rvAdapter = RvAdapter(arrayListOf())

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        rv.apply {
            layoutManager = LinearLayoutManager(context)
            //adapter = rvAdapterCategories
            adapter = rvAdapter
        }

        //viewModel.fetchJokes(rvAdapterCategories)

        viewModel.addSearchTextListener(rvAdapter, edtSearch)

    }

}
