package fr.bendev.batchcookingapp.base

import fr.bendev.batchcookingapp.domain.common.error.ErrorType

open class BaseUIState(
    val isLoading: Boolean = false,
    val modelError: ErrorType? = null
)