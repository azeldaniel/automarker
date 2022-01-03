package out.Chelsea_Joyeau_657671_assignsubmission_file_;/**
 * Chelsea Joyeau ~ 816020515
 * Object Oriented Programming
 * Assignment 1.0 ~ Virtual Meeting
 */
public class BreakoutRoom
{
    private boolean open = true;
    private String breakoutRoomID;
    private Participant[] participants; // Declaring an array of participants
    private int numberOfParticipants ;
    private int breakoutRoomNumber ; // Used to keep track of the current room 

    private final int breakoutRoomSize = 10; //A constant that specifies the maximum number (10) of participants allowed in a breakout room
    private static int breakoutRoomNumberCounter = 1; // A class variable for producing unique integer values used in creating breakoutRoomID values

    public BreakoutRoom(String name)
    {
       this.breakoutRoomID = name + breakoutRoomNumberCounter; //Unique identifier  {combination of the virtual room name and a unique room number} 
       this.breakoutRoomNumber = breakoutRoomNumberCounter;
       this.breakoutRoomNumberCounter++;
       participants = new Participant[breakoutRoomSize]; 
       this.numberOfParticipants = 0;
       getOpen();
    }
    
    public String getBreakoutRoomID()
    {
        return this.breakoutRoomID;
    }
    
    public int getBreakoutRoomNumber()
    {
        return this.breakoutRoomNumber;
    }
    
    public int getNumberOfParticipants()
    {
        return this.numberOfParticipants;
    }
    
    public boolean getOpen()
    {
        return open;
    }
    
    /*Adds a new participant (no duplicates) with a valid ID to the (open) breakout room if the room is not
     * filled and then returns true, otherwise returns false
     */
    public boolean addParticipant(String participantID)
    {
        Participant newParticipant = new Participant (participantID);
        boolean duplicateFound = false;
        
        for (int i = 0; i < numberOfParticipants; i++) // Determines if the participantID passed in is already in the breakout room
        { 
            if (participants[i].getParticipantID().equals(participantID))
            {
                duplicateFound = true;
            }
        }
        
        if (getOpen() == false)
        {
            System.out.println ("\nThe Breakout Room Is Currently Closed And Must Be Opened Before A New Participant Is Added.");
            return false;
        }
        
        if (numberOfParticipants == breakoutRoomSize)
        {
            System.out.println ("\nThe Breakout Room Is Currently At Full Capacity. Thus, The New Participant Cannot Be Added.");
            return false;
        }
        
        if  (duplicateFound == true)
        {
            System.out.println ("\nParticipant: " +participantID +" Cannot Is Already In Breakout Room: " +getBreakoutRoomID());
            return false;
        }
        
        if (newParticipant.verifyID(participantID) == false)
        {
            System.out.println ("\nParticipant: " +participantID + " Is Not A Valid ParticipantID.");
            return false;
        }
              
        else 
        {
            System.out.println ("\nParticipant: " +participantID + "\tBreakout Room: " +getBreakoutRoomID());
            participants [numberOfParticipants] = newParticipant;
            numberOfParticipants++;
            return true;
        }
    }
    
    /*Locates and returns a participant based on a supplied (valid) ID if present 
     * in the (open) breakout room, otherwise returns null.
     */
    public Participant findParticipant(String participantID)
    {
        for (int location = 0; location < breakoutRoomSize; location++)
        {
            if ((participants[location].getParticipantID().equals(participantID)) && (getOpen() == true)
                        && (participants[location].verifyID(participantID) == true))
            {
                
                return participants[location];
            }
        }     
        return null; 
     }
  
    /* Returns a list of the participants (ID) in the breakout room 
     * with the breakout room ID heading the list on a separate line
     */
     public String listParticipants()
     {
        if (numberOfParticipants == 0)
        {
            return ("BREAKOUT ROOM NAME: " +getBreakoutRoomID() + " Has No Participants!\n");
        }
        else
        {
            String details = ("BREAKOUT ROOM NAME: " +getBreakoutRoomID() +"\n\n");
            for (int count = 0; count < numberOfParticipants; count++)
            {
                details += (participants[count].toString() +"\n");
            }    
            return details;
        }
    }
    
   public String toString ()
   {
       String details;
       
       if (getOpen() == true)
         details = (this.breakoutRoomID +" OPEN " +numberOfParticipants +"\n");
       
       else
         details = (this.breakoutRoomID +" CLOSE " +numberOfParticipants +"\n");
         
       return details;
   }
   
   /* Closes the breakout room, clears the participant list
    * and resets any relevant state of the breakout room
    */
   public void closeBreakoutRoom()
   {
       if (open == false)
       {
           System.out.println ("Breakout Room ID:" +getBreakoutRoomID() +" Is Already Closed");
       }
       else
       {
           System.out.println ("Breakout Room ID:" +getBreakoutRoomID() +" Is Now Closed");
           open = false; 
           numberOfParticipants = 0;
       }
   }
   
   /* Opens the breakout room and sets the state as open */
   public void openBreakoutRoom()
   {
       if (open == true)
       {
           System.out.println ("Breakout Room ID:" +getBreakoutRoomID() +" Is Already Open");
       }
       else 
       {
           System.out.println ("Breakout Room ID:" +getBreakoutRoomID() +" Was Closed, But Is Now Open");
           open = true;
       }
   }
}
