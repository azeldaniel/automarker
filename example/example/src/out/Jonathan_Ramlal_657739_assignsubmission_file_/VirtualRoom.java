package out.Jonathan_Ramlal_657739_assignsubmission_file_;

public class VirtualRoom
{
    public String name;
    public int BreakoutRoomLimit = 5;
    public boolean breakoutRoom;
    public int getNumberOfBreakoutRooms;
    //public void createBreakoutRooms;
    public BreakoutRoom[] findBreakoutRoom;
    public boolean closeBreakoutRoom;
    public boolean openBreakoutRoom;
    public String listBreakoutRoom;
    public String listParticipantsInBreakoutRoom;
    public boolean addParticipantsInBreakoutRoom;
    public String findParticipantBreakoutRoom;
    public boolean open;
    
    public VirtualRoom(String name)
    {
        this.name = name;
        this.BreakoutRoomLimit = 5;
    }

    public VirtualRoom(String name, int limit)
    {
        this.name = name;
        this.BreakoutRoomLimit = limit;
    }
    
    public void createBreakoutRoom()
    {
        BreakoutRoom b= new BreakoutRoom("Breakout Room");
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber)
    {
        if(open)
        {
            for(int i=0; i<=roomNumber;i++)
            {
                
            }
        }return null;
    }
    
    public boolean closeBreakoutRoom()
    {
        if(breakoutRoom = true)
        {
            return true;
        }
        return false;
    }
    
    public boolean openBreakoutRoom()
    {
        if(breakoutRoom = false)
        {
            return true;
        }
        return false;
    }
    
    public String listBreakoutRooms()
    {
        String details = "";
        return details + ("Breakout rooms") + breakoutRoom;
    }
    
    /*public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber)
    {
        if(open){
            for(int i=0; i<=roomNumber; i++)
            {
                if(findParticipant(roomNumber[i].getParticipantID()).equals(null))
                {
                    
                    
                }
            }
        }
        if(numberOfParticipants<10)
            return true;
        closeBreakoutRoom();
        return false;
    }
    
    public String findParticipantBreakoutRoom(String participantID)
    {
        if(open)
        {
            for(int i=0; i<getNumberOfBreakoutRooms; i++)
            {
                if(findParticipant(getNumberOfBreakoutRooms[i].getParticipantID()).equals(null))return breakoutRoomID;
            }
        }
        return null;
    }*/
}
