package out.Kymberly_Byanile_657778_assignsubmission_file_;/* Student ID: 814117667 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VirtualMeetingSystem
{
 private VirtualRoom tempVRoom; 
 private String name; //testing
 private int count = 0;
 public void loadParticipantData(String filename){
     
        String[] arrayOfNames = new String[53]; 
        int arrayLen = 0;
        try {
        File participantDataFile = new File(filename);
        Scanner fileData = new Scanner(participantDataFile);
        while (fileData.hasNextLine()){
            String input = fileData.nextLine();
                arrayOfNames[arrayLen] = input;
                arrayLen+=1;
            //System.out.println(input); //input to array
        }
    
      fileData.close();
      System.out.println("Loaded "+arrayLen+ " IDs.");
     }
      catch(FileNotFoundException e){
      System.out.println("The file containing the data was not found");
      e.printStackTrace();
      }
    
 }
 
 public void createVirtualRoom(String name){
    //this is where to invoke virtual room
    VirtualRoom newVirtualRoom = new VirtualRoom(name);
    
    for (int i = 0; i < 5; i ++){
    newVirtualRoom.createBreakoutRooms();
    }
    System.out.println("New Virtual Room "+name+ " created.");
 }
 
 public boolean addParticipant (String participantID,int roomNumber){
     VirtualRoom tempRoom = new VirtualRoom(this.name);
     
     if (tempRoom != null){
        tempRoom.addParticipantToBreakoutRoom(participantID, roomNumber);
        return true;
        }   
     return false;
 }   
 
 public String listParticipants(int roomNumber){
     VirtualRoom tempRoom = new VirtualRoom(this.name);
     if (tempRoom != null){
        String list = tempRoom.listParticipantsInBreakoutRoom(roomNumber);
        return list;
        }
     
    return null;
 }
 
 public boolean openBreakoutRoom(int roomNumber) {
    
    VirtualRoom tempRoom = new VirtualRoom(this.name);
    
    if(tempRoom.openBreakoutRoom(roomNumber)){
        return true;
    }
    return false;
 }
 
 public boolean closeBreakoutRoom(int roomNumber) {
    
    VirtualRoom tempRoom = new VirtualRoom(this.name);
    
    if(tempRoom.closeBreakoutRoom(roomNumber)){
        return true;
    }
    return false;
 }
 
 public String findParticipantBreakoutRoom (String participantID) {
  String roomID;
  VirtualRoom tempRoom = new VirtualRoom(this.name);
  return tempRoom.findParticipantBreakoutRoom(participantID); 
 }   
 
  public String listAllBreakoutRooms(){
  VirtualRoom tempRoom = new VirtualRoom(this.name);
  return tempRoom.listBreakoutRooms();
 }
 
  public String listParticipantsInAllBreakoutRooms() {
  
  VirtualRoom tempRoom = new VirtualRoom(this.name);
  for (int i = 0; i <= tempRoom.getNumberOfBreakoutRooms(); i++){
    return tempRoom.listParticipantsInBreakoutRoom(i);
    }
    
  return null; 
 }
 
 
 
 
 public void allocateParticipants(String code){
     VirtualRoom tempRoom = new VirtualRoom(this.name);
     int x = 1;
     int y = 1;
     
     
     if (code.equals("C5")){
         while (x < this.count){
            if(y == 6){
                y = 1;
            }
            }
         for (int z = 1; z <= 5; z++){
            //this.tempVRoom.addParticipantToBreakoutRoom(code);
            }
        }
        
     if (code.equals("RR")){
        for (int i = 1; i <= this.count; i++){
        // this.tempVRoom.addParticipantToBreakoutRoom(code);
        y++;
        }
        }
 }
}
