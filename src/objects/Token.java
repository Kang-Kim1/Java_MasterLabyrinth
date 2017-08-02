package objects;

import java.awt.Color;
import java.awt.color.*;
import java.util.Random;

public class Token {

	int _number;
	boolean _collected;
	boolean _visible;
	boolean _facedown;
	int[] _location; // Tile.getLocation()

	public Token(int[] location, Integer integer) {
		this._collected = false;

		this._location = location;

	}

	public void flipToken() { // flip it to opposite boolean value
		if (this._facedown == true) {
			this._facedown = false;
		} else {
			this._facedown = true;
		}

	}

	public void setNumber() {
		// set the number label on the token -Kang
		// set as random number ( 1 - 20, 25)
		// Random r = new Random(20);
		// int a = 25;
		// // and array of numbers kang

		// Random a = new Random();
		// _number = aa[a.nextInt(aa.length)];//picks a random number from the
		// array and set it as the token number.
		// Jerry

	}

	public void setColor() {
		// set the color of the token

		// _visible = Color.WHITE;
		// _collected = Color.GRAY;
		// -Kevin
	}

	public int setLocation(int l) {
		int location = l;
		// get a location from Tile object.
		// location is each tile except for edges and initial player
		// locations-Keng
		return location;
	}

	public void setNumber(Integer number) {
		this._number = number;
	}

	public Integer getNumber() {
		return this._number;
	}
}