package out.Jonathan_Gray_657823_assignsubmission_file_;// StudentID: 816022996
// Student Name: Jonathan Gray

import java.util.*;
import java.io.*;

public class VirtualMeetingSystem{
    // Initilization of essential attributes/variables.
    private String[] participantDataList;
    private VirtualRoom vr;
    
    public void loadParticipantData(String filename){
        File file = new File(filename);
        Scanner in;
  
        participantDataList = new String[50];

        int i = 0;
        
        try{
            in = new Scanner(file);
            while(in.hasNext()){
                participantDataList[i] = new String(in.nextLine());
                //System.out.println(participantDataList[i]);
                i += 1;  
            }   
            //System.out.println("\n\t<-> Successful read-in of '" + filename + "' <->\n");
            in.close();
        }      
        catch(Exception e){
            System.out.println("\t...File failed to open...");
        }
    }
    
    public void createVirtualRoom(String name){
        this.vr = new VirtualRoom(name);
    }
    
    public void createBreakoutRooms(){
         vr.createBreakoutRooms();
    }
    
    public void allocateParticipants(String code){
        int j = 0;
        if(code.equals("C5")){
            for(int i = 0; i < vr.getBreakoutRoomLimit(); i++){
                //System.out.println("\n\t<-> BreakoutRoom '" + vr.getBreakoutRoomID(i) + "' <->\n");
               for(int y = 0; y < 5; y++){
                 vr.addParticipantToBreakoutRoom(participantDataList[j], y);
                   
                 j += 1;
               }
            }
        }
        else if(code.equals("RR")){
            for(int i = 0; i < vr.getBreakoutRoomLimit(); i++){
                for(int y = 0; y < vr.getBreakoutRoomSize(i); y++){
                 vr.addParticipantToBreakoutRoom(participantDataList[j], y);
                 //System.out.println(vr.getParticipantID(i, y));
                 
                 j += 5;
               }
               j = i+1;
               //System.out.println("\n\n");
            }
        }
        else{
            System.out.println("\n\tThe code entered is Invalid code.\n");
        }
    }

    public boolean addParticipant(String participantID, int roomNumber){
       return vr.addParticipantToBreakoutRoom(participantID, roomNumber);
    }

    public String listParticipants(int roomNumber){
        return vr.listParticipantsInBreakoutRoom(roomNumber);
    }

    public boolean openBreakoutRoom(int roomNumber){
        return vr.openBreakoutRoom(roomNumber);
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        return vr.closeBreakoutRoom(roomNumber);
    }

    public String findParticipantBreakoutRoom(String participantID){
       return vr.findParticipantBreakoutRoom(participantID);
    }

    public String listAllBreakoutRooms(){
        return vr.listBreakoutRooms();
    }
    
    public String listParticipantsInAllBreakoutRooms(){
        String participantsInAllBreakoutRooms = new String();
        
        for(int i = 0; i < vr.getBreakoutRoomLimit(); i++){
                //System.out.println("Room number is: " + vr.getBreakoutRoomNumber(i));
                
                if(vr.getBreakoutRoomNumber(i) != -1){
                    /*participantsInAllBreakoutRooms += vr.listParticipantsInBreakoutRoom(
                        vr.getBreakoutRoomNumber(i));*/
                        
                    participantsInAllBreakoutRooms += vr.listParticipantsInBreakoutRoom(
                        vr.getBreakoutRoomNumber(i));
                    
                    
                }                    
        }
        
        return participantsInAllBreakoutRooms;
    }
    
    public int getNumberOfBreakoutRooms(){
        return vr.getNumberOfBreakoutRooms();
    }
    
    public boolean getBreakoutRoomOpen(int breakoutRoomIndex){
        return vr.getBreakoutRoomIsOpen(breakoutRoomIndex);
    }
} 

// To read-in files, I sourced and modified online code to meet the requirements
// ...of the assigment as I was not taught how to do this in classes.