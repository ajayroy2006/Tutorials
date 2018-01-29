class Board {
    //...
    class Piece {
        //...
        String representation;
		String character() {
			return representation.substring(0, 1);
		}
		void addTo(StringBuffer buf) {
			buf.append(character());
		}
	}
	class Location {
		//...
		Piece current;
		void addTo(StringBuffer buf) {
			current.addTo(buf);
		}
	}
	String boardRepresentation() {
		StringBuffer buf = new StringBuffer();
		for(Location l : squares())
			l.addTo(buf);
		return buf.toString();
	}
}
