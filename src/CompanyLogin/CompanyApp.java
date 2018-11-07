package CompanyLogin;

import java.util.Random;
import java.util.Scanner;

public class CompanyApp {

    private int passwordLength;
    private int mailboxCapacity;
    private String firstName;
    private String lastName;
    private String userName;
    private String department;
    private String password;
    private String alternativeEmail;
    private String securityQuestion;
    private String securityAnswer;
    final private String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz123456789!@%$";
    final private String companySuffix = "company.com";

    // TODO: 07-11-2018 ADD GETTERS IF NEEDED

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
//        randomPasswordGenerator();
//        System.out.println(password);
        setPassword();
        setAlternativeEmail();
        System.out.println(alternativeEmail);
        setMailboxCapacity();
        System.out.println(mailboxCapacity);
        setSecurityQuestion();
        System.out.println(securityQuestion);
        System.out.println(securityAnswer);
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

    private void setPasswordLength() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Password Length : ");
        int userInput;
        userInput = scanner.nextInt();

        if (userInput > 0 && userInput < 25) {
            this.passwordLength = userInput;
        } else {
            System.err.println("Invalid Input! Enter only between 0 and 25.");
            setPasswordLength();
        }
    }

    private void setPassword() {
        System.out.println("Choose Your Code : \n" +
                "  1 - Random Generated Password\n" +
                "  2 - Custom Generated Password");

        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();

        if (userInput == 1) {
            //Random Password Method
            randomPasswordGenerator();
            System.out.println(password);
        } else if (userInput == 2) {
            //Custom Password Method
            customPasswordGenerator();
            System.out.println(password);
        } else {
            System.err.println("Invalid Input!!");
            setPassword();
        }
    }

    private void randomPasswordGenerator() {

        setPasswordLength();

        char[] password = new char[this.passwordLength];

        for (int i = 0; i < this.passwordLength; i++) {
            Random random = new Random();
            int randomNumber = random.nextInt(passwordSet.length());
            password[i] = this.passwordSet.charAt(randomNumber);
        }

        this.password = new String(password);

    }

    private void customPasswordGenerator() {

        setPasswordLength();

        boolean isValid = true;
        System.out.print("Enter Your Password : ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        if (userInput.length() == this.passwordLength) {
            for (int i = 0; i < this.passwordLength; i++) {
                char passswordCharacter = userInput.charAt(i);
                if (this.passwordSet.indexOf(passswordCharacter) == -1 ) {
                    isValid = false;
                    System.err.println("Invalid Password!");
                    break;
                }
            }
        } else {
            System.err.println("Out of Password Length!!");
            customPasswordGenerator();
        }
        if (isValid) {
            this.password = userInput;
        } else {
            System.err.println("Enter characters from A to Z, a to z , 0 to 9 or !, @, %, $.");
            customPasswordGenerator();
        }


    }

    private void setAlternativeEmail() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Alternative Email : ");
        String userInput = scanner.nextLine();

        if (userInput.contains("@") && userInput.contains(".com")) {
            this.alternativeEmail = userInput;
        } else {
            System.err.println("Invalid Email!");
            setAlternativeEmail();
        }
    }

    private void setMailboxCapacity() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Mailbox Capacity : ");
        int userInput = scanner.nextInt();

        if (userInput >= 50 && userInput <= 1000) {
            this.mailboxCapacity = userInput;
        } else {
            System.err.println("Invalid Input! Enter between 50 to 1000!");
            setMailboxCapacity();
        }
    }

    private void setSecurityQuestion() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Security Question : ");
        String userInput = scanner.nextLine();
        if (userInput.isEmpty()){
            setSecurityQuestion();
        } else {
            this.securityQuestion = userInput;
            setSecurityAnswer();
        }

    }

    private void setSecurityAnswer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Security Answer : ");
        String userInput = scanner.nextLine();
        if (userInput.isEmpty()){
            setSecurityAnswer();
        } else {
            this.securityAnswer = userInput;
        }
    }
}
