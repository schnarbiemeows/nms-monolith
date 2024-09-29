package com.schnarbiesnmeowers.nmsmonolith.pojos.email;

import java.io.Serializable;

public class OutputMessage implements Serializable {

    private int returnCode;

    private String returnMessage;

    private String errorMessage;

    public OutputMessage() {
    }

    public OutputMessage(int returnCode, String returnMessage, String errorMessage) {
        this.returnCode = returnCode;
        this.returnMessage = returnMessage;
        this.errorMessage = errorMessage;
    }

    public int getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
