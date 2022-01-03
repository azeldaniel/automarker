package out.Kershawn_Edwards_657805_assignsubmission_file_;//816016050
import java.util.Arrays;

public class BreakoutRoom{
    
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter = 1;
    private final int breakoutRoomSize;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;
    private String list;
    private boolean contains;
    private int count = 0;
    
    public BreakoutRoom(String name){
    
        breakoutRoomID = name + breakoutRoomNumberCounter;
        breakoutRoomNumberCounter++;
        open = true;
        numberOfParticipants = 0;
        breakoutRoomSize = 10;
        participants = new Participant[breakoutRoomSize];
        contains = false;
        
    }
    
    public String getBreakoutRoomID(){
        return breakoutRoomID;
    }
    
    public int getNumberOfParticipants(){
    
        return numberOfParticipants;
    }
    
    public void setNumberOfParticipants(int number){
        numberOfParticipants = number;
    
    }
    
    public boolean addParticipant(String participantID){
        Participant p = new Participant(participantID);
        for(int x = 0;x<numberOfParticipants;x++){
            //System.out.println("inside");
            if((x == 0)&&(numberOfParticipants == 0)){
                participants[numberOfParticipants] = p;
                numberOfParticipants++;
                return true;
            }
            else if(participants[x].toString().equals(p.toString())){
                //System.out.println(participants[x].toString());
                contains = true;
                return false;
            }
        }
        if((!contains)&&(Participant.verifyID(participantID))&&(this.open)&&(numberOfParticipants <10)){
            participants[numberOfParticipants] = p;
            numberOfParticipants++;
            contains = false;
            return true;
        }
        
        
        return false;
    }
    
    public Participant findParticipant(String participantID){
        Participant p = new Participant(participantID);
        if((p.verifyID(participantID))&&(this.open)){
        
            for(int x=0;x < numberOfParticipants;x++){
                
                
                if(participants[x].getParticipantID().equals(participantID)){
                    return participants[x];
                }
                
            }
        }
        return null;
    }
    
    public String listParticipants(){
    
        list = getBreakoutRoomID() + "\n";
        for(int x = 0; x < numberOfParticipants;x++){
            
            list += participants[x].getParticipantID() + "\n";
        }
        return list;
        
    }
    
    public String toString(){
        if(this.open) 
            return breakoutRoomID + " OPEN " + numberOfParticipants;
            
        if(!this.open)
            return breakoutRoomID + " CLOSED " + numberOfParticipants;
            
        return null;
    }
    
    public void openBreakoutRoom(){
        open = true;
    }
    
    public void closeBreakoutRoom(){
        open = false;
        for(int x = 0;x < 10; x++){
            participants[x] = null;
        }
        setNumberOfParticipants(0);
    }
    
    
    public static void main(String args[]){
    
        BreakoutRoom b = new BreakoutRoom("Zess");
        if(b.addParticipant("55566611")){
            b.addParticipant("88844434");
            b.addParticipant("88844434");
            System.out.println("Participant added");
        }
        if(!b.addParticipant("556611")){
            System.out.println("Invalid ID");
        }
        
        Participant p = b.findParticipant("55566611");
        if(p != null)
            System.out.println(p.toString());
        System.out.println(b.listParticipants());
        System.out.println(b.toString());
        //if(b.findPArticipant(""))
        //System.out.println();
        
    }
}