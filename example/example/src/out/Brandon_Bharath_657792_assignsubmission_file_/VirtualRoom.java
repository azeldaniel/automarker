package out.Brandon_Bharath_657792_assignsubmission_file_;//816020909 Brandon Bharath
public class VirtualRoom
{
    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;
    
    public VirtualRoom(String name)
    {
        this.name = name;
        breakoutRoomLimit = 5;
        breakoutRooms = new BreakoutRoom[5]; 
    }
    
    public VirtualRoom(String name, int limit)
    {
        this.name = name;
        breakoutRoomLimit = limit;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }
    
    public int getNumberOfBreakoutRooms()
    {
        return this.breakoutRoomLimit;
    }
    
    public void createBreakoutRooms()
    {
        int x=0;
        while(x < this.breakoutRoomLimit)
        {
            this.breakoutRooms[x] = new BreakoutRoom(this.name);
            x++;
        }
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber)
    {
        if((roomNumber > this.breakoutRoomLimit) || (roomNumber <= 0))
        {
            return null;
        }
        if(breakoutRooms[roomNumber-1] != null) 
        {
            return breakoutRooms[roomNumber-1];
        }
        return null;
    }
    
    public boolean closeBreakoutRoom(int roomNumber)
    {
        BreakoutRoom b;
        b = findBreakoutRoom(roomNumber);
        if(b == null)
        {
            System.out.println("Breakout Room was not found.");
        }
        else
        {
            b.closeBreakoutRoom();
            return true;
        }
        return false;
    }
    
    public boolean openBreakoutRoom(int roomNumber)
    {
        BreakoutRoom b;
        b = findBreakoutRoom(roomNumber);
        if(b == null)
        {
            System.out.println("Breakout Room was not found.");
        }
        else
        {
            b.openBreakoutRoom();
            return true;
        }
        return false;
    }
    
    public String listBreakoutRooms()
    {
        String details = "Virtual Room: " + this.name + "\n";
        int x = 0;
        while(x < this.breakoutRoomLimit)
        {
            details += this.breakoutRooms[x].toString();
            x++;
        }
        return details;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber)
    {  
        String details;
        BreakoutRoom b;
        b = findBreakoutRoom(roomNumber);
        if(b == null)
        {
            System.out.println("Breakout Room was not found.");
            return null;
        }
        else
        {
            details = b.listParticipants();
            return details;
        }
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber)
    {
        BreakoutRoom b;
        b = findBreakoutRoom(roomNumber);
        if(b == null)
        {
            System.out.println("Breakout Room was not found.");
            return false;
        }
        else
        {
            boolean check = breakoutRooms[roomNumber-1].addParticipant(participantID);
            return check;
        }
    }
    
    public String findParticipantBreakoutRoom(String participantID)
    {
        String details;
        for(int x = 0; x < this.breakoutRoomLimit; x++)
        {
            if(breakoutRooms[x].findParticipant(participantID) != null)
            {
                details = breakoutRooms[x].getBreakoutRoomID();
                return details;
            }
        }
        return null;
    }
}

