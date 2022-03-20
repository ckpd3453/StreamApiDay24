package com.StreamApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Services {
	ArrayList<ServerBook> contacts = new ArrayList<ServerBook>();
	Scanner s = new Scanner(System.in);

	public void numberOfTimes() throws Exception {
		System.out.println("Enter the number of contacts to add");
		int number = s.nextInt();
		for (int i = 1; i <= number; i++) {
			
			checkDuplicate();
		}
	}
	public void checkDuplicate() 
	{
		System.out.println("Enter the first name: ");
		String name = s.next();
		int duplicate = 0; // will increment the duplicate if found multiple contacts with same name
		for (ServerBook contact1 : contacts) 
		{
			if (contact1.getFirstName().equals(name)) {
	  
				duplicate++; System.out.println("Sorry this name is already used...\n"+contact1 + "\n Please Enter the different contact name....");
				checkDuplicate();
			}
	  } 
		if(duplicate == 0)
		{
			addPerson(name); 
		}
	}
	 

	public void addPerson(String name) {

		
		String firstName = name;

		System.out.println("Enter the last name: ");
		String lastName = s.next();

		System.out.println("Enter the address: ");
		String address = s.next();

		System.out.println("Enter the city: ");
		String city = s.next();

		System.out.println("Enter the state: ");
		String state = s.next();

		System.out.println("Enter the zip code: ");
		int zipNo = s.nextInt();

		System.out.println("Enter the phoneNo name");
		Long phoneNo = s.nextLong();

		System.out.println("Enter the email: ");
		String email = s.next();

		ServerBook newContact = new ServerBook(firstName, lastName, address, city, state, zipNo, phoneNo, email);
		contacts.add(newContact);
	}

	public void display() {

		System.out.println(contacts);
	}

	public ServerBook findContact() { // to find the contacts
		System.out.println("\n Enter the first name of the contact to edit: ");
		String name = s.next();
		int duplicate = 0; // will increment the duplicate if found multiple contacts with same name
		ServerBook temp = null;

		for (ServerBook contact : contacts) {

			if (contact.getFirstName().equals(name)) {

				duplicate++;
				temp = contact;
			}
		}
		if (duplicate == 1) {
			return temp;

		} else if (duplicate > 1) {
			System.out.print(" There are multiple contacts with given name.\n Please enter their email id: ");
			String email = s.next();
			for (ServerBook contact : contacts) {
				if (contact.getFirstName().equals(name) && contact.getCity().equals(email)) {
					return contact;
				}
			}
		} else {
			System.out.println("No contact with the given first name. Please enter the correct first name");
			findContact();
		}
		return temp;
	}

	public void edit() {
		ServerBook contact = findContact();
		System.out.println(
				"1: To edit first name \n 2: To edit lastName \n 3: To edit address \n 4: To edit city \n 5: To edit state \n 6: To edit zip code \n 7: To edit Phone no. \n 8: To edit email ");
		int choice = s.nextInt();

		switch (choice) {
		case 1:
			System.out.println("Enter new first name:");
			String newName = s.next();
			contact.setFirstName(newName);
			System.out.println("New name updated");
			break;
		case 2:
			System.out.println("Enter new last name:");
			String lName = s.next();
			contact.setLastName(lName);
			System.out.println("New name updated");
			break;
		case 3:
			System.out.println("Enter new address:");
			String newadd = s.next();
			contact.setAddress(newadd);
			System.out.println("New address updated");
			break;
		case 4:
			System.out.println("Enter new city:");
			String newcity = s.next();
			contact.setCity(newcity);
			System.out.println("New city updated");
			break;
		case 5:
			System.out.println("Enter new state");
			String newstate = s.next();
			contact.setState(newstate);
			System.out.println("New state updated");
			break;
		case 6:
			System.out.println("Enter new Zip code:");
			int newZip = s.nextInt();
			contact.setZipNo(newZip);
			System.out.println("New Zip code updated");
			break;
		case 7:
			System.out.println("Enter new phone no:");
			Long newph = s.nextLong();
			contact.setPhoneNo(newph);
			System.out.println("New phone no. updated");
			break;
		case 8:
			System.out.println("Enter new email");
			String newemail = s.next();
			contact.setEmail(newemail);
			System.out.println("New email updated");
			break;
		}
		System.out.println("Contacts Updated: " + contact);
	}

	public void delete() {
		ServerBook contact = findContact();
		contacts.remove(contact);
		System.out.println("Updated Phone Book: \n" + contacts);
	}

}
