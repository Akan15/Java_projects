package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "aeycompany.com";

    // Конструктор для получения имени и фамилии
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        // Вызвать метод с запросом отдела - вернуть отдел
        this.department = setDepartment();

        // Вызвать метод, возвращающий случайный пароль
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        // Комбинируйте элемент для создания элетронной почты
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
    }

    // Спосите об отделе
    private String setDepartment() {
        System.out.println("New worked: " + firstName + ". DEPARMENT CODES\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {
            return "sales";
        } else if (depChoice == 2) {
            return "dev";
        } else if (depChoice == 3) {
            return "acct";
        } else {
            return "";
        }
    }

    // Сгенирировать случайный пароль
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    // Установите емкость почтового ящика
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    // Установите альтернативный адрес элекронной почты
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    // Сменить пароль
    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    public String showInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }
}