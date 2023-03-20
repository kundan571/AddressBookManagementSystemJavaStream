package com.addressbook;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dictionary {

    static AddressBookMain addressBookMain = new AddressBookMain();
    static Dictionary dictionary = new Dictionary();
    public static Map<String, AddressBookMain> addressHashMap = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    // Method to add multiple Address book
    public void addAddressBook() {
        AddressBookMain addressBookMain = new AddressBookMain();
        System.out.println("Enter address book name:");
        String newBookName = scanner.next();
        addressHashMap.put(newBookName, addressBookMain);
    }

    // Method to show address book
    public void displayAddressBook() {
        for (String addressBookName : addressHashMap.keySet()) {
            System.out.println(addressBookName);
        }
    }

    // Method to select address book and perform operation
    public void selectAddressBook() throws Exception {
        displayAddressBook();
        System.out.println("Select the name of address book:");
        String addressBookName = scanner.next();
        for (String key : addressHashMap.keySet()) {
            if (addressBookName.equals(key)) {
                addressHashMap.get(addressBookName).menu();
            } else {
                System.out.println("Provided name not found");
            }
        }
    }

    // Method to delete address book
    public void deleteAddressBook() {
        displayAddressBook();
        System.out.println("Select the address book you want to delete:");
        String delBookName = scanner.next();
        for (String key : addressHashMap.keySet()) {
            if (delBookName.equals(key)) {
                addressHashMap.remove(delBookName);
            } else {
                System.out.println("Address book not found");
            }
        }
    }

    void viewPersonDetailsByState() {
        System.out.println("Enter the name of state:");
        String stateName = scanner.next();
        addressHashMap.get(addressBookMain).personDetails.stream()
                .filter(state -> state.state.equals(stateName))
                .forEach(found -> System.out.println("First Name: " + found.firstName + ", Phone_Number: " + found.phoneNumber));
    }
<<<<<<< HEAD:src/main/java/com/addressbook/Dictionary.java
    public static void main(String[] args) {
=======

    public static void main(String[] args) throws Exception {
>>>>>>> UC13-FileReadAndWrite:src/com/addressbook/Dictionary.java
        int choice = 1;
        while (choice != 0) {
            System.out.println("Enter 1 to Add");
            System.out.println("Enter 2 to View:");
            System.out.println("Enter 3 to Delete");
            System.out.println("Enter 4 to Select");
            System.out.println("Enter 5 to view person name and phoneNumber");
            System.out.println("Enter 0 to Exit:");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    dictionary.addAddressBook();
                    break;
                case 2:
                    dictionary.displayAddressBook();
                    break;
                case 3:
                    dictionary.deleteAddressBook();
                    break;
                case 4:
                    dictionary.selectAddressBook();
                    break;
                case 5:
                    dictionary.viewPersonDetailsByState();
                    break;
            }
        }
        System.out.println("Goodbye From AddressBook Dictionary");
    }
}
