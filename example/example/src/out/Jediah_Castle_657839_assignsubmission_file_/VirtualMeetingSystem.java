package out.Jediah_Castle_657839_assignsubmission_file_;import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 
                                                                     
public class VirtualMeetingSystem
{
    // instance variables - replace the example below with your own
    private VirtualRoom  VRoom;
    private String[] pIDs = new String[50];
    
    public VirtualMeetingSystem()
    {
        // initialise instance variables
        String[] pIDs;
    }
    public void loadParticipantData(String filename){
        int x =0;
    
        try{
        Scanner IDs = new Scanner(new File(filename));
        while(IDs.hasNextLine()){
            pIDs[x] = IDs.nextLine();
            x++;
            }
        IDs.close();
          }
        catch(FileNotFoundException e){
            System.out.println("File not Found");
            e.printStackTrace();
        }
    }
    
    public void createVirtualRoom(String name){
        VRoom = new VirtualRoom(name);
        VRoom.createBreakoutRooms();
    }
    
    public void allocateParticipants(String code){
        if(code.equals("C5")){
            for(int i = 0; i < VRoom.getNumberOfBreakoutRooms(); i++){
                for(int x = 0; x < 5; x++){
                   addParticipant(pIDs[x], i);
                }
            }
        }
        else if(code.equals("RR")){
            for(int i = 0; i < VRoom.getNumberOfBreakoutRooms(); i++){
                addParticipant(pIDs[i], i);
                addParticipant(pIDs[i + 5], i);
            }
        }
    }
    
    public boolean addParticipant (String participantID,int roomNumber){
        if(VRoom.findBreakoutRoom(roomNumber - 1) != null){
            VRoom.addParticipantToBreakoutRoom( participantID,roomNumber - 1);
            return true;
        }
        return false;
    }
    
    public String listParticipants(int roomNumber){
        if(VRoom.findBreakoutRoom(roomNumber) != null){
        return VRoom.listParticipantsInBreakoutRoom(roomNumber);
        }
        return null;
    }
    
    public boolean openBreakoutRoom(int roomNumber){
         if(VRoom.findBreakoutRoom(roomNumber) != null){
            VRoom.openBreakoutRoom(roomNumber);
            return true;
        }
        return false;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
         if(VRoom.findBreakoutRoom(roomNumber) != null){
            VRoom.closeBreakoutRoom(roomNumber);
            return true;
        }
        return false;
    }
    /*
    public String findParticipantBreakoutRoom(String participantID){
        
    }
    */
    public String listAllBreakoutRooms( ){
        return VRoom.listBreakoutRooms();
    }
    
    public String listParticipantsInAllBreakoutRooms(){
        String ListOfP = " Participants in All Breakout Rooms";
        for(int i = 0; i < VRoom.getNumberOfBreakoutRooms(); i++){
             ListOfP += "/n"  + VRoom.listParticipantsInBreakoutRoom(i);
        }
        return null;
    }
}
