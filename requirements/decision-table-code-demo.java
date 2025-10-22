import java.util.Scanner;

public class decision-table-code-demo{
    public static void main(String[] args){
        boolean uniqueUsername = false;
        boolean longPassword = false;
        boolean isLoggedIn = false;
        boolean isAdmin = false;
        boolean itemsInCart = false;
        boolean shippingAndPaymentInfoPresent = false;
        boolean browse = false;
        boolean confirmOrder = false;
        boolean runReport = false;
        boolean promoteAccount = false;
        boolean login = false;
        boolean checkout = false;

        Scanner scan = new Scanner(System.in);
        char input = ' ';

        System.out.print("Is the user's username unique? (y/n): ");
        input = scan.nextLine().charAt(0);
        if (input == 'y' || input == 'Y'){
            uniqueUsername = true;
        }
        System.out.print("Does the user's password have at least 6 characters? (y/n): ");
        input = scan.nextLine().charAt(0);
        if (input == 'y' || input == 'Y'){
            longPassword = true;
        }
        System.out.print("Is the user logged in? (y/n): ");
        input = scan.nextLine().charAt(0);
        if (input == 'y' || input == 'Y'){
            isLoggedIn = true;
        }
        System.out.print("Is the user an admin? (y/n): ");
        input = scan.nextLine().charAt(0);
        if (input == 'y' || input == 'Y'){
            isAdmin = true;
        }
        System.out.print("Does the user have items in their cart? (y/n): ");
        input = scan.nextLine().charAt(0);
        if (input == 'y' || input == 'Y'){
            itemsInCart = true;
        }
        System.out.print("Has the user entered their shipping and payment information? (y/n): ");
        input = scan.nextLine().charAt(0);
        if (input == 'y' || input == 'Y'){
            shippingAndPaymentInfoPresent = true;
        }

        if (uniqueUsername && longPassword){
            login = true;
            if (isLoggedIn){
                browse = true;
                if (itemsInCart){
                    checkout = true;
                    if (shippingAndPaymentInfoPresent){
                        confirmOrder = true;
                    }
                }
                if (isAdmin){
                    runReport = promoteAccount = true;
                }
            }
        }

        System.out.println("The system will allow the user to perform the following tasks:\n" +
                "Login: " + login + "\n" +
                "Browse and Add Items to Cart: " + browse + "\n" +
                "Checkout: " + checkout +"\n" +
                "Confirm Order: " + confirmOrder + "\n" +
                "Run and Export Sales Reports: " + runReport + "\n" +
                "Promote User Accounts into Admin Accounts: " + promoteAccount);

    }
}