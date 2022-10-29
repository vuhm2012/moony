package com.vuhm.moony.domain.model;

import java.util.UUID;

public class CategoryIcon {

    private final String id;
    private final String iconName;
    private final int iconResId;

    public CategoryIcon(String iconName, int iconResId) {
        this.id = UUID.randomUUID().toString();
        this.iconName = iconName;
        this.iconResId = iconResId;
    }

    public CategoryIcon(String id, String iconName, int iconResId) {
        this.id = id;
        this.iconName = iconName;
        this.iconResId = iconResId;
    }

    public String getId() {
        return id;
    }

    public String getIconName() {
        return iconName;
    }

    public int getIconResId() {
        return iconResId;
    }
}
