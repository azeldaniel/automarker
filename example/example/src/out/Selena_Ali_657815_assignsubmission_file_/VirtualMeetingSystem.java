package out.Selena_Ali_657815_assignsubmission_file_;// 816017254

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.LinkedList;

/**
 * Write a description of class VirtualMeetingSystem here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class VirtualMeetingSystem
{
    // instance variables - replace the example below with your own
    private VirtualRoom vr;
    
    LinkedList<String> dataList = new LinkedList<String>();
    
    public void loadParticipantData(String filename){
        try {
            File myObj = new File("participant.dat");
            Scanner myReader = new Scanner(myObj);
            
            while(myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            
            myReader.close();
        }
        
        catch (FileNotFoundException e) {
            System.out.println("An error occurred. File not found.");
            e.printStackTrace();
        }
    }
    
    public void createVirtualRoom (String name){
        vr= new VirtualRoom(name);
        vr.createBreakoutRoom();
    }
    
    public void allocateParticipants (String code){
        String data;
        boolean added;
        
        if (code == "C5"){
            for (int i=0; i<dataList.size(); i= i+5){
                for (int j=1; j<=vr.getNumberOfBreakoutRooms(); j++){
                    for (int k=i; k<i+5; k++){
                        data= dataList.get(k);
                        
                        if (addParticipant(data, j) == true)
                            System.out.println (data + " added to room " + j);
                        
                        else
                            System.out.println (data + " was not added to room " + j);
                    }
                }
            }
        }
        
        if(code == "RR"){
            int j= 1;
            
            for (int i=0; i<dataList.size(); i++){
                if (j > vr.getNumberOfBreakoutRooms())
                    j= 1;
                
                data= dataList.get(i);
                
                if (addParticipant(data, j) == true)
                    System.out.println (data + " was added to room " + j);
                
                else
                    System.out.println (data + "was not added to room "+ j);
                    
                j++;
            }
        }
        
        
    }
    
    public boolean addParticipant (String participantID, int roomNumber){
        return vr.addParticipantToBreakoutRoom(participantID, roomNumber);
    }
    
    public String listParticipants (int roomNumber){
        return vr.listParticipantsInBreakoutRoom(roomNumber);
    }
    
    public boolean openBreakoutRoom (int roomNumber){
        return vr.openBreakoutRoom(roomNumber);
    }
    
    public boolean closeBreakoutRoom (int roomNumber){
        return vr.closeBreakoutRoom(roomNumber);
    }
    
    public String findParticipantBreakoutRoom (String participantID){
        return vr.findParticipantBreakoutRoom(participantID);
    }
    
    public String listAllBreakoutRooms(){
        return vr.listBreakoutRooms();
    }
    
    public String listParticipantsInAllBreakoutRooms(){
        String allOutput= "All Participants: /n";
        int len= vr.getNumberOfBreakoutRooms();
        
        for (int i=1; i<=len; i++){
            allOutput= vr.listParticipantsInBreakoutRoom(i);
        }
        
        return allOutput;    
    }
    
}

/* sources used for assignment
 - lecture slides
 - code from labs
 - textbook: OBJECT-ORIENTED ANALYSIS AND DESIGN
 - https://www.w3schools.com/java/java_files_read.asp
 - https://www.geeksforgeeks.org/linked-list-in-java/
 
 */