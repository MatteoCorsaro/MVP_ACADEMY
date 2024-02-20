package org.example.mvpAcademy;

public enum HOUR {
    PRIMA("8:00"),
    SECONDA("9:15"),
    TERZA("10:30"),
    QUARTA("11:45");

    private final String hour;

    HOUR(String Hour) {
        this.hour = Hour;
    }

    public static HOUR fromString(String positionName) {
        for (HOUR position : HOUR.values()) {
            if (position.hour.equalsIgnoreCase(positionName)) {
                return position;
            }
        }
        throw new IllegalArgumentException("Invalid position name: " + positionName);
    }

    @Override
    public String toString() {
        return hour;
    }
}
