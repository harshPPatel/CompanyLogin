package CompanyLogin;

import java.util.Scanner;

public class CompanyApp {

    private String firstName;
    private String lastName;
    private String userName;

    public CompanyApp() {

        setFirstName();
        System.out.println(firstName);
        setLastName();
        System.out.println(lastName);
        setUserName();
        System.out.println(userName);

    }

    private void setFirstName() {
        System.out.print("Enter First Name : ");
        Scanner in = new Scanner(System.in);
        String userInput = in.nextLine();
        if (userInput.isEmpty()) {
            System.err.println("Invalid First Name!");
            setFirstName();
        } else {
            this.firstName = userInput.substring(0,1).toUpperCase() + userInput.substring(1).toLowerCase();
        }
    }

    private void setLastName() {
        System.out.print("Enter Last Name : ");
        Scanner in = new Scanner(System.in);
        String userInput = in.nextLine();
        if (userInput.isEmpty()) {
            System.err.println("Invalid Last Name!");
            setLastName();
        } else {
            this.lastName = userInput.substring(0,1).toUpperCase() + userInput.substring(1).toLowerCase();
        }
    }

    private void setUserName() {
        this.userName = this.firstName + " " + this.lastName;
    }
}
