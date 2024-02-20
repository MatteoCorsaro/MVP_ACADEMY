package org.example.progetto;

public enum HOUR {
    PRIMA("8:00"),
    SECONDA("9:15"),
    TERZA("10:30"),
    QUARTA("11:45");

    private final String stringHour;

    HOUR(String hour) {
        this.stringHour = hour;
    }

    public static HOUR fromString(String positionName) {
        for (HOUR position : HOUR.values()) {
            if (position.stringHour.equalsIgnoreCase(positionName)) {
                return position;
            }
        }
        throw new IllegalArgumentException("Invalid position name: " + positionName);
    }

    @Override
    public String toString() {
        return stringHour;
    }
}
