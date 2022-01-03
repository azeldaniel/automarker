package out.Jason_Downie_657822_assignsubmission_file_;// 816004029

public class VirtualRoom
{
    private String name;
    private int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;
    
    public VirtualRoom( String name) //constructor for the virtual room
    {
        this.name = name;
        this.breakoutRoomLimit = 5;        
        createBreakoutRooms();
        //this.breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }
    public VirtualRoom( String name, int breakoutRoomLimit)//overloaded constructor
    {
        this.name = name;
        this.breakoutRoomLimit = breakoutRoomLimit;
        createBreakoutRooms();
        //this.breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }
    
    public void createBreakoutRooms() 
    {
        this.breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }
    
    public static int getNumberOfBreakoutRooms() //accessor for breakout rooms
    {
         return BreakoutRoom.breakoutRoomNumberCounter;
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber) 
    {
        for(int i=0; i < BreakoutRoom.breakoutRoomNumberCounter; i++)
        {
            if(this.breakoutRooms[roomNumber].getBreakoutRoomID()!= null)
            return this.breakoutRooms[roomNumber];
        }
        return null;
    }
    
    public boolean closeBreakoutRoom(int roomNumber) 
    {
        if (this.findBreakoutRoom(roomNumber)!= null){
            this.breakoutRooms[roomNumber].closeBreakoutRoom(); //closes room
            return true;
        }
        else 
            return false; //no room found
    }
    public boolean openBreakoutRoom(int roomNumber)
    {
        if (this.findBreakoutRoom(roomNumber)!= null){
            this.breakoutRooms[roomNumber].openBreakoutRoom(); //opens room
            return true;
        }
        else 
            return false; //no room found
    }
    
    public String findParticipantBreakoutRoom(String participantID)
    {
        for(int i =0; i < this.getNumberOfBreakoutRooms(); i++)
        {
            if(this.breakoutRooms[i].findParticipant(participantID) != null)
                return this.breakoutRooms[i].getBreakoutRoomID();
        }
        return null;
    }
    
    public String listBreakoutRooms()
    {
        String details = this.name;
        for (int i = 0;i < this.getNumberOfBreakoutRooms();i++)
        {
            details+= "/n "+this.breakoutRooms[i];
        }
        return details;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber)
    {
        if (this.findBreakoutRoom(roomNumber)!= null){
            return this.breakoutRooms[roomNumber].listParticipants();
        }
        return null;
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber) 
    {
        if (this.findBreakoutRoom(roomNumber)!= null){
        return this.breakoutRooms[roomNumber].addParticipant(participantID);
        }
        return false;
    }
    
    
    
    
}
