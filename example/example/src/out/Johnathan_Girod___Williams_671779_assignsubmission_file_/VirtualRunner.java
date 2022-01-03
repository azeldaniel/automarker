package out.Johnathan_Girod___Williams_671779_assignsubmission_file_;import java.util.Scanner;

/**
 * Write a description of class VirtualRunner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class VirtualRunner
{
    // instance variables - replace the example below with your own
    private VirtualMeetingSystem vms;
    
    String test;

    /**
     * Constructor for objects of class VirtualRunner
     */
    public VirtualRunner()
    {
        // initialise instance variables
        vms = new VirtualMeetingSystem();
        
        test = "";
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void initialize()
    {
        
        vms.loadParticipantData("src/test/resources/participant.dat");
        
        vms.createVirtualRoom("myVR");
        
        vms.allocateParticipants("RR");
        
        
        
    }
    
    public void tests(){
        
        
        
        //String s = "";
        
        //s+= vms.findParticipantBreakoutRoom("84528887");
        
        //System.out.println( "Test dataout: " + s );
        
        
        //test += vms.listParticipantInAllBreakoutRooms();
        
        //System.out.println( "Test dataout: " + test );
    }
    
    public void testParticipant()
    {
        String s = "12345678";
        
        //test verify ID
        Participant p = new Participant(s);
        
        boolean b = p.verifyID(s);
        
        System.out.println( "Test dataout: " + b );
        
        b = p.verifyID("1234567");
        
        System.out.println( "Test dataout: " + b );
        
        //test get ID
        s = p.getParticipantID();
        
        System.out.println( "Test dataout: " + s );
        
        //test toString
        
        System.out.println( p.toString() );
        
        
    }
    
    public void testBreakoutRoom()
    {
        BreakoutRoom b = new BreakoutRoom("MyRoom");
        
        
        //test add Participant
        
        boolean bool = b.addParticipant("12345678");
        
        System.out.println( "Testing with 12345678 as a string " );
        System.out.println( "Test dataout: " + bool );
        
        bool = b.addParticipant("1234567");
        
        System.out.println( "Testing with 1234567 as a string " );
        System.out.println( "Test dataout: " + bool );
        
        // test findParticipant
        
        b.addParticipant("12345679");
        b.addParticipant("12345677");
        
        Participant p = b.findParticipant("12345679");
        
        // test listParticipants
        
        String s = b.listParticipants();
        
        System.out.println( s );
        
        // test toString
        
        s = b.toString();
        
        System.out.println( s );
        
        // test is open
        
        bool = b.getOpen();
        
        System.out.println( "Room is open: " + bool );
        
        // test open
        
        b.closeBreakoutRoom();
        
        bool = b.getOpen();
        
        System.out.println( "Closing Room" );
        System.out.println( "Room is open: " + bool );
        
        
        
        b.openBreakoutRoom();
        
        bool = b.getOpen();
        
        System.out.println( "Opening Room" );
        System.out.println( "Room is open: " + bool );
        
        //test close
        
        b.closeBreakoutRoom();
        
        bool = b.getOpen();
        
        System.out.println( "Closing Room" );
        System.out.println( "Room is open: " + bool );
        
        
        // test getBreakoutRoomID
        
        s = b.getBreakoutRoomID();
        
        System.out.println("ID = " + s );
    }
    
    public void testVirtualRoom()
    {
        VirtualRoom v1 = new VirtualRoom("MyBasicVirtualRoom");
        
        VirtualRoom v2 = new VirtualRoom("MySpecialVirtualRoom", 2);
        
        // test getNumberOfBreakoutRooms
        //if this works then createBreakoutRooms also worked
        
        int i = v1.getNumberOfBreakoutRooms();
        
        System.out.println( i );
        
        i = v2.getNumberOfBreakoutRooms();
        
        System.out.println( i );
        
        // test findBreakoutRoom
        
        BreakoutRoom b = v1.findBreakoutRoom(3);
        
        System.out.println( b.getBreakoutRoomID() );
        
        b = v2.findBreakoutRoom(1);
        
        System.out.println( b.getBreakoutRoomID() );
        
        // test open close breakoutRoom
        
        boolean bool = b.getOpen();
        
        System.out.println( "Room is open: " + bool );
        
        
        
        v2.closeBreakoutRoom(1);
        
        b = v2.findBreakoutRoom(1);
        
        bool = b.getOpen();
        
        System.out.println( "Room is open: " + bool );
        
        
        
        v2.openBreakoutRoom(1);
        
        b = v2.findBreakoutRoom(1);
        
        bool = b.getOpen();
        
        System.out.println( "Room is open: " + bool );
        
        
        
        
        v2.closeBreakoutRoom(1);
        
        b = v2.findBreakoutRoom(1);
        
        bool = b.getOpen();
        
        System.out.println( "Room is open: " + bool );
        
        // test listBreakoutRooms
        
        String s = v1.listBreakoutRooms();
        
        System.out.println( "Rooms: " + s );
        
        // test addParticipantToBreakoutRoom
        
        bool = v2.addParticipantToBreakoutRoom("12345678", 1);
        
        bool = v2.addParticipantToBreakoutRoom("123456", 1);
        
        bool = v2.addParticipantToBreakoutRoom("12345668", 1);
        
        // test listParticipantsInBreakoutRoom
        
        s = v2.listParticipantsInBreakoutRoom(1);
        
        System.out.println( "Participants: " + s );
        
        // test findParticipantBreakoutRoom
        
        s = v2.findParticipantBreakoutRoom("12345668");
        
        System.out.println( "room: " + s );
    }
    
    public void testVMS()
    {
        VirtualMeetingSystem v1 = new VirtualMeetingSystem();
        VirtualMeetingSystem v2 = new VirtualMeetingSystem();
        // test loadParticipantData
        
        v1.loadParticipantData("src/test/resources/participant.dat");
        
        v2.loadParticipantData("src/test/resources/participant.dat");
        
        // test createVirtualRoom
        
        v1.createVirtualRoom("myVR");
        
        v2.createVirtualRoom("myVR");
        
        //test allocateParticipants, addParticipant which is in allocate
        
        v1.allocateParticipants("C5");
        
        v2.allocateParticipants("RR");
        
        // test listParticipants
        
        v2.listParticipants(0);
        
        v1.listParticipants(3);
        
        // test open close breakout room
        
        boolean b = v1.openBreakoutRoom(1);
        
        System.out.println( "Room is open: " + b );
        
        b = v1.closeBreakoutRoom(1);
        
        System.out.println( "Room is closed: " + b );
        
        // test findParticipantBreakoutRoom
        
        String s = v1.findParticipantBreakoutRoom("11905916");
        
        System.out.println( s );
        
        s = v2.findParticipantBreakoutRoom("11905916");
        
        System.out.println( s );
        
        // test listAllBreakoutRooms
        
        s = v1.listAllBreakoutRooms();
        
        System.out.println( s );
        
        s = v2.listAllBreakoutRooms();
        
        System.out.println( s );
        
        // test listParticipantInAllBreakoutRooms
        
        s = v1.listParticipantInAllBreakoutRooms();
        
        System.out.println( s );
        
        s = v2.listParticipantInAllBreakoutRooms();
        
        System.out.println( s );
        
    }
}
