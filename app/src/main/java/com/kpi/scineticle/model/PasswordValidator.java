package com.kpi.scineticle.model;

public class PasswordValidator {
    private static boolean isValid = true;

    public static boolean isIsValid() {
        return isValid;
    }

    public static void isValid(String password)
            throws InvalidPasswordException {

        if (password == null) {
            isValid = false;
            return;

        }
        if (!((password.length() >= 8)
                && (password.length() <= 15))) {
            isValid = false;
            throw new InvalidPasswordException(1);
        }

        if (password.contains(" ")) {
            isValid = false;
            throw new InvalidPasswordException(2);
        }
        if (true) {
            int count = 0;

            for (int i = 0; i <= 9; i++) {

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

            for (int i = 65; i <= 90; i++) {

                char c = (char) i;

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

            for (int i = 90; i <= 122; i++) {

                char c = (char) i;
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

    }


}
