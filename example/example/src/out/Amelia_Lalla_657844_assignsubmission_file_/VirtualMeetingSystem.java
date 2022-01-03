package out.Amelia_Lalla_657844_assignsubmission_file_;import java.io.*;
import java.util.*;
/**
 * Write a description of class VirtualMeetingSystem here.
 *
 * @author Amelia Lalla 816021543
 * @version (a version number or a date)
 */
public class VirtualMeetingSystem
{
    VirtualRoom vroom;
    int pIndex = 0;
    String participantsArr[] = new String[1000];
    
    public void loadParticipantData(String filename){
        try{
            File text = new File(filename);
            Scanner sc = new Scanner(text);
            while(sc.hasNextLine()){
                String data = sc.next();
                participantsArr[pIndex] = data;
                pIndex++;
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File "+ filename+ " not found");
            e.printStackTrace();
        }
    }
    
    public void createVirtualRoom(String name){
        vroom = new VirtualRoom(name, 5);
        vroom.createBreakoutRooms();
    }
    
    public void allocateParticipants(String code){
        String codeUpper = code.toUpperCase();
        int i=1;
        int cluster = 0;
        boolean added = false;
  
        if (codeUpper == "C5"){
            for (int j=0; j<pIndex; j++){
                added = addParticipant(participantsArr[j], i);
                if (added == true){
                    cluster++;
                    if (cluster % 10 == 0){
                        i++;
                    }
                }  
                
                if (cluster == 50){
                    break;
                }
            }
        }
        
        else if (codeUpper == "RR"){
            for (int j=0; j<pIndex; j++){
                added = addParticipant(participantsArr[j], i);
                if (added == true){
                    cluster++;
                    if (i == 5){
                        i = 1;
                    }
                    else{
                        i++;
                    }
                }
                
                if (cluster == 50){
                    break;
                }
            }
        }
        
        else{
            System.out.println("The code entered is not valid");
        }
    }
    
    public boolean addParticipant(String participantID, int roomNumber){
        boolean added = false;
        added = vroom.addParticipantToBreakoutRoom(participantID, roomNumber);
        return added;
    }
    
    public String listParticipants(int roomNumber){
        String details = "";
        details = vroom.listParticipantsInBreakoutRoom(roomNumber);
        if(details == null){
            details += "No Participants in Breakout Room Number: " + roomNumber;
        }
        return details;
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        boolean open = false;
        open = vroom.openBreakoutRoom(roomNumber);
        return open;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        boolean close = false;
        close = vroom.closeBreakoutRoom(roomNumber);
        return close;
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        String ID = null; 
        ID = vroom.findParticipantBreakoutRoom(participantID);
        return ID;
    }
    
    public String listAllBreakoutRooms(){
        String details = "";
        int numOfBreakoutRooms = vroom.getNumberOfBreakoutRooms();
        if (numOfBreakoutRooms != 0){
            details += vroom.listBreakoutRooms();
        }
        return details;
    }
    
    public String listParticipantsInAllBreakoutRooms(){
       String details = "";
       int numOfBreakoutRooms = vroom.getNumberOfBreakoutRooms();
       if (numOfBreakoutRooms != 0){
           for (int i=1; i<=numOfBreakoutRooms; i++){
               details += vroom.listParticipantsInBreakoutRoom(i) + "\n";
               
           }
       }
       return details;
    }
    
}
