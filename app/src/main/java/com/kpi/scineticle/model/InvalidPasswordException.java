package com.kpi.scineticle.model;

public class InvalidPasswordException extends Exception{
    int passwordConditionViolated = 0;

    public InvalidPasswordException(int conditionViolated)
    {
        super("Invalid Password: ");
        passwordConditionViolated = conditionViolated;
    }

    public String printMessage()
    {
        // Call constructor of parent Exception
        // according to the condition violated
        switch (passwordConditionViolated) {

            // Password length should be
            // between 8 to 15 characters
            case 1:
                return ("Пароль повинен бути від 8 до 15 символів");

            // Password should not contain any space
            case 2:
                return ("Пароль не повинен містити відступів");

            // Password should contain// at least one digit(0-9)
            case 3:
                return ("Пароль повинен містити хоча б одну цифру (0-9)");

            // Password should contain at least
            // one special character ( @, #, %, &, !, $ )
            case 4:
                return ("Пароль повинен міститити хоча б один спец. символ ( @, #, %, &, !, $ )");

            // Password should contain at least
            // one uppercase letter(A-Z)
            case 5:
                return ("Пароль повинен містити хоча б одну велику літеру (A-Z)");

            // Password should contain at least
            // one lowercase letter(a-z)
            case 6:
                return ("Пароль повинен містити хоча б одну маленьку літеру (a-z)");
        }

        return ("");
    }
}

