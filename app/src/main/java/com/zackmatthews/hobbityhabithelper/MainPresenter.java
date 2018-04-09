package com.zackmatthews.hobbityhabithelper;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.List;

/**
 * Created by zmatthews on 4/6/18.
 */

public class MainPresenter {

    private static final String HABIT_NEW_TITLE = "New habit";

    private MainContract contract;

    public interface MainContract{
        void onHabitCreated(HabitModel habit);
    }

    public void presentNewHabbitDialog(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View v = inflater.inflate(R.layout.new_habbit_dialog, null);
        new AlertDialog.Builder(context)
                .setTitle(HABIT_NEW_TITLE).setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                HabitModel model = new HabitModel();
                model.setTitle(((TextView)v.findViewById(R.id.et_title)).getText().toString());
                model.setDesc(((TextView)v.findViewById(R.id.et_desc)).getText().toString());
                contract.onHabitCreated(model);
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setView(v).show();
    }

    public void commitHabitList(Context ctx, List<HabitModel> habits){
        HabitManager.getInstance().commitHabits(ctx, habits);
    }

    public void setContract(MainContract contract) {
        this.contract = contract;
    }
}
