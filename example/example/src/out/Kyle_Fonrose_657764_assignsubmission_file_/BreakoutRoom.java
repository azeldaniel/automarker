package out.Kyle_Fonrose_657764_assignsubmission_file_;//NAME: KYLE E. FONROSE
//ID: 816002546
//TITLE: ASSIGNMENT 1

public class BreakoutRoom{
    // instance variables
     private String breakoutRoomID;
     private static int breakoutRoomNumberCounter = 1;
     private final int breakoutRoomSize;
     private int numberOfParticipants;
     private boolean open;
     private Participant[] participants;
        
    //Constructor for objects of class BreakoutRoom
    public BreakoutRoom(String name){
     // initialise instance variables
     this.breakoutRoomID = name + Integer.toString(breakoutRoomNumberCounter); //Example: FSS 300
     this.breakoutRoomSize = 10;
     this.numberOfParticipants = 0; //represents objects used
     breakoutRoomNumberCounter++; //increments by 1 each time participant is added
     this.participants = new Participant[10]; // must have a max of 10 participants in the room     
     this.open = true;
    }

    public boolean addParticipant(String participantID){
     Participant test = new Participant(participantID);
     boolean duplicate = false;
     
     for(int i = 0; i < breakoutRoomSize; i++){
         if((test.verifyID(participantID) == true) && (open == true) && (numberOfParticipants < 10)){
            for(int k = 0; k< numberOfParticipants; k++)
                if(participants[k].getParticipantID().equals(participantID)){
                  duplicate = true;
                  return false;
                }
             if(duplicate == false){   
             participants[numberOfParticipants] = new Participant(participantID);
             //System.out.println(participants[numberOfParticipants].getParticipantID() + ": Adding participant");
             this.numberOfParticipants += 1;
             return true;
            }
         }
        
     }
     return false;
    }
    
    
    public Participant findParticipant(String participantID){
        Participant pID = new Participant(participantID);
   
        if((open == true) && (pID.verifyID(participantID) == true)){
           for(int i = 0; i < numberOfParticipants; i++){  
             //System.out.println(participants[i].getParticipantID());
               if(participants[i].getParticipantID().equals(participantID)){
                //System.out.println("FOUND Participant");
               return pID;
             }
           }
         } 
    
     return null;
     }


    public String listParticipants(){

        String list = getBreakoutRoomID() + "\n";

        for(int i = 0; i < numberOfParticipants; i++){
            list += (participants[i].getParticipantID() + "\n");
        }

        return list;
    }

    public String toString(){
    
     if(open == true){
         return getBreakoutRoomID() +  " OPEN " + Integer.toString(numberOfParticipants) + "\n";
    }
    else{
        return getBreakoutRoomID() + " CLOSED " + Integer.toString(numberOfParticipants) + "\n";
     }
    }
    
    public void closeBreakoutRoom(){
       for(int i=0; i<numberOfParticipants; i++){
             participants[i].setParticipantID("");
       }
       this.open = false;
       this.numberOfParticipants = 0;
       this.breakoutRoomNumberCounter = 1;
    }
    
    public void openBreakoutRoom(){
        this.open = true;
    }
    
    //Accessor method
    public String getBreakoutRoomID(){
         return breakoutRoomID;
    }
    //Accessor method
    public int getNumberOfParticipants(){
         return numberOfParticipants;
    }
    //Accessor method
    public int getbreakoutRoomNumberCounter(){
        return breakoutRoomNumberCounter;
    }

    public boolean getOpen(){
        return open;
    }
    
}


