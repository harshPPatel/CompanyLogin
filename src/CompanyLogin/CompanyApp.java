package CompanyLogin;

import java.util.Scanner;

public class CompanyApp {

    private String firstName;
    private String lastName;
    private String userName;
    private String department;
    final private String companySuffix = "company.com";

    public CompanyApp() {

        setFirstName();
        System.out.println(firstName);
        setLastName();
        System.out.println(lastName);
        setUserName();
        System.out.println(userName);
        setDepartment();
        System.out.println(department);
        generateEmail();

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

    private void setDepartment() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose Your Code : \n" +
                         "  1 - Accounting\n" +
                         "  2 - Development\n" +
                         "  3 - Sales\n" +
                         "  4 - Design\n" +
                         "  5 - none");

        System.out.print("Enter Your Choice : ");
        int userInput = scanner.nextInt();

        if (userInput < 6 && userInput > 0) {
            switch (userInput) {
                case 1:
                    this.department = "acc";
                    break;
                case 2:
                    this.department = "dev";
                    break;
                case 3:
                    this.department = "sales";
                    break;
                case 4:
                    this.department = "design";
                    break;
                default:
                    this.department = "";
            }

        } else {
            System.err.println("Invalid Choice!!");
            setDepartment();
        }
    }

    private void generateEmail() {
        String output;
        if (this.department.equals("")) {
            output = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() +
                    "@" + this.companySuffix;
        } else {
            output = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() +
                    "@" + this.department + "." + this.companySuffix;
        }
        System.out.println(output);
    }
}
