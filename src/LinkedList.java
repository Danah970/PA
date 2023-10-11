
//this class represents a list of contacts 

public class LinkedList {
private Node<Contact> current;
private Node<Contact> head;
private int numC;  //number of contacts in the list
    
    //default constructor
    public LinkedList () 
    {
        numC = 0;
        head = current = null;
    }
 //-----------------------------------------------------------------------------------------------------
   
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
 
    //-----------------------------------------------------------------------------------------------------
    
    
    public void addContact(Contact c)//adding to a list
    {
        
        current = head;

        Node<Contact> newContact= new Node<Contact>(c);
  
        if(head == null) {
            newContact.setNext(head);
            head = newContact;
            current = newContact;
            System.out.println("The contact has been added succesfully! ");
            numC++; //adding to an empty list           
        }
  
        else{ //not empty
            Node<Event> prev = null;
            current=head;
            while(current.getNext() != null && current.getNext().getData().compareTo(newContact.getData()) < 0) {
                current= current.getNext(); //traversing  
            }//end while
            newContact.setNext(current.getNext());
            current.setNext(newContact);
             System.out.println("The contact has been added succesfully! ");
            numC++; //adding to a non-empty list   
        }//end else (adding to a list thats not empty)
    }//end addContact
    
    //-----------------------------------------------------------------------------------------------------
   
    
    public EventList deletContact(String contactName){//deleting from a list
        EventList events;
        if(head.getData().getName().equalsIgnoreCase(contactName)){//deleted contact in front
            events=head.getData().getElist();
            head=head.getNext();
            current=head;
            System.out.println("The Contact deleted Successfully!");// deleted contact is at the head
            numC--;//decrement number of contacts 
            return events;//return event list that associated with deleted contact
        }//end if
        current=head.getNext();
        Node <Contact> previous=head;
        while(current!=null){
            if(current.getData().getName().equalsIgnoreCase(contactName)){
                events=current.getData().getElist();
                previous.setNext(current.getNext());
                if(current.getNext()!=null)//last
                    current=current.getNext();
                else 
                    current=head;
               
                System.out.println("The Contact deleted Successfully!");
                return events;//return event list that associated with deleted contact
            }//end if
            
            }
 
        System.out.println("The contact does not exist");
        return null;
    }//end deletContact
        
//-----------------------------------------------------------------------------------------------------       
        

    public Contact[] searchContacts(String str,int criteria) {// 1 by name 2 by number 3 email 4 address and 5 birthday
        /*When you search for a contact by email address, address, or birthday, you should return all contacts
        that have these values*/
        current=head;
        Contact[] cList = new Contact[this.numC];
        int index=0;
        while(current!=null) {
	    switch(criteria) {       
	        case 3 ://by email address
		    if(current.getData().getEmail().equalsIgnoreCase(str))
		        cList[index++]=current.getData();
	            current=current.getNext();
		break;
	        case 4 ://by address
		    if(current.getData().getAddress().equalsIgnoreCase(str))
	                cList[index++]=current.getData();
	            current=current.getNext();
		break;
	        case 5 ://by birthday
		    if(current.getData().getBirthday().equalsIgnoreCase(str))
		        cList[index++]=current.getData();
	            current=current.getNext();
		break;	
	    }//end switch
        }//end while
	return cList;//return all contacts
    }//end searchContacts
	
    //-----------------------------------------------------------------------------------------------------
    
	
    public boolean checkUniqueContact ( String name, String num ){
        if (head == null)
            return true;//list is empty thus you can surly add and it will be unique
        
        Node<Contact> node  = head;
        while ((node != null) && (node.getData().getName().compareTo(name) != 0)&& !node.getData().getPhoneNumber().equalsIgnoreCase(num))
            node = node.getNext();
        if (node!=null) //it broke out of loop beacase the node is NOT unique
            return false;
        
        return true;
    }//end checkUniqueContact
   
    
    //-----------------------------------------------------------------------------------------------------


    public boolean addEventToaContact(Contact contact,Event e){//add event to a contact in the list
        current=head;
        while(current!=null) { //Make sure before adding an event that the contact in the event exist in the contact list
            if(current.getData().getName().equalsIgnoreCase(contact.getName())){ //if contact exists
                return current.getData().checkEvent(e);//check if there is conflict  
            }//end if
            current=current.getNext(); //move current
        }//end while
        System.out.println("the contact doesn't exist in the contact list!");
        return false; //contact does not exist
    }//end addEventToaContact
    
    //-----------------------------------------------------------------------------------------------------
    
    
    public Contact searchContactByNameOrNumber(String str,int criteria){//1 for contact name 2 for phone number this method will return only one contact
        current=head;
        while(current!=null) {
	    switch(criteria) {
	    case 1 ://by contact name
		if(current.getData().getName().equalsIgnoreCase(str))
                    return current.getData();
	        current=current.getNext();//move current
		break;
	    case 2 ://by phone number
		if(current.getData().getPhoneNumber().equalsIgnoreCase(str))
                    return current.getData();
	        current=current.getNext();//move current
		break;
            }//end switch
        }//end while
        return null;//if the contact doesn't exist
    }//end searchContactByNameOrNumber
}//end LinkedList class
 
 
