package fr.bendev.batchcookingapp

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotSelected
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import fr.bendev.batchcookingapp.pages.MainActivity
import org.junit.Rule
import org.junit.Test


class BottomNavigationTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun initMainActivity_verifyStartDestination() {
        composeTestRule
            .onNodeWithText("Cookbook")
            .assertIsSelected()
            .assertIsDisplayed()
    }

    @Test
    fun initMainActivity_clickOnToCook_toCookSelected() {
        composeTestRule
            .onNodeWithText("To Cook")
            .assertIsDisplayed()
            .assertIsNotSelected()
            .performClick()
            .assertIsSelected()
    }

    @Test
    fun initMainActivity_clickOnSettings_settingsSelected() {
        composeTestRule
            .onNodeWithText("Settings")
            .assertIsDisplayed()
            .assertIsNotSelected()
            .performClick()
            .assertIsSelected()
    }

}