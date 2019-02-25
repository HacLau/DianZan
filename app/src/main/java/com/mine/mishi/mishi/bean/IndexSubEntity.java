package com.mine.mishi.mishi.bean;

/**
 * Created by liush on 2019/2/22.
 */

public class IndexSubEntity {
    private String imageDesc;
    private String imageIcon;

    private String name;
    private String headIcon;

    private String likeNumber;
    private String likeIcon;

    public IndexSubEntity(String imageDesc, String imageIcon, String name, String headIcon, String likeNumber, String likeIcon) {
        this.imageDesc = imageDesc;
        this.imageIcon = imageIcon;
        this.name = name;
        this.headIcon = headIcon;
        this.likeNumber = likeNumber;
        this.likeIcon = likeIcon;
    }

    public String getIamagedesc() {
        return imageDesc;
    }

    public void setIamagedesc(String imageDesc) {
        this.imageDesc = imageDesc;
    }

    public String getImageIcon() {
        return imageIcon;
    }

    public void setImageIson(String imageIcon) {
        this.imageIcon = imageIcon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadIcon() {
        return headIcon;
    }

    public void setHeadIcon(String headIcon) {
        this.headIcon = headIcon;
    }

    public String getLikeNumber() {
        return likeNumber;
    }

    public void setLikeNumber(String likeNumber) {
        this.likeNumber = likeNumber;
    }

    public String getLikeIcon() {
        return likeIcon;
    }

    public void setLikeIson(String likeIcon) {
        this.likeIcon = likeIcon;
    }
}