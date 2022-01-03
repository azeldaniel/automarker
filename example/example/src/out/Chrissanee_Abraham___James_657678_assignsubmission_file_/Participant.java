package out.Chrissanee_Abraham___James_657678_assignsubmission_file_;
/**
 Name:Chrissanee Abraham-James
 ID: 816000377
 Course: Object Oriented Programming
 Course Code: COMP 2603
 Assignment 1
 */
public class Participant
{
    private String participantID;

    /**
     * Constructor for objects of class Participant
     */
        public Participant(String participantID)
    {
        this.participantID = new String(participantID);
        //System.out.println("new Participant: "+ this.participantID);
    }
    
    public boolean verifyID(String participantID){
        int length;
        length = participantID.length();
        if(length!=8){
        return false;
        }
        return true;
    }
        
    public String getParticipantID(){
        return this.participantID;
    }
    
    public String toString(){
    //Returns a String representation of the state of a Participant formatted as follows: Participant: participantID
        String output = new String("");
        output = "\nParticipant: "+ participantID;
        //System.out.println(output);
        return output;
    }
    
}

