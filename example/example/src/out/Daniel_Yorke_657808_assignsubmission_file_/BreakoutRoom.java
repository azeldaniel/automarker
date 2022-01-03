package out.Daniel_Yorke_657808_assignsubmission_file_;/**
* 816019400
 */
//import java.util.*;  
public class BreakoutRoom{
    String breakoutRoomID;
    int breakoutRoomNumberCounter;
    int breakoutRoomSize = 10;
    int numberOfParticipants;
    Participant [ ] participants = new Participant [breakoutRoomSize];
    boolean open;

    BreakoutRoom(String name){
        breakoutRoomID = name;
        numberOfParticipants = 0;
        open = false;
    }   
    public boolean addParticipant( String participantID){
        if(!open){
            return false;
        }
        Participant p = new Participant("000000");
        if(!p.verifyID(participantID)){
            return false;
        }
        //System.out.println("Open and verify adding participant --BR");
        //System.out.println("numberOfParticipants-- "+ numberOfParticipants);
        for(int i = 0; i <numberOfParticipants ;i++){
            try{
                //System.out.println("Participants.... "+ participants[i].participantID);
                if(participants[i].equals(participantID)){
                return false;
            }
        }catch(Exception e){
                return false;
            }
        }
        
        //System.out.println("Adding........");
        participants[numberOfParticipants] = new Participant(participantID);
        numberOfParticipants++;
        //System.out.println("Added+++++++++" + participantID);
        
        return true;
    }
    public Participant findParticipant( String participantID){
        if(!open){
            return null;
        }
        if(!participants[0].verifyID(participantID)){
            return null;
        }
        for(int i = 0; i <numberOfParticipants ;i++){
            if(participants[i].equals(participantID)){
                return participants[i];
            }
        }
        return null;
    }
    public String listParticipants( ){
        String list = new String();
        list = breakoutRoomID + "\n";
        try{
            for(int i = 0; i <numberOfParticipants ;i++){
            list = list + participants[i].participantID + ", ";
            return list;
        }
        }catch(Exception e){
            return list;
        }
        return list;
    }
    public String toString( ){
        String format = new String();
        format = breakoutRoomID;
        if(open){
            format = format + " OPEN ";
        }
        else
            format = format + " CLOSE " ;
        format = format + Integer.toString(numberOfParticipants);
        return format;
    }
    public void closeBreakoutRoom( ){
        open = false;
        numberOfParticipants = 0;
        breakoutRoomNumberCounter--;
        
    }
    public void openBreakoutRoom( ){
        open = true;
        breakoutRoomNumberCounter++;
    }
}
