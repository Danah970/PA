/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author danah
 */

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
    public void addEvent(Event e){ //this method is not invoked directly in main we still have to check
        current=head;
        Node<Event> newEvent=new Node<Event>(e);
        if(head==null){
            head=newEvent;
            current=newEvent;
            System.out.println("The Event has been schedled succesfully!1 ");

            
        }
        else{ //not empty
            Node<Event> prev = null;
            current=head;
            while(current!= null && current.getData().compareTo(e)<0){
                prev=current;
                current= current.getNext(); //traversing  
            }
            if(prev==null){
                newEvent.setNext(current);
                current=newEvent;
                System.out.println("The Event has been added succesfully!2 ");
                return;
            }//added first
            newEvent.setNext(current);
            prev.setNext(newEvent);
            current=newEvent;
            System.out.println("The Event has been added succesfully!3 ");
        }//end else
        
    }
    public Event searchEvent(String str,int criteria){ //the search for an event is based on the event title or contact name
        current=head;
        while(current!=null) {
	   switch(criteria) {
	        case 1 :
                    Contact[] contacts=current.getData().getContacts();
                    for(int i=0;i<current.getData().getNumOfContacts();i++)
		    if(contacts[i].getName().equalsIgnoreCase(str))
                        return current.getData();
                    current=current.getNext();    
		break;
                
	        case 2 :
		    if(current.getData().getTitle().equalsIgnoreCase(str))
                        return current.getData();
                    current=current.getNext();    
		break;
                
	        case 3 :
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


