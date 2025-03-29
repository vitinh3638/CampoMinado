package victor.campoMinado.view;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import victor.campoMinado.logic.BotaoMenu;

@SuppressWarnings("serial")
public class BotaoMenuView extends JButton 
implements MouseListener {
	
	private final Color BG_padrao = new Color(180,180,180);
	private final BotaoMenu botao;
	
	public BotaoMenuView(BotaoMenu B, Menu M) {
		this.botao = B;
		setBackground(BG_padrao);
		switch(B.meuEvento) {
		case MAIS10L:
			setText("+10 L");
			break;
		case MAIS10C:
			setText("+10 C");
			break;
		case MAIS10M:
			setText("+10 M");
			break; 
		case MAIS1L:
			setText("+1 L");
			break;
		case MAIS1C:
			setText("+1 C");
			break;
		case MAIS1M:
			setText("+1 M");
			break; 
		case MENOS10L:
			setText("-10 L");
			break;
		case MENOS10C:
			setText("-10 C");
			break;
		case MENOS10M:
			setText("-10 M");
			break; 
		case MENOS1L:
			setText("-1 L");
			break;
		case MENOS1C:
			setText("-1 C");
			break;
		case MENOS1M:
			setText("-1 M");
			break; 
		case REINICIO:
			setText("REINICIAR");
			setBackground(new Color(200,200,200));
			break;
		}
		setBorder(BorderFactory.createBevelBorder(0));
		addMouseListener(this);
		this.botao.registrarObservador(M);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		botao.CliqueMouse();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub	
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub	
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub	
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub	
	}
}
