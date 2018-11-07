package CompanyLogin;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

//        boolean isExit = false;
        Scanner scanner = new Scanner(System.in);
        int userStartChoice;

        System.out.println("Choose Your Code : \n" +
                           "  1 - Log In\n" +
                           "  2 - Sign Up");
        int i = 0;
        while (i == 0) {
            System.out.print("Enter your code : ");
            userStartChoice = scanner.nextInt();

            switch (userStartChoice) {
                case 1:
                    System.out.println("Log In");
                    i++;
                    break;
                case 2:
                    System.out.println("Sign Up");
                    CompanyApp employee = new CompanyApp();
                    i++;
                    break;
                default:
                    System.out.println("\nEnter Valid Input!!");
                    i = 0;
            }
        }

    }
}
