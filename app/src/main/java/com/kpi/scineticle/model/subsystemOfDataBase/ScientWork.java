package com.kpi.scineticle.model.subsystemOfDataBase;

public abstract class ScientWork {
    private String typeOfWork;

    public String getTypeOfWork() {
        return typeOfWork;
    }

    public void setTypeOfWork(String typeOfWork) {
        this.typeOfWork = typeOfWork;
    }

    public abstract int getId();
}
