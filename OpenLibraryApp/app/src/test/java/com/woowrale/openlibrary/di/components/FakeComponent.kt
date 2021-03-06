package com.woowrale.openlibrary.di.components

import com.woowrale.openlibrary.OpenLibraryMVVMTest
import com.woowrale.openlibrary.data.repository.OpenLibraryRepository
import com.woowrale.openlibrary.di.factory.UseCaseFactory
import com.woowrale.openlibrary.di.modules.FakeAppModule
import com.woowrale.openlibrary.di.modules.ThreadModule
import com.woowrale.openlibrary.ui.details.DetailsViewModel
import com.woowrale.openlibrary.ui.global.local.GlobalLocalViewModel
import com.woowrale.openlibrary.ui.global.remote.GlobalRemoteViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        FakeAppModule::class,
        ThreadModule::class
    ]
)
interface FakeComponent {

    val openLibraryRepository: OpenLibraryRepository
    val useCaseFactory: UseCaseFactory
    val globalRemoteViewModel: GlobalRemoteViewModel
    val globalLocalViewModel: GlobalLocalViewModel
    val detailsViewModel: DetailsViewModel

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun appTest(application: OpenLibraryMVVMTest): FakeComponent.Builder
        fun build(): FakeComponent
    }
}