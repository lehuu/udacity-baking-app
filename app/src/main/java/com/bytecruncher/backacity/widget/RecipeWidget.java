package com.bytecruncher.backacity.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import com.bytecruncher.backacity.R;
import com.bytecruncher.backacity.model.Recipe;

/**
 * Implementation of App Widget functionality.
 */
public class RecipeWidget extends AppWidgetProvider {

    static void updateAppWidgets(Context context, AppWidgetManager appWidgetManager,
                                 int[] appWidgetId) {

        Recipe recipe = WidgetPrefs.loadRecipe(context);

        if(recipe != null) {
            // Construct the RemoteViews object
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.recipe_widget);
            views.setTextViewText(R.id.widget_recipe_name, recipe.getName());
            views.setTextViewText(R.id.widget_recipe_servings, context.getString(R.string.servings_widget, recipe.getServings()));

            //Bind remote adapter
            Intent listIntent = new Intent(context, RecipeWidgetService.class);
            views.setRemoteAdapter(R.id.widget_ingredient_list, listIntent);

            // Instruct the widget manager to update the widget
            appWidgetManager.updateAppWidget(appWidgetId, views);
            appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetId, R.id.widget_ingredient_list);
        }
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        updateAppWidgets(context, appWidgetManager, appWidgetIds);
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

