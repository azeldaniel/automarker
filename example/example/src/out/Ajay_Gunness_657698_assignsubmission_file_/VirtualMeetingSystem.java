package out.Ajay_Gunness_657698_assignsubmission_file_;import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VirtualMeetingSystem
{
    Participant[] loadedParticipantData;
    VirtualRoom[][] virtualRooms;
    int count;
    int virtualRoomCount;
    
    //Constructor for objects of class VirtualMeetingSystem 
    public VirtualMeetingSystem()
    {
        count = 0;
        virtualRoomCount = 0;
    }

    public void loadParticipantData(String fileName)
    {
        try
        {
            File x = new File("participant.dat");
            Scanner myReader = new Scanner(x);
            while(myReader.hasNextLine())
            {
                //String pID = myReader.nextLine();
                loadedParticipantData[count].participantID = myReader.nextLine();
                count ++;
            }
        }catch(FileNotFoundException e)
        {   
            System.out.println("Room Full!!");
            
        }
        
    }
    
    public void createVirtualRoom(String name)                         
    {
        
        int x = 0;
        virtualRooms[virtualRoomCount][x].name = name;
        for(x = 0; x<5; x++)
        {   
            virtualRooms[virtualRoomCount][x].createBreakoutRoom(); //    = breakout.createBreakoutRoom();
        }
        virtualRoomCount++;
    }    
    
    public void allocateParticipants(String code)
    {
        
        
    }
    
    public boolean addParticipant(String participantID, int roomNumber)
    {
        
        VirtualRoom room = new VirtualRoom("room", 5);
        if(!room.findBreakoutRoom(roomNumber).equals(null))
        {
            if(room.findBreakoutRoom(roomNumber).numberOfParticipants < 10)
            {
                room.addParticipantToBreakoutRoom(participantID, roomNumber);
                return true;
            }
        }
        return false;
    }
    
    public String listParticipants(int roomNumber)
    {
        
        VirtualRoom list = new VirtualRoom("list", 5);
        if(!list.findBreakoutRoom(roomNumber).equals(null))
        {
            return list.listParticipantsInBreakoutRoom(roomNumber);
        }
        return null;
    }
    
    public boolean openBreakoutRoom(int roomNumber)
    {
        
        
        return false;
    }
    
    public boolean closeBreakoutRoom(int roomNumber)
    {
       
        return false;
    }
    
    public String findParticipantBreakoutRoom(String participantID)
    {
        // code go here;
        return "sample";
    }
    
    public String listAllBreakoutRoom()
    {
        // code go here
        return "sample";
    }
    
    public String listParticipantsInAllBreakoutRooms()
    {
        // code go here
        return "sample";
    }
}    
    
