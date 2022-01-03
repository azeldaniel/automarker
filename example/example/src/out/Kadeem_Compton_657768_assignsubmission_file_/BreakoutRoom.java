package out.Kadeem_Compton_657768_assignsubmission_file_;//814002641

public class BreakoutRoom
{
    
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter = 1;
    private final int breakoutRoomSize;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open = false;


    public BreakoutRoom(String name)
    {
       
       breakoutRoomID = name + breakoutRoomNumberCounter;
       numberOfParticipants = 0;
       breakoutRoomNumberCounter++;
       breakoutRoomSize = 10;
       participants = new Participant[breakoutRoomSize];
       
    }

    public int getNumberOfParticipants()
    {
        return numberOfParticipants;
    }

    public boolean getOpen()
    {
        return open;
    }

    public String getBreakoutRoomID()
    {
        return breakoutRoomID;
    }

    private boolean duplicate (String ID)
    {
        if (numberOfParticipants == 0)
            return false;

        for (int i=0; i < numberOfParticipants; i++)
        {
            if (participants[i].getParticipantID().equals(ID))
                return true;
        }
        return false;
    }

    
    public boolean addParticipant (String participantID)
    {
        if (!open)
        {
            System.out.println("Error. Room is closed, cannot add");
            return false;
        }

        Participant newParticipant = new Participant(participantID);

        if (!Participant.verifyID(participantID))
            return false;

        
        
        if (duplicate(participantID))
        {
            System.out.println("Error, Duplicate participant.");
            return false;
        }

        else if (numberOfParticipants < breakoutRoomSize)
        {
            participants[numberOfParticipants] = newParticipant;
            numberOfParticipants++;
            return true;
        }

        else 
            return false;

    }
    
    public Participant findParticipant (String participantID)
    {
        if (numberOfParticipants == 0)
            return null;

        for (int i=0; i < numberOfParticipants ; i++)
        {
            if (participants[i].getParticipantID().equals(participantID))
                return participants[i];
        }

        return null;
    }


    public String listParticipants( ) 
    {
        String list = "";
        list += breakoutRoomID + ":\n";

        for (int i=0; i < numberOfParticipants ; i++)
        {
           list += "Participant" + (i+1) + ": " +participants[i].toString() + " \n";
           
                
        }
        return list;
    }

    public void closeBreakoutRoom()
    {
        for (int i=0; i < breakoutRoomSize ; i++)
        {
            participants[i] = null;
           
        } 
        numberOfParticipants = 0;
        open = false;

    }


    public void openBreakoutRoom()
    {
        open = true;
    }

    public String toString()
    {
        String status;

        if (open)
            status = "OPEN";
        else 
            status = "CLOSED";
            
        String details;
        details = breakoutRoomID + " " + status + " " +numberOfParticipants;
        return details;
        
    }

}
