class Board {
    //...
    class Piece {
        //...
        String representation;
    }
	class Location {
		//...
		Piece current;
	}
	String boardRepresentation() {
		StringBuffer buf = new StringBuffer();
		for(Location l : squares())
			buf.append(l.current.representation.substring(0, 1));
		return buf.toString();
	}
}
