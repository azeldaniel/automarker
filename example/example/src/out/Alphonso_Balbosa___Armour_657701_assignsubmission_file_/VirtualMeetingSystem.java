package out.Alphonso_Balbosa___Armour_657701_assignsubmission_file_;//STUDENT I.D. == 816018750
/**
 * Write a description of class VirtualMeetingSystem here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner;

public class VirtualMeetingSystem{
   private String[] participantID_array = new String[50];
   private int p_Index=0;
   VirtualRoom vr_1;  
    
   public void loadParticipantData(String file){
       String participantID;
       try{
           Scanner scanner = new Scanner(new File(file));
           while(scanner.hasNextLine()){
               participantID = scanner.nextLine();
               participantID_array[p_Index] = participantID;
               p_Index++;
            }
            scanner.close();
       }catch (FileNotFoundException e) {
          System.out.println("File not found.");
          e.printStackTrace();
       }  
    }
    
    public void createVirtualRoom(String name){
       VirtualRoom newRoom = new VirtualRoom(name);
       this.vr_1 = newRoom;
    }
    
    public void allocateParticipants(String code){
      int count_1;
      int count_2;
      int room_number = 1;
      int p_count = 0; 
        if(code.equals("C5")){
            if(p_Index % 5 == 0){
                for(int x = 1 ; x <= p_Index ; x = x + 5){
                    for(int y=0; y<5; y++){
                      vr_1.addParticipantToBreakoutRoom(participantID_array[p_count],room_number);
                        p_count++;
                      
                    }
                    if(room_number == 5){
                        room_number = 1;
                    }else{ 
                        room_number++;
                    }
                }
            }else{
                count_1 = (p_Index / 5 ) * 5 ;
                count_2 = (p_Index % 5);
                for(int x = 1 ; x <= count_1 ; x = x + 5){
                    for(int y=0; y<5; y++){
                      vr_1.addParticipantToBreakoutRoom(participantID_array[p_count],room_number);
                        p_count++;
                        
                    }
                    
                    if(room_number == 5){
                        room_number = 1;
                    }else{ 
                        room_number++;
                    }
                }
                for(int i = 1 ; i <= count_2 ; i++){
                    vr_1.addParticipantToBreakoutRoom(participantID_array[p_count],room_number);
                    p_count++;
                }
                
            
            }
            
        }else if(code.equals("RR")){
            for(int x = 1 ; x < p_Index ; x = x + 5 ){
                for(int y = 1; y <= 5 ; y++){
                   vr_1.addParticipantToBreakoutRoom(participantID_array[p_count], y);
                   p_count++;  
                }
            }
        }
        
       
    }
    
    public boolean addParticipant(String participantID, int room_number){
        boolean check;
        if(vr_1.findBreakoutRoom(room_number)!=null){
            
            check = vr_1.addParticipantToBreakoutRoom(participantID, room_number);
            if(check == true){
                System.out.println("Participant: " + participantID + " has been added to room " + room_number + ".");
                return true;
            }
        }
        System.out.println("Participant could not be added to room.");
        return false;
    
    }
        
    public String listParticipants(int room_number){
        return vr_1.listParticipantsInBreakoutRoom(room_number); 
    }
    
    public boolean openBreakoutRoom(int room_number){
         if(vr_1.findBreakoutRoom(room_number)!=null){
            vr_1.openBreakoutRoom(room_number);
             return true;
         }
         return false;
    }
    
    public boolean closeBreakoutRoom(int room_number){
         if(vr_1.findBreakoutRoom(room_number)!=null){
            vr_1.closeBreakoutRoom(room_number);
            return true;
         }
         return false;
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        String breakoutRoomID;
        breakoutRoomID = vr_1.findParticipantBreakoutRoom(participantID);
        if(breakoutRoomID == null){
            System.out.println("Participant not found.");
            return null;
        }else{
            System.out.println("Participant: " + participantID + " found in "+ breakoutRoomID + ".");
            return breakoutRoomID;
        }
    
    }
    
    public String listAllBreakoutRooms(){
       return vr_1.listBreakoutRooms(); 
    }
    
    public String listParticipantsInAllBreakoutRooms(){
        String participant_list = "";
        for(int i=1; i<=5; i++){
          participant_list += vr_1.listParticipantsInBreakoutRoom(i)+ "\n";
        }
        return participant_list;
    }
}
   
  

