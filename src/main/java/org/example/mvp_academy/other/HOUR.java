package org.example.mvp_academy.other;

public enum HOUR {
    prima("8:00"),
    seconda("9:15"),
    terza("10:30"),
    quarta("11:45");

    private final String Hour;

    HOUR(String Hour) {
        this.Hour = Hour;
    }

    public static HOUR fromString(String positionName) {
        for (HOUR position : HOUR.values()) {
            if (position.Hour.equalsIgnoreCase(positionName)) {
                return position;
            }
        }
        throw new IllegalArgumentException("Invalid position name: " + positionName);
    }

    @Override
    public String toString() {
        return Hour;
    }
}
