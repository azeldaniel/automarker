package out.De_Jhan_Aaron_671781_assignsubmission_file_;public class VirtualRoom
{
    private final int breakoutRoomLimit;
    private String name;
    private BreakoutRoom[] breakoutRooms;
    private BreakoutRoom bRoom;
    public VirtualRoom(String name)
    {
        breakoutRoomLimit = 5;
        this.name = name;
        breakoutRooms = new BreakoutRoom[5];
    }

    public VirtualRoom(String name, int limit)
    {
        breakoutRoomLimit = limit;
        this.name = name;
        breakoutRooms = new BreakoutRoom[limit];
    }
    
    public int getBreakoutRoomLimit()
    {
        return breakoutRoomLimit;
    }
    
    public int getNumberOfBreakoutRooms()
    {
        return breakoutRoomLimit;
    }
    
    public void createBreakoutRooms()
    {
        
        for(int i=0; i< breakoutRoomLimit; i++)
        {
            bRoom = new BreakoutRoom(name);
            breakoutRooms[i] = bRoom;
        }
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber)
    {
        if(roomNumber<getNumberOfBreakoutRooms())
            return breakoutRooms[roomNumber];
        else if(roomNumber == getNumberOfBreakoutRooms())
            return breakoutRooms[roomNumber - 1];
        else
            return null;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        if(findBreakoutRoom(roomNumber) == null)
        {
            System.out.println("Failed to find room.");
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
        if(findBreakoutRoom(roomNumber) == null)
        {
            System.out.println("Failed to find room.");
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
       String brList = name+"\n";
       for(int i = 0; i<getNumberOfBreakoutRooms(); i++)
       {
           brList = brList+ breakoutRooms[i]+"\n";
        }
        return brList;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber)
    {
        if(findBreakoutRoom(roomNumber) != null)
            return breakoutRooms[roomNumber].listParticipants();
        return null;
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber)
    {
        return breakoutRooms[roomNumber].addParticipant(participantID);
    }
    
    public String findParticipantBreakoutRoom(String participantID)
    {
        int i = 0;
        int numberOfRooms = getNumberOfBreakoutRooms();
        while(i < numberOfRooms)
        {
            if(breakoutRooms[i].findParticipant(participantID)!= null)
                return breakoutRooms[i].getBreakoutRoomID();
            i++;
        }
        return null;
    }
}
