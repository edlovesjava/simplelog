package com.wentware.simpleapps.simplelog;

import java.util.Date;
import org.springframework.data.annotation.Id;

public class LogMessage {

    @Id
    private String id;
    private String message;
    private String mood;
    private String recordedOn;

    public LogMessage() {
        
    }
    public LogMessage(String id, String message, String mood) {
        this.id = id;
        this.message = message;
        this.mood = mood;
        this.recordedOn = new Date().toString();
    }

    public String getId() {
        return this.id;
    }

    public String getMessage() {
        return this.message;
    }

    public String getMood() {
        return this.mood;
    }

    public String recordedOn() {
        return this.getRecordedOn();
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @param mood the mood to set
     */
    public void setMood(String mood) {
        this.mood = mood;
    }

    /**
     * @return the recordedOn
     */
    public String getRecordedOn() {
        return recordedOn;
    }

    /**
     * @param recordedOn the recordedOn to set
     */
    public void setRecordedOn(String recordedOn) {
        this.recordedOn = recordedOn;
    }
}
