package out.Deepak_Ramsubhag_657786_assignsubmission_file_;/**
 Deepak Ramsubhag
 816016482
 
 Please note that there are two allocateParticipants methods; C5 and RR.
 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VirtualMeetingSystem
{
    private int numberOfParticipants;
    private String[] participantID;
    private VirtualRoom vRoom;
    private String rName;
    
    public VirtualMeetingSystem(){
    }
    
    public void loadParticipantData(String filename) throws FileNotFoundException{
        
        int i=0;
        participantID = new String[50];
    
        File file = new File(filename);
        Scanner scan = new Scanner(file);
        
        while(scan.hasNextLine()){
            participantID[i]=scan.nextLine();
            i++;
        }
        numberOfParticipants=i;
    }
    
    public void createVirtualRoom(String name){
        vRoom = new VirtualRoom(name, 5);
        vRoom.createBreakoutRooms();
        rName = name;
    }
    
    public void allocateParticipants(String code){ 
        int x = 1;
        int numRooms = vRoom.getNumberOfBreakoutRooms();
        
        if(code == "C5"){  //Allocate 5 students to a breakoutroom at a time
       
            for(int i=0; i<numberOfParticipants;i++){
                if(i%numRooms==0 && i!=0){
                    x++;
                    if(x>numRooms){
                        x=1;
                    }
                }
                vRoom.addParticipantToBreakoutRoom(participantID[i],x);
            }
        }
        
        if(code == "RR"){
            for(int i=0; i<numberOfParticipants;i++,x++){
                vRoom.addParticipantToBreakoutRoom(participantID[i],x);
                if(x%numRooms==0){
                    x=0;
                }
            }
        }
    }
    
    public boolean addParticipant(String participantID, int roomNumber){
        if(vRoom.findBreakoutRoom(roomNumber)!=null){
            if(vRoom.addParticipantToBreakoutRoom(participantID,roomNumber)==true){
                return true;
            }
        }
        return false;
    }
    
    public String listParticipants(int roomNumber){
        String details="";
        if(vRoom.findBreakoutRoom(roomNumber)!=null){
            details=vRoom.listParticipantsInBreakoutRoom(roomNumber);
        }
        return details;
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        return vRoom.openBreakoutRoom(roomNumber);
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        return vRoom.closeBreakoutRoom(roomNumber);
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        String details = vRoom.findParticipantBreakoutRoom(participantID);
        if(details == null){
            return "Participant not found";
        }
        return details;
    }
        
    public String listAllBreakoutRooms(){
        return vRoom.listBreakoutRooms();
    }
    
    public String listParticipantsInAllBreakoutRooms(){
        int x = vRoom.getNumberOfBreakoutRooms();
        String details="";
        for(int i = 1;i <= x; i++){
            details += vRoom.listParticipantsInBreakoutRoom(i) +"\n\n";
        }
        return details;
    }
    
            

            
            
            
            
            
            
            
            
            
            
            
            
            
}