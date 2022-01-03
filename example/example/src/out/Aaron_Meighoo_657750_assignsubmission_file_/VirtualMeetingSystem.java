package out.Aaron_Meighoo_657750_assignsubmission_file_;//Aaron Meighoo
//816000303
//A1
//VirtualMeetingSystem Class

import java.io.*;
import java.util.*;
import java.util.Arrays;

public class VirtualMeetingSystem{
    
    private VirtualRoom virtualRoom;
    private int totalNumberOfParticipants = 0;
    private Scanner readFromFile;
    private String participantIDArray[];
    
    
    public void loadParticipantData(String filename){
        
        //int participantArray[];
        int counter = 0;
        
        participantIDArray = new String[50];
        
        
        try{
            readFromFile = new Scanner(new File(filename));
            
        }
        catch(Exception e){
            System.out.println("Could not find file");
        }
        while(readFromFile.hasNext()){
            String value = readFromFile.next();
            participantIDArray[counter] = value;
            counter++;
            totalNumberOfParticipants++;
            
            System.out.println("Participant ID: " + value);
        }
        
    
    }
   
    public String[] getParticipantIDArray(){
        return participantIDArray;
    }
    
    public int getTotalNumberOfParticipants(){
        return totalNumberOfParticipants;
    }
    
    
    public void closeFile(){
        readFromFile.close();
    }
    
    public void createVirtualRoom(String name){
        //int limit = 5;
        virtualRoom = new VirtualRoom(name,5);
        virtualRoom.createBreakoutRooms();
    }
    
    public void allocateParticipants(String code){
        boolean addPartic = false;
        int partCounter = 0;
        int index=0;
        int numOfBreakoutRooms = virtualRoom.getNumberOfBreakoutRooms();
        if(code.toUpperCase().equals("C5")){
            while((partCounter % 5 != 0) && partCounter != 0){
                virtualRoom.getBreakoutRooms()[index].addParticipant(participantIDArray[partCounter]);
                partCounter++;
                if(partCounter % 5 == 0)
                index++;
            }

        }
        else if(code.toUpperCase().equals("RR")){
                for(index = 0; index < getTotalNumberOfParticipants(); index++){
                    for(int j = 0; j < numOfBreakoutRooms; j++){
                        addPartic = virtualRoom.getBreakoutRooms()[j].addParticipant(participantIDArray[j]);
                        if(!addPartic)
                            j = j +2;
                    }
                }
                if(index==numOfBreakoutRooms)
                    index=0;
        }
    }
    
    public boolean addParticipant(String participantID, int roomNumber){ 
        return virtualRoom.addParticipantToBreakoutRoom(participantID, roomNumber);
    }
    
    public String listParticipants(int roomNumber){
        String details = "";
        details = virtualRoom.listParticipantsInBreakoutRoom(roomNumber);
        if(details == null){
            details = "There is no participants in breakoutRoom: " + roomNumber+ " \n" ;
            return details;
        }
        return details;
    
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
        String details= null;
        int numRooms = virtualRoom.getNumberOfBreakoutRooms();
        if(numRooms != 0)
            details += virtualRoom.listBreakoutRooms() + "/n";   
        return details;
    }
    
    public String listParticipantsInAllBreakoutRooms(){
        String details= null;
        int numRooms = virtualRoom.getNumberOfBreakoutRooms();
        if(numRooms != 0){
            for(int i=0; i<numRooms;i++)
                details+=virtualRoom.listParticipantsInBreakoutRoom(i)+ "/n";
        }
        return details;
    }
}
