package out.Govinda_Ramcharan_657806_assignsubmission_file_;/**
 * @author Govinda Ramcharan 816003108
 * 
 */
public class VirtualRoom
{
    // instance variables
    private String name;
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;
    
    // Constructor
    public VirtualRoom(String name)
    {
        this.name = name; 
        this.breakoutRoomLimit = 5;
        this.breakoutRooms = new BreakoutRoom[5]; //creates 5 empty breakout room objects
    }
    
    // Overloaded Constructor
    public VirtualRoom(String name, int limit)
    {
        this.name = name;
        this.breakoutRoomLimit = limit;
        this.breakoutRooms = new BreakoutRoom[10];
    }

    public int getNumberOfBreakoutRooms()
    {
        return breakoutRooms.length; // gets the size of the breakoutRooms array
    }
    
    public void createBreakoutRooms()
    {
        for(int i = 0; i < breakoutRoomLimit; i++)
        {   
             breakoutRooms[i] = new BreakoutRoom(name); //creates 5 breakout room objects 
        }
        
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber)
    {
        String bRoomNum = name + Integer.toString(roomNumber); //temp string variable to combine the virtual room name and the
                                                               //breakout room number for comparison later
        
        for(int i = 0; i < getNumberOfBreakoutRooms(); i++) //cycles through all the breakout rooms
        {
            if(breakoutRooms[i].getBreakoutRoomID().equals(bRoomNum)) //breakoutRooms[i].getbreakoutRoomID() gets the stored breakout room id  
                                                                      //and compares it to bRoomNum using the .equals method
            {
                return breakoutRooms[i]; //if the .equals method returns true the breakout room that corresponds to the room number that is passed in is returned
            }
        }
        return null;
    }
    
    
    public boolean closeBreakoutRoom(int roomNumber)
    {
        String bRoomNum = name + Integer.toString(roomNumber); //same explanation for each occurrence of this line 
    
        for(int i = 0; i < getNumberOfBreakoutRooms(); i++)  //same explanation for each occurrence of this line
        {
           if(breakoutRooms[i].getBreakoutRoomID().equals(bRoomNum) && breakoutRooms[i].getOpen() == true) //same explanation for each occurrence of this line
           {
               breakoutRooms[i].closeBreakoutRoom(); //if the .equals method returns true the breakout room that corresponds to the room number that is passed in is closed
               return true;
            }
        }
        return false; 
    }
    
    public boolean openBreakoutRoom(int roomNumber)
    {
        String bRoomNum = name + Integer.toString(roomNumber); //same explanation for each occurrence of this line 
        
        for(int i = 0; i < getNumberOfBreakoutRooms(); i++) //same explanation for each occurrence of this line 
        {
            if(breakoutRooms[i].getBreakoutRoomID().equals(bRoomNum) && breakoutRooms[i].getOpen() == false) //same explanation for each occurrence of this line 
            {
              breakoutRooms[i].openBreakoutRoom(); //if the .equals method returns true the breakout room that corresponds to the room number that is passed in is opened
              return true;
            }
        }
        return false; 
    }
    
    
    public String listBreakoutRooms()
    {
        String listBrooms = name + "\n"; //creates a list containing the name of the virtual room heading the list followed by the names of all rooms in a seperate line
        
        for(int i = 0; i < getNumberOfBreakoutRooms(); i++) //same explanation for each occurrence of this line 
        {
           listBrooms += breakoutRooms[i].toString() + "\n"; // calls the toString method of each breakout Room which returns the name of the room, status and num Participants
        }
        return listBrooms;
    }
    
       
    public String listParticipantsInBreakoutRoom(int roomNumber)
    {
        String bRoomNum = name + Integer.toString(roomNumber); //same explanation for each occurrence of this line 
     
        for(int i = 0; i < getNumberOfBreakoutRooms(); i++) //same explanation for each occurrence of this line 
        {
            if(breakoutRooms[i].getBreakoutRoomID().equals(bRoomNum)) //same explanation for each occurrence of this line 
            {  
                String list = (breakoutRooms[i].listParticipants()); // if the .equals method returns true it calls the listParticipants method of the breakout room 
                return list;                                         // that corresponds to the room number that is passed in
            }
        }
        return null;
    }
     
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber)
    {
        String bRoomNum = name + Integer.toString(roomNumber);  //same explanation for each occurrence of this line 
     
        for(int i = 0; i < getNumberOfBreakoutRooms(); i++)     //same explanation for each occurrence of this line 
        {  
            if(breakoutRooms[i].getBreakoutRoomID().equals(bRoomNum))  //same explanation for each occurrence of this line 
            {
                breakoutRooms[i].addParticipant(participantID); //if the .equals method returns true it calls the addParticipant method and assigns the participantID                                                             
                return true;                                    // to the breakout room that corresponds to the room number that is passed in 
            }
        }
        return false;
    }
    
    public String findParticipantBreakoutRoom(String participantID)
    {
        String foundID = ""; //empty string used to return the breakout room ID that contains the participant ID that is passed in
        
        for(int i = 0; i < getNumberOfBreakoutRooms(); i++)  //same explanation for each occurrence of this line 
        {
            if(breakoutRooms[i].findParticipant(participantID) != null) //if the function returns null it means that the participantID does not exist in any of the rooms
            {                                                           //if it returns true it means the participantID does exist 
              foundID = breakoutRooms[i].getBreakoutRoomID();           //foundID stores the breakoutRoom ID that contains the corresponding participantID
              return foundID;
            }
            
        }    
        return null;
    }
}
