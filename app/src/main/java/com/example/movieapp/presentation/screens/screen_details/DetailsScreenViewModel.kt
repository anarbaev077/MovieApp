package com.example.movieapp.presentation.screens.screen_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.base.model.ResponseStatus
import com.example.movieapp.data.mappers.presentation_mappers.toUi
import com.example.movieapp.domain.use_case.info.DefaultGetCurrentKinofyInfoUseCase
import com.example.movieapp.presentation.models.info_models.details_base_models_presentation.InfoKinofyPresentationModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.net.UnknownHostException
import javax.inject.Inject

@HiltViewModel
class DetailsScreenViewModel @Inject constructor(
    private val detailsKinofy: DefaultGetCurrentKinofyInfoUseCase,
) : ViewModel() {

    private val _uiState: MutableStateFlow<DetailsScreenUiState> =
        MutableStateFlow(DetailsScreenUiState.Loading)
    val uiState: StateFlow<DetailsScreenUiState> = _uiState.asStateFlow()

    private val handle = CoroutineExceptionHandler { _, throwable -> }

    fun getKinofyInfo(movieId: Int) {
        viewModelScope.launch(handle + Dispatchers.IO) {
            val response = detailsKinofy(
                movieId = movieId
            )
            if (response.status == ResponseStatus.SUCCESS) {
                _uiState.update {
                    DetailsScreenUiState.Success(
                        detailsKinofy = response.data?.toUi()
                            ?: InfoKinofyPresentationModel.unknown,
                        overview = response.data?.toUi()
                            ?: InfoKinofyPresentationModel.unknown
                    )
                }
            } else {
                response.errorThrowable?.message?.let { message ->
                    if (
                        response == UnknownHostException()
                    ) {
                        _uiState.update {
                            DetailsScreenUiState.Error(
                                message = message,
                                isErrorWithConnection = true
                            )
                        }
                    } else {
                        _uiState.update {
                            DetailsScreenUiState.Error(
                                message = message,
                                isErrorWithConnection = false
                            )
                        }
                    }
                }
            }
        }
    }
}