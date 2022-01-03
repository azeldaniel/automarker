package out.Brandon_James_657851_assignsubmission_file_;/**
 * NOT Working:
 * findParticipantBreakoutroom keeps running indefinitely when string passed in runner class. 
 * 
 * Everything else works as expected. 
 * Code handles both C5 and RR allocation strategies.
 * 
 * @815006970 (ID)
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class VirtualMeetingSystem
{
    // instance variables
    private VirtualRoom room;
    private String[] participantData = new String[50];
    private int numParticipants;
    private String name = "";

    /**
     * Constructor for objects of class VirtualMeetingSystem
     */
    public VirtualMeetingSystem()
    {
        // initialise instance variables
        room = null;
        numParticipants = 0;
    }

    public void loadParticipantData(String filename){
        try {
            File dataFile = new File(filename);
            Scanner scnr = new Scanner(dataFile);
            int lineNum = 0;
            while (scnr.hasNextLine()) {
                String line = scnr.nextLine();
                participantData[lineNum] = line;
                lineNum++;
            }
            numParticipants = lineNum; 
            scnr.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred. File not found.");
            e.printStackTrace();
        }
    }
    
    public void createVirtualRoom(String name){
        room = new VirtualRoom(name);
        this.name = name;
    }
    
    public void allocateParticipants(String code){
        int numOfRooms = room.getNumberOfBreakoutRooms();
        int i = 0; //brRoom counter
        int j = 0;
        if(code=="C5"){
            for(int count=0; count<numOfRooms; count++){ // for every BreakoutRoom
                while(i<numParticipants && j<5){
                        if(i<numParticipants){
                            addParticipant(participantData[i], count); 
                            i++;
                            j++;
                        }  
                }
                j=0;
            }
            
        }else if(code=="RR"){
            while(i<numParticipants){
                for(int count=0; count<numOfRooms; count++){ // for every BreakoutRoom
                    addParticipant(participantData[i], count); //add 1 participant
                    i++;
                }
            }
        }else {
            System.out.println("Wrong code entered.");
        }
    }
    
    public boolean addParticipant(String participantID, int roomNumber){
         return room.addParticipantToBreakoutRoom(participantID, roomNumber);
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
        String found = "";
        found = room.findParticipantBreakoutRoom(participantID);
        return found;
    }
    
    public String listAllBreakoutRooms(){
        return room.listBreakoutRooms();
    }
    
    public String listParticipantsInAllBreakoutRooms(){
        String list = "";
        int numOfRooms = room.getNumberOfBreakoutRooms();
        for(int i=0; i<numOfRooms; i++){
            list += room.listParticipantsInBreakoutRoom(i);
        }
        return list;
    }
}
/* Sources
 * https://www.w3schools.com/java/java_files_read.asp
 */