  import org.pcap4j.core.*;
import org.pcap4j.packet.Packet;

import java.util.List;

public class PacketAnalyzer {

    public static void main(String[] args) {
        try {

            // Get all network interfaces
            List<PcapNetworkInterface> interfaces = Pcaps.findAllDevs();

            if (interfaces == null || interfaces.isEmpty()) {
                System.out.println("No network interfaces found.");
                return;
            }

            System.out.println("Available Network Interfaces:");
            for (int i = 0; i < interfaces.size(); i++) {
                System.out.println(i + " : " + interfaces.get(i).getName());
            }

            // Select first interface
            PcapNetworkInterface device = null;

for (PcapNetworkInterface nif : interfaces) {
    if (nif.getAddresses() != null && !nif.getAddresses().isEmpty()) {
        for (PcapAddress addr : nif.getAddresses()) {
            if (addr.getAddress() != null 
                && addr.getAddress().getHostAddress().startsWith("192.")) {
                device = nif;
                break;
            }
        }
    }
    if (device != null) break;
}

if (device == null) {
    System.out.println("No active IPv4 interface found.");
    return;
}

System.out.println("Using interface: " + device.getName());
            int snapLen = 65536;
            PcapNetworkInterface.PromiscuousMode mode =
                    PcapNetworkInterface.PromiscuousMode.PROMISCUOUS;
            int timeout = 10;

            PcapHandle handle = device.openLive(snapLen, mode, timeout);

            System.out.println("\nCapturing 10 packets...\n");

            PacketListener listener = new PacketListener() {
                @Override
                public void gotPacket(Packet packet) {
                    System.out.println(packet);
                }
            };

            handle.loop(-1, listener); 
            handle.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}