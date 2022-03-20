package com.StreamApi;

import java.util.Scanner;

public class AddressBook {

	public static void main(String[] args) {
		System.out.println("----------Phone Book-----------");
		Scanner sc = new Scanner(System.in);
		Services add = new Services();				//created objects
		while (true) {					
			System.out.println("Enter to avail services: ");
			System.out.println(" 1: To add contact \n 2: To edit existing contact \n 3: To delete contact \n 4: To display contact list \n 5: To Exit");

			int choices = sc.nextInt();

			switch (choices) {
			case 1:
				try {
					add.numberOfTimes();
				} catch (Exception e) {
					
				}
				break;
			case 2:
				add.edit();
				break;
			case 3:
				add.delete();
				break;
			case 4:
				add.display();
				break;
			case 5:
				sc.close();
				return;
			}
		}

	}

}
