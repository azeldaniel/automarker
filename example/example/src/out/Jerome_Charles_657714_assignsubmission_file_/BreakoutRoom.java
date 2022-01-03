package out.Jerome_Charles_657714_assignsubmission_file_;
/*
Jerome Charles 816021939
Assignment 1
 */
public class BreakoutRoom
{
    // instance variables - replace the example below with your own
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter;
    private final int breakoutRoomSize=10;
    private Participant[] participants=new Participant[10];
    private int numberOfParticipants=0;
    private boolean open=false;
    

    /**
     * Constructor for objects of class BreakoutRoom
     */
    public BreakoutRoom(String name)
    {
        breakoutRoomID=name;
    }
    
    public String getbreakoutRoomID(){
    return breakoutRoomID;
    }
    public void setbreakoutRoomID(String name){
    breakoutRoomID=name;
    }
    
    public int getnumberOfParticipants(){
    return numberOfParticipants;
    }
    
    public boolean getopen(){
    return open;
    }
   
    public boolean addParticipant(String participantID){
        boolean checker=true;
        int count=participantID.length();
          for (int i = 0; i < count; i++) { 
  
           
            if (participantID.charAt(i) >= '0'
                && participantID.charAt(i) <= '9') { 
                 
            } 
            else { 
                System.out.println("ID contains letters");
                return false;
            } 
        }
        if(open==false || numberOfParticipants==breakoutRoomSize){
        System.out.println("The ROOM is closed ");
        return false;
        }
        /*
        for (int i = 0; i < 10; i++) { //check if ID is already in room
  
           
            if (participants[i].getParticipantID().equals(participantID)) { 
                System.out.println("im already here");
                checker= false;
            } 
            
        } 
        */
        if(findParticipant(participantID)!=(null)){ checker=true;}
        
        if(checker==false){//ID NUMBER WAS FOUND
         System.out.println("The ID is already present");
         return false;
        }
        
        if (checker==true){//adds ID to breakout room
        for(int i=0;i<10;i++){
        if(participants[i].getParticipantID().equals("")) {   
        participants[i]=new Participant(participantID);
        //System.out.println(participants[i].getParticipantID());
        i=10;
        //System.out.println("ID has been added to Room");
    }
    }    
    
        numberOfParticipants++;
        return true;
        }
        
        return false;
    }
    
    
    
    
    public Participant findParticipant(String participantID){
        
        int count=participantID.length();
        //if (open==false){System.out.println("Room is closed"); return null;}
        if (count<8){System.out.println("ID is less than 8 numbers");return null;}
        for (int i = 0; i < count; i++) { 
  
           
            if (participantID.charAt(i) >= '0'
                && participantID.charAt(i) <= '9') { 
                 
            } 
            else { 
                System.out.println("no letters in ID");
                return null; 
            } 
        }
    
        for (int i = 0; i < 10; i++) { //check if ID is in room
  
           
            if (participants[i].getParticipantID().equals(participantID)) {
                
                System.out.println("Participant found");
                return participants[i]; 
            } 
            
        } 
    
    return null;
    }
    
    
    
    public String listParticipants(){
         
        String holder="";
        for (int i = 0; i < 10; i++) { //check if ID is in room
  
           
            if (participants[i].getParticipantID()!=null) {
                
                //System.out.println(participants[i].getParticipantID());
                holder=(holder+"\r\n"+participants[i].getParticipantID());
            } 
            
        } 
    
        
        return (getbreakoutRoomID()+"\r\n"+ holder);
        
    }
    
    
    
    
    public String toString(){
    String state;
    if(open==true){state="OPEN";}
    else{state="CLOSED";}
    return (getbreakoutRoomID()+" "+state+" "+numberOfParticipants);
    }
    
    public void closeBreakoutRoom(){
    
        for (int i = 0; i < 10; i++) { //check if ID is in room
  
                participants[i]=null;
                open=false;
                numberOfParticipants=0;
        } 
    
    }
    
    public void openBreakoutRoom(){
        for (int i = 0; i < 10; i++){
        participants[i]=new Participant("");}
        for (int i = 0; i < 10; i++) { //check if ID is in room
  
                
                open=true;
                //numberOfParticipants=0;
        } 
    
    }
}
