package out.Terrel_Charles_657846_assignsubmission_file_;
/**
 * Write a description of class VirtualMeetingSystem here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */


import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;

public class VirtualMeetingSystem
{
    // instance variables - replace the example below with your own
    
    private String[] participantsID= new String[50];
    private static int numberOfParticipants=0;
    private VirtualRoom virtualRoom=null;
    
    
   
    public void loadParticipantData(String filename) throws FileNotFoundException
    {
         
       File participantIDFile =new File(filename);
       Scanner participantID=new Scanner(participantIDFile);
       
       
       int countNumberOfParticipants=0;
       while(participantID.hasNextLine()){
           
           participantsID[numberOfParticipants++]=participantID.nextLine();
           
           
       
    }
    //need to close file 
      
      //participantIDFile.close();
    
        
    }

    
    
   
    
 
public void createVirtualRoom(String name){

   this.virtualRoom = new VirtualRoom(name);
   this.virtualRoom.createBreakoutRooms();
}
   
public void allocateParticipants(String code){ 
        
        int participants = 0;
        int breakoutRooms = 0;

        if(code.equals("C5")){
            while(participants < this.numberOfParticipants){
                if(breakoutRooms == 5){
                    breakoutRooms= 0;
                }
                for (int i = 0; i < 5 ; i++){
                    this.virtualRoom.addParticipantToBreakoutRoom(this.participantsID[participants], breakoutRooms);
                    System.out.println("breakout Room " + breakoutRooms+" "+ participants +" ");
                    participants++;
                    if(participants == this.numberOfParticipants){
                        break;
                    }
                    
                }
                
                breakoutRooms++;
            }
        }

      
        
        if(code.equals("RR")){
            
            for(int i = 0; i < this.numberOfParticipants; i++){
                
                this.virtualRoom.addParticipantToBreakoutRoom(this.participantsID[i], breakoutRooms);
                breakoutRooms++;
                if(breakoutRooms == 5){
                    breakoutRooms = 0;
                }
            }
            
        }
        
        

    }
    
    
    




public String listParticipants(int roomNumber){

    
    return virtualRoom.listParticipantsInBreakoutRoom(roomNumber);


}


public boolean openBreakoutRoom(int roomNumber){
if(virtualRoom.openBreakoutRoom(roomNumber)){
return true;}
else
return false;
}

public boolean closeBreakoutRoom(int roomNumber){
if(virtualRoom.closeBreakoutRoom(roomNumber)){
return true;}
else
return false;
}

public String findParticipantBreakoutRoom(String participantID){

  return virtualRoom.findParticipantBreakoutRoom(participantID);
}

public String listAllBreakoutRooms(){
   return virtualRoom.listBreakoutRooms();
}

public String listParticipantsInAllBreakoutRooms(){
    String list=" ";
    for(int i=0;i<5;i++){
    
    list+=this.virtualRoom.listParticipantsInBreakoutRoom(i);
    }
    return list;
    

}
public boolean addParticipant(String participantID, int roomNumber){

return this.virtualRoom.addParticipantToBreakoutRoom(participantID,roomNumber);
}



}


