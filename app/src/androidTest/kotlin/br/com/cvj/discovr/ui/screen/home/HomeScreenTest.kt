package br.com.cvj.discovr.ui.screen.home

import androidx.activity.ComponentActivity
import androidx.annotation.StringRes
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import br.com.cvj.discovr.R
import br.com.cvj.discovr.ui.util.components.loading.LoadingTag
import br.com.cvj.discovr.util.AppLanguage
import br.com.cvj.discovr.util.AppTheme
import org.junit.Rule
import org.junit.Test

class HomeScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private fun getString(@StringRes id: Int) = composeTestRule.activity.resources.getString(id)

    @Test
    fun loading_showsLoadingScreen() {
        composeTestRule.setContent {
            HomeScreen(
                uiState = HomeUiState.Loading,
                onChangeLanguage = { },
                onChangeTheme = { }
            )
        }

        composeTestRule
            .onNodeWithTag(LoadingTag)
            .assertIsDisplayed()
    }

    @Test
    fun success_showsSettingsOptions() {
        composeTestRule.setContent {
            HomeScreen(
                uiState = HomeUiState.Success(
                    language = AppLanguage.English,
                    theme = AppTheme.FollowSystem
                ),
                onChangeLanguage = { },
                onChangeTheme = { }
            )
        }

        // assert both "change language" and "change theme" buttons are displayed
        composeTestRule
            .onNodeWithText(getString(R.string.change_language))
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText(getString(R.string.change_theme))
            .assertIsDisplayed()
    }
}
