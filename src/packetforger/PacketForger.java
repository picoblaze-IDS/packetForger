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
        packet.setProtocol("udp");
        packet.setSourceIp("12.2.3.4");
        packet.setDestinationIp("127.0.0.1");
        packet.setSourcePort(37);
        packet.setDestinationPort(200);
        packet.setContent("heher his ___sher_");
        packet.forge();
        
        //packet.hexoutput();
        //packet.output();
        //packet.vhdloutput();
    }
}
