package es.studium.aplicacion;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.Toolkit;

public class Vista extends Frame {
	private static final long serialVersionUID = 1L;
	TextArea txaInfo = new TextArea("Información", 10, 30);
	Button btnAnterior = new Button("Anterior");
	Button btnSiguiente = new Button("Siguiente");
	Image caratula;
	Toolkit herramienta;
	
	Vista() {
		setSize(350, 350);
		setTitle("Pelis");
		herramienta = getToolkit();
		setLayout(new GridLayout(2,2));
		add(txaInfo);
		txaInfo.setEditable(false);
		this.add(btnAnterior);
		this.add(btnSiguiente);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
}
