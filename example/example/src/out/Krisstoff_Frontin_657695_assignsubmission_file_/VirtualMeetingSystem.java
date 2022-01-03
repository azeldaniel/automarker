package out.Krisstoff_Frontin_657695_assignsubmission_file_;
/**
 * Krisstoff Frontin
 * 816001130
 * 
 * 
 */

import java.io.File; 
import java.io.FileNotFoundException;
import java.util.Scanner;



public class VirtualMeetingSystem{
     
  private VirtualRoom virtualRooms;
  String[] inFile = new String[50];
   
    
  public void  loadParticipantData(String filename){
    try {                           
      int c = 0;
      File myObj = new File(filename);
      Scanner myReader = new Scanner(myObj);
       while (myReader.hasNextLine()){
         inFile[c] = myReader.nextLine();
         c++;
       }
      myReader.close();
       
    } 
    catch (FileNotFoundException e) {
      System.out.println("Error opening file");
      e.printStackTrace();
    }
  }
    

  public void createVirtualRoom(String name){
   virtualRooms = new VirtualRoom(name);
   virtualRooms.createBreakoutRooms();
  }

 
  public boolean addParticipant (String participantID, int roomNumber){
     return virtualRooms.addParticipantToBreakoutRoom(participantID, roomNumber);
  }

   
  public void allocateParticipants(String code){
    int count1 = 100; 
    int t = 0; 
    
     if(code.equals("C5")){
         
         while(t<50){
             
       for(int i=0; i<virtualRooms.getNumberOfBreakoutRooms(); i=i+1){
           
           for(int j=0; j<5; j=j+1){  
               
             virtualRooms.addParticipantToBreakoutRoom(inFile[t],count1); 
             t++;
            }
            count1++; 
        }
        if(t != 50){
            count1 = 100;
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
    int count2 = 100;
      
      for(int k=0; k<virtualRooms.getNumberOfBreakoutRooms(); k++){
          participantList += virtualRooms.listParticipantsInBreakoutRoom(count2);
          count2++;
      }
      
    return participantList;   
  }
    
}
