package out.Jared_Sandy_657733_assignsubmission_file_;// 816018721

public class Participant
{
    private String participantID;
    
    public Participant (String participantID){
        this.participantID=participantID;
    }
    
    public static boolean verifyID(String participantID){
        int num=participantID.length();
        boolean letter=true;
        
        if (num !=8)
           return false;
           
         else if (num ==8){
             for(int i=0;i<8;i++){
                 if(Character.isDigit(participantID.charAt(i))){
                   letter=true;
                }
                else
                return false;
            }
                   return true;
            }
        
        
        return false;
    }
    
    public String getParticipantID( ){
        return participantID;
    }
    
    public String toString(){
         String details="Participant:"+ participantID;    
        return details;     
    }
    
}
//To check each char in ID: https://www.tutorialspoint.com/how-to-check-if-a-given-character-is-a-number-letter-in-java#:~:text=We%20can%20check%20whether%20the,specified%20character%20is%20a%20digit.