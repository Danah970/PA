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
private int numC;    
    

    
public void addContact(Contact c){
   current = head;
Node<Contact> newContact= new Node<Contact>(c);
  if(head == null) {
    head = newContact;
   current = newContact;
   System.out.println("The contact has been added succesfully! ");
   numC++; //adding to an empty list
   return;
  }
  else //not empty
  {
      
      if(head.getData().compareTo(c)>0){ //c is added first
          newContact.setNext(head);
          head=newContact;
          current=newContact;
          numC++;
          System.out.println("The contact has been added succesfully! ");
          return;
      }
     Node<Contact> prev = head;
     Node<Contact> ahead= head;
  
   while(current.getNext() != null){
       if(ahead.getData().compareTo(c)<0 ){ 
           prev=ahead;
           ahead = ahead.getNext();}
    if(current.getData().compareTo(c.getPhoneNumber())==0||
         current.getData().compareTo(c)==0){
        System.out.println("The contact already exists!");
        return;}
        current=current.getNext();
   } 
      newContact.setNext(ahead);
      prev.setNext(newContact);
      current=newContact;
          System.out.println("The contact has been added succesfully! ");
          numC++;
    }

 }

public void searchContact(String str,int criteria) {
current=head;
Contact[] cList = new Contact[this.numC];
int index=0;
while(current!=null) {
	switch(criteria) {
	case 1 :
		if(current.getData().getName().equalsIgnoreCase(str)){
		  System.out.print("Contact found!\n");
                  current.getData().dispaly();
                        current=null;
                        index=-1;
                }
		break;
	case 2 :
		if(current.getData().getPhoneNumber().equalsIgnoreCase(str)){
                    System.out.print("Contact found!\n");   
                    current.getData().dispaly();
                        current=null;
                        index=-1;
                }
		break;
	case 3 :
		if(current.getData().getEmail().equalsIgnoreCase(str))
			cList[index++]	= current.getData();
		current=current.getNext();
		break;
	case 4 :
		if(current.getData().getAddress().equalsIgnoreCase(str))
			cList[index++]	= current.getData();
		current=current.getNext();
		break;
	case 5 :
		if(current.getData().getBirthday().equalsIgnoreCase(str))
			cList[index++]	= current.getData();
		current=current.getNext();
		break;
		
	}}
	if(index==0){
        System.out.println("The contact doesn't exist!");
	return;}
            
        for(int i=0;i<=index;i++)
                cList[i].dispaly();
			
	}
	
public void printFirstName(String name){
    current=head;
    while(current!=null){
        if(current.getData().getName().substring(0, current.getData().getName().indexOf(' ')).equalsIgnoreCase(name))
            current.getData().dispaly();
        current=current.getNext();
    }
    
}

public boolean AddEvent(Event e){
    current=head;
    while(current!=null) {
        if(current.getData().getName().equalsIgnoreCase(e.getContactName())){
            current.getData().AddEvent(e);
            return true;
        }
        current=current.getNext();
    }
    return false;
}
 public EventList deletContact(String contactName){
        if(head.getData().getName().compareTo(contactName)==0){
            head=null;
            System.out.println("The Contact deleted Successfully!");
            return null;}
        current=head.getNext();
        Node <Contact> previous=head;
        while(current!=null){
            if(current.getData().getName().compareTo(contactName)==0){
                EventList events=current.getData().getElist();
                previous.setNext(current.getNext());
                current=current.getNext();
                System.out.println("The Contact deleted Successfully!");
                return events;
            }
            previous=current;
            current=current.getNext();
    }
        return null;
 }
}