package out.Aaron_Meighoo_657750_assignsubmission_file_;//Aaron Meighoo
//816000303
//A1
//Participant Class

public class Participant {
    
    private String participantID;

    public Participant(String participantID){
        if(verifyID(participantID))
            this.participantID = participantID;
    
    } 
    
    public static boolean verifyID(String participantID){
        boolean number = false;
        if(participantID.length() == 8){
            for(int i = 0; i < participantID.length(); i++){
                number = Character.isDigit(participantID.charAt(i));
                if(!number)
                    return false;
            }
            return true;
        }
        return false;
    }
    
    public String getParticipantID(){
        return participantID;
    }
    
    public String toString(){
        String details = "";
        details = "Participant ID : " + getParticipantID();
        return details;
    
    }
    
    //public static void main (String[] args){
    //    String name = "160030030";
    //    String id= "";
    //    boolean check = false;
    //    Participant p1 = new Participant(name);
    //    id = p1.toString();
    //    System.out.println(id);
    //    check = p1.verifyID(name);
    //    System.out.println(check);
    //    
    //}
    
}
