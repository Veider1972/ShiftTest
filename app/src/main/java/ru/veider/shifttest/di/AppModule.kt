package ru.veider.shifttest.di

import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ru.veider.shifttest.data.repo.local.*
import ru.veider.shifttest.data.repo.remote.*
import ru.veider.shifttest.domain.repo.Repo
import ru.veider.shifttest.data.repo.RepoImpl
import ru.veider.shifttest.domain.*
import ru.veider.shifttest.presentation.MainViewModel

val appModule = module {
    singleOf(::WebSource)
    singleOf(::LocalRepoImpl) {bind<LocalRepo>()}
    singleOf(::RemoteRepoImpl) {bind<RemoteRepo>()}
    singleOf(::RepoImpl) {bind<Repo>()}
    singleOf(::UseCasesImpl) {bind<UseCases>()}
    singleOf(::MainViewModel)
}
