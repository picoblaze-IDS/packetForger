package packetforger;

/**
 *
 * @author jc
 */
public class PacketForger {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PacketForgerBuilder packet = new PacketForgerBuilder();
        packet.setProtocol("tcp");
        packet.setSourceIp("173.194.66.94");
        packet.setDestinationIp("129.12.219.126");
        packet.setSourcePort(9977);
        packet.setDestinationPort(41439);
        packet.setContent("test1testhesheAAA");
        packet.forge();
        
        //packet.hexoutput();
        packet.output();
    }
}
