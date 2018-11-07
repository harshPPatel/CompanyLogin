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
    private String email;
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
        this.email = output;
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

    private boolean passwordAuthentication() {
        System.out.print("Enter current Password : ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput.equals(this.password);
    }

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

    private void changePassword() {
        System.out.println("CHANGE PASSWORD PROCESS : ");
        if (securityQuestionAuthentication()) {
            setPassword();
        } else {
            System.err.println("WRONG ANSWER!");
            changePassword();
        }
    }

    private boolean securityQuestionAuthentication() {
        System.out.println("SECURITY QUESTION");
        System.out.println(this.securityQuestion);
        System.out.print("ANSWER : ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput.equalsIgnoreCase(this.securityAnswer);
    }

    private boolean userNameAuthentication() {
        System.out.println("USER AUTHENTICATION");
        System.out.print("Enter email : ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput.equals(this.email);
    }

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

    private String getInformation() {
        return "First Name : " + this.firstName +
                "\nLast Name  : " + this.lastName +
                "\nMailBox Capacity : " + this.mailboxCapacity;
    }

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

    private void updateMailboxCapacity() {
        if (passwordAuthentication()) {
            setMailboxCapacity();
        } else {
            System.err.println("INVALID PASSWORD!");
            passwordOption();
            updateMailboxCapacity();
        }
    }

    private void updateAlternativeEmail() {
        if (passwordAuthentication()) {
            setAlternativeEmail();
        } else {
            System.err.println("INVALID PASSWORD!");
            passwordOption();
            updateAlternativeEmail();
        }
    }

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