package com.woowrale.openlibrary.di.threads

import com.woowrale.openlibrary.usecase.threads.JobScheduler
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class JobThread @Inject internal constructor() : JobScheduler {
    override val scheduler: Scheduler
        get() = Schedulers.io()
}