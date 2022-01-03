package out.Raveena_Ramnarine_657853_assignsubmission_file_;//816022556

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Write a description of class VirtualMeetingSystem here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class VirtualMeetingSystem
{
    // instance variables - replace the example below with your own
     private String[] partID= new String[50];
     private VirtualRoom vRoom;
       
  

    public void loadParticipantData(String filename){
        try{
        File obj = new File(filename);
        Scanner r = new Scanner(obj);
        int count=0;
        while (r.hasNextLine()){
            partID[count++]= r.nextLine();
        
        }
        r.close();
     }
     catch (FileNotFoundException e){
    System.out.println("Error occured opening file");
    e.printStackTrace();
    
     }
   }  
   
    public void createVirtualRoom(String name){
       vRoom = new VirtualRoom(name);
       vRoom.createBreakoutRoom();
    }
   
    public void allocateParticipants(String code){
        int bRoom=0;
        int noPart=0;
        for(int i = 1; i <= noPart; i++){
                vRoom.addParticipantToBreakoutRoom(this.partID[i], bRoom);
                bRoom=bRoom+1;
                if(bRoom == 5){
                    bRoom = 0;
                }
            }
        }
     
    public boolean addParticipant(String participantID, int roomNumber){
        return vRoom.addParticipantToBreakoutRoom(participantID, roomNumber);
    }
    
    
   public String listParticipants(int roomNumber){
            return vRoom.listParticipantInBreakoutRoom(roomNumber);
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        if(vRoom.openBreakoutRoom(roomNumber)){
            return true;
        }
    return false;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        if(vRoom.closeBreakoutRoom(roomNumber)){
            return true;
        }
     return false;
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        return vRoom.findParticipantBreakoutRoom(participantID);
    }
    
    public String listAllBreakoutRooms(){
        return vRoom.listBreakoutRooms();
    }
   


 
}

//Java Tutorial. https://www.w3schools.com/java/default.asp.
// Lab