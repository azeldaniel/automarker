package out.Jamal_Ali_657686_assignsubmission_file_;import java.io.*;
import java.util.*;
/**
 * VirtualMeetingSystem Class.
 * Jamal Ali
 * ID: 81614616
 */
public class VirtualMeetingSystem
{
    // instance variables 
    VirtualRoom Vroom;
    String[] participants = new String[50];
    
    /**
     *Methods for VirtualMeetingSytem Class
    */
    public void loadParticipantData(String filename){
        int i=0;
        try{
            File in = new File(filename);
            Scanner scan = new Scanner(in);
            while (scan.hasNextLine()){
              participants[i] = scan.nextLine();
              i++;
            }
            scan.close();
        } catch (FileNotFoundException e){
            System.out.println("An Error Occured");
        }
    }
 
    public void createVirtualRoom(String name)
    {
        Vroom = new VirtualRoom(name);
        Vroom.createBreakoutRooms();
    }
   
    public void allocateParticipants(String code){
        int room = 1;
        int ParticipantNum =0;
        int count = 0;
        int flag = -1;
        if(code.equalsIgnoreCase("c5")){
            while(flag!=0){
                Vroom.addParticipantToBreakoutRoom(participants[ParticipantNum],room);
                ParticipantNum++;
                if(ParticipantNum%5 == 0){
                    room++;
                }
                if(room == 6){
                    count++;
                    room = 1;
                    if(count == 2){
                        flag = 0;
                    }
                }
            }
        }  
    }
    
    public boolean addParticipant(String participantID, int roomNumber){
        if(Vroom.addParticipantToBreakoutRoom(participantID, roomNumber)){
            return true;
        }
        return false;
    }
    
    public String listParticipants(int roomNumber){
        if(Vroom.findBreakoutRoom(roomNumber)!= null){
            return Vroom.listParticipantsInBreakoutRoom(roomNumber);
        }
        return null;
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        if(Vroom != null){
            Vroom.openBreakoutRoom(roomNumber-1 );
            return true;
        }
        return false;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        if(Vroom != null){
            Vroom.closeBreakoutRoom(roomNumber-1);
            return true;
        }
        return false;
    }
    
    public String findParticipantBreakoutRoom(String participantID){
         return Vroom.findParticipantBreakoutRoom(participantID);
        }
        
     public String listAllBreakoutRooms(){
        return Vroom.listBreakoutRooms();
        }
    
    public String listParticipantsInAllBreakoutRooms(){
        String list = "";
        for(int i = 1; i<6; i++){
            if(Vroom.listParticipantsInBreakoutRoom(i) == null){
                return null;
            }else{
                list += Vroom.listParticipantsInBreakoutRoom(i);
            }
        } 
        return list;
    }
}
