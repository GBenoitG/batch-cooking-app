package fr.bendev.batchcookingapp.base

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.fragment.app.FragmentActivity
import fr.bendev.batchcookingapp.ui.theme.BatchTheme

abstract class BaseActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BatchTheme {
                SetContentView()
            }
        }
    }

    @Composable
    abstract fun SetContentView()

}