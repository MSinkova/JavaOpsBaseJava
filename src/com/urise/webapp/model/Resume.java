package com.urise.webapp.model;

/**
 * Initial resume class
 */
public class Resume {

    // Unique identifier
    private String uuid;

    public String getUuid() {
        return uuid;
    }

    public Resume setUuid(String uuid) {
        this.uuid = uuid;
        return null;
    }

    @Override
    public String toString() {
        return uuid;
    }
}
