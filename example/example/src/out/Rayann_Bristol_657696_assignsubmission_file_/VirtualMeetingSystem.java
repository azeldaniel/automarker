package out.Rayann_Bristol_657696_assignsubmission_file_;import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Rayann Bristol
 * 816013958
 */
public class VirtualMeetingSystem
{
    private VirtualRoom virtualRoom;
    
    public void loadParticipantData(String filename)
    {
        String[] data = new String [50];
        int i =0;
        try{
            Scanner scanner = new Scanner(new File("participant.dat"));
            while(scanner.hasNextLine()){
                data[i] = scanner.nextLine();
                i++;
            }
            scanner.close();
        }catch(FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    public void createVirtualRoom(String name)
    {
       VirtualRoom[] virtualRoom = new VirtualRoom[5];
       VirtualRoom vr = new VirtualRoom(name);
    }
     
    public void allocateParticipants(String code)
    {
        String[] data = new String [50];
        int k =data.length;
        if(code.equals("C5"))
        {
           for(int i=0;i<5;i++){//traverse breakout rooms
               for(int j=0;j<5;j++){//adding 5 participants
                      addParticipant(data[k],j);
                      k++;//increment array
                }
            }
        }
        
        if(code.equals("RR"))
        {
            int b =0;
            for(int a=0;a<5;a++){//roomNumber
                while(b<5){//breakout room
                    addParticipant(data[k],b);
                    k++;//traverse array
                    b++;
                }
            }
        }
    }
    
    public boolean addParticipant(String participantID, int roomNumber)
    {
      if(virtualRoom.findBreakoutRoom(roomNumber).equals(roomNumber)){
          virtualRoom.addParticipantToBreakoutRoom(participantID,roomNumber);
          return true;
      }else{
          return false;
      }
    }
    
    public String listParticipants(int roomNumber)
    {
        if(virtualRoom.findBreakoutRoom(roomNumber).equals(roomNumber)){
            virtualRoom.listParticipantsInBreakoutRoom(roomNumber);
        }
        return null;    
    }
    
    public boolean openBreakoutRoom(int roomNumber)
    {
        if(virtualRoom.findBreakoutRoom(roomNumber).equals(roomNumber)){
            virtualRoom.openBreakoutRoom(roomNumber);
            return true;
        }
        return false;
    }
    
    public boolean closeBreakoutRoom(int roomNumber)
    {
        if(virtualRoom.findBreakoutRoom(roomNumber).equals(roomNumber)){
            virtualRoom.closeBreakoutRoom(roomNumber);
            return false;
        }
        return true;
    }
    
    public String findParticipantBreakoutRoom(String participantID)
    {
       if(virtualRoom.findParticipantBreakoutRoom(participantID).equals(participantID))
       {
           return virtualRoom.findParticipantBreakoutRoom(participantID);
       }else{
           return null;
       }
    }
    
    public String listAllBreakoutRooms()
    {
        String details = " ";
        details += "List of all Breakout Rooms: " + "\n";
        for(int k=0;k<virtualRoom.getNumberOfBreakoutRooms();k++){
            details += virtualRoom.listBreakoutRooms().toString();
        }
          
        return details;
    }
    
    public String listParticipantsInAllBreakoutRooms()
    {
        String details = " "; 
            for(int k=0;k<virtualRoom.getNumberOfBreakoutRooms();k++){
                details+= "Participants in Room: "+ "\n";
                details += virtualRoom.listParticipantsInBreakoutRoom(k);
            }
            return details;
    }
}

