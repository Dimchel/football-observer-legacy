package com.dimchel.footballobserver

import com.dimchel.footballobserver.data.repos.competition.CompetitionRepo
import com.dimchel.footballobserver.data.repos.competition.models.CompetitionModel
import com.dimchel.footballobserver.presentation.competitions.CompetitionPresenter
import com.dimchel.footballobserver.presentation.competitions.CompetitionsView
import com.dimchel.footballobserver.presentation.competitions.`CompetitionsView$$State`
import io.reactivex.Single
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.*
import org.mockito.Mockito.`when`
import org.mockito.Mockito.times


class CompetitionsListUnitTest {

    @Mock
    private lateinit var view: CompetitionsView

    @Mock
    private lateinit var repo: CompetitionRepo

    @Mock
    private lateinit var viewState: `CompetitionsView$$State`

    @Captor
    private lateinit var captor: ArgumentCaptor<Boolean>

    private lateinit var presenter: CompetitionPresenter

    @Before
    fun init() {
        MockitoAnnotations.initMocks(this)

        presenter = CompetitionPresenter(repo)
        presenter.setViewState(viewState)
    }

    @Test
    fun test_progress() {
        val list: List<CompetitionModel> = listOf(CompetitionModel(
                1,
                "1",
                "1",
                1,
                1,
                1,
                1,
                1,
                "1")
        )

        `when`(repo.getCompetitionsList()).thenReturn(Single.just(list))

        presenter.attachView(view)

        Mockito.verify(viewState, times(2)).showProgress(captor.capture())
        assertEquals(true, captor.allValues[0])
        assertEquals(false, captor.allValues[1])

        Mockito.verify(repo).getCompetitionsList()
    }

}