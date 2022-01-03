package out.Joshua_Davis_657702_assignsubmission_file_;import java.lang.reflect.Field;

/*
    Student ID: 816022176
*/

public class VirtualRunner {
    public static void main(String[] args) {

        //The numbers are the same as outlined in the overview of the application
        Object[][][] rawTests = new Object[][][] { 
            {
                 { 1 }, { 2, "Meeting" }, { 10 }, { 3, "RR" }, { 10 }
            },
            {
                 { 1 }, { 2, "Meeting" }, { 10 }, { 3, "C5" }, { 10 }, {3, "RR"}, {10}
            },
            {
                 { 1 }, { 3, "C5" }, { 10 }
            },
            { 
                { 2, "Meeting" }, { 7, 1 }, {7, 2},
                    { 4, new Object[] { "81602217", 1 } },
                    { 4, new Object[] { "12972132", 2 } }, 
                    { 4, new Object[] { "82932322", 2 } }, 
                    { 4, new Object[] { "56162329", 1 } }, 
                { 10 },
                {5, 3},
                {5, 2},
                {5, 1},
                {6, 2},
                { 10 },
            },
            {
                { 2, "Meeting" }, { 7, 1 }, {7, 2},
                    { 4, new Object[] { "81602217", 1 } },
                    { 4, new Object[] { "12972132", 2 } }, 
                    { 4, new Object[] { "82932322", 2 } }, 
                    { 4, new Object[] { "56162329", 10 } }, 
                { 10 },
                {5, 3},
                {9},
                {8, "12972132"},
                {6, 2},
                {8, "12972132"},
            }
        };

        Operation[][] tests = new Operation[rawTests.length][];

        for (int i = 0; i < rawTests.length; i++) {
            Operation[] operations = new Operation[rawTests[i].length];
            tests[i] = operations;
            for (int j = 0; j < rawTests[i].length; j++) {
                switch (rawTests[i][j].length) {
                    case 1:
                        operations[j] = new Operation((Integer) rawTests[i][j][0]);
                        break;
                    case 2:
                        operations[j] = new Operation((Integer) rawTests[i][j][0], rawTests[i][j][1]);
                        break;
                    default:
                        throw new RuntimeException("Error parsing rawTests (invalid number of parameters) at " + i + " "
                                + j + " " + rawTests[i][j]);
                }
            }
        }

        for (int i = 0; i < tests.length; i++) {
            System.out.println("==================Performing test " + i + " =========================");
            VirtualRunner virtualRunner = new VirtualRunner();
            virtualRunner.performOperations(tests[i]);
        }

        // VirtualMeetingSystem meetingSystem = new VirtualMeetingSystem();
        // meetingSystem.loadParticipantData("participant.dat");

        // System.out.println("File loaded");

        // System.out.println();
        // System.out.println("Performing C5");
        // meetingSystem.allocateParticipants("C5");
        // System.out.println(meetingSystem.listParticipantsInAllBreakoutRooms());

        // System.out.println();
        // System.out.println("Performing RR");
        // meetingSystem.allocateParticipants("RR");
        // System.out.println(meetingSystem.listParticipantsInAllBreakoutRooms());

    }

    private static class Operation {
        public final int opcode;
        public final Object extra;

        public Operation(int opcode) {
            this(opcode, null);
        }

        public Operation(int opcode, Object extra) {
            this.opcode = opcode;
            this.extra = extra;
        }

    }

    private String participantFile;
    private VirtualMeetingSystem virtualMeetingSystem;

    private VirtualRunner() {
        participantFile = "participant.dat";
        
        try {//Ignore me :3. Just working around a bad design since breakoutRoomNumberCounter should controlled (and not be static!!!) by the virtualRoom butttt oh well.
            Field f = BreakoutRoom.class.getDeclaredField("breakoutRoomNumberCounter");
            f.setAccessible(true);
            f.setInt(null, 1);
            f.setAccessible(false);
        } catch (Exception e) {
            // e.printStackTrace();
        }

        virtualMeetingSystem = new VirtualMeetingSystem();
    }

    private void performOperations(Operation[] operations){
        for (int i = 0; i < operations.length; i++){
            try{
                performOperation(operations[i]);
            }catch(Exception e){
                e.printStackTrace();
            }

            System.out.println();
            System.out.println();
        }
    }

    private void performOperation(Operation operation){
        String name;
        String scheme;
        String participantID;
        int roomNumber;
        System.out.print("> ");
        switch(operation.opcode){
            case 1:
                System.out.println("Loading participant data");
                virtualMeetingSystem.loadParticipantData(participantFile);
                break;
            case 2:
                name = (String) operation.extra;
                System.out.println("Creating virtual room '" + name + "'");
                virtualMeetingSystem.createVirtualRoom(name);
                break;
            case 3:
                scheme = (String) operation.extra;
                System.out.println("Allocating participants using '"+scheme+"'");
                virtualMeetingSystem.allocateParticipants(scheme);
                break;
            case 4:
                Object[] participantRoomPair = (Object[]) operation.extra;
                participantID = (String) participantRoomPair[0];
                roomNumber = (Integer) participantRoomPair[1];
                System.out.println("Adding participant '"+participantID+"' to '"+roomNumber+"'");
                System.out.println("Return value: " + virtualMeetingSystem.addParticipant(participantID, roomNumber));
                break;
            case 5:
                roomNumber = (Integer) operation.extra;
                System.out.println("Displaying list of all participants in breakoutRoom: '"+roomNumber+"'");
                System.out.println(virtualMeetingSystem.listParticipants(roomNumber));
                break;
            case 6:
                roomNumber = (Integer) operation.extra;
                System.out.println("Closing breakoutRoom: '"+roomNumber+"'");
                System.out.println("Return value: " + virtualMeetingSystem.closeBreakoutRoom(roomNumber));
                break;
            case 7:
                roomNumber = (Integer) operation.extra;
                System.out.println("Opening breakoutRoom: '"+roomNumber+"'");
                System.out.println("Return value: " + virtualMeetingSystem.openBreakoutRoom(roomNumber));
                break;
            case 8:
                participantID = (String) operation.extra;
                System.out.println("Finding breakout room number of participant '"+participantID+"'");
                System.out.println(virtualMeetingSystem.findParticipantBreakoutRoom(participantID));
                break;
            case 9:
                System.out.println("Displaying list of all breakout rooms managed by the system");
                System.out.println(virtualMeetingSystem.listAllBreakoutRooms());
                break;
            case 10:
                System.out.println("Displaying list of all breakout rooms managed by the system as well as the participants in each room");
                System.out.println(virtualMeetingSystem.listParticipantsInAllBreakoutRooms());
                break;
            default: 
                System.err.println("Invalid operation supplied");
                break;
        }
    }
    
}