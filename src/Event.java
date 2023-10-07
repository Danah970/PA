
//This class will represent events or appointment that can be scheduled with a contact
public class Event implements Comparable<Event> {
    private String title;
    private String date;
    private String time;
    private String location; 
    private Contact[] contacts;//array of contacts in the event
    private int numOfContacts;//number of contacts
    private int index;
    public Event(String title, String date, String time, String location, int numOfContacts) {//constructor
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
    
    public Contact[] getContacts() {
        return contacts;
    }

    public int getNumOfContacts() {
        return numOfContacts;
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
    
    //-----------------------------------------------------------------------------------------------------

    
    public int compareTo(Event e){ 
        return this.title.toLowerCase().compareTo(e.title.toLowerCase());
    }
    
    //-----------------------------------------------------------------------------------------------------

    
    public void display(){
        System.out.println("Event title: "+title) ; 
        System.out.print("Contact name(s): ") ;
        for(int i=0;i<numOfContacts;i++)
            if(contacts[i]!=null)
                System.out.print(contacts[i].getName()+", ");
        System.out.println("\n Event date and time (MM/DD/YYYY HH:MM): "+date+" "+time) ;   
        System.out.println("Event location: "+location) ;     
    }//end display
    
    //-----------------------------------------------------------------------------------------------------
    
    
    public boolean deletContact(String contactName){//check if event have no contact linked to
        if(!contacts[numOfContacts-1].getName().equalsIgnoreCase(contactName)){ //numOfContacts-1 to get the index
            for(int i=0;i<numOfContacts-1;i++){
                if(contacts[i].getName().equalsIgnoreCase(contactName)){
                    contacts[i]=contacts[numOfContacts-1];
                    contacts[--numOfContacts]=null;
                }//end if
            }//end for
        }//end if
        else{
            contacts[--numOfContacts]=null;//deleted account in the last index
        }//end else
        if(numOfContacts==0)
            return true;//event have no contact linked to
        return false;//there is contact(s)        
    }//end deletContact
    
    //-----------------------------------------------------------------------------------------------------
    
    
    public void addcontact(Contact c){//add contact to the event
        contacts[index++]=c;
    }//end addcontact
}//end Event class

