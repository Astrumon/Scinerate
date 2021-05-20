package com.kpi.scineticle.viewmodel.subsystemFormationOfRules.inputData;

import com.kpi.scineticle.model.subsystemOfDataBase.user.User;

public abstract class InputViewModel<T> {

    public abstract boolean insert(T t);
    public abstract boolean inputDataForCheck(String email, String password);
    public abstract boolean checkExistingMail(User user);
}
