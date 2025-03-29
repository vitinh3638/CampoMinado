package victor.campoMinado.view;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import victor.campoMinado.logic.Campo;
import victor.campoMinado.logic.CampoEvento;
import victor.campoMinado.logic.CampoObserver;

@SuppressWarnings("serial")
public class BotaoCampo extends JButton 
implements CampoObserver, MouseListener {
	private final Color BG_padrao = new Color(74,74,74);
	private final Color BG_aberto = new Color(200,200,200);
	private final Color BG_marcado = new Color(20,20,255);
	private final Color BG_explodido = new Color(255,0,0);
	
	private Campo campo;
	
	public BotaoCampo(Campo campo) {
		this.campo = campo;
		setBackground(BG_padrao);
		setBorder(BorderFactory.createBevelBorder(0));
		
		addMouseListener(this);
		campo.registrarObservador(this);
	}

	@Override
	public void eventoOcorreu(Campo campo, CampoEvento evento) {
		// TODO Auto-generated method stub
		switch(evento) {
		case MARCAR:
			aplicaEstiloMarcar();
			break;
		case EXPLODIR:
			aplicaEstiloExplodir();
			break;
		case ABRIR:
			aplicaEstiloAbrir();
			break; 
		default:
			aplicaEstiloPadrao();
		}
		
		
	}

	private void aplicaEstiloPadrao() {
		// TODO Auto-generated method stub
		setBackground(BG_padrao);
		setText("");
		setBorder(BorderFactory.createBevelBorder(0));		
	}

	private void aplicaEstiloExplodir() {
		// TODO Auto-generated method stub
		setBackground(BG_explodido);
		setBorder(BorderFactory.createBevelBorder(0));
	}

	private void aplicaEstiloMarcar() {
		// TODO Auto-generated method stub
		setBackground(BG_marcado);
		setBorder(BorderFactory.createBevelBorder(0));
	}

	private void aplicaEstiloAbrir() {
		// TODO Auto-generated method stub
		setBackground(BG_aberto);
		setBorder(BorderFactory.createBevelBorder(1));
		if(!campo.isMina()) {
			setText("" + campo.getMinas());
		}
	}


	public void mousePressed(MouseEvent e) {
		if(e.getButton() == 1) {
			campo.abrir();
		}
		else {
			campo.alternarMarcacao();
		}
		
	}
	
	public void mouseClicked(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	
}
