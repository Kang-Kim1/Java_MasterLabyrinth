package objects;

import java.awt.Color;
import java.util.ArrayList;

public class Player {

	int _location[];
	public void set_location(int[] _location) {
		this._location = _location;
	}

	Color _color;
	ArrayList<Integer> _collectedToken;

	public Player(Color c, int[] location) {
		this._color = c;
		this._location = location;
		_collectedToken = new ArrayList<>();
	}

	public int[] get_location() {
		return _location;
	}

	public Color get_color() {
		return _color;
	}

	public void set_color(Color _color) {
		this._color = _color;
	}

	public ArrayList<Integer> get_collectedToken() {
		return _collectedToken;
	}

	public void set_collectedToken(ArrayList<Integer> _collectedToken) {
		this._collectedToken = _collectedToken;
	}
}