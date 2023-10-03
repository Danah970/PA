/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author danah
 */


public class LinkedList {
private Node<Contact> current;
private Node<Contact> head;
private int numC;  //number of contacts  
    
    //default constructor
    public LinkedList () 
    {
        numC = 0;
        head = current = null;
    }
    
    //classic linked list methods
    public boolean empty () {
        return head == null;
    }
    public boolean last () {
        return current.getNext() == null;
    }
    public boolean full () {
            return false;
    }
    public void findFirst () {
            current = head;
    }
    public void findNext () {
            current = current.getNext();
    }
    public Contact retrieve () {
            return current.getData();
    }
    public void update (Contact newData) {
            current.setData(newData); 
    } 
     //getter of size (needed in main)
    public int getNumC() {
        return numC;
    }
 
    
    
    //adding to a list
    public void addContact(Contact c)
    {
        
            current = head;

            Node<Contact> newContact= new Node<Contact>(c);
  
            if(head == null) {
    
                head = newContact;
    
                current = newContact;
   
                System.out.println("The contact has been added succesfully! ");
   
                numC++; //adding to an empty list
   
                
  }
  
            else //not empty
  {
       
      
     Node<Contact> prev = null;
     current= head;
  
   while(current  != null){
       if(current.getData().compareTo(c.getPhoneNumber())==0||
            current.getData().compareTo(c)==0){
            System.out.println("The contact already exists!");
            return;}
       current=current.getNext();} //check it's unique
   
       current=head;
       while(current  != null && current.getData().compareTo(c)<0){
         
             prev=current;
             current= current.getNext(); //traversing
    
       
   } //end while
       if(prev==null){
           newContact.setNext(current);
           current=newContact;
           System.out.println("The contact has been added succesfully! ");
           numC++;
           return;
           
       }//added first 
     
       
      newContact.setNext(current);
      prev.setNext(newContact);
      current=newContact;
      System.out.println("The contact has been added succesfully! ");
      numC++;
       
       
          
   }//end else (adding to a list thats not empty)
    }
   
    
 public EventList deletContact(String contactName){
     EventList events;
        if(head.getData().getName().compareTo(contactName)==0){
            head=head.getNext();
            events=current.getData().getElist();
            current=head;
            System.out.println("The Contact deleted Successfully!");// deleted contact is at the head
            numC--;
            return events;}
        current=head.getNext();
        Node <Contact> previous=head;
        while(current!=null){
            if(current.getData().getName().compareTo(contactName)==0){
                events=current.getData().getElist();
                previous.setNext(current.getNext());
                if(current.getNext()!=null)
                    current=current.getNext();
                else 
                    current=head;
               
                System.out.println("The Contact deleted Successfully!");
                return events;
            }
            
            }
 
    System.out.println("The contact does not exist");
    return null;
 }
        
        
        
        
          
        
        
 

public Contact[] searchContacts(String str,int criteria) {// 3 email 4 address and 5 birthday
    /*When you search for a contact by email address, address, or birthday, you should return all contacts
that have these values*/
current=head;
Contact[] cList = new Contact[this.numC];
int index=0;
while(current!=null) {
	switch(criteria) {
	case 3 :
		if(current.getData().getEmail().equalsIgnoreCase(str))
		    cList[index++]=current.getData();
	        current=current.getNext();
		break;
	case 4 :
		if(current.getData().getAddress().equalsIgnoreCase(str))
	           cList[index++]=current.getData();
	        current=current.getNext();
		break;
	case 5 :
		if(current.getData().getBirthday().equalsIgnoreCase(str))
		    cList[index++]=current.getData();
	        current=current.getNext();
		break;
		
	}}
        if(cList==null)
            System.out.println("there is no contact(s) with this information");
        else
            System.out.print("\"Contact(s) found!\n");
	return cList;
	}
	
	
public boolean checkUniqueContact ( String name, String num )
    {
        if (head == null)
            return true;//list is empty thus you can surly add and it will be unique
        
        Node<Contact> node  = head;
        while ((node != null) && (node.getData().getName().compareTo(name) != 0)&& !node.getData().getPhoneNumber().equalsIgnoreCase(num))
            node = node.getNext();
        if (node!=null) //it broke out of loop beacase the node is NOT unique
        
            return false;
        
        return true;
    }


public void printFirstName(String name){
    /* we used this in main but did put another method in phonebook to show user implementation 
    and because it's stated in the requirements that 'The Phonebook class should have methods for printing all contacts that share an event as well as all
contacts that share the first name.*/
    if(this.empty())
     System.out.println("No Contacts found!");   
    current=head;
    for ( int i = 0 ; i < numC; i++)
        {
            String currentName = current.getData().getName();
            String[] fName = currentName.split(" ");

            if (fName[0].compareToIgnoreCase(currentName) == 0)
                current.getData().display();
                current=current.getNext();
        }
    
    }
    


public boolean addEventToaContact(Contact contact,Event e){
    current=head;
    while(current!=null) { //Make sure before adding an event that the contact in the event exist in the contact list
        if(current.getData().getName().equalsIgnoreCase(contact.getName())) //if contact exists
            return current.getData().checkEvent(e);//check if there is conflict
        
        current=current.getNext(); //move current
    }
    System.out.println("the contact doesn't exist in the contact list!");

    return false; //contact does not exist

    }
    public Contact SearchContact(String str,int criteria){//1 for contact name 2 for phone number this method will return only one contact
        current=head;
    while(current!=null) {
	switch(criteria) {
	case 1 :
		if(current.getData().getName().equalsIgnoreCase(str))
                    return current.getData();
	        current=current.getNext();
                
		break;
	case 2 :
		if(current.getData().getPhoneNumber().equalsIgnoreCase(str))
                    return current.getData();
	        current=current.getNext();
                
		break;
        }
    }
    return null;
}
}
 
 

   
    


