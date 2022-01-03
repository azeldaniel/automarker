package out.Jean___Paul_Lezama_657809_assignsubmission_file_;import java.io.File;
import java.util.Scanner;
 import java.util.Arrays;
import java.util.LinkedHashSet;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * Write a description of class VirtualMeetingSystem here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class VirtualMeetingSystem
{
    
    // instance variables - replace the example below with your own
    private String filename;
    private String fileInfo[];
    private VirtualRoom virtualroom;
    /**
     * Constructor for objects of class VirtualMeetingSystem
     */
    
    public VirtualMeetingSystem()
    {
        // initialise instance variables
        
        this.fileInfo = new String[50];
    }


    public void loadParticipantData(String filename)
    {
      BufferedReader reader; 
        
        try {
          int count = 0;

          reader = new BufferedReader(new FileReader(filename));
          String line = reader.readLine();
          while(line!=null){
              fileInfo[count] = new String(line);
              line = reader.readLine();
              count++; 
          }
          reader.close();

        }catch(IOException e){
            e.printStackTrace(); 
        }
    }
    
    public void createVirtualRoom(String name){
        virtualroom = new VirtualRoom(name);
        virtualroom.createBreakoutRooms();
    }
    
    public void allocateParticipants(String code){
        if(code.equals("C5")){
                    int x=0;
           int i=0;
           for(i=0; i<50; i++){  
            if((i%5 == 0) && (i != 0) ){
             x++;    
            }
            if(x==5){
                x=0;
            }
            virtualroom.addParticipantToBreakoutRoom(fileInfo[i],x);
           }  
        }
        else
        System.out.println("Not a valid code......");
    }
    
    public boolean addParticipant(String participantID, int roomNumber){
        return this.virtualroom.addParticipantToBreakoutRoom(participantID,roomNumber);
    }
    
    public String listParticipants(int roomNumber){
        String list = new String();
        list = this.virtualroom.listParticipantsInBreakoutRoom(roomNumber); 
        return list; 
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        return this.virtualroom.openBreakoutRoom(roomNumber);
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        return this.virtualroom.closeBreakoutRoom(roomNumber);  
    }
    
    public String findParticipantBreakoutRoom(String ParticipantID){
       String room = "";
       room = this.virtualroom.findParticipantBreakoutRoom(ParticipantID); 
       if(room == null){
          room = ParticipantID + " not found(null)";
       }
       return room +"is the room for "+ParticipantID;
    }
    
   
    public String listAllBreakoutRooms(){
       return virtualroom.listBreakoutRooms();
    }
    
    public String listParticipantsInAllBreakoutRooms(){
        String participant = ""; 
        for(int i=0; i<virtualroom.getNumberOfBreakoutRooms(); i++){
            participant += this.virtualroom.listParticipantsInBreakoutRoom(i) + "\n";
        }   
        return participant;
    }
    
}