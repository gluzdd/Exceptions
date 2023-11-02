package org.example.HW3;

import java.util.InputMismatchException;

public class ParseGender {

    public static char genderParse(char args) throws InputMismatchException{

        try {
            String as = String.valueOf(args);
            if (as.equals("f") || as.equals("m")) {
                return args;
            }
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
        throw new InputMismatchException("Invalid symbol");
    }
}
