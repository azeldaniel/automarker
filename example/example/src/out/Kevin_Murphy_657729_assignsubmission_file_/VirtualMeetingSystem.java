package out.Kevin_Murphy_657729_assignsubmission_file_;/**
 * Kevin Murphy 
 * 816003734
 * 
 */

import java.io.File; 
import java.io.FileNotFoundException;
import java.util.Scanner;



public class VirtualMeetingSystem{
     
    private VirtualRoom virtualRooms;
    String[] inFile = new String[50];
   
    
  public void  loadParticipantData(String filename){
    try {                           //referenced from https://www.w3schools.com/java/java_files_read.asp
      int count = 0;
      File myObj = new File(filename);
      Scanner myReader = new Scanner(myObj);
       while (myReader.hasNextLine()){
         inFile[count] = myReader.nextLine();
         count = count +1;
       }
      myReader.close();
      //test print 
    } 
    catch (FileNotFoundException e) { 
      System.out.println("Unable to open file...");
      e.printStackTrace();
    }
  }//end function
    

  public void createVirtualRoom(String name){
   virtualRooms = new VirtualRoom(name);
   virtualRooms.createBreakoutRooms();
  }//end function

 
  public boolean addParticipant (String participantID, int roomNumber){
     return virtualRooms.addParticipantToBreakoutRoom(participantID, roomNumber);
  }//end function

   
  public void allocateParticipants(String code){
    int countBreakoutRoom = 100; //ref to breakoutRoom
    int temp1 = 0; //cycle through arrIDs
    
     if(code.equals("C5")){  //check C5 condition
         
         while(temp1 < 50){ //while <
             
       for(int i=0; i<virtualRooms.getNumberOfBreakoutRooms(); i=i+1){  //cycle through all breakoutRooms
           
           for(int j=0; j<5; j=j+1){  //add a participant 5 times
               
             virtualRooms.addParticipantToBreakoutRoom(inFile[temp1],countBreakoutRoom); //call to addParticipant
             temp1++;
            }
            countBreakoutRoom++; //increment each room
        }
        if(temp1 != 50){
            countBreakoutRoom = 100;
     } //end if
    } //end while
   } //end if
  } //end function
  
  public String listParticipants(int roomNumber){
    return virtualRooms.listParticipantsInBreakoutRoom(roomNumber);
  }//end function
  
  public boolean openBreakoutRoom(int roomNumber){
     return virtualRooms.openBreakoutRoom(roomNumber);
  }//end function
  
    
  public boolean closeBreakoutRoom(int roomNumber){
     return virtualRooms.closeBreakoutRoom(roomNumber);
  }//end function
  
    
  public String findParticipantBreakoutRoom (String participantID){
     return virtualRooms.findParticipantBreakoutRoom(participantID);
  }//end function
  
 
  public String listAllBreakoutRooms( ){
    return virtualRooms.listBreakoutRooms(); 
  }//end function
    
    
  public String listParticipantsInAllBreakoutRooms(){
    String participantList = ""; //initalize
    int count = 0;
      
      for(int k=0; k<virtualRooms.getNumberOfBreakoutRooms(); k=k+1){
          participantList += virtualRooms.listParticipantsInBreakoutRoom(count); //append to list
          count++; //increment counter
      }
      
    return participantList;   
  }//end function
    
}
