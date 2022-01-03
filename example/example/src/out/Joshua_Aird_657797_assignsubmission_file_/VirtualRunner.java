package out.Joshua_Aird_657797_assignsubmission_file_;public class VirtualRunner {
    public static void main(String[] args) {
        VirtualMeetingSystem Zoom = new VirtualMeetingSystem(); 
        Zoom.createVirtualRoom("Zoom");
        Zoom.loadParticipantData("participant.dat");
        Zoom.allocateParticipants("RR"); 
       
        if(Zoom.virtualroom.addParticipantToBreakoutRoom("12345678", 3)==false){
            System.out.println("Student cant not be added");
        }
        
        
        System.out.println(Zoom.listParticipants(0));
        System.out.println(Zoom.listParticipants(1));
        System.out.println(Zoom.listParticipants(2));
        System.out.println(Zoom.listParticipants(3));
        System.out.println(Zoom.listParticipants(4));
        
        if(Zoom.virtualroom.closeBreakoutRoom(2)==true){
            System.out.println("Room is now close");
        }
        
        System.out.println(Zoom.listParticipants(0));
        System.out.println(Zoom.listParticipants(1));
        System.out.println(Zoom.listParticipants(2));
        System.out.println(Zoom.listParticipants(3));
        System.out.println(Zoom.listParticipants(4));
        
        if(Zoom.virtualroom.openBreakoutRoom(2)==true){
            System.out.println("Room is now open");
        }
        
        Zoom.virtualroom.addParticipantToBreakoutRoom("12345678", 2);
        System.out.println(Zoom.listParticipants(2));
        
        System.out.println(Zoom.virtualroom.findParticipantBreakoutRoom("19147829"));
        
        System.out.println(Zoom.virtualroom.listBreakoutRooms());
        System.out.println(Zoom.listParticipantsInAllBreakoutRooms());
    }
}
