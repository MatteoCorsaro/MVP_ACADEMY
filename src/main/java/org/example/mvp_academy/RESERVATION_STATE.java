package org.example.mvp_academy;

public enum RESERVATION_STATE {
    PASSATA("PASSATA"),
    NON_ACCETTATA("NON ACCETTATA"),
    ACCETTATA("ACCETTATA");

    private final String state;

    RESERVATION_STATE(String state) {
        this.state = state;
    }

    public static RESERVATION_STATE fromString(String state_str) {
        for (RESERVATION_STATE state : RESERVATION_STATE.values()) {
            if (state.state.equalsIgnoreCase(state_str)) {
                return state;
            }
        }
        throw new IllegalArgumentException(STR."Invalid position name: \{state_str}");
    }

    @Override
    public String toString() {
        return state;
    }

}
