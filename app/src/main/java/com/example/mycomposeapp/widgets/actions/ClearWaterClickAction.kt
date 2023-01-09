package com.example.mycomposeapp.widgets.actions

import android.content.Context
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.glance.GlanceId
import androidx.glance.action.ActionParameters
import androidx.glance.appwidget.action.ActionCallback
import androidx.glance.appwidget.state.updateAppWidgetState
import androidx.glance.state.PreferencesGlanceStateDefinition
import com.example.mycomposeapp.widgets.main.WATER_WIDGET_PREFS_KEY
import com.example.mycomposeapp.widgets.main.WaterWidget

class ClearWaterClickAction : ActionCallback {
    override suspend fun onRun(context: Context, glanceId: GlanceId, parameters: ActionParameters) {
        updateAppWidgetState(context, PreferencesGlanceStateDefinition, glanceId) {
            it.toMutablePreferences()
                .apply {
                    this[intPreferencesKey(WATER_WIDGET_PREFS_KEY)] = 0
                }
        }
        WaterWidget().update(context, glanceId)
    }
}
