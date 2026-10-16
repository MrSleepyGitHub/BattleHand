package model;

public enum AttackType {
    ENERGY (0),
    HEAT (1),
    ICE (2),
    FURY (3),
    PROTECTOR (4);

    private final int slot;

    AttackType(int slot) {
        this.slot = slot;
    }

    public int slot() {
        return this.slot;
    }

    public static String nameFromSlot(int slot) {
        for (AttackType type : values()) {
            if (type.slot == slot) {
                return type.name();
            }
        }
        throw new IllegalArgumentException("Invalid slot");
    }
}
