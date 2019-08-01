package com.bytecruncher.backacity.widget;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;

import com.bytecruncher.backacity.model.Recipe;

public class RecipeWidgetService {

    public static void updateWidget(Context context, Recipe recipe) {
        WidgetPrefs.saveRecipe(context, recipe);

        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(context, RecipeWidget.class));
        RecipeWidget.updateAppWidgets(context, appWidgetManager, appWidgetIds);
    }
}
