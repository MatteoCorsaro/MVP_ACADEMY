package org.example.mvpAcademy;

public enum TRAINER_LIST {
    MATTIA("MATTIA"),
    MASSIMILIANO("MASSIMILIANO"),
    EMANUELE("EMANUELE");

    private final String trainerName;

    TRAINER_LIST(String positionName) {

        this.trainerName = positionName;
    }

    public static TRAINER_LIST fromString(String positionName) {
        for (TRAINER_LIST position : TRAINER_LIST.values()) {
            if (position.trainerName.equalsIgnoreCase(positionName)) {
                return position;
            }
        }
        throw new IllegalArgumentException(STR."Invalid position name: \{positionName}");
    }

    @Override
    public String toString() {
        return trainerName;
    }
}
