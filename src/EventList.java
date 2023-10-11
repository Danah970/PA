
//this class represents a list of events to be stored in a contact as well as in the phonebook app to access all available events

public class EventList {
    private Node<Event> current;
    private Node<Event> head;
    
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
    public Event retrieve () {
            return current.getData();
    }
    public void update (Event newData) {
            current.setData(newData); 
    } 
    //-----------------------------------------------------------------------------------------------------

    //adding to a list of events
    public boolean addEvent(Event e){ //this method is not invoked directly in main we still have to check
        current=head;
        Node<Event> newEvent=new Node<Event>(e);
        if (head == null || head.getData().compareTo(e)>= 0) { //add at the start of list if it's empty or the object added is meant to be at the start based on title
            newEvent.setNext(head);
            head=newEvent;
            current=newEvent;
            return true; 
        }//end if
        else{ //not empty or head isn't supposed to be a successor 
            Node<Event> prev = null;
            current=head;
            while(current.getNext() != null && current.getNext().getData().compareTo(newEvent.getData()) < 0) {
                current= current.getNext(); //traversing  
            }//end while
            newEvent.setNext(current.getNext());
            current.setNext(newEvent);
                return true;
        }//end else  
    }//end addEvent
    
    //-----------------------------------------------------------------------------------------------------
    
    
    public Event searchEvent(String str,int criteria){ //the search for an event is based on contact name or the event title and it updates the current to point at the node we were looking for
        current=head;
        while(current!=null) {
	   switch(criteria) {
	        case 1 : //search based on contact name
                    Contact[] contacts=current.getData().getContacts();
                    for(int i=0;i<current.getData().getNumOfContacts();i++)
		    if(contacts[i].getName().equalsIgnoreCase(str))
                        return current.getData();
                    current=current.getNext();    
		break;
	        case 2 : //search based on event title
		    if(current.getData().getTitle().equalsIgnoreCase(str))
                        return current.getData();
                    current=current.getNext();    
		break;
	        case 3 : //search based on date and time to ensure uniqueness
		    if(current.getData().getDate().concat(current.getData().getTime()).equalsIgnoreCase(str))
			return current.getData();
                    current=current.getNext();  
		break;
	    }//end switch
        }//end while
	return null;		
    }//end searchEvent
    
    //-----------------------------------------------------------------------------------------------------
    
        
    public boolean printEvents(){
        boolean flag=false; 
        current=head;
        while(current!=null){
            current.getData().display();
            flag=true;  //true meaning an event has been printed
            current=current.getNext();//move current
        }//end while
        return flag;//empty list
    }//end printEvents
    
    //-----------------------------------------------------------------------------------------------------
    
    
    public void deletEvent(Event e){//delet event from event list
        if(head.getData().compareTo(e)==0){//deleted event in front
            head=head.getNext();
            return;
        }//end if
        current=head.getNext();
        Node <Event> previous=head;
        while(current!=null){
            if(current.getData().compareTo(e)==0){
                previous.setNext(current.getNext());
                current=head;//to not leave current at null
                return;
            }//end if
            current=current.getNext();
        }//end while       
    }//end deletEvent
    
    //-----------------------------------------------------------------------------------------------------
    
    
    public void deletcontact(String name){//delete contact to all the events linked to deleted contact
        current=head;
        Node <Event> previous=null;
        while(current!=null){
            current.getData().deletContact(name);//calling delet contact in Event class
            current=current.getNext();//move current
        }//end while
    }//end deletcontact
        
}//end EventList class

   