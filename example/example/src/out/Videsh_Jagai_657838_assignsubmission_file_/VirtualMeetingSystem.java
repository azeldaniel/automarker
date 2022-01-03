package out.Videsh_Jagai_657838_assignsubmission_file_;
/**
 * 
 *
 * Name: Videsh Jagai...
 * Student ID: 816014860
 * 
 */

import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.Scanner; 


public class VirtualMeetingSystem
{
    
    VirtualRoom virtualRoom;  
    // Declaration of the class VirtualRoom and its corresponding virtualRoom object...
    private int NumPart = 0; // intialising the variable NumPart = 0;
    // Declaration of the array List..
    private String[] PartList = new String[50];
   
    
    // Read data from a file and loads the data into an array for allocation to breakout rooms

    public void loadParticipantData(String filename) 
    {
        try { // Creation of the Fobject1 pbject and assigning to the filename which is passed into the corresponding File class.
            File FObject1 = new File(filename); // Scanner is utilise to subsequently get the user input of the Fobject1...
            Scanner ReaderFile = new Scanner(FObject1); 
            while (ReaderFile.hasNextLine()) 
            {
                PartList[NumPart] = ReaderFile.nextLine();// assessing each of the data (NumParticipants) on new line..
                NumPart = NumPart + 1;
            }
            
            ReaderFile.close();
        } catch (FileNotFoundException e) // Background check to determine if file in invalid/ any errors occurs..
        {
            System.out.println("Error occured!! ");
            e.printStackTrace();
        }
    }
    // Resources: https://www.w3schools.com/java/java_files_read.asp
    
    // Creates a virtual room with the supplied name,containing 5 breakout rooms..
   
    public void createVirtualRoom(String name) 
    {
        virtualRoom = new VirtualRoom(name); // Passing the name into the VirtualRoom class
    }
    // Allocates participants to the breakout rooms of a virtual room using a strategy determined by the
    // supplied code....
    public void allocateParticipants(String code)
    {
        // recalling the method function: createBreakoutRooms();Creates a virtual room with the supplied name,
        //containing 5 breakout rooms
        virtualRoom.createBreakoutRooms();
        // checking whether the state of the participantID in a cluster of 5 for each breakout Room..
        // respectively...
        // numberBreakoutRooms: Returns the total number of breakout rooms managed by the virtual room...
        int NumBreakR = virtualRoom.getNumberOfBreakoutRooms();
        // PartCh: keeps trck of the participant data...
         int PartCh = 0;
        // RoomCh: keeps tracks roomcheck
        int RoomCh = 1;
        // Keeps check of the of the cluster set of participantID data....
        int CluSet = 0;
        
       
        // This strategy selects participants from the data list and allocates participants to the virtual rooms in a
        // clusters of 5.
        
        if (code.equals("C5")) 
        {
            // PartCh keeps track woth the participant data...
            while (PartCh < NumPart ) 
            {
                // verifying that each cluster has 5 participantID respectively...
                if (CluSet == 5 )  
                {
                // CluSet: Changing the respective state back to its original state when it reach CluSet of 5 participants data... 
                    CluSet = 0;
                // RoomCh: increments for every check of CluSet of 5 participant data..  
                    RoomCh = RoomCh +1;
                }
                
                // RoomCh less than NumBreakR resort changing back to original state ....
                if(RoomCh > NumBreakR)
                {
                     RoomCh = 1;//RoomCh; Changing the respective state back to its original state.. 
                }
                // Recalling the addParticipantToBreakoutRoom:Adds a new participant to the breakout room with
                //the supplied room number if it exists
            
                virtualRoom.addParticipantToBreakoutRoom(PartList[PartCh],RoomCh);
                
                // PartCH: increments respectively for each prticipant data
                PartCh = PartCh +1;
                // CluSet increments 
                CluSet = CluSet +1;
                
                
            }
            
        } 
             //Workshop1: {100, 600 }, Workshop2: {200, 700}, Workshop3: {300, 800 }, Workshop4: {400, 900 },
            //Workshop5: {500, 999 }
        else if (code.equals("RR")) 
        {   // checking to verifiy that PartCh 
            while (PartCh < NumPart ) 
            {
                // // Recalling the addParticipantToBreakoutRoom:Adds a new participant to the breakout room with
                //the supplied room number if it exists
                virtualRoom.addParticipantToBreakoutRoom(PartList[PartCh], RoomCh);
                
                // PartCH: increments respectively for each prticipant data
                PartCh=PartCh+1;
                
            }

        }
        else 
        {
            System.out.println("Error Occured!!!.");
        }
        
    }
    //Adds a new participant to the breakout room with the supplied room number if it exists..
    
