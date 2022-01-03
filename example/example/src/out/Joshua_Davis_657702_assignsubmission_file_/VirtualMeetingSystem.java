package out.Joshua_Davis_657702_assignsubmission_file_;/*
    Student ID: 816022176
*/

import java.io.File;
// import java.nio.file.Files;
import java.util.Scanner;
import java.io.IOException;

public class VirtualMeetingSystem {
    private final static int MAX_PARTICIPANTS = 50;
    private VirtualRoom virtualRoom;

    private String[] participants;
    private int numberOfParticipants;

    public VirtualMeetingSystem(){
        virtualRoom = null;
        
        participants = new String[MAX_PARTICIPANTS];
        numberOfParticipants = 0;
    }
    public void loadParticipantData(String filename){
        try{
            numberOfParticipants = 0;

            File file = new File(filename);
            
            Scanner scanner  = new Scanner(file);


            while(scanner.hasNextLine()){
                if (numberOfParticipants >= MAX_PARTICIPANTS){
                    System.out.println("Warning: maximum of " + MAX_PARTICIPANTS + " participants have been loaded. All following would be ignored.");
                    break;
                }
                String participantID = scanner.nextLine();
                if (Participant.verifyID(participantID)){
                    boolean found = false;
                    for (int i =0; !found && i < numberOfParticipants; i++){
                        if (participants[i].equals(participantID)){
                            found = true;
                        }
                    }
                    if (found){
                        System.out.println("Skipping duplicate participant ID: '"+participantID + "'");
                    }else{
                        participants[numberOfParticipants++] = participantID;
                    }
                }else{
                    System.out.println("Skipping invalid participant id: '" + participantID + "'.");
                }
            }
            scanner.close();
            // participants = Files.readAllLines(file.toPath()).toArray(new String[0]); 

            // participants = new String[numParticipants];
            // for (int i =0; i < numParticipants; i++){
            //     participants[i] = loadedParticipants[i];
            // }
        }catch(IOException e){
            System.err.println(e);
        }
    }
    


    public void createVirtualRoom(String name){
        virtualRoom = new VirtualRoom(name, 5);
        virtualRoom.createBreakoutRooms();
    }
    // public void createVirtualRoom(String name, int limit){
    //     virtualRoom = new VirtualRoom(name, limit);
    //     virtualRoom.createBreakoutRooms();
    // }
    
    public boolean virtualRoomCreated(){
        return virtualRoom != null;
    }


    public void allocateParticipants(String code){
        if (!virtualRoomCreated()){
            System.out.println("Warning, virtual room has not been created. It will be auto generated");
            createVirtualRoom("Meeting");
        }
        // if (!virtualRoom.breakoutRoomsCreated()){
        //     System.out.println("Warning, breakout rooms have not been created. It will be auto generated");
        //     virtualRoom.createBreakoutRooms();
        // }

        int[] roomNumbers = listAllBreakoutRoomNumbersArray();
        int roomNumberIndex = 0;

        for (int i =0 ; i < roomNumbers.length; i ++){//cleaning breakoutrooms
            closeBreakoutRoom(roomNumbers[i]);
        }

        if (code.equals("C5")){
            for (int i =0; i < numberOfParticipants; ){
                //openroom 
                openBreakoutRoom(roomNumbers[roomNumberIndex]);
                //add next five participants to room
                for ( int j =0; j < 5 && i < numberOfParticipants; j++){
                    addParticipant(participants[i], roomNumbers[roomNumberIndex]);
                    i++;    
                }
                roomNumberIndex++;
                //wraparound if necessary
                if (roomNumberIndex >= roomNumbers.length){
                    roomNumberIndex = 0;
                }
            }
        }else if (code.equals("RR")){

            for (int i =0; i < numberOfParticipants; i++){
                //openroom 
                openBreakoutRoom(roomNumbers[roomNumberIndex]);
                //add one participant to room
                addParticipant(participants[i], roomNumbers[roomNumberIndex]);
                
                roomNumberIndex++;
                //wraparound if necessary
                if (roomNumberIndex >= roomNumbers.length){
                    roomNumberIndex = 0;
                }
            }
        }else{
            System.err.println("Invalid code entered: " + code);
        }
    }
    public boolean addParticipant(String participantID, int roomNumber){
        return virtualRoom.addParticipantToBreakoutRoom(participantID, roomNumber);
    }
    public String listParticipants(int roomNumber){
        return virtualRoom.listParticipantsInBreakoutRoom(roomNumber);
    }
    public String[] listParticipantsArray(int roomNumber){
        return virtualRoom.listParticipantsInBreakoutRoomArray(roomNumber);
    }
    public boolean openBreakoutRoom(int roomNumber){
        return virtualRoom.openBreakoutRoom(roomNumber);
    }
    public boolean closeBreakoutRoom(int roomNumber){
        return virtualRoom.closeBreakoutRoom(roomNumber);
    }
    public String findParticipantBreakoutRoom(String participantID){
        return virtualRoom.findParticipantBreakoutRoom(participantID);
    }
    public String listAllBreakoutRooms(){
        return virtualRoom.listBreakoutRooms();
    }
    public int[] listAllBreakoutRoomNumbersArray(){
        return virtualRoom.listBreakoutRoomNumbersArray();
    }
    public String listParticipantsInAllBreakoutRooms(){
        String results = "";
        int[] roomNumbers = listAllBreakoutRoomNumbersArray();
        for (int i =0; i < virtualRoom.getNumberOfBreakoutRooms(); i++){
            results += virtualRoom.listParticipantsInBreakoutRoom(roomNumbers[i]) + "\n";
        }
        if (results.length() == 0) return null;
        return results.substring(0, results.length() - 1);
    }
}
