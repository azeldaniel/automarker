package out.Dexter_Singh_671780_assignsubmission_file_; //816009215
import java.io.File;  
import java.io.FileNotFoundException;
import java.util.Scanner; 

public class VirtualMeetingSystem
{

   private String[] participantArray = new String[500];
   protected VirtualRoom newVirtualRoom;
   private String newVirtualRoomName;
   private int partNo = 0; //count number of participants in system
   
   //constructor
   public VirtualMeetingSystem(String name){
       createVirtualRoom(name);
   }
   
   //METHODS/BEHAVIOURS/MUTATORS/ACCESSORS
   public void loadParticipantData(String filename){
      try{ 
           File participantFile = new File(filename);
           Scanner readFile = new Scanner(participantFile);
           while(readFile.hasNextLine()){
               participantArray[partNo] = readFile.nextLine();
               partNo++;
           }
           if(partNo > 50)
             for(int i = partNo; i < 500; i++)//if a dataset >50 is used
                 participantArray[i] = null;
                
           readFile.close();
      }
       
      catch(FileNotFoundException e){
       System.out.println("An error occurred.");
       e.printStackTrace();
      }
       
   }
   
   public void createVirtualRoom(String name){
        this.newVirtualRoom = new VirtualRoom(name);
        newVirtualRoom.createBreakoutRooms();
        newVirtualRoomName = name;
      
   }
   
   public void allocateParticipants(String code){//C5 Allocation
        int partCounter = 0;
        int breakRoomCounter = 0;
        if(code.equals("C5")){
            while(partCounter < partNo && breakRoomCounter < 5){
                newVirtualRoom.addParticipantToBreakoutRoom(participantArray[partCounter], breakRoomCounter);
                partCounter++;
               
                if(partCounter%5 == 0){
                    breakRoomCounter++;
                    if(breakRoomCounter == 5 && partCounter < partNo)
                        breakRoomCounter=0;
                }
            }
        }
        
        else if(code.equals("RR")){
            while(partCounter < partNo && breakRoomCounter < 5){
                newVirtualRoom.addParticipantToBreakoutRoom(participantArray[partCounter], breakRoomCounter);
                partCounter++;
                breakRoomCounter++;
                
                if(breakRoomCounter == 5 && partCounter < partNo)
                   breakRoomCounter=0;
            }    
        }
        else 
            System.out.println("Invalid code entered(Enter C5 or RR)");
   }
   
   public boolean addParticipant(String participantID, int roomNumber){
       if(newVirtualRoom.findBreakoutRoom(roomNumber)!=null){
           newVirtualRoom.addParticipantToBreakoutRoom(participantID, roomNumber);
           return true;
       }
       return false;
   }
   
   public String listParticipants(int roomNumber){
       if(newVirtualRoom.findBreakoutRoom(roomNumber)!=null)
          return newVirtualRoom.listParticipantsInBreakoutRoom(roomNumber);
       return null; 
   }
   
   public boolean openBreakoutRoom(int roomNumber){
       if(newVirtualRoom.findBreakoutRoom(roomNumber)!=null){
           return newVirtualRoom.openBreakoutRoom(roomNumber);
       }
       return false;
   }
   
   public boolean closeBreakoutRoom(int roomNumber){
       if(newVirtualRoom.findBreakoutRoom(roomNumber)!=null){
           return newVirtualRoom.closeBreakoutRoom(roomNumber);
       }
       return false;
   }
   
   public String findParticipantBreakoutRoom(String participantID){
       if(newVirtualRoom.findParticipantBreakoutRoom(participantID)!=null)
            return newVirtualRoom.findParticipantBreakoutRoom(participantID);
    return null;
   }
   
   public String listAllBreakoutRooms(){
       String list = newVirtualRoom.listBreakoutRooms();
       return list;
    }
    
   public String listParticipantsInAllBreakoutRooms() {
       String list = newVirtualRoomName+ "\n";
       for(int i = 0; i < 5; i++){
           if(newVirtualRoom.findBreakoutRoom(i)!=null)
                list = list + newVirtualRoom.listParticipantsInBreakoutRoom(i) + "\n";
        }
       if(list.equals(newVirtualRoomName))
           return null; 
       return list;
   }
  
}

/*Resources: Read file: https://www.w3schools.com/java/java_files_read.asp
 * Lecture Notes
   */
