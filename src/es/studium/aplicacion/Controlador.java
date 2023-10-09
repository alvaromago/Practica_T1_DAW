package es.studium.aplicacion;

import java.awt.Image;
import java.awt.Toolkit;
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
			this.modelo.anterior();
		}
		if(e.getSource().equals(this.vista.btnSiguiente)) {
			this.modelo.siguiente();
		}
		
		this.modelo.rellenarTitulo(this.vista.txtTitulo);
		this.modelo.rellenarGenero(this.vista.txtGenero);
		this.modelo.rellenarFecha(this.vista.txtFecha);
		this.modelo.rellenarDirector(this.vista.txtDirector);
		this.modelo.rellenarReparto(this.vista.txaReparto);
		this.modelo.rellenarArgumento(this.vista.txaArgumento);
		
		String cambiarCaratula = this.modelo.rellenarCaratula();
		String nuevaCaratula = "./images/" + cambiarCaratula;
		Image imagen = Toolkit.getDefaultToolkit().getImage(nuevaCaratula);
		this.vista.actualizarCaratula(imagen);
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
