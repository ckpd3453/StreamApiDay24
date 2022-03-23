package com.StreamApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBookServices12 {
	/**
	 * creating person object of ServerBook12 class
	 */
	ServerBook12 person = new ServerBook12();
	/**
	 * Creating a List of ServerBook12 using ArrayList
	 */
	List<ServerBook12> contactDetailsList = new ArrayList<>();

	/**
	 * Declaring The Add Contact Method And Entering The Contact Details By Using
	 * Scanner Class And Printing The Contact Details Of Person
	 */
	public void addContact() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of contacts you want to enter");
		int number = scanner.nextInt();
		/**
		 * for loop will use if we enter the number of contacts that number of times the
		 * for loop will execute
		 */
		for (int i = 0; i < number; i++) {

			/**
			 * checking the duplicate contacts of person by contact first name because there
			 * is no Duplicate Entry of the same Person in a particular Address Book
			 */
			System.out.println("Enter the first name of person");
			String fName = scanner.next();
			/**
			 * if else condition is used to check the same person is exist or not
			 */
			if (fName.equals(person.getFirstName())) {
				System.out.println("The entered person is already exist. Enter new name");
			} else {
				System.out.println("Enter the contact details of person ");
				/**
				 * calling method wrireContact() to enter all the contact details
				 */
				writeContact();
				System.out.println("contact added Successfully");
			}
		}
	}

	/**
	 * created method writeContact() to create a new contacts to the AddressBook
	 */
	public void writeContact() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter First Name : ");
		String firstName = scanner.next();
		System.out.println("Enter Last Name : ");
		String lastName = scanner.next();
		System.out.println("Enter Address : ");
		String address = scanner.next();
		System.out.println("Enter City : ");
		String city = scanner.next();
		System.out.println("Enter State : ");
		String state = scanner.next();
		System.out.println("Enter ZipCode : ");
		int zipCode = scanner.nextInt();
		System.out.println("Enter Mobile Number : ");
		long mobileNumber = scanner.nextLong();
		System.out.println("Enter EmailId : ");
		String emailId = scanner.next();
		/**
		 * storing or adding all the ServerBook12 to the person
		 */
		person = new ServerBook12(firstName, lastName, address, city, state, zipCode, mobileNumber, emailId);
		ServerBook12List.add(person);
	}

	/**
	 * create method searchByName that is Ability to search Person across the
	 * multiple AddressBook by name
	 * 
	 * @param name -passing name
	 */
	public void searchByName(String name) {
		/**
		 * creating Stream from list of ServerBook12. Filter operation produces a new
		 * stream that contains elements of the original stream that pass a given
		 * test(specified by a Predicate). filter(),is a Intermediate operations return
		 * a new stream on which further processing can be done. here filter is used to
		 * search particular name of a person and the filtered stream is creates a list
		 * and will collect in a ServerBook12 using collector
		 */
		List<ServerBook12> collect = ServerBook12List.stream().filter(p -> p.getFirstName().equalsIgnoreCase(name))
				.collect(Collectors.toList());
		/**
		 * ForEach() method is used and it is a Terminal operations mark the stream as
		 * consumed, after which point it can no longer be used further.
		 */
		for (ServerBook12 contact : collect) {
			System.out.println("Search result: " + contact);
		}
	}

	/**
	 * create method searchByCity that is Ability to search Person across the
	 * multiple AddressBook by City
	 * 
	 * @param name -passing City name
	 */
	public void searchByCity(String city) {
		List<ServerBook12> collect = ServerBook12List.stream().filter(p -> p.getCity().equalsIgnoreCase(city))
				.collect(Collectors.toList());
		for (ServerBook12 contact : collect) {
			System.out.println("Search result: " + contact);
		}
	}

	/**
	 * create method searchByState that is Ability to search Person across the
	 * multiple AddressBook by State
	 * 
	 * @param name -passing State name
	 */
	public void searchByState(String state) {
		List<ServerBook12> collect = ServerBook12List.stream().filter(p -> p.getCity().equalsIgnoreCase(state))
				.collect(Collectors.toList());
		for (ServerBook12 contact : collect) {
			System.out.println("Search result: " + contact);
		}
	}

	/**
	 * Declaring The Count Contacts Method By City Name Using Java Streams To Count
	 * The Contacts By using City Name
	 * 
	 * @param cityName -passing the city name to count the contacts method
	 */
	public void countContactsByUsingCity(String cityName) {
		long count = 0;
		long count1 = ServerBook12List.stream().filter(g -> g.getCity().equalsIgnoreCase(cityName)).count();
		for (ServerBook12 contact : ServerBook12List) {
			count1 = count1 + count;
		}
		System.out.println("Contact List :" + count1);

	}

	/**
	 * Declaring Sort Method Sorting The Details Of Contact By Using Names Using
	 * Stream method
	 */
	public void sortByName() {
		List<ServerBook12> list = ServerBook12List.stream().collect(Collectors.toList());
		list.stream().sorted((g1, g2) -> ((String) g1.getFirstName()).compareTo(g2.getFirstName()))
				.forEach(contact -> System.out.println(contact.getFirstName() + " " + contact.getLastName()));
	}

	/**
	 * Declaring Sort Method Sorting The Details Of Contact By City
	 */
	public void sortByCity() {
		List<ServerBook12> list = ServerBook12List.stream().collect(Collectors.toList());
		list.stream().sorted((g1, g2) -> ((String) g1.getCity()).compareTo(g2.getCity()))
				.forEach(contact -> System.out.println(contact.getFirstName() + " " + contact.getLastName()));
	}

	/**
	 * Declaring The Edit Contact Method To Edit The Details Of Contact Edit By
	 * Using FirstName If First Name Is Match The Contact Will Edit
	 */
	public void editContact() {
		System.out.println("Enter firstname of contact you want edit");
		Scanner scanner = new Scanner(System.in);
		String editName = scanner.next();
		for (int i = 0; i < ServerBook12List.size(); i++) {
			String name = ServerBook12List.get(i).getFirstName();
			if (name.equalsIgnoreCase(editName)) {
				System.out.println("Enter name is exit. you can edit the details");
				while (true) {
					System.out.println(
							"Enter\n 1. To edit all details\n 2. To edit certain detail\n 3. for previous menu");
					int choose = scanner.nextInt();
					switch (choose) {
					case 1:
						ServerBook12List.remove(i);
						writeContact();
						break;
					case 2:
						while (true) {
							System.out.println(
									"Enter\n 1. for First Name\n 2. for Last Name\n 3. for City\n 4. for State\n"
											+ " 5. for Zip Code\n 6. for Phone\n 7. forEmail\n 8. for previous menu");
							int option = scanner.nextInt();
							switch (option) {
							case 1:
								System.out.println("Enter new First Name");
								String newFirstName = scanner.next();
								ServerBook12List.get(i).setFirstName(newFirstName);
								break;
							case 2:
								System.out.println("Enter new Last Name");
								String newLastName = scanner.next();
								ServerBook12List.get(i).setLastName(newLastName);
								break;
							case 3:
								System.out.println("Enter new City");
								String newCity = scanner.next();
								ServerBook12List.get(i).setCity(newCity);
								break;
							case 4:
								System.out.println("Enter new State");
								String newState = scanner.next();
								ServerBook12List.get(i).setState(newState);
								break;
							case 5:
								System.out.println("Enter new ZipCode");
								int newZip = scanner.nextInt();
								ServerBook12List.get(i).setZipNo(newZip);
								break;
							case 6:
								System.out.println("Enter new Phone Number");
								int newPNumber = scanner.nextInt();
								ServerBook12List.get(i).setPhoneNo(newPNumber);
								break;
							case 7:
								System.out.println("Enter new Email");
								String newEmail = scanner.next();
								ServerBook12List.get(i).setEmail(newEmail);
								break;
							case 8:
								return;
							default:
								System.out.println("Entered choice is incorrect!.. please enter correct choice");
							}
						}
					case 3:
						return;
					default:
						System.out.println("Entered choice is incorrect!.. please enter correct choice");
					}
				}
			} else {
				System.out.println("enter name not exist");
			}
		}
	}

	/**
	 * Declaring Delete Contact Method To delete The Details Of Contact Delete By
	 * Using FirstName If First Name Is Match Then Contact Will Delete
	 */
	public void deleteContact() {
		System.out.println("Enter the first name of contact you want to delete");
		Scanner scanner = new Scanner(System.in);
		String deleteName = scanner.next();
		for (int i = 0; i < ServerBook12List.size(); i++) {
			if (deleteName.equalsIgnoreCase(ServerBook12List.get(i).getFirstName())) {
				ServerBook12List.remove(i);
				System.out.println("contact delete successfully");
			} else {
				System.out.println("enter name dose not exit");
			}
		}
	}

	/**
	 * create method viewByOptions() is used to view the options by searching the
	 * person using option like name, city, state and from previous menu
	 */
	public void viewByOptions() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Enter\n 1. By name\n 2. By city\n 3. By state\n 4. for previous menu");
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1:
				System.out.println("Enter name: ");
				String name = scanner.nextLine();
				searchByName(name);
				break;
			case 2:
				System.out.println("Enter city: ");
				String city = scanner.nextLine();
				searchByCity(city);
				break;
			case 3:
				System.out.println("Enter state: ");
				String state = scanner.nextLine();
				searchByState(state);
				break;
			case 4:
				return;
			default:
				System.out.println("Entered choice is incorrect!.. please enter correct choice");
			}
		}
	}
}
