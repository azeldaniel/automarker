package out.Brittney_Cupen_657790_assignsubmission_file_;//Brittney Cupen 8160222438
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VirtualMeetingSystem
{   
    private String[] data;
    private int count;
    private VirtualRoom room;
    
    public void loadParticipantData(String filename) throws FileNotFoundException{
        try{ 
            //I was trying to open file and read to find the number of elements
            //before reading the file again for the data
            //but it wouldn't execute.
            data = new String[50];
            count = 0;
            Scanner scan = new Scanner(new File(filename));
            while(scan.hasNext()){
                data[count] = scan.nextLine();
                count++;
            }
            scan.close();
        }
        
        catch(FileNotFoundException err){
            System.out.println("No file found");
        }
        
    }
    
    public void createVirtualRoom(String name){
        room = new VirtualRoom(name);
        room.createBreakoutRooms();
    }
    
    public void allocateParticipants(String code){
        int roomNumber = 1;
        if(code.equals("C5")){
            for(int i=0; i<count; i++){
                int check = (i+1) % 5;
                if(check == 0){
                    roomNumber = roomNumber + 1;
                }
                if(roomNumber == 6){
                    roomNumber = 1;
                }
                room.addParticipantToBreakoutRoom(data[i], roomNumber);
            }
        }
        else if(code.equals("RR")){
            for(int i=0; i<count; i++){
                roomNumber = (i%5) + 1;
                room.addParticipantToBreakoutRoom(data[i], roomNumber);
            }
        }
        else{
            System.out.println("Invalid Code entered");
        }
    }
    
    public boolean addParticipant(String participantID, int roomNumber){
        if(room.addParticipantToBreakoutRoom(participantID, roomNumber)){
            return true; //successful
        }
        else{
            return false; //unsuccessful
        }
    }
    
    public String listParticipants(int roomNumber){
        return room.listParticipantsInBreakoutRoom(roomNumber);
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        return room.openBreakoutRoom(roomNumber);
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        return room.closeBreakoutRoom(roomNumber);
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        return room.findParticipantBreakoutRoom(participantID);
    }
    
    public String listAllBreakoutRooms(){
        return room.listBreakoutRooms();
    }
    
    public String listParticipantsInAllBreakoutRooms(){
        String list = "";
        for(int i=1; i<=room.getNumberOfBreakoutRooms(); i++){
            list += room.listParticipantsInBreakoutRoom(i);
            list += "\n";
        }
        return list;
    }
}
