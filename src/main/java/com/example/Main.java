package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContactBook book = new ContactBook();
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        while (run) {

            System.out.println(
                    "Welcome! Please select an action: \n[1] View contacts\n[2] Add a contact\n[3] Update a contact\n[4] Delete a contact\n[5] Exit");

            int choice = scanner.nextInt();

            scanner.nextLine();

            if (choice == 1) {
                System.out.println("\n");
                for (Contact contact : book.readFile()) {
                    System.out.println(contact.getName() + " " + contact.getPhone() + " " + contact.getEmail());
                }

                System.out.println("\nPress anything to continue.");
                scanner.nextLine();

            } else if (choice == 2) {
                System.out.println("Name of new contact?");
                String name = scanner.nextLine();
                System.out.println("Phone number of new contact?");
                String phone = scanner.nextLine();
                System.out.println("Email of new contact?");
                String email = scanner.nextLine();
                book.add(new Contact(name, phone, email));
                System.out.println("Contact Added!\n");

            } else if (choice == 3) {
                System.out.println("\nWhich contact would you like to update?");
                ArrayList<Contact> contacts = book.readFile();
                for (int i = 0; i < contacts.size(); i++) {
                    Contact contact = contacts.get(i);
                    System.out.println(
                            "[" + (i + 1) + "] " + contact.getName() + " " + contact.getPhone()
                                    + " " + contact.getEmail());
                }

                choice = scanner.nextInt() - 1;
                scanner.nextLine();
                System.out.println("What is the updated name?");
                String name = scanner.nextLine();
                System.out.println("What is the updated phone number?");
                String phone = scanner.nextLine();
                System.out.println("What is the updated email?");
                String email = scanner.nextLine();
                book.update(choice, new Contact(name, phone, email));

            } else if (choice == 4) {
                System.out.println("\nWhich contact would you like to delete?");
                ArrayList<Contact> contacts = book.readFile();
                for (int i = 0; i < contacts.size(); i++) {
                    Contact contact = contacts.get(i);
                    System.out.println(
                            "[" + (i + 1) + "] " + contact.getName() + " " + contact.getPhone()
                                    + " " + contact.getEmail());
                }

                choice = scanner.nextInt() - 1;
                scanner.nextLine();
                book.delete(choice);
            } else if (choice == 5) {
                scanner.close();
                break;
            }

        }
    }
}