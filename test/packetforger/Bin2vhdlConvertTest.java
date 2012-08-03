/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package packetforger;

import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author 4m0ni4c
 */
public class Bin2vhdlConvertTest {
    
    public Bin2vhdlConvertTest() {
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
     * Test of getVhdl method, of class Bin2vhdlConvert.
     */
    @Test
    public void testGetVhdl() {
        ArrayList<Byte> data;

        System.out.println("getVhdl");
        data = new ArrayList<Byte>();
        data.add((byte)0x00);
        data.add((byte)0x1f);
        data.add((byte)0x3b);
        data.add((byte)0xb7);
        data.add((byte)0xac);
        data.add((byte)0xf9);
        data.add((byte)0x00);
        data.add((byte)0x24);
        data.add((byte)0xf7);
        data.add((byte)0x3d);
        data.add((byte)0x6c);
        data.add((byte)0x00);
        data.add((byte)0x08);
        data.add((byte)0x00);
        data.add((byte)0x45);
        data.add((byte)0x00);
        data.add((byte)0x00);
        data.add((byte)0x42);
        data.add((byte)0x6b);
        data.add((byte)0xa9);
        data.add((byte)0x40);
        data.add((byte)0x00);
        data.add((byte)0x72);
        data.add((byte)0x11);
        data.add((byte)0x00);
        data.add((byte)0x00);
        data.add((byte)0x0c);
        data.add((byte)0x02);
        data.add((byte)0x03);
        data.add((byte)0x04);
        data.add((byte)0x7f);
        data.add((byte)0x00);
        data.add((byte)0x00);
        data.add((byte)0x01);
        data.add((byte)0x00);
        data.add((byte)0x25);
        data.add((byte)0x00);
        data.add((byte)0xc8);
        data.add((byte)0x00);
        data.add((byte)0x1a);
        data.add((byte)0x00);
        data.add((byte)0x00);
        data.add((byte)0x68);
        data.add((byte)0x65);
        data.add((byte)0x68);
        data.add((byte)0x65);
        data.add((byte)0x72);
        data.add((byte)0x20);
        data.add((byte)0x68);
        data.add((byte)0x69);
        data.add((byte)0x73);
        data.add((byte)0x20);
        data.add((byte)0x5f);
        data.add((byte)0x5f);
        data.add((byte)0x5f);
        data.add((byte)0x73);
        data.add((byte)0x68);
        data.add((byte)0x65);
        data.add((byte)0x72);
        data.add((byte)0x5f);
        
        Bin2vhdlConvert instance = new Bin2vhdlConvert(data);
        String expResult = "INIT_00 => X\"007F0403020C000011720040A96B420000450008006C3DF72400F9ACB73B1F00\","
                + "\nINIT_01 => X\"000000005F726568735F5F5F2073696820726568656800001A00C80025000100\"";
        String result = instance.getVhdl();
        assertEquals(expResult, result);
    }
}
