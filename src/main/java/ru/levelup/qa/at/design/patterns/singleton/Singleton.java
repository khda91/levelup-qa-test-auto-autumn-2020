package ru.levelup.qa.at.design.patterns.singleton;

public enum Singleton {

    INSTANCE;

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
