package out.Brandon_Bharath_657792_assignsubmission_file_;//816020909 Brandon Bharath
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VirtualMeetingSystem
{
    protected VirtualRoom v1;
    protected String[] data = new String[50];
    
    public void loadParticipantData(String fileName)
    {
        try
        {
            File myObj = new File(fileName);
            Scanner reader = new Scanner(myObj);
            int x = 0;
            while(reader.hasNextLine())
            {
                data[x] = reader.nextLine();
                x++;
            }
            reader.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    public void createVirtualRoom(String name)
    {
       v1 = new VirtualRoom(name,5);
       v1.createBreakoutRooms();
    }
    
    public void allocateParticipants(String code)
    {
        int x;
        int numberOfRooms = v1.getNumberOfBreakoutRooms();
        int roomCounter;
        if(code.equals("C5"))
        {
            roomCounter = 1;
            for(x = 1; x <= 50; x++)
            {
                v1.addParticipantToBreakoutRoom(data[x-1], roomCounter);
                if((x % numberOfRooms) == 0)
                {
                    roomCounter++;
                }
                if(roomCounter > numberOfRooms)
                {
                    roomCounter = 1;
                }
            }
        }
        if(code.equals("RR"))
        {
            roomCounter = 1;
            for(x = 1; x <= 50; x++)
            {
                v1.addParticipantToBreakoutRoom(data[x-1], roomCounter);
                roomCounter++;
                if(roomCounter > numberOfRooms)
                {
                    roomCounter = 1;
                }
            }
        }
    }
    
    public boolean addParticipant(String participantID, int roomNumber)
    {
        boolean check = v1.addParticipantToBreakoutRoom(participantID, roomNumber);
        return check;
    }
    
    public String listParticipants(int roomNumber)
    {
        String details = v1.listParticipantsInBreakoutRoom(roomNumber);
        return details;
    }
    
    public boolean openBreakoutRoom(int roomNumber)
    {
        boolean check = v1.openBreakoutRoom(roomNumber);
        return check;
    }
    
    public boolean closeBreakoutRoom(int roomNumber)
    {
        boolean check = v1.closeBreakoutRoom(roomNumber);
        return check;
    }
    
    public String findParticipantBreakoutRoom(String participantID)
    {
        String details = v1.findParticipantBreakoutRoom(participantID);
        if(details == null)
        {
            details = "Participant not found in any Breakout Room.";
        }
        else
        {
            details = "Participant " + participantID + "'s Breakout Room is: " + details;
        }
        return details;
    }
    
    public String listAllBreakoutRooms()
    {
        String details = v1.listBreakoutRooms();
        return details;
    }
    
    public String listParticipantsInAllBreakoutRooms()
    {
        String details = "";
        int numberOfRooms = v1.getNumberOfBreakoutRooms();
        int x = 0;
        while(x < numberOfRooms)
        {
            details += v1.listParticipantsInBreakoutRoom(x+1) + "\n";
            x++;
        }
        return details;
    }
}