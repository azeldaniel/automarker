package out.Jamie_Mahabir_657666_assignsubmission_file_;
/**
BreakoutRoom class
816019893

 */
public class BreakoutRoom 
{
    
    //attributes
    
    private String breakoutRoomID=null;
    private static int breakoutRoomNumberCounter=0;
    private final int breakoutRoomSize;
    private Participant[] participants=new Participant[50];
    private int numberOfParticipants=0;
    private boolean open=false;
    
    
    //accessors
    public String getBreakoutRoomID(){
        return breakoutRoomID;
    }
   
    public int getNumberOfParticipants(){
        return numberOfParticipants;
    }
    
    public boolean getOpen(){
        return open;
    }
    
    
    //methods
    public BreakoutRoom(String name){
        this.breakoutRoomID=name+breakoutRoomNumberCounter;
        this.breakoutRoomNumberCounter++;
        this.breakoutRoomSize = 10;
        this.open = true;
    }
    
    public boolean addParticipant(String participantID){
        
        Participant add=new Participant(participantID);
        
        if(add.verifyID(participantID)==true){
            
            if(breakoutRoomSize!=10){
                participants[numberOfParticipants] = add;
                numberOfParticipants++;
                
                return true;
            }
        }
        return false;
    }
    
    
    public Participant findParticipant(String participantID){
    
        Participant found=new Participant(participantID);
        
        if(found.verifyID(participantID)==true){
           
            for(int i=0; i<getNumberOfParticipants();i++){
             
                if(this.participants[i].getParticipantID().equals(participantID)){
                    return participants[i];
                }
            }
        }
        return null;
   
    }
    
    public String listParticipants(){
    
        String participantsPresent;
        
        participantsPresent=breakoutRoomID+"\n";
        
        int i=0;
        for(i=0;i<getNumberOfParticipants();i++){
        
            participantsPresent+=participants[i].getParticipantID()+ " \n";
        
        }
        
        return participantsPresent;
    
    }
    
    
    public String toString(){
    
        String details;
        details=breakoutRoomID;
        
        
        if(open==true){
            details+=" OPEN ";
        }
        else{
            details+=" CLOSED ";
        }
        details+=getNumberOfParticipants();
        
        return details;
    
    
    }
    
    
    public void closeBreakoutRoom(){
    
        int i=0;
        for(i=0;i<getNumberOfParticipants();i++){
            this.participants[i]=null;
        }
        
        this.numberOfParticipants=0;
    
    }
    
    public void openBreakoutRoom(){
    
        this.open=true;
        
    }
    
   

}
