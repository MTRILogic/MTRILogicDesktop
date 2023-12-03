package com.mtrilogic.abstracts;

@SuppressWarnings("unused")
public abstract class Model {

    private final boolean enabled;
    private final int type;
    private final long id;

    /*==================================================================================================================
    PUBLIC CONSTRUCTORS
    ==================================================================================================================*/

    public Model(long id, int type, boolean enabled) {
        this.enabled = enabled;
        this.type = type;
        this.id = id;
    }

    /*==================================================================================================================
    PUBLIC FINAL METHODS
    ==================================================================================================================*/

    public final boolean isEnabled() {
        return enabled;
    }

    public final int getType() {
        return type;
    }

    public final long getId() {
        return id;
    }
}
