/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author danah
 */
import java.util.*;
public class Phonebook {
public static void main(String args[]) {
Scanner input = new Scanner (System.in);	
int choice= -1;
LinkedList clist= new LinkedList();
EventList Elist=new EventList();
System.out.println("Welcome to the Linked List Phonebook!");
do {
	input.nextLine();
	System.out.println("Please choose an option:");
	System.out.println("1. Add a contact");
	System.out.println("2. Search for a contact");
	System.out.println("3. Delete a contact");
	System.out.println("4. Schedule an event");
	System.out.println("5. Print event details");
	System.out.println("6. Print contacts by first name");
	System.out.println("7. Print all events alphabetically");
	System.out.println("8. Exit\n");
	System.out.print("Enter your choice:");
	choice= input.nextInt();
        input.nextLine();
        
switch(choice) {
    case 1:
      input.nextLine();
      System.out.print("Enter the contact's name: ");
      String name= input.nextLine();
      System.out.print("Enter the contact's phone number: ");
      String phoneNumber= input.nextLine();
      System.out.print("Enter the contact's email address: ");
      String email= input.nextLine();
      System.out.print("Enter the contact's address: ");
      String address= input.nextLine();
      System.out.print("Enter the contact's birthday: ");
      String birthday= input.nextLine(); 
      System.out.print("Enter any notes for the contact: ");
      String notes= input.nextLine();
      input.nextLine();
      clist.addContact(new Contact(name,phoneNumber,email,address,birthday,notes));
      break; 
    case 2:
        input.nextLine();
        System.out.println("Enter search criteria:");
        System.out.println("1. Name\n" +
        "2. Phone Number\n" +
        "3. Email Address\n" +
        "4. Address\n" +
        "5. Birthday");
        input.nextLine();
        System.out.print("Enter your choice: ");
        int criteria= input.nextInt();
        String str="";
        input.nextLine();
        if(criteria==1){
        input.nextLine();
        System.out.print("Enter The contact's name: ");
        str=input.nextLine();;
        input.nextLine();
        clist.searchContact(str, criteria);
        }
        if(criteria==2){
        input.nextLine();
        System.out.print("Enter The contact's number: ");
        str=input.nextLine();
        clist.searchContact(str, criteria);
        }
        if(criteria==3){
        System.out.print("Enter The contact's email: ");
        str=input.nextLine();
        clist.searchContact(str, criteria);
        }
        if(criteria==4){
        System.out.print("Enter The contact's address: ");
        str=input.nextLine();
        clist.searchContact(str, criteria);
        }
        if(criteria==5){
        System.out.print("Enter The contact's birthday: ");
        str=input.nextLine();
        clist.searchContact(str, criteria);
        }
        break;
    case 3:
        input.nextLine();
        System.out.println("Enter Contact Name:");
        String Name= input.nextLine();
        EventList events=clist.deletContact(Name);
        if(events!=null){
            events.setCurrent(events.getHead());
            while(events.getCurrent()!=null){
                Elist.deletEvent(events.getCurrent().getData());
            }
        }
        break;
    case 4:
        input.nextLine();
        System.out.print("Enter event title:");
        String title= input.nextLine();
        System.out.print("Enter contact name:");
        String contactname= input.nextLine();
        System.out.print("Enter event date and time (MM/DD/YYYY HH:MM):");
        String Date= input.next();
        String time=input.next();
        System.out.print("Enter event location:");
        String location= input.next();
        Event e=new Event(title,Date,time,location,contactname);
        
        if(clist.AddEvent(e)){
            Elist.AddEvent(e);
        }
        else
            System.out.println("the contact isn't exist in the contact list!");
        break;
    case 5:
        input.nextLine();
        System.out.println("Enter search criteria:");
        System.out.println("1. contact name\n" +"2. Event tittle\n");
        System.out.print("Enter your choice: ");
        int n=input.nextInt();
        str="";
        if(n==1){
            input.nextLine();
            System.out.print("Enter The contact name");
            str=input.nextLine();
        }
        else if(n==2){
            input.nextLine();
            System.out.print("Enter the event title: ");
            str=input.nextLine();
        }
        Event event=Elist.Search(str, n);
        if(event!=null){
            System.out.print("Event found!\n");
            event.display();}
        break;    
    case 6:
        input.nextLine();
       System.out.print("Enter the first name: ");
       String fname=input.nextLine();
       clist.printFirstName(fname);
        break;
    case 7:
        
        Elist.printEvents();
        break;
    case 8:
        input.nextLine();
        System.out.print("Goodbye!");
        break;
}
}while(choice!=8);
}}


