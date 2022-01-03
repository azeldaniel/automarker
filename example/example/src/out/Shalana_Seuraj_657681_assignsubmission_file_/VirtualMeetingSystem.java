package out.Shalana_Seuraj_657681_assignsubmission_file_;/*
 * 816021684
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VirtualMeetingSystem{
    private String[] participantsIDs = new String[50];
    private VirtualRoom vRoom;
    
    //Constructor
    public VirtualMeetingSystem(){
       
    }
    
    public void loadParticipantData(String filename){
        int count = 0;
        try{
            File inputFile = new File(filename); 
            Scanner fileIn = new Scanner(inputFile);
            while(fileIn.hasNextLine()){
                String participantData = fileIn.nextLine();
                String p = new String(participantData);//Create participant object
                participantsIDs[count] = p;//Add participant object to array
                count++;
            }
            fileIn.close();
        }
        catch(FileNotFoundException noFound){
        System.out.println("participant.dat file could not be found....");
        noFound.printStackTrace();
        }  
    }
    
    public void createVirtualRoom(String name){
        vRoom = new VirtualRoom(name);
        vRoom.createBreakoutRooms();
    }
    
    public void allocateParticipants(String code){
        int numPIDs = 0;
        if(code.equals("C5")){
            while(numPIDs<50){              
                for(int i=1;i<=vRoom.getNumberOfBreakoutRooms();i++){                    
                    if(vRoom.findBreakoutRoom(i)!=null){                      
                        for(int j=1;j<=5;j++){   
                            if(numPIDs<50){
                                String IDs = participantsIDs[numPIDs];
                                boolean addedID = vRoom.addParticipantToBreakoutRoom(IDs, i);
                                if(addedID==false){
                                    System.out.println(IDs+"could not be added to "+vRoom.findBreakoutRoom(i).getBreakoutRoomID());
                                }    
                                numPIDs++;
                            }                                              
                        }                    
                    }                    
                }             
            }
        }
        else{
            if(code=="RR"){
                numPIDs = 0;               
                for(int j=1;j<=5;j++){
                    for(int i=1;i<=vRoom.getNumberOfBreakoutRooms();i++){
                        if(vRoom.findBreakoutRoom(i)!=null){
                            if(numPIDs<50){
                                String IDs = participantsIDs[numPIDs];                                    
                                boolean addedID = vRoom.addParticipantToBreakoutRoom(IDs, i);
                                if(addedID==false){
                                    System.out.println(IDs+"could not be added to "+vRoom.findBreakoutRoom(i).getBreakoutRoomID());
                                }                                
                                numPIDs++; 
                            }                                                     
                        } 
                    }              
                }                           
            }
            else{
                System.out.println("The code you entered is incorrect...The code must be C5 or RR");
            }
        }
    }
    
    public boolean addParticipant(String participantID, int roomNumber){
        boolean pAdded = vRoom.addParticipantToBreakoutRoom(participantID, roomNumber);
        return pAdded;
    }
    
    public String listParticipants(int roomNumber){
        String listPIBR = vRoom.listParticipantsInBreakoutRoom(roomNumber);
        return listPIBR;
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        boolean roomOpen = vRoom.openBreakoutRoom(roomNumber);
        return roomOpen;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        boolean roomClose = vRoom.closeBreakoutRoom(roomNumber);
        return roomClose;
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        String findPBR = vRoom.findParticipantBreakoutRoom(participantID);
        return findPBR;
    }
    
    public String listAllBreakoutRooms(){
        String listBRooms = vRoom.listBreakoutRooms();
        return listBRooms;
    }
    
    public String listParticipantsInAllBreakoutRooms(){
        int numBRooms = vRoom.getNumberOfBreakoutRooms();
        String list = "";
        for(int count=1;count<=numBRooms;count++){
            if(vRoom.findBreakoutRoom(count)!=null){
                int roomNumber = vRoom.getBreakoutRoomNumber(vRoom.findBreakoutRoom(count).getBreakoutRoomID());
                list += vRoom.listParticipantsInBreakoutRoom(roomNumber) + "\n";
            }            
        }
        if(list==null){
            return null;
        }
        else{
            return list;
        }
    }
}

// To read from a file - https://www.w3schools.com/java/java_files_read.asp