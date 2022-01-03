package out.Chad_Bhagwandeen_657831_assignsubmission_file_;//Student ID:816002273
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VirtualMeetingSystem
{
    public String[] idArray;
    public int count=0;
    VirtualRoom virtualRoom;
    public void loadParticipantData(String filename)
    {
        try
        {
            File myObj=new File(filename);
            Scanner reader= new Scanner(myObj);
            while(reader.hasNextLine())
            {
                String data=reader.nextLine();
                count=count+1;
            }
            idArray=new String[count];
            Scanner reader2= new Scanner(myObj);
            for(int i=0;i<count;i++)
            {
                idArray[i]=reader2.next();
            }
            reader.close();
        }catch(FileNotFoundException e)
        {
            System.out.println("Error");
        }
        
        
            
    }
    public void createVirtualRoom(String name)
    {
        virtualRoom=new VirtualRoom(name);
        virtualRoom.createBreakoutRooms();
        
    }
    public void allocateParticipant(String code)
    {
        if(code.equals("C5"))
        {
            int x;
            int y;
            int arraycount=0;
            for(x=1;x<6;x++)
            {
                for(y=0;y<9;y++)
                {
                    virtualRoom.addParticipantToBreakoutRoom(idArray[arraycount],x);
                    arraycount=arraycount+1;
                }
            }
                
            
        }
            
        
    }
    public boolean addParticipant(String participantID,int roomNumber)
    {
        return virtualRoom.addParticipantToBreakoutRoom(participantID,roomNumber);
    }
    public String listParticipants(int roomNumber)
    {
        String list= virtualRoom.listParticipantsInBreakoutRoom(roomNumber);
        if(list.equals(null))
        {
            return null;
        }
        else
        {
            return list;
        }
        
    }
    public boolean openBreakoutRoom(int roomNumber)
    {
        if(virtualRoom.openBreakoutRoom(roomNumber)==true)
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }
    public boolean closeBreakoutRoom (int roomNumber)
    {
        if(virtualRoom.closeBreakoutRoom(roomNumber)==true)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public String findParticipantBreakoutRoom (String participantID)
    {
        String room;
        room=virtualRoom.findParticipantBreakoutRoom(participantID);
        if(room.equals(null))
        {
            return null;
        }
        else
        {
            return room;
        }
        
    }
    public String listAllBreakoutRooms()
    {
        String list;
        list=virtualRoom.listBreakoutRooms();
        return list;
    }
    public String listParticipantsInAllBreakoutRooms()
    {
        String allLists="All participants in breakout Rooms";
        int x;
        for(x=0;x<=5;x++)
        {
            allLists+=virtualRoom.listParticipantsInBreakoutRoom(x);
        }
        return allLists;
    }
    
}

