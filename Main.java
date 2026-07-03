import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ContactManager manager = new ContactManager();

        int choice;

        do {

            System.out.println("\n==================================");
            System.out.println("   CONTACT MANAGEMENT SYSTEM");
            System.out.println("==================================");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Update Contact");
            System.out.println("5. Delete Contact");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("Invalid input. Enter a number: ");
                sc.next();
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    manager.addContact();
                    break;

                case 2:
                    manager.viewContacts();
                    break;

                case 3:
                    manager.searchContact();
                    break;

                case 4:
                    manager.updateContact();
                    break;

                case 5:
                    manager.deleteContact();
                    break;

                case 6:
                    System.out.println("\nThank you for using Contact Management System!");
                    break;

                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }

        } while (choice != 6);

        sc.close();
    }
}