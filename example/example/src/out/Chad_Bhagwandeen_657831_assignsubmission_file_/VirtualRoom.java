package out.Chad_Bhagwandeen_657831_assignsubmission_file_;//Student ID:816002273

public class VirtualRoom
{
    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms=new BreakoutRoom[5];
    private int BreakoutRoomCount;

    
    public VirtualRoom(String name)
    {
        this.name=name;
        breakoutRoomLimit=5;
        BreakoutRoomCount=0;
    }
    public VirtualRoom(String name, int limit)
    {
        this.name=name;
        breakoutRoomLimit=limit;
        BreakoutRoomCount=0;
        
    }
    
    public int getNumberOfBreakoutRooms()
    {
        return BreakoutRoomCount;
    }
    public void createBreakoutRooms()
    {
        int x;
        for(x=0;x<breakoutRoomLimit;x++)
        {
            breakoutRooms[x]=new BreakoutRoom(name);
            BreakoutRoomCount++;
        }
        
        
    
    }
    public BreakoutRoom findBreakoutRoom(int roomNumber)
    {
        if(breakoutRooms[roomNumber]==null)
        {
            return null;
        }
        else
        {
            return breakoutRooms[roomNumber];
        }
        
    }
    public boolean closeBreakoutRoom(int roomNumber)
    {
        if(breakoutRooms[roomNumber]==null)
        {
            return false;
        }
        else
        {
            breakoutRooms[roomNumber].closeBreakoutRoom();
            return true;
        }
    }
    
    public boolean openBreakoutRoom(int roomNumber)
    {
        if(breakoutRooms[roomNumber]==null)
        {
            return false;
        }
        else
        {
            breakoutRooms[roomNumber].openBreakoutRoom();
            return true;
        }
    }

    public String listBreakoutRooms()
    {
        String list="Virtual Room: "+name;
        list+="Breakout Rooms: ";
        int x;
        for(x=0;x<=BreakoutRoomCount;x++)
        {
            list+=breakoutRooms[x].toString();
        }
        return list;
        
    }
    public String listParticipantsInBreakoutRoom(int roomNumber)
    {
        String list="Participants ";
        if(breakoutRooms[roomNumber]==null)
        {
            return null;
        }
        else
        {
            int x;
            for(x=0;x<BreakoutRoomCount;x++)
            {
               list+=breakoutRooms[x].listParticipants();
            }
            return list;
            
            
        }
    }
    public boolean addParticipantToBreakoutRoom(String participantID,int roomNumber)
    {
        if(breakoutRooms[roomNumber]==null)
        {
            return false;
        }
        else
        {
            return breakoutRooms[roomNumber].addParticipant(participantID);
        }
        
    }
    public String findParticipantBreakoutRoom(String participantID)
    {
        String room;
        int x;
        for(x=0;x<BreakoutRoomCount;x++)
        {
            if(breakoutRooms[x].findParticipant(participantID)!=null)
            {
                room=name+x;
                return room;
            }
        }
        return null;
        
    }
    
    
    
 
}
