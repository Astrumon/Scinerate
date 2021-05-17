package com.kpi.scineticle.model;

public class PasswordValidator {
    private static boolean isValid = true;

    public static boolean isIsValid() {
        return isValid;
    }

    public static void isValid(String password)
            throws InvalidPasswordException
    {
        // for checking if password length
        // is between 8 and 15
        if (password == null) {
            isValid = false;
            return;

        }
        if (!((password.length() >= 8)
                && (password.length() <= 15))) {
            isValid = false;
            throw new InvalidPasswordException(1);
        }

        // to check space
        if (password.contains(" ")) {
            isValid = false;
            throw new InvalidPasswordException(2);
        }
        if (true) {
            int count = 0;

            // check digits from 0 to 9
            for (int i = 0; i <= 9; i++) {

                // to convert int to string
                String str1 = Integer.toString(i);

                if (password.contains(str1)) {
                    count = 1;
                }
            }
            if (count == 0) {
                isValid = false;
                throw new InvalidPasswordException(3);
            }
        }

        // for special characters
        if (!(password.contains("@") || password.contains("#")
                || password.contains("!") || password.contains("~")
                || password.contains("$") || password.contains("%")
                || password.contains("^") || password.contains("&")
                || password.contains("*") || password.contains("(")
                || password.contains(")") || password.contains("-")
                || password.contains("+") || password.contains("/")
                || password.contains(":") || password.contains(".")
                || password.contains(", ") || password.contains("<")
                || password.contains(">") || password.contains("?")
                || password.contains("|"))) {
            isValid = false;
            throw new InvalidPasswordException(4);
        }

        if (true) {
            int count = 0;

            // checking capital letters
            for (int i = 65; i <= 90; i++) {

                // type casting
                char c = (char)i;

                String str1 = Character.toString(c);
                if (password.contains(str1)) {
                    count = 1;
                }
            }
            if (count == 0) {
                isValid = false;
                throw new InvalidPasswordException(5);
            }
        }

        if (true) {
            int count = 0;

            // checking small letters
            for (int i = 90; i <= 122; i++) {

                // type casting
                char c = (char)i;
                String str1 = Character.toString(c);

                if (password.contains(str1)) {
                    count = 1;
                }
            }
            if (count == 0) {
                isValid = false;
                throw new InvalidPasswordException(6);
            }
        }

        // The password is valid
    }


}
