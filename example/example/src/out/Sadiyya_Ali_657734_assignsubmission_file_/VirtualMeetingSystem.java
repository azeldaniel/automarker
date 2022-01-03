package out.Sadiyya_Ali_657734_assignsubmission_file_;//816013697
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.*;
import java.util.*;

public class VirtualMeetingSystem {
    private VirtualRoom virtualRoom = null;
    private int size = 0;
    private String[] info = new String[50];
    
    public VirtualRoom getVirtualRoom() {
        return virtualRoom;
    }
    
    public int getSize() {
        return size;
    }

    public String[] getInfo() {
        return info;
    }
    
    public void loadParticipantData (String filename) {
        if (virtualRoom == null) {
            int k = 1;
            
            try {
                BufferedReader br = new BufferedReader(new FileReader(filename));
                String input = br.readLine();
                this.info[k] = input;
                
                while (input != null) {
                    k++;
                    input = br.readLine();
                    this.info[k] = input;
                }
                br.close();
            }
            
            catch (Exception ex) {
                ex.getMessage();
            }
            
            this.size = k;  
    }
    
    else {
        System.out.println ("Data already exists");
    }
    }  
    
    public void createVirtualRoom (String name) {
        virtualRoom = new VirtualRoom(name);
        this.virtualRoom.createBreakoutRooms();
    }
    
    public void allocateParticipants (String code) {
        int r = 1;
        int c = 1;
        
        if (code.equals("C5")) {
            while (c < this.size) {
                if (r == 6) {
                    r = 1;
                }
                
                for (int k = 1; k <= 5; k++) {
                    this.virtualRoom.addParticipantToBreakoutRoom
                    (this.info[c], r);
                    c++;
                    
                    if (c == this.size) {
                        break;
                    }
                }
                r++;
            }
        }
        
        if (code.equals("RR")) {
            for (int k = 1; k <= this.size; k++) {
                this.virtualRoom.addParticipantToBreakoutRoom
                (this.info[k], r);
                r++;
                
                if (r == 6) {
                    r = 1;
                }
            }
        }
    }
    
    public boolean addParticipant (String participantID, int roomNumber) {
        return this.virtualRoom.addParticipantToBreakoutRoom(participantID, 
        roomNumber);
    }
    
    public String listParticipants (int roomNumber) {
        return this.virtualRoom.listParticipantsInBreakoutRoom(roomNumber);
    }
    
    public boolean openBreakoutRoom (int roomNumber) {
        return this.virtualRoom.openBreakoutRoom(roomNumber);
    }
    
    public boolean closeBreakoutRoom (int roomNumber) {
        return this.virtualRoom.closeBreakoutRoom(roomNumber);
    }
    
    public String findParticipantBreakoutRoom (String participantID) {
        return this.virtualRoom.findParticipantBreakoutRoom(participantID);
    }
    
    public String listAllBreakoutRooms() {
        return this.virtualRoom.listBreakoutRooms();
    }
    
    public String listParticipantsInAllBreakoutRooms() {
        String participantsList = "Participants in each Breakout Room:" +"\n";
        
        for (int k = 1; k < 5; k++) {
            participantsList += "BreakoutRoom Number: " +k + "\n";
            
            if (this.virtualRoom.listParticipantsInBreakoutRoom(k) == null) {
                return null;
        }
        
        else {
            participantsList += this.virtualRoom.listParticipantsInBreakoutRoom(k)
            + "\n";
            k++;
        }
    }
    return participantsList;
}
}
