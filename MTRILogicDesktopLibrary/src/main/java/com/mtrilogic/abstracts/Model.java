package com.mtrilogic.abstracts;

@SuppressWarnings("unused")
public abstract class Model {
    private final boolean enabled;
    private final int type;
    private final long id;

    public Model(long id, int type, boolean enabled) {
        this.enabled = enabled;
        this.type = type;
        this.id = id;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public int getType() {
        return type;
    }

    public long getId() {
        return id;
    }
}
