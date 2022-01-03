package out.Brandon_Bissoon_657753_assignsubmission_file_;/**
 * Write a description of class Participant here.
 *
 *Student ID :- 816022435
 *Student Name :- Brandon Bissoon 
 */
public class Participant{
   // instance variables - replace the example below with your own
   public String participantID;
   
   //Method Signature for Participant Class
   /*
    * Constructor�
    */
   /**
    * Constructor for Participant Class
    */
    public Participant(String participantID){
        this.participantID = participantID;
   }
    
   /*
     *Class method that validates that a non-null,
     *participantID conforms to the required 8 digit
     *format and returns true, otherwise false.� 
       */
   public static boolean verifyID(String participantID){
        
        //variable for counting lenght of id
        int count;
        int partlength = participantID.length();
        
        if (participantID == null || partlength!=8 ){
            return false;        
        }
        
        /*
         * for loop using a builtin functions called isDigit to check if the 
         * string is corresponding
           */
        for( count = 0; count < participantID.length(); count = count + 1){
            if(Character.isDigit(participantID.charAt(count))){
                return true;
            }
        }  
        return false;
   }
    
   /*
   * Accessor for a participant’s ID�
   */
   public String getParticipantID(){        
        return participantID;
   } 
    
   /*
     *Returns a String representation of the state of a 
     *Participant formatted as follows:
     *Participant: participantID� 
     *
     *learnt toString function from COMP 2603 Lab Seesions with teacher
       */
   public String toString(){
        String output;
        output = " The ParticipantID is :- " + participantID;
        return output;
   }
}
