package out.Jean___Luke_Chankoo_657705_assignsubmission_file_;//816006490

public class Participant
{
    private String participantID;
    
    public Participant(String participantID)
    {
     participantID= participantID;  
    }

    public boolean verifyID(String participantID){
    int check=0;
    int length=participantID.length();
    if(length!=8){
    return false;
    }
    else{
        for(int i=0;i<8;i++){
        if(Character.isDigit(participantID.charAt(i))){
            check=check+1;
        }
        if(check==8){
        return true;
        }
        else{
        return false;
        }
        }
    }
    return false;    
    }
    
    public String getParticipantID(){
        return participantID;
    }
    
    public String toString(){
    String details= "Participant: "+participantID;
    return details;
    }
    
    }
