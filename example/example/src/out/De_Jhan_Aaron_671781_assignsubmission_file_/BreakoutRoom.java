package out.De_Jhan_Aaron_671781_assignsubmission_file_;/**816018662*/
public class BreakoutRoom
{
    // Attributes
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter;
    private final int breakoutRoomSize;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;
    
    public BreakoutRoom(String name)
    {
        // initialise instance variables
        breakoutRoomNumberCounter = 0;
        breakoutRoomID = "0";
        breakoutRoomID = name + breakoutRoomNumberCounter;
        breakoutRoomSize = 10;
        Participant[] participants = new Participant[10];
        numberOfParticipants = 0;
        open = true;
    }

    //Methods
    public boolean addParticipant(String participantID)
    {
        Participant p = new Participant(participantID);
        if(numberOfParticipants != 10 && p.verifyID(participantID) == true)
        {
            for(int i=0;i<numberOfParticipants; i++)
            {
                if(participants[i].getParticipantID() == participantID)
                    return false;
            }
            participants[numberOfParticipants] = p;
            numberOfParticipants += 1;
            return true;
        }
        return false;
    }
    
    public Participant findParticipant(String participantID)
    {
        int i = 0;
        boolean found;
        while((participants[i].getParticipantID() != participantID) && (i<numberOfParticipants))
        {
            i++;
        }
        if(participants[i].getParticipantID() == participantID)
            return participants[i];
        else
            return null;
    }
    
    public String listParticipants()
    {
        String participantList = null;
        for(int i = 0; i<numberOfParticipants; i++)
        {
            participantList = participantList+ participants[i].getParticipantID();
        }
        return participantList;
    }
    
    public String toString()
    {
        String bRoom = "Breakout Room #"+breakoutRoomNumberCounter+"\nID: "+ breakoutRoomID+ "\nRoom Size: "+breakoutRoomSize+"\nNumber of Participants: "+numberOfParticipants+"\nStatus: ";
        if(open == true)
            bRoom = bRoom + "Open";
        else
            bRoom = bRoom + "Closed";
        return bRoom;
    }
    
    public int getNumberOfParticipants()
    {
        return numberOfParticipants;
    }
    
    public boolean getOpen()
    {
        return open;
    }
    
    public void closeBreakoutRoom()
    {
        open = false;
    }
    
    public void openBreakoutRoom()
    {
        open = true;
    }
    
    public String getBreakoutRoomID()
    {
        return breakoutRoomID;
    }
}