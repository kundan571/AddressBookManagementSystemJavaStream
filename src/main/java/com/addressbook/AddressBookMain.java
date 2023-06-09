package com.addressbook;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class AddressBookMain extends ContactPerson {

    public static AddressBookMain newPersonDetails = new AddressBookMain();
    public static ArrayList<ContactPerson> personDetails = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static File file1 = new File("AddressBookStore.txt");
    static File file2 = new File("AddressBookObj.txt");
    static ObjectInputStream objectInputStreamReader = null;
    static ObjectOutputStream objectOutputStream = null;
    static OutputStreamWriter outputStreamWriter = null;

    public void addContact() throws Exception {
        // Taking user input
        System.out.println("Enter first name: ");
        newPersonDetails.setFirstName(scanner.next());
        Optional<ContactPerson> ref_var = personDetails.stream()
                .filter(name -> getFirstName().equals(name.getFirstName())).findAny();
        if (ref_var.isPresent()) {
            System.out.println("Name already exist");
            return;
        }
        System.out.println("Enter last name: ");
        newPersonDetails.setLastName(scanner.next());
        System.out.println("Enter Address: ");
        newPersonDetails.setAddress(scanner.next());
        System.out.println("Enter city: ");
        newPersonDetails.setCity(scanner.next());
        System.out.println("Enter state: ");
        newPersonDetails.setState(scanner.next());
        System.out.println("Enter zip: ");
        newPersonDetails.setZip(scanner.nextInt());
        System.out.println("Enter phone_number: ");
        newPersonDetails.setPhoneNumber(scanner.next());
        System.out.println("Enter email: ");
        newPersonDetails.setEmail(scanner.next());
        // Adding details in address book
        personDetails.add(new ContactPerson(newPersonDetails.getFirstName(), newPersonDetails.getLastName(), newPersonDetails.getAddress(),
                newPersonDetails.getCity(), newPersonDetails.getState(), newPersonDetails.getZip(), newPersonDetails.getPhoneNumber(), newPersonDetails.getEmail()));

        //  writes the data
        objectOutputStream = new ObjectOutputStream(new FileOutputStream(file2));
        objectOutputStream.writeObject(personDetails);
        objectOutputStream.close();
        // readable format
        outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file1));
        outputStreamWriter.write(personDetails.toString());
        outputStreamWriter.close();
        personDetails.forEach(System.out::println);
    }
    // reads contacts from file
    public void readFile() {
        if (file1.isFile()) {
            try {
                objectInputStreamReader = new ObjectInputStream(new FileInputStream(file1));
                personDetails = (ArrayList<ContactPerson>) objectInputStreamReader.readObject();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
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

    // search by state
    void searchPersonDetails() {
        System.out.println("Enter the name of state:");
        String stateName = scanner.next();
        List<ContactPerson> ref_var = personDetails.stream()
                .filter(state -> state.getState().equals(stateName)).collect(Collectors.toList());
        for (ContactPerson contactPerson : ref_var) {
            System.out.println("Details are: " + contactPerson);
        }

    }

    // count by city method
    void countByCity() {
        System.out.println("Enter city name: ");
        String cityName = scanner.next();
        long countCity = personDetails.stream()
                .filter(City -> cityName.equals(City.getCity())).count();
        System.out.println("Number of person details by city: " + cityName + " -> " + countCity);
    }

    // count by state method
    void countByState() {
        System.out.println("Enter state name: ");
        String stateName = scanner.next();
        long countState = personDetails.stream().filter(state -> stateName.equals(state.getState())).count();
        System.out.println("Number of person details by state: " + stateName + " -> " + countState);
    }

    // Sort by alphabetical order by person name
    void sortByName() {
        System.out.println("Sorted Details are:!!");
        personDetails.stream().sorted(Comparator.comparing(ContactPerson::getFirstName))
                .forEach(System.out::println);
    }

    // sort person details by zip
    void sortByZip() {
        System.out.println("Sorted Details are:!!");
        personDetails.stream().sorted(Comparator.comparing(ContactPerson::getZip))
                .forEach(System.out::println);
    }

    // for menu
    public void menu() throws Exception {
        readFile();
        int menu = 1;
        while (menu != 0) {
            System.out.println("Enter 1 to add contact:");
            System.out.println("Enter 2 to edit contact:");
            System.out.println("Enter 3 to delete contact:");
            System.out.println("Enter 4 to Search contact:");
            System.out.println("Enter 5 to count person details by city:");
            System.out.println("Enter 6 to count person details by state:");
            System.out.println("Enter 7 to sort by name:");
            System.out.println("Enter 8 to sort by zip:");
            System.out.println("Enter 0 to exit:");
            menu = scanner.nextInt();
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
                case 4:
                    newPersonDetails.searchPersonDetails();
                    break;
                case 5:
                    newPersonDetails.countByCity();
                    break;
                case 6:
                    newPersonDetails.countByState();
                    break;
                case 7:
                    newPersonDetails.sortByName();
                    break;
                case 8:
                    newPersonDetails.sortByZip();
                    break;
            }
        }
        System.out.println("Good Bye from addressBook");
        System.out.println("Back To dictionary:!!");
    }
}
