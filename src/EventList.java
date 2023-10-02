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
    
    public void AddEvent(Event e){
        current=head;
        Node<Event> newEvent=new Node<Event>(e);
        if(head==null){
            head=newEvent;
            current=newEvent;
            return;
        }
        else{
            if(head.getData().compareTo(newEvent.getData())<0){
                newEvent.setNext(head);
                current=head=newEvent;
                return;
            }
            Node<Event> prev = head;
            Node<Event> ahead= head;
            while(current.getNext()!=null)
                if(ahead.getData().compareTo(e)>0){
                    prev=ahead;
                    ahead=ahead.getNext();
                }
            newEvent.setNext(ahead);
            prev.setNext(newEvent);
            current=newEvent;
        }
        
    }
    public Event Search(String str,int criteria){
        current=head;
        while(current!=null) {
	   switch(criteria) {
	        case 1 :
		    if(current.getData().getContactName().equalsIgnoreCase(str))
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
       for(current=head;current!=null;current=current.getNext()){
           current.getData().display();
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
                current=current.getNext();
                return;
            }
            previous=current;
            current=current.getNext();
        }
    }

    public Node<Event> getCurrent() {
        return current;
    }

    public void setCurrent(Node<Event> current) {
        this.current = current;
    }

    public Node<Event> getHead() {
        return head;
    }

    public void setHead(Node<Event> head) {
        this.head = head;
    }

    @Override
    public String toString() {
        return "EventList{" + "current=" + current + ", head=" + head + '}';
    }
    
}
