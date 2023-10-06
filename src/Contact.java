
//This class will represent a single contact in the phonebook

public class Contact implements Comparable<Contact>{// references below: 
//http://www.javapractices.com/topic/TopicAction.do?Id=10 
//https://www.baeldung.com/java-compareto 
private String name;
private String phoneNumber;
private String email;
private String address;
private String birthday;
private String notes;
private EventList elist;


    public Contact(String name, String phoneNumber, String email, String address, String birthday, String notes) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.birthday = birthday;
        this.notes = notes;
        this.elist= new EventList();
    } /*adding a default empty contact constructor like:
       public Contact() {
        this.name = "";
        this.phonenumber = "";
        this.emailaddress = "";
        this.address = "";
        this.birthday = null;
        this.notes = "";
        elist= new LinkedList<Event>();
    }
    is in "theory" a good practice but it simply does NOt make sense IRL
    */
    
    
    //getters

    public String getName(){
        return name;

    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getNotes() {
        return notes;
    }   

     public EventList getElist() {
        return elist;
    }
     
    //setters

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    //printing a contact's details
    public void display() {
        System.out.println("Name: "+name) ;
        System.out.println("Phone Number: "+phoneNumber) ;
        System.out.println("Email Address: "+email) ;
        System.out.println("Address: "+address) ;
        System.out.println("Birthday: "+birthday) ;
    }
   
@Override
    public int compareTo(Contact c)
    {
        
    return this.name.toLowerCase().compareTo(c.name.toLowerCase());
    }
    
    public int compareTo(String num) 
    { //we will use it to ensure unique number
     int num1=Integer.parseInt(this.phoneNumber);
     int num2=Integer.parseInt(num); //the user is required to enter a correct phonenumber
     return num1-num2;
    }
    
    public boolean checkEvent(Event e){
        Event event=elist.searchEvent(e.getDate().concat(e.getTime()),3);
        /*There should be no conflict in event scheduling. A new event should not be scheduled for a contact if
it has a conflict with a current scheduled event.*/
        if(event!=null){
            System.out.println(name+" has a conflict with "+event.getTitle());
            return false;
        }
        elist.addEvent(e);
  
        return true;
    }
    
    
    

   

   

    
}
    

