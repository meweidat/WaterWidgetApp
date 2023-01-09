package com.example.mycomposeapp.widgets.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.glance.*
import androidx.glance.action.actionStartActivity
import androidx.glance.action.clickable
import androidx.glance.appwidget.action.actionRunCallback
import androidx.glance.layout.*
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextAlign
import androidx.glance.text.TextStyle
import androidx.glance.unit.ColorProvider
import com.example.mycomposeapp.R
import com.example.mycomposeapp.SecondaryActivity
import com.example.mycomposeapp.widgets.main.WATER_WIDGET_PREFS_KEY
import com.example.mycomposeapp.widgets.actions.AddWaterClickAction
import com.example.mycomposeapp.widgets.actions.ClearWaterClickAction

@Composable
fun WaterWidgetContent(
    modifier: GlanceModifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val prefs = currentState<Preferences>()
        val glassesOfWater = prefs[intPreferencesKey(WATER_WIDGET_PREFS_KEY)] ?: 0
        val glanceModifier = GlanceModifier.fillMaxWidth().defaultWeight()
        WaterWidgetCounter(
            glassesOfWater = glassesOfWater,
            modifier = glanceModifier
        )
        WaterWidgetGoal(
            glassesOfWater = glassesOfWater,
            modifier = glanceModifier
        )
        WaterWidgetButtons(glanceModifier)
        WaterWidgetOpenActivity(glanceModifier)
    }
}

@Composable
fun WaterWidgetCounter(
    glassesOfWater: Int,
    modifier: GlanceModifier
) {
    Text(
        text = "Number of cups: $glassesOfWater",
        modifier = modifier,
        style = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            color = ColorProvider(
                color = Color.White
            )
        ),
    )
}

@Composable
fun WaterWidgetGoal(
    glassesOfWater: Int,
    modifier: GlanceModifier
) {
    Text(
        text =
        when {
            glassesOfWater >= 8 -> "Goal Met!"
            else -> "Water Goal 8 cups"
        },
        modifier = modifier,
        style = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            color = ColorProvider(
                color = Color.White
            )
        ),
    )
}

@Composable
fun WaterWidgetButtons(
    modifier: GlanceModifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            provider = ImageProvider(
                resId = R.drawable.ic_baseline_delete_outline_24
            ),
            contentDescription = null,
            modifier = GlanceModifier
                .clickable(
                    onClick = actionRunCallback<ClearWaterClickAction>()
                )
                .defaultWeight()
        )
        Image(
            provider = ImageProvider(
                resId = R.drawable.ic_baseline_add_24
            ),
            contentDescription = null,
            modifier = GlanceModifier
                .clickable(
                    onClick = actionRunCallback<AddWaterClickAction>()
                )
                .defaultWeight()
        )
    }
}

@Composable
fun WaterWidgetOpenActivity(
    modifier: GlanceModifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            text = "Open water activity",
            onClick = actionStartActivity<SecondaryActivity>()
        )
    }
}