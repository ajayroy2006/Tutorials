/* This application lets the network administrators document their 
 * server configurations.
 * Originally we had a simple Server class as shown in the code:
 */
class Server {
    String name;
    String CPUModel;
    int RAMSizeInMB;
    int diskSizeInMB;
    InetAddress ipAddress;
}
class ServerConfigSystem {
    Server servers[];
}
/* Now, there are four new requirements. You are required to implement 
 * these requirements without modifying the Server class:
 * 1. An administrator (identified by an admin ID) can be assigned 
 *    to be responsible for a server.
 * 2. We can check if a server is a DHCP server or not. If yes, 
 *    we can record the address scope it manages 
 *    (e.g., from 192.168.0.21 to 192.168.0.254).
 * 3. We can check if a server is a file server or not. If yes, we can 
 *    set and check the disk space quota allocated for each user 
 *    (identified by a user ID).
 * 4. A server can be a DHCP server and a file server at the same time.
 */