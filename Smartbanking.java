import java.util.Scanner;

public class Smartbanking{
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        final String CLEAR = "\033[H\033[2J";
        final String COLOR_BLUE_BOLD = "\033[34;1m";
        final String COLOR_RED_BOLD = "\033[31;1m";
        final String COLOR_GREEN_BOLD = "\033[33;1m";
        final String RESET = "\033[0m";

        final String DASHBOARD = "👷 Welcome To Smart Banking System";
        final String ADD_ACCOUNT = "➕ Add New Account";
        final String DEPOSIT = "➕ Deposit";
        final String WITHDRAW = "➕ Withdraw";
        final String TRANSFER = "➕ Transfer";
        final String PRINT_BALANCE = "🖨 Print Balance";
        final String DELETE_ACCOUNT = "❌ Remove Exisiting Account";

        final String ERROR_MSG = String.format("\t%s%s%s\n", COLOR_RED_BOLD, "%s", RESET);
        final String SUCCESS_MSG = String.format("\t%s%s%s\n", COLOR_GREEN_BOLD, "%s", RESET);

        String[] account = new String[0];
        int[] ID = new int[0];
        int[] DEPO = new int[0];
        String screen = DASHBOARD;

        do {
            final String APP_TITLE = String.format("%s%s%s",
                    COLOR_BLUE_BOLD, screen, RESET);

            System.out.println(CLEAR);
            System.out.println("\t" + APP_TITLE + "\n");

            switch (screen) {
                case DASHBOARD:
                    System.out.println("\t[1]. Open New Account");
                    System.out.println("\t[2]. Deposit Money");
                    System.out.println("\t[3]. Withdraw Money");
                    System.out.println("\t[4]. Transfer Money");
                    System.out.println("\t[5]. Check Account Balance");
                    System.out.println("\t[6]. Drop Existing Account");
                    System.out.println("\t[7]. Exit");
                    System.out.print("\tEnter an option to continue: ");

                    int option = scanner.nextInt();
                    scanner.nextLine();

                    switch (option) {
                        case 1:
                            screen = ADD_ACCOUNT;
                            break;
                        case 2:
                            screen = DEPOSIT;
                            break;
                        case 3:
                            screen = WITHDRAW;
                            break;
                        case 4:
                            screen = TRANSFER;
                            break;
                        case 5:
                            screen = PRINT_BALANCE;
                            break;
                        case 6:
                            screen = DELETE_ACCOUNT;
                            break;
                        case 7:
                            System.out.println(CLEAR);
                            System.exit(0);
                        default:
                    }
                    break;

                case ADD_ACCOUNT:
                    int id = account.length;
                    String name;
                    int deposit;
                    boolean valid;

                    // set ID
                    System.out.printf("\tNew A/C ID: SDB-%05d \n", (account.length + 1));

                    int[] newId = new int[account.length + 1];
                    for (int i = 0; i < ID.length; i++) {
                        newId[i] = ID[i];

                    }
                    newId[newId.length - 1] = id;
                    ID = newId;

                    // Name Validation
                    do {
                        valid = true;
                        System.out.print("\tEnter A/C Name: ");
                        name = scanner.nextLine().strip();
                        if (name.isBlank()) {
                            System.out.printf(ERROR_MSG, "A/C name can't be empty");
                            valid = false;
                            continue;
                        }
                        for (int i = 0; i < name.length(); i++) {
                            if (!(Character.isLetter(name.charAt(i)) ||
                                    Character.isSpaceChar(name.charAt(i)))) {
                                System.out.printf(ERROR_MSG, "Invalid A/C name");
                                valid = false;
                                break;
                            }
                        }
                    } while (!valid);

                    String[] newAcNames = new String[account.length + 1];
                    for (int i = 0; i < account.length; i++) {
                        newAcNames[i] = account[i];

                    }
                    newAcNames[newAcNames.length - 1] = name;
                    account = newAcNames;

                    // // Initial Deposit

                    do {
                        valid = true;
                        System.out.println();
                        System.out.print("\tEnter your Deposited Amount Here :");
                        deposit = scanner.nextInt();
                        scanner.nextLine();

                        if (deposit > 5000) {
                            System.out.println("\tInitial Deposit :" + deposit);
                            System.out.println();
                            
                        } else {

                            System.out.printf(ERROR_MSG, "Not Sufficient Amount In Your A/C");
                            valid=false;
                            continue;
                        }
                    } while (!valid);

                    int[] NewDepo = new int[DEPO.length + 1];
                    for (int i = 0; i < DEPO.length; i++) {

                        NewDepo[i] = DEPO[i];
                    }
                    NewDepo[NewDepo.length - 1] = deposit;
                    DEPO = NewDepo;

                    System.out.printf(SUCCESS_MSG,
                                    String.format("%s:%s has been saved successfully", account.length, name));
                    System.out.print("\tDo you want to continue adding (Y/n)? ");
                    if (scanner.nextLine().strip().toUpperCase().equals("Y"))
                        continue;
                    ;
                    screen = DASHBOARD;
                    break;
            }
        } while (true);

    }
}



                    
                
     