package se.lexicon;

import java.util.Scanner;

public class CafeApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // customer name
        System.out.print("Welcome! What is your name? ");
        String customerName = scanner.nextLine();

        // menu
        System.out.println("Hi " + customerName + "! Here is our menu:");

        System.out.println("==============================");
        System.out.println("       Lexicon Cafe");
        System.out.println("==============================");
        System.out.println("1. Espresso         25 SEK");
        System.out.println("2. Cappuccino       35 SEK");
        System.out.println("3. Latte            40 SEK");
        System.out.println("4. Croissant        30 SEK");
        System.out.println("5. Sandwich         55 SEK");
        System.out.println("==============================");

        // choose item
        System.out.print("Enter item number (1-5): ");
        int itemNumber = scanner.nextInt();

        // quantity
        System.out.print("How many? ");
        int quantity = scanner.nextInt();

        scanner.nextLine();

        // membership
        System.out.print("Loyalty member? (yes/no): ");
        String member = scanner.nextLine();

        String itemName = "";
        double price = 0;

        // choose item price
        switch (itemNumber) {

            case 1:
                itemName = "Espresso";
                price = 25;
                break;

            case 2:
                itemName = "Cappuccino";
                price = 35;
                break;

            case 3:
                itemName = "Latte";
                price = 40;
                break;

            case 4:
                itemName = "Croissant";
                price = 30;
                break;

            case 5:
                itemName = "Sandwich";
                price = 55;
                break;

            default:
                System.out.println("Invalid choice");
                return;
        }

        // subtotal
        double subtotal = price * quantity;

        // discount
        double discount = 0;

        if (member.equalsIgnoreCase("yes")) {

            discount = subtotal * 0.15;

        } else if (subtotal > 150) {

            discount = subtotal * 0.10;
        }

        // after discount
        double afterDiscount = subtotal - discount;

        // VAT
        double vat = afterDiscount * 0.12;

        // total
        double total = afterDiscount + vat;

        // receipt
        System.out.println();
        System.out.println("==============================");
        System.out.println("      LEXICON CAFE");
        System.out.println("==============================");

        System.out.println("Customer  : " + customerName);
        System.out.println("Item      : " + itemName + " x " + quantity);

        System.out.printf("Subtotal  : %.2f SEK%n", subtotal);

        if (discount > 0) {

            System.out.printf("Discount  : -%.2f SEK%n", discount);
        }

        System.out.printf("VAT       : %.2f SEK%n", vat);

        System.out.println("------------------------------");

        System.out.printf("TOTAL     : %.2f SEK%n", total);

        System.out.println("==============================");
        System.out.println("Thank you, " + customerName + "!");
        System.out.println("==============================");

        scanner.close();
    }
}