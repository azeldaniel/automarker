package out.Xern_Mottley_657730_assignsubmission_file_;//81601935


import java.io.*;
import java.util.*;

public class VirtualMeetingSystem
{    
    VirtualRoom VM;
    private int participantCount=0;
    private String[] participantID= new String[50];
    public void loadParticipantData(String filename){
        String s;
        try{
            BufferedReader br= new BufferedReader(new FileReader( filename));
            s=br.readLine();
            while((s!=null )){
                participantID[participantCount]=s;
                s=br.readLine();
                participantCount++;
            }
            br.close();
        }catch(Exception ex){
            return;
        }
        
    }
    public void createVirtualRoom(String name){
        VM= new  VirtualRoom(name);
    }
   
    public void allocateParticipants(String code) {
        VM.createBreakoutRooms();
        int participantTracker=0;
        int roomNum=1;
        int count=0;
        if (code=="RR") {
            while(participantTracker< participantCount){
                VM.addParticipantToBreakoutRoom(participantID[participantTracker], roomNum);
                if(roomNum==VM.getNumberOfBreakoutRooms()){
                    roomNum=1;
                }else{
                    roomNum++;
                }
                participantTracker++;
            }
        }else if(code=="C5"){
            while(participantTracker<participantCount){
                if(count==5){
                    count=0;
                    roomNum++;
                }
                if(roomNum>VM.getNumberOfBreakoutRooms()){
                    roomNum=1;
                }
                VM.addParticipantToBreakoutRoom(participantID[participantTracker], roomNum);
                participantTracker++;
                count++;
            }
        }else{
            System.out.println("Enter valid code");
        }  
    }
   
    public boolean addParticipant(String participantID, int roomNumber) {
        if (VM.findBreakoutRoom(roomNumber) != null) {
            VM.addParticipantToBreakoutRoom(participantID, roomNumber);
            return true;
        }else
            return false;
    }
    
    
    public String listParticipants(int roomNumber){
        if (VM.findBreakoutRoom(roomNumber) != null) {
            return VM.listParticipantsInBreakoutRoom(roomNumber);
        }
        return null;
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        if (VM.findBreakoutRoom(roomNumber) != null) {
            return VM.openBreakoutRoom(roomNumber);
        }
        return false;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){ 
        if (VM.findBreakoutRoom(roomNumber) != null) {
            return VM.closeBreakoutRoom(roomNumber);
        }else
            return false;
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        return VM.findParticipantBreakoutRoom(participantID);
    }
    
    public String listAllBreakoutRooms(){
        return VM.listBreakoutRooms();
    }
    
    public String listParticipantsInAllBreakoutRooms(){
        int numOfBreakoutRooms = VM.getNumberOfBreakoutRooms( );
        String List="";
        for(int i = 1; i <= numOfBreakoutRooms; i++) {
            List+=VM.listParticipantsInBreakoutRoom(i);
        }
        return List;
    }
}
