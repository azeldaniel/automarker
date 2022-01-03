package out.Tariq_Mohammed_657807_assignsubmission_file_;
/*
 Student ID: 816015043
 Name: Tariq Azard Mohammed
 VirtualMeetingSystem Class
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class VirtualMeetingSystem
{
    // instance variables
    private VirtualRoom vr;
    private String participantID;
    private String[] participantArr = new String[50];

    /**
     * Constructor for objects of class VirtualMeetingSystem
     */
    public VirtualMeetingSystem()
    {
        // initialise instance variables
        
    }
    
    
    public void loadParticipantData(String filename){
        int i = 0;
        
        try{
            File datafile = new File(filename);
            Scanner input = new Scanner(datafile);
            
            while(input.hasNextLine()){
                participantID = input.nextLine();
                participantArr[i] = participantID;
                i++;
            }
            
            input.close();
        }
        
        catch(FileNotFoundException e){
            System.out.println("An error occurred! Could not read file");
        }
    }
    
    public void createVirtualRoom(String name){
        vr = new VirtualRoom(name);     // do not need to specify limit, since the default number of BreakoutRooms created is 5.
        vr.createBreakoutRooms();
    }
    
    public void allocateParticipants(String code){
        boolean added = false;
        int x = 1;
        
        // each iteration is incremented by 5 in order to place participants into corresponding breakoutRooms (5 participants at each iteration of the loop)
        if(code.equals("C5")){
            
            for(int i=0; i<participantArr.length; i=i+5){
                
                added = vr.addParticipantToBreakoutRoom(participantArr[i],x);
                added = vr.addParticipantToBreakoutRoom(participantArr[i+1],x);
                added = vr.addParticipantToBreakoutRoom(participantArr[i+2],x);
                added = vr.addParticipantToBreakoutRoom(participantArr[i+3],x);
                added = vr.addParticipantToBreakoutRoom(participantArr[i+4],x);
                
                x++;
                
                // if x goes over the limit of breakoutRooms, then restart x at 1 in order to resume filling participants from the first breakoutRoom.
                // loops back over to the first breakoutRoom.
                if(x == (vr.getBreakoutRoomLimit() + 1)){
                    x=1;
                }
            }
        }
        
        // participants are entered into breakoutRooms one at a time, with each iteration corresponding to the next breakoutRoom in the list
        else if(code.equals("RR")){
            
            for(int i=0; i<participantArr.length; i++){
                added = vr.addParticipantToBreakoutRoom(participantArr[i], x);
                
                x++;
                
                // if limit is reached then loop over to the first breakoutRoom to resume allocation of participants.
                if(x == (vr.getBreakoutRoomLimit() + 1)){
                    x = 1;
                }
            }
        }
        
        else{
            System.out.println("Invalid allocation code entered");
        }
        
        
    }
    
    public boolean addParticipant(String participantID, int roomNumber){
        boolean status;     // returns true or false based on if a participant was added to the breakoutRoom.
        
        status = vr.addParticipantToBreakoutRoom(participantID, roomNumber);
        
        return status;
    }
    
    public String listParticipants(int roomNumber){
        String result = "";
        
        result = vr.listParticipantsInBreakoutRoom(roomNumber);
        
        return result;
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        boolean status;
        
        status = vr.openBreakoutRoom(roomNumber);
        
        return status;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        boolean status;
        
        status = vr.closeBreakoutRoom(roomNumber);
        
        return status;
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        String breakoutRoom = "";
        String result = "Participant (" + participantID + ") was found in BreakoutRoom: ";
        
        breakoutRoom = vr.findParticipantBreakoutRoom(participantID);
        
        result += breakoutRoom;
        
        return result;
    }
    
    public String listAllBreakoutRooms(){
        String result = "";
        
        result = vr.listBreakoutRooms();
        
        return result;
    }
    
    public String listParticipantsInAllBreakoutRooms(){
        int roomLimit;
        String result = "";
        
        roomLimit = vr.getBreakoutRoomLimit();
        
        result = result + "\nVirtual Room: " + vr.getName() + "\n\n";
        
        for(int i=1; i<=roomLimit; i++){
            result = result + listParticipants(i) + "\n\n";
        }
        
        return result;
    }
    
}
