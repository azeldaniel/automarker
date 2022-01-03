package out.Daniel_Herbert_657791_assignsubmission_file_;//816021155
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VirtualMeetingSystem
{
    VirtualRoom virtualRoom;
    private String list;
    private int index = 0;
    private String[] Participants = new String[20];
    
    public void VirtualMeetingSystem(){
    
    }
    
    public void loadParticipantData(String filename){
        int count = 0;
        try{
            Scanner s1 = new Scanner(new File(filename));
            while(s1.hasNextLine()){
                count++;
                s1.next();
            }
            
            Scanner s2 = new Scanner(new File(filename));
            String[] pIDs = new String[count];
            
            for(int i = 0; i < count; i++)
                pIDs[i] = s2.next();
                
            for(int i = 0; i < count; i++)
                System.out.println(pIDs[i]);
                
        }catch(FileNotFoundException e){
            System.out.println("File not found");
            e.printStackTrace();
        }
    }
    
    public void createVirtualRoom(String name){
       VirtualRoom vr = new VirtualRoom(name); 
       this.virtualRoom= vr;
    }
    
    public void allocateParticipants(String code){
        int count = 0;
        int roomNumber = 1;
        int check;
        int check1;
        if(code.equals("C5")){
            if(index % 5 == 0){
                for(int i = 1; i <= index; i = i + 5){
                    for(int j = 1; j < 5; j++){
                        virtualRoom.addParticipantToBreakoutRoom(Participants[count], roomNumber);
                        count++;
                    }
                    if(roomNumber == 5)
                        roomNumber = 1;
                    else
                        roomNumber++;
                }
            }else{
                check = (index / 5 ) * 5 ;
                check1 = (index % 5 );
                for(int k = 1 ; k <= check ; k = k + 5){
                    for(int l = 0; l < 5; l++){
                      virtualRoom.addParticipantToBreakoutRoom(Participants[count],roomNumber);
                        count++;
                    }
                    if(roomNumber == 5)
                        roomNumber = 1;
                    else
                        roomNumber++;
            }
            
            for(int m = 1; m <= check1; m++){
                virtualRoom.addParticipantToBreakoutRoom(Participants[count],roomNumber);
                count++;
            }
        }
    }else if(code.equals("RR")){
            for(int n = 1; n < index; n = n + 5 ){
                for(int o = 1; o <= 5 ; o++){
                   virtualRoom.addParticipantToBreakoutRoom(Participants[count],o);
                   count++;  
                }
            }
            
        }
}
    
    public boolean addParticipant(String participantID, int roomNumber){
        boolean check;
        if(virtualRoom.findBreakoutRoom(roomNumber)!=null){
            check=virtualRoom.addParticipantToBreakoutRoom(participantID, roomNumber);
            if(check == true){
                System.out.println("Check for Addition of participant," + participantID);
                return true;
            }
        }
        System.out.println("Check for no Addition");
        return false;
    }
    
    public String listParticipants(int roomNumber){
       list = virtualRoom.listParticipantsInBreakoutRoom(roomNumber);
       return list; 
    }
    
    public boolean openBreakoutRoom(int roomNumber){
         if(virtualRoom.findBreakoutRoom(roomNumber)!= null){
            virtualRoom.openBreakoutRoom(roomNumber);
             return true;
         }
         return false;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
         if(virtualRoom.findBreakoutRoom(roomNumber)!= null){
            virtualRoom.closeBreakoutRoom(roomNumber);
             return true;
         }
         return false;
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        String bID = virtualRoom.findParticipantBreakoutRoom(participantID);
        if(bID == null){
            System.out.println("No participants found!!!");
            return null;
        }else{
            System.out.println("Participant: "+ participantID + " was found in "+ bID);
            return bID;
        }
    }
    
    public String listAllBreakoutRooms(){
       return virtualRoom.listBreakoutRooms(); 
    }
    
    public String listParticipantsInAllBreakoutRooms(){
        String details ="Participants in Breakout Rooms \n";
        for(int i=1; i<=5; i++)
          details += virtualRoom.listParticipantsInBreakoutRoom(i)+ "\n";
    
        return details;
    }
}
