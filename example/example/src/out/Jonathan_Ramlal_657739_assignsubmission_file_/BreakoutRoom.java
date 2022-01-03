package out.Jonathan_Ramlal_657739_assignsubmission_file_;
/**
 * Write a description of class VirtualMeeting here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BreakoutRoom
{
    public String breakoutRoomID;
    public int breakoutRoomNumberCounter;
    public int breakoutRoomSize;
    public Participant[] participants;
    public int numberOfParticipants;
    public boolean open;

    public BreakoutRoom(String name){ //Overloaded Constructor
        this.breakoutRoomID=name+breakoutRoomNumberCounter;
        breakoutRoomNumberCounter=0;
        breakoutRoomSize=10;
        participants= new Participant[10];
        numberOfParticipants=0;
        open=true;
    }

    

    public boolean addParticipant(String participantID)
    {
        if(open){
            for(int i=0; i<=numberOfParticipants; i++)
            {
                if(findParticipant(participants[i].getParticipantID()).equals(null))
                {
                    numberOfParticipants++;
                    participants[i+1]= new Participant(participantID);
                }
            }
        }
        if(numberOfParticipants<10)
            return true;
        closeBreakoutRoom();
        return false;
    }
    
    public Participant findParticipant(String participantID)
    {
        if(open)
        {
            for(int i=0; i<=numberOfParticipants;i++)
            {
                if(participantID.equals(participants[i].getParticipantID()))return participants[i];
            }
        }   return null;
    }

    //Functions

    public void openBreakoutRoom()
    {
        this.open=true;
    }

    public void closeBreakoutRoom()
    {
        this.open=false;
    }

    public String toString()
    {
        if(open)
            return(this.breakoutRoomID+" is Open "+ numberOfParticipants);
        return(this.breakoutRoomID+" is Closed "+ numberOfParticipants);
    }

    public String listParticipants()
    {
        String list="";
        String name="";
        for(int x=0; x<=numberOfParticipants; x++)
        {
            list+=participants[x].getParticipantID()+" "+"\n";
        }
        return list;
    }

    //main
    public static void main(String[] args)
    {
        Participant p=new Participant("Jane");
        BreakoutRoom b=new BreakoutRoom("Breakout Room");
    }
}
