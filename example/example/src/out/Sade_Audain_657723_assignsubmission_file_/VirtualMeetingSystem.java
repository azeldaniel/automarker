package out.Sade_Audain_657723_assignsubmission_file_;import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
COMP 2603 Object Oriented Programming 1
Assignment 1
2020/2021 Semester 2

STUDENT NAME: Sade Audain
ID: 816013000
 */
public class VirtualMeetingSystem
{

    // instance variables - replace the example below with your own
    private String [] data = new String[50];
    private int i = 0;
    VirtualRoom room;

    /**
     * Constructor for objects of class VirtualMeetingSystem
     */
    public VirtualMeetingSystem()
    {
        // initialise instance variables

    }
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */

    public void loadParticipantData(String filename){
        //Read data from a file
        try{
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while(myReader.hasNextLine()){
                data[i] = myReader.nextLine();
                //System.out.println(data[i]);
                i++;
            }
            myReader.close();
        } catch (FileNotFoundException e){
            System.out.println("An error occured.");
            e.printStackTrace();
        }

    }

    public void createVirtualRoom(String name){
        //Create a virtual room
        room = new VirtualRoom(name);
        //System.out.println("Virtual room created.");
        room.createBreakoutRooms();
        
    }

    public void allocateParticipants(String code){
        //Allocate participant using C5 or RR
        int numberOfBreakoutRooms = room.getNumberOfBreakoutRooms();
        int size = 0;
        int number = 1;
        int value = 0;
        int i = 0;

        if(code.equals("C5")){
            while(value < 50) {
                if(size == 5){
                    size = 0;
                    number++;
                }

                if(number > numberOfBreakoutRooms)
                    number = 1;

                room.addParticipantToBreakoutRoom(data[i], number);
                i++;
                size++;
                value++;
            }
        }
        else if(code.equals("RR")){
            while(value < 50) {
                room.addParticipantToBreakoutRoom(data[i], number);
                if(number == numberOfBreakoutRooms){
                    number = 1;
                } else{
                    number++;
                }
                i++;
                value++;
            }
        } else{
            System.out.println("Invalid code");
        }
    }

    public boolean addParticipant(String participantID, int roomNumber){
        //Add a new participant to breakout room
       
        if(room.findBreakoutRoom(roomNumber)!= null ){
           return room.addParticipantToBreakoutRoom(participantID, roomNumber);
            
        }
        return false;

    }

    public String listParticipants(int roomNumber){
        //Returns list of participant in breakout room
        String details = "";

        if(room.findBreakoutRoom(roomNumber)!= null){
            details = room.findBreakoutRoom(roomNumber).listParticipants();
            return details; 
        }

        return null;
    }

    public boolean openBreakoutRoom(int roomNumber){
        //Open breakout room with supplied room number
        if(room.findBreakoutRoom(roomNumber)!= null){
           return room.openBreakoutRoom(roomNumber);
           
        }
        return false;
    }

    public boolean closeBreakoutRoom(int roomNumber){
        //Close breakout room with supplied room number
        if(room.findBreakoutRoom(roomNumber)!= null){
            return room.closeBreakoutRoom(roomNumber);
            
        }
        return false;
    }

    public String findParticipantBreakoutRoom(String participantID){
        //Locate and return breakout room ID for breakout with the participant ID
        String details = "";

        if(participantID == null){
            return null;
         
        }
          details = room.findParticipantBreakoutRoom(participantID);
        return details;
    }

    public String listAllBreakoutRooms(){
        //Return list of breakout room managed by virtual room
         String details = "";
        details += room.listBreakoutRooms();
        return details;
    }

    public String listParticipantsInAllBreakoutRooms(){
        //Return list of participant per breakout room manged by virtual room
        String details = "";
        int i = 1;
        while(i <= room.getNumberOfBreakoutRooms()){
            details += room.listParticipantsInBreakoutRoom(i);
            i++;
        }
        return details;
    }
}

//Resources: https://www.w3schools.com/java/java_files_read.asp
