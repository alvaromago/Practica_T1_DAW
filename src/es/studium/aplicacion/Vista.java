package es.studium.aplicacion;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;

public class Vista extends Frame {
	private static final long serialVersionUID = 1L;
	Label lblTitulo = new Label("Título: ");
    Label lblFecha = new Label("Fecha: ");
    Label lblReparto = new Label("Reparto: ");
    Label lblDirector = new Label("Director: ");
    Label lblArgumento = new Label("Argumento: ");
    Label lblGenero = new Label("Género: ");
    TextField txtTitulo = new TextField();
    TextField txtFecha = new TextField();
    TextField txtDirector = new TextField();
    TextField txtGenero = new TextField();
    TextArea txaArgumento = new TextArea();
    TextArea txaReparto = new TextArea();
    Button btnAnterior = new Button("Anterior");
    Button btnSiguiente = new Button("Siguiente");
    Image caratula;
    Modelo m = new Modelo();
    Panel panelImagen;
    
    public Vista() {
    	
    	setTitle("Aplicación de Películas");
    	setSize(600, 400);

        // Panel principal con GridLayout
        Panel panelPrincipal = new Panel(new GridLayout(1, 2));

        caratula = Toolkit.getDefaultToolkit().getImage("./images/" + m.rellenarCaratula());
        // Panel izquierdo para la carátula
        panelImagen = new Panel(new BorderLayout()){
			private static final long serialVersionUID = 1L;
			public void paint(Graphics g) {
				g.drawImage(caratula, 10, 20, 300, 300, this);
			}
        };
        panelImagen.repaint();
        
        // Panel derecho para la información de la película
        Panel panelInfo = new Panel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panelInfo.add(lblTitulo, gbc);

        m.rellenarTitulo(txtTitulo);
        txtTitulo.setEditable(false);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelInfo.add(txtTitulo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        panelInfo.add(lblGenero, gbc);
        
        m.rellenarGenero(txtGenero);
        txtGenero.setEditable(false);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelInfo.add(txtGenero, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        panelInfo.add(lblFecha, gbc);
        
        m.rellenarFecha(txtFecha);
        txtFecha.setEditable(false);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelInfo.add(txtFecha, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        panelInfo.add(lblDirector, gbc);

        m.rellenarDirector(txtDirector);
        txtDirector.setEditable(false);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelInfo.add(txtDirector, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        panelInfo.add(lblReparto, gbc);

        m.rellenarReparto(txaReparto);
        txaReparto.setEditable(false);
        txaReparto.setColumns(20);
        txaReparto.setRows(3);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        panelInfo.add(txaReparto, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        panelInfo.add(lblArgumento, gbc);

        m.rellenarArgumento(txaArgumento);
        txaArgumento.setEditable(false);
        txaArgumento.setColumns(20);
        txaArgumento.setRows(3);
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        panelInfo.add(txaArgumento, gbc);
        

        // Panel inferior para los botones de navegación
        Panel panelBotones = new Panel(new FlowLayout());
        panelBotones.add(btnAnterior);
        panelBotones.add(btnSiguiente);

        panelPrincipal.add(panelImagen);
        panelPrincipal.add(panelInfo);

        add(panelPrincipal, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void actualizarCaratula(Image nuevaCaratula) {
        this.caratula = nuevaCaratula;
        panelImagen.repaint();
    }
}
