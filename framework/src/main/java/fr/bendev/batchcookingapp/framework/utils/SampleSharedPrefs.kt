package fr.bendev.batchcookingapp.framework.utils

/**
 * DESCRIPTION: Specific file that handles one specific shared preference. Inherits abstract BaseSharedPrefs
 * FILE NAMING CONVENTION: {OBJECT}SharedPrefs

    class SampleSharedPrefs(sharedPrefs: SharedPreferences = Injector.sharedPreferences) :
        BaseSharedPrefs(sharedPrefs) {

        companion object {
            const val SAMPLE_SHARED_PREF_KEY = "SAMPLE_SHARED_PREF_KEY"
        }

        fun getSamplePref(): String = load(SAMPLE_SHARED_PREF_KEY, "")
        fun saveUpdateSamplePref(value: String) = save(SAMPLE_SHARED_PREF_KEY, value)
        fun deleteSamplePref() = delete(SAMPLE_SHARED_PREF_KEY)
    }

 */