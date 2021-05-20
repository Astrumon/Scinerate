package com.kpi.scineticle.model;

public class InvalidPasswordException extends Exception {
    int passwordConditionViolated = 0;

    public InvalidPasswordException(int conditionViolated) {
        super("Invalid Password: ");
        passwordConditionViolated = conditionViolated;
    }

    public String printMessage() {
        switch (passwordConditionViolated) {

            case 1:
                return ("Пароль повинен бути від 8 до 15 символів");

            case 2:
                return ("Пароль не повинен містити відступів");

            case 3:
                return ("Пароль повинен містити хоча б одну цифру (0-9)");

            case 4:
                return ("Пароль повинен міститити хоча б один спец. символ ( @, #, %, &, !, $ )");

            case 5:
                return ("Пароль повинен містити хоча б одну велику літеру (A-Z)");

            case 6:
                return ("Пароль повинен містити хоча б одну маленьку літеру (a-z)");
        }

        return ("");
    }
}

