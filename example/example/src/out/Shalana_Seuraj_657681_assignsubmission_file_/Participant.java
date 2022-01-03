package out.Shalana_Seuraj_657681_assignsubmission_file_;/*
 * 816021684
 */

public class Participant{
    private String participantID;
    
    //Constructor
    public Participant(String participantID){
        this.participantID = participantID;
    }
    
    //Class Method
    public static boolean verifyID(String participantID){
        int numbers = 0;
        if(participantID!=null){
            int lengthID = participantID.length();
            //System.out.println(lengthID);
            if(lengthID==8){
                for(int j=0;j<lengthID;j++){
                    if(participantID.charAt(j)>='0' && participantID.charAt(j)<='9'){
                        numbers+=1;
                    }
                }
                //System.out.println(numbers);
                if(numbers==lengthID){
                    return true;
                }
            }
        } 
        return false;
    }
    
    //Accessor
    public String getParticipantID(){
        return this.participantID;
    }
    
    public String toString(){
        String stateParticipant = "Participant: " + this.participantID;
        return stateParticipant;
    }
    
    //For verifyID method - https://www.geeksforgeeks.org/how-to-check-if-string-contains-only-digits-in-java/

}