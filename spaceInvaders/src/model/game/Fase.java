package model.game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Fase extends JPanel implements ActionListener{
	
	private Image fundo;
	private Timer timer;
//associação da classe player como atributo na classe fase
	private Player player;
	
	

//construtor que vai definir o background da fase
	public Fase() {
		setFocusable(true);
		setDoubleBuffered(true);
		
//objeto do tipo ImageIcon sendo instanciado, recebendo como argumento o caminho para o arquivo contendo o plano de fundo da fase.
		ImageIcon referencia = new ImageIcon("/home/vini/Documentos/spaceInvaders/spaceInvaders/res/Background.png");
//atributo imagem recebendo o objeto do tipo ImageIcon utilizando o método  getImage();
		fundo = referencia.getImage();
		
		player = new Player();
		player.load();
		
		addKeyListener(new TecladoAdapter());
		
//velocidade do jogo
		timer = new Timer(5, this);
		timer.start();
	}
	
	public void paint(Graphics g) {
		Graphics2D graficos = (Graphics2D) g;
		graficos.drawImage(fundo, 0, 0, null);
		graficos.drawImage(player.getImagem(), player.getX(), player.getY(), this);
		g.dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		player.update();
		repaint();
	}
	
	private class TecladoAdapter extends KeyAdapter {
		
		@Override
		public void keyPressed(KeyEvent e) {
			player.keyPressed(e);
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			player.keyRelease(e);
		}
	}
}
