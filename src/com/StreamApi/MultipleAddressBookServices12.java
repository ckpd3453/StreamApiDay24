package com.StreamApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MultipleAddressBookServices12 {
	/**
	 * Java HashMap class implements the Map interface which allows us to store key
	 * and value pair, where keys should be unique.
	 */
	Map<String, AddressBookServices12> AddressBookServices12Map = new HashMap<>();

	/**
	 * created method addAddressBookServices12() to add a new values in AddressBookServices12
	 */
	public void addAddressBookServices12() {
		System.out.println("Enter Name of new Address Book: ");
		Scanner scanner = new Scanner(System.in);
		String bookName = scanner.next();
		if (AddressBookServices12Map.containsKey(bookName)) {
			System.out.println("Address book with this name exists, Enter new name.");
			addAddressBookServices12();
		} else {
			AddressBookServices12 AddressBookServices12 = new AddressBookServices12();
			AddressBookServices12Map.put(bookName, AddressBookServices12);
			System.out.println("press 1 if you want to add another book or press any key to exit.");
			int newBook = scanner.nextInt();
			if (newBook == 1) {
				addAddressBookServices12();
			}
		}
	}

	/**
	 * create method AddressBookServices12Functions() to edit ,delete the contact in
	 * addresbook
	 */
	public void AddressBookServices12Functions() {
		System.out.println("Enter the name of Address book to add, edit or delete the contact.");
		Scanner scanner = new Scanner(System.in);
		String bookName = scanner.nextLine();
		if (AddressBookServices12Map.containsKey(bookName)) {
			AddressBookServices12Map.get(bookName);
			System.out.println("Enter book is present choose the options below to do certain function");
			while (true) {
				System.out.println("Enter\n 1. add Contact\n 2. edit contact\n 3. delete contact\n 4. previous menu");
				int choice = scanner.nextInt();
				switch (choice) {
				case 1:
					AddressBookServices12Map.get(bookName).addContact();
					break;
				case 2:
					AddressBookServices12Map.get(bookName).editContact();
					break;
				case 3:
					AddressBookServices12Map.get(bookName).deleteContact();
					break;
				case 4:
					return;
				default:
					System.out.println("Entered choice is incorrect!.. please enter correct choice");
				}
			}
		}
	}

	/**
	 * create method deleteBook to delete the name of the AddressBookServices12 to delete
	 */
	public void deleteBook() {
		System.out.println("Enter the name of Address book to delete.");
		Scanner scanner = new Scanner(System.in);
		String bookName = scanner.next();
		if (AddressBookServices12Map.containsKey(bookName)) {
			AddressBookServices12Map.remove(bookName);
		} else {
			System.out.println("No book found");
		}
	}

	/**
	 * create method printBook to see if AddressBookServices12 is present in a program
	 */
	public void printBook() {
		System.out.println("These are AddressBookServices12s in present program.");
		for (Map.Entry<String, AddressBookServices12> entry : AddressBookServices12Map.entrySet()) {
			System.out.println(entry.getKey() + "[]");
		}
	}

	/**
	 * create method printContactsInBook() that prints the contacts ina a book
	 */
	public void printContactsInBook() {
		for (Map.Entry<String, AddressBookServices12> entry : AddressBookServices12Map.entrySet()) {
			System.out.println("The contacts in the Book of < " + entry.getKey() + " > are!...");
			System.out.println(entry.getValue().contactDetailsList);
		}
	}

}
