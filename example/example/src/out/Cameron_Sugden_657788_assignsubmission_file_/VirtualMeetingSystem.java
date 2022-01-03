package out.Cameron_Sugden_657788_assignsubmission_file_;import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.*;
import java.util.*;

public class VirtualMeetingSystem{
    
    private String[] data = new String[50];
    private VirtualRoom vr = null;
    private int dataSize = 0;
    
    public String[] getData(){
        return data;
    }
    
    public VirtualRoom getVirtualRoom(){
        return vr;
    }
    
    public int getDataSize(){
        return dataSize;
    }
    
    public void loadParticipantData(String fileName){
        if (vr == null){
            int i = 1;
            
            try{
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                String in = reader.readLine();
                this.data[i] = in;
                
                while (in != null){
                    i++;
                    
                    in = reader.readLine();
                    this.data[i] = in;
                }
                reader.close();
            }catch(Exception e){
                e.getMessage();
            }
            this.dataSize = i;
        }else{
            System.out.println("Data is already loaded...");
        }
    }
    
    public void createVirtualRoom(String name){
        vr = new VirtualRoom(name);
        this.vr.createBreakoutRooms();
    }
    
    public void allocateParticipants(String code){
        int c = 1;
        int r = 1;
        
        if(code.equals("C5")){
            while(c < this.dataSize){
            if(r==6){
                r=1;
            }
            
            
            for(int i = 1; i<=5; i++){
                this.vr.addParticipantToBreakoutRoom(this.data[c],r);
                c++;
                
                if(c == this.dataSize){
                    break;
                }
            }
            r++;
        }
        }   
        
        if(code.equals("RR")){
            for(int i = 1; i<= this.dataSize; i++){
                this.vr.addParticipantToBreakoutRoom(this.data[i],r);
                r++;
                
                if(r == 6){
                    r = 1;
                }
            }
        }
    
    }
    
    public boolean addParticipant(String participantID, int roomNumber){
        return this.vr.addParticipantToBreakoutRoom(participantID,roomNumber);
    }
    
    public String listParticipants(int roomNumber){
        return this.vr.listParticipantsInBreakoutRoom(roomNumber);
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        return this.vr.openBreakoutRoom(roomNumber);
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        return this.vr.closeBreakoutRoom(roomNumber);
    }
    
    public String listAllBreakoutRooms(){
        return this.vr.listBreakoutRooms();
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        return this.vr.findParticipantBreakoutRoom(participantID);
    }
    
    public String listParticipantsInAllBreakoutRooms(){
        int i = 1;
        String details  = "";
        details += "Listing all participants for each BreakoutRoom";
        while(i<5){
            details += "\nBreakoutRoom Number: ";
            details += i;
            details += "\n";
                if(this.vr.listParticipantsInBreakoutRoom(i) == null){
                    return null;
                }else{
                    details += this.vr.listParticipantsInBreakoutRoom(i);
                    details += "\n";
                    i++;
                }
        }return details;
    }
}