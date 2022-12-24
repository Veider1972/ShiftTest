package ru.veider.shifttest.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.veider.shifttest.domain.UseCases
import ru.veider.shifttest.domain.data.Resource
import ru.veider.shifttest.presentation.screens.cache.CacheScreenState
import ru.veider.shifttest.presentation.screens.main.MainScreenState

class MainViewModel(
    private val useCases: UseCases
) : ViewModel() {

    private val _cardDataState = MutableStateFlow(MainScreenState())
    val cardDataState: StateFlow<MainScreenState> = _cardDataState.asStateFlow()

    private val _cacheDataState = MutableStateFlow(CacheScreenState())
    val cacheDataState: StateFlow<CacheScreenState> = _cacheDataState.asStateFlow()

    fun textUpdate(cardNumber:String){
        _cardDataState.update { it.copy(cardNumber = cardNumber) }
    }

    fun getCardInfo(number: Long) {
        viewModelScope.launch {
            when (val card = useCases.getCardInfo(number)) {
                is Resource.Success -> {
                    _cardDataState.update {
                        it.copy(card = card.data, error = null)
                    }
                }
                is Resource.Error   -> {
                    _cardDataState.update {
                        it.copy(error = card.error)
                    }
                }
            }
        }
    }

    fun getCache(){
        viewModelScope.launch {
            when(val cardList = useCases.getCache()){

                is Resource.Success -> {
                    _cacheDataState.update {
                        it.copy(cacheList = cardList.data, error = null)
                    }
                }
                is Resource.Error ->{
                    _cacheDataState.update {
                        it.copy(error = cardList.error)
                    }
                }
            }
        }
    }
}