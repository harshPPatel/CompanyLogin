package CompanyLogin;

import java.util.Scanner;

public class CompanyApp {

    private String firstName;
    private String lastName;
    private String userName;

    public CompanyApp() {

        setFirstName();
        System.out.println(firstName);
//        setLastName();
//        System.out.println(lastName);

    }

    public void setFirstName() {
        System.out.print("Enter First Name : ");
        Scanner in = new Scanner(System.in);
        String userInput = in.nextLine();
        this.firstName = userInput.substring(0,1).toUpperCase() + userInput.substring(1);
    }

    public void setLastName() {
        System.out.print("Enter Last Name : ");
        Scanner in = new Scanner(System.in);
        String userInput = in.nextLine();
        this.lastName = userInput.substring(0,1).toUpperCase() + userInput.substring(1);
    }
}
