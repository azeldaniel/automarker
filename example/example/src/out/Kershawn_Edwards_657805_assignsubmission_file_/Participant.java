package out.Kershawn_Edwards_657805_assignsubmission_file_;//816016050

public class Participant{

    private String participantID;
    private static int count;
    private static int temp;
    //private  int count;
    //private  int temp;
    
    public Participant(String participantID){
      
            this.participantID = participantID;
        
    }
    
    public static boolean verifyID(String participantID){
        temp = 0;
        count = 0;
        if(participantID!= null){
           temp = Integer.parseInt(participantID);
           while(temp != 0){
               count++;
               temp = temp/10;
           } 
           if(count == 8 ){
               return true;
               } 
        }
        return false;
    }
    
    /*public  boolean verifyID(String participantID){
    
        if(participantID!= null){
           temp = Integer.parseInt(participantID);
           while(temp != 0){
               count++;
               temp = temp/10;
           } 
           if(count == 8 ){
               return true;
               } 
        }
        return false;
    }*/
    
    
    public String getParticipantID(){
    
        return participantID;
    }
    
    public String toString(){
    
        return "Participant: " + participantID;
    }
    
    public static void main(String args[]){
    Participant p1 = new Participant("88844888");
    System.out.println(p1.verifyID(p1.getParticipantID()));
    System.out.println(p1.toString());
        
    }
}