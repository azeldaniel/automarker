package out.Kershawn_Edwards_657805_assignsubmission_file_;//816016050


import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner; 

public class VirtualMeetingSystem{

    private String data[] = new String[50];
    private int count;//counts the number of values read
    private VirtualRoom vr;
    private String participantsList;
    private int allocationCount;
    private int breakoutRoomChecker;
    private int x;
    
    public void loadParticipantData(String filename ){
    
    try{
      File participantList = new File(filename);
      Scanner sc = new Scanner(participantList);
      while (sc.hasNextLine()) {
        data[count] = sc.nextLine();
        count++;
      }
      sc.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
     
    
    
    }
    
    public void createVirtualRoom(String name){
    
        vr = new VirtualRoom(name);
        for(int x =0;x <5 ;x++){
            //System.out.println("inside createBR VR"+ "\n");
            vr.createBreakoutRooms();
            
        } 
        
        
    }
    
    public void allocateParticipants(String code ){
    
        if(code.equals("C5")){
            allocationCount = 0;
            breakoutRoomChecker = 1;
            x =0;
            while((x < count)){
                if(vr.addParticipantToBreakoutRoom(data[x], breakoutRoomChecker) == true){
                    allocationCount++;
                }
                
                if (allocationCount == 5){
                    breakoutRoomChecker++;
                    allocationCount = 0;
                    if(breakoutRoomChecker == 6){
                        breakoutRoomChecker = 1;
                    }
                }
                
                x++;
            }
            
        }
        if(code.equals("RR")){
            breakoutRoomChecker = 1;
            x =0;
            
            while( x < count){
                if(vr.addParticipantToBreakoutRoom(data[x], breakoutRoomChecker) == true){
                    breakoutRoomChecker++;
                }
                
                if(breakoutRoomChecker == 6){
                    breakoutRoomChecker = 1;
                }
                
                x++;
            }
        }
    }
    
    
    public boolean addParticipant (String participantID, int roomNumber){
    
        return vr.addParticipantToBreakoutRoom(participantID, roomNumber);
    }
    
    public String listParticipants(int roomNumber){
    
        return vr.listParticipantsInBreakoutRoom(roomNumber);
    }
    
    
    
    public boolean openBreakoutRoom(int roomNumber){
    
        return vr.openBreakoutRoom(roomNumber);
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
    
        return vr.closeBreakoutRoom(roomNumber);
    }
   
    public String findParticipantBreakoutRoom(String participantID){
    
    return vr.findParticipantBreakoutRoom(participantID);
    }
    
    public String listAllBreakoutRooms(){
    return vr.listBreakoutRooms();
    }
    
    public String listParticipantsInAllBreakoutRooms(){
        participantsList = "";
        for(int x = 1; x <= vr.getBreakoutRoomLimit(); x++){
        
            participantsList += vr.listParticipantsInBreakoutRoom(x);
        }
    return participantsList;
    }
    
     
}