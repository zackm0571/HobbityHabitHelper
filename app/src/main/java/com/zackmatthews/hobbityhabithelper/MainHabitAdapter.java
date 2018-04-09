package com.zackmatthews.hobbityhabithelper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zmatthews on 4/6/18.
 */

public class MainHabitAdapter extends RecyclerView.Adapter<MainHabitAdapter.HabitHolder>{

    private Context ctx;
    private List<HabitModel> data;

    public MainHabitAdapter(Context ctx){
        this.ctx = ctx;
        this.data = new ArrayList<>();
    }
    public class HabitHolder extends RecyclerView.ViewHolder{

        public TextView title, desc;

        public HabitHolder(View itemView) {
            super(itemView);
            this.title = itemView.findViewById(R.id.tv_title);
            this.desc = itemView.findViewById(R.id.tv_desc);
        }

        public void setTitle(String text){
            title.setText(text);
        }
        public void setDesc(String text){
            desc.setText(text);
        }
    }

    @Override
    public HabitHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.habit_row, null);
        return new HabitHolder(v);
    }

    @Override
    public void onBindViewHolder(HabitHolder holder, int position) {
        HabitModel model = data.get(position);
        holder.setTitle(model.getTitle());
        holder.setDesc(model.getDesc());
    }

    public void addHabit(HabitModel model){
        data.add(model);
    }
    @Override
    public int getItemCount() {
        return data.size();
    }
}
