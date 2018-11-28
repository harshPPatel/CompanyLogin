package CompanyLogin;

import java.util.Scanner;

/**
 * Main : Contains main method, provides option of LogIn or SignUp to the user and use the CompanyApp Class
 *
 * @author Harsh
 * @version 1
 *
 * Date Created: 28-11-2018
 * Last Updated: 28-11-2018
 *
 */

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int userStartChoice;
        CompanyApp employee = null;


        while (true) {
            System.out.println("Choose Your Code : \n" +
                    "  1 - Log In\n" +
                    "  2 - Sign Up\n" +
                    "  3 - exit\n");
            System.out.print("Enter your code : ");
            userStartChoice = scanner.nextInt();

            switch (userStartChoice) {
                case 1:
                    System.out.println("Log In");
                    if (employee == null) {
                        System.err.println("No User Found!! Sign Up First.");
                        break;
                    } else {
                        employee.logIn();
                    }
                    break;
                case 2:
                    System.out.println("Sign Up");
                    employee = new CompanyApp();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("\nEnter Valid Input!!");
            }
        }

    }
}
