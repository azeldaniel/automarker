package out.Kadeem_Compton_657768_assignsubmission_file_;//814002641

import java.io.File; 
import java.io.FileNotFoundException;  
import java.util.Scanner;

public class VirtualMeetingSystem
{
    private VirtualRoom virtualRoom;
    private String[] participantsArray;
    private int validSize;
    

    public void loadParticipantData(String filename)
    {
        validSize = 0;
        try {
            File myFile = new File(filename);
            Scanner myReader = new Scanner(myFile);
            participantsArray = new String [50];
            System.out.println("Participants IDs: ");
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                participantsArray[validSize] = data;
                validSize++;
            }
            myReader.close();

          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }
    

    public void createVirtualRoom(String name) 
    {
        virtualRoom = new VirtualRoom(name, 5);
        virtualRoom.createBreakoutRooms();
    }


    public void allocateParticipants(String code)
    {
        int counter = 0;
        int roomNumber = 1;
        if (code.equals("C5"))
        {
            for (int i = 0; i < validSize; i++)
            {
               virtualRoom.addParticipantToBreakoutRoom(participantsArray[i], roomNumber);
               counter++;

               if (counter == 5){
                    roomNumber++;
                    counter=0;
               }
            }
        }

        if (code.equals("RR"))
        {
            counter = 1;

            for (int i=0 ; i < validSize ; i++)
            {
               virtualRoom.addParticipantToBreakoutRoom(participantsArray[i], counter);
               counter++;

               if (counter == virtualRoom.getNumberOfBreakoutRooms()+1)
                  counter = 1;
            }
        }
    }

    public boolean addParticipant (String participantID,int roomNumber) 
    {
        if (virtualRoom.addParticipantToBreakoutRoom(participantID, roomNumber))
            return true;
        
        else
            return false;
    }

    public String listParticipants(int roomNumber)
    {
        return virtualRoom.listParticipantsInBreakoutRoom(roomNumber);
    }
    
    public boolean openBreakoutRoom (int roomNumber)
    {
        return virtualRoom.openBreakoutRoom(roomNumber);
    }

    public boolean closeBreakoutRoom(int roomNumber)
    {
        return virtualRoom.closeBreakoutRoom(roomNumber);
    }

    public String findParticipantBreakoutRoom (String participantID)
    {
        return virtualRoom.findParticipantBreakoutRoom(participantID);
    }

    public String listAllBreakoutRooms ()
    {
        return virtualRoom.listBreakoutRooms();
    }

    public String listParticipantsInAllBreakoutRooms()
    {
        String list = "";

        for (int i=0; i < 5 ; i++)
        {
            list += virtualRoom.listParticipantsInBreakoutRoom(i+1) + "\n";
        }
        return list;
    }

}