    public boolean addParticipant(String participantID, int roomNumber) 
    {    // recalling the findBreakoutRoom method function which
        // Locates and returns the breakout room with the supplied room number (valid) 
        // untilsing the respective parameter parameter and roomNumber..
        while (virtualRoom.findBreakoutRoom(roomNumber) != null)
        { 
            // adding the Participants to the resective virtualRoom...
            virtualRoom.addParticipantToBreakoutRoom(participantID, roomNumber);
            return true; // returning true respectively...
        }
        return false; // otherwise returning false...
    }
    // Returns a list of the participants in the breakoutroom with the supplied room number if found,
    //otherwise returns null

    public String listParticipants(int roomNumber)
    {
        // recalling the findBreakoutRoom method function which
        // Locates and returns the breakout room with the supplied room number (valid) 
        // untilsing the respective parameter parameter and roomNumber..
        while(virtualRoom.findBreakoutRoom(roomNumber) != null) 
        {
            // recalling the listParticipantsInBreakoutRoom; Returns a list of the participants in the breakout
            //room with the supplied room number if found, 
            return ("VirtualRoom"+ virtualRoom.listParticipantsInBreakoutRoom(roomNumber));
        }
        return null;// otherwise return null if the supplied number doesnt exist..
    }
    // Opens a breakout room with the supplied room number if it exists

    public boolean openBreakoutRoom(int roomNumber)
    {     
        // recalling the findBreakoutRoom method function which
        // Locates and returns the breakout room with the supplied room number (valid) 
        // untilsing the respective parameter parameter and roomNumber..
        while (virtualRoom.findBreakoutRoom(roomNumber) != null)
        {
            return (virtualRoom.openBreakoutRoom(roomNumber));
        }
        return false;// otherwise if the supplied number doesn't exist ..
    }
    // Closes a breakout room with the supplied room number if it exists

    public boolean closeBreakoutRoom(int roomNumber)
    { 
        // recalling the findBreakoutRoom method function which
        // Locates and returns the breakout room with the supplied room number (valid) 
        // untilsing the respective parameter parameter and roomNumber..
        while (virtualRoom.findBreakoutRoom(roomNumber) != null) 
        {
            // closes a breakout room with the supplied room number 
            // within the virtualRomm class..
            return (virtualRoom.closeBreakoutRoom(roomNumber));
        }
        return false;// otherwise return false..
    }
    
    // Locates and returns the breakoutRoomID for the breakout room hosting the participant with the
    //(valid) supplied ID, otherwise returns null...

    public String findParticipantBreakoutRoom(String participantID)
    {
        //  Recalling the function findParticipantBreakoutRoom: Locates and returns the breakout room with the supplied room number,
        // passing long the String participantID otherwise returning null...
        return (virtualRoom.findParticipantBreakoutRoom(participantID));
    }
    
    // Returns a list of the breakout rooms managed by the virtual room
    
    public String listAllBreakoutRooms()
    {
        // listAllBreakoutRooms method Returns a list of the breakout rooms managed by
        //the virtual room with the virtual room name heading the list on a separate line...
        return (virtualRoom.listBreakoutRooms());
    }
    
    
    //Returns a list of all of the participants per breakout
    //room managed by the virtual room, otherwise
    //returns null
    
    public String listParticipantsInAllBreakoutRooms()
    {
         String ParDet = "";
        int NumBreakR = virtualRoom.getNumberOfBreakoutRooms();
        // recalling the method function:  Returns the total number of breakout roomsmanaged by the virtual room
        for(int j = 1; j <= NumBreakR; j++)
        {
            ParDet += virtualRoom.listParticipantsInBreakoutRoom(j) + "VirtualRoom"+ "\n" ;
        }
        return ParDet;
    }
    
    
}
