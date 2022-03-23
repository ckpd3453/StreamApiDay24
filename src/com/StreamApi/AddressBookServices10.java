package com.StreamApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AddressBookServices10 {
	Scanner sc = new Scanner(System.in);
	String name;

	/*
	 * We have created a list of ContactPerson type and also a HashMap for multiple
	 * address book.
	 */
	List<ServerBook10> contacts = new ArrayList<ServerBook10>();
	Map<String, AddressBook10> addressBookMap = new HashMap<>();
	public static HashMap<String, ArrayList<ServerBook10>> personByCity  = new HashMap<String, ArrayList<ServerBook10>>();
	public static HashMap<String, ArrayList<ServerBook10>> personByState = new HashMap<String, ArrayList<ServerBook10>>();
	ServerBook10 person = new ServerBook10();

	/*
	 * In this method we are checking if the contacts added is duplicate or not with
	 * reference to the first name.
	 */
	public void duplicateCheck() {
		System.out.print(" Please enter the first name: ");
		name = sc.next();
		for (ServerBook10 i : contacts) {
			if (i.getFirstName().equals(name)) {
				System.out.println(" Given name already exists");
				return;
			}
		}
		addPerson();
	}

	/*
	 * We have created this class to take number of contacts from the user. We have
	 * used the For loop and called the check method.
	 */
	public void ServerBook9() {
		System.out.println("Enter the number of contacts you want to enter");
		int number = sc.nextInt();
		for (int i = 0; i < number; i++) {
			System.out.println("Enter the contact details of person ");
			duplicateCheck();
		}
	}

	/*
	 * 1.This method is to take the input from console and set the values of the
	 * contact.
	 */
	public void addPerson() {
		ServerBook10 person = new ServerBook10();
		Scanner scan = new Scanner(System.in);
		String firstName = name;

		System.out.print(" Please enter the last name: ");
		String lastName = scan.next();

		System.out.print(" Please enter the address: ");
		String address = scan.next();

		System.out.print(" Please enter the city: ");
		String city = scan.next();

		System.out.print(" Please enter the state: ");
		String state = scan.next();

		System.out.print(" Please enter the zip: ");
		int zip = scan.nextInt();

		System.out.print(" Please enter the phone number: ");
		Long phoneNumber = scan.nextLong();

		System.out.print(" Please enter the email: ");
		String email = scan.next();

		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setPhoneNo(phoneNumber);
		person.setEmail(email);
		person.setCity(city);
		person.setState(state);
		person.setZipNo(zip);
		contacts.add(person);

	}

	/*
	 * 2. We have created the findContact method
	 */
	public ServerBook10 findContact() {
		System.out.println("\n Enter the first name of the contact to edit: ");
		String name = sc.next();
		int duplicate = 0;
		ServerBook10 temp = null;
		for (ServerBook10 contact : contacts) {
			if (contact.getFirstName().equals(name)) {
				duplicate++;
				temp = contact;
			}
		}
		if (duplicate == 1) {
			return temp;

		} else if (duplicate > 1) {
			System.out.print(" There are multiple contacts with given name.\n Please enter their email id: ");
			String email = sc.next();
			for (ServerBook10 contact : contacts) {
				if (contact.getFirstName().equals(name) && contact.getEmail().equals(email)) {
					return contact;
				}
			}
		} else {
			System.out.println("No contact with the given first name. Please enter the correct first name");
			findContact();
		}
		return temp;
	}

	/*
	 * 2. The editContact method will edit the contact in the list.
	 */
	public void editContact() {

		ServerBook10 contact = findContact();

		System.out.println("Enter your choice to edit: " + "\n 1.Edit first name" + "\n 2.Edit last name"
				+ "\n 3.Edit address" + "\n 4.Edit city" + "\n 5.Edit state" + "\n 6.Edit zipcode"
				+ "\n 7.Edit phone number" + "\n 8.Edit email");

		int choice = sc.nextInt(); // with the help of setters setting the new details
		switch (choice) {
		case 1:
			System.out.println("Enter new first name");
			String newFirstName = sc.next();
			contact.setFirstName(newFirstName);
			System.out.println("new first name updated");

			break;
		case 2:
			System.out.println("Enter new last name");
			String newLastName = sc.next();
			contact.setLastName(newLastName);
			System.out.println("new last name updated");

			break;
		case 3:
			System.out.println("Enter new address");
			String newAddress = sc.next();
			contact.setAddress(newAddress);
			System.out.println("new newaddress updated");

			break;
		case 4:
			System.out.println("Enter new city");
			String newCity = sc.next();
			contact.setCity(newCity);
			System.out.println("new city updated");

			break;
		case 5:
			System.out.println("Enter new state");
			String newState = sc.next();
			contact.setState(newState);
			System.out.println("new state updated");

			break;
		case 6:
			System.out.println("Enter new zip code");
			int newZipCode = sc.nextInt();
			contact.setZipNo(newZipCode);
			System.out.println("new zip code updated");
			break;

		case 7:
			System.out.println("Enter new phone number");
			long newPhoneNumber = sc.nextLong();
			contact.setPhoneNo(newPhoneNumber);
			System.out.println("new phone number updated");

			break;

		case 8:
			System.out.println("Enter new email");
			String newEmail = sc.next();
			contact.setEmail(newEmail);
			System.out.println("new email updated");

			break;

		default:
			System.out.println("Please enter a number between 1 to 8 only...");
			break;
		}
		System.out.println("The contact after editing is : " + contact);

	}

	/*
	 * 3.Method display to list the contacts.
	 */
	public void displayContact() {
		System.out.println(contacts);
	}

	/*
	 * 4. Method delete to delete a specific contact.
	 */
	public void deleteContact() {
		ServerBook10 contact = findContact();
		if (contact == null) {
			System.out.println("No contact found with the given name");
			return;
		}
		contacts.remove(contact);
		System.out.println("The contact has been deleted from the Address Book");
	}

	public void addPersonToCity(ServerBook10 contact) {
		if (personByCity.containsKey(contact.getCity())) {
			personByCity.get(contact.getCity()).add(contact);
		}
		else {
			ArrayList<ServerBook10> cityList = new ArrayList<ServerBook10>();
			cityList.add(contact);
			personByCity.put(contact.getCity(), cityList);
		}
	}


	/*
	 *  In this method we are checking the person by state
	 */
	public void addPersonToState(ServerBook10 contact) {
		if (personByState.containsKey(contact.getState())) {			
			personByState.get(contact.getState()).add(contact);
		}
		else {
			ArrayList<ServerBook10> stateList = new ArrayList<ServerBook10>();
			stateList.add(contact);
			personByState.put(contact.getState(), stateList);
		}
	}
}
