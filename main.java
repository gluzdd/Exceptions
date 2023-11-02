package org.example.HW3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class main {
    public static void main(String[] args) throws DataFormatException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные в произвольном порядке, разделенные пробелом:" +
                " Фамилия Имя Отчество дата рождения номер телефона пол");
        String user = scanner.nextLine();

        String[] data = user.split(" ");
        if (data.length < 5) {
            throw new IllegalArgumentException("Что то пошло не так ) пожалуйста прочитайте условие внимательно!");
        }
        String lastName = ParseText.transform(data[0]);
        String firstName = ParseText.transform(data[1]);
        String middleName = ParseText.transform(data[2]);
        String birthday = ParseDate.formatDate(ParseDate.parsedate(data[3]));
        long phoneNumber = ParsNumber.check(data[4]);
        char gender = ParseGender.genderParse(data[5].charAt(0));

        try (FileWriter fileWriter = new FileWriter("HW3")) {
            fileWriter.write(user);
        } catch (RuntimeException | IOException e) {
            System.out.println("catch exception: " + e.getClass().getSimpleName());
        }

        System.out.println("lastName: " + lastName + "\n" + "firstName: " + firstName + "\n"
                + "middleName: " + middleName + "\n" + "birthday: "+
                birthday + "\n" + "phoneNumber: " + phoneNumber + "\n" + "gender: " + gender);
    }
}
