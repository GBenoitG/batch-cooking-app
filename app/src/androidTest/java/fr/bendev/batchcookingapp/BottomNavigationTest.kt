package fr.bendev.batchcookingapp

import android.content.Context
import androidx.annotation.StringRes
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotSelected
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.filterToOne
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.performClick
import fr.bendev.batchcookingapp.pages.MainActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class BottomNavigationTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private lateinit var context: Context

    @Before
    fun initTest() {
        context = composeTestRule.activity
    }

    @Test
    fun initMainActivity_verifyStartDestination() {
        composeTestRule
            .onTabNodeWithTitleRes(context, R.string.bottom_navigation_bar_label_cookbook)
            .assertIsSelected()
            .assertIsDisplayed()
    }

    @Test
    fun initMainActivity_clickOnToCook_toCookSelected() {
        composeTestRule
            .onTabNodeWithTitleRes(context, R.string.bottom_navigation_bar_label_tocook)
            .assertIsDisplayed()
            .assertIsNotSelected()
            .performClick()
            .assertIsSelected()
    }

    @Test
    fun initMainActivity_clickOnSettings_settingsSelected() {
        composeTestRule
            .onTabNodeWithTitleRes(context, R.string.bottom_navigation_bar_label_settings)
            .assertIsDisplayed()
            .assertIsNotSelected()
            .performClick()
            .assertIsSelected()
    }

    private fun AndroidComposeTestRule<*, *>.onTabNodeWithTitleRes(
        context: Context,
        @StringRes stringRes: Int
    ): SemanticsNodeInteraction {
        val objectTitle = context.getString(stringRes)
        return this.onAllNodesWithText(objectTitle).filterToOne(
            SemanticsMatcher.expectValue(
                SemanticsProperties.Role, Role.Tab
            )
        )
    }

}
