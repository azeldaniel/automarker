package out.Aniel_Heera_657752_assignsubmission_file_;//ID:816004672
/**
 * Write a description of class BreakoutRoom here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BreakoutRoom
{
    // instance variables - replace the example below with your own
    private String breakoutRoomID;
    private int breakoutRoomNumberCounter;
    private int breakoutRoomSize;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;
    

    /**
     * Constructor for objects of class BreakoutRoom
     */
    public BreakoutRoom(String name)
    {
        // initialise instance variables
        participants = new Participant[10];
        numberOfParticipants = 0;
        breakoutRoomSize = 10;
        open = false;
        name = null;
    }
    
    public boolean addParticipant(String participantID)
    {
       if(numberOfParticipants < 10){
           Participant p = new Participant(participantID);
           participants[numberOfParticipants] = p;
           return true;
       }else{
           return false;
        }
     
    }
    
    public Participant findParticipant(String participantID)
    {
        Participant p = participants[10];
        for(int i = 0; i < numberOfParticipants; i++)
            if(p.equals(participantID))
                return p;
          return null;
   }
    
    public String listParticipants()
    {
        String str = breakoutRoomID;
        str += "\n";
        for(int i = 0; i < breakoutRoomSize; i++){
            str += "participant_(i+1) " + participants[i] + "\n";
        }
        return str;
    }
    
    public String toString()
    {
        String details ="Seminar" + breakoutRoomID + " " + "OPEN " + numberOfParticipants;
        return details;
    }
    
    public void closeBreakoutRoom()
    {
        if(open == true){
            open = false;
        }
    }
    
    public void openBreakoutRoom()
    {
        if(open == false){
            open = true;
        }
    }
    
}
