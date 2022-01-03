package out.Terrel_Charles_657846_assignsubmission_file_;import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class BreakoutRoom{
    
    //String name needs to be included 
    private String name;
   private String breakoutRoomID;
   private static int breakoutRoomNumberCounter=1;
   private final int breakoutRoomSize;
   private Participant[] participants;
   private int numberOfParticipants;
   boolean open=true;
   
   public int getNumberOfParticipants(){
    return numberOfParticipants;}
    public boolean getOpen(){
    return open;}
    public String getBreakoutRoomID(){
return breakoutRoomID;}
    
   public BreakoutRoom(String name){   
     this.name = name;
     this.participants = new Participant[10];
     breakoutRoomID= name+" " +  breakoutRoomNumberCounter++;
    numberOfParticipants=0;
     breakoutRoomSize=10;
}
    


public boolean addParticipant(String participantID){
  Participant participant = new Participant(participantID);
 
  
  if(!this.open){
        
    return false;}
    
     if(numberOfParticipants>=breakoutRoomSize){
     
        
    return false;}
    
    if(findParticipant(participantID)!=null){
       //this is here to negate duplications
    return false;}
    
    
   if(!Participant.verifyID(participantID)){
       
    return false;
    }
    
    
        
        
    this.participants[this.numberOfParticipants] = participant;
     numberOfParticipants++;
    return true;
    
   
    
    }
   
    
public Participant findParticipant(String participantID){
    
    if(!open){
    return null;
    }
    
    for(int i=0;i<numberOfParticipants;i++){
    
        
        
    if(participants[i].getParticipantID().equals(participantID)){
    
    return participants[i];
    }    
      
    }
    
    return null;
}

public  String listParticipants(){

    String listpart=breakoutRoomID+"\n";
    
 
for(int i=0;i<numberOfParticipants;i++){
listpart+=" "+participants[i].toString()+"\n";

}


return listpart;


}



public String toString(){
String representation;
String integerNumberOfParticipant=Integer.toString(numberOfParticipants);
    if(open){
    representation=breakoutRoomID+" "+"OPEN "+integerNumberOfParticipant;
    }

    else{ 
    representation=breakoutRoomID+" CLOSE "+integerNumberOfParticipant;
    }

return representation;
}

public void closeBreakoutRoom(){ 

    
    
    for(int i=0;i<numberOfParticipants;i++){
    participants[i]=null;
    
    }

numberOfParticipants=0;
this.open=false;

}


public void openBreakoutRoom(){
    
open=true;
}



   
}
