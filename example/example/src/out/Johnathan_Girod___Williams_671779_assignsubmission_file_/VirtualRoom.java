package out.Johnathan_Girod___Williams_671779_assignsubmission_file_;
/**
 
 
 * Johnathan Girod-Williams 816004809
 * Feb 15th 2021
 */
public class VirtualRoom
{
    // instance variables - replace the example below with your own
    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;

    /**
     * Constructor for objects of class VirtualRoom
     */
    public VirtualRoom(String name)
    {
        // initialises breakoutRoom to 
        
        this.name = name;
        this.breakoutRoomLimit = 5;
        this.breakoutRooms = new BreakoutRoom[5];
        
        createBreakoutRooms();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    
    
    public VirtualRoom(String name, int limit)
    {
        this.name = name;
        this.breakoutRoomLimit = limit;
        this.breakoutRooms = new BreakoutRoom[limit];
        
        createBreakoutRooms();
    }
    
    public int getNumberOfBreakoutRooms()
    {
        //
        return this.breakoutRoomLimit;
    }
    
    public void createBreakoutRooms()
    {
        String s = "";
        
        for(int i = 0; i < this.breakoutRoomLimit ; i++)
        {
            s += this.name + i;
            
            this.breakoutRooms[i] = new BreakoutRoom(s);
            
            s = "";
        }
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber)
    {
        return this.breakoutRooms[roomNumber];
    }
    
    public boolean closeBreakoutRoom(int roomNumber)
    {
        try 
        {
            this.breakoutRooms[roomNumber].closeBreakoutRoom();
        }
        catch(Exception e) {
            return false;
        }
        
        return true;
    }
    
    public boolean openBreakoutRoom(int roomNumber)
    {
        try 
        {
            this.breakoutRooms[roomNumber].openBreakoutRoom();
        }
        catch(Exception e) {
            return false;
        }
        
        return true;
    }
    
    public String listBreakoutRooms()
    {
        String s = "";
        
        for(int i = 0; i < this.breakoutRoomLimit ; i++)
        {
            s+= this.name + i + " ";
        }
        
        return s;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber)
    {
        return this.breakoutRooms[roomNumber].listParticipants();
    }
    
    public boolean addParticipantToBreakoutRoom(String paticipantID, int roomNumber)
    {
        
        try 
        {
            return this.breakoutRooms[roomNumber].addParticipant(paticipantID);
        }
        catch(Exception e) {
            return false;
        }
        
        
    }
    
    public String findParticipantBreakoutRoom(String participantID)
    {
        Participant p;
        
        for(int i = 0; i < this.breakoutRoomLimit; i++)
        {
            p = this.breakoutRooms[i].findParticipant(participantID);
            
            if(p!=null)
            {
                return this.name + i + " ";
            }
        }
        
        return null;
    }
    
    
}
