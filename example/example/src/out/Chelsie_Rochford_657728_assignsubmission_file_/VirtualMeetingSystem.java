package out.Chelsie_Rochford_657728_assignsubmission_file_;/**
 *816000366
 */
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException; 


public class VirtualMeetingSystem
{
    // instance variables - replace the example below with your own
    private String[] participants = new String[50];
    private int numParticipants=0;
    private String name;
    private VirtualRoom vr;
    
  
    public void loadParticipantData(String filename){
        try{
            File participantList = new File(filename);
            Scanner fin = new Scanner(participantList); 
            
            while (fin.hasNextLine()){
                participants[numParticipants] = fin.nextLine();
                numParticipants ++;
            }
            System.out.println("File read. Number of participants: " + numParticipants);
            fin.close();
        } catch (FileNotFoundException f) {
            System.out.println("An error has occurred. File not read");
            f.printStackTrace();   
        }
    }
   
    
    public void createVirtualRoom(String name){
         vr = new VirtualRoom(name);
         vr.createBreakoutRooms();
    }
    
    public void allocateParticipants(String code){
        int i=0; //participants
        if (code.equals("C5")){ //cluster of 5
            int j=1, k=1, count=0;
            for(i=0; i<numParticipants; i++){
                if (j>5) j=1;
                addParticipant(participants[i],j);
                count++; //no of participants
                if(count%5==0) j++;
            }
        }
        if (code.equals("RR")){ //round robin
            while(i<numParticipants){
                for (int j=1; j<=5; j++){
                   addParticipant(participants[i],j);
                   i++;
                }
            }
        }
            
    }
    
    public boolean addParticipant(String participantID, int roomNumber){
        if (vr.addParticipantToBreakoutRoom(participantID, roomNumber))
            return true;
        return false;
    }
    
    public String listParticipants(int roomNumber){
        if (!vr.findBreakoutRoom(roomNumber).equals(null)){
            return roomNumber + vr.listParticipantsInBreakoutRoom(roomNumber);
          
        }
        return null;
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        if(!vr.findBreakoutRoom(roomNumber).equals(null)){
            vr.openBreakoutRoom(roomNumber);
            return true;
        }
        return false;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        if(!vr.findBreakoutRoom(roomNumber).equals(null)){
            if(vr.openBreakoutRoom(roomNumber)){
                if(vr.closeBreakoutRoom(roomNumber)){
                    return true;
                }
            }
            return true;
        }
        return false;
    }
    
       
    
    public String findParticipantBreakoutRoom(String participantID){
      
         return vr.findParticipantBreakoutRoom(participantID);
   
    }
    
    public String listAllBreakoutRooms(){
        
        return vr.listBreakoutRooms();
        
    }
    
    
    public String listParticipantsInAllBreakoutRooms(){
       String list = "";
        for (int i=1; i<=5; i++){
            list += vr.listParticipantsInBreakoutRoom(i);
        }
        return list;
        
    }

}

// Source for code on reading files: https://www.geeksforgeeks.org/file-handling-java-using-filewriter-filereader/