package out.Joshua_Davis_657702_assignsubmission_file_;import java.lang.reflect.Field;

/*
    Student ID: 816022176
*/

public class VirtualRunner2{
    public static void main(String[] args) {

        TestSequence[] tests = new TestSequence[]{
            new TestSequence()
                .loadParticipants("participant.dat")
                .createVirtualRoom("Meeting")
                .listParticipantsInAllBreakoutRooms()
                .allocateParticipants("RR")
                .listParticipantsInAllBreakoutRooms()
            ,
            new TestSequence()
                .loadParticipants("participant.dat")
                .createVirtualRoom("Meeting")
                .listParticipantsInAllBreakoutRooms()
                .allocateParticipants("C5")
                .listParticipantsInAllBreakoutRooms()
                .allocateParticipants("RR")
                .listParticipantsInAllBreakoutRooms()
            ,
            new TestSequence()
                .createVirtualRoom("Meeting")
                .openBreakoutRoom(1)
                .openBreakoutRoom(2)
                    .addParticipant("81602217", 1)
                    .addParticipant("12972132", 2)
                    .addParticipant("82932322", 2)
                    .addParticipant("56162329", 1)
                .listParticipantsInAllBreakoutRooms()
                .listParticipants(3)
                .listParticipants(2)
                .listParticipants(1)
                .closeBreakoutRoom(2)
                .listParticipantsInAllBreakoutRooms()
            ,
            new TestSequence()
                .createVirtualRoom("Meeting")
                .openBreakoutRoom(1)
                .openBreakoutRoom(2)
                    .addParticipant("81602217", 1)
                    .addParticipant("12972132", 2)
                    .addParticipant("82932322", 2)
                    .addParticipant("56162329", 10)
                .listParticipantsInAllBreakoutRooms()
                .listParticipants(3)
                .listAllBreakoutRooms()
                .findParticipantBreakoutRoom("12972142")
                .closeBreakoutRoom(2)
                .findParticipantBreakoutRoom("12972142")
        };
        for (int i = 0; i < tests.length; i++) {
            System.out.println("==================Performing test " + i + " =========================");
            

            try {//Ignore me :3. Just working around a bad design since breakoutRoomNumberCounter should controlled (and not be static!!!) by the virtualRoom butttt oh well.
                Field f = BreakoutRoom.class.getDeclaredField("breakoutRoomNumberCounter");
                f.setAccessible(true);
                f.setInt(null, 1);
                f.setAccessible(false);
            } catch (Exception e) {
                // e.printStackTrace();
            }
    
            VirtualMeetingSystem virtualMeetingSystem = new VirtualMeetingSystem();
            
            TestSequence ts = tests[i];
            for (int j = 0; j < ts.getSequenceLength(); j++){
                try{
                    TestSequence.Operation op = ts.getOperation(j);
                    System.out.println("> " + op.message());
                    System.out.println(op.act(virtualMeetingSystem));
                }catch(Exception e){
                    e.printStackTrace();
                }
    
                System.out.println();
                System.out.println();
            }
        }

    }

    
}