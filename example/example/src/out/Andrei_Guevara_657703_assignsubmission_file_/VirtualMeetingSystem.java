package out.Andrei_Guevara_657703_assignsubmission_file_;/**816022711
 * Andrei Guevara
 * OwO - O3O
**/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 
import java.nio.file.*;

public class VirtualMeetingSystem{
    
    private String[] ids;
    private VirtualRoom vr;
    private int numOfIds;
    
    
    private int getLinesInFile(String filename){
        
        long amt = 100;
        
        try{
            
            Path file = Paths.get(filename);
            amt = Files.lines(file).count();
            
        }
        
        catch(Exception e){
            
            e.getStackTrace();
            
        }
        
        return (int) amt;
        
    }
    
    public void loadParticipantData(String filename){

        try{
            
            numOfIds = getLinesInFile(filename);
            ids = new String[this.numOfIds];
            
            File newfile = new File(filename);
            Scanner read = new Scanner(newfile);
            
            int count = 0;
            
            while (read.hasNextLine()){
                
                ids[count] = read.nextLine();
                count++;
                
            }
            
        }
        
        catch (FileNotFoundException e){
            
            System.out.println("File not found.");
            e.printStackTrace();
            
        }
    
    }
    

    public void createVirtualRoom(String name){
        
        vr = new VirtualRoom(name);
        vr.createBreakoutRooms();
        
    }
    
    
    public void allocateParticipants(String code){
    
        int counter = 0;
        int breakoutRoomCounter = 0;
        int num = 0;
        
        if (code.equals("C5")){
            
            while (num < numOfIds){
            
                while (counter < 5){
                    if (breakoutRoomCounter < vr.getBreakoutRoomLimit()){
                        if (vr.getBreakoutRooms()[breakoutRoomCounter] != null && vr.getBreakoutRooms()[breakoutRoomCounter].getNumberOfParticipants() < vr.getBreakoutRooms()[breakoutRoomCounter].getBreakoutRoomSize() && addParticipant(ids[num],breakoutRoomCounter+1)){
                               
                           num++;
                           counter++;
                           
                        }
                        
                        else if(vr.getBreakoutRooms()[breakoutRoomCounter].getNumberOfParticipants() >= vr.getBreakoutRooms()[breakoutRoomCounter].getBreakoutRoomSize()){
                            
                            breakoutRoomCounter++;
                            
                        }
                        
                        else if(!vr.getBreakoutRooms()[breakoutRoomCounter].getParticipants()[0].verifyID(ids[num])){
                            
                            num++;
                            
                        }
                    }
                        
                    if (breakoutRoomCounter >= vr.getBreakoutRoomLimit()){
                        
                        breakoutRoomCounter = 0;
                        
                    }

            }
            
            breakoutRoomCounter++;
            counter = 0;
            
                if (breakoutRoomCounter > vr.getBreakoutRoomLimit())
                
                    breakoutRoomCounter = 0;
                
            }
            
        }

        else if (code.equals("RR")){
           
           while (counter < numOfIds){

             //System.out.println("Meow " + num);
                while (breakoutRoomCounter < vr.getBreakoutRoomLimit()){
                    if (addParticipant(ids[num], breakoutRoomCounter+1)){
                         
                        breakoutRoomCounter++;
                        
                    }
                    
                    num++; 
                    counter++; 
                    
                }
                
                breakoutRoomCounter = 0;
                
            }
            
        }
       
    }
    
    
    public boolean addParticipant(String participantID, int roomNumber){
        
        if (roomNumber > 0 && roomNumber <= vr.getBreakoutRoomLimit()){
        
            if (vr.getBreakoutRooms()[roomNumber-1].addParticipant(participantID)){
                
                return true;
                
            }
        
        }
        
        return false;
        
    }
    
    
    public String listParticipants(int roomNumber){
        
        String list = null;
        
        if (vr.findBreakoutRoom(roomNumber) != null)
        
            list = vr.listParticipantsInBreakoutRoom(roomNumber);
            
        return list;
    }
    
    
    public boolean openBreakoutRoom(int roomNumber){
           
        if (roomNumber > 0 && roomNumber <= vr.getBreakoutRoomLimit() && !vr.getBreakoutRooms()[roomNumber-1].getOpen()){
        
            if (vr.openBreakoutRoom(roomNumber-1));
            
                return true;
            
        }
         
        return false;
        
    }
    
    
    public boolean closeBreakoutRoom(int roomNumber){

        if (roomNumber > 0 && roomNumber <= vr.getBreakoutRoomLimit() && vr.getBreakoutRooms()[roomNumber-1].getOpen()){
        
            if (vr.closeBreakoutRoom(roomNumber-1));
                
                return true;
            
        }

        return false;

    }
    
    
    public String findParticipantBreakoutRoom(String participantID){
        
        for (int counter = 0; counter < vr.getBreakoutRoomLimit(); counter++){
            
            if (vr.getBreakoutRooms()[counter].findParticipant(participantID) != null)
            
                return vr.getBreakoutRooms()[counter].getBreakoutRoomID();

        }
        
        return null;
        
    }
    
    
    public String listAllBreakoutRooms(){
     
        String list = "";
        
        for (int counter = 0; counter < vr.getBreakoutRoomLimit(); counter++){
            
            list += vr.getBreakoutRooms()[counter].getBreakoutRoomID();
            
            if (counter + 1 < vr.getBreakoutRoomLimit())
            
                list +="\n";
            
        }
        
        return list;
        
    }
    
    
    public String listParticipantsInAllBreakoutRooms(){
        
        String list = "";
        
        if (vr.getBreakoutRoomLimit() == 0)
        
            return null;
        
        for (int breakoutRoomCounter = 0; breakoutRoomCounter < vr.getBreakoutRoomLimit(); breakoutRoomCounter++){
            
           list += vr.getBreakoutRooms()[breakoutRoomCounter].getBreakoutRoomID() + ":\n";
            
           for (int participantCounter = 0; participantCounter < vr.getBreakoutRooms()[breakoutRoomCounter].getNumberOfParticipants(); participantCounter++){
               
               list += vr.getBreakoutRooms()[breakoutRoomCounter].getParticipants()[participantCounter].getParticipantID();
               
               if (participantCounter+1 < vr.getBreakoutRooms()[breakoutRoomCounter].getNumberOfParticipants())
                    
                    list += "\n";
                    
           }
           
           if (breakoutRoomCounter+1 < vr.getBreakoutRoomLimit())
           
                list += "\n\n";
            
        }
        
        return list;
        
    }
    
    public VirtualRoom getVirtualRoom(){
        
        return this.vr;
        
    }

}