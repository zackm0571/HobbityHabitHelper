package com.zackmatthews.hobbityhabithelper;

import android.content.Context;

import java.util.List;

/**
 * Created by zmatthews on 4/9/18.
 */

public class HabitManager {

    private static HabitManager instance;
    private static final String HABIT_LIST_ID="list";
    public static HabitManager getInstance() {
        if(instance == null) instance = new HabitManager();
        return instance;
    }

    public void commitHabits(Context ctx, List<HabitModel> habits){
//        StringBuilder builder = new StringBuilder();
//        for(HabitModel habit : habits){
//            builder.append(HabitSerializer.serializeHabit(habit));
//        }

//        HabitSerializer.storeDataToSharedPrefs(ctx, HABIT_LIST_ID, builder.toString());

        HabitSerializer.storeDataToSharedPrefs(ctx, HABIT_LIST_ID, HabitSerializer.serializeHabitList(ctx, habits));
    }

    public List<HabitModel> loadHabits(Context ctx){
        return HabitSerializer.deserializeHabitList(ctx, HABIT_LIST_ID);
    }
}
