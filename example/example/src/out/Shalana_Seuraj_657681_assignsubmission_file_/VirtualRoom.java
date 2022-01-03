package out.Shalana_Seuraj_657681_assignsubmission_file_;/*
 * 816021684
 */

public class VirtualRoom{
    private String name;
    private final int breakoutRoomLimit;    
    private BreakoutRoom[] breakoutRooms;
    
    //Constructor
    public VirtualRoom(String name){
        this.name = name;
        this.breakoutRoomLimit = 5;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }
    
    //Overloaded Constructor
    public VirtualRoom(String name, int limit){
        this.name = name;
        this.breakoutRoomLimit = limit;
        breakoutRooms = new BreakoutRoom[breakoutRoomLimit];
    }    
    
    public int getNumberOfBreakoutRooms(){
        return this.breakoutRoomLimit;
    }    
    
    public void createBreakoutRooms(){        
        for(int i=0;i<this.breakoutRoomLimit;i++){      
            if(breakoutRooms[i]==null){
                BreakoutRoom br = new BreakoutRoom(name);           
                breakoutRooms[i] = br;   
            }               
        }
    }    
    
    public BreakoutRoom findBreakoutRoom(int roomNumber){
        for(int j=0;j<breakoutRoomLimit;j++){
            String bRoomID = breakoutRooms[j].getBreakoutRoomID();
            int bRoomNum = getBreakoutRoomNumber(bRoomID);
            if(bRoomNum==roomNumber){
                return breakoutRooms[j];
            }
        }
        return null;
    }
    
    public boolean closeBreakoutRoom(int roomNumber){
        for(int j=0;j<breakoutRoomLimit;j++){
            if(breakoutRooms[j]!=null){              
                String bRoomID = breakoutRooms[j].getBreakoutRoomID();
                int bRoomNum = getBreakoutRoomNumber(bRoomID);
                if(bRoomNum==roomNumber){
                    if(breakoutRooms[j].getOpen()==false){//BreakoutRoom Close
                        return true;
                    }
                    else{//BreakoutRoom open
                        breakoutRooms[j].closeBreakoutRoom();
                        System.out.println(breakoutRooms[j].toString());
                        return true;//returns true if it successfully closes the room
                    }                
                }                
            }            
        }
        return false;
    }
    
    public boolean openBreakoutRoom(int roomNumber){
        for(int j=0;j<breakoutRoomLimit;j++){
            if(breakoutRooms[j]!=null){
                String bRoomID = breakoutRooms[j].getBreakoutRoomID();
                int bRoomNum = getBreakoutRoomNumber(bRoomID);
                if(bRoomNum==roomNumber){
                    if(breakoutRooms[j].getOpen()==true){//BreakoutRoom open
                        return true;
                    }
                    else{//BreakoutRoom close
                        breakoutRooms[j].openBreakoutRoom();
                        System.out.println(breakoutRooms[j].toString());
                        return true;//returns true if it successfully opened the room
                    }                    
                }            
            }            
        }
        return false;
    }
    
    public String listBreakoutRooms(){
        String listBR = "";
        listBR += this.name + " (Virtual Room Name)\n";
        for(int b=0;b<this.breakoutRoomLimit;b++){
           if(breakoutRooms[b]!=null){
               listBR += this.name + " - " + breakoutRooms[b].getBreakoutRoomID() + "\n";
           }
        }
        return listBR;
    }
    
    public String listParticipantsInBreakoutRoom(int roomNumber){
        String listPIBR = "";        
        for(int b=0;b<this.breakoutRoomLimit;b++){
            if(breakoutRooms[b]!=null){
                int numberParticipants = breakoutRooms[b].getNumberOfParticipants();
                String bRoomID = breakoutRooms[b].getBreakoutRoomID();
                int bRoomNum = getBreakoutRoomNumber(bRoomID);
                if(bRoomNum==roomNumber){                                      
                   listPIBR += breakoutRooms[b].listParticipants();                       
                   return listPIBR;          
                }
            }
        }
        return null;
    }
    
    public boolean addParticipantToBreakoutRoom(String participantID, int roomNumber){
        boolean addedParticipant = false;
        for(int b=0;b<this.breakoutRoomLimit;b++){
            if(breakoutRooms[b]!=null){
                String bRoomID = breakoutRooms[b].getBreakoutRoomID();
                int bRoomNum = getBreakoutRoomNumber(bRoomID);
                if(bRoomNum==roomNumber){
                    addedParticipant = breakoutRooms[b].addParticipant(participantID);
                    return addedParticipant;
                }
            }
        }
        return addedParticipant;
    }
    
    public String findParticipantBreakoutRoom(String participantID){        
        for(int c=0;c<this.breakoutRoomLimit;c++){//Traverse through breakoutRooms array
            if(breakoutRooms[c]!=null){         
                int numberParticipants = breakoutRooms[c].getNumberOfParticipants();            
                if(breakoutRooms[c].findParticipant(participantID)!=null){
                    if(breakoutRooms[c].findParticipant(participantID).getParticipantID().equals(participantID)){
                        String bRoomID = breakoutRooms[c].getBreakoutRoomID();
                        return bRoomID;
                    }
                }
            }
        }        
        return null;
    }     
    
    public int getBreakoutRoomNumber(String breakoutRoomID){        
        StringBuilder bRNumber = new StringBuilder();        
        String bRID = breakoutRoomID;
        int roomNumber;
        char[] characters = bRID.toCharArray();            
        for(char num : characters){
            if(Character.isDigit(num)){
                bRNumber.append(num);
            }
        }    
        roomNumber = Integer.parseInt(bRNumber.toString());
        return roomNumber;
    }
    
    //For getBreakoutRoomNumber method - https://www.tutorialspoint.com/Check-if-a-string-contains-a-number-using-Java#:~:text=To%20find%20whether%20a%20given,method%20of%20the%20Character%20class.
    //                                 - https://beginnersbook.com/2013/12/how-to-convert-string-to-int-in-java/
}