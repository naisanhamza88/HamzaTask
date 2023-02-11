package com.hamza.task.view.football_view

import androidx.recyclerview.widget.LinearLayoutManager
import com.hamza.task.R
import com.hamza.task.base.BaseBindingFragment
import com.hamza.task.databinding.FragmentFootballBinding
import com.hamza.task.viewModel.FootballViewModel


class FootballFragment :
    BaseBindingFragment<FootballViewModel, FragmentFootballBinding>(
        FootballViewModel::class.java
    ) {

    override fun getLayoutRes(): Int {
        return R.layout.fragment_football
    }

    override fun init() {
        super.init()
        binding.viewModel = viewModel
        binding.footballList.layoutManager = LinearLayoutManager(appActivity)
        viewModel.fetchData()
    }

}