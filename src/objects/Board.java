package objects;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Board {
	// ㅣ = 0 + 5 + 0 + 2 + 0 + 4 + 2 + 0 = 13
	// ㄴ = 3 + 2 + 3 + 4 + 1 + 2 + 3 + 1 = 19 - 4 = 15
	// ㅗ = 4 + 0 + 4 + 1 + 6 + 1 + 2 + 0 = 18 - 12 = 6
	//
	//
	// ㅣ = 13
	// ㄴ = 15
	// ㅗ = 6

	public static int COL = 7;
	public static int ROW = COL;

	private Observer _observer;

	private ArrayList<ArrayList<Tile>> _tileAL;

	private ArrayList<Tile> _colAL;

	private Token[] _tokens; // change to ArrayList
	private Player[] _players;


	private Tile _unplacedTile;

	private ArrayList<Character> _setchar;

	private char[] _shapeArr = { '─', '│', '┌', '┐', '└', '┘', '┬', '├', '┴',
			'┤' };

	// private char[] _shapeArr = { '─', '┌', '┬' };

	public Board() {
		_observer = null;
		initializeBoard();
		initializeTiles();
		initializePlayers();
		initializeToken();
	}

	public void setObserver(Observer ob) {
		this._observer = ob;
	}

	public void gameStateUpdate() {
		if (_observer != null) {
			_observer.update();
		}
	}

	public ArrayList<ArrayList<Tile>> get_tileAL() {
		return _tileAL;
	}

	public void set_tileAL(ArrayList<ArrayList<Tile>> _tileAL) {
		this._tileAL = _tileAL;
	}

	private void initializeToken() {
		_tokens = new Token[21];
		int[][] temp = { { 1, 1 }, { 1, 2 }, { 1, 3 }, { 1, 4 }, { 1, 5 },
				{ 2, 1 }, { 2, 3 }, { 2, 5 }, { 3, 1 }, { 3, 2 }, { 3, 3 },
				{ 3, 4 }, { 3, 5 }, { 4, 1 }, { 4, 3 }, { 4, 5 }, { 5, 1 },
				{ 5, 2 }, { 5, 3 }, { 5, 4 }, { 5, 5 } };
		Integer[] tokenNums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
				15, 16, 17, 18, 19, 20, 25 };
		Collections.shuffle(Arrays.asList(tokenNums));
		for (int i = 0; i < tokenNums.length; i++) {
			_tokens[i] = new Token(temp[i], tokenNums[i]);
			_tokens[i].setNumber(tokenNums[i]);
			pickTile(temp[i][0], temp[i][1]).set_token(_tokens[i]);
			pickTile(temp[i][0], temp[i][1]).set_hasTokenOnIt(true);

		}
	}

	private Tile pickTile(int col, int row) {
		Tile pickedTile;
		pickedTile = _tileAL.get(col).get(row);
		return pickedTile;
	}

	private void initializePlayers() {
		_players = new Player[4];
		int[][] startingLocs = { { 2, 2 }, { 2, 4 }, { 4, 2 }, { 4, 4 } };
		Color[] colors = { Color.BLUE, Color.RED, Color.YELLOW, Color.GREEN };
		for (int i = 0; i < 4; i++) {
			int[] temp = startingLocs[i];
			Tile pickedTile = _tileAL.get(temp[0]).get(temp[1]);
			_players[i] = new Player(colors[i], temp);
			_tileAL.get(temp[0]).get(temp[1]).set_hasPlayerOnIt(true);
			pickedTile.placePlayerOnTile(_players[i]);
		}
	}

	public Player[] get_players() {
		return _players;
	}

	public Player get_player(int num) {
		return _players[num];
	}
	public void pushTiles(int col, int row) {
		Tile removedTile, newTile = null;

		// left to right
		if (col == 0 && row == 1) {

		} else if (col == 0 && row == 3) {

		} else if (col == 0 && row == 5) {

			// up to down
		} else if (col == 1 && row == 0) {
			_tileAL.get(col).add(0, _unplacedTile);
			set_unplacedTile(_tileAL.get(col).remove(
					_tileAL.get(col).size() - 1));
			System.out.println("pushed");

		} else if (col == 3 && row == 0) {
			_tileAL.get(col).add(0, _unplacedTile);
			set_unplacedTile(_tileAL.get(col).remove(
					_tileAL.get(col).size() - 1));
			System.out.println("pushed");

		} else if (col == 5 && row == 0) {
			_tileAL.get(col).add(0, _unplacedTile);
			set_unplacedTile(_tileAL.get(col).remove(_tileAL.get(col).size() - 1));
			System.out.println("pushed");

			// right to left
		} else if (col == 6 && row == 1) {

		} else if (col == 6 && row == 3) {

		} else if (col == 6 && row == 5) {

			// down to up
		} else if (col == 1 && row == 6) {
			_tileAL.get(col).add(_tileAL.get(col).size(), _unplacedTile);
			set_unplacedTile(_tileAL.get(col).remove(0));
			System.out.println("pushed");
		} else if (col == 3 && row == 6) {
			_tileAL.get(col).add(_tileAL.get(col).size(), _unplacedTile);
			set_unplacedTile(_tileAL.get(col).remove(0));
			System.out.println("pushed");
		} else if (col == 5 && row == 6) {
			_tileAL.get(col).add(_tileAL.get(col).size(), _unplacedTile);
			set_unplacedTile(_tileAL.get(col).remove(0));
			System.out.println("pushed");
		} else {
			System.out.println("that location can't be pushed");
		}
		// updateAddedTileInfo(temp);

	}

	private void updateAddedTileInfo(Tile temp) {
		if (temp.is_hasPlayerOnIt()) {

		}
		if (temp.is_hasTokenOnIt()) {

		}
	}

	public void unpushable() {
	}

	public void initializeBoard() {
		// this.setLayout(new GridLayout(_column, _row));
		// Makes the board, a 7x7 board. -Kang
		// and makes the player, color and set location -Obi
		_tileAL = new ArrayList<ArrayList<Tile>>();
		for (int i = 0; i < COL; i++) { // put 7 ArrayList<Tile>s
			_colAL = new ArrayList<Tile>();
			_tileAL.add(i, _colAL);
			for (int j = 0; j < ROW; j++) {
				int[] temp = { i, j };
				_tileAL.get(i).add(j, new Tile(temp, ' '));
			}
		}
	}

	public void initializeTiles() {
		int[] tempLoc = new int[2];
		// initialize fixed tiles

		tempLoc[0] = 0;
		tempLoc[1] = 0;
		_tileAL.get(tempLoc[0]).set(tempLoc[1], new Tile(tempLoc, '┌'));
		tempLoc[1] = 2;
		_tileAL.get(tempLoc[0]).set(tempLoc[1], new Tile(tempLoc, '├'));
		tempLoc[1] = 4;
		_tileAL.get(tempLoc[0]).set(tempLoc[1], new Tile(tempLoc, '├'));
		tempLoc[1] = 6;
		_tileAL.get(tempLoc[0]).set(tempLoc[1], new Tile(tempLoc, '└'));
		// fixed tiles on the top

		tempLoc[0] = 2;
		tempLoc[1] = 0;
		_tileAL.get(tempLoc[0]).set(tempLoc[1], new Tile(tempLoc, '┬'));
		tempLoc[0] = 4;
		_tileAL.get(tempLoc[0]).set(tempLoc[1], new Tile(tempLoc, '┬'));
		// fixed tiles on the center

		tempLoc[0] = 2;
		tempLoc[1] = 2;
		_tileAL.get(tempLoc[0]).set(tempLoc[1], new Tile(tempLoc, '├'));
		tempLoc[0] = 4;
		_tileAL.get(tempLoc[0]).set(tempLoc[1], new Tile(tempLoc, '┬'));
		tempLoc[0] = 4;
		tempLoc[1] = 4;
		_tileAL.get(tempLoc[0]).set(tempLoc[1], new Tile(tempLoc, '┤'));
		tempLoc[0] = 2;
		_tileAL.get(tempLoc[0]).set(tempLoc[1], new Tile(tempLoc, '┴'));
		// fixed tiles on the bottom

		tempLoc[0] = 2;
		tempLoc[1] = 6;
		_tileAL.get(tempLoc[0]).set(tempLoc[1], new Tile(tempLoc, '┴'));
		tempLoc[0] = 4;
		_tileAL.get(tempLoc[0]).set(tempLoc[1], new Tile(tempLoc, '┴'));
		// fixed tiles on the right

		tempLoc[0] = 6;
		tempLoc[1] = 0;
		_tileAL.get(tempLoc[0]).set(tempLoc[1], new Tile(tempLoc, '┐'));
		tempLoc[1] = 2;
		_tileAL.get(tempLoc[0]).set(tempLoc[1], new Tile(tempLoc, '┤'));
		tempLoc[1] = 4;
		_tileAL.get(tempLoc[0]).set(tempLoc[1], new Tile(tempLoc, '┤'));
		tempLoc[1] = 6;
		_tileAL.get(tempLoc[0]).set(tempLoc[1], new Tile(tempLoc, '┘'));
		// initialize movable tiles

		int[] counterArr = { 13, 15, 6 };
		for (int a = 0; a < COL; a++) {
			for (int b = 0; b < ROW; b++) {
				if (_tileAL.get(a).get(b).get_tileShape() == ' ') {
					Random r = new Random();
					int randomPicker = r.nextInt(3);
					if (counterArr[randomPicker] == 0) {
						while (counterArr[randomPicker] == 0) {
							randomPicker = r.nextInt(3);
						}
					}
					if (randomPicker == 0) {
						char[] shapeArr = { '─', '│' };
						Random r1 = new Random();
						int randomPicker1 = r1.nextInt(shapeArr.length);
						tempLoc[0] = a;
						tempLoc[1] = b;
						_tileAL.get(a).set(b,
								new Tile(tempLoc, shapeArr[randomPicker1]));
						counterArr[randomPicker] = counterArr[randomPicker] - 1;
					} else if (randomPicker == 1) {
						char[] shapeArr = { '┌', '┐', '└', '┘' };
						Random r1 = new Random();
						int randomPicker1 = r1.nextInt(shapeArr.length);
						tempLoc[0] = a;
						tempLoc[1] = b;
						_tileAL.get(a).set(b,
								new Tile(tempLoc, shapeArr[randomPicker1]));
						counterArr[randomPicker] = counterArr[randomPicker] - 1;
					} else if (randomPicker == 2) {
						char[] shapeArr = { '┬', '├', '┴', '┤' };
						Random r1 = new Random();
						int randomPicker1 = r1.nextInt(shapeArr.length);
						tempLoc[0] = a;
						tempLoc[1] = b;
						_tileAL.get(a).set(b,
								new Tile(tempLoc, shapeArr[randomPicker1]));
						counterArr[randomPicker] = counterArr[randomPicker] - 1;
					}
				}
			}
		}
		// set a tile out of the board
		int[] unplacedTileLoc = { 100, 100 };
		for (int i = 0; i < counterArr.length; i++) {
			if (counterArr[i] != 0) {
				switch (i) {
				case 0:
					_unplacedTile = new Tile(unplacedTileLoc, '─');
					break;
				case 1:
					_unplacedTile = new Tile(unplacedTileLoc, '┐');
					break;
				case 2:
					_unplacedTile = new Tile(unplacedTileLoc, '┬');
					break;
				}
				_unplacedTile.set_isOnTheBoard(false);
			}

		}
		System.out.println("unplaced tile : " + _unplacedTile.get_tileShape());
	}

	public Tile get_unplacedTile() {
		return _unplacedTile;
	}

	public void set_unplacedTile(Tile _unplacedTile) {
		this._unplacedTile = _unplacedTile;
		this._unplacedTile.set_hasPlayerOnIt(false);
		this._unplacedTile.set_hasTokenOnIt(false);

	}

	public Object getplayer(int _player) {
		// TODO Auto-generated method stub
		return null;
	}

	public static int getCOL() {
		return COL;
	}

	public static void setCOL(int cOL) {
		COL = cOL;
	}

	public static int getROW() {
		return ROW;
	}

	public static void setROW(int rOW) {
		ROW = rOW;
	}

	public Observer get_observer() {
		return _observer;
	}

	public void set_observer(Observer _observer) {
		this._observer = _observer;
	}

	public ArrayList<Tile> get_colAL() {
		return _colAL;
	}

	public void set_colAL(ArrayList<Tile> _colAL) {
		this._colAL = _colAL;
	}

	public Token[] get_tokens() {
		return _tokens;
	}

	public void set_tokens(Token[] _tokens) {
		this._tokens = _tokens;
	}

	public ArrayList<Character> get_setchar() {
		return _setchar;
	}

	public void set_setchar(ArrayList<Character> _setchar) {
		this._setchar = _setchar;
	}

	public char[] get_shapeArr() {
		return _shapeArr;
	}

	public void set_shapeArr(char[] _shapeArr) {
		this._shapeArr = _shapeArr;
	}

	public void set_players(Player[] _players) {
		this._players = _players;
	}
}