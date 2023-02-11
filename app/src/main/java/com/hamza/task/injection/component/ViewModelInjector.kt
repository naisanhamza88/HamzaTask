package com.hamza.task.injection.component

import com.hamza.task.injection.module.NetworkModule
import com.hamza.task.network.RequestHandler
import com.hamza.task.viewModel.FootballViewModel
import dagger.Component
import javax.inject.Singleton

/**
 * Component providing inject() methods for presenters.
 */
@Singleton
@Component(modules = [NetworkModule::class])
interface ViewModelInjector {
    fun inject(rh: RequestHandler)

    fun inject(rh: FootballViewModel)

}