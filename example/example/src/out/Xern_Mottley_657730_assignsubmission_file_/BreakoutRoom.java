package out.Xern_Mottley_657730_assignsubmission_file_;//816019358
public class BreakoutRoom
{
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter=0;
    private final int breakoutRoomSize=10;
    private Participant[] participants;
    private  int numberOfParticipants;
    private boolean open;
    
    public  BreakoutRoom(String name){
        breakoutRoomNumberCounter++;
        breakoutRoomID=name  + "_" +breakoutRoomNumberCounter ;
        participants= new Participant[breakoutRoomSize];
        numberOfParticipants=0;
        open=true;
    }
    
    public boolean addParticipant( String ParticipantID){
        numberOfParticipants=0;
        boolean found=false;
        for(int i=0; i< breakoutRoomSize; i++){
            if(participants[i]!=null){
                numberOfParticipants++;
            }else{
                break;
            }
        }
        if(numberOfParticipants==breakoutRoomSize){
            return false;
        }else{
            for(int y=0; y < numberOfParticipants ; y++){
                if(participants[y].getParticipantID()== ParticipantID){
                    found=true;
                }
                if(found==true){
                    return false;
                }
            }
            Participant participant= new Participant( ParticipantID);
            participants[numberOfParticipants]=participant;
        }
          return true;
        
    }
    
    public Participant findParticipant( String participantID){
        if(Participant.verifyID(participantID)==true && open==true){
             for(int h=0; h < numberOfParticipants ; h++){
                    if(participants[h].getParticipantID()== participantID){
                        return participants[h];
                    }
                   
             }
             
        }else if(Participant.verifyID(participantID)==false){
            return null;
        }
        return null;
    }
    

    public String listParticipants(){
        String list="Breakout Room ID: "+breakoutRoomID+"\n";
        for(int k=0; k < breakoutRoomSize; k++){
            if(participants[k]==null){
                break;
            }
            list+=participants[k].toString()+ "\n";
        }
        return list; 
    }    
    
    public String toString(){
        String details, status;
        if(open==true){
            status="OPEN";
        }else{
            status="CLOSED";
        }
        
        details= "Breakout Room ID: "+ breakoutRoomID+" "+ status+" "+ numberOfParticipants;
        return details;
    }
    
    public void closeBreakoutRoom(){       
        numberOfParticipants=0;
        open=false;
    }
    public void openBreakoutRoom(){
        open= true;
    }
    
    public String getBreakoutRoomID(){
        return this.breakoutRoomID;
    }
    
    public boolean getOpen(){
        if( this.numberOfParticipants < this.breakoutRoomSize){
            return true;
        }
        return false;
    }
    
    public int getNumberOfParticipants(){
        return this.numberOfParticipants;
    }

}
