import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class ContactManager {

    private ArrayList<Contact> contacts = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private final String FILE_NAME = "contacts.txt";

    // Constructor
    public ContactManager() {
        loadContacts();
    }

    // Add Contact
    public void addContact() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        Contact contact = new Contact(name, phone, email);
        contacts.add(contact);

        saveContacts();

        System.out.println("Contact added successfully!");
    }

    // View Contacts
    public void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }

        System.out.println("\n----- Contact List -----");

        for (Contact contact : contacts) {
            System.out.println(contact);
            System.out.println("------------------------");
        }
    }

    // Search Contact
    public void searchContact() {
        System.out.print("Enter name to search: ");
        String name = sc.nextLine();

        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.println("Contact Found:");
                System.out.println(contact);
                return;
            }
        }

        System.out.println("Contact not found.");
    }

    // Update Contact
    public void updateContact() {
        System.out.print("Enter name to update: ");
        String name = sc.nextLine();

        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {

                System.out.print("Enter New Name: ");
                contact.setName(sc.nextLine());

                System.out.print("Enter New Phone: ");
                contact.setPhone(sc.nextLine());

                System.out.print("Enter New Email: ");
                contact.setEmail(sc.nextLine());

                saveContacts();

                System.out.println("Contact updated successfully!");
                return;
            }
        }

        System.out.println("Contact not found.");
    }

    // Delete Contact
    public void deleteContact() {
        System.out.print("Enter name to delete: ");
        String name = sc.nextLine();

        for (int i = 0; i < contacts.size(); i++) {

            if (contacts.get(i).getName().equalsIgnoreCase(name)) {

                contacts.remove(i);

                saveContacts();

                System.out.println("Contact deleted successfully!");

                return;
            }
        }

        System.out.println("Contact not found.");
    }

    // Save Contacts to File
    public void saveContacts() {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Contact contact : contacts) {

                writer.write(contact.getName() + "," +
                             contact.getPhone() + "," +
                             contact.getEmail());

                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error saving contacts.");
        }
    }

    // Load Contacts from File
    public void loadContacts() {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length == 3) {

                    Contact contact = new Contact(data[0], data[1], data[2]);

                    contacts.add(contact);
                }
            }

        } catch (IOException e) {
            System.out.println("Error loading contacts.");
        }
    }
}