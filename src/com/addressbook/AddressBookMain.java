package com.addressbook;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class AddressBookMain extends ContactPerson {

    public static AddressBookMain newPersonDetails = new AddressBookMain();
    static ArrayList<ContactPerson> personDetails = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public void menu() {
        int menu;
        System.out.println("Enter 1 to add contact:");
        System.out.println("Enter 2 to edit contact:");
        System.out.println("Enter 3 to delete contact");
        System.out.println("Enter 0 to exit:");
        menu = scanner.nextInt();
        while (menu != 0) {
            switch (menu) {
                case 1:
                    newPersonDetails.addContact();
                    break;

                case 2:
                    newPersonDetails.editDetails();
                    break;
                case 3:
                    newPersonDetails.deleteDetails();
                    break;
            }
            System.out.println("Enter 1 to add contact:");
            System.out.println("Enter 2 to edit contact:");
            System.out.println("Enter 3 to delete contact");
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
        newPersonDetails.setPhoneNumber(scanner.next());
        System.out.println("Enter email: ");
        newPersonDetails.setEmail(scanner.next());
        // Adding details in address book
        personDetails.add(new ContactPerson(newPersonDetails.getFirstName(), newPersonDetails.getLastName(), newPersonDetails.getAddress(),
                newPersonDetails.getCity(), newPersonDetails.getState(), newPersonDetails.getZip(), newPersonDetails.getPhoneNumber(), newPersonDetails.getEmail()));
        personDetails.forEach(System.out::println);
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
            newPersonDetails.setPhoneNumber(scanner.next());
            System.out.println("Edit gmail:");
            newPersonDetails.setEmail(scanner.next());

            //  personDetails.add(newPersonDetails);
            personDetails.forEach(System.out::println);
        } else {
            System.out.println("Please Enter A Valid Name:");
        }
    }

    public void deleteDetails() {
        System.out.println("Enter the name you want to delete:");
        String choiceName = scanner.next();
        Iterator<ContactPerson> iterator = personDetails.iterator();
        int flag = 0;
        while (iterator.hasNext()) {
            ContactPerson delObj = iterator.next();
            if (choiceName.equals(delObj.getFirstName())) {
                iterator.remove();
                flag = 1;
                personDetails.forEach(System.out::println);
            }
        }
        if (flag == 1) {
            System.out.println("Contact deleted:");
        } else {
            System.out.println("Contact not found:");
        }


    }

//    public static void main(String[] args) {
//        newPersonDetails.menu();
//    }
}
