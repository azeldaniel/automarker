package out.Alphonso_Balbosa___Armour_657701_assignsubmission_file_;//STUDENT I.D. == 816018750
/**
 * Write a description of class BreakoutRoom here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BreakoutRoom
{
    private String name;
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter = 0;
    private final int breakoutRoomSize = 10;
    private int numberOfParticipants;
    private boolean open;
    private String participantID;
    private Participant[] participants;

    public BreakoutRoom(String name)
    {
        breakoutRoomID = name + breakoutRoomNumberCounter;
        breakoutRoomNumberCounter++;
        numberOfParticipants = 0;
        open = true;
        participants = new Participant[breakoutRoomSize];
    }

    public boolean addParticipant(String participantID)
    {
        if(Participant.verifyID(participantID) == true && numberOfParticipants != 10 && open == true){
            numberOfParticipants++;
            participants[numberOfParticipants-1] = new Participant(participantID);
            return true;
        }
        return false;
    }

    public Participant findParticipant(String participantID){
        for(int i=0; i<numberOfParticipants; i++)
        {
            String temp = participants[i].getParticipantID();
            if(participantID.equals(temp)){
                return participants[i];
            }
        }
        return null;
    }

    public String listParticipants()
    {
        String listParticipants = "Breakout Room ID: " + breakoutRoomID + "\n";
        for(int i=0; i<numberOfParticipants; i++)
        {
            listParticipants += i+1 + ". " + participants[i].getParticipantID() + "\n" ;
        }
        return listParticipants;
    }

    public String toString(){
        String details = breakoutRoomID + " ";
        if(open == true){
            details += "OPEN ";
        }else{
            details += "CLOSED ";
        }
        details += numberOfParticipants;
        return details;
    }

    public void closeBreakoutRoom(){
        open = false;
        participants = null;
        numberOfParticipants = 0;
    }

    public void openBreakoutRoom()
    {
        open = true;
        participants = new Participant[breakoutRoomSize];   
    }

    public String getBreakoutRoomID()
    {
        return breakoutRoomID;
    }

    public int getNumberOfParticipants()
    {
        return numberOfParticipants;
    }

    public boolean getOpen()
    {
        return open;
    }

}
