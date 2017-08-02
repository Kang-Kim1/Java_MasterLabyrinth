package gui;

// movement = 4 more buttons
// shift = 12 more buttons
// score 
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import objects.Board;
import objects.Observer;
import objects.Tile;

public class MasterLabyrinthGUI implements Runnable, Observer {

	private JFrame _controlFrame;
	private Board _model;
	private JPanel _boardPanel;
	private JFrame _mainFrame;
	// private JButton _rotateBtn;
	private JLabel _unplacedTileLabel;

	public MasterLabyrinthGUI(Board model) {
		this._model = model;

	}

	@Override
	public void run() {
		_mainFrame = new JFrame("Master Labyrinth");
		_mainFrame.setLayout(new BorderLayout());
		_mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_mainFrame.getContentPane().setLayout(new FlowLayout());
		_mainFrame.setFocusable(true);
		_mainFrame.setFocusTraversalKeysEnabled(false);

		_controlFrame = new JFrame("Controler");
		_controlFrame.setLayout(new BorderLayout());
		_controlFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_controlFrame.setVisible(true);

		// key handler
		createAndPopulateBoard();
		_mainFrame.setVisible(true);

	}

	public void createAndPopulateBoard() {
		_boardPanel = new JPanel();

		JPanel rightPan = new JPanel();// for 12 shift buttons
		rightPan.setLayout(new GridLayout(4, 4));

		int[][] shiftableLoc = { { 0, 1 }, { 0, 3 }, { 0, 5 }, { 1, 0 },
				{ 3, 0 }, { 5, 0 }, { 6, 1 }, { 6, 3 }, { 6, 5 }, { 1, 6 },
				{ 3, 6 }, { 5, 6 } };

		for (int i = 0; i < shiftableLoc.length; i++) {
			JButton shiftBtn = new JButton(shiftableLoc[i][0] + ","
					+ shiftableLoc[i][1]);
			rightPan.add(shiftBtn);

			shiftBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// row / col

					_model.pushTiles(
							Integer.parseInt("" + shiftBtn.getText().charAt(0)),
							Integer.parseInt("" + shiftBtn.getText().charAt(2)));
					update();
				}

			});
		}
		// rightPan.add{new JButton{}};

		JPanel leftPan = new JPanel();

		leftPan.setToolTipText("빠");
		leftPan.setLayout(new GridLayout(3, 1));
		JLabel unplacedText = new JLabel("[ Unplaced Tile ]",
				SwingConstants.CENTER);
		unplacedText.setFont(new Font("Serif", Font.BOLD, 20));
		_unplacedTileLabel = new JLabel(new ImageIcon(), SwingConstants.CENTER);
		// _unplacedTileLabel.setIcon(_model.get_unplacedTile().get_image());
		_unplacedTileLabel.setBorder(new TitledBorder(""));
		
		_unplacedTileLabel.setFont(new Font("Serif", Font.BOLD, 60));

		JButton rotateBtn = new JButton("rotate");
		rotateBtn.setFont(new Font("Serif", Font.BOLD, 10));
		leftPan.add(rotateBtn);
		rotateBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_model.get_unplacedTile().rotateClockWise();
				update();
			}
		});

		_boardPanel.setLayout(new GridLayout(Board.ROW, Board.COL));
		leftPan.add(unplacedText);
		leftPan.add(_unplacedTileLabel);
		leftPan.add(rotateBtn);

		// _mainFrame.add(rightPan, "East");
		// _mainFrame.add(leftPan, "North");
		_controlFrame.add(rightPan, "East");
		_controlFrame.add(leftPan, "North");
		_mainFrame.add(_boardPanel, "Center");

		for (int c = 0; c < Board.COL; c++) {
			for (int r = 0; r < Board.ROW; r++) {
				JButton b = new JButton("");
				b.setOpaque(true);
				b.setFocusable(false);
				b.setPreferredSize(new Dimension(70, 70));
				b.setFont(b.getFont().deriveFont(Font.BOLD,
						b.getFont().getSize() * 4));
				_boardPanel.add(b);
			}
		}
		update();
	}

	@Override
	public void update() {
		_unplacedTileLabel.setText(_model.get_unplacedTile().get_tileShape()
				+ "");
		// _unplacedTileLabel.setIcon(_model.get_unplacedTile().get_image());
		for (int c = 0; c < Board.COL; c++) {
			for (int r = 0; r < Board.ROW; r++) {

				Tile pickedTile = _model.get_tileAL().get(c).get(r);
				JButton b = (JButton) _boardPanel.getComponent(r * Board.COL
						+ c);
				if (pickedTile.is_hasPlayerOnIt()) {
					for (int i = 0; i < pickedTile.getPlayersOnIt().size(); i++) {
						JLabel playerLabel = new JLabel("P");
						playerLabel.setForeground(pickedTile.getPlayersOnIt()
								.get(i).get_color());
						playerLabel.setFont(new Font("Sherif", Font.BOLD, 20));
						b.add(playerLabel, SwingConstants.HORIZONTAL);
					}
				}
				b.setIcon(pickedTile.get_image());
				// ImageIcon i = pickImage(pickedTile.get_tileShape());
				// b.setIcon(i);
				// ImageIcon i = pickImage(pickedTile.get_tileShape());
				// b.setIcon(i);

				// JButton a2 = new JButton();
				// JButton a3 = new JButton();
				// JPanel p = new JPanel();

				// ImageIcon i = new ImageIcon("images/─.jpg");
				// b.setIcon(i);

				// ImageIcon i = pickImage(pickedTile.get_tileShape());
				// b.setIcon(i);
				//
				//
				// a.setIcon(i);
				// a2.setIcon(i);
				// a3.setIcon(i);
				// p.add(a);
				// p.add(a2);
				// b.setIcon(pickImage(pickedTile.get_tileShape()));
			}
			// _window.pack();
			_mainFrame.pack();
			_controlFrame.pack();
			_mainFrame.repaint(); // make sure board is updated visually

		}
	}
}
