package com.schnarbiesnmeowers.nmsmonolith.dtos.spices;

import java.io.Serializable;

public class SpiceRecordDisplay implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private Integer spiceId;

    /**
     * "name of the spice"
     */
    private String spiceName;

    private boolean local;

    public SpiceRecordDisplay() {
    }

    public SpiceRecordDisplay(Integer spiceId, String spiceName, boolean local) {
        this.spiceId = spiceId;
        this.spiceName = spiceName;
        this.local = local;
    }

    public Integer getSpiceId() {
        return spiceId;
    }

    public void setSpiceId(Integer spiceId) {
        this.spiceId = spiceId;
    }

    public String getSpiceName() {
        return spiceName;
    }

    public void setSpiceName(String spiceName) {
        this.spiceName = spiceName;
    }

    public boolean isLocal() {
        return local;
    }

    public void setLocal(boolean local) {
        this.local = local;
    }

    @Override
    public String toString() {
        return "SpiceRecordDisplay{" +
                "spiceId=" + spiceId +
                ", spiceName='" + spiceName + '\'' +
                ", local=" + local +
                '}';
    }
}
