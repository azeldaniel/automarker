package out.Leeia_Ahyew_657830_assignsubmission_file_;//816016640
public class BreakoutRoom
{
    
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter=0;
    private int breakoutRoomSize;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;
    private String name;
    private String state;

    public BreakoutRoom(String name)
    {
    
        this.breakoutRoomNumberCounter++;
        this.breakoutRoomID = name+ " "+breakoutRoomNumberCounter;
        this.name=name;
        this.breakoutRoomSize = 10;
        this.participants = new Participant[breakoutRoomSize];
        this.numberOfParticipants = 0;
        this.open = true;
    }

    public boolean addParticipant(String participantID)
    {
       
        Participant par = new Participant(participantID);
        if(par.verifyID(participantID)&& open){
              for(int count = 0; count<50;count++){
                if(participants[count].equals(participantID)){
                return false;
                }
              }
        }
              participants[numberOfParticipants] = par;
              numberOfParticipants = numberOfParticipants + 1;

        return true;

    }


    public Participant findParticipant (String participantID){
        for(int count = 0; count<numberOfParticipants;count++){
            if((participants[count].getParticipantID()).equals(participantID)){
                return participants[count];
            }
        }

        return null;
    }

    public String listParticipants(){
        String parlist = "Room ID: " +breakoutRoomID+ ' ' +"Participants: " +' ';
        for(int count = 0; count<numberOfParticipants;count++){
            parlist += " " +participants[count].toString()+ ' ';
            }
        return parlist;
    }

    public void closeBreakoutRoom(){
        this.open = false;
        participants = new Participant[breakoutRoomSize];
        numberOfParticipants = 0;
    }

    public void openBreakoutRoom(){
        this.open = true;
    }

    public String toString(){
        if(open == true)
            state = "OPEN";

        if(open == false)
            state = "CLOSED";
    return ""+breakoutRoomID+ " " +state+ " "+numberOfParticipants;
    }

    public String setID(){
        return breakoutRoomID;
    }

    public int getnumberOfParticipants(){
        return numberOfParticipants;
    }

    public boolean stateOpen(){
        return this.open;
    }
}
