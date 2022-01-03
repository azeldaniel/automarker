package out.Kwame_Trancoso_657796_assignsubmission_file_;//816005595
public class VirtualRunner{
    public static void main(String[] args){
    
    VirtualMeetingSystem vs = new VirtualMeetingSystem();
    vs.loadParticipantData();
    vs.createVirtualRoom("Workshop");
    vs.vRoom.createBreakoutRooms();
    
    String s = vs.listAllBreakoutRooms();
    System.out.println(s);
    
    vs.allocateParticipants("C5");
    
    
    
    
    
    
    
    
    }
}
