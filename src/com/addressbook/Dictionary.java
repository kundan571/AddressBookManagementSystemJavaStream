package com.addressbook;

import java.util.HashMap;
import java.util.Scanner;

public class Dictionary {

    static Dictionary dictionary = new Dictionary();
    HashMap<String, AddressBookMain> addressHashMap = new HashMap<>();
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
    public void selectAddressBook() {
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

    public static void main(String[] args) {
        int flag = 0;
        while (flag == 0) {
            System.out.println("Enter 1 to add");
            System.out.println("Enter 2 to view:");
            System.out.println("Enter 3 to delete");
            System.out.println("Enter 4 to Select");
            System.out.println("Enter 5 to exit:");
            int choice = scanner.nextInt();
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
                    flag = 1;
                    System.out.println("Goodbye from address book");
            }
        }
    }
}
