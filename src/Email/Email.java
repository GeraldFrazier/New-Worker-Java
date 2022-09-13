package Email;

import java.util.Scanner;

public class Email {
    private final String firstName;
    private final String lastName;
    private final String department;
    private String email;
    private String password;
    private int mailBoxCapacity = 500;
    private String alternateEmail;

    public int getMailBoxCapacity() {
        return mailBoxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }
public String getPassword() {
        return password;
    }
    private int defaultPasswordLength = 8;
    private String CompanyName = "Company.com";

    //constructor to receive the first name and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = setDepartment();
        this.password = randomPassword(defaultPasswordLength);
        this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "."+ CompanyName;

        System.out.println("Email Created: " + this.firstName + " " + this.lastName);
        System.out.println("Department: " + this.department);
        System.out.println("Password: " + this.password);
        System.out.println("Email: " + email);
    }

    //ask for the department - return the department
    private String setDepartment() {
        System.out.println("Enter the department Code: \n 1 for Sales \n 2 for Development \n 3 for Accounting \n 0 for none");
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

    //generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%"; //set of characters to choose password from
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
//            System.out.println(passwordSet.charAt(rand));
        }
        return new String(password);
    }

    //set the mailbox capacity
    public void setMailBoxCapacity(int capacity) {
        this.mailBoxCapacity = capacity;
    }
    //set the alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    //change the password
    public void changePassword(String password) {
        this.password = password;
    }
}
