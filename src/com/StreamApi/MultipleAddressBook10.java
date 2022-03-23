package com.StreamApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MultipleAddressBook10 {
	/**
	 * We have created a HashMap and taken the key String as addressBook name and the value as AddressBookServices9 for contacts.
	 */
	Map<String, AddressBookServices10> addressBookMap = new HashMap<>();
	List<ServerBook10> contacts = new ArrayList<ServerBook10>();
	Scanner scanner = new Scanner(System.in);

	/**
	 * 1. The method addAddressBook will add the address book key to the Map.
	 */
	public void addAddressBook() {
		System.out.println("Enter Name of new Address Book: ");
		Scanner scanner = new Scanner(System.in);
		String bookName = scanner.next();
		if (addressBookMap.containsKey(bookName)) {
			System.out.println("Address book with this name exists, Enter new name.");
			addAddressBook();
		} else {
			AddressBookServices10 addressBook = new AddressBookServices10();
			addressBookMap.put(bookName, addressBook); 
			System.out.println("Address Book " + bookName + " successfully added!!");
		}
	}

	/**
	 * 2. The method ServerBook9 will add the contact to the addressBook
	 */
	public void ServerBook9() {
		System.out.println("Enter the name of Address book to add the contact.");
		Scanner scanner = new Scanner(System.in);
		String newContact = scanner.nextLine();
		AddressBookServices10 addressBook = addressBookMap.get(newContact);
		if (addressBook == null) {
			System.out.println("No book found");

		} else {
			addressBookMap.get(newContact).ServerBook9();
		}
	}

	/**
	 * 3. The method editContact will edit the contacts in the address book
	 */
	public void editContactInBook() {
		System.out.println("Enter Name of Address Book you want to edit: ");
		Scanner scanner = new Scanner(System.in);
		String editBookName = scanner.next();
		if (addressBookMap.containsKey(editBookName)) {
			addressBookMap.get(editBookName).editContact();
		} else {
			System.out.println("AddressBook doesn't exist, Please enter correct name.");
			editContactInBook();
		}
	}

	/**
	 * 4. - Method to delete the addressBook
	 */
	public void deleteAddressBook() {
		System.out.println("Enter Name of Address Book you want to delete: ");
		Scanner scanner = new Scanner(System.in);
		String bookName = scanner.next();
		if (addressBookMap.containsKey(bookName)) { 
			addressBookMap.remove(bookName); 
		} else {
			System.out.println("AddressBook doesn't exist, Please enter correct name.");
			deleteAddressBook();
		}
	}

	/**
	 * 5. The method deleteContactInBook to delete the specific contact in the book
	 */
	public void deleteContactInBook() {
		System.out.println("Enter Name of Address Book you want to delete the contacts in it: ");
		Scanner scanner = new Scanner(System.in);
		String bookName = scanner.next();
		if (addressBookMap.containsKey(bookName)) {
			addressBookMap.get(bookName).deleteContact();
		} else {
			System.out.println("AddressBook doesn't exist, Please enter correct name.");
			deleteContactInBook();
		}
	}

	/*
	 * 6.- This method will print the AddressBook i.e keys in the Map
	 */
	public void printBook() {
		System.out.println("These are AddressBooks in program.");
		for (String i : addressBookMap.keySet()) {
			System.out.println(i);
		}
	}

	/*
	 * 2 We have used the get(key) metod to print the contacts.
	 */
	public void printContactsInBook() {
		for (String i : addressBookMap.keySet()) {
			System.out.println(i);
			System.out.println(addressBookMap.get(i).contacts);
		}
		System.out.println(" ");
	}

	/*
	 * 7. In this method we are searching the person by the city
	 */
	public void searchByCity() {

		System.out.println("Enter the name of the City to get the persons : ");
		String cityName = scanner.next();
		for (String i : addressBookMap.keySet()) {
			List<ServerBook10> arr = addressBookMap.get(i).contacts;
			arr.stream().filter(person -> person.getCity().equals(cityName))
					.forEach(person -> System.out.println(person.getFirstName()));
		}
	}

	/*
	 * In this method we are searching the person by the state
	 */
	public void searchByState() {

		System.out.println("Enter the name of the State to the get persons : ");
		String stateName = scanner.next();
		for (String i : addressBookMap.keySet()) {
			List<ServerBook10> arr = addressBookMap.get(i).contacts;
			arr.stream().filter(person -> person.getState().equals(stateName))
					.forEach(person -> System.out.println(person.getFirstName()));
		}
	}
	public void displayPeopleByRegion(HashMap<String, ArrayList<ServerBook10>> addressBookMap) {
		System.out.println("Enter the name of the region :");
		String regionName = scanner.next();
		
		addressBookMap.values().stream()
			    .map(region -> region.stream()
				.filter(person -> person.getState().equals(regionName) || person.getCity().equals(regionName)))
				.forEach(person -> person.forEach(personDetails -> System.out.println(personDetails)));
	}
	/**
	 * In this method we are displaying the number of person in the city or state.
	 */
	public void countPeopleByRegion(HashMap<String, ArrayList<ServerBook10>> listToDisplay) {

		System.out.println("Enter the name of the region :");
		String regionName = scanner.next();
		long countPeople = listToDisplay.values().stream()
				.map(region -> region.stream().filter(person -> person.getState().equals(regionName) || person.getCity().equals(regionName)))
				.count();
					
		System.out.println("Number of People residing in " + regionName+" are: "+countPeople+"\n");
		
	   }
}
