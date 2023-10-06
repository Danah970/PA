
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
    
    

    
    
    
    //adding to a list of events
    public boolean addEvent(Event e){ //this method is not invoked directly in main we still have to check
        current=head;
        Node<Event> newEvent=new Node<Event>(e);
        if (head == null || head.getData().compareTo(e)>= 0) {
            newEvent.setNext(head);
            head=newEvent;
            current=newEvent;
            return true;

            
        }
        else{ //not empty
            Node<Event> prev = null;
            current=head;
            while(current.getNext() != null && current.getNext().getData().compareTo(newEvent.getData()) < 0) {
                current= current.getNext(); //traversing  
            }
            newEvent.setNext(current.getNext());
            current.setNext(newEvent);
                return true;
        }//end else
        
    }
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
	       
	    }
        }
	return null;
			
	}
        
    public void printEvents(){
       //for(current=head;current!=null;current=current.getNext()){
         //  current.getData().display(); //they are added in a sorted manner already so printing is straight forward
       
      // if(current!=null)
          // current.getData().display();
        current=head;
        while(current!=null){
            current.getData().display();
            current=current.getNext();
        }
    }
    
    public void deletEvent(Event e){
        if(head.getData().compareTo(e)==0){
            head=null;
            return;}
        current=head.getNext();
        Node <Event> previous=head;
        while(current!=null){
            if(current.getData().compareTo(e)==0){
                previous.setNext(current.getNext());
                current=head;//to not leave current at null
                return;}
            current=current.getNext();
        }        
               
            }
    
    public void deletcontact(String name){
        current=head;
        Node <Event> previous=null;
        while(current!=null){
            current.getData().deletContact(name);
            current=current.getNext();
            }
    }
        
    
    }

     //if(current.getData().compareTo(e)==0){
             //   previous.setNext(current.getNext());
              //  current=current.getNext();      



