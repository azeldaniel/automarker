package out.Zion_Haye_657855_assignsubmission_file_;/*
 Student ID : 816020871
*/
public class BreakoutRoom{
    

     
    private String breakoutRoomID; 
    private static int breakoutRoomNumberCounter = 1;
    private final int breakoutRoomSize = 10; 
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;
    
    
        
    public BreakoutRoom(String name){
        
        breakoutRoomID = name + breakoutRoomNumberCounter;
        breakoutRoomNumberCounter = breakoutRoomNumberCounter + 1; 
        
        numberOfParticipants = 0;
        open = true;
        
        participants = new Participant [breakoutRoomSize];
        
    }
    
    public boolean addParticipant (String participantID){
        
        Participant participant;
        String participantIDNumber;
        boolean isValid;
        
        participant = null;
           
        isValid = participant.verifyID(participantID);
        
        if(open == false){
            System.out.println("Breakout Room is closed.");
            return false;
        }
        
        
        if(numberOfParticipants == breakoutRoomSize){
            System.out.println("Breakout Room is Full");
            return false;
        }
        
        if(isValid==false){
            System.out.println("This Participant ID is invalid");
            return false;
        }
                      
       
        for (int x = 0 ; x < numberOfParticipants ; x++){
             participant = participants[x]; 
             participantIDNumber = participant.getParticipantID();
             
             if(participantIDNumber.equals(participantID)){
                 System.out.println("Participant : " + participantID + " is already in the Breakout Room ");  
                 return false;
             }
        }
        
         if(numberOfParticipants < breakoutRoomSize){
            participant = new Participant(participantID);
            participants[numberOfParticipants] = participant;
            numberOfParticipants = numberOfParticipants + 1;
            return true;
        }

        
        return false;
    }
    
    public Participant findParticipant(String participantID){
        
        Participant participant;
        String pID;
        boolean isValid;
        
        participant = null;
        isValid = participant.verifyID(participantID);
        
        if(isValid==false){
            System.out.println("Invalid Participant ID");
            return null;
        }else{
            
            for ( int x = 0 ;  x < numberOfParticipants ; x++){
                participant = participants[x];
                pID = participant.getParticipantID();
                
                if(pID.equals(participantID)){
                    return participant;
                }
                
            }
        
        }
        
        return null;
    }
    
    public String listParticipants(){
        
        Participant participant;
        String listOfParticipants ;
        
        listOfParticipants = breakoutRoomID + "\n";
        
        for( int x = 0 ; x < numberOfParticipants ; x++ ){
            participant = participants[x];
 
            listOfParticipants += participant.toString();
            listOfParticipants += "\n";
            

        }
        
        return listOfParticipants;
    }
    
    public String toString(){
        
        String details;
        
        details = breakoutRoomID;
        
        if(open==true){
            details += " OPEN ";
        }
        else{
            details += " CLOSE ";
        }
        
        details += numberOfParticipants;
        
        return details;
    }
    
    public void closeBreakoutRoom(){
        
        open = false;
        
        Participant participant;
        participant = null;
        
        for (int x =0 ;  x < numberOfParticipants ; x++){
             participants[x] = participant;   
        }
        
        numberOfParticipants = 0;
        
    }
    
    public void openBreakoutRoom(){
        
        open = true;
    
    }
    
        
    public String getBreakoutRoomID(){
     
        return breakoutRoomID;
        
    }
    
    public boolean getOpen() {
        
        return open;
        
    }
    
    public int getNumberOfParticipants(){
        
        return numberOfParticipants;
    }
}