package out.Kyle_Fonrose_657764_assignsubmission_file_;//NAME: KYLE E. FONROSE
//ID: 816002546
//TITLE: ASSIGNMENT 1

//INSTRUCTIONS - The order in which to run methods:
//First run loadParticipantData(String filename), where filename = "participant.dat"
//Second run createVirtualRoom(String name), where name is determained by the users.
//Ensure running in order, as allocation of participants can only happen if there exist
//a virtual room, containing the 5 breakout rooms. The method would create and initalize
//both the Virtual Room and Breakout Rooms.


//Import Statments
import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class VirtualMeetingSystem{
     
  private VirtualRoom virtualRooms;
  String[] fileData = new String[50];
   
    
  public void  loadParticipantData(String filename ){
    //This code was taken from "https://www.w3schools.com/java/java_files_read.asp"
    //This code worked as needed so it was fit to just reuse it in this case.
    try {
      int counter = 0;
      File myObj = new File(filename);
      Scanner myReader = new Scanner(myObj);
       while (myReader.hasNextLine()) {
         fileData[counter] = myReader.nextLine();
         counter++;
       }
      myReader.close();
       for(int i=0;i<counter;i++){
        //System.out.println(fileData[i]);
        }
        System.out.println("Number of Participants Loaded: " + counter);
      
    } //File error checking
    catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
    

  public void createVirtualRoom(String name){
   virtualRooms = new VirtualRoom(name); //create empty object
   virtualRooms.createBreakoutRooms(); // create BreakoutRoom objects and assign room name + id
  }

 
  public boolean addParticipant (String participantID, int roomNumber){
      boolean added = false;
      
      //System.out.println(virtualRooms.addParticipantToBreakoutRoom(participantID, roomNumber));
      return virtualRooms.addParticipantToBreakoutRoom(participantID, roomNumber);

  }

   
  public void allocateParticipants(String code){
    int i;  
    int count = 1;
    int clusterCount = 0; 
    
     if(code.equals("C5")){
         while(clusterCount<50){
       for( i=0; i<virtualRooms.getNumberOfBreakoutRooms(); i++){
           for(int k=0; k<5; k++){
             virtualRooms.addParticipantToBreakoutRoom(fileData[clusterCount],count);
             clusterCount++;
            }
            count++;
        }
        if(clusterCount != 50){
            i = 0;
            count = 1;
     }
    }
   }
   
   if(code.equals("RR")){
    while(clusterCount<50){
       for( i=0; i<virtualRooms.getNumberOfBreakoutRooms(); i++){
           for(int k=0; k<5; k++){
             virtualRooms.addParticipantToBreakoutRoom(fileData[clusterCount],count);
             clusterCount++;
             count++;
            if(count == 6){
                count = 1;
            }
            }
            
     }
         if(clusterCount != 50){
            i = 0;
     }
    }
   }
   
  }
  
  public String listParticipants(int roomNumber){
    return virtualRooms.listParticipantsInBreakoutRoom(roomNumber);
  }
  
  public boolean openBreakoutRoom(int roomNumber){
     return virtualRooms.openBreakoutRoom(roomNumber);
  }
  
    
  public boolean closeBreakoutRoom(int roomNumber){
     return virtualRooms.closeBreakoutRoom(roomNumber);
  }
  
    
  public String findParticipantBreakoutRoom (String participantID){
     return virtualRooms.findParticipantBreakoutRoom(participantID);
  }  
  
 
  public String listAllBreakoutRooms( ){
    return virtualRooms.listBreakoutRooms(); 
  }
    
    
  public String listParticipantsInAllBreakoutRooms(){
    String participantList = "";
    int count = 1;
      
      for(int i=0; i<virtualRooms.getNumberOfBreakoutRooms(); i++){
          participantList += virtualRooms.listParticipantsInBreakoutRoom(count);
          count++;
      }
      
    return participantList;   
  }
  
  
}
