package out.Kevin_Murphy_657729_assignsubmission_file_;/**
 * Kevin Murphy 
 * 816003734
 * 
 */

import java.io.File; 
import java.io.FileNotFoundException;
import java.util.Scanner;


public class VirtualRoom{
   
    
    private String name;
    private int breakoutRoomLimit;
    private BreakoutRoom[] breakoutRooms;
    
    
   public VirtualRoom(String name){
        this.name = name;
        this.breakoutRoomLimit = 5;
        this.breakoutRooms = new BreakoutRoom[5];
        
   }//end function
    
    
   public VirtualRoom(String name, int limit){
        this.name = name;
        this.breakoutRoomLimit = limit;
        this.breakoutRooms = new BreakoutRoom[10];
   }//end function

   
   public int getNumberOfBreakoutRooms(){
        return breakoutRooms.length;
   }//end function
    
   
   public void createBreakoutRooms(){

        for(int i=0; i<breakoutRoomLimit; i=i+1){   //while under limit 
             breakoutRooms[i] = new BreakoutRoom(name);  //allocate new room
         }//end for
   }//end function
    
   public String getName(){
        return name;
   }//end function
   
   public BreakoutRoom findBreakoutRoom(int roomNumber){
    String roomNum = getName() + Integer.toString(roomNumber);
   
     for(int i=0; i<getNumberOfBreakoutRooms(); i=i+1){
       
        if(breakoutRooms[i].getbreakoutRoomID().equals(roomNum)){
        return breakoutRooms[i];
        }
    }
    
    return null;
   }//end function
    
    
   public boolean closeBreakoutRoom(int roomNumber){
   String roomNum = getName() + Integer.toString(roomNumber);  
    
       for(int j=0; j<getNumberOfBreakoutRooms(); j=j+1){
           
        if(breakoutRooms[j].getbreakoutRoomID() == (roomNum)){
            
            breakoutRooms[j].closeBreakoutRoom();
        
            return true;
        }//end if
       }//end for
    
   return false; 
   }//end function
    
   
   public boolean openBreakoutRoom(int roomNumber){
   String roomNum = getName() + Integer.toString(roomNumber);   
   // System.out.println("Test "+ roomNum);
       for(int k=0; k<getNumberOfBreakoutRooms(); k=k+1){
           
        if(breakoutRooms[k].getbreakoutRoomID().equals(roomNum)){
            
            breakoutRooms[k].openBreakoutRoom();
            
            return true;
        }
       }
    
   return false; 
   }//end function
    
    
   public String listBreakoutRooms(){
       String list= name;
       
        for(int l=0; l<getNumberOfBreakoutRooms(); l=l+1){
            
           list += breakoutRooms[l];
        }
        
        return list;
   }//end function
    
       
   public String listParticipantsInBreakoutRoom(int roomNumber){
     String roomNum = getName() + Integer.toString(roomNumber); 
     
      for(int m=0; m<getNumberOfBreakoutRooms(); m=m+1){
          
       if(breakoutRooms[m].getbreakoutRoomID()==(roomNum)){  
           
           String list = (breakoutRooms[m].listParticipants());
           
           return list;    
       }
      }
       return null;
   }//end function
     
    
   public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
     String roomNum = getName() + Integer.toString(roomNumber);  
     //while()
      for(int n=0; n<getNumberOfBreakoutRooms(); n=n+1){ 
          
       if(breakoutRooms[n].getbreakoutRoomID().equals(roomNum)){
           
           breakoutRooms[n].addParticipant(participantID);
  
           return true;
       }//end if
     }//end for
        return false;
   }//end function
    
   
   public String findParticipantBreakoutRoom(String participantID){
        String participantLoc = "";
        
        for(int o=0; o<getNumberOfBreakoutRooms(); o=o+1){
            
            if(breakoutRooms[o].findParticipant(participantID) != null){
             participantLoc = breakoutRooms[o].getbreakoutRoomID();
            return participantLoc;
            }
            
        }
      return null;
   }//end function
     
}
    
