package out.Celena_Lewis_657697_assignsubmission_file_;//Celena Lewis
//816019582
//Assignment One COMP 2603

import java.util.Scanner;

public class VirtualRunner{
    
    public static void main(String[] args) throws Exception{
        //https://rollbar.com/guides/java-throwing-exceptions/
        
        //1 reading in the file
        VirtualMeetingSystem vSys = new VirtualMeetingSystem();
        //new virtual meeting system object
        String file;
        System.out.println("Please enter a file name to be used");
        Scanner keyboard = new Scanner(System.in);
        //keyboard input from the user
        file = keyboard.nextLine();
        //System.out.println("Please enter a file name to be used");
        vSys.loadParticipantData(file);
        //throw required
        /*
        System.out.println("Please enter a file name to be used");
        try
        {
            vSys.loadParticipantData(file);
        }
        catch (java.lang.Exception e)
        {
            e.printStackTrace();
        }
        //throw required
        */
       
       
       //2 new virtual room
       //user supplies name
       String VirtualRoomName; 
       System.out.println("Please enter the name of the Virtual Room to be created");
       VirtualRoomName = keyboard.nextLine();
       System.out.println("The virtual room name:" + VirtualRoomName);
       //user input
       vSys.createVirtualRoom(VirtualRoomName);
       System.out.println("Virtual Room created...");
       //createVirtualRoom method called to create the room
       //with the user supplied name
       
       //3 
       //allocate participants to breakoutrooms
       String alloc = " ";
       System.out.println("Please enter either C5 or RR to allocate participants to breakout rooms");
       alloc = keyboard.nextLine();
       //user input
       vSys.allocateParticipants(alloc);
       System.out.println(vSys.listParticipantsInAllBreakoutRooms());
       //call to the allocateParticipants method from the VirtualMeetingSystem class
       
       //8
       //find a participant's breakout room number
       System.out.println("Please enter a participant ID in order to find their corresponding Breakout Room ");
       //promt for user input
       String participantID = " ";
       participantID = keyboard.nextLine();
       System.out.println(vSys.findParticipantBreakoutRoom(participantID));
       //located a participant's breakout room given the supplied ID
       //accesses the method in the virtual meeting system class

       //4
       //Add a new participant to a breakoutroom
       boolean addp;
       //String partID = " ";
       int roomnum = 0;
       System.out.println("Please enter a particpantID to add a new participant to a breakout room");
       String partID = keyboard.nextLine();
       //user input
       System.out.println("Please enter the breakout room number for the corresponding breakout room in which the participant will be added");
       roomnum = keyboard.nextInt();
       //user input
       vSys.addParticipant(partID,roomnum);
       //call to addParticipant method in Virtual Meeting System class
       
       //5
       //display the list of participants in a breakoutroom
       String blist = " ";
       int roomNumb = 0;
        //blist = vSys.listParticipantsInAllBreakoutRooms();
       //list participants in a breakout room
       System.out.println("Please enter a room number of a particular breakout room in order to display the participants for that room");
       //prompt for user input
       roomNumb = keyboard.nextInt();
        //the breakout room number
       //call to method in Virtual Meeting System class;
       //System.out.println("All participants in all breakout rooms are:" + "\n");
       //System.out.println(blist);
        blist = vSys.listParticipants(roomNumb);
        //System.out.println(blist);
       //list participants in a breakout room
       
       
       //6
       //close a breakoutroom based on the room number
       System.out.println("Please enter a room number of a breakout room so that the room can be closed");
       //prompt for user input
       int closeRoomNum = 0;
       closeRoomNum = keyboard.nextInt();
       //the number of the breakout room to be closed
       boolean closed;
       closed = vSys.closeBreakoutRoom(closeRoomNum);
       //access method in the virtual meeting system class 
       if(closed == true){
           System.out.println("The breakout room is closed...");
        }
        /*
        else{
            System.out.println("Room number is invalid...the breakout room cannot be closed" + "\n");
            System.out.println("Please enter another room number to close the breakout room");
            closeRoomNum = keyboard.nextInt();
        }
        */

       
       //7
       //open a breakoutroom based on the room number
       System.out.println("Please enter a room number of a breakout room so that the room can be opened");
       //prompt for user input
       int openRoomNum = 0;
       openRoomNum = keyboard.nextInt();
       //the number of the breakout room to be closed
       boolean opened;
       opened = vSys.openBreakoutRoom(openRoomNum);
       //access method in the virtual meeting system class
       if(closed == true){
           System.out.println("The breakout room is now opened...");
        }
        /*
        else{
            System.out.println("Room number is invalid...the breakout room cannot be open" + "\n");
            System.out.println("Please enter another room number to open the breakout room");
            openRoomNum = keyboard.nextInt();
        }
        */

       //9
       //display a list of all breakout rooms managed by the system
       System.out.println("A list of all the Breakout Rooms managed by the Virtual Meeting System:" + "\n");
       vSys.listAllBreakoutRooms();
       //call to method to list all breakout rooms in the virtual meeting system class
       
       
       //10
       //display a list of all the breakout rooms managed by the system
       //and the participants in each room
       System.out.println("A list of all the Breakout Rooms managed by the Virtual Meeting System as well as the total participants in each Breakout Room");
       vSys.listParticipantsInAllBreakoutRooms();
       //access method in virtual meeting system class in order to display all the breakout rooms
       //and the participants respectively
       
               
    }

    
}
//invokes VirtualRoom class