package out.Aleksi_Olivier_657749_assignsubmission_file_;import java.io.*;
import java.util.*;
/**
 * Write a description of class VirtualMeetingSystem here.
 * All classes originally written in VS code
 * @author (ALEKSI OLIVIER 816023287)
 * @version (a version number or a date)
 */
import java.io.*;
import java.util.*;

public class VirtualMeetingSystem{
    VirtualRoom v1;
    String[] data = new String[50];
    int numParticipants;

    public void loadParticipantData(String filename){
        int i = 0;
        try{
            File in = new File(filename);
            Scanner scan = new Scanner(in);
            while (scan.hasNextLine()){
                data[i] = scan.nextLine(); 
                //System.out.println(data[i]);
                i++;
            }
            scan.close();
            numParticipants = i;
        } catch (FileNotFoundException e) {
            System.out.println("An Error Occured");
            e.printStackTrace();
        }
        System.out.println("Number of Participants loaded: " +numParticipants);
    }
    
    public void createVirtualRoom(String name){
        v1 = new VirtualRoom(name);
        v1.createBreakoutRooms();
    }

    public void allocateParticipants(String code){ //this working for now
        int room = 1; //keeps track of the room index
        int count = 0;
        int temp = 0;
        boolean flag1 = false;
        if(code.equalsIgnoreCase("c5")){
            while(!flag1){
                v1.addParticipantToBreakoutRoom(data[count], room);
                    count++;
                if(count % 5 == 0){
                    room++;
                }
                if(room == 6){
                    temp++;
                    if(temp == 2){
                        flag1 = true;
                    }
                    room = 1;
                }
            }
        }else{
            System.out.println("Failed to allocate");
        }
    }


    public boolean addParticipant(String participantID, int roomNumber){
        if(v1.addParticipantToBreakoutRoom(participantID, roomNumber)){
            System.out.println("Added participant sucessfully");
            return true;
        }
        System.out.println("Failed to add participant");
        return false;
    }

    public String listParticipants(int roomNumber){ 
        if(v1.findBreakoutRoom(roomNumber) != null){
            return v1.listParticipantsInBreakoutRoom(roomNumber);
        }
        return null;
    }

    public boolean openBreakoutRoom(int roomNumber){
        if(v1.findBreakoutRoom(roomNumber) != null){
            v1.findBreakoutRoom(roomNumber).openBreakoutRoom();
            return true;
        }
        return false;
    }

    public boolean closeBreakoutRoom(int roomNumber){
        if(v1.findBreakoutRoom(roomNumber)!= null){
            v1.findBreakoutRoom(roomNumber).closeBreakoutRoom();
            return true;
        }
        return false;
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        if(v1.findParticipantBreakoutRoom(participantID) == null){
            return null;
        }else{
            return "Participant is in: " +v1.findParticipantBreakoutRoom(participantID);
        }
    }

    public String listAllBreakoutRooms(){
        return v1.listBreakoutRooms();
    }

    public String listParticipantsInAllBreakoutRooms(){
        String details = "";
        for(int i = 1; i<6; i++){
            if(v1.listParticipantsInBreakoutRoom(i) == null){
                return null;
            }else{
                details += v1.listParticipantsInBreakoutRoom(i);
            }
        } 
        return details;
    }

}