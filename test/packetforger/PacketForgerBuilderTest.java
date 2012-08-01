/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package packetforger;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author 4m0ni4c
 */
public class PacketForgerBuilderTest {
    
    public PacketForgerBuilderTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of forge method, of class PacketForgerBuilder.
     */
    @Test
    public void testForge() {
        System.out.println("forge");
        PacketForgerBuilder instance = new PacketForgerBuilder();
        instance.setProtocol("udp");
        instance.setSourceIp("12.2.3.4");
        instance.setDestinationIp("127.0.0.1");
        instance.setSourcePort(37);
        instance.setDestinationPort(200);
        instance.setContent("heher his ___sher_");
        instance.forge();
    }

    /**
     * Test of setProtocol method, of class PacketForgerBuilder.
     */
    @Test
    public void testSetProtocol() {
        System.out.println("setProtocol");
        String protocol = "udp";
        PacketForgerBuilder instance = new PacketForgerBuilder();
        instance.setProtocol(protocol);
    }

    /**
     * Test of setSourceIp method, of class PacketForgerBuilder.
     */
    @Test
    public void testSetSourceIp() {
        System.out.println("setSourceIp");
        String sourceIp = "1.2.3.4";
        PacketForgerBuilder instance = new PacketForgerBuilder();
        instance.setSourceIp(sourceIp);
    }

    /**
     * Test of setDestinationIp method, of class PacketForgerBuilder.
     */
    @Test
    public void testSetDestinationIp() {
        System.out.println("setDestinationIp");
        String destIp = "4.5.6.7";
        PacketForgerBuilder instance = new PacketForgerBuilder();
        instance.setDestinationIp(destIp);
    }

    /**
     * Test of setSourcePort method, of class PacketForgerBuilder.
     */
    @Test
    public void testSetSourcePort() {
        System.out.println("setSourcePort");
        int sourcePort = 0;
        PacketForgerBuilder instance = new PacketForgerBuilder();
        instance.setSourcePort(sourcePort);
    }

    /**
     * Test of setDestinationPort method, of class PacketForgerBuilder.
     */
    @Test
    public void testSetDestinationPort() {
        System.out.println("setDestinationPort");
        int destPort = 0;
        PacketForgerBuilder instance = new PacketForgerBuilder();
        instance.setDestinationPort(destPort);
    }

    /**
     * Test of setContent method, of class PacketForgerBuilder.
     */
    @Test
    public void testSetContent() {
        System.out.println("setContent");
        String content = "";
        PacketForgerBuilder instance = new PacketForgerBuilder();
        instance.setContent(content);
    }

    /**
     * Test of output method, of class PacketForgerBuilder.
     */
    @Test
    public void testOutput() {
        System.out.println("output");
        PacketForgerBuilder instance = new PacketForgerBuilder();
        instance.output();
    }

    /**
     * Test of hexoutput method, of class PacketForgerBuilder.
     */
    @Test
    public void testHexoutput() {
        System.out.println("hexoutput");
        PacketForgerBuilder instance = new PacketForgerBuilder();
        instance.hexoutput();
    }

    /**
     * Test of vhdloutput method, of class PacketForgerBuilder.
     */
    @Test
    public void testVhdloutput() {
        System.out.println("vhdloutput");
        PacketForgerBuilder instance = new PacketForgerBuilder();
        instance.setProtocol("udp");
        instance.setSourceIp("12.2.3.4");
        instance.setDestinationIp("127.0.0.1");
        instance.setSourcePort(37);
        instance.setDestinationPort(200);
        instance.setContent("heher his ___sher_");
        instance.forge();
        instance.vhdloutput();
    }

    /**
     * Test of save method, of class PacketForgerBuilder.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        PacketForgerBuilder instance = new PacketForgerBuilder();
        instance.save();
    }
}
