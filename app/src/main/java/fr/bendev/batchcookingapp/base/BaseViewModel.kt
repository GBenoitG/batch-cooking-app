package fr.bendev.batchcookingapp.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import fr.bendev.batchcookingapp.domain.common.error.ErrorType

abstract class BaseViewModel : ViewModel() {

    protected val _isLoading = MutableLiveData<Boolean>()
    protected val _modelError = MutableLiveData<ErrorType>()

    val isLoading: LiveData<Boolean>
        get() = _isLoading
    val modelError: LiveData<ErrorType?>
        get() = _modelError

}

class BaseViewModelFactory<T>(val creator: () -> T) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return creator() as T
    }
}