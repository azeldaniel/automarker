package out.Nicholas_Kauffmann_657738_assignsubmission_file_;public class Participant        //ID: 816015405
{

    private String participantID;


    public Participant(String participantID)
    {
        // initialise instance variables
        this.participantID = participantID;
    }


    public static boolean verifyID (String participantID)   //ID must be between 10000000 and 99999999
    {
        int id;
        try{              
            id = Integer.parseInt(participantID);      
        }       
        catch(NumberFormatException e){        
            id = 0;
        }

        if( (id>10000000) && (id<99999999) ){
            return true;
        }
        else{
            return false;
        }
    
    }
    
    public String getParticipantID(){
        return participantID;  
    }
    
    public String toString(){
       return ("Participant: "+participantID);
    }
    

   
    
}
