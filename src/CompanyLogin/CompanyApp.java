package CompanyLogin;

import java.util.Random;
import java.util.Scanner;

/**
 * CompanyApp : Class containing different methods and basic constructor for the CompanyApp.
 *
 * @author Harsh
 * @version 1
 *
 * Date Created: 28-11-2018
 * Last Updated: 28-11-2018
 *
 */

public class CompanyApp {

    /* Variables */
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
    private String email;
    final private String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz123456789!@%$";
    final private String companySuffix = "company.com";

    /**
     * Constructor which runs methods to create employee account
     */
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
        setPassword();
        setAlternativeEmail();
        System.out.println(alternativeEmail);
        setMailboxCapacity();
        System.out.println(mailboxCapacity);
        setSecurityQuestion();
        System.out.println(securityQuestion);
        System.out.println(securityAnswer);
    }

    /**
     * Print the message, takes input from user, validate it and set it to the variable firstName
     */
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

    /**
     * Print the message, takes input from user, validate it and set it to the variable lastName
     */
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

    /**
     * Concatenate first and last name and creates userName
     */
    private void setUserName() {
        this.userName = this.firstName + " " + this.lastName;
    }

    /**
     * Print list of different options, takes input from user, validates the input and set the department for the employee
     */
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

    /**
     * Concat firstName, lastName, companySuffix to create email ID for employee
     */
    private void generateEmail() {
        String output;
        if (this.department.equals("")) {
            output = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() +
                    "@" + this.companySuffix;
        } else {
            output = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() +
                    "@" + this.department + "." + this.companySuffix;
        }
        this.email = output;
        System.out.println(output);
    }

    /**
     * Ask user to enter the length of the password, validate it and set the value for further process
     */
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

    /**
     * Provides user two different options (Random Generate Or Custom Generated Password), validates the input an drun according methods
     */
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

    /**
     * Use setPasswordLength() method, creates random generated password
     */
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

    /**
     * Use setPasswordLength() method, creates custom generated password
     */
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

    /**
     * Ask for alternative email, validates user input and set the alternativeEmail
     */
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

    /**
     * Ask for mailbox Capacity, validates it and sets the mailboxCapacity
     */
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

    /**
     * Ask user for setting up security question
     */
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

    /**
     * Ask users, validates input and set securityAnswer
     */
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

    /**
     * Ask user to enter password, authenticate it and return boolean value
     * @return true if authentication is successful; false otherwise
     */
    private boolean passwordAuthentication() {
        System.out.print("Enter current Password : ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput.equals(this.password);
    }

    /**
     * If User enters wrong password, prints two option to the user, Retrieve Password or change the password
     */
    private void passwordOption() {
        if (!passwordAuthentication()){
            System.out.println("Choose your Code \n" +
                    "  1 - Retrieve Password\n" +
                    "  2 - Change Password\n" +
                    "  3 - To Exit");
            while (true) {
                Scanner scanner = new Scanner(System.in);
                int userInput = scanner.nextInt();
                if (userInput < 1 || userInput > 3) {
                    System.err.println("Invalid Input!!");
                    passwordOption();
                } else {
                    switch (userInput) {
                        case 1:
                            retrievePassword();
                            break;
                        case 2:
                            changePassword();
                            break;
                        default:
                            return;
                    }
                }
            }
        }
    }

    /**
     * Runs securityQuestionAuthentication, if it is successful, prints employee current password
     */
    private void retrievePassword() {
        System.out.println("RETRIEVE PASSWORD PROCESS : ");
        //Security Question Authentication
        if (securityQuestionAuthentication()) {
            System.out.println("Your Current Password : " + this.password);
        } else {
            System.err.println("WRONG ANSWER!");
            retrievePassword();
        }
    }

    /**
     * Runs securityQuestionAuthentication, if it is successful, runs setPassword method
     */
    private void changePassword() {
        System.out.println("CHANGE PASSWORD PROCESS : ");
        if (securityQuestionAuthentication()) {
            setPassword();
        } else {
            System.err.println("WRONG ANSWER!");
            changePassword();
        }
    }

    /**
     * ask user for security question, and take input of security answer, if it matches, return true
     * @return true if Successful; false otherwise
     */
    private boolean securityQuestionAuthentication() {
        System.out.println("SECURITY QUESTION");
        System.out.println(this.securityQuestion);
        System.out.print("ANSWER : ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput.equalsIgnoreCase(this.securityAnswer);
    }

    /**
     * ask user for email(username), and take input, if it matches, return true
     * @return true if Successful; false otherwise
     */
    private boolean userNameAuthentication() {
        System.out.println("USER AUTHENTICATION");
        System.out.print("Enter email : ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput.equals(this.email);
    }

    /**
     * Runs passwordAuthentication, if it is true, it runs setSecurityQuestion and setSecurityAnswer
     */
    private void changeSecurityQuestion() {
        if (passwordAuthentication()) {
            setSecurityQuestion();
            setSecurityAnswer();
        } else {
            System.err.println("INVALID PASSWORD");
            passwordOption();
            changeSecurityQuestion();
        }
    }

    /**
     * Print out short hand information
     * @return formatted employee data
     */
    private String getInformation() {
        return "First Name : " + this.firstName +
                "\nLast Name  : " + this.lastName +
                "\nMailBox Capacity : " + this.mailboxCapacity;
    }

    /**
     * runs passwordAuthentication, if successful, prints full data
     * @return formatted employee full data
     */
    private String getFullInformation() {
        String output = "";
        if (passwordAuthentication()) {
            output = "First Name : " + this.firstName +
                    "\nLast Name  : " + this.lastName +
                    "\nMailBox Capacity : " + this.mailboxCapacity +
                    "\nPassword : " + this.password +
                    "\nAlternative Email : " + this.alternativeEmail +
                    "\nSecurity Question : " + this.securityQuestion +
                    "\nSecurity Answer : " + this.securityAnswer;
        }else {
            System.err.println("AUTHENTICATION FAILED!");
            passwordOption();
            getFullInformation();
        }
        return output;
    }

    /**
     * runs passwordAuthentication, if it is successful, updates the mailbox Capacity
     */
    private void updateMailboxCapacity() {
        if (passwordAuthentication()) {
            setMailboxCapacity();
        } else {
            System.err.println("INVALID PASSWORD!");
            passwordOption();
            updateMailboxCapacity();
        }
    }

    /**
     * runs passwordAuthentication, if it is successful, updates the alternative Email
     */
    private void updateAlternativeEmail() {
        if (passwordAuthentication()) {
            setAlternativeEmail();
        } else {
            System.err.println("INVALID PASSWORD!");
            passwordOption();
            updateAlternativeEmail();
        }
    }

    /**
     * Login method which runs userNameAuthentication and passwordAuthentication, if it is successful log in the user
     */
    public void logIn(){
        System.out.println("Login Method");
        if (userNameAuthentication()) {
            if (passwordAuthentication()) {
                logInInstruction();
            } else {
                System.err.println("AUTHENTICATION FAILED!");
                passwordOption();
                logIn();
            }
        } else {
            System.err.println("Invalid Email!!");
            logIn();
        }
    }

    /**
     * Prints the list of different commands available, and also takess input from user and run appropriate methods
     */
    private void logInInstruction() {
        System.out.println("Choose your Code : \n" +
                "  1 - To get Information\n" +
                "  2 - To get Full Information\n" +
                "  3 - To Change Password\n" +
                "  4 - To Change Security Question\n" +
                "  5 - To Update Mail Box Capacity\n" +
                "  6 - To Update Alternative Email\n" +
                "  7 - To Log Out");
        while (true) {
            System.out.print("Enter Your Choice : ");
            Scanner scanner = new Scanner(System.in);
            int userInput = scanner.nextInt();

            if (userInput < 1 || userInput > 7) {
                System.err.println("Invalid Input!!");
                return;
            } else {

                switch (userInput) {
                    case 1:
                        //get Info Method
                        System.out.println(getInformation());
                        break;
                    case 2:
                        //get Full info
                        System.out.println(getFullInformation());
                        break;
                    case 3:
                        //change pass
                        changePassword();
                        break;
                    case 4:
                        //change security que
                        changeSecurityQuestion();
                        break;
                    case 5:
                        //update mailbox capacity
                        updateMailboxCapacity();
                        break;
                    case 6:
                        //update alternaative email
                        updateAlternativeEmail();
                        break;
                    default:
                        return;
                }
            }
        }
    }
}