package out.Gersha_France_657754_assignsubmission_file_;//816009767

import java.io.File;  

import java.io.FileNotFoundException;  

import java.util.Scanner; 

public class VirtualMeetingSystem{

    private int  rn;  
    private String listParticipants;
    private String participantID;
    
    private boolean isopenBR;
    private Participant[] participant;
    
  public static void loadParticipantData(String[] args) {
      
      int i=0;
    try {
      File myObj = new File("participant.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
          
          
        String data = myReader.nextLine();
        args[i] = data;
        i++;
       
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }


    public void createVirtualRoom(String name) {
    VirtualRoom[] rooms = new VirtualRoom [10];
     
     VirtualRoom r1 = new VirtualRoom(name);
     VirtualRoom r2 = new VirtualRoom (name);
     VirtualRoom r3 = new VirtualRoom (name);
     VirtualRoom r4 = new VirtualRoom (name);
     
     rooms[0]=r1;
     rooms[1]=r2;
     rooms[2]=r3;
     rooms[3]=r4;
   }

        public void allocateParticipants(String code) {
    
            }

        public boolean addParticipant(String participantID,  int roomNumber){
          
    
    
    return true;
        }


    public String listParticipants(int roomNumber) {
       if(roomNumber == 0){
            return "no roomNumber ";
        }else{
            String details =  " ";
            for(int i = 0; i < roomNumber; i++){
            details += roomNumber;
            
        }
        return details;
    }
    
       }

    public boolean openBreakoutRoom(int roomNumber){
      if (!isopenBR){
                isopenBR = true;
                return true;
            }
            return false;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        
          if (isopenBR == true){
                isopenBR = false;
                return true;
            }
            return false;
    
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        return participantID;
    }
    
    public String listAllRooms(){
          if(rn == 0){
            return "no roomNumber ";
        }else{
            String details =  " ";
            for(int i = 0; i < rn; i++){
            details += rn;
            
        }
        return details;
    }
    }
    
    public String listParticipantsInAllBreakRoom(){
        String details = "";
        return  details;
    }





 }
