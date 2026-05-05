# Java Packet Analyzer

A real-time network packet analyzer built in Java using the Pcap4J library.  
This project captures live network traffic and analyzes packets across multiple layers of the OSI model, providing insights into IP communication and transport protocols.

---

## 🚀 Features

- 📡 Live packet capture using Npcap/Pcap4J
- 🌐 IPv4 and IPv6 packet analysis
- 🔍 Protocol identification (TCP, UDP, ICMP)
- 🔢 Source and destination IP extraction
- 🔌 Port number analysis for TCP/UDP
- 📊 Real-time packet statistics tracking
- ⚡ Efficient packet processing with low latency

---

## 🧠 How It Works

The analyzer captures packets directly from the network interface using Npcap.  
Each packet is parsed to extract:

- Network layer information (IP headers)
- Transport layer details (TCP/UDP/ICMP)
- Source and destination endpoints

The system processes packets in real-time and continuously updates protocol statistics.

---

## 🛠 Tech Stack

- **Language:** Java
- **Library:** Pcap4J
- **Driver:** Npcap (Windows packet capture driver)

---

## ⚙️ Setup & Installation

1. Install Npcap:
   https://nmap.org/npcap/

2. Clone the repository:
   ```bash
   git clone https://github.com/your-username/java-packet-analyzer.git
