package com.example.meli

import android.view.View
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.google.android.material.textfield.TextInputLayout
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.anything
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers


open class BaseTestRobot {

    fun  checkActivityStarted(activityName: String) =
        Intents.intended(IntentMatchers.hasComponent(activityName))

    fun fillEditText(resId: Int, text: String): ViewInteraction =
        onView(withId(resId)).perform(ViewActions.replaceText(text), ViewActions.closeSoftKeyboard())

    fun clickButton(resId: Int): ViewInteraction = onView((withId(resId))).perform(ViewActions.click())

    fun textView(resId: Int): ViewInteraction = onView(withId(resId))

    fun matchText(viewInteraction: ViewInteraction, text: String): ViewInteraction = viewInteraction
        .check(ViewAssertions.matches(ViewMatchers.withText(text)))

    fun matchTextInputLayoutError(resId: Int, errorText: String) =
        onView(withId(resId)).check(
            ViewAssertions.matches(hasTextInputLayoutErrorText(errorText))
        )

    fun matchText(resId: Int, text: String): ViewInteraction = matchText(textView(resId), text)

    fun clickListItem(listRes: Int, position: Int) {
        onData(anything())
            .inAdapterView(allOf(withId(listRes)))
            .atPosition(position).perform(ViewActions.click())
    }

    private fun hasTextInputLayoutHintText(hintText: String): Matcher<View> =
        object : TypeSafeMatcher<View>() {

            override fun describeTo(description: Description) = Unit

            override fun matchesSafely(item: View): Boolean {
                (item as? TextInputLayout)?.let { inputLayout ->
                    val msg =  inputLayout.hint
                    msg?.let {
                        return hintText == it
                    } ?: run {
                        return false
                    }
                } ?: run {
                    return false
                }
            }
        }

    private fun hasTextInputLayoutErrorText(errorText: String): Matcher<View> =
        object : TypeSafeMatcher<View>() {

            override fun describeTo(description: Description) = Unit

            override fun matchesSafely(item: View): Boolean {
                (item as? TextInputLayout)?.let { inputLayout ->
                    val msg =  inputLayout.error
                    msg?.let {
                        return errorText == it
                    } ?: run {
                        return false
                    }
                } ?: run {
                    return false
                }
            }
        }

}