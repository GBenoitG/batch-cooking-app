package fr.bendev.batchcookingapp.navigation

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) {
        // Pop up to the start destination of the graph to
        // avoid building up a large stack of destinations
        // on the back stack as users select items
        popUpTo(
            this@navigateSingleTopTo.graph.findStartDestination().id
        ) {
            saveState = true
        }
        // Avoid multiple copies of the same destination when
        // reselecting the same item
        launchSingleTop = true
        // Restore state when reselecting a previously selected item
        restoreState = true
    }

fun NavHostController.navigateToInternalActivity(
    target: Class<out Activity>,
    args: Bundle? = null,
    action: ((Activity) -> Unit)? = null
) {
    // Get an activity instance
    (this.context as? Activity)?.run {
        navigateToActivityWithIntent(
            Intent(
                this,
                target
            ).apply {
                args?.let {
                    putExtras(it)
                }
            }
        )

        action?.invoke(this)
    }
}

fun NavHostController.navigateToActivityWithIntent(intent: Intent) {
    context.run {
        startActivity(intent)
    }
}