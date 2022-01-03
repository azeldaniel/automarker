package out.Stephen_Scarlett_657837_assignsubmission_file_;import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.*;
import java.util.*;
/**
 * Write a description of class VirtualMeetingSystem here.
 *
 * @author (Stephen Scarlett, 816013791)
 * @version (a version number or a date)
 */
public class VirtualMeetingSystem
{
    private String[] participantArray = new String[50];
    private int arrayLength = 0;
    private VirtualRoom virtualRoom = null;
    
    //public static void main(String[] args)// throws FileNotFoundException
   
    public void loadParticipantData(String fileName){ //throws FileNotFoundException
        if (virtualRoom == null){
            int i = 1;

            try{
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                String s = reader.readLine();
                this.participantArray[i] = s;
    
                while (s != null)
                {
                i++;
    
                s = reader.readLine();
                this.participantArray[i] = s;
             }
    
               reader.close();
    
             }
             catch (Exception e){
               e.getMessage();
             }
              this.arrayLength = i;
        }

        else{
         System.out.println("Data Exists Already");
        }
    }
    
    
    public void createVirtualRoom(String name)
    {
        this.virtualRoom = new VirtualRoom(name);
        this.virtualRoom.createBreakoutRooms();
    }

    public void allocateParticipants(String code)
    {
        int i = 1;
        int m = 1;
        
        if(code.equals("C5")){
            while(i < this.arrayLength){
                
                if(m == 6){
                    m = 1;
                }
                for(int k=1; k<6; k++){
                    this.virtualRoom.addParticipantToBreakoutRoom(this.participantArray[i], m);
                    i++;
                    if(i == this.arrayLength){
                        break;
                    }
                }
                m++;
            }
        }
 

        if(code.equals("RR")){
            for(int k=1; k<this.arrayLength; k++){
                this.virtualRoom.addParticipantToBreakoutRoom(participantArray[k], m);
                
                m++;
                if(m == 6){
                    m = 1;
                }
            }
                
        }
            
    }
    
    public boolean addParticicipant(String participantID, int roomNumber)
    {
       return this.virtualRoom.addParticipantToBreakoutRoom(participantID, roomNumber);
    }

    public String listParticipants(int roomNumber)
    {
        return this.virtualRoom.listParticipantsInBreakoutRoom(roomNumber);
    }
    
    public boolean openBreakoutRoom(int roomNumber)
    {
        return this.virtualRoom.openBreakoutRoom(roomNumber);
    }
    
    public boolean closeBreakoutRoom(int roomNumber)
    {
        return this.virtualRoom.closeBreakoutRoom(roomNumber);
    }
    
    public String findParticipantBreakoutRoom(String participantID)
    {
        return this.virtualRoom.findParticipantBreakoutRoom(participantID);
    }
    
    public String listAllBreakoutRooms()
    {
        return this.virtualRoom.listBreakoutRooms();
    }
    
    public String listParticipantsInAllBreakoutRooms()
    {
        int i=1;
        String details = "";
        while(i < 6)
        {
            details += "Breakout Room Number: ";
            details += i;
            details += "\n";

            if(this.virtualRoom.listParticipantsInBreakoutRoom(i) == null){
                    return null;
            }
            details += this.virtualRoom.listParticipantsInBreakoutRoom(i);
            details += "\n";
            i++;
        }
        return details;
    }
    
    public String[] getData() { 
        return this.participantArray; 
    }
    
    public int getDataSize(){ 
        return this.arrayLength; 
    }
    
    public VirtualRoom getVirtualRoom(){ 
        return this.virtualRoom; 
    }
    
}
