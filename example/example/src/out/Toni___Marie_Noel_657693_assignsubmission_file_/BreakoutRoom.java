package out.Toni___Marie_Noel_657693_assignsubmission_file_;
/**
 * The BreakoutRoom class simulates a room for further 
 * discussion within a smaller group of participants
 *
 * @ Toni-Marie Noel- 816017238 
 * @ Jan 30, 2021 
 */
public class BreakoutRoom
{
    // instance variables - replace the example below with your own
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter=0; // final
    private final int breakoutRoomSize=10;
    private int roomNum; 
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open;

    /**
     * Constructor for objects of class BreakoutRoom
     */
    
    public BreakoutRoom(String name){
        
       breakoutRoomNumberCounter++;
       roomNum = breakoutRoomNumberCounter; 
       breakoutRoomID = name + breakoutRoomNumberCounter;
       openBreakoutRoom();
       numberOfParticipants = 0; 
       participants = new Participant[breakoutRoomSize];  
        
    }
    
        
    public boolean addParticipant(String participantID){
        
        participants[numberOfParticipants]= new Participant(participantID);
        //check to see if the participant is in the room and their ID is valid and the breakout room is open and not 10, add them 
        if(participants!=null &&findParticipant(participantID)==null && participants[0].verifyID(participantID)==true && getOpen()==true && numberOfParticipants<breakoutRoomSize)
        
        {
            numberOfParticipants++;
           // System.out.println(numberOfParticipants); 
            return true;
            
        }
        
        participants[numberOfParticipants] = null; // remove participant
        
        return false; 
   
    }
    
     public Participant findParticipant(String participantID)
    {
        int i = 0;
        boolean key = false;
       
       while(key != true && i < numberOfParticipants)
       {
           if(participants[i].getParticipantID().equals(participantID) && getOpen() == true)
           {
               key = true; 
               return participants[i];
               
           }
           i++;
        } 
        
            return null;
    }
    
    
      public String listParticipants(){
        
        String list ="";
        list = "Breakout Room ID: "+breakoutRoomID+ '\n'; 
      
       
        if(numberOfParticipants ==0)
        list = list + "Breakout Room is Empty \n";
        
        for(int i=0; i<numberOfParticipants; i++)
        {
           list= list +"participant_"+(i+1)+ " ID: "+ participants[i].getParticipantID()+"\n"; 
        }
        
        return list; 
        
    }
    
    public String toString(){
          
         String roomInfo="";
         
        if(getOpen()==true)
            roomInfo = breakoutRoomID + " OPEN " + numberOfParticipants; 
         
            else
           roomInfo = breakoutRoomID + " CLOSED " + numberOfParticipants;
            
        return roomInfo; 
     }
     
    
    
    public void closeBreakoutRoom(){
            
        // close the breakout room
        if(getOpen()==true)
           open = false;

        // clear participant array
        for(int i=0; i<numberOfParticipants; i++)
        {
            participants[i] = null;
            
        }
        
        // change the number of participants in the room to zero
        numberOfParticipants = 0; 
        
    }
        
        
    public void openBreakoutRoom(){
            
            if(getOpen()==false)
            open = true;
            
        }
   

    
    public int getBreakoutRoomSize(){
        return breakoutRoomSize; 
    }
    
    
    public String getBreakoutRoomID(){
       return breakoutRoomID;  
    }
    

    //getters
    public boolean getOpen(){
        return open;       
    }
    // getNumberOfParticipants
    public int getNumberOfParticipants(){
       return numberOfParticipants;
    }
  
    public int getBreakoutRoomNumberCounter(){
        return roomNum;
    }
    
    public void reset(){
        breakoutRoomNumberCounter=0;         
    }
    
    
    public static void println(Object line) {
    System.out.println(line);
    }
    
     // testing
     public static void main(String [] args){
         
         BreakoutRoom bruck = new BreakoutRoom("Hell");
         BreakoutRoom bruck2 = new BreakoutRoom("Hell");
         
         if(bruck.addParticipant("12345678"))
         println("added");
         
         if(bruck.addParticipant("12345679"))
         println("added"); 
     
         println(bruck); 
         println(bruck.getNumberOfParticipants());
         println(bruck.listParticipants()); 
         
         println(bruck2); 
         bruck.closeBreakoutRoom(); 
         println(bruck.listParticipants());
         println(bruck.getNumberOfParticipants());
         println(bruck);
         bruck.openBreakoutRoom();
         println(bruck);
         
         if(bruck.addParticipant("12345679"))
         println("added");
         println(bruck.listParticipants());
         
     }

}