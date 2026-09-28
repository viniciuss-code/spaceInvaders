package game;

import javax.swing.JFrame;

import model.game.Fase;

public class Container extends JFrame {
	
//classe container e as definições de título, tamanho e configuração da tela.
	public Container() {
		add(new Fase());
		setTitle("Space Invaders");//define um título a tela.
		setSize(1024, 728);//define a resolução da tela.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//fecha a janela quando clicar no "x".
		setLocationRelativeTo(null);//define a janela abrir no meio da tela.
		this.setResizable(false);//impede o usuário de aumentar o tamanho da tela para full screen.
		setVisible(true);//torna a tela visível.
	}
	
	public static void main(String[] args) {
		
		new Container();
	}
}
