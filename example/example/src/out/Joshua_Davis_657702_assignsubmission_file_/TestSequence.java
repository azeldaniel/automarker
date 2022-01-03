package out.Joshua_Davis_657702_assignsubmission_file_;
public class TestSequence {

    private static interface OperationMessageGenerator{
        public String message();
    }
    private static interface OperationActor{
        public Object act(VirtualMeetingSystem vms);
    }
    public static interface Operation extends OperationMessageGenerator, OperationActor{
    }

    private int sequenceLength = 0;
    private Operation[] sequence = new Operation[0];


    public TestSequence(){

    }

    public int getSequenceLength(){
        return sequenceLength;
    }
    public Operation getOperation(int i){
        return sequence[i];
    }

    private void extendSequence(int amt){
        Operation[] newSequence = new Operation[sequenceLength + amt];
        for (int i =0; i < sequenceLength; i++){
            newSequence[i] = sequence[i];
        }
        sequence = newSequence;
    }
    private void addOperation(Operation op){
        if (sequenceLength == sequence.length){
            extendSequence(10);
        }
        sequence[sequenceLength++] = op;
    }
    private void addOperation(OperationMessageGenerator omg, OperationActor oa){
        addOperation(new Operation(){
            public String message(){
                return omg.message();
            }
            public Object act(VirtualMeetingSystem vms){
                return oa.act(vms);
            }
        });
    }

    public TestSequence loadParticipants(String filename){
        addOperation(
            ()->"Loading participant data from '" + filename + "'",
            vms->{vms.loadParticipantData(filename); return null;}
        );
        return this;
    } 
    public TestSequence createVirtualRoom(String name){
        addOperation(
            ()->"Creating virtual room '" + name + "'",
            vms->{vms.createVirtualRoom(name); return null;}
        );
        return this;
    } 
    public TestSequence allocateParticipants(String code){
        addOperation(
            ()->"Allocating participants using '" + code + "'",
            vms->{vms.allocateParticipants(code);; return null;}
        );
        return this;
    } 
    public TestSequence addParticipant(String participantID, int roomNumber){
        addOperation(
            ()->"Adding participant '" + participantID + "' to room " + roomNumber,
            vms->vms.addParticipant(participantID, roomNumber)
        );
        return this;
    } 
    public TestSequence listParticipants(int roomNumber){
        addOperation(
            ()->"Displaying list of all participants in brackoutRoom '" + roomNumber + "'",
            vms->vms.listParticipants(roomNumber)
        );
        return this;
    } 
    public TestSequence closeBreakoutRoom(int roomNumber){
        addOperation(
            ()->"Closing breakoutRoom '" + roomNumber + "'",
            vms->vms.closeBreakoutRoom(roomNumber)
        );
        return this;
    } 
    public TestSequence openBreakoutRoom(int roomNumber){
        addOperation(
            ()->"Opening breakoutRoom '" + roomNumber + "'",
            vms->vms.openBreakoutRoom(roomNumber)
        );
        return this;
    } 
    public TestSequence findParticipantBreakoutRoom(String participantID){
        addOperation(
            () -> "Finding breakout room number of participant '"+participantID + "'",
            vms -> vms.findParticipantBreakoutRoom(participantID)
        );
        return this;
    } 
    public TestSequence listAllBreakoutRooms(){
        addOperation(
            () -> "Displaying list of all breakout rooms managed by the system",
            vms -> vms.listAllBreakoutRooms()
        );
        return this;
    } 
    public TestSequence listParticipantsInAllBreakoutRooms(){
        addOperation(
            () -> "Displaying list of all breakout rooms managed by the system as well as the participants in each room",
            vms -> vms.listParticipantsInAllBreakoutRooms()
        );
        return this;
    } 

}
