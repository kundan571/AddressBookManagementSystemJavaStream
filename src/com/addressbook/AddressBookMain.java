package com.addressbook;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMain extends ContactPerson {

    public void addContact() {
        ArrayList<AddressBookMain> personDetails = new ArrayList<>();
        AddressBookMain newpersonDetails = new AddressBookMain();
        // Taking user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first name: ");
        newpersonDetails.setFirstName(scanner.nextLine());
        System.out.println("Enter last name: ");
        newpersonDetails.setLastName(scanner.nextLine());
        System.out.println("Enter Address: ");
        newpersonDetails.setAddress(scanner.nextLine());
        System.out.println("Enter city: ");
        newpersonDetails.setCity(scanner.nextLine());
        System.out.println("Enter state: ");
        newpersonDetails.setCity(scanner.nextLine());
        System.out.println("Enter zip: ");
        newpersonDetails.setZip(scanner.nextInt());
        System.out.println("Enter phone_number: ");
        newpersonDetails.setPhoneNumber(scanner.nextLong());
        System.out.println("Enter email: ");
        newpersonDetails.setEmail(scanner.next());
        // Adding details in address book
        personDetails.add(newpersonDetails);
        System.out.println(personDetails);
    }
}
