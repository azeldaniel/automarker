package out.Makaela_Wallace_657818_assignsubmission_file_;/*
 * Name: Makaela Wallace
 * ID: 816018659
*/

import java.util.*; 
import java.io.*;

public class VirtualRoom{
    
    private String name = "";
    private final int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;
    
    
    public VirtualRoom (String name){
        this.name = name;
        this.breakoutRoomLimit = 5;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    } 
    
    public VirtualRoom (String name, int limit){
        this.name = name;
        this.breakoutRoomLimit = limit;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    } 
    
    public int getNumberOfBreakoutRooms(){
        return breakoutRooms.length;
    } 
    
    public void createBreakoutRooms (){
        for (int i = 0; i< breakoutRoomLimit; i++){
            breakoutRooms[i] = new BreakoutRoom(name);
        }
    }
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        BreakoutRoom b = null ;
        String s;
        boolean check;
        
        for (int i = 0; i< breakoutRoomLimit; i++){
            s = Integer.toString(roomNumber);
            check = breakoutRooms[i].getBreakoutRoomID().contains(s);
             if (check == true){
                 b = breakoutRooms[i];
             }
        }
        
        return b;
    } 
    
    public boolean closeBreakoutRoom(int roomNumber){
        BreakoutRoom b =null;
        boolean flag = false;
        
        b = findBreakoutRoom (roomNumber);
        
        if (b==null){
            return flag;
        }
        
        if (b.getOpen()==true){
            b.closeBreakoutRoom();
            flag = true;
        }
        
        return flag;
    } 
    
    public boolean openBreakoutRoom(int roomNumber){
        BreakoutRoom b= null;
        boolean flag = false;
        b = findBreakoutRoom (roomNumber);
        
        if (b==null){
            return flag;
        }
        
        if (b.getOpen()==false){
            b.openBreakoutRoom();
            flag = true;
        }
        
        return flag;
    }
    
    public String listBreakoutRooms(){
        
        String details = name +"\n";
        String info = "";
        
        for (int i = 0; i< breakoutRoomLimit; i++){
            info = info +i+1;
            
            details = details + "BreakoutRoom: "+ breakoutRooms[i].toString() + "\n";
            
            info = null;
        }
        
        
        return details;
    } 
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
        
        String details = null;
        BreakoutRoom b = null;
        
        b = findBreakoutRoom(roomNumber);
        
        if (b==null){
            return details;
        }
        
        details = b.listParticipants();
        
        return details;
    }
    
    public boolean addParticipantToBreakoutRoom (String participantID, int roomNumber) {
        BreakoutRoom b = null;
        b= findBreakoutRoom(roomNumber);
        boolean notFull;
        
        if (b==null){
            return false;
        }
        
        notFull = b.addParticipant (participantID);
        
        if (notFull==false){
            return false;
        }
        
        return true;
        
    }
    
    public String findParticipantBreakoutRoom (String participantID){
        
        boolean found = false;
        
        String breakoutRoomID = null;
        
        for (int i=0; i<breakoutRoomLimit; i++){
            
            found = breakoutRooms[i].getParticipant (participantID);
            if (found == true){
                breakoutRoomID= breakoutRooms[i].getBreakoutRoomID();
            }
        }
        
        return breakoutRoomID;
        
    }
    
}
