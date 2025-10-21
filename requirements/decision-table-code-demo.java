import java.util.Scanner;

public class decision-table-code-demo{
    pulic static void main(String[] args){
        boolean isLoggedIn, isAdmin, itemsInCart, shippingAndPaymentInfoPresent;
        boolean browse, checkout, confirmOrder, runReport, promteAccount;
        Scanner scan = new Scanner(System.in);
        char input = ' ';
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

        if (!isLoggedIn){
            browse = checkout = confirmOrder = runReport = promoteAccount = false;
        }
        else{
            browse = true;
            if (!itemsInCart){
                checkout = confirmOrder = false;
            }
            else{
                checkout = true
                        if (!shippingAndPaymentInfoPresent){
                            confirmOrder = false;
                        }
                        else{
                            confirmOrder = true;
                        }
            }
            if (!isAdmin){
                runReport = promteAccount = false;
            }
            else {
                runReport = promteAccount = true;
            }
        }

        System.out.println("The system will allow the user to perform the following tasks:\n" +
                "Browse and Add Items to Cart: " + browse + "\n" +
                "Checkout: " + checkout +"\n" +
                "Confirm Order: " + confirmOrder + "\n" +
                "Run and Export Sales Reports: " + runReport + "\n" +
                "Promote User Accounts into Admin Accounts: " + promteAccount);

    }
}