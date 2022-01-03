package out.Johnathan_Girod___Williams_671779_assignsubmission_file_;
/**
 
 
 * Johnathan Girod-Williams 816004809
 * Feb 15th 2021
 */

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class VirtualMeetingSystem
{
    // instance variables - replace the example below with your own
    private Participant[] participants;
    int noOfParticipants;
    
    private VirtualRoom vr;

    /**
     * Constructor for objects of class VirtualMeetingSystem
     */
    public VirtualMeetingSystem()
    {
        // initialise instance variables
        participants = new Participant[100];
        this.noOfParticipants = 0;
        
    }

    public void loadParticipantData(String filename)
    {
        // Read data from file
        try
        {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            
            while (myReader.hasNextLine()) 
            {
                String data = myReader.nextLine();
                
                this.participants[this.noOfParticipants] = new Participant(data);
                
                this.noOfParticipants++;
            }
            myReader.close();
            
        } catch (FileNotFoundException e) 
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        
    }
    
    public void createVirtualRoom(String name)
    {
        // Create virtual room containing 5 breakout rooms
        System.out.println("Number of participants is : " + this.noOfParticipants);
        
        if(this.noOfParticipants < 50)
        {
            this.vr = new VirtualRoom(name);
            
            System.out.println(" created the standard sized Virtual room");
        }
        else
        {
            int i = this.noOfParticipants / 10;
            i++;
            
            this.vr = new VirtualRoom(name, i);
            
            System.out.println("Number of Rooms is : " + i);
        }
        
        //System.out.println("Max number of participants is : " + (this.vr.getNumberofBreakoutRooms() * 10));
    }
    
    public void allocateParticipants(String code)
    {
        // Allocates students to virtual rooms using C5 or RR strategies
        /*if(code != "c5" && code != "RR")
        {
            return;
        }*/
        if(code == "C5")
        {
            int i = 0;
            int j = 0;
            
            if(this.noOfParticipants >50)
            {
                
            }
            while(i < this.noOfParticipants)
            {
                
                
                for(int count = 0 ; count <5 && i < this.noOfParticipants; i++)
                {
                    this.vr.addParticipantToBreakoutRoom(this.participants[i].getParticipantID(), j);
                    count++;
                }
                i++;
                j++;
                
                if(j == this.vr.getNumberOfBreakoutRooms())
                {
                    j = 0;
                }
            }
        }
        if(code == "RR")
        {
            
            
            int i = 0;
            int j = 0;
            
            while(i < this.noOfParticipants)
            {
                
                
                
                this.vr.addParticipantToBreakoutRoom(this.participants[i].getParticipantID(), j);
                
                i++;
                j++;
                
                if(j == this.vr.getNumberOfBreakoutRooms())
                {
                    j = 0;
                }
            }
        }
    }
    
    public boolean addParticipant(String participantID, int roomNumber)
    {
        // Adds a new participant to a specified room if room is found, else returns null
        // I am assuming a new participant is new to the point of not being on the data file
        this.participants[this.noOfParticipants] = new Participant(participantID);
        this.noOfParticipants++;
        //I predict errors where we add too many participants and the code doesn't support adding more rooms at tis stage
        System.out.println(this.noOfParticipants);
        try 
        {
            this.vr.addParticipantToBreakoutRoom(participantID, roomNumber);
        }
        catch(Exception e) 
        {
            return false;
        }
        
        System.out.println(this.noOfParticipants);
        return true;//gonna return true if it was added
    }
    
    
    public String listParticipants(int roomNUmber)
    {
        // returns the list of participants in the breakout room
        return this.vr.listParticipantsInBreakoutRoom(roomNUmber);
    }
    
    
    public boolean openBreakoutRoom(int roomNumber)
    {
        
        
        try 
        {
            this.vr.openBreakoutRoom(roomNumber);
        }
        catch(Exception e) {
            return false;
        }
        return true;
    }
    
    public boolean closeBreakoutRoom(int roomNumber)
    {
        try 
        {
            this.vr.closeBreakoutRoom(roomNumber);
        }
        catch(Exception e) {
            return false;
        }
        return true;
    }
    
    public String findParticipantBreakoutRoom(String participantID)
    {
        // returns breakoutRoomID 
        
        
        return this.vr.findParticipantBreakoutRoom(participantID);
    }
    
    public String listAllBreakoutRooms()
    {
        //
        return this.vr.listBreakoutRooms();
    }
    
    public String listParticipantInAllBreakoutRooms()
    {
        String s = "";
        
        int nobor = this.vr.getNumberOfBreakoutRooms();
        
        for(int i = 0 ; i < nobor ; i++)
        {
            s += this.vr.listParticipantsInBreakoutRoom(i) + " ";
        
        }
    
        return s;
    }
}
