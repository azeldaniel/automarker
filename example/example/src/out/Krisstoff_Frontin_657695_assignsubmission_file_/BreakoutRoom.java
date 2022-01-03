package out.Krisstoff_Frontin_657695_assignsubmission_file_;
/**
 * Krisstoff Frontin
 * 816001130
 * 
 * 
 */
public class BreakoutRoom
{
    
    private String breakoutRoomID;
    private int breakoutRoomNumberCounter;
    private int breakoutRoomSize;
    private int numberOfParticipants = 0;
    private boolean open; 
    Participant participants[];
    Participant p;

    /**
     * Constructor for objects of class BreakoutRoom
     */
    public BreakoutRoom(String name)
    {
        
        breakoutRoomID = name;
        
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public boolean addParticipant(String participantID)
    {
        int i;
        if(numberOfParticipants >= 50){
            return false; 
        }else{
            p = new Participant(participantID);
            participants[numberOfParticipants+1] = p;
            numberOfParticipants++;
        }
        return true;
    }
    public Participant findParticipant(String participantID)
    {
        return p;
        
    }
    public String listParticipants()
    {
        String s;
        s = " ";
        return s;
    }
    public String toString()
    {
        String s;
        s = " ";
        return s;
        
    }
    public void closeBreakoutRoom()
    {
    }
    public void openBreakoutRoom()
    {
    }
}
