package com.addressbook;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMain extends ContactPerson {

    public static AddressBookMain newPersonDetails = new AddressBookMain();
    static ArrayList<ContactPerson> personDetails = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public void menu() {
        int menu;
        System.out.println("Enter 1 to add contact:");
        System.out.println("Enter 2 to edit contact:");
        System.out.println("Enter 0 to exit:");
        menu = scanner.nextInt();
        while (menu != 0) {
            switch (menu) {
                case 1 -> newPersonDetails.addContact();
                case 2 -> newPersonDetails.editDetails();
            }
            System.out.println("Enter 1 to add contact:");
            System.out.println("Enter 2 to edit contact:");
            System.out.println("Enter 0 to exit:");
            menu = scanner.nextInt();
        }
        System.out.println("Goodbye from addressBook");
    }

    public void addContact() {

        // Taking user input
        System.out.println("Enter first name: ");
        newPersonDetails.setFirstName(scanner.next());
        System.out.println("Enter last name: ");
        newPersonDetails.setLastName(scanner.next());
        System.out.println("Enter Address: ");
        newPersonDetails.setAddress(scanner.next());
        System.out.println("Enter city: ");
        newPersonDetails.setCity(scanner.next());
        System.out.println("Enter state: ");
        newPersonDetails.setCity(scanner.next());
        System.out.println("Enter zip: ");
        newPersonDetails.setZip(scanner.nextInt());
        System.out.println("Enter phone_number: ");
        newPersonDetails.setPhoneNumber(scanner.nextLong());
        System.out.println("Enter email: ");
        newPersonDetails.setEmail(scanner.next());
        // Adding details in address book
        personDetails.add(newPersonDetails);
        System.out.println(personDetails);
    }

    // Edit the contact with name
    public void editDetails() {
        System.out.println("Enter first name you want to edit:");
        String choiceName = scanner.next();
        // AddressBookMain newPersonDetails = new AddressBookMain();
        if (choiceName.equals(newPersonDetails.getFirstName())) {
            System.out.println("Edit first name:");
            newPersonDetails.setFirstName(scanner.next());
            System.out.println("Edit last name:");
            newPersonDetails.setLastName(scanner.next());
            System.out.println("Edit address:");
            newPersonDetails.setAddress(scanner.next());
            System.out.println("Edit city:");
            newPersonDetails.setCity(scanner.next());
            System.out.println("Edit state:");
            newPersonDetails.setState(scanner.next());
            System.out.println("Edit zip:");
            newPersonDetails.setZip(scanner.nextInt());
            System.out.println("Edit Phone_Number:");
            newPersonDetails.setPhoneNumber(scanner.nextLong());
            System.out.println("Edit gmail:");
            newPersonDetails.setEmail(scanner.next());

            //  personDetails.add(newPersonDetails);
            System.out.println(personDetails);
        } else {
            System.out.println("Please Enter A Valid Name:");
        }
    }

    public static void main(String[] args) {
        newPersonDetails.menu();
    }
}
