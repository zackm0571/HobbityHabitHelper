package com.zackmatthews.hobbityhabithelper;

import java.io.Serializable;

/**
 * Created by zmatthews on 4/6/18.
 */

public class HabitModel implements Serializable{

    private String title, desc, id;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
