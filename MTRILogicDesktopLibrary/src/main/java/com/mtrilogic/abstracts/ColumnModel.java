package com.mtrilogic.abstracts;

@SuppressWarnings("unused")
public abstract class ColumnModel extends Model {

    private final Class<? extends Model> clazz;
    private final String name;

    /*==================================================================================================================
    PUBLIC CONSTRUCTORS
    ==================================================================================================================*/

    public ColumnModel(long id, int type, boolean enabled, String name, Class<? extends Model> clazz) {
        super(id, type, enabled);
        this.clazz = clazz;
        this.name = name;
    }

    /*==================================================================================================================
    PUBLIC FINAL METHODS
    ==================================================================================================================*/

    public final String getName() {
        return name;
    }
    
    public final Class<?> getClazz() {
        return clazz;
    }
}
