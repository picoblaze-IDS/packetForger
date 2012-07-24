package packetforger;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author jc
 */
class PacketForgerBuilder {

    private ArrayList<Byte> data;
    private byte protocol;
    private byte[] sourceIp;
    private byte[] destIp;
    private byte[] sourcePort;
    private byte[] destPort;
    private byte[] content;
    
    private HashMap<String, Byte> protocol_number;

    public PacketForgerBuilder() {
        this.data = new ArrayList<Byte>();
        this.sourceIp = new byte[4];
        this.destIp = new byte[4];
        this.sourcePort = new byte[2];
        this.destPort = new byte[2];
        
        //http://en.wikipedia.org/wiki/List_of_IP_protocol_numbers
        this.protocol_number = new HashMap();
        this.protocol_number.put("tcp", (byte)6);
        this.protocol_number.put("udp", (byte)17);
    }
    
    
    public void forge() {
        this.forgeEthernet(); // Link layer
        this.forgeInternetProtocol(); // Internet layer
        this.forgeTransportProtocol(); // Transport layer
        this.forgeDataContent(); // Application layer
    }
    
    private void forgeEthernet() {
        // MAC Destination 6 bytes
        this.data.add((byte)0x00);
        this.data.add((byte)0x1f);
        this.data.add((byte)0x3b);
        this.data.add((byte)0xb7);
        this.data.add((byte)0xac);
        this.data.add((byte)0xf9);
        // MAC Source 6 bytes
        this.data.add((byte)0x00);
        this.data.add((byte)0x24);
        this.data.add((byte)0xf7);
        this.data.add((byte)0x3d);
        this.data.add((byte)0x6c);
        this.data.add((byte)0x00);
        // Type 2 bytes
        this.data.add((byte)0x08);
        this.data.add((byte)0x00);
    }
    
    private void forgeInternetProtocol() {
        // Version and header length
        this.data.add((byte) 0x45);
        // Differentiated  Service Field 0x00
        this.data.add((byte) 0x00);
        // Total length 2 bytes
        this.data.add((byte) 0x00);
        this.data.add((byte) 0x42);
        // Identification 2 bytes
        this.data.add((byte)0x6b);
        this.data.add((byte)0xa9);
        // Flag and fragment offset
        this.data.add((byte)0x40);
        this.data.add((byte)0x00);
        // TTL 1 byte
        this.data.add((byte)0x72);
        // Protocol 1 byte
        this.data.add(this.protocol);
        // Header checksum
        this.data.add((byte) 0x00);
        this.data.add((byte) 0x00);
        // Source Ip 4 bytes
        for (int i = 0; i < 4; i++) {
            this.data.add(this.sourceIp[i]);
        }
        // Destination Ip 4 bytes
        for (int i = 0; i < 4; i++) {
            this.data.add(this.destIp[i]);
        }
    }
    
    private void forgeTransportProtocol() {
        if (this.protocol == this.protocol_number.get("tcp")) {
            this.forgeTcp();
        } else if (this.protocol == this.protocol_number.get("udp")) {
            this.forgeUdp();
        } else {
            throw new RuntimeException("Protocol not yet supported");
        }
    }

    private void forgeTcp() {
        // Source Port 2 bytes
        for (int i = 0; i < 2; i++) {
            this.data.add(this.sourcePort[i]);
        }
        // Destination Port 2 bytes
        for (int i = 0; i < 2; i++) {
            this.data.add(this.destPort[i]);
        }
        // Sequence number 4 bytes
        this.data.add((byte) 0x0d);
        this.data.add((byte) 0x33);
        this.data.add((byte) 0x8e);
        this.data.add((byte) 0xd1);

        // Acknowledgment number 4 bytes
        this.data.add((byte) 0x87);
        this.data.add((byte) 0xcf);
        this.data.add((byte) 0x5c);
        this.data.add((byte) 0x3c);

        // Header length 1 byte
        this.data.add((byte) 0x80);

        // Flags 1 byte
        this.data.add((byte) 0x18);

        // Window size 2 bytes
        this.data.add((byte) 0x00);
        this.data.add((byte) 0xfe);

        // Checksum 2 bytes
        this.data.add((byte) 0x72);
        this.data.add((byte) 0x5d);

        this.data.add((byte) 0x00);
        this.data.add((byte) 0x00);

        //Options 12 bytes
        this.data.add((byte) 0x01);
        this.data.add((byte) 0x01);
        this.data.add((byte) 0x08);
        this.data.add((byte) 0x0a);
        this.data.add((byte) 0x04);
        this.data.add((byte) 0x4f);
        this.data.add((byte) 0x57);
        this.data.add((byte) 0xe4);
        this.data.add((byte) 0x00);
        this.data.add((byte) 0x16);
        this.data.add((byte) 0xa0);
        this.data.add((byte) 0xaa);
    }
    
    private void forgeUdp() {
        // Source Port 2 bytes
        for (int i = 0; i < 2; i++) {
            this.data.add(this.sourcePort[i]);
        }
        // Destination Port 2 bytes
        for (int i = 0; i < 2; i++) {
            this.data.add(this.destPort[i]);
        }
        // Length 2 bytes
        int datagram_length = this.content.length + 8;
        this.data.add((byte) (datagram_length >> 8));
        this.data.add((byte) (datagram_length & 255));
        // Checksum 2 bytes
        this.data.add((byte) 0x00);
        this.data.add((byte) 0x00);
    }
    
    private void forgeDataContent() {
        for (int i = 0; i < this.content.length; i++) {
            this.data.add((byte) this.content[i]);
        }
    }
    
    public void setProtocol(String protocol) {
        try {
            this.protocol = this.protocol_number.get(protocol.toLowerCase());
        } catch (Exception e) {
            throw new RuntimeException("Protocol not yet supported");
        }
    }

    public void setSourceIp(String sourceIp) {
        for (int i = 0; i < 4; i++) {
            this.sourceIp[i] = (byte) Integer.parseInt(sourceIp.split("\\.")[i]);
        }
    }

    public void setDestinationIp(String destIp) {
        for (int i = 0; i < 4; i++) {
            this.destIp[i] = (byte) Integer.parseInt(destIp.split("\\.")[i]);
        }
    }

    public void setSourcePort(int sourcePort) {
        this.sourcePort[0] = (byte) (sourcePort >> 8);
        this.sourcePort[1] = (byte) (sourcePort & 255);
    }

    public void setDestinationPort(int destPort) {
        this.destPort[0] = (byte) (destPort >> 8);
        this.destPort[1] = (byte) (destPort & 255);
    }
    
    public void setContent(String content) {
        this.content = content.getBytes();
    }

    public void output() {
        for (Byte ch : this.data) {
            System.out.write(ch);
        }
        System.out.flush();
    }
    
    public void hexoutput() {
        int i = 0;

        for (Byte ch : this.data) {
            System.out.print(String.format("0x%02x", ch) + " ");
            if ((i+1) % 16 == 0) {
                System.out.println();
            }
            i++;
        }
        System.out.flush();
    }
    
    public void save() {
        String path = "packet.txt";

        try {
            FileOutputStream fos = new FileOutputStream(path);
            for (Byte ch : this.data) {
                fos.write(ch);
            }
            fos.close();
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException : " + ex);
        } catch (IOException ioe) {
            System.out.println("IOException : " + ioe);
        }
    }
}
