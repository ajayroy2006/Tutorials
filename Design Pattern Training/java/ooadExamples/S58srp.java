class Server {
	String name;
	String CPUModel;
	int RAMSizeInMB;
	int diskSizeInMB;
	InetAddress ipAddress;
}
class Administrator {
	String adminId;
	Server serversAdminedByHim[];
}
class DHCPConfig {
	InetAddress startIP;
	InetAddress endIP;
}
class FileServerConfig {
	HashMap userIdToQuota;
	int getQuotaForUser(String userId) {
		...
	}
	void setQuotaForUser(String userId, int quota) {
		...
	}
}
class ServerConfigSystem {
	Server servers[];
	Administrator admins[];
	HashMap<Server,DHCPConfig> DHCPservers;
	HashMap<Server,FileServerConfig> FileServers;
}
