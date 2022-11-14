package fr.bendev.batchcookingapp.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData

/**
 * Custom live data that can be forced to be refreshed
 */

class RefreshableLiveData<T>(private val source: () -> LiveData<T>) : MediatorLiveData<T>() {

    private var liveData = source()

    init {
        this.addSource(liveData, ::observer)
    }

    private fun observer(data: T) {
        value = data
    }

    fun refresh() {
        this.removeSource(liveData)
        liveData = source()
        this.addSource(liveData, ::observer)
    }
}