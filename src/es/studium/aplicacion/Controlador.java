package es.studium.aplicacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Controlador implements WindowListener, ActionListener {
	
	Modelo modelo;
	Vista vista;
	
	public Controlador(Modelo m, Vista v) {
		this.modelo = m;
		this.vista = v;
		
		this.vista.addWindowListener(this);
		this.vista.btnAnterior.addActionListener(this);
		this.vista.btnSiguiente.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(this.vista.btnAnterior)) {
			
		}
		
		if(e.getSource().equals(this.vista.btnSiguiente)) {
			
		}
	}

	public void windowOpened(WindowEvent e) {}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	public void windowClosed(WindowEvent e) {}

	public void windowIconified(WindowEvent e) {}

	public void windowDeiconified(WindowEvent e) {}

	public void windowActivated(WindowEvent e) {}

	public void windowDeactivated(WindowEvent e) {}

}
