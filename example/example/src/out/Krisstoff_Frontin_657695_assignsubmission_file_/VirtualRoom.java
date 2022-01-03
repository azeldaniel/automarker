package out.Krisstoff_Frontin_657695_assignsubmission_file_;
/**
 * Krisstoff Frontin
 * 816001130
 * 
 */
public class VirtualRoom
{
    
    private int x;
    private String name;
    private int breakoutRoomLimit;
    BreakoutRoom[] breakoutRooms;
    BreakoutRoom b;

    /**
     * Constructor for objects of class VirtualRoom
     */
    public VirtualRoom(String name)
    {
        
        name = name; 
    }
    public VirtualRoom(String name, int limit)
    {
        name = name;
        breakoutRoomLimit = limit; 
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getNumberOfBreakoutRooms()
    {
        
        int num;
        num = 0;
        return num;
    }
    public void createBreakoutRooms()
    {
        
    }
    public BreakoutRoom findBreakoutRoom(int roomNumber)
    {
        return b;
    }
    public boolean closeBreakoutRoom(int roomNumber)
    {
        return true;
    }
    public boolean openBreakoutRoom(int roomNumber)
    {
        return true;
    }
    public String listBreakoutRooms()
    {
        String s;
        s = " ";
        return s;
    }
    public String listParticipantsInBreakoutRoom(int roomNumber)
    {
        String s;
        s = " ";
        return s;
        
    }
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber)
    {
        return true;
    }
    public String findParticipantBreakoutRoom(String participantID)
    {
        String s;
        s = " ";
        return s;
    }
}
