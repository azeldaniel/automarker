package out.Nicholas_Kauffmann_657738_assignsubmission_file_;import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;

public class VirtualMeetingSystem       //ID: 816015405
{
    VirtualRoom virtualRooms[] = new VirtualRoom[5];
    private String[] participantIDs = new String[50];
    public static int numberOfParticipants;


    public VirtualMeetingSystem()
    {
        virtualRooms[0] = new VirtualRoom("Virtual Room");
        virtualRooms[0].createBreakoutRooms();
    }
    

    public void loadParticipantData(String fileName)
    {
        try
        {
            File myObj = new File (fileName);
            Scanner fileReader = new Scanner(myObj);
            int i = 0;
            int counter;
            String data = "";

            while(fileReader.hasNextLine()){
                data = fileReader.nextLine();
                //System.out.println(data);
                
                participantIDs[i] = data;
                i++;
                
            }      
            this.numberOfParticipants = i;
            // put your code here
            fileReader.close();
            //System.out.println(numberOfParticipants);
            
        }        
        catch(FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    public void createVirtualRoom (String name){
        VirtualRoom r1 = new VirtualRoom (name);
    }
    
    public void allocateParticipants (String code){
        int i = 0;
        int j = 0;
        int count = 0;
        int breakoutRoomSize = 0;
        int roomLimit = 10;
        boolean check;
        //virtualRooms[0] = new VirtualRoom("Virtual Room");
        //virtualRooms[0].createBreakoutRooms();
        breakoutRoomSize = virtualRooms[0].getNumberOfBreakoutRooms();
        
        if(code.equals("C5")){  
            for(i=0; i<breakoutRoomSize; i++){              //loop changing rooms
                virtualRooms[0].openBreakoutRoom(i);
                
                for(j=0; j<(roomLimit); j++){           //loop adding participants
                    check = virtualRooms[0].addParticipantToBreakoutRoom(participantIDs[count], i);
                    count++;
                }

            }

            System.out.println("Allocated Participants to breakout rooms using the "+code+" method.");
        }

        if(code.equals("RR")){
            count = 0;
            while(count < numberOfParticipants){
                for(i = 0; i<breakoutRoomSize; i++){        //breakoutroom size = 5
                    virtualRooms[0].openBreakoutRoom(i);
                    check = virtualRooms[0].addParticipantToBreakoutRoom(participantIDs[count], i);
                    count++;
                }

            }
            System.out.println("Allocated Participants to breakout rooms using the "+code+" method.");
        }

        if(!code.equals("RR") && !code.equals("C5")){
            System.out.println("Unknown allocation method!\nUse the methods stated on the main menu!");
            check = false;
        }
    }


    public boolean addParticipant (String participantID, int roomNumber){        
        boolean added;
        added = virtualRooms[0].addParticipantToBreakoutRoom(participantID, (roomNumber - 1));
        if (added == true)
            System.out.println("Added participant," + participantID + " to room " + (roomNumber));

        return added;
    }
    
    public String listParticipants (int roomNumber){
        String list;
        list = virtualRooms[0].listParticipantsInBreakoutRoom(roomNumber-1);
        
        //System.out.println("listing participants");
        return (list);
    }
    
    public boolean openBreakoutRoom (int roomNumber){       
        
        return virtualRooms[0].openBreakoutRoom(roomNumber-1);
    }
    
    public boolean closeBreakoutRoom(int roomNumber){

        return virtualRooms[0].closeBreakoutRoom(roomNumber-1);
    }
    
    public String findParticipantBreakoutRoom(String participantID){
        String result;
        result = virtualRooms[0].findParticipantBreakoutRoom(participantID);


        return(result);
    }
    
    public String listAllBreakoutRooms(){
        String rooms;        
        rooms = virtualRooms[0].listBreakoutRooms();
        
        //System.out.println("listing??");
        return(rooms);
    }
    
    public String listParticipantsInAllBreakoutRooms(){
        String allParticipants = null;
        String roomName ="";
        String result = "";
        int breakoutRoomSize = virtualRooms[0].getNumberOfBreakoutRooms(); 
        
        for(int i=0; i<breakoutRoomSize; i++){
            roomName = "Breakout Room "+(i+1)+"\n";
            allParticipants = virtualRooms[0].listParticipantsInBreakoutRoom(i);

            result = result+"\n"+allParticipants+"\n\n";
        }
        
        return (result);
    }
    
}

    
           
    
