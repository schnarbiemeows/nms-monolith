package com.schnarbiesnmeowers.nmsmonolith.entities.email;

import java.io.Serializable;

public class InputMessage implements Serializable {

    private String subject;
    private String content;

    public InputMessage() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public InputMessage(String subject, String content) {
        this.subject = subject;
        this.content = content;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


}
