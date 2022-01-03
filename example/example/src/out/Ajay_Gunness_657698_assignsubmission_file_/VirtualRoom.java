package out.Ajay_Gunness_657698_assignsubmission_file_;public class VirtualRoom
{
    String name;
    int breakoutRoomLimit;
    BreakoutRoom[] breakoutRooms;
    
    //Constructor for objects of class VirtualRoom

    public VirtualRoom(String name, int limit)
    {
        // initialise instance variables
        breakoutRoomLimit = 5;
        breakoutRoomLimit = limit; 
    }

    public int getNumberOfBreakoutRooms()
    {
        // code go here
        return breakoutRoomLimit;
    }
    
    public void createBreakoutRoom() 
    {
        // code go here
        for(int x=0; x<getNumberOfBreakoutRooms(); x++)
        {
            BreakoutRoom breakoutRooms[] = new BreakoutRoom[x];
        }
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber)
    {
        // return type is BreakoutRoom
        for(int x=0; x<getNumberOfBreakoutRooms(); x++)
        {
            if(breakoutRooms[x].breakoutRoomID.equals(roomNumber))
            {
                return breakoutRooms[x];
            }
        }
        return null;
    }
    
    public boolean openBreakoutRoom(int roomNumber)
    {
        BreakoutRoom test;
        test = findBreakoutRoom(roomNumber);
        if(!test.equals(null))
        {
            if(test.open)
            {
                return true;
            }
        }
        return false;
    }
    
    public boolean closeBreakoutRoom(int roomNumber)
    {
        // code go here
        BreakoutRoom test;
        test = findBreakoutRoom(roomNumber);
        if(!test.equals(null))
        {
            if(!test.open)
            {
                return false;
            }
        }
        return true;
    }
    
    public String listBreakoutRooms()
    {
        //code go here
        String listBreakoutRooms = name + "\n";
        for(int x =0; x<getNumberOfBreakoutRooms(); x++)
        {
            listBreakoutRooms += breakoutRooms[x].breakoutRoomID + " \n";   
        }        
        return listBreakoutRooms;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber)
    {
        //code go here
        BreakoutRoom room;
        room = findBreakoutRoom(roomNumber);
        if(!room.equals(null)) 
        {
            return room.listParticipants();
        }
        return null;
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber)
    {
        //code go here
        BreakoutRoom add;
        add = findBreakoutRoom(roomNumber);
        
        if(!add.equals(null))
        {
            add.addParticipant(participantID);
            return true;
        }
        return false;
    }
    
    public String findParticipantBreakoutRoom(String participantID)        
    {
        //code go here
        return "sample";
    }
    
}
