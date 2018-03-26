package com.dimchel.footballobserver

import com.dimchel.footballobserver.data.repos.competition.CompetitionRepo
import com.dimchel.footballobserver.presentation.competitions.CompetitionPresenter
import com.dimchel.footballobserver.presentation.competitions.CompetitionsView
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class CompetitionsListUnitTest {

    private lateinit var presenter: CompetitionPresenter
    private lateinit var view: CompetitionsView
    private lateinit var repo: CompetitionRepo

    @Before
    fun init() {
        repo = Mockito.mock(CompetitionRepo::class.java)
        presenter = Mockito.spy(CompetitionPresenter(repo))

        view = Mockito.mock(CompetitionsView::class.java)
    }

    @Test
    fun test_progress() {
        presenter.attachView(view)

        Mockito.verify(view).showProgress(true)
        Mockito.verify(repo).getCompetitionsList()
    }

}