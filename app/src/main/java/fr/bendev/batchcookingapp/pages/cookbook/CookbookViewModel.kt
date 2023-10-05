package fr.bendev.batchcookingapp.pages.cookbook

import androidx.lifecycle.viewModelScope
import fr.bendev.batchcookingapp.base.BaseViewModel
import fr.bendev.batchcookingapp.domain.common.repositories.CookbookRepository
import fr.bendev.batchcookingapp.framework.di.Injector
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CookbookViewModel(
    private val cookbookRepository: CookbookRepository = Injector.cookbookRepository
) : BaseViewModel<CookBookUIState>(CookBookUIState()) {

    init {
        viewModelScope.launch {
            cookbookRepository.getAllEntries().collect { list ->
                _uiState.update { it.copy(entries = list.map { entry -> CookbookEntryUI(entry) }) }
            }
        }
    }

}