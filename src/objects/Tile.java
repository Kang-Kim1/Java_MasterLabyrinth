package objects;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Tile {

	private boolean _isOnTheBoard;
	private ArrayList<Boolean> _openedSide; // NESW

	private char _tileShape;
	private int[] _location; // tile index, if not on the board[100,100]
	private boolean _hasPlayerOnIt;
	private boolean _hasTokenOnIt;
	private ArrayList<Player> _playersOnIt;
	private Token _token;

	private ImageIcon _image;

	// private ArrayList<Tile> connectedTile; // add connected tiles to this
	// tile

	// 0 = N / 1 = E / 2 = S / 3 = W
	// ─ │ ┬ ┤ ┣ <- will use this kinds of letters.
	public Tile(int[] location, char ch) {
		this._isOnTheBoard = true;
		// this._location = new int[2];
		this._location = location;
		this._isOnTheBoard = true;
		this._tileShape = ch;
		this._openedSide = new ArrayList<Boolean>();
		setUpOpenedSide(_tileShape);
		this._playersOnIt = new ArrayList<Player>();
		this._image = new ImageIcon("images/" + _tileShape + ".jpg");
	}

	public void rotateClockWise() {
		Boolean temp = _openedSide.remove(_openedSide.size() - 1);
		_openedSide.add(0, temp);

		switch (_tileShape) {
		case '─':
			_tileShape = '│';
			break;
		case '│':
			_tileShape = '─';
			break;
		case '┌':
			_tileShape = '┐';
			break;
		case '┐':
			_tileShape = '┘';
			break;
		case '└':
			_tileShape = '┌';
			break;
		case '┘':
			_tileShape = '└';
			break;
		case '┬':
			_tileShape = '┤';
			break;
		case '├':
			_tileShape = '┬';
			break;
		case '┴':
			_tileShape = '├';
			break;
		case '┤':
			_tileShape = '┴';
			break;
		}

	}

	public void set_token(Token _token) {
		this._token = _token;
	}

	public ArrayList<Player> getPlayersOnIt() {
		return this._playersOnIt;
	}

	public void placePlayerOnTile(Player p) {
		_playersOnIt.add(p);
	}

	public void set_isOnTheBoard(boolean _isOnTheBoard) {
		this._isOnTheBoard = _isOnTheBoard;
	}

	public ArrayList<Boolean> setUpOpenedSide(char shape) {
		boolean[] openedSide = new boolean[4];

		switch (shape) {
		case '─': // 북동남서

			_openedSide.add(0, false);
			_openedSide.add(1, true);
			_openedSide.add(2, false);
			_openedSide.add(3, true);
			break;

		case '│':
			_openedSide.add(0, true);
			_openedSide.add(1, false);
			_openedSide.add(2, true);
			_openedSide.add(3, false);
			break;

		case '┴':
			// 0 = N / 1 = E / 2 = S / 3 = W
			_openedSide.add(0, true);
			_openedSide.add(1, true);
			_openedSide.add(2, true);
			_openedSide.add(3, false);
			break;

		case '┤':
			_openedSide.add(0, true);
			_openedSide.add(1, false);
			_openedSide.add(2, true);
			_openedSide.add(3, true);
			break;

		case '├':
			_openedSide.add(0, true);
			_openedSide.add(1, true);
			_openedSide.add(2, true);
			_openedSide.add(3, false);
			break;

		case '┬':
			_openedSide.add(0, false);
			_openedSide.add(1, true);
			_openedSide.add(2, true);
			_openedSide.add(3, true);

			break;

		case '┐':
			_openedSide.add(0, false);
			_openedSide.add(1, false);
			_openedSide.add(2, true);
			_openedSide.add(3, true);
			break;

		case '┘':
			_openedSide.add(0, true);
			_openedSide.add(1, false);
			_openedSide.add(2, false);
			_openedSide.add(3, true);

			break;

		case '┌':
			_openedSide.add(0, false);
			_openedSide.add(1, true);
			_openedSide.add(2, true);
			_openedSide.add(3, false);
			break;

		case '└':
			// 0 = N / 1 = E / 2 = S / 3 = W
			_openedSide.add(0, true);
			_openedSide.add(1, true);
			_openedSide.add(2, false);
			_openedSide.add(3, false);
			break;

		}
		return _openedSide;
	}

	// private char Character(int j) {
	// return 0;
	// }

	public char get_tileShape() {// get the shape of the tile, - kang
		return _tileShape;
	}

	public void set_tileShape(char _tileShape) {// set the shape of the tile -
												// kang
		this._tileShape = _tileShape;
	}

	// public int get_location() {
	// return _location;
	// }

	// public void set_location(int col, int row) {
	// this._location = ;
	// }

	public boolean is_hasPlayerOnIt() {
		return _hasPlayerOnIt;
	}

	public void set_hasPlayerOnIt(boolean _hasPlayerOnIt) {
		this._hasPlayerOnIt = _hasPlayerOnIt;
	}

	public boolean is_hasTokenOnIt() {
		return _hasTokenOnIt;
	}

	public void set_hasTokenOnIt(boolean _hasTokenOnIt) {
		this._hasTokenOnIt = _hasTokenOnIt;
	}

	public ImageIcon get_image() {
		return _image;
	}

	public Token get_token() {
		return _token;
	}
	public ArrayList<Boolean> get_openedSide() {
		return _openedSide;
	}

	public void set_openedSide(ArrayList<Boolean> _openedSide) {
		this._openedSide = _openedSide;
	}

}