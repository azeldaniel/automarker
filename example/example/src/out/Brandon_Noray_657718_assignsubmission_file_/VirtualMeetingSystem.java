package out.Brandon_Noray_657718_assignsubmission_file_;import java.io.*;
import java.util.*;
/**
* Write a description of class VirtualMeetingSystem here.
*
* @author (816018360 | Brandon Noray)
* @version (v1.6.9)
*/
public class VirtualMeetingSystem
{
    
    /** Variables **/
    public String[] id; //Array that holds the ids from file
    public VirtualRoom room; //Virtual Room
    
    /** Methods **/
    public void loadParticipantData(String filename)
    {
        Scanner file = null;
        try{
            file = new Scanner(new File(filename));
        } catch(IOException e){
            System.out.println("Could not find file");
        }
        
        if(file == null) //breaks if not found
            return;
            
        String[] tempArr = new String[1000];
        int i = 0;
        
        while(file.hasNext())
        {
            tempArr[i] = file.next();
            i++;
        }
        
        this.id = new String[i];
        for(int j=0; j<i; j++){//Copy array
            this.id[j] = tempArr[j];
        }
        
    }
    
    public void createVirtualRoom(String name)
    {
        //Code
        this.room = new VirtualRoom(name);
        this.room.createBreakoutRooms();
        //System.out.println(this.room.listParticipantsInBreakoutRoom(2));
    }
    
    public void allocateParticipants(String code)
    {
        //Code
        int roomNum = 1;
        int num = 5; //Code: C5
        String test;
        if(code == "RR")
            num = 1; //Code: RR
        
        for(int i=0; i<this.id.length; i++){
            this.room.addParticipantToBreakoutRoom(this.id[i], roomNum);

            if(i % num == 0)
                roomNum++;
            if(roomNum > this.room.getNumberOfBreakoutRooms())
                roomNum = 1;
        }
        
    }

    public boolean addParticipant(String participantID, int roomNumber)
    {
        //Code
        if(this.room.addParticipantToBreakoutRoom(participantID, roomNumber))
            return true;
        return false;
    }
    
    public String listParticipants(int roomNumber)
    {
        //Code
        String list = "Virtual Room: ";
        list += this.room.listParticipantsInBreakoutRoom(roomNumber);
        return list;
    }
    
    public boolean openBreakoutRoom(int roomNumber)
    {
        //Code
        boolean opened = this.room.openBreakoutRoom(roomNumber); 
        if(opened) System.out.println("Room" + roomNumber + " opened");
        else System.out.println("Room" + roomNumber + " not found");
        return opened;
    }
    
    public boolean closeBreakoutRoom(int roomNumber)
    {
        //Code
        boolean closed = this.room.closeBreakoutRoom(roomNumber); 
        if(closed) System.out.println("Room" + roomNumber + " closed");
        else System.out.println("Room" + roomNumber + " not found");
        return closed;
    }
    
    public String findParticipantBreakoutRoom(String participantID)
    {
        //Code
        return this.room.findParticipantBreakoutRoom(participantID);
    }
    
    public String listAllBreakoutRooms()
    {
        //Code
        return this.room.listBreakoutRooms();
    }
    
    public String listParticipantsInAllBreakoutRooms()
    {
        //Code
        String list = "";
        for(int i=1; i<=5; i++)
            list += this.room.listParticipantsInBreakoutRoom(i);
        
        if(list != "")
            return list;
        return null;
    }
}
