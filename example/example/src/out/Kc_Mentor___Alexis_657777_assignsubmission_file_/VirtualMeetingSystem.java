package out.Kc_Mentor___Alexis_657777_assignsubmission_file_;//816018833
import java.util.*;
import java.io.*;

public class VirtualMeetingSystem{
   
   private Scanner data;
   private String filename;
   private int numberOfIDs;
   private String Participants[];
   private String virtualRoomName;
   private VirtualRoom VirtualRoom;
   
   public void loadParticipantData(String filename){
       
        numberOfIDs =0;
        this.filename = filename;
        Participants = new String[50];
        
        try{
            data = new Scanner (new File (filename));    
        }
        catch(Exception e){
            System.out.println("File not found");
        }
        
        while(data.hasNext()){
            String ID = data.next();
            Participants[numberOfIDs] = ID;
            numberOfIDs++;
        }
        
        data.close();
   } 
   
   public void createVirtualRoom(String name){
       
       this.virtualRoomName = name;
       
       VirtualRoom = new VirtualRoom(name);
 
       VirtualRoom.createBreakoutRooms();
   }
   
   public void allocateParticipants(String code){
       String participants = "";
       int i=0;
       int l=0;;
       int k=0;
       
       if(code == "C5"){
           for(k=0; k < numberOfIDs; k++){
                 if(l >= 1){
                    k--;
                 } 
                 for(int j =0; j < 5; j++){
                      for(i=0; i < 5; i++){
                         VirtualRoom.addParticipantToBreakoutRoom(Participants[k],j);
                         k++;
                       }      
                 }
                 l++;
           }
       }
       
       if(code == "RR"){
           for(k=0; k < numberOfIDs; k++){
                 if(l >= 1){
                    k--;
                 } 
                 for(int j =0; j < 5; j++){
                         VirtualRoom.addParticipantToBreakoutRoom(Participants[k],j);
                         k++;
                 }
                 l++;
           }
                 
       }  
   }
   
   public boolean addParticipant (String participantID,int roomNumber){
      
       int i;
      
      if(VirtualRoom.findBreakoutRoom(roomNumber-1) !=null){
         if(VirtualRoom.addParticipantToBreakoutRoom(participantID,roomNumber-1) ==true){
              return true;
         }
         return false;
      } 
      return false;
   } 
   
   public String listParticipants(int roomNumber){
       String participants="";
       if(VirtualRoom.findBreakoutRoom(roomNumber-1) !=null){
           participants = VirtualRoom.listParticipantsInBreakoutRoom(roomNumber-1);
           return participants; 
       }
       return null; 
   }
   
   public boolean openBreakoutRoom(int roomNumber){
       if(VirtualRoom.openBreakoutRoom(roomNumber-1)){
         return true;  
       }
       return false;
   }
   
   public boolean closeBreakoutRoom(int roomNumber){
       if(VirtualRoom.closeBreakoutRoom(roomNumber-1)){
         return true;  
       }
       return false;
   }
   
   public String findParticipantBreakoutRoom (String participantID){
      
      String found = VirtualRoom.findParticipantBreakoutRoom (participantID);
      if(found !=null){
          return found;
      }
      return null;
   }
   
   public String listAllBreakoutRooms( ){
       return VirtualRoom.listBreakoutRooms();
   }
   
   public String listParticipantsInAllBreakoutRooms(){
       
       String participants = "";
       
        for(int i=0; i < 5; i++){
         participants = participants + VirtualRoom.listParticipantsInBreakoutRoom(i);
       }
       
       return participants;
   }
}
   
   
