package out.Chantel_Lewis_657735_assignsubmission_file_;
/**
 * Write a description of class VirtualMeetingSystem here.
 *
 * @author 816011391
 * @version 07/03/2021
 */
import java.io.*;
import java.util.*;

public class VirtualMeetingSystem
{
    // instance variables - replace the example below with your own
    public String filename;
    public String participantData[];
    private VirtualRoom virtualRoom;
    /**
     * Constructor for objects of class VirtualMeetingSystem
     */
    public VirtualMeetingSystem()
    {
        // initialise instance variables
        this.filename = "participant.dat";
        this.participantData = new String[50];
    }
    
    public void loadParticipantData(String filename)
    {
        try
        {
            String data;
            int i = 0;
            BufferedReader dataFile;
            dataFile = new BufferedReader(new FileReader(filename));
            data = dataFile.readLine();
            //Scanner dataFile = new Scanner(data);
            while(data != null)
            {
                participantData[i] = new String(data);
                data = dataFile.readLine();
                i++;
                //System.out.println(participantData);
            }
            dataFile.close();
        }
        catch(IOException e)
        {
            System.out.println("The file could not open because an error occured");
            e.printStackTrace();
        }
    }
    
    public void createVirtualRoom(String name)
    {
        VirtualRoom virtualRoom = new VirtualRoom(name);
        virtualRoom.createBreakoutRooms();
    }
    
    /*public void allocateParticipants(String code)
    {
        int counter1 = 0;
        int counter2 = 0;
        if(code == "C5")
        {
            
        }
        else
        System.out.println("Invalid code.");
    }*/
    
    public boolean addParticipant(String participantID, int roomNumber)
    {
        //int i;
        //if(breakoutRooms[i].equals(roomNumber))
        return virtualRoom.addParticipantToBreakoutRoom(participantID, roomNumber);
    }
    
   public String listParticipants(int roomNumber)
    {
       String participantDetails = new String();
        participantDetails = this.virtualRoom.listParticipantsInBreakoutRoom(roomNumber);
        return participantDetails;
    }
    
   public boolean openBreakoutRoom(int roomNumber)
    {
       //open the breakout room with the given room number
        return virtualRoom.openBreakoutRoom(roomNumber);
    }
    
    public boolean closeBreakoutRoom(int roomNumber)
    {
        //close the breakout room with the given room number
        return virtualRoom.closeBreakoutRoom(roomNumber);
    }
    
    public String findParticipantBreakoutRoom(String participantID)
    {
        String roomDetails = "";
        roomDetails += this.virtualRoom.findParticipantBreakoutRoom(participantID);
        if(roomDetails.equals(null))
        {
            roomDetails = participantID + " not found in room.";
        }
        return roomDetails;
    }
    
    public String listAllBreakoutRooms()
    {
        return virtualRoom.listBreakoutRooms();
    }
    
    public String listParticipantsInAllBreakoutRooms()
    {
        String participantDetails = "";
        int count = 0;
        while(count < virtualRoom.getNumberOfBreakoutRooms())
        {
            participantDetails += virtualRoom.listParticipantsInBreakoutRoom(count) + "\n";
        }
        return participantDetails;
    }
    
    
    
    

   
}
