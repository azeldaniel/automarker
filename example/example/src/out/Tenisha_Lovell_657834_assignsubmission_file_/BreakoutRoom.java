package out.Tenisha_Lovell_657834_assignsubmission_file_;/* 816008740
 */

import java.util.Arrays;

public class BreakoutRoom{
    
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter = 0;
    private final static int breakoutRoomSize = 10;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;

    public BreakoutRoom(String name){
        this.breakoutRoomNumberCounter = breakoutRoomNumberCounter + 1;
        this.breakoutRoomID = name + breakoutRoomNumberCounter; 
        this.numberOfParticipants = 0;
        participants = new Participant[breakoutRoomSize];
        if(numberOfParticipants < breakoutRoomSize){
            openBreakoutRoom();
            this.open = true; 
        }
    }
    
    public String getBreakoutRoomID(){
        return breakoutRoomID;
    }
    
    public int getNumberOfParticipants(){
        return numberOfParticipants;
    }

    public boolean addParticipant(String participantID){
        int i = 0;
       // boolean isFound = false;
        if(this.open == true){ 
            // and Verify ID
            if(this.findParticipant(participantID) != null){
                return false;
            }
           else if(this.getNumberOfParticipants() < breakoutRoomSize){
               int n = this.getNumberOfParticipants();
               if(Participant.verifyID(participantID)){
                   //System.out.println("is valid");
                   participants[n] = new Participant(participantID);
                   //System.out.println(participants[n].toString());
                   numberOfParticipants++;
                   //System.out.println(this.toString());
                   return true;
                }
           }
       
         }
        return false;
    }
    
    public Participant findParticipant(String participantID){
      //  boolean isFound = false;
       int i = 0;
        if(this.open = true){
            while(participants[i] != null && (i < numberOfParticipants)){
                if(participants[i].equals(participantID)){        
                    return participants[i];
                }
                i = i + 1;
            }
        }
        return null; 
    }
    
    public String  listParticipants(){
        String list;
        list = breakoutRoomID + "\n";
        for(int i=0; i<numberOfParticipants; i=i+1){
            //System.out.println("1");
            list = list + participants[i].getParticipantID() + " ";
        }
        return list;
    }
    
    public String toString(){
        String state = "CLOSED";
        if(this.open == true){
            state = "OPEN";
        }
 
        return(getBreakoutRoomID() + " "+  state + " " + getNumberOfParticipants()); 
    }
    
    public void testPart(){
        System.out.println(getBreakoutRoomID() + " " + getNumberOfParticipants() + "\n");
           for(int i=0; i<participants.length ; i++){
           if(participants[i] != null)
           System.out.println(participants[i].toString());
        }
      } 
    public void closeBreakoutRoom(){
        //if(numberOfParticipants == breakoutRoomSize){
            this.open = false;
            Arrays.fill(participants, null);
            numberOfParticipants = 0;
        //}
    }
    
    public void openBreakoutRoom(){
        this.open = true;
    }
    
    
}