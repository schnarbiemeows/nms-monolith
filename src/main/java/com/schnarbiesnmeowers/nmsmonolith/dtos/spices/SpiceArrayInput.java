package com.schnarbiesnmeowers.nmsmonolith.dtos.spices;

import java.io.Serializable;
import java.util.Arrays;

public class SpiceArrayInput implements Serializable {


    int[] globalSpiceIds;
    int[] localSpiceIds;

    public SpiceArrayInput() {
    }

    public SpiceArrayInput(int[] globalSpiceIds, int[] localSpiceIds) {
        this.globalSpiceIds = globalSpiceIds;
        this.localSpiceIds = localSpiceIds;
    }

    public int[] getGlobalSpiceIds() {
        return globalSpiceIds;
    }

    public void setGlobalSpiceIds(int[] globalSpiceIds) {
        this.globalSpiceIds = globalSpiceIds;
    }

    public int[] getLocalSpiceIds() {
        return localSpiceIds;
    }

    public void setLocalSpiceIds(int[] localSpiceIds) {
        this.localSpiceIds = localSpiceIds;
    }

    @Override
    public String toString() {
        return "SpiceArrayInput{" +
                "globalSpiceIds=" + Arrays.toString(globalSpiceIds) +
                ", localSpiceIds=" + Arrays.toString(localSpiceIds) +
                '}';
    }
}
