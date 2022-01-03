package out.Aaron_Meighoo_657750_assignsubmission_file_;//Aaron Meighoo
//816000303
//A1
//Virtual Runner
public class VirtualRunner{
    
    public static void main(String[] args){
        
        String fileName = "participant.dat";
        
        VirtualMeetingSystem v1 = new VirtualMeetingSystem();
        
        v1.loadParticipantData(fileName);
        
        String name = "Test";
        
        v1.createVirtualRoom(name);
        
        //v1.allocateParticipants("C5");
        
        v1.listParticipantsInAllBreakoutRooms();
        
    }
    
    
}
