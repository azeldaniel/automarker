package out.Ryan_Harris_657812_assignsubmission_file_;import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner; 

/*
 * 
 * ID: 816021062
 * Name: Ryan Harris
 * 
 */
public class VirtualMeetingSystem
{
    private VirtualRoom virtualRooms;
    private static String[] fileIDs;
    private static int numIDs=0;
    
    private static int countLines(String filename){
        int count = 0;
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                count++;
            }
            myReader.close();
            return count;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return -1;
    }
    
    
    public void loadParticipantData (String filename){
        int count = countLines(filename);
        fileIDs = new String[count+1];
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                fileIDs[numIDs] = data;
                //System.out.println(fileIDs[numIDs]);
                numIDs++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    public void createVirtualRoom(String name){
        virtualRooms = new VirtualRoom(name);
        virtualRooms.createBreakoutRooms();
    }
     
    public void allocateParticipants(String code ){
        int numBreakoutRooms = virtualRooms.getNumberOfBreakoutRooms();
        int room = 1;
        if (code.equals("C5")){
            int count;
            System.out.println("Groups of 5");
            for (int i=0; i<numIDs; i=count){
                count = i + 5;
                for (int j=i; j<count ; j++){
                    if (j<numIDs){
                        if (!virtualRooms.addParticipantToBreakoutRoom(fileIDs[j], room)){
                            if (!virtualRooms.isBreakoutRoomOpen(room)){
                                j--;
                                room++;
                                if (room > numBreakoutRooms) room=1;
                            }else{
                                count++;
                            }
                        }
                    }
                }
                room++;
                if (room > numBreakoutRooms) room=1;
            }
        }else if (code.equals("RR")){
            System.out.println("Round Robin");
            for (int i=0; i<numIDs; i++){
                if (!virtualRooms.addParticipantToBreakoutRoom(fileIDs[i], room)){
                    if (!virtualRooms.testID(fileIDs[i])) System.out.println("This ID was not added");
                    else if (!virtualRooms.isBreakoutRoomOpen(room)){
                        i--;
                        room++;
                        if (room > numBreakoutRooms) room=1;
                    }
                }else{
                    room++;
                    if (room > numBreakoutRooms) room=1;
                }
            }
        }
    
    }
    
    public boolean addParticipant (String participantID,int roomNumber){
        if (virtualRooms.addParticipantToBreakoutRoom(participantID, roomNumber)){
            //System.out.println("Participant Added");
            return true;
        }else return false;
    }
    
    public String listParticipants(int roomNumber){
        
        return virtualRooms.listParticipantsInBreakoutRoom(roomNumber);
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        return virtualRooms.openBreakoutRoom(roomNumber);
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        return virtualRooms.closeBreakoutRoom(roomNumber);
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        return virtualRooms.findParticipantBreakoutRoom(participantID);
    }
    
    public String listAllBreakoutRooms( ){
        return virtualRooms.listBreakoutRooms();
    }
    
    public String listParticipantsInAllBreakoutRooms(){
        int numBreakoutRooms = virtualRooms.getNumberOfBreakoutRooms();
        int room;
        String details= "";
        for (room = 1; room<=numBreakoutRooms ; room++){
            details += virtualRooms.listParticipantsInBreakoutRoom(room);
            details += "\n\n";
        }
        return details;
    }
    
    

}
