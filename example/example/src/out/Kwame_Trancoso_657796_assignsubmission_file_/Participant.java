package out.Kwame_Trancoso_657796_assignsubmission_file_;//816005595
public class Participant
{
    public String participantID;
    
    public Participant(String ID)
    {
        participantID = ID;
    }

  
    public boolean verifyID(String participantID){
       if (participantID.length()==8){
       return true;
    }
    return false;
    }
    
    public String getParticipantID(){
        return participantID;
    }
    
    public String toString(){
        String s;
        s="Participant:"+participantID;
        return s;
    }
}
