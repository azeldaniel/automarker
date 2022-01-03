package out.Kemeisha_Wilson_657772_assignsubmission_file_;/**
 * @author (Kemeisha Wilson 816020815)
 * @version (08/02/2021)
 */
public class BreakoutRoom
{
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter;
    private final int breakoutRoomSize;
    private int numberOfParticipants;
    private boolean open;
    private Participant[] participants;
    
    public BreakoutRoom(String name)
    {
        breakoutRoomNumberCounter++;
        breakoutRoomID=name+"_"+breakoutRoomNumberCounter;
        open=false;
        breakoutRoomSize=10;
        numberOfParticipants=0;
        participants=new Participant[10];
    }

    public String getBreakoutRoomID(){ return breakoutRoomID;}

    public int getNumberOfParticipants(){return numberOfParticipants;}
    public boolean getOpen(){return open;}

    public boolean addParticipant(String participantID)
    {
        if(breakoutRoomSize==numberOfParticipants)
            return false;
        Participant p=new Participant(participantID);
        if(!p.verifyID(participantID)){
            System.out.println("ID Not valid");
            return false;
        }
        p=null;
        if(participants[numberOfParticipants]==null){
            for(int x=0;x<numberOfParticipants;x++){
                if(participants[x].getParticipantID().equals(participantID)){
                    System.out.println("This ID is already in room");
                    return false;
                }
            }
            participants[numberOfParticipants]=new Participant(participantID);
            numberOfParticipants++;
            return true;
        }
        return false;
    }
    public Participant findParticipant(String participantID)
    {
        Participant p= new Participant(participantID);
        if(open){
            if(!p.verifyID(participantID)){
                System.out.println("ID Not valid");
                return null;
            }
            for(int x = numberOfParticipants - 1; x >= 0; x--){
                if(participantID.equals(participants[x].getParticipantID())){
                    return participants[x];
                }  
                else 
                    return null;
            }
        }
        return null;
    }
    public String listParticipants()
    {
        if(open){

            String details;
            details="BreakoutRoom ID:  "+breakoutRoomID+"\n";
            for(int x=0;x<numberOfParticipants;x++){
                details+=participants[x].toString()+"\n";
            }
            return details;
        }
        else{
            String details;
            details=breakoutRoomID;
            return details;
        }
    }
    public String toString()
    {
        String details=breakoutRoomID ;
        if(open)
            details +=" OPEN";
        else
            details +=" CLOSED";
        details+= "\n Number of participants in room: " + numberOfParticipants;
        return details;
    }
    public void closeBreakoutRoom()
    {
        if(!open)
            System.out.println("This breakout room is already closed");
        else{
            for(int x=0;x<numberOfParticipants;x++){
                participants[x]=null;
            }
            open=false;
        }
    }
    public void openBreakoutRoom()
    {
        if(open)
            System.out.println("This breakout room is already open");
        else
            open=true;
    }
}
