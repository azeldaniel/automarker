package out.Satash_Rampersad_657829_assignsubmission_file_;
/**
 * 816020134
 */
import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.Scanner; 
public class VirtualMeetingSystem{
    
    private String[] list = new String[50];
    private int numOfParticipants = 0;
    VirtualRoom virtualRoom;
    
    public VirtualMeetingSystem() {
    }
    
    public void loadParticipantData(String filename) {
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                list[numOfParticipants] = myReader.nextLine();
                numOfParticipants++;
            }
            
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
    }
    
    public void createVirtualRoom(String name) {
        virtualRoom = new VirtualRoom(name);
        virtualRoom.createBreakoutRooms();
    }
    
    public void allocateParticipants(String code) {
         
        int count = 0;
        int num = 1;
        int numberOfBreakoutRooms = virtualRoom.getNumberOfBreakoutRooms();
        int a = 0;
        if (code.equals("C5")) {
            while (a < numOfParticipants) {
                if (count == 5) {
                    count = 0;
                    num++;
                }

                if(num > numberOfBreakoutRooms)
                    num = 1;

                virtualRoom.addParticipantToBreakoutRoom(list[a], num);

                a++;
                count++;

            }
        } else if (code.equals("RR")) {
            while (a < numOfParticipants) {
               
                virtualRoom.addParticipantToBreakoutRoom(list[a], num);
                
                if(num == numberOfBreakoutRooms){
                    num = 1;
                }else{
                    num++;
                }

                a++;
                
            }

        } else {
            System.out.println("Code is invalid.");
        }
        
    }
    
    public boolean addParticipant(String participantID, int num) {
        if (virtualRoom.findBreakoutRoom(num) != null) {
            virtualRoom.addParticipantToBreakoutRoom(participantID, num);
            return true;
        }
        return false;
    }
    
    public String listParticipants(int num){
        if (virtualRoom.findBreakoutRoom(num) != null) {
            return virtualRoom.listParticipantsInBreakoutRoom(num);
        }
        return null;
    }
    
    public boolean openBreakoutRoom(int num){
        if (virtualRoom.findBreakoutRoom(num) != null) {
            return virtualRoom.openBreakoutRoom(num);
        }
        return false;
    }
    
    public boolean closeBreakoutRoom(int num){ 
        if (virtualRoom.findBreakoutRoom(num) != null) {
            return virtualRoom.closeBreakoutRoom(num);
        }
        return false;
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        return virtualRoom.findParticipantBreakoutRoom(participantID);
    }
    
    public String listAllBreakoutRooms(){
        return virtualRoom.listBreakoutRooms();
    }
 
    public String listParticipantsInAllBreakoutRooms(){
        int numOfBreakoutRooms = virtualRoom.getNumberOfBreakoutRooms( );
        String list = "";
        for(int i = 1; i <= numOfBreakoutRooms; i++) {
            list += virtualRoom.listParticipantsInBreakoutRoom(i) + "\n";
        }
        return list;
    }
    
    // Adapted from: https://www.w3schools.com/java/java_files_read.asp
}
