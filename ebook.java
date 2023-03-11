import java.util.Scanner;

public class ebook {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] bookTitles = { "Java Programming", "Python Programming", "Web Development" };
        double[] bookPrices = { 10.99, 12.99, 14.99 };
        int bookChoice;
        int quantity;
        double subtotal;
        double tax = 0.07;
        double total;
        boolean addBook;
        String choice;

        do {
            // Display book options
            System.out.println("Welcome to the Ebook Purchase System!");
            System.out.println("Please select a book to purchase:");
            for (int i = 0; i < bookTitles.length; i++) {
                System.out.println((i + 1) + ". " + bookTitles[i] + " - $" + bookPrices[i]);
            }

            // Check if user wants to add a book
            System.out.print("Do you want to add a new book? (Y/N): ");
            String addBookChoice = input.next();
            if (addBookChoice.equalsIgnoreCase("Y")) {
                addBook = true;
            } else {
                addBook = false;
            }

            // Add a new book if requested
            if (addBook) {
                System.out.print("Enter the title of the new book: ");
                String newTitle = input.next();
                System.out.print("Enter the price of the new book: ");
                double newPrice = input.nextDouble();
                String[] newBookTitles = new String[bookTitles.length + 1];
                double[] newBookPrices = new double[bookPrices.length + 1];
                for (int i = 0; i < bookTitles.length; i++) {
                    newBookTitles[i] = bookTitles[i];
                    newBookPrices[i] = bookPrices[i];
                }
                newBookTitles[newBookTitles.length - 1] = newTitle;
                newBookPrices[newBookPrices.length - 1] = newPrice;
                bookTitles = newBookTitles;
                bookPrices = newBookPrices;
            }

            // Get book choice from user
            System.out.print("Enter your choice (1-" + bookTitles.length + "): ");
            bookChoice = input.nextInt() - 1;

            // Get quantity from user
            System.out.print("Enter the quantity: ");
            quantity = input.nextInt();

            // Calculate subtotal, tax, and total
            subtotal = bookPrices[bookChoice] * quantity;
            total = subtotal + (subtotal * tax);

            // Display receipt
            System.out.println("\nReceipt:");
            System.out.println("Book Title: " + bookTitles[bookChoice]);
            System.out.println("Quantity: " + quantity);
            System.out.println("Subtotal: $" + subtotal);
            System.out.println("Tax: $" + (subtotal * tax));
            System.out.println("Total: $" + total);

            // Ask user if they want to make another purchase
            System.out.print("Do you want to make another purchase? (Y/N): ");
            choice = input.next();
        } while (choice.equalsIgnoreCase("Y"));

        System.out.println("Thank you for using the Ebook Purchase System!");
    }

}