/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author danah
 */
//This class will represent the phonebook application itself
import java.util.*;
public class Phonebook {
    
 /*one of the requiremnts is The Phonebook class should have methods for printing all contacts that share an event as well as all
contacts that share the first name. and we will lis them down below, but alos
we were required this " It should have a field for the linked list ADT that stores the contacts and methods for interacting with the list (e.g., adding,
searching, and deleting contacts). You will also need to schedule events and appointments with
contacts." b "fields" we assumed this was part of the main method interaction*/
    
    
    public static Scanner input = new Scanner (System.in);
    //field for storage:
    public static LinkedList clist= new LinkedList();
    public static EventList Elist=new EventList();
    
    
  // Print all contacts that share the first name (user implementation)
    public static void PrintContactsFirstName(){
       
        System.out.print("Enter the first name:");
        String fname = input.nextLine();
        
        if (clist.empty())
            System.out.println("No Contacts were found !");
        
        clist.findFirst();//move current to head
        for ( int i = 0 ; i < clist.getNumC(); i++)
        {
            String currentName = clist.retrieve().getName();
            String [] fName = currentName.split(" ");

            if (fName[0].compareToIgnoreCase(currentName) == 0)
               clist.retrieve().display();
            clist.findNext(); //traverse
        }
    }//end method
      
    
    
    
    //print contacts that share an event
public static void printIfSharedEvent(String eventTitle){
 clist.findFirst();
 for( int i =0; i< clist.getNumC() ; i++){
     if(clist.retrieve().getElist().searchEvent(eventTitle, 1)!=null)
         clist.retrieve().display();
 clist.findNext();
 }
}
    
public static void main(String args[]) {
	
int choice= -1;

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
        System.out.println("8. Print all contacts that share an event");
	System.out.println("9. Exit\n");
	System.out.print("Enter your choice:");
	choice= input.nextInt();
        input.nextLine();
        
switch(choice) {
    case 1://Add a contact
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
      if(clist.checkUniqueContact(name, phoneNumber))
      clist.addContact(new Contact(name,phoneNumber,email,address,birthday,notes));
      else
          System.out.println("Contact is not added because it's NOT unique");
      break; 
    case 2://Search for a contact
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
        Contact c;
        Contact[] contacts=null;
        input.nextLine();
        switch(criteria){
            case 1://by Name
                input.nextLine();
                System.out.print("Enter The contact's name: ");
                str=input.nextLine();;
                c=clist.SearchContact(str, criteria);
                if(c!=null){
                    System.out.print("Contact found!\n");
                    c.display();
                }
                break;
            case 2://by Phone Number
                input.nextLine();
                System.out.print("Enter The contact's number: ");
                str=input.nextLine();
                c=clist.SearchContact(str, criteria);
                if(c!=null){
                    System.out.print("Contact found!\n");
                    c.display();
                }
                break;
            case 3://by Email Address
                System.out.print("Enter The contact's email: ");
                str=input.nextLine();
                contacts=clist.searchContacts(str, criteria);
                break;
            case 4://by Address
                System.out.print("Enter The contact's address: ");
                str=input.nextLine();
                contacts=clist.searchContacts(str, criteria);
                break;
            case 5:// by Birthday
                System.out.print("Enter The contact's birthday: ");
                str=input.nextLine();    
                contacts=clist.searchContacts(str, criteria);
                break;
                }
                if(contacts!=null){
                    for(int i=0;i<contacts.length;i++)
                        contacts[i].display();
                }
        break;
    case 3://Delete a contact
        input.nextLine();
        System.out.println("Enter Contact Name:");
        String Name= input.nextLine();
        EventList events=clist.deletContact(Name);//return all events in contact
        if(events!=null){//deleted contact has event(s)
            events.deletcontact(Name);//delet contact for all events tha
            Elist.findFirst();
            while(!Elist.last()){
                if(Elist.retrieve().getNumOfContacts()==0)//
                    Elist.deletEvent(Elist.retrieve());//delet the event 
                Elist.findNext();    
            }
            if(Elist.retrieve().getNumOfContacts()==0)
                Elist.deletEvent(Elist.retrieve());
        }
        break;
    case 4://Schedule an event
        input.nextLine();
        System.out.print("Enter event title:");
        String title= input.nextLine();
        System.out.print("How Many contacts you want to add:");
        int numOfContacts=input.nextInt();
        Contact[] Contacts=new Contact[numOfContacts];
        int index=0;
        for(int i=0;i<numOfContacts;i++){
            Contact contact;
            do{
                input.nextLine();
                System.out.print("Enter contact name:");
                String contactname= input.nextLine();
                contact=clist.SearchContact(contactname, 1);//check if contact exist
                if(contact!=null)
                    Contacts[index++]=contact;
            }while(contact==null);     
        }
        System.out.print("Enter event date and time (MM/DD/YYYY HH:MM):");
        String Date= input.next();
        String time=input.next();
        System.out.print("Enter event location:");
        String location= input.next();
        boolean flag=false;
        Event e=new Event(title,Date,time,location,Contacts,numOfContacts);
        for(int i=0;i<numOfContacts;i++){//add event to each contact
        if(clist.addEventToaContact(Contacts[i],e))//no conflict
            flag=true;  
        }
        if(flag)
            Elist.addEvent(e);
        break;
    case 5://Print event details
        input.nextLine();
        System.out.println("Enter search criteria:");
        System.out.println("1. contact name\n" +"2. Event tittle\n");
        System.out.print("Enter your choice: ");
        int n=input.nextInt();
        str="";
        if(n==1){//by contact name
            input.nextLine();
            System.out.print("Enter The contact name:");
            str=input.nextLine();
        }
        else if(n==2){//by Event tittle
            input.nextLine();
            System.out.print("Enter the event title: ");
            str=input.nextLine();
        }
        Event event=Elist.searchEvent(str, n);
        if(event!=null){
            System.out.print("Event found!\n");
            event.display();}
        break;    
    case 6://Print contacts by first name
       input.nextLine();
       PrintContactsFirstName();
       //System.out.print("Enter the first name: ");
       //String fname=input.nextLine();
      // clist.printFirstName(fname);
        break;
    case 7://Print all events alphabetically
        Elist.printEvents();
        break;
    case 8://Print all contacts that share an event
        System.out.println("Enter event title: ");
        String eventtitle=input.nextLine();
        Event ev=Elist.searchEvent(eventtitle, 2);
        Contact[] Cont=ev.getContacts();
        for(int i=0;i<ev.getNumOfContacts();i++)
            Cont[i].display();
        break;
    case 9://Exit
        input.nextLine();
        System.out.print("Goodbye!");
        break;
    default: 
        System.out.println("invalid choice, try again!");
}
}while(choice!=9);
}}


