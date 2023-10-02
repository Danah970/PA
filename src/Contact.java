/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author danah
 */
public class Contact implements Comparable<Contact>{
private String name;
private String phoneNumber;
private String email;
private String address;
private String birthday;
private String notes;
private EventList Elist= new EventList();


    public Contact(String name, String phoneNumber, String email, String address, String birthday, String notes) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.birthday = birthday;
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    
    
    public void dispaly(){
    System.out.println("Name: "+name) ; 
    System.out.println("Phone Number: "+phoneNumber) ;   
    System.out.println("Email Address: "+email) ;   
    System.out.println("Address: "+address) ;   
    System.out.println("Birthday: "+birthday) ;   

    }
   
    public int compareTo(Contact c) {
    String str1=this.name.toLowerCase();
    String str2=c.name.toLowerCase();
    int n1=str1.length();
    int n2=str2.length();
    int min=Math.min(n1, n2);
     for(int i=0;i<min;i++){
         if(str1.charAt(i)<str2.charAt(i))
             return 1;
         else if(str1.charAt(i)>str2.charAt(i))
                 return -1;
     }
     if(n1<n2)
         return -1;
     else if(n1>n2)
         return 1;
     return 0;
    }
    public int compareTo(String num) {
     int num1=Integer.parseInt(this.phoneNumber);
     int num2=Integer.parseInt(num);
     return num1-num2;
    }
    
    public boolean AddEvent(Event e){
        Event event=Elist.Search(e.getDate().concat(e.getTime()),3);
        if(event!=null){
            System.out.println("there is a conflict with "+event.getTitle());
            return false;
        }
        Elist.AddEvent(e);
        System.out.println("Event scheduled successfully!");
        return true;
    }

    public EventList getElist() {
        return Elist;
    }

   

    
}
    

