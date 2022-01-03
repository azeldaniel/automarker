package out.Cleopatra_Arrindell___Walker_657673_assignsubmission_file_;import java.io.IOException;
import java.util.Scanner;
import java.io.*;
/**
 *
 * @author (813001054)
 */
public class VirtualMeetingSystem
{
        
        private BreakoutRoom[] breakoutRooms;
       
        
        public void loadParticipantData(String filename)throws IOException{
          
        String[] data = new String[50];
        int i = 0;
        Scanner readCodes = new Scanner(new File(filename));
        readCodes.useDelimiter("[,\n]");
        while(readCodes.hasNext()){
            data[i] = readCodes.nextLine();
            System.out.println(data[i]);
            i++;
  
        }
       
        readCodes.close();
        
        //www.buildingjavaprograms.com/ch07_sample.pdf
    }
   
    
    public void createVirtualRoom(String name){
         
         name = "VirtualRoom ";
         System.out.println(name);
         for(int i =0; i<5; i++){
             VirtualRoom rs = new VirtualRoom(name);
             
             System.out.println("Breakout rooms: "  + i);
            }  
        
        }
    
    
    public void allocateParticipants(String code){
          String[] allocate = new String[50];
     
        int multiple = 5;
        while(multiple < 50){
            allocate[multiple] = code;
             String participantsID = allocate[multiple];
             System.out.println(code);
             multiple = multiple + 5;
            
        }
  
    }
    
    
    public boolean addParticipant(String participantID, int roomNumber){
       
         if(!closeBreakoutRoom(roomNumber) && openBreakoutRoom(roomNumber)){
           VirtualRoom rms = new VirtualRoom(participantID, roomNumber);
           allocateParticipants(participantID);
           return true;
        }else{
               return false;
        }
}
    
    public String listParticipants(int roomNumber){
        
       
         for(int i=0; i<50; i++){
            if(openBreakoutRoom(roomNumber) ){
             return "VirtualRoom: " + roomNumber + "\n"+
             "Participants: " + listParticipants(i);
       
            }
     
         }
         return null;
            
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        
        if(roomNumber != 0 ){
           
            return true;
        
        }else{
            return false;
        }
   
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
       
        if(openBreakoutRoom(roomNumber)){
           roomNumber = 0;
            return true;
           
        }else{
            return false; 
            
        }
   
    }
    
      public String findParticipantBreakoutRoom(String participantID){
          for(int i=0; i<50; i++){
             if(openBreakoutRoom(i)){
                 return "1";
        }
       
       }
       return null;
   }
    
    public String listAllBreakoutRooms(){
        for(int i=0; i<50; i++){
            if(openBreakoutRoom(i)){
              return "1";
           }
        }
        return null;
   }
    public String listParticipantsInAllBreakoutRooms(){
        
        for(int i=0; i<50; i++){
        
             return  "BreakoutRoom: " + listAllBreakoutRooms() +" \n" +
             "Participants: " + listParticipants(i);
             
          
          }
          return null;
   }
}