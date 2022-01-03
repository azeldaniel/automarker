package out.Aniel_Heera_657752_assignsubmission_file_;//ID:816004672
/**
 * Write a description of class VirtualRoom here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class VirtualRoom
{
    // instance variables - replace the example below with your own
    private String name;
    private int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;
    int numberOfBreakoutRooms;

    /**
     * Constructor for objects of class VirtualRoom
     */
    public VirtualRoom(String name)
    {
        breakoutRoomLimit = 5;
        breakoutRooms = new BreakoutRoom[5];
        numberOfBreakoutRooms = 0;
        name = null;
    }
    
    public VirtualRoom(String name, int limit)
    {
        breakoutRoomLimit = limit;
    }
    
    public int getNumberOfBreakoutRooms()
    {
        return numberOfBreakoutRooms;
    }
    
    public void createBreakoutRooms()
    {
        for(int i=0; i<breakoutRoomLimit; i++)
            breakoutRooms[i] = new BreakoutRoom("");
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber)
    {
        BreakoutRoom b = breakoutRooms[10];
        for(int i=0; i<breakoutRoomLimit; i++)
            if(b.equals(roomNumber))
                return b;
           return null;
    }
    
    public String listBreakoutRooms(){
        String str = name;
        str += "\n";
        for(int i = 0; i < breakoutRoomLimit; i++){
            str += "breakoutRoom_(i+1) " + breakoutRooms[i] + "\n";
        }
        return str;
        
    }
    
    
}
