package out.Chantel_Lewis_657735_assignsubmission_file_;
/**
 * Write a description of class BreakoutRoom here.
 *
 * @author 816011391
 * @version 05/03/2021
 */

public class BreakoutRoom
{
    // instance variables - replace the example below with your own
    private String breakoutRoomID;
    private String breakoutRoomName;
    private static int breakoutRoomNumberCounter = 0;
    private final int breakoutRoomSize ;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;
    private String breakoutRoomState;

    /**
     * Constructor for objects of class BreakoutRoom
     */
    public BreakoutRoom(String name)
    {
        // initialise instance variables
        this.breakoutRoomID = "";
        this.breakoutRoomNumberCounter += breakoutRoomNumberCounter++;
        this.breakoutRoomName = name + breakoutRoomNumberCounter;
        this.open = true; 
        this.breakoutRoomState = "";
        this.numberOfParticipants = 0;
        this.breakoutRoomSize = 10;
        this.participants = new Participant[breakoutRoomSize];
    } 
    
    public String getBreakoutRoomID()
    {
        return breakoutRoomID;
    }
    
    public String setBreakoutRoomID()
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
    
    public boolean addParticipant(String participantID)
    {
        int i;
        Participant participant = new Participant(participantID);
        if(open && participant.verifyID(participantID) == true)
        {
            for(i = 0; i <= numberOfParticipants; i++)
            {
                if(participants[i].equals(participantID))
                {
                    return false;
                }
            }
        }
        participants[numberOfParticipants] = participant;
        numberOfParticipants++;
        
        return true;
    }
    
    public Participant findParticipant(String participantID)
    {
        int i;
        for(i = 0; i < breakoutRoomSize; i++)
        {
            if(participantID.equals(participants[i]))
            {
                return participants[i];
            }
        }
        return participants[i];
    }
    
    public String listParticipants()
    {
        String details = "Participant: ";
        System.out.println("Breakout Room: " + breakoutRoomID + "\n");
        if(numberOfParticipants == 0)
        {
            System.out.println("There are no participants in this room.");
        }
        else
        { 
            for(int i = 0; i <= numberOfParticipants; i++)
            {
                details += "\n" + participants[i].toString() + "\n";
                System.out.println(details);
            }
        }
        return details;
    }
    
    public String toString()
    {
        String details = "Information for: " + breakoutRoomID;
        if(open)
        {
            breakoutRoomState = "OPEN";
        }
        if(!open)
        {
            breakoutRoomState = "CLOSE";
        }  
        details += " " + breakoutRoomState + " " + numberOfParticipants;
        
        return details;
    }
    
    public void closeBreakoutRoom()
    {
        if(open)
        {
            for(int i = 0; i < breakoutRoomSize; i++)
            {
                participants[i] = null;
            }
            open = false;
            
            //breakoutRoomSize = 0;
            //participants.clear();
        }
        System.out.println(participants);
        System.out.println("CLOSE");
    }
    
    public void openBreakoutRoom()
    {
        if(!open)
        {
            getOpen();
            System.out.println("OPEN");
        }
    }
}
