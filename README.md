# PacketForger

A program to forge packets.

## How to create a packet?

    PacketForgerBuilder packet = new PacketForgerBuilder();
    packet.setProtocol("udp");
    packet.setSourceIp("12.2.3.4");
    packet.setDestinationIp("127.0.0.1");
    packet.setSourcePort(37);
    packet.setDestinationPort(200);
    packet.setContent("heher his ___sher_");
    packet.forge();

## How to output a packet?

In hexadecimal representation:

    packet.hexoutput();

In raw data:

    packet.output();

In VHDL:

    packet.vhdloutput();

## Contact

    David Carnot
    dc386@kent.ac.uk

    Jean-Charles Le Goff
    jcl28@kent.ac.uk

    Valentin Briand
    vb86@kent.ac.uk

    Michael Bishaey
    mb551@kent.ac.uk