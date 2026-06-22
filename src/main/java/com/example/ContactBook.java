package com.example;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;

public class ContactBook {
    private ArrayList<Contact> contacts;
    private File file;
    private Gson gson;

    public ContactBook() {
        gson = new Gson();
        file = new File("src/main/java/com/example/contacts.json");
        this.readFile();

    }

    public ArrayList<Contact> readFile() {
        try (Reader reader = new FileReader(file)) {

            Contact[] contactsArray = gson.fromJson(reader, Contact[].class);

            if (contactsArray == null) {

                contacts = new ArrayList<Contact>();

            } else {

                contacts = new ArrayList<>(Arrays.asList(contactsArray));
            }

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        return contacts;
    }

    public void writeFile(ArrayList<Contact> contactList) {
        try (FileWriter writer = new FileWriter(file)) {
            gson.toJson(contactList, writer);
            System.out.println("Written to the file.");
        } catch (IOException e) {
            System.err.println("Error writing: " + e.getMessage());
        }
    }

    public void add(Contact contact) {
        contacts.add(contact);
        this.writeFile(contacts);
    }

    public void update(int index, Contact updatedContact) {
        contacts.set(index, updatedContact);
        this.writeFile(contacts);

    }

    public void delete(int index) {
        contacts.remove(index);
        this.writeFile(contacts);
    }
}