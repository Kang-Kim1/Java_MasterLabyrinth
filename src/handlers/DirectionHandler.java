// still working on it 

package handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import objects.Board;
import objects.Player;
import objects.Tile;

public class DirectionHandler implements ActionListener {
	private JButton _stay;
	private JButton _north;
	private JButton _east;
	private JButton _south;
	private JButton _west;
	private JButton _button;
	private Board _board;
	private int _player;
	private String _direction;

	public DirectionHandler(String button, JButton north, JButton east, JButton south, JButton west, JButton stay,
			Board board, int i) {
		_north = north;
		_east = east;
		_south = south;
		_west = west;
		_south = south;
		_stay = stay;
		_board = board;
		_player = i;
		_direction = button;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int[] location = _board.get_player(_player).get_location();
		char chup = _board.get_tileAL().get(location[0] - 1).get(location[1]).get_tileShape();
		char ch = _board.get_tileAL().get(location[0]).get(location[1]).get_tileShape();
		Tile tnorth = _board.get_tileAL().get(location[0]).get(location[1] - 1);
		Tile tsouth = _board.get_tileAL().get(location[0]).get(location[1] + 1);
		Tile twest = _board.get_tileAL().get(location[0 - 1]).get(location[1]);
		Tile teast = _board.get_tileAL().get(location[0] + 1).get(location[1]);
		Tile t = _board.get_tileAL().get(location[0]).get(location[1]);
		Player player = _board.get_player(_player);
		if (_button.getText() == "North") {
			if (tnorth.setUpOpenedSide(chup).get(2) == true && t.setUpOpenedSide(ch).get(0) == true && location[1] != 0) {
				_board.get_tileAL().get(location[0]).get(location[1] + 1).set_hasPlayerOnIt(true);
				_board.get_tileAL().get(location[0]).get(location[1]).set_hasPlayerOnIt(false);
			}
		}
		if (_button.getText() == "South") {
			if (tsouth.setUpOpenedSide(chup).get(0) == true && t.setUpOpenedSide(ch).get(2) == true && location[1] != 6) {
				_board.get_tileAL().get(location[0]).get(location[1] - 1).set_hasPlayerOnIt(true);
				_board.get_tileAL().get(location[0]).get(location[1]).set_hasPlayerOnIt(false);
			}
		}
		if (_button.getText() == "East") {
			if (teast.setUpOpenedSide(chup).get(3) == true && t.setUpOpenedSide(ch).get(1) == true && location[0] != 6) {
				_board.get_tileAL().get(location[0] + 1).get(location[1]).set_hasPlayerOnIt(true);
				_board.get_tileAL().get(location[0]).get(location[1]).set_hasPlayerOnIt(false);
			}
		}
		if (_button.getText() == "West") {
			if (twest.setUpOpenedSide(chup).get(2) == true && t.setUpOpenedSide(ch).get(0) == true && location[0] != 0) {
				_board.get_tileAL().get(location[0] - 1).get(location[1]).set_hasPlayerOnIt(true);
				_board.get_tileAL().get(location[0]).get(location[1]).set_hasPlayerOnIt(false);
			}
		} else
			System.out.println("TRY AGAIN");
	}
}