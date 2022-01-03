package out.Maria_Cadogan_657849_assignsubmission_file_;
//816013573

public class BreakoutRoom{
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter = 1;
    private final int breakoutRoomSize = 10;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;
    
    
    //delete or comment out this constructor
    public BreakoutRoom(){
        breakoutRoomID = null;
        //breakoutRoomNumberCounter++;
        participants = new Participant[breakoutRoomSize];
        numberOfParticipants = 0;
        open = false;
    }
    
    public BreakoutRoom(String name){
        breakoutRoomID = name + breakoutRoomNumberCounter;
        breakoutRoomNumberCounter++;;
        participants = new Participant[breakoutRoomSize]; 
        numberOfParticipants = 0;
        open = false;
    }
    
    //Add accessors for the other attributes??
    public String getBreakoutRoomID(){
        return breakoutRoomID;
    }
    
    public int getNumberOfParticipants(){
        return numberOfParticipants;
    }
    
    public boolean getOpen(){
        return open;
    }
    
    //do a check for duplicates
    public boolean addParticipant(String participantID){
        if((open == true) && (numberOfParticipants < 10)){
            Participant newParticipant = new Participant(participantID);
            
            if(newParticipant.verifyID(participantID) == true){
                participants[numberOfParticipants] = newParticipant;
                numberOfParticipants += 1;
                return true;
            }
        }
        return false;
        
    }
    
    public Participant findParticipant(String participantID){
        if(open == true){
            Participant tempParticipant = new Participant(participantID);
            
            if(tempParticipant.verifyID(participantID) == true){
                for(int i = 0; i < numberOfParticipants; i++){
                    String pID = participants[i].getParticipantID();
                    
                    if(pID.equals(participantID)){
                        return participants[i];
                    }
                }
            }           
        }
        return null;
    }
    
    public String listParticipants(){
         if(numberOfParticipants == 0){
             return "No participants in break out room as yet";
         }
         else{
             String details = "Breakout Room: " + getBreakoutRoomID() + "\n";
             
             for(int i = 0; i < numberOfParticipants; i++){
                 details += participants[i].toString() + "\n";
                  
             }
             return details;
         }
     }
         
     public String toString(){
         String details = breakoutRoomID;
         
         if(getOpen() == true){
             details += " OPEN";
         }
         else
         {
            details += " CLOSED"; 
         }
  
         //details += " " + numberOfParticipants;
         
         return details;
         
     }
     
     public void closeBreakoutRoom(){
         if(open == true){
             open = false; // now closed
             
             for(int i = 0; i < numberOfParticipants; i++){
                 participants[i] = null;
             }
             
             numberOfParticipants = 0;
             
         }
         
     }
     
     public void openBreakoutRoom(){
         if(!open){
             open = true; // now opened
             
         }
     }
     
     /*
     //Tests
     public static void main(String[] args){
        BreakoutRoom br1 = new BreakoutRoom("Seminar");
        BreakoutRoom br2 = new BreakoutRoom("Workshop");
        
        System.out.println("Constructor Test for initial states.");
        System.out.println("Break Room ID: " + br1.breakoutRoomID);
         
        System.out.println("Break Room Number Counter: " + br1.breakoutRoomNumberCounter);
        System.out.println("Break Room Size: " + br1.breakoutRoomSize);
        System.out.println("Number of Participants: " + br1.numberOfParticipants);
        System.out.println("Open: " + br1.open);
        
        System.out.println("\nAfter Initial: ");
        br1.openBreakoutRoom();
        System.out.println("Open: " + br1.open);
        System.out.println("Added: " + br1.addParticipant("12345678"));
        System.out.println("Added: " + br1.addParticipant("01234567"));
        System.out.println("Number of Participants: " + br1.numberOfParticipants);
        System.out.println("Found " + br1.findParticipant("12345678"));
        System.out.println(br1.listParticipants());
        System.out.println("\n");
        
        br2.openBreakoutRoom();
        System.out.println("Open: " + br2.open);
        System.out.println("Added: " + br2.addParticipant("24682468"));
        System.out.println(br2.listParticipants());
        System.out.println("\n");
        
        //toString when BR is open
        System.out.println(br1.toString());
        System.out.println(br2.toString());
        System.out.println("\n");
        
        //Testing for closed BR
        br1.closeBreakoutRoom();
        System.out.println("Open: " + br1.open);
        System.out.println(br1.listParticipants());
        System.out.println(br1.toString());
        
    }
    */
     
}