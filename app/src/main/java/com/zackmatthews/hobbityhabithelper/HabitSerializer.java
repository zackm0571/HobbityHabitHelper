package com.zackmatthews.hobbityhabithelper;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by zmatthews on 4/9/18.
 */

public class HabitSerializer {
    private static Gson gson;
    public static void storeDataToSharedPrefs(Context ctx, String id, String data){
        getPreferences(ctx).edit().putString(id, data).apply();
    }

    public static String serializeHabit(@NonNull HabitModel habit){
        return getGson().toJson(habit, HabitModel.class);
    }

    public static String serializeHabitList(Context ctx, List<HabitModel> habits){
        Type listType = new TypeToken<List<HabitModel>>(){}.getType();
        return getGson().toJson(habits, listType);
    }

    public static List<HabitModel> deserializeHabitList(Context ctx, String id){
        Type listType = new TypeToken<List<HabitModel>>(){}.getType();
        return getGson().fromJson(getDataFromSharedPrefs(ctx, id), listType);
    }

    public static String getDataFromSharedPrefs(Context ctx, String id){
        return getPreferences(ctx).getString(id, null);
    }

    public static HabitModel deserializeHabit(Context ctx, String id){
        String json = getPreferences(ctx).getString(id, null);
        if(json != null){
            return getGson().fromJson(json, HabitModel.class);
        }
        return null;
    }

    private static SharedPreferences getPreferences(Context ctx){
        return PreferenceManager.getDefaultSharedPreferences(ctx);
    }

    public static Gson getGson() {
        if(gson == null) gson = new Gson();
        return gson;
    }
}
