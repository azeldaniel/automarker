package out.Melika_Ogarro_657708_assignsubmission_file_;
/**
 *
 * @authorID (816002233)
 * @version (13.02.2021)
 */

import java.io.File;
import java.io.FileNotFoundException;  
import java.util.Scanner; 

public class VirtualMeetingSystem{
    private VirtualRoom vR;
    private String[] participants = new String[50];
    int numParticipants=0;
    

   public void loadParticipantData(String filename)
   {
        
        try {
            File readF = new File(filename);
            Scanner scan = new Scanner(readF);
            
            while (scan.hasNextLine()) {
                String data = scan.nextLine();
                participants[numParticipants] = data;
                System.out.println(participants[numParticipants]);
                numParticipants++;
            }
            //System.out.println("TOTAL: " + numParticipants);
            scan.close();
            
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
    }
    
   public int getNumberOfParticipants(){
        return numParticipants;
    }
    
   public void createVirtualRoom(String name){
        vR = new VirtualRoom(name);  
        vR.createBreakoutRooms();
    }
    
   public void allocateParticipants(String code){
        
        if(code.equals("C5") || code.equals("c5")){
            int roomNumber =1;
            int count = 0;
            for(int i=0; i<getNumberOfParticipants(); i++){
                    vR.addParticipantToBreakoutRoom(participants[i], roomNumber);
                    count++;
                    if(count%5==0 && roomNumber <= vR.getBreakoutRoomLimit()){
                        roomNumber++;
                    }
                    if (roomNumber > vR.getBreakoutRoomLimit()){
                        count = 0;
                        roomNumber = 1;
                    }
            }
        }
        
        if(code.equals("RR") || code.equals("rr") || code.equals("rR") || code.equals("Rr")){
            int roomNumber = 1;
            int count = 0;
            for(int i=0; i<getNumberOfParticipants(); i++){
                    vR.addParticipantToBreakoutRoom(participants[i], roomNumber);
                    roomNumber++;
                    count++;
                    if(roomNumber > vR.getBreakoutRoomLimit()){
                        roomNumber = 1;
                    }
            }       
        }
    }
        
   public boolean addParticipant(String participantID, int roomNumber){
       return vR.addParticipantToBreakoutRoom(participantID, roomNumber);
    }
    
   public String listParticipants(int roomNumber){
       return vR.listParticipantsInBreakoutRoom(roomNumber);
       
   }
   
   public boolean openBreakoutRoom(int roomNumber){
       return vR.openBreakoutRoom(roomNumber);
   }
   
   public boolean closeBreakoutRoom (int roomNumber){
       return vR.closeBreakoutRoom(roomNumber);
   }
   
   public String findParticipantBreakoutRoom(String participantID){
       return vR.findParticipantBreakoutRoom(participantID);
   }
   
   public String listAllBreakoutRooms(){
       return vR.listBreakoutRooms();
   }
   
   public String listParticipantsInAllBreakoutRooms(){
       String list="";
       for(int i=1; i<=vR.getNumberOfBreakoutRooms(); i++){
          if(listParticipants(i)!= null){
              list += listParticipants(i) + "\n\n";
            }
       }
       return list;
   }
    
    
    
    
}
    
  
