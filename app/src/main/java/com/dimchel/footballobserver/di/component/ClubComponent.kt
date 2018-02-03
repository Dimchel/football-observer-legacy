package com.dimchel.footballobserver.di.component

import com.dimchel.footballobserver.di.module.ClubModule
import com.dimchel.footballobserver.di.scopes.ClubScope
import com.dimchel.footballobserver.presentation.club.ClubPresenter
import dagger.Subcomponent


@ClubScope
@Subcomponent(modules = [(ClubModule::class)])
interface ClubComponent {

    fun inject(clubPresenter: ClubPresenter)

}