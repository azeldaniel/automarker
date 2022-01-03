package out.Tevon_Thatcher_657668_assignsubmission_file_;/**
 * @Tevon Thatcher - 816019492
 */

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class VirtualMeetingSystem
{
    // instance variables - replace the example below with your own
    private String participants[]= new String[50];
    private VirtualRoom vRoom = null;
    
    
    public void loadParticipantData(String filename)
    {
        try{
            File newFile = new File(filename);
            Scanner newScanner = new Scanner(newFile);
        
            int i=0;
        
            while(newScanner.hasNextLine()){
                participants[i]= new String(newScanner.nextLine());
                i++;
            }
            newScanner.close();
        }
        catch(FileNotFoundException e){
                System.out.println("An error occured.\n");
                e.printStackTrace();
            }
    }
    
    public void createVirtualRoom(String name){
        vRoom = new VirtualRoom(name);
        vRoom.createBreakoutRooms();
    }
    
    public void allocateParticipants(String code){
        int added = 0;
        int roomnumber = 0;
        
        if(vRoom == null)
            return;
        
        if(code.equals("C5")){
            for(String i : participants){
                if(roomnumber >= vRoom.getNumberOfBreakoutRooms())
                    roomnumber=0;
                
                vRoom.openBreakoutRoom(roomnumber);
                vRoom.addParticipantToBreakoutRoom(i,roomnumber); 
                added++;
                    
                if(added%5 == 0){
                    roomnumber++;
                }        
            }
        }
        else if(code.equals("RR")){
            for(String i : participants){
                if(roomnumber >= vRoom.getNumberOfBreakoutRooms())
                    roomnumber=0;
                
                vRoom.openBreakoutRoom(roomnumber);
                vRoom.addParticipantToBreakoutRoom(i,roomnumber); 
                added++;
                    
                roomnumber++;       
            }
        }
    }
    
    public boolean addParticipant(String participantID, int roomNumber){  
        if(vRoom == null)
            return false;
            
        vRoom.openBreakoutRoom(roomNumber);
        if(vRoom.addParticipantToBreakoutRoom(participantID,roomNumber)){
            System.out.println(participantID + " was added to room.\n");
            return true;
        }
            
        else{
            System.out.println(participantID + " could not be added to room.\n");
            return true;
        }
            

    }
    
    public String listParticipants(int roomNumber){
        if(vRoom == null)
            return "Virtual Room does not exist";;
        if(roomNumber < vRoom.getNumberOfBreakoutRooms() || roomNumber > vRoom.getNumberOfBreakoutRooms())
            return vRoom.listParticipantsInBreakoutRoom(roomNumber);
        else 
        return null;
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        if(vRoom == null)
            return false;
            
        if(vRoom.openBreakoutRoom(roomNumber) ){
            System.out.println("Breakout room: " + roomNumber + " opened\n");
            return true;
        }
            
        else{
            System.out.println("Breakout room: " + roomNumber + " could not be opened\n");
            return false;
        } 
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        if(vRoom == null)
            return false;
        
        if(vRoom.closeBreakoutRoom(roomNumber)){
            System.out.println("Breakout room: " + roomNumber + " closed\n");
            return true;
        }
            
        else{
            System.out.println("Breakout room: " + roomNumber + " could not be closed\n");
            return false;
        } 
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        if(vRoom == null)
            return "Virtual Room does not exist";
            
        String roomID = vRoom.findParticipantBreakoutRoom(participantID);
        return roomID;
    }
    
    public String listAllBreakoutRooms(){
        if(vRoom == null)
            return "Virtual Room does not exist";
            
        return vRoom.listBreakoutRooms();
    }
    
    public String listParticipantsInAllBreakoutRooms(){
        if(vRoom == null)
            return "Virtual Room does not exist";
            
        String participants = "";
        
        for(int i = 0; i<vRoom.getNumberOfBreakoutRooms();i++){
            if(vRoom.listParticipantsInBreakoutRoom(i) != null)
                participants+=vRoom.listParticipantsInBreakoutRoom(i) + "\n";
        }
        
        return participants;
    }
}
