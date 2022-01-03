package out.Danielle_Charles_657700_assignsubmission_file_;
/**
 * @author Danielle Charles 816017229
 */
import java.util.*;

public class BreakoutRoom
{
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter = 0;
    private final int breakoutRoomSize;
    private Participant[] participants;
    private int numberOfParticipants = 0;
    private boolean open;
    //private boolean exists;

    public BreakoutRoom(String name)
    {
        participants = new Participant[10];
        breakoutRoomNumberCounter++;
        breakoutRoomID = name + breakoutRoomNumberCounter;
        breakoutRoomSize = 10;
    }

    public boolean addParticipant(String participantID)
    {
        if (Participant.verifyID(participantID) && open==true && numberOfParticipants<breakoutRoomSize)
        {
            for(int i = 0; i < participants.length; i++)
            {
                if(participants[i]!=null && participants[i].getParticipantID().equals(participantID))
                {
                    return false;
                }
            }
            Participant p = new Participant(participantID);
            participants[numberOfParticipants] = p;
            //System.out.println(p);
            numberOfParticipants++;
            //System.out.println(numberOfParticipants);
            return true;
        }
        return false;
    }
    
    public Participant findParticipant(String participantID)
    {
        if(Participant.verifyID(participantID) && open == true)
        {
            for(int i = 0; i<numberOfParticipants;i++)
            {
                if(participants[i].getParticipantID().equals(participantID))
                {
                    return participants[i];
                }
            }
        }
        return null;
    }
    
    public String listParticipants()
    {
        String participantList = breakoutRoomID;
        
        if (numberOfParticipants == 0)
        {
            return participantList +" is empty";
        }
        else
        {
            for(int i = 0; i < numberOfParticipants; i++)
            {
                participantList = participantList + "\n" + participants[i];
            }
                
        }
        return participantList;   
    }
    
    public String toString()
    {
        if (open == true)
        {
            return breakoutRoomID + " OPEN " + numberOfParticipants;
        }
        else
        { return breakoutRoomID + " CLOSED " + numberOfParticipants;
        }
    }
    
    public void closeBreakoutRoom()
    {
        this.open = false;
    }
    
    public void openBreakoutRoom()
    {
        this.open = true;
    }
    
    public int getBreakoutRoomNumberCounter()
    {
        return breakoutRoomNumberCounter;
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
    /*public static void main(String[] args)
    {
        BreakoutRoom br = new BreakoutRoom("testing");
        br.openBreakoutRoom();
        System.out.println(br.addParticipant("12345678"));
        System.out.println(br.addParticipant("23456789"));
        //System.out.println(br.listParticipants());
        //System.out.println(br.findParticipant("12345678"));
        System.out.println(br.toString());
    }*/
    
}
