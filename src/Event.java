/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author danah
 */

//This class will represent events or appointment that can be scheduled with a contact
public class Event implements Comparable<Event> {
    private String title;
    private String date;
    private String time;
    private String location; 
    private Contact[] contacts;
    private int numOfContacts;
    private int index;
    public Event(String title, String date, String time, String location, int numOfContacts) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.location = location;
        this.numOfContacts = numOfContacts;
        contacts=new Contact[numOfContacts];
        this.index=0;
    }

    /* Same as the contact class adding a default empty contact constructor like:
      public Event() {
        this.title = "";
        this.date = null;
        this.time = "";
        this.location = "";
        this.contactsname = "";
    }
    is in "theory" a good practice but it simply does NOt make sense IRL
    */
    
    //getters
    public String getTitle(){
        return title;
    
        }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }
    
    // setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int compareTo(Event e) 
    {
    return this.title.toLowerCase().compareTo(e.title.toLowerCase());
 
    }

    
    public void display(){
    System.out.println("Event title: "+title) ; 
    System.out.print("Contact name: ") ;
    for(int i=0;i<numOfContacts;i++)
        System.out.print(contacts[i].getName()+", ");
    System.out.println("\n Event date and time (MM/DD/YYYY HH:MM): "+date+" "+time) ;   
    System.out.println("Event location: "+location) ;     
    }

    public Contact[] getContacts() {
        return contacts;
    }

    public int getNumOfContacts() {
        return numOfContacts;
    }
    
    public boolean deletContact(String contactname){//check if event have no contact linked to
        if(!contacts[numOfContacts-1].getName().equalsIgnoreCase(contactname)){
            for(int i=0;i<numOfContacts-1;i++){
                if(contacts[i].getName().equalsIgnoreCase(contactname)){
                    contacts[i]=contacts[numOfContacts-1];
                    contacts[--numOfContacts]=null;
                }
            }
        }
        else{
            contacts[--numOfContacts]=null;
        }
        if(numOfContacts==0)
            return true;
        return false;//there is contact(s) 
            
    }
    public void addcontact(Contact c){
        contacts[index++]=c;
    }
}

