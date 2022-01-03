package out.Makaela_Wallace_657818_assignsubmission_file_;/*
 * Name: Makaela Wallace
 * ID: 816018659
*/

import java.util.*; 
import java.io.*;


public class VirtualMeetingSystem{
    String participantData[] = new String [50];
    VirtualRoom virtualRoom ;
      
        public void loadParticipantData (String fileName){
             
            int count = 0;
            
            try{
                File infoFile = new File(fileName);
                Scanner reader = new Scanner(infoFile);
             
                while (reader.hasNextLine()) {
                    String data = reader.nextLine();
                    
                    participantData[count] = data;
                     
                    //System.out.println ("\n" +data);
                    
                    count++;
                }
                reader.close();
            }
            
            catch (Exception e){
                System.out.println("File not found");
            }
            
            //Info about how to read data from a file was found on W3 schools website
            
        } 

        public void createVirtualRoom(String name){
            
            virtualRoom = new VirtualRoom (name);
            virtualRoom.createBreakoutRooms();
            
        }
         
        public void allocateParticipants(String code ){
            
            if (virtualRoom==null){
                return;
            }
            
            int roomNumber = 1;
            boolean added;
            int participantDataLength = participantData.length;
            int breakoutRoomLimit = virtualRoom.getNumberOfBreakoutRooms();
            
            
            if (code== "C5"){
                
                int participantDataPosition =0;
                int c5CutOff = 5;
                
                while ( participantDataPosition< participantDataLength ){
                    
                    for (int i=participantDataPosition; i<c5CutOff; i++){
                        
                        added = virtualRoom.addParticipantToBreakoutRoom(participantData[i], roomNumber);
                        
                    }
                    
                    roomNumber++;
                    
                    if (roomNumber >breakoutRoomLimit){
                            roomNumber = 1;
                    }
                    participantDataPosition = participantDataPosition + 5;
                    c5CutOff = participantDataPosition + 5;
                }
            }
            
            
            else if (code== "RR"){
                
                for (int i=0; i< participantDataLength; i++){
                    
                    added = virtualRoom.addParticipantToBreakoutRoom(participantData[i], roomNumber);
                    
                    roomNumber++;
                    
                    if (roomNumber >breakoutRoomLimit){
                            roomNumber = 1;
                        }
                    
                }
                
                
            }
        }
        
        public boolean addParticipant (String participantID, int roomNumber){
            
            if (virtualRoom==null){
                return false;
            }
            
            boolean details = false;
            
            if (virtualRoom !=null){
                details = virtualRoom.addParticipantToBreakoutRoom(participantID, roomNumber);
            }
            
            return details;
        }
        
        public String listParticipants(int roomNumber){
            
            String details = "";
            
            if (virtualRoom==null){
                return details;
            }
            
            if (virtualRoom !=null){
                details = virtualRoom.listParticipantsInBreakoutRoom(roomNumber);
            }
            
            return details;
        
        }
        
        public boolean openBreakoutRoom(int roomNumber){
            if (virtualRoom==null){
                return false;
            }
            return virtualRoom.openBreakoutRoom(roomNumber);
        
        }
        
        public boolean closeBreakoutRoom(int roomNumber){
        if (virtualRoom==null){
                return false;
            }
            return virtualRoom.closeBreakoutRoom(roomNumber);
        
        }
        
        public String listAllBreakoutRooms( ){
            if (virtualRoom==null){
                return "";
            }
            
            if ( virtualRoom.listBreakoutRooms() == null){
                return null;
            } 
            
            return virtualRoom.listBreakoutRooms();
        
        }
        
        public String findParticipantBreakoutRoom(String participantID){
            if (virtualRoom==null){
                return "";
            }
            return virtualRoom.findParticipantBreakoutRoom (participantID); 
             
        }
        
        public String listParticipantsInAllBreakoutRooms() {
            if (virtualRoom==null){
                return "";
            }
            String listOfParticipants = ""; 
            int numberOfBreakoutRooms = virtualRoom.getNumberOfBreakoutRooms();
            
            
            for (int i=1; i<=numberOfBreakoutRooms; i++){
                
                listOfParticipants = listOfParticipants + "\n" + virtualRoom.listParticipantsInBreakoutRoom(i);
            
            }
            
            return listOfParticipants;
            
        }
    
    }
