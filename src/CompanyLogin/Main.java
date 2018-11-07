package CompanyLogin;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int userStartChoice;


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
                    break;
                case 2:
                    System.out.println("Sign Up");
                    CompanyApp employee = new CompanyApp();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("\nEnter Valid Input!!");
            }
        }

    }
}
