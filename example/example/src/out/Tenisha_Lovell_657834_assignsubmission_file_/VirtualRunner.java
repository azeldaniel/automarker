package out.Tenisha_Lovell_657834_assignsubmission_file_;
public class VirtualRunner
{

public static void main(String[] args){
  VirtualMeetingSystem vms = new VirtualMeetingSystem("Hello Vr");
  vms.loadParticipantData("participant.dat");   
  vms.createVirtualRoom("Workshop");
  vms.allocateParticipants("C5");
  //vms.test();
}



}
