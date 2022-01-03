package out.Govinda_Ramcharan_657806_assignsubmission_file_;/**
 * @author Govinda Ramcharan 816003108
 * 
 */
public class BreakoutRoom
{
    // instance variables
    private String breakoutRoomID;
    private static int breakoutRoomNumberCounter = 100;
    private final int breakoutRoomSize = 10;
    private int numberOfParticipants;
    private boolean open;
    private Participant[] participants;

    // Constructor 
     
    public BreakoutRoom(String name)
    {
        this.breakoutRoomID = name + Integer.toString(breakoutRoomNumberCounter);         
        this.numberOfParticipants = 0; 
        breakoutRoomNumberCounter++; //increments by 1 whenever a breakout room is created 
        this.participants = new Participant[10]; // creates 10 empty participant objects    
        this.open = true;        
    }

    public boolean addParticipant(String participantID)
    {
        Participant temp = new Participant(participantID); //creates a temp Participant object in order to give access to 
                                                           //verifyID method in the Participant class
        for(int i = 0; i < breakoutRoomSize; i++)
        {
            if((temp.verifyID(participantID) == true) && (open == true) && (numberOfParticipants < breakoutRoomSize))
            {
              participants[numberOfParticipants] = new Participant(participantID);
              this.numberOfParticipants += 1;
            
              return true;
            }
            else
            {
              return false;
            }
        }
        return false;
    }
    
    public Participant findParticipant(String participantID)
    {
        Participant temp = new Participant(participantID); //creates a temp Participant object in order to give access to
                                                           //verifyID method in the Participant class         
        if((open == true) && (temp.verifyID(participantID) == true)) //checks if room is open and the participantID is valid
        {
           for(int i = 0; i < numberOfParticipants; i++)
           {  
               if(participants[i].getParticipantID().equals(participantID))
               {
                  return temp; //returns the Participant object that contains the desired participant ID
               }
           }
        } 
    
        return null;
    }
    
    public String listParticipants()
    {
        String participantList = breakoutRoomID + "\n"; //adds the breakoutRoomID at the start of the list followed by the IDs
                                                 //that are present in the room in another line
        for(int i = 0; i < numberOfParticipants; i++)
        {
            participantList += (participants[i].getParticipantID() + "\n");
        }

        return participantList;
    }

    public String toString()
    {
        if(open == true)
        {
            return breakoutRoomID +  " OPEN " + Integer.toString(numberOfParticipants) + "\n";
        }
        else
        {
            return breakoutRoomID + " CLOSED " + Integer.toString(numberOfParticipants) + "\n";
        }
    }
     
    public void closeBreakoutRoom()
    {
       for(int i = 0; i < numberOfParticipants; i++)
       {
           participants[i].setID(""); //resets the IDs of all participants in the breakout room to ""
       }
       this.open = false;               //changes the status of the room to false so no one can be added to the room
       this.numberOfParticipants = 0;   //resets the number of participants currently in the room back to 0 
       this.breakoutRoomNumberCounter = 100; //resets the room counter back to its original value
    }
    
    public void openBreakoutRoom()
    {
        this.open = true; //changes the status of the room to true, participant IDs can now be added to the room
    }
    
    //Accessor
    public String getBreakoutRoomID()
    {
        return breakoutRoomID; //gives access to breakoutRoomID from VirtualRoom class
    }
    
    public int getNumberOfParticipants()
    {
        return numberOfParticipants; //gives access to numberOfParticipants
    }
    
    public boolean getOpen()
    {
        return open;  
    }
    

}
