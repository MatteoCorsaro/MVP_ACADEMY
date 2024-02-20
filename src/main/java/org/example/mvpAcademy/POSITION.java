package org.example.mvpAcademy;

public enum POSITION {
    SMALL_FORWARD("Small Forward"),
    POWER_FORWARD("Power Forward"),
    CENTER("Center"),
    PLAYMAKER("Point Guard"),
    GUARD("Shooting Guard");

    private final String positionName;

    POSITION(String positionName) {
        this.positionName = positionName;
    }

    public static POSITION fromString(String positionName) {
        for (POSITION position : POSITION.values()) {
            if (position.positionName.equalsIgnoreCase(positionName)) {
                return position;
            }
        }
        throw new IllegalArgumentException("Invalid position name: " + positionName);
    }

    @Override
    public String toString() {
        return positionName;
    }
}

