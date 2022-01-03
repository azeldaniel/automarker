package out.Arun_Persaud_657699_assignsubmission_file_;//Arun Persaud 816019788
import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner; 
import java.util.Random;

public class VirtualMeetingSystem{
    private String name;
    private static String[] participants; 
    private VirtualRoom[] virtualRooms;
    private VirtualRoom vrm = new VirtualRoom(name);
    
    public VirtualMeetingSystem(String name){
         this.name = name;
         participants = new String[50];
         virtualRooms = new VirtualRoom[2];
    }
   
    public void  loadParticipantData(String filename) throws FileNotFoundException{
       int counter=0;
       File fin = new File(filename);
       Scanner key = new Scanner(fin);
       while (key.hasNextLine()) {
           participants[counter] = key.nextLine();
           counter++;
       }
    
    }
    
    public void createVirtualRoom(String name){
         VirtualRoom vRoom = new VirtualRoom(this.name, 5);
         virtualRooms[0] = vRoom;
         vRoom.createBreakoutRooms();
    }
    
    public void allocateParticipants(String code){
         if(code.equals("C5")){
            int val = 0;
            for(int room = 2; room<6;room++){
                for(int y=0;y<5;y++){
                      //System.out.println(participants[val]);
                     //System.out.println(room);
                     virtualRooms[0].addParticipantToBreakoutRoom(participants[val],room);
                     val++;
                }
            }  
        }
    }
    
     
     public boolean addParticipant(String participantID, 
    int roomNumber){
          if(virtualRooms[0].addParticipantToBreakoutRoom(participantID, roomNumber)){
               return true;
          }
         
          return false;
     }
   
   
    public String listParticipants(int roomNumber){
        return virtualRooms[0].listParticipantsInBreakoutRoom(roomNumber);
     
    }
   
  
   public boolean openBreakoutRoom(int roomNumber){
       virtualRooms[0].openBreakoutRoom(roomNumber);
       return true;
       
   }
   
   
   public boolean closeBreakoutRoom(int roomNumber){
       virtualRooms[0].closeBreakoutRoom(roomNumber);
       return true;
   }
   
   
   public String findParticipantBreakoutRoom
   (String participantID){
        String data = virtualRooms[0].findParticipantBreakoutRoom(participantID);
        return data;
    }
   
   
   public String listAllBreakoutRooms(){
       return virtualRooms[0].listBreakoutRooms();
   }
   
   public String listPariticipantsInAllBreakoutRooms(){
       String details = "";
       for(int i=0;i<10;i++){
           details += virtualRooms[0].listParticipantsInBreakoutRoom(i);
       }
       return details;
   }
   
}
