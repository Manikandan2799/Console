package contactmanagement;

import java.util.ArrayList;
import java.util.Collection;

import java.util.Scanner;

public class ContactDetails {

	Scanner in = new Scanner(System.in);
	ArrayList<Contact> contacts = new ArrayList<Contact>();
	Contact contact1 = new Contact(1, "Monisha", "8099090909", "15-06-1998", "monisha@gmail.com", "peravurani");
	Contact contact2 = new Contact(2, "Ananthi", "9080788991", "02-11-1998", "ananthi@gmail.com", "pattukkottai");
	Contact contact3 = new Contact(3, "Madhu", "9090980990", "11-08-1997", "madhu@gmail.com", "thanjavur");
	Contact contact4 = new Contact(4, "Preethi", "8890890900", "28-04-1998", "preethi@gmail.com", "peravurani");
	Contact contact5 = new Contact(5, "Pavithra", "9009944439", "06-06-1998", "pavithra@gmail.com", "pattukkottai");
	Contact contact6 = new Contact(6, "Mani", "9090807012", "06-06-1999", "manik@gmail.com", "pattukkottai");

	public ContactDetails() {
		contacts.add(contact1);
		contacts.add(contact2);
		contacts.add(contact3);
		contacts.add(contact4);
		contacts.add(contact5);
		contacts.add(contact6);

	}

	public void process() {
		ContactDetails contacts = new ContactDetails();
		int choice;
		do {
			System.out.println("********Contact Management********");
			System.out.println(
					"\n1.Add Contact\n2.View Contact\n3.Update Contact\n4.Delete Contact\n5.View All Contact\n6.Exit");
			System.out.println("Enter your choice:");
			choice = in.nextInt();

			switch (choice) {
			case 1:
				contacts.addContact();
				break;
			case 2:
				contacts.viewContact();
				break;
			case 3:
				contacts.updateContact();
				break;
			case 4:
				contacts.deleteContact();
				break;
			case 5:
				contacts.viewAllContact();
				break;
			case 6:
				System.out.println("Thankyou");
				break;
			}

		} while (choice != 6);
	}

	public void addContact() {

		System.out.println("Enter the id:");
		int id = in.nextInt();
		System.out.println("Enter the name:");
		String name = in.next();
		System.out.println("Enter the contact Number:");
		String contactNumber = in.next();
		System.out.println("Enter the DOB:");
		String DOB = in.next();
		System.out.println("Enter the emailId:");
		String emailid = in.next();
		System.out.println("Enter the address:");
		String address = in.next();
		System.out.println("Contact added successfully...");
		Contact contact_add = new Contact(id, name, contactNumber, DOB, emailid, address);
		contacts.add(contact_add);
		System.out.println(contacts);
	}

	public void viewContact() {
		System.out.println("Enter the id:");
		int id = in.nextInt();
		for (Contact view : contacts) {
			if (view.getId() == id)
				System.out.println(view.getName() + "\n" + view.getContactNumber() + "\n" + view.getDOB() + "\n"
						+ view.getEmailId() + "\n" + view.getAddress());
		}
	}

	public void updateContact() {

		System.out.println("Enter the id:");
		int id = in.nextInt();
		System.out.println("Enter the name:");
		String name = in.next();
		System.out.println("enter the contact Number:");
		String contactNumber = in.next();
		for (Contact contact : contacts) {
			if (contact != null && id == contact.getId()) {
				contact.setName(name);
				contact.setContactNumber(contactNumber);
				System.out.println(contact);
				break;
			}
		}
	}

	public void deleteContact() {
		System.out.println("Enter the id:");
		int id = in.nextInt();
		for (Contact contact : contacts) {
			if (contact.getId() == id) {
				contacts.remove(id);
				break;
			}
		}
		System.out.println("Contact removed successfully...");
	}

	public void viewAllContact() {

		for (Contact contact : contacts) {
			System.out.println(contact);
		}
	}
}
