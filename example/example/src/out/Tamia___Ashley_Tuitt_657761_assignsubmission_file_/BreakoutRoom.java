package out.Tamia___Ashley_Tuitt_657761_assignsubmission_file_;/**
 * Student ID: 816021561
 */
public class BreakoutRoom
{
    
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter=0;
    private int RoomNumber;
    private final int breakoutRoomSize;
    private Participant[] participants= new Participant[10];
    private int numberOfParticipants;
    private boolean open;

    

    public BreakoutRoom(String name)
    {
        this.breakoutRoomNumberCounter+=1;
        this.RoomNumber=breakoutRoomNumberCounter;
        this.breakoutRoomID=""+name + this.RoomNumber;
        this.open=true;
        this.numberOfParticipants=0;
        this.breakoutRoomSize=10;
    }
    
    public int getBreakoutRoomNumber(){
        return RoomNumber;
    }
    public int getBreakoutRoomNumberCounter(){
        return breakoutRoomNumberCounter;
    }
    
    public String getBreakoutRoomID(){
        return breakoutRoomID;
    }
    
    public int getNumberOfParticipants(){
        return numberOfParticipants;
    }
    
    public boolean getOpen(){
        return open;
    }
    
    public boolean addParticipant(String participantID)
    {   
        if((numberOfParticipants >= breakoutRoomSize)||(open==false))
         return false;
        Participant P= new Participant(participantID);
        if(P.verifyID(participantID)==true){
        for(int i=0; i<this.numberOfParticipants; i++){
            if(participants[i].getParticipantID().equals(participantID))
            {
                return false;
            }
        }
        
        participants[this.numberOfParticipants]=P;
        this.numberOfParticipants++;
        return true;  
       }
       return false;
    }
    
    
    public Participant findParticipant(String participantID){
        if(open==true){
            
            for(int i=0; i<numberOfParticipants; i++){
                if(participants[i].getParticipantID().equals(participantID))
                    return participants[i];
                }
                  
        }
        return null;
    }
    
    public String listParticipants(){
        
        String list="";
        list += breakoutRoomID +"\n";
        for(int i=0; i<numberOfParticipants; i++)
            list += participants[i] + "\n";
            
        return list;
    }
    
    public String toString(){
        String details="Breakout Room: ";
        if(open==true)
        details= details + breakoutRoomID+" "+"OPEN"+" "+numberOfParticipants;
        else
        details= details + breakoutRoomID+" "+"CLOSED"+" "+numberOfParticipants;
        return details;
    }
    
    public void closeBreakoutRoom(){
        
        for(int i=0; i<numberOfParticipants; i++){
            participants[i]=null;
        }
        numberOfParticipants=0;
        open=false;
    }
    
    public void openBreakoutRoom(){
        open=true;
    }
}   

