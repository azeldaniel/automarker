package out.Gerard_Bharath_657771_assignsubmission_file_;
/**
 * 
 *
 * @Gerard Bharath
 * 816020015
 * @version (a version number or a date)
 */
public class VirtualRoom
{
    // instance variables - replace the example below with your own
    public String name;
    private int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;

    /**
     * Constructor for objects of class VirtualRoom
     */
    public VirtualRoom(String name)
    {
        // initialise instance variables
        breakoutRoomLimit= 5;
        breakoutRooms= new BreakoutRoom[5];
        this.name= name;
    }
    
    public VirtualRoom(String name, int limit)
    {
        this.name= name;
        this.breakoutRoomLimit= limit;
        this.breakoutRooms= new BreakoutRoom[limit];    
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getNumberOfBreakoutRooms()
    {
        // put your code here
        return breakoutRoomLimit;
    }
    
    public void createBreakoutRooms()
    {
        breakoutRooms= new BreakoutRoom[breakoutRoomLimit];
        for (int i= 0; i< this.breakoutRoomLimit; i++)
        {
            breakoutRooms[i]= new BreakoutRoom(name);
        }        
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber)
    {
        for (int i= 0; i< this.breakoutRoomLimit; i++)
        {
            if(i== roomNumber){            
                return this.breakoutRooms[i];
            }
        }
        return null;
    }   
    
    public boolean closeBreakoutRoom(int roomNumber)
    {
        breakoutRooms[roomNumber].closeBreakoutRoom();
        return true;
    }

    
    public boolean openBreakoutRoom(int roomNumber)
    {
        breakoutRooms[roomNumber].openBreakoutRoom();
        return false;
    }    
    
    public String listBreakoutRooms()
    {
        String details = "List of Virtual Rooms: " +"\n";
        for (int i= 0; i< this.breakoutRoomLimit; i++)
        {
            details +=breakoutRooms[i].toString() +"\n";
        }
            return details;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber)
    {
        String details = "";
            
            for (int i= 0; i< this.breakoutRoomLimit; i++)
            {
                if(i== roomNumber){
                details= breakoutRooms[roomNumber].listParticipants();
                return details;
                }
            }
            return null;
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber)
    {
        BreakoutRoom room= new BreakoutRoom(" ");
        room= findBreakoutRoom(roomNumber);
        boolean addNewParticipant;
        
        if(room!= null)
        {
            addNewParticipant= room.addParticipant(participantID);
            if(addNewParticipant== true)
            {
            return true;
            }
        }
        return false;        
    }
    
    public String findParticipantBreakoutRoom(String participantID)
    {
        for (int i= 0; i< this.breakoutRoomLimit; i++)
        {
            if(this.breakoutRooms[i].findParticipant(participantID)!= null)
            {
                return breakoutRooms[i].toString();
            }
        }
        return null;
    } 
}
