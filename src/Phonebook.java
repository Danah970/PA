
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
            if(clist.retrieve().getElist().searchEvent(eventTitle, 2)!=null)
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
        System.out.println("9. add new contact(s) to a pre-schedualed event");
	System.out.println("10. Exit\n");
	System.out.print("Enter your choice:");
	choice= input.nextInt();
        input.nextLine();
        boolean check;
switch(choice) {
   
    
    
    
    
    
    
    
    case 1://Add a contact
      input.nextLine();
      System.out.print("Enter the contact's name: ");
      String name= input.nextLine();
      String phoneNumber;
      do{
      check=false;
      System.out.print("Enter the contact's phone number: ");
      phoneNumber= input.nextLine();
      if(phoneNumber.length()!=10||phoneNumber.indexOf("05")!=0){
              System.out.println("invalid phone number");
              check=true;
      }//end if
      }while(check); //end number validation
      
      
      
      String email;
      do{
            check=false;
            System.out.print("Enter the contact's email address: ");
            email= input.nextLine();
            if(email.indexOf("@")==-1){ //no @
                System.out.println("invalid email address");
                check=true;
            }//end if
      }while(check);// end email validation
      
      
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
                c=clist.searchContactByNameOrNumber(str, criteria); // returns list of contacts
                if(c!=null){
                    System.out.print("Contact found!\n");
                    c.display();
                } 
                else
                    System.out.println("Contact doesn't exist");
                break;
            case 2://by Phone Number
                input.nextLine();
                System.out.print("Enter The contact's number: ");
                str=input.nextLine();
                c=clist.searchContactByNameOrNumber(str, criteria);
                if(c!=null){
                    System.out.print("Contact found!\n");
                    c.display();
                }
                else
                    System.out.println("Contact doesn't exist");
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
            /*default:
                System.out.println("invalid number!");
                break;*/
                }
                if(contacts!=null){
                    System.out.println("Contact(s) found!");
                    for(int i=0;i<contacts.length;i++)
                        if(contacts[i]!=null)
                            contacts[i].display();
                }
                else if(contacts==null&&criteria!=1&&criteria!=2)
                System.out.println("Contact(s) doesn't exist");
         break;
         
         
         
         
         
         
    case 3://Delete a contact
        input.nextLine();
        System.out.println("Enter Contact Name:");
        String Name= input.nextLine();
        EventList events=clist.deletContact(Name);//return all events in contact that we want to delete
        Elist.findFirst();
        events.findFirst();
        Contact[] con=null;
        Event toBeDeletedEvent=null;
        if(events!=null){//deleted contact has an eventlist
            while(!events.last()){
            if(events.retrieve().getContacts().length==1)//meaning we deleted the only contact this event is associated with so it should be deleted
                Elist.deletEvent(events.retrieve());
            else{
                con=events.retrieve().getContacts();
            
                for(int i=0; i< con.length; i++) 
                    if(con[i].getName().equalsIgnoreCase(Name)){
                        toBeDeletedEvent=Elist.searchEvent(events.retrieve().getTitle(), 1);//step *
                        toBeDeletedEvent.deletContact(Name);
                        Elist.update(toBeDeletedEvent);//current is already at right place from step(*)
                        i=con.length; }//so it would exit if
            }
                events.findNext();
            
            
        }//end while
        }
            //we will check last element in events
            if(events.retrieve().getContacts().length==1)//meaning we deleted the only contact this event is associated with so it should be deleted
                Elist.deletEvent(events.retrieve());
            else{
                con=events.retrieve().getContacts();
            
                for(int i=0; i< con.length; i++) 
                    if(con[i].getName().equalsIgnoreCase(Name)){
                        toBeDeletedEvent=Elist.searchEvent(events.retrieve().getTitle(), 1);//step *
                        toBeDeletedEvent.deletContact(Name);
                        Elist.update(toBeDeletedEvent);//current is already at right place from step(*)
                        i=con.length; }}//so it would exit if
        break;
    
    
    
    
    
    case 4://Schedule an event
        input.nextLine();
        System.out.print("Enter event title:");
        String title= input.nextLine();
        int numOfContacts=0;
        do{
            try{
                check=false;
                System.out.print("How Many contacts you want to add:");
                numOfContacts=input.nextInt();
            }catch(InputMismatchException e1){
                System.out.println("invalid input");
                check=true;
            }
        }while(check); //validate number
        
        
        
        Contact[] Contacts = new Contact[numOfContacts];
        int index=0;
        Contact contact;
        for(int i=0;i<numOfContacts;i++){
            do{
                input.nextLine();
                System.out.print("Enter contact's number "+ (i+1)+" name:");
                String contactname= input.nextLine();
                contact=clist.searchContactByNameOrNumber(contactname, 1);//check if contact exist
                if(contact!=null)
                    Contacts[index++]=contact;
                else
                    System.out.print("You entered a name that does not exist, try again");
            }while(contact==null);     
        }
        String date,time;
        do{
            check=false;
            System.out.print("Enter event date and time (MM/DD/YYYY HH:MM):");
            date= input.next();
            time=input.next();
            if(date.charAt(2)!='/'||date.charAt(5)!='/'||time.charAt(2)!=':'){
                System.out.println("invalid date and time");
                check=true;
            }//end if
        }while(check);
        System.out.print("Enter event location:");
        input.nextLine();
        String location= input.nextLine();
        boolean flag=false;
        Event e=new Event(title,date,time,location,numOfContacts);
        clist.findFirst();
        for(int i=0;i<numOfContacts;i++){//add event to each contact
            if(clist.addEventToaContact(Contacts[i],e)){//no conflict
                System.out.println("The Event with "+Contacts[i].getName()+" has been schedled succesfully! ");
                e.addcontact(Contacts[i]);
                flag=true;  
            }
        }
        if(flag)
            Elist.addEvent(e);
        break;
  
    
    
    
    
    case 5://Print event details
        input.nextLine();
        System.out.println("Enter search criteria:");
        int n=0;
        System.out.println("1. contact name\n" +"2. Event tittle\n");
        do{
            check=false;
            try{
            System.out.print("Enter your choice: ");
            n=input.nextInt();
            }catch(InputMismatchException e2){
                check=true;
                System.out.println("invalid input");
            }
        }while(check||(n!=1&&n!=2));
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
      
       
       /*another way: (beacause we have memeber implemetation of the method)
       System.out.println("Enter the first name: ");
       String fname=input.nextLine();
       clist.printFirstName(fname);*/
        break;
   
    
    
    
    case 7://Print all events alphabetically (directly because it was added sorted)
        Elist.printEvents();
        break;
   
    
    
    
    
    case 8://Print all contacts that share an event 
        System.out.println("Enter event title: ");
        String eventtitle=input.nextLine();
        Event ev=Elist.searchEvent(eventtitle, 2); //2 to search based on event title 
        Contact[] Cont=ev.getContacts();
        for(int i=0;i<ev.getNumOfContacts();i++)
            Cont[i].display();
        break;
   
    
    
    
   
    
    
    case 9://add new contact(s) to a pre-schedualed event
        input.nextLine();
        int extra=0;
        boolean flag_=false;
        System.out.print("what's the event title? ");
        String titleOfEvent= input.nextLine();
        Event alteredEvent= Elist.searchEvent(titleOfEvent, 2);
         do{
            check=false;
            try{
            System.out.print("how many contacts you want to add to a pre-scheduled event? ");
            extra=input.nextInt();
            }catch(InputMismatchException e2){
                check=true;
                System.out.println("invalid input");
            }
        }while(check);
         Elist.deletEvent(alteredEvent);
         Contact[] updatedContacts = new Contact[alteredEvent.getNumOfContacts()+extra];
         for(int i=0;i<alteredEvent.getNumOfContacts();i++)
             updatedContacts[i] = alteredEvent.getContacts()[i]; //copy previous
        int indexing=alteredEvent.getNumOfContacts()-1;
        Contact contact_;
        for(int i=0;i<extra;i++){
            do{
                input.nextLine();
                System.out.print("Enter contact name:");
                String contactname= input.nextLine();
                contact=clist.searchContactByNameOrNumber(contactname, 1);//check if contact exist
                if(contact!=null)
                    updatedContacts[indexing++]=contact;
            }while(contact==null);     
        }
         alteredEvent=new Event(titleOfEvent,alteredEvent.getDate(),alteredEvent.getTime(),alteredEvent.getLocation(),alteredEvent.getNumOfContacts()+extra);
        clist.findFirst();
        for(int i=0;i<alteredEvent.getNumOfContacts()+extra;i++){//add event to each contact
            if(clist.addEventToaContact(updatedContacts[i],alteredEvent)){//no conflict
                alteredEvent.addcontact(updatedContacts[i]);
                flag_=true;  
            }
        }
        if(flag_)
            Elist.addEvent(alteredEvent);
        break;
        
        
        
        
        
        case 10://Exit
        input.nextLine();
        System.out.print("Goodbye!");
        break;
    default: 
        System.out.println("invalid choice, try again!");
}
}while(choice!=10);
}}




