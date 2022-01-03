package out.De_Jhan_Aaron_671781_assignsubmission_file_;import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VirtualMeetingSystem
{
    private static VirtualRoom mainRoom;
    private static String filename;
    private static String[] participantsIDs;
    private static int i, p, c;
    
    public VirtualMeetingSystem()
    {
        participantsIDs = new String[50];
        VirtualRoom mainRoom;
        String filename = "participant.dat";
    }

    public void loadParticipantData(String filename)
    {
        File text = new File(filename);
        i = 0;
        try
        {
            Scanner scanr = new Scanner(text);
            while(scanr.hasNextLine() && i < 50)
            {
                participantsIDs[i] = scanr.nextLine();
                i++;
            }
            System.out.println("Success");
        }
        catch(Exception e)
        {
            System.out.println("Error");
        }
    }
    
    public void createVirtualRoom(String name)
    {
        VirtualRoom mainRoom = new VirtualRoom(name);
        System.out.println(name);
    }
    
    public void allocateParticipants(String code)
    {
        i = 0;
        p = 0;
        mainRoom.getBreakoutRoomLimit();
        int num = mainRoom.getNumberOfBreakoutRooms();
        while(i<num)
        {
            c = 0;
            if(mainRoom.findBreakoutRoom(i) != null)
            {
                while(c<5 && p<50)
                {
                    mainRoom.addParticipantToBreakoutRoom(participantsIDs[p], i);
                    p++;
                    c++;
                }
            }
            i++;
        }
    }
    
    public boolean addParticipant(String participantID, int roomNumber)
    {
        if(mainRoom.findBreakoutRoom(roomNumber) != null)
        {
            mainRoom.addParticipantToBreakoutRoom(participantID, roomNumber);
            return true;
        }
        else
            return false;
    }
    
    public String listParticipants(int roomNumber)
    {
        if(mainRoom.findBreakoutRoom(roomNumber) != null)
        {
            return mainRoom.findBreakoutRoom(roomNumber).listParticipants();
        }
        else
            return null;
    }
    
    public boolean openBreakoutRoom(int roomNumber)
    {
        if(mainRoom.findBreakoutRoom(roomNumber) != null)
        {
            mainRoom.openBreakoutRoom(roomNumber);
            return true;
        }
        return false;
    }
    
    public boolean closeBreakoutRoom(int roomNumber)
    {
        if(mainRoom.findBreakoutRoom(roomNumber) != null)
        {
            mainRoom.closeBreakoutRoom(roomNumber);
            return true;
        }
        return false;
    }
    
    public String findParticipantBreakoutRoom(String participantID)
    {
        if(mainRoom.findParticipantBreakoutRoom(participantID)!= null)
        {
           return mainRoom.findParticipantBreakoutRoom(participantID);
        }
        return null;
    }
    
    public String listAllBreakoutRooms()
    {
        return mainRoom.listBreakoutRooms();
    }
    
    public String listParticipantsInAllBreakoutRooms()
    {
        i = 0;
        String allPartList = new String();
        allPartList = "";
        while(mainRoom.findBreakoutRoom(i) != null && i < mainRoom.getNumberOfBreakoutRooms()){
            allPartList = allPartList + mainRoom.listParticipantsInBreakoutRoom(i) + "\n";
            i++;
        }
        return allPartList;
    }
}
