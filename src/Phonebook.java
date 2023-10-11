
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
    public static LinkedList clist= new LinkedList();//contact list
    public static EventList Elist=new EventList();//event list for all the contacts
    
    
  // Print all contacts that share the first name (user implementation)
    public static boolean PrintContactsFirstName(){
       
        System.out.print("Enter the first name:");
        String fname = input.nextLine();
        boolean flag=false;
        if (clist.empty())
            System.out.println("No Contacts were found !");
        
        clist.findFirst();//move current to head
        for ( int i = 0 ; i < clist.getNumC(); i++)
        {
            String currentName = clist.retrieve().getName();
            String [] fName = currentName.split(" ");

            if (fName[0].equalsIgnoreCase(fname)){
               flag=true;
               clist.retrieve().display();}
            clist.findNext(); //traverse
        }//end for
        return flag;
    }//end method
      
    
    
    
   //print contacts that share an event
    public static void printIfSharedEvent(String eventTitle){
        clist.findFirst();
        for( int i =0; i< clist.getNumC() ; i++){
            if(clist.retrieve().getElist().searchEvent(eventTitle, 2)!=null)
              clist.retrieve().display();
            clist.findNext();
        }//end for 

    }//end metod
    
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
	System.out.print("10. Exit\n");
        boolean check;
        do{
            try{
                input.nextLine();
                check=false;
                System.out.print("Enter your choice:");
                choice= input.nextInt();  
            }catch(InputMismatchException e){
                System.out.println("invalid input");
                check=true;
            }//end catch   
        }while(check);//end choice validation
	
        input.nextLine();
        switch(choice) {
   
 //-----------------------------------------------------------------------------------------------------
   
        case 1://Add a contact
        input.nextLine();
        System.out.print("Enter the contact's name: ");
        String name= input.nextLine();
        String phoneNumber;
        do{
            check=false;
            System.out.print("Enter the contact's phone number: ");
            phoneNumber= input.nextLine();
            if(phoneNumber.trim().length()!=10||phoneNumber.trim().indexOf("05")!=0){ //trim() is to give room for user ti enter space without causing a problem
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
        if(clist.checkUniqueContact(name.trim(), phoneNumber.trim()))
            clist.addContact(new Contact(name,phoneNumber,email,address,birthday,notes));
        else
          System.out.println("Contact is not added because it's NOT unique");
        break;//end Add a contact
    
    //-----------------------------------------------------------------------------------------------------
    

        case 2://Search for a contact
        input.nextLine();
        System.out.println("Enter search criteria:");
        System.out.println("1. Name\n" +
        "2. Phone Number\n" +
        "3. Email Address\n" +
        "4. Address\n" +
        "5. Birthday");
        int criteria=0;
        do{
            try{
                input.nextLine();
                check=false;
                System.out.print("Enter your choice: ");
                criteria= input.nextInt();  
            }catch(InputMismatchException e){
                System.out.println("invalid input");
                check=true;
            }//end catch   
        }while(check);//end criteria validation
        String str="";
        Contact c= null;
        Contact[] contacts=null;
        input.nextLine();
        switch(criteria){
            case 1://by Name
                input.nextLine();
                System.out.print("Enter The contact's name: ");
                str=input.nextLine().trim();;
                c=clist.searchContactByNameOrNumber(str, criteria); // returns only one contact
                if(c!=null){
                    System.out.print("Contact found!\n");
                    c.display();
                }//end if 
                else
                    System.out.println("Contact doesn't exist");
                break;
            case 2://by Phone Number
                input.nextLine();
                System.out.print("Enter The contact's number: ");
                str=input.nextLine().trim();
                c=clist.searchContactByNameOrNumber(str, criteria); // returns only one contact
                if(c!=null){
                    System.out.print("Contact found!\n");
                    c.display();
                }//end if
                else
                    System.out.println("Contact doesn't exist");
                break;
            case 3://by Email Address
                System.out.print("Enter The contact's email: ");
                str=input.nextLine().trim();
                contacts=clist.searchContacts(str, criteria); // returns list of contacts
                break;
            case 4://by Address
                System.out.print("Enter The contact's address: ");
                str=input.nextLine().trim();
                contacts=clist.searchContacts(str, criteria); // returns list of contacts
                break;
            case 5://by Birthday
                System.out.print("Enter The contact's birthday: ");
                str=input.nextLine().trim();    
                contacts=clist.searchContacts(str, criteria); // returns list of contacts
                break;
                default:
                System.out.println("invalid number!");
                break;
                }//end switch 
                if(contacts!=null){
                    System.out.println("Contact(s) found!");
                    for(int i=0;i<contacts.length;i++)
                        if(contacts[i]!=null)
                            contacts[i].display();
                }//end if
                else if(contacts==null&&c!=null) 
                System.out.println("Contact(s) doesn't exist");
         break;
         
    //-----------------------------------------------------------------------------------------------------
         
      
        case 3://Delete a contact
        input.nextLine();
        System.out.print("Enter Contact Name:");
        String Name= input.nextLine().trim();
        EventList events=clist.deletContact(Name);//return all events in deleted contact
        if(events!=null){//deleted contact has event(s)
            events.deletcontact(Name);//delet contact for all return events 
            Elist.findFirst();
            while(!Elist.empty()&&Elist.last()){
                if(Elist.retrieve().getNumOfContacts()==0)//check if the event has no contact associated with 
                    Elist.deletEvent(Elist.retrieve());//delete the event
                Elist.findNext();    
            }//end while 
            if(!Elist.empty()&&Elist.retrieve().getNumOfContacts()==0)
               Elist.deletEvent(Elist.retrieve());//delete the event

        }//end if
        break;
    
    //-----------------------------------------------------------------------------------------------------
    
   
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
        }while(check); //validate number of contacts
        
        
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
        }//end for
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
        }while(check);//end date and time validation
        System.out.print("Enter event location:");
        input.nextLine();
        String location= input.nextLine();
        boolean flag=false;
        Event e=new Event(title,date,time,location,numOfContacts);
        clist.findFirst();
        for(int i=0;i<numOfContacts;i++){//add event to each contact
            if(clist.addEventToaContact(Contacts[i],e)){//no conflict
                System.out.println("The Event with "+Contacts[i].getName()+" has been schedled succesfully! ");
                e.addcontact(Contacts[i]);//add contact to the event
                flag=true;  
            }// end if
        }// end for
        if(flag)//the event added to at least one contact
            Elist.addEvent(e);//add event to event list
        break;
  
    //-----------------------------------------------------------------------------------------------------
    
    
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
            }//end catch
        }while(check||(n!=1&&n!=2));// end choice validation
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
        if(event!=null){// event exist
            System.out.print("Event found!\n");
            event.display();
        }//end if
        else
           System.out.print("Event not found!\n");

        break;    
    
    //-----------------------------------------------------------------------------------------------------
    
    
        case 6://Print contacts by first name
        input.nextLine();
        boolean found= PrintContactsFirstName();
        if(found)
        System.out.println("\n\nContact(s) found as mentioned ^");
        else
        System.out.print("no contact with such first name");

       
   
    //-----------------------------------------------------------------------------------------------------
    
    
        case 7://Print all events alphabetically (directly because it was added sorted)
        if(!Elist.printEvents())//no event is printed
        System.out.println("No avaiable events to print :(");
        break;
   
    //-----------------------------------------------------------------------------------------------------
    
    
        case 8://Print all contacts that share an event 
        System.out.print("Enter event title: ");
        String eventtitle=input.nextLine();
        Event ev=Elist.searchEvent(eventtitle, 2); //2 to search based on event title 
        if(ev!=null){
        Contact[] Cont=ev.getContacts();
        for(int i=0;i<ev.getNumOfContacts();i++)
            if(Cont[i]!=null)
                Cont[i].display();}
        break;
   
    //-----------------------------------------------------------------------------------------------------
    
  
        
        case 9://Exit
        input.nextLine();
        System.out.print("Goodbye!");
        break;
        
        //-----------------------------------------------------------------------------------------------------
        
        
        default: 
        System.out.println("invalid choice, try again!");
        }//end switch 
    }while(choice!=9);//end do
}//end main
}//end Phonebook class




