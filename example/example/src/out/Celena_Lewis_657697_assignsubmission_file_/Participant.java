package out.Celena_Lewis_657697_assignsubmission_file_;//Celena Lewis
//816019582
//Assignment One COMP 2603

//import java.util.Scanner;

public class Participant{
    private String participantID;
    
    public Participant(String ParticipantID){
        this.participantID = ParticipantID;
    }
    //constructor for the Participant class
    
     public String getParticipantID(){
        String ID = this.participantID;
        
        return ID;
    }
    //accessor for the participantID variable
    
    public static boolean verifyID(String participantID){
        int len = 0;
        
        len = String.valueOf(participantID).length();
        //System.out.println(len);
        
        if((participantID==null) || (len>8) || (len<8)){
            System.out.println("ID is invalid.");
            return false;
            //ID is invalid
        }
            
            return true;
            //ID is invalid
    }
    //verifies a participantID
    
    public String toString(){
        String partdetails;
        if(verifyID(participantID)!=true){
            return partdetails = ("Participant ID is not valid.");
        }
        else{
            //String partdetails = "Participant:" + " " + participantID;
            partdetails = "Participant:" + " " + participantID;
            return partdetails;
        }
    }
    //string representation of the participantID
    
    /* Code to ensure participant class is working
    public static void main(String args[]){
        Scanner keyboard = new Scanner(System.in);
        String id = keyboard.nextLine();
        Participant pp = new Participant(id);
        boolean verify = pp.verifyID(id);
        
        if(verify == true)
         System.out.println("ID is good");
        
    } */
}