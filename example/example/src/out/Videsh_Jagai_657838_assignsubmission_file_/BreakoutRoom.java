package out.Videsh_Jagai_657838_assignsubmission_file_;
/**
 * 
 * Name: Videsh Jagai..
 * Student ID: 816014860
 * 
 */
public class BreakoutRoom
{
    // instance variables - replace the example below with your own
    // instance variables - replace the example below with your own
    private String breakoutRoomID;//formed combination of virtual room name and unique room number  
    private static int breakoutRoomNumberCounter= 0; // producing unique integer values (breakoutID)
    private final int breakoutRoomSize = 10; //constant specifies the maximum number(10) participants..
    private Participant[] participants;// A list of participants who have been added to the breakout room 
    private int numberOfParticipants;//Keeps track of the number of participants in the breakout room
    private boolean open;// A flag for tracking whether the breakout room’s state is open or closed.
    
    
    //breakoutRoom constructor ....
    public BreakoutRoom(String name)
    {
       breakoutRoomNumberCounter = breakoutRoomNumberCounter + 1; // unique integer values (breakoutID)
        breakoutRoomID = name + breakoutRoomNumberCounter;//concatenation of both the virtual room name and unique room number
        participants = new Participant [breakoutRoomSize]; // Participants added to breakout room
        numberOfParticipants = 0; // number of participants in the breakout room intialises to zero..
        open = true;// open intialises to being true..
    }
    
    // Accessors for the numberOfParticipants..
    public int getNumberOfParticipants()
    {
        return (numberOfParticipants);
        
    }
    // Accessors for the breakoutRoomID...
    public String getBreakoutRoomID()
    {
        return (breakoutRoomID);
        
    }
    //Accessors for the open variables 
    public boolean getOpen()
      {
        if( this.numberOfParticipants < this.breakoutRoomSize && open==true)
        {
            return true;
        }
            return false;
        
     }
     // Accessor for breakoutRoomSize
     public int getbreakoutRoomSize()
     {
         return (breakoutRoomSize);
     }
     // asscessor getbreakoutRoomNumberCounter() retaining the vlue unique integer values [breakoutRoomID] values]
    public int getbreakoutRoomNumberCounter()
    {
        return (breakoutRoomNumberCounter);
        
    }
    
    public boolean addParticipant(String participantID)
    {
        // base case scenario .. hence return null....
        if(participantID == null)
        {
            return false; // hence return false....
        }
        
        for (int i = 0; i < numberOfParticipants; i++)
        {
              // Recalling the getParticipantID asscessor function and determining whether if there are any duplicates
              // present , hence return false...
             if (participants[i].getParticipantID().equals(participantID))
             {
                 return false; 
             }
                 
        }
            // the respective NumberofParticipant must be less than breakout Room Size and therefore open must be true in state of
            // adding participant ID....
        if ((numberOfParticipants < breakoutRoomSize) && (open == true))
        {
            participants[numberOfParticipants] = new Participant(participantID);// poulating the respective participants to the breakout room
            numberOfParticipants=numberOfParticipants +1;// incrementing respectively..
            System.out.println(participantID);
            return true;// return true

        }
      
        return false;
     }
    
    public Participant findParticipant(String participantID)
    { // recalling the method verifyID when flag to keep track whether the
      // breakout room’s is true (numberOfParticipants < breakoutRoomSize)
      // as we are add participants respectively...
        if ((open == true) && (Participant.verifyID(participantID) == true))
        {
        for(int j = 0; j < breakoutRoomSize; j++) 
        {    // passing in and determining the validity of the participantID,afterwards returning the 
            // participants
            if (participants[j].getParticipantID().equals(participantID))
            {
                return participants[j]; // returning the participants..
            }
        }      
      }
      return null; // otherwsie returning null...
  
   } 
    
   // Returns a list of the breakout rooms managed bythe virtual room with the virtual room name heading
   //the list on a separate line

     public String listParticipants()
    {
        String ParDet = "BREAKROOM ID: " + breakoutRoomID ;
        
        for(int j = 0; j < numberOfParticipants; j++)
        {
              ParDet += participants[j].toString() + "\n";
        }
        return ParDet;
    }
    
    
    // returns string containing attribute breakoutRoomID in format
    // breakoutRoomID OPEN
    public String toString()
    {
        String ParBreaID;// variable showcasing whether the BreakoutRoom is open or not
                         // respectively...
      if(open) // checking to confirm the aggregated state of BreakoutRoom
      {
         ParBreaID = "Open BreakoutRoom!!" ;
       }
       else
       {
         ParBreaID = "Closed BreakoutRoom!!";  
       }
       // Returns a String representation of the aggregated 
      // state of a BreakoutRoom  and respectuve numberofParticipants..
      return (breakoutRoomID + " // " + ParBreaID + "// " +numberOfParticipants);
        
    }
    
    // Closes the breakout room, clears the participant list 
    // and resets any relevant state of the breakout room..
    public void closeBreakoutRoom()
    {
        System.out.println("The breakout room is correspondingly closed");
        open = false; // Changing back to its original state accordingly...
        numberOfParticipants = 0;
    }
    // Opens the breakout room and sets the state as open..
    public void openBreakoutRoom()
    {
        System.out.println("The breakout room is correspondingly open");
        open = true; 
        
    }
    
    
    public boolean getOpenBreakoutRoom( ){
        return open; 
    }
   
}
