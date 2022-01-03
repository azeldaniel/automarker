package out.Hansel_Charles_657854_assignsubmission_file_;import java.io.File;
import java.io.FileNotFoundException; 
import java.util.Scanner; 
import java.util.ArrayList;
import java.util.Arrays;

/*
 * HANSEL CHARLES
 * ID: 816011166
 */
public class VirtualMeetingSystem
{ 
    private VirtualRoom virtualRooms;
    private String [] data;
    
    public VirtualMeetingSystem(){
        data = new String [50];
    }
    
    public void loadParticipantData(String filename ){
        ArrayList<String> lines = new ArrayList<String>();
        
        try {
            File read = new File(filename);
            Scanner myReader = new Scanner(read);
            
            while (myReader.hasNextLine()) {
                lines.add(myReader.nextLine());  
            }
            myReader.close();
            
            data = lines.toArray(new String[]{});
            /*
            for(int i=0; i < data.length; i++){
                System.out.println(data[i]);
            }
            */
        }catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
    }
    
    public void createVirtualRoom(String name){
        virtualRooms = new VirtualRoom(name);
            
        virtualRooms.createBreakoutRooms();
    }
    
    public void allocateParticipants(String code){
        if(code == null){
            System.out.println("Invalid Code");
        }
        else if(code=="C5"){
            int j =0;
            
            for(int i = 0; i < data.length; i++){
                if((i!=0) && (i % 5 == 0)){
                    j++;
                    if(j == 5){
                        j=0;
                    }
                }
                
                virtualRooms.addParticipantToBreakoutRoom(data[i],j);
            }
            
        }
        
    }
    
    public boolean addParticipant (String participantID, int roomNumber){
        boolean add = false;
        
        add = virtualRooms.addParticipantToBreakoutRoom(participantID,roomNumber);
            
        return add;
    }
    
    public String listParticipants(int roomNumber){
        String details ="";
        
        details += virtualRooms.listParticipantsInBreakoutRoom(roomNumber);
        
        return details;
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        boolean isOpen = false;
        
        isOpen = virtualRooms.openBreakoutRoom(roomNumber);
        
        return isOpen;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        boolean isClose = false;
        
        isClose = virtualRooms.closeBreakoutRoom(roomNumber);
        
        return isClose;
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        String found = "";
        
        found += virtualRooms.findParticipantBreakoutRoom(participantID);
        
        return found;
    }
    
    public String listAllBreakoutRooms(){
        String details ="";
        
        details += virtualRooms.listBreakoutRooms();
        
        return details;
    }
    
    public String listParticipantsInAllBreakoutRooms(){
        String details ="";
        
        for(int i=0; i < virtualRooms.getNumberOfBreakoutRooms(); i++){
            details += virtualRooms.listParticipantsInBreakoutRoom(i);
            details +="\n \n";
        }
        return details;
    }
    
}
