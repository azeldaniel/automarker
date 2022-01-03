package out.Rashad_Downes_657743_assignsubmission_file_;
/**
 * ID#: 816015845
 *
 * @author (Rashad Downes)
 * @version (Thursday, February 11th, 2021)
 */

public class BreakoutRoom
{
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter = 0;
    private final int breakoutRoomSize = 10;
    private int numberOfParticipants = 0;
    private boolean open;

    private Participant[] participants = new Participant[10];

    public BreakoutRoom (String name){
        breakoutRoomNumberCounter++;  //increment class variable
        breakoutRoomID = name + breakoutRoomNumberCounter;
        numberOfParticipants = 0;
        participants = new Participant[breakoutRoomSize];
        open = true;
        //System.out.println("Room created " + breakoutRoomID);
    }

    public boolean addParticipant(String participantID){
        Participant participant = new Participant (participantID);
        boolean added = false;
        boolean found = false;

        if(participant.verifyID(participant.getParticipantID()) == true)
            if(getOpen() == true)
                if(getNumberOfParticipants() > 0){
                    for(int i=0; i<getNumberOfParticipants(); i++){
                        if(participants[i].getParticipantID().equals(participant.getParticipantID())){
                            found = true;
                            return added;
                        }
                    }

                    if(getNumberOfParticipants() < breakoutRoomSize){
                        participants[numberOfParticipants] = participant;
                        numberOfParticipants++;
                        added = true;    
                    }
                }      

                else if ((found == false) && (getNumberOfParticipants() < breakoutRoomSize)){
                    participants[numberOfParticipants] = participant;
                    numberOfParticipants++;
                    added = true;
                }

        return added;
    }

    public int getNumberOfParticipants(){
        return numberOfParticipants;
    }
    
    public String getBreakoutRoomID(){
        return breakoutRoomID;
    }
    
    public int getBreakrooms(){
        return breakoutRoomNumberCounter;
    }
    
    public Participant findParticipant(String participantID){
        for(int i=0; i<getNumberOfParticipants(); i++)
            if(participants[i].getParticipantID().equals(participantID))
                return participants[i];                   
        return null;
    }

    public String listParticipants(){
        String details = new String();
        details += getBreakoutRoomID() + "\n";
        for(int i=0; i<getNumberOfParticipants(); i++)
            details += participants[i].getParticipantID() + "\n";
        return details + "\n";
    }

    private String roomStatus(){
        String status;
        if(getOpen() == true)
            status = "OPEN";
        else
            status = "CLOSED"; 

        return status;
    }

    public boolean getOpen(){
        return open;
    }

    public String toString(){
        return getBreakoutRoomID() + " " + roomStatus() + " " + getNumberOfParticipants() + "\n"; 
    }

    public void closeBreakoutRoom(){
        if(getOpen() == true)
            for(int i=0; i<getNumberOfParticipants(); i++)
                participants[i] = new Participant(null);
        numberOfParticipants = 0;        
        open = false;   
    }

    public void openBreakoutRoom(){
        if(getOpen() == false)
            open = true;
    }
}
