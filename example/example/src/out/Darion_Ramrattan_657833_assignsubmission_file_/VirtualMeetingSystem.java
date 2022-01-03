package out.Darion_Ramrattan_657833_assignsubmission_file_;import java. io. File; 
import java.io.FileNotFoundException; 
import java.util.Scanner; 
import java.io.IOException;
import java.util.ArrayList; 

/**
 * Write a description of class VirtualMeetingSystem here.
 *
 * @author (816018746)
 * @version (a version number or a date)
 */
public class VirtualMeetingSystem
{
    // instance variables - replace the example below with your own
    public String participant[]= new String[50] ; 
    public VirtualRoom v1; 
    public static int c =0; 
    
    public void loadParticipantData(String filename){ 
      try{
        File myObj = new File(filename);
        Scanner myReader = new Scanner(myObj); 
        int i=0;
        String data=""; 
        while(myReader.hasNextLine()){
          data = myReader.nextLine(); 
          participant[i] = data; 
          i++; 
        }
        System.out.println("File Successfully Read.");
        myReader.close(); 
    }
    catch(FileNotFoundException e){
        
        System.out.println("An error has occurred");
        e.printStackTrace(); 
    }
    }  
    
    public void createVirtualRoom(String name){  
         v1 = new VirtualRoom(name); 
         
          System.out.println("Created Virtual Room.");
    }

    public void allocateParticipants(String code){
      
      v1.createBreakoutRooms();
     for(int i =0; i< 5; i++){ //i = 1
        
         for(int j=0; j<10; j++){
             v1.addParticipantToBreakoutRoom(participant[c], i); 
             c++; 
            }
    }
    System.out.println("Participants Allocated.");
    }

    public boolean addParticipant (String participantID,int roomNumber){
        boolean a = v1.addParticipantToBreakoutRoom(participantID, roomNumber-1);
        
        if(a == true){
            System.out.println("Added participant");

        }
        else
            System.out.println("Participant was not Added");
        return a;
        
    }
    //incomplete 
    public String listParticipants(int roomNumber){
     String p= ""; 
        p+=v1.listParticipantsInBreakoutRoom(roomNumber-1); 
        return p; 
        
    }
    
    public boolean openBreakoutRoom(int roomNumber){
       System.out.println("Open BreakoutRoom.");
       return v1.openBreakoutRoom(roomNumber-1); 
         
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
         System.out.println("Closed BreakoutRoom.");
         return v1.closeBreakoutRoom(roomNumber-1);   
   
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        String p= ""; 
        
        p+= v1.findParticipantBreakoutRoom(participantID); 
        if(p != null){
        //System.out.println("Participant Found.");
        return p; 
    }
        return null; 
    }
    
    public String listAllBreakoutRooms(){
     String p= "";    
     
     p+=v1.listBreakoutRoom(); 
     
     return p; 
    }
    
    public String listParticipantsInAllBreakoutRooms(){
        String p = ""; 
        
         
        
        for(int i=0; i<5; i++){
            p+=v1.listParticipantsInBreakoutRoom(i) + " \n"; 
    }
    return p;
} 
}
