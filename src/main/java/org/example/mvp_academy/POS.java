package org.example.mvp_academy;

public enum POS {
    MID_CORNER_LEFT("Mid_Corner_left"),
    MID_WING_LEFT("Mid_wing_left"),
    MID_TOP_OF_THE_KEY("Mid_top_of_the_Key"),
    MID_WING_RIGHT("Mid_Wing_right"),
    MID_CORNER_RIGHT("Mid_Corner_right"),

    THREE_CORNER_LEFT("Three_Corner_left"),
    THREE_WING_LEFT("Three_Wing_left"),
    THREE_TOP_OF_THE_KEY("Three_top_of_the_Key"),
    THREE_WING_RIGHT("Three_Wing_right"),
    THREE_CORNER_RIGHT("Three_Corner_right"),

    FREE_THROW("Free_throw");

    private final String positionName;

    POS(String positionName) {
        this.positionName = positionName;
    }

    public static POS fromString(String positionName) {
        for (POS position : POS.values()) {
            if (position.positionName.equalsIgnoreCase(positionName)) {
                return position;
            }
        }
        throw new IllegalArgumentException(STR."Invalid position name: \{positionName}");
    }

    @Override
    public String toString() {
        return positionName;
    }
}
