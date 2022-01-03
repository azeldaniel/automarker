package out.Shania_Rampersadsingh_657736_assignsubmission_file_;import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.*;
import java.util.*;

/**
 * Write a description of class VirtualMeetingsSystem here.
 *
 * @author Shania Rampersadsingh 816016166
 * @version (a version number or a date)
 */
public class VirtualMeetingSystem 
{
    // instance variables - replace the example below with your own
    
    private VirtualRoom meetingRoom = null;
    private String[] participantData = new String[50];
    private int lengthArr = 1;
    
    
    public void loadParticipantData(String filename)
    
    {
      
        
       if (meetingRoom != null){
            System.out.println("Participant data already loaded.");
            
        }

        else{
         int i = 1;

            try{
                BufferedReader reader = new BufferedReader(new FileReader(filename));
                String s = reader.readLine();
                this.participantData[i] = s;
    
                while (s != null)
                {
                i++;
    
                s = reader.readLine();
                this.participantData[i] = s;
             }
    
               reader.close();
    
             }
             catch (Exception ex){
               ex.getMessage();
             }
              this.lengthArr = i;
        }
    }
    
    
    
    public void createVirtualRoom(String name)
    {
        this.meetingRoom = new VirtualRoom(name);
        this.meetingRoom.createBreakoutRooms();
    }

    public void allocateParticipants(String code)
    {
        int i;
        int j;
        i=1;
        j=1;
        
        if(code==("C5")){
            while(i < lengthArr){
                
                if(j > 5){
                    j = 1;
                }
                
                for(int k=1; k<=5; k++){
                    this.meetingRoom.addParticipantToBreakoutRoom(this.participantData[i],j);
                    i++;
                    if(i == this.lengthArr){
                        break;
                    }
                    
                }
                j++;
            }
        }
 

        if(code==("RR")){
            int k = 1;
            while (k < this.lengthArr){
                this.meetingRoom.addParticipantToBreakoutRoom(participantData[k], j);
                
                j++;
                if(j > 5){
                    j = 1;
                }
                k++;
            }
                
        }
            
    }
    
    public boolean addParticicipant(String participantID, int roomNumber)
    {
       return this.meetingRoom.addParticipantToBreakoutRoom(participantID, roomNumber);
    }

    public String listParticipants(int roomNumber)
    {
        return this.meetingRoom.listParticipantsInBreakoutRoom(roomNumber);
    }
    
    public boolean openBreakoutRoom(int roomNumber)
    {
        return this.meetingRoom.openBreakoutRoom(roomNumber);
    }
    
    public boolean closeBreakoutRoom(int roomNumber)
    {
        return this.meetingRoom.closeBreakoutRoom(roomNumber);
    }
    
    public String findParticipantBreakoutRoom(String participantID)
    {
        return this.meetingRoom.findParticipantBreakoutRoom(participantID);
    }
    
    public String listAllBreakoutRooms()
    {
        return this.meetingRoom.listBreakoutRooms();
    }
    
    public String listParticipantsInAllBreakoutRooms()
    {
        int l;
        System.out.println("List of Participants In All Breakout Rooms: \n");
        String participantsList = "";
        l=0;
        while(l <= 5)
        {
            participantsList += "Breakout Room Number: " + l + "\n";
            

            if(this.meetingRoom.listParticipantsInBreakoutRoom(l) != null){
                 participantsList += this.meetingRoom.listParticipantsInBreakoutRoom(l) + "\n";
            
                 l++;
                 
            }
            else{
                return null;
            }
            
        }
        return participantsList;
    }
    
    public String[] getData() { 
        return this.participantData; 
    }
    
    public int getDataSize(){ 
        return this.lengthArr; 
    }
    
    public VirtualRoom getVirtualRoom(){ 
        return this.meetingRoom; 
    }
    
    
}
