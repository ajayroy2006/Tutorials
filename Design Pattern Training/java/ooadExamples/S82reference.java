class MainApp {
	String faxNo;
	void main() {
		FaxMachine faxMachine = new FaxMachine(faxNo);
		faxMachine.sendFax("783675", "hello");
	}
}
class FaxMachine {
	String stationId;
	FaxMachine(String stationId) {
		this.stationId = stationId;
	}
	void sendFax(String toFaxNo, String msg) {
		FaxMachineHardware hardware = ...;
		hardware.setStationId(stationId);
		hardware.setRecipientFaxNo(toFaxNo);
		hardware.start();
		try {
			do {
				Graphics graphics = hardware.newPage();
				//draw the msg into the graphics.
			} while (more page is needed);
		} finally {
			hardware.done();
		}
	}
}