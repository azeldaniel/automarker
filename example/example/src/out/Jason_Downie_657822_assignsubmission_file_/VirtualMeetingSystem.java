package out.Jason_Downie_657822_assignsubmission_file_;// 816004029
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files


public class VirtualMeetingSystem
{   
    private VirtualRoom[] virtualRooms;
    String[] data = new String[50]; //an array to store the IDs taken from the files
    
    public void loadParticipantData(String filename)
    {
        try
        {
            File participants = new File("participant.dat");
            Scanner reader = new Scanner(participants);
            int i=0;
             
            while(reader.hasNextLine())
            {
                data[i]=reader.nextLine();
                i++;
                //System.out.println(data);
            }
        }
        catch (FileNotFoundException e) 
        {
            System.out.println("An error locating the file has occurred.");
            e.printStackTrace();
        }

    }
    
    public static void  createVirtualRoom(String name)
    {
        VirtualRoom virtualRooms = new VirtualRoom(name);        
    }
       
    
    public void allocateParticipants(String code)
    {
        if(code.equals("C5"))
        {
            int k=0;
            for(int j=0; j< 5; j++)
            
            {
                for(int i=0 ; i< 5; i++)
                {
                    this.addParticipant(data[k],j);
                    k++;
                }
            }
        }
        else if (code.equals("RR"))
        {
            int k=0;
        while (data[k]!= null)
        {
            for(int j=0; j< 5; j++)
            
            {
                
                    this.addParticipant(data[k],j);
                    k++;
                
            }
        }
        }
        else
        {
            System.out.println("Wrong allocation Code used");
        }
    }
    
    public boolean addParticipant (String participantID,int roomNumber) 
    {
        return this.virtualRooms[roomNumber].addParticipantToBreakoutRoom(participantID,roomNumber);
    }
    
    public String listParticipants(int roomNumber)
    {
        return this.virtualRooms[roomNumber].listParticipantsInBreakoutRoom(roomNumber);
    }
    
    public boolean openBreakoutRoom(int roomNumber)
    {
        return this.virtualRooms[roomNumber].openBreakoutRoom(roomNumber);
    }
    
    public boolean closeBreakoutRoom(int roomNumber) 
    {            
        return this.virtualRooms[roomNumber].closeBreakoutRoom(roomNumber);         
    }
    
    public String findParticipantBreakoutRoom(String participantID)
    {
        for(int i=0; i< VirtualRoom.getNumberOfBreakoutRooms(); i++)
        {
            if (this.virtualRooms[i].findParticipantBreakoutRoom(participantID)!= null)
            {
                return this.virtualRooms[i].findParticipantBreakoutRoom(participantID);
            }
        }
        return null; 
    }
    
    public String listAllBreakoutRooms()
    {
        return this.virtualRooms[VirtualRoom.getNumberOfBreakoutRooms()].listBreakoutRooms();
    }
    
    public String listParticipantsInAllBreakoutRooms() 
    {
        String details=null;
        for (int i=0;i<VirtualRoom.getNumberOfBreakoutRooms();i++)
        details += this.virtualRooms[VirtualRoom.getNumberOfBreakoutRooms()].listParticipantsInBreakoutRoom(i)
        +"/n";
        return details;
    }
    
}
