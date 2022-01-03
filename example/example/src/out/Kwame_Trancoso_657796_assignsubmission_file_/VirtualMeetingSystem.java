package out.Kwame_Trancoso_657796_assignsubmission_file_;//816005595   
import java.io.File;  
    import java.io.FileNotFoundException;  
    import java.util.Scanner; 
    public class VirtualMeetingSystem   {
        public VirtualRoom vRoom;
        public String[] participants = new String[100] ;
        
        
        public VirtualMeetingSystem()
        {
            
        }
        
        public void loadParticipantData(){
             try {
                 File data = new File("participant.dat");
                 Scanner scanner = new Scanner(data);
                 int i=1;
                    while (scanner.hasNextLine()) {
                        String s = scanner.nextLine();
                        participants[i]=s;
                        i++;
                }
                scanner.close();
            }   catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
             
        }


    public void createVirtualRoom(String name){
        vRoom = new VirtualRoom(name,5);
    }
    
    public void allocateParticipants(String code){
        int room = 1;
        if(code=="C5"){
            for(int i = 1; i<= 60; i++){
                if(i%5==0){
                    if(room<5){
                        vRoom.addParticipantToBreakoutRoom(participants[i],room);
                        room++;
                    }
                    else
                        room=1;
                }   
                else{
                    vRoom.addParticipantToBreakoutRoom(participants[i],room);
                }
            }
        }
    }
    public boolean addParticipant(String participantID, int roomNumber){
        boolean status;
        status = vRoom.addParticipantToBreakoutRoom(participantID,roomNumber);
        return status;
    }
    
    public String listParticipnats(int roomNumber){
        String s;
        s = vRoom.listParticipantsInBreakoutRoom(roomNumber);
        return s;
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        boolean status;
        status = vRoom.openBreakoutRoom(roomNumber);
        return status;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        boolean status;
        status = vRoom.closeBreakoutRoom(roomNumber);
        return status;
    }
    
    public String findParticipnatBreakoutRoom(String participantID){
        String s;
        s = vRoom.findParticipantBreakoutRoom(participantID);
        return s;
    }
    
    public String listAllBreakoutRooms(){
        String s;
        s = vRoom.listBreakoutRooms();
        return s;
    }
    
    public String listParticipantsInAllBreakoutRooms(){
        String s=null;
        int i=0;
        while(i<5){
            s = vRoom.listParticipantsInBreakoutRoom(i);
            i++;
        }  
       return s;
    }
    
}
