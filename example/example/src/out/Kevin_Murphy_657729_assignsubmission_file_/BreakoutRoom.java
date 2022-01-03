package out.Kevin_Murphy_657729_assignsubmission_file_;/**
 * Kevin Murphy 
 * 816003734
 * 
 */

import java.io.File; 
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BreakoutRoom{
     private String breakoutRoomID;
     private static int breakoutRoomNumCount = 0;
     private int breakoutRoomSize;
     private int numParticipants;
     private boolean open = false; //initialize 
     private Participant[] participants;
        
    
   
    public BreakoutRoom(String name){
     
     this.breakoutRoomSize = 0;
     this.numParticipants = 0; 
     
     this.participants = new Participant[10];
     this.breakoutRoomID = name + Integer.toString(breakoutRoomNumCount); 
     
     this.open = true;
     breakoutRoomNumCount++; 
    }//end function

    
    public boolean addParticipant(String participantID){
    Participant temp = new Participant(participantID);
     
     for(int i = 0; i < breakoutRoomSize; i=i+1){
         
         if((temp.verifyID(participantID) == true) && (open == true)){
              participants[numParticipants] = new Participant(participantID);
              //participants[i].setID(participantID); //false
              this.numParticipants = this.numParticipants+1; //update participants
             
              return true;
         }//end if
      }//end for
      return false;
    }//end function
    
    
    public Participant findParticipant(String participantID){
        Participant locID = new Participant(participantID);
   
        if(locID.verifyID(participantID) == true){  //once ID is present do
            for(int j = 0; j < numParticipants; j=j+1){  //go through all participants
             if(participants[j].getParticipantID() == locID.getParticipantID()){ //if ID is found return location 
                return locID;
             }//end 2nd if
           }//endfor
         } //end if
    return null;
     }//end function


    public String listParticipants(){

        String listAllParticipants = getbreakoutRoomID();

        for(int k=0; k< numParticipants; k=k+1){
            
            listAllParticipants += (participants[k].getParticipantID()); //populate with participant IDs
        }

        return listAllParticipants;
    }//end function

    
    
    public String toString(){
    if(open == true){
         return getbreakoutRoomID() +"Open"+ Integer.toString(numParticipants);
    }else{
        return getbreakoutRoomID() +"Closed"+ Integer.toString(numParticipants);
     }//end else
    }//end function
    
    
   
    public String getbreakoutRoomID(){
         return breakoutRoomID;
    }//end function
    
    
    public String numParticipants(){
         return Integer.toString(numParticipants);
    }//end function
    
    
    public int breakoutRoomNumCount(){
        return breakoutRoomNumCount;
    }//end function

    
    public void openBreakoutRoom(){
        this.open = true;
    }//end function
    
    
    public void closeBreakoutRoom(){
       for(int l=0; l<numParticipants; l=l+1){
           
             participants[l].setID("");
       }
       
       this.numParticipants = 0; //close and empty room
       this.breakoutRoomNumCount = 0;  
    }//end function
    
}


