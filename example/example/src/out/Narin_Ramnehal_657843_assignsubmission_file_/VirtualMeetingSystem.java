package out.Narin_Ramnehal_657843_assignsubmission_file_;// ID - 816015907

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VirtualMeetingSystem
{ 
    private int count;
    private String [] data;
    VirtualRoom room;
    
    //Constructor
    public VirtualMeetingSystem() 
    { 
        count = -1;
        data = new String[50];
    }  
    
    //Methods 
    public void loadParticipantData(String filename) 
    { 
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner (myObj);
            while (myReader.hasNextLine()) {
                data[++count] = myReader.nextLine();
                System.out.println(data[count]);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
 
    public void createVirtualRoom(String name)
    {
        VirtualRoom virtualRoom = new VirtualRoom(name);
        System.out.println("Virtual Room - " + name);
        virtualRoom.createBreakoutRooms();
    }
    
    public void allocateParticipants(String code) 
    { 
        int j = 0;
        boolean isValid = false;
        if (code == "C5" || code == "c5") {
            for (int i = 0; i < 50; i ++) {
                if (i % 5 == 0){
                    i++;
                }
                if (j % 5 == 0) {
                    j = 0;
                }
                isValid = addParticipant(data[i], j);
                if (isValid = true) {
                    System.out.println("Participant added to the breakoutRoom");
                }
                else{
                    System.out.println("Invalid Participant ID");
                }
            }
        }
    }
    
    public boolean addParticipant (String participantID,int roomNumber)  
    { 
        if (this.room.findBreakoutRoom(roomNumber) != null) {
            this.room.addParticipantToBreakoutRoom(participantID, roomNumber);
            return true;
        }else{
            return false;
        }
    } 
    
    public String listParticipants(int roomNumber) 
    { 
        if (room.findBreakoutRoom(roomNumber) != null) {
            String details = " " + roomNumber;
            details += room.listParticipantsInBreakoutRoom(roomNumber);
            return details; 
        }
        return ("Room Number not found"); 
    }    
    
    public boolean openBreakoutRoom(int roomNumber)
    {
        if (room.findBreakoutRoom(roomNumber) != null) { 
            room.openBreakoutRoom(roomNumber);
            return true;
        }
        return false;
    } 
    
    public boolean closeBreakoutRoom(int roomNumber)
    {
        if (room.findBreakoutRoom(roomNumber) != null) {
            room.closeBreakoutRoom(roomNumber);
            return true;
        }
        return false;
    }
    
    public String findParticipantBreakoutRoom(String participantID)
    {
        String result = room.findParticipantBreakoutRoom(participantID);
        if (result != null){
            System.out.println("BreakoutRoom ID: " + result);
        }
        return null;
    }
    
    public String listAllBreakoutRooms() 
    { 
        for (int i = 0; i < room.getNumberOfBreakoutRooms(); i ++) { 
            return room.listBreakoutRooms();
        }
        return null;
    } 
    
    public String listParticipantsInAllBreakoutRooms()
    {
        String details = "Participants: " + data;
        return details;
    }
}
