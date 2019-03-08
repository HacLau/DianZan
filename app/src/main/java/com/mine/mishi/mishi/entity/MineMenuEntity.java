package com.mine.mishi.mishi.entity;

/**
 * Created by liush on 2019/2/26.
 */

public class MineMenuEntity {
    private int id;
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MineMenuEntity(int id, String title) {
        this.id = id;
        this.title = title;
    }
}
