package out.Isaiah_Norcisse_657783_assignsubmission_file_;// Student ID : 816016804
// COMP 2603 A1

public class VirtualRoom
{
    private String name;
    private int breakoutRoomLimit;
    protected BreakoutRoom[] breakoutRooms;
    
    /**
     * Constructor for objects of class VirtualRoom
     */
    public VirtualRoom(String name)
    {
         this.name=name;
         this.breakoutRoomLimit=5;
         this.breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }

    public String getName()
    {
        return this.name;
    }
    
    public VirtualRoom(String name, int limit)
    {
         this.name=name;
         this.breakoutRoomLimit=limit;
         this.breakoutRooms = new BreakoutRoom[breakoutRoomLimit];

    }
    
    public int getNumberOfBreakoutRooms()
    {
        return  breakoutRooms.length;
    }
    
    public void createBreakoutRooms()
    {
        for(int i =0;i<getNumberOfBreakoutRooms();i++){
        this.breakoutRooms[i]= new BreakoutRoom(getName());
        this.breakoutRooms[i].setBRCounter(i+1);
       }
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber)
    {
        for(int i =0;i<getNumberOfBreakoutRooms();i++)
        {
            if(roomNumber==this.breakoutRooms[i].getBreakoutRoomNumberCounter())
            {
                return breakoutRooms[i];
            }
        }
        return null;
    }
    
    public boolean closeBreakoutRoom(int roomNumber)
    {
        for(int i =0;i<getNumberOfBreakoutRooms();i++)
        {
            if(roomNumber==this.breakoutRooms[i].getBreakoutRoomNumberCounter())
            {
                breakoutRooms[i].closeBreakoutRoom();
                return true;
            }
        }
        return false;
    }
    
    public boolean openBreakoutRoom(int roomNumber)
    {
        for(int i =0;i<getNumberOfBreakoutRooms();i++)
        {
            if(roomNumber==this.breakoutRooms[i].getBreakoutRoomNumberCounter())
            {
                breakoutRooms[i].openBreakoutRoom();
                return true;
            }
        }
        return false;
    }
    
    public String listBreakoutRooms( )
    {
        String details="";
        for(int i =0;i<getNumberOfBreakoutRooms();i++)
        {
            details+=breakoutRooms[i].toString();
        }
        return details;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber)
    {
        BreakoutRoom br= new BreakoutRoom("");
        if(findBreakoutRoom(roomNumber)!= null)
         {
            br=findBreakoutRoom(roomNumber);
            return br.listParticipant();
        }
        else 
            return null;
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber)  
    {
        
        if(roomNumber<=breakoutRooms.length)
         {
            breakoutRooms[roomNumber].addParticipant(participantID);
            return true;
        }
        return false;
    }
    
    public String findParticipantBreakoutRoom(String participantID)
    {   

        for(int i =0;i<getNumberOfBreakoutRooms();i++)
        {
            if(breakoutRooms[i].findParticipant(participantID).getParticipantID()==participantID)
                return breakoutRooms[i].getBreakoutRoomID();
        }
        return null;
    }
}
