package com.tin.clientsOrganization.mapper;

public abstract class BaseMapper<Source , Target> implements Mapper<Source , Target> {

    public BaseMapper(){
        this.setSourceClass();
        this.setTargetClass();
    }

    protected String sourceClass ;
    protected String targetClass ;

    public abstract Target getInstance ();

    public abstract void setSourceClass();
    public abstract void setTargetClass();

    public String getSourceClass (){
        return sourceClass;
    }

    public String getTargetClass(){
        return targetClass;
    }

}
