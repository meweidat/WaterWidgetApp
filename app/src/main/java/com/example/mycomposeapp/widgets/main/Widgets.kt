package com.example.mycomposeapp.widgets.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.glance.GlanceModifier
import androidx.glance.appwidget.*
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.padding
import androidx.glance.state.GlanceStateDefinition
import androidx.glance.state.PreferencesGlanceStateDefinition
import com.example.mycomposeapp.widgets.ui.WaterWidgetContent

const val WATER_WIDGET_PREFS_KEY = "WATER_WIDGET_PREFS_KEY"

class WaterWidget : GlanceAppWidget() {
    override var stateDefinition: GlanceStateDefinition<*> = PreferencesGlanceStateDefinition

    @Composable
    override fun Content() {
        WaterWidgetContent(
            modifier = GlanceModifier
                .fillMaxSize()
                .background(
                    day = Color.Blue,
                    night = Color.DarkGray
                )
                .appWidgetBackground()
                .cornerRadius(16.dp)
                .padding(8.dp),
        )
    }
}