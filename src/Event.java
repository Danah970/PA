/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author danah
 */
public class Event {
    private String Title,Date,Time,Location,ContactName;
    

    public Event(String Title, String Date, String Time, String Location, String ContactName) {
        this.Title = Title;
        this.Date = Date;
        this.Time = Time;
        this.Location = Location;
        this.ContactName = ContactName;
    }

    public String getTitle() {
        return Title;
    }
    
    public int compareTo(Event e){
        String str1=this.Title.toLowerCase();
        String str2=e.getTitle().toLowerCase();
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

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public String getContactName() {
        return ContactName;
    }

    public void setContactName(String ContactName) {
        this.ContactName = ContactName;
    }
    
    public void display(){
    System.out.println("Event title: "+Title) ; 
    System.out.println("Contact name: "+ContactName) ;   
    System.out.println("Event date and time (MM/DD/YYYY HH:MM): "+Date+" "+Time) ;   
    System.out.println("Event location: "+Location) ;     
    }
}
