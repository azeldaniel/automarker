package out.Jeremy_De_Freitas_657820_assignsubmission_file_;//816018479
public class BreakoutRoom{
    
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter; 
    private final int breakoutRoomSize;
    private Participant[] participants;
    private int numberOfParticipants;
    private boolean open; 


    
    public BreakoutRoom(String name) //Constructor
    {
        this.breakoutRoomID =  String.valueOf(breakoutRoomNumberCounter);
        this.breakoutRoomNumberCounter++; 
        this.breakoutRoomSize = 10;
        this.participants = new Participant[breakoutRoomSize];
        this.numberOfParticipants = 0; 
        this.open = true;
    }
    
    public String getBreakoutRoomID(){
        return breakoutRoomID;
    }
    
    public int getNumberOfParticipants()
    {
        int numOfPart;
        numOfPart= numberOfParticipants;
        return numOfPart;
        
    }

    
    public boolean getOpen()
    {
        boolean isOpen;
        isOpen = open;
        return isOpen;
    }
    
    
    public boolean addParticipant(String participantID)
    {
         
        Participant participant;
        participant = new Participant(participantID);
  
        String ID;
        ID = participant.getParticipantID(); 
        
        boolean valid;
        valid = participant.verifyID(ID);
        
        if(this.numberOfParticipants == 10 && valid == true)
        {
            System.out.println("This breakout room is full.");
            return false;
        }
        
        if(valid  && open )
        {
           this.participants[numberOfParticipants] = participant;
           this.numberOfParticipants++;

             return true;
        }       
            return false;                
    }

    
    public Participant findParticipant(String participantID)
    {  
        Participant Par = new Participant(participantID);         
       
       if(Par.verifyID(participantID)){
           int count = 0;
           while(count < numberOfParticipants){
               if(this.participants[count].getParticipantID().equals(participantID)){

                   return this.participants[count]; 
                }
                count++;
            }//end of loop
        }
        return null;
    }

    public String listParticipants()
    {        
        String Partlist = "List of Participants:" + "\n";
        int count = 0;
        
        while(count < numberOfParticipants){
            Partlist += this.participants[count].getParticipantID()+ "\n";
            count++;
        }
        return Partlist;    
    }

    
    public String toString()
    {
        /**String status;
        if(open == true)
        {
            status = "Open";
        }
        else
        {
            status = "Closed";
        }
        **/ 
        String state= "BreakOut Room Number: " + breakoutRoomID + "\n";
        state += "Participants: " + numberOfParticipants + "\n";
        state += "Open/Closed: " + getOpen() + "\n";
        
        return state;
    }
  
    
    public void closeBreakoutRoom()//resets state
    {
       int count = 0;
       this.open = false;
       while (count < getNumberOfParticipants())
       {
       this.participants[count] = null;
       count++;
    }
       this.numberOfParticipants = 0;
    }
    
    
    public void openBreakoutRoom(){
       this.open=true;
    }

}
