package out.Matthew_Paul_657732_assignsubmission_file_;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
 
//Matthew Paul 816018640


public class VirtualMeetingSystem
{
    private VirtualRoom VR;
    private String[] allocations=new String[1000];
    private int numParticipants=0;
    
        
    
    public void loadParticipantData(String filename){
          try{
          File reader=new File(filename);
          Scanner data= new Scanner(reader);
          while(data.hasNextLine()){
             String id=data.nextLine();
             allocations[numParticipants]=id;
             numParticipants++;
            }
          data.close();
          }catch(FileNotFoundException e){
          System.out.println("Error");
          e.printStackTrace();
          }
        }
    
    public void createVirtualRoom(String name){
            VR=new VirtualRoom(name); 
            VR.createBreakoutRooms();
    }
    
    
    public void allocateParticipants(String code ){
        if(code.equals("C5")){
            int roomID=0;
            int assignRoom=0;
            int count=0;
            for(int i=0;i<numParticipants;i+=5){
                
            roomID=roomID+1;
            if(roomID>5){
                roomID=1;
            }
            for(int j=0;j<5;j++){
                    VR.addParticipantToBreakoutRoom(allocations[count],roomID);
                    count++;
                }
            }
        }
        else if(code.equals("RR")){
        int roomID=0;
        for(int i=0;i<numParticipants;i++){
            roomID++;
            if(roomID>5){
            roomID=1;
            }
            VR.addParticipantToBreakoutRoom(allocations[i],roomID);
        }
        }
     
    }
    
    public boolean addParticipant (String participantID,int roomNumber){
        boolean added=VR.addParticipantToBreakoutRoom(participantID,roomNumber);
        if(added==true){
        return true;
        }
        return false;
    }
    
    public String listParticipants(int roomNumber){
        String list=" ";
        list=VR.listParticipantsInBreakoutRoom(roomNumber);
        return list;
    }
   
    public boolean openBreakoutRoom(int roomNumber){
        boolean open=VR.openBreakoutRoom(roomNumber);
        if(open==true){
        return true;
        }
        return false;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        boolean closed=VR.closeBreakoutRoom(roomNumber);
        if(closed==true){
        return true;
        }
        return false;
    }
    
    public String findParticipantBreakoutRoom(String participantID){
          String roomID=" ";
          roomID=VR.findParticipantBreakoutRoom(participantID);
          return roomID;
    }
    
    public String listAllBreakoutRooms(){
        String rooms=" ";
        rooms=VR.listBreakoutRooms();
        return rooms;
    }
    
    public String listParticipantsInAllBreakoutRooms(){
        String list=" ";
        for(int i=1;i<=5;i++){
            list=list +VR.listParticipantsInBreakoutRoom(i)+ " ";
        }
        return list;
    }
}
