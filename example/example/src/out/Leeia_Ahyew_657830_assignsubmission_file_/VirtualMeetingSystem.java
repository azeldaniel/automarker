package out.Leeia_Ahyew_657830_assignsubmission_file_;//816016640

import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.BufferedReader;
import java.util.LinkedHashSet;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;


public class VirtualMeetingSystem
{
    
    private String filename;
    private String data[];
    private VirtualRoom vroom;
   
    
    public VirtualMeetingSystem()
    {
        
        this.data = new String[50];
    }


    public void loadParticipantData(String filename)
    {
      BufferedReader reader; 
        
        try {
          int num = 0;

          reader = new BufferedReader(new FileReader(filename));
          String line = reader.readLine();
          while(line!=null){
              data[num] = new String(line);
              line = reader.readLine();
              num++; 
          }
          reader.close();

        }catch(IOException e){
            e.printStackTrace(); 
        }
    }
    
    public void createVirtualRoom(String name){
        vroom = new VirtualRoom(name);
        vroom.createBreakoutRooms();
    }
    
    public void allocateParticipants(String code){
        if(code.equals("C5")){
                    int a=0;
           int count=0;
           for(count=0; count<50; count++){  
            if((count%5 == 0) && (count != 0) ){
             a++;    
            }
            if(a==5){
                a=0;
            }
            vroom.addParticipantToBreakoutRoom(data[count],a);
           }  
        }
        else
        System.out.println("Code is not valid.");
    }
    
    public boolean addParticipant(String participantID, int roomNumber){
        return this.vroom.addParticipantToBreakoutRoom(participantID,roomNumber);
    }
    
    public String listParticipants(int roomNumber){
        String participantlist = new String();
        participantlist = this.vroom.listParticipantsInBreakoutRoom(roomNumber); 
        return participantlist; 
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        return this.vroom.openBreakoutRoom(roomNumber);
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        return this.vroom.closeBreakoutRoom(roomNumber);  
    }
    
    public String findParticipantBreakoutRoom(String ParticipantID){
       String room = "";
       room = this.vroom.findParticipantBreakoutRoom(ParticipantID); 
       if(room == null){
          room = ParticipantID + " was not found(null)";
       }
       return room +" is room with "+ParticipantID;
    }
    
   
    public String listAllBreakoutRooms(){
       return vroom.listBreakoutRooms();
    }
    
    public String listParticipantsInAllBreakoutRooms(){
        String participant = ""; 
        for(int j=0; j<vroom.getNumberOfBreakoutRooms(); j++){
            participant += this.vroom.listParticipantsInBreakoutRoom(j) + " ";
        }   
        return participant;
    }
    
}
