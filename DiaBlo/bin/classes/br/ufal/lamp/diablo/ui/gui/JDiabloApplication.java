package br.ufal.lamp.diablo.ui.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

import org.jhotdraw.contrib.MDI_DrawApplication;
import org.jhotdraw.contrib.zoom.ZoomDrawingView;
import org.jhotdraw.framework.Drawing;
import org.jhotdraw.framework.DrawingView;
import org.jhotdraw.framework.FigureEnumeration;
import org.jhotdraw.framework.Tool;
import org.jhotdraw.standard.ConnectionTool;

import br.ufal.lamp.diablo.core.Block;
import br.ufal.lamp.diablo.core.ClassTool;
import br.ufal.lamp.diablo.core.DataStreamLineConnection;
import br.ufal.lamp.diablo.core.Diagram;
import br.ufal.lamp.diablo.core.TextSelectionTool;
import br.ufal.lamp.diablo.core.block.BeginTerminal;
import br.ufal.lamp.diablo.core.block.Connector;
import br.ufal.lamp.diablo.core.block.Decision;
import br.ufal.lamp.diablo.core.block.EndTerminal;
import br.ufal.lamp.diablo.core.block.InputData;
import br.ufal.lamp.diablo.core.block.InputOutputData;
import br.ufal.lamp.diablo.core.block.OutPutDataImpress;
import br.ufal.lamp.diablo.core.block.OutputData;
import br.ufal.lamp.diablo.core.block.Processing;
import br.ufal.lamp.diablo.core.gerador.Gerador;
import br.ufal.lamp.diablo.exception.EmptyDiagramException;

public class JDiabloApplication extends MDI_DrawApplication {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2832002133056037664L;
	
	public static final String DIAGRAM_IMAGES = "/br/ufal/lamp/images/";
	private Diagram diagram;


	protected void createTools(JToolBar jb) {
		super.createTools(jb);
		Tool tool = new ConnectionTool(this, new DataStreamLineConnection());
		jb.add(createToolButton(DIAGRAM_IMAGES+"DATASTREAM", "Data Stream", tool));
		try {
			tool = new ClassTool(this, new BeginTerminal());
			jb.add(createToolButton(DIAGRAM_IMAGES+"RRECT", "Terminal Início", tool));
			tool = new ClassTool(this, new EndTerminal());
			jb.add(createToolButton(DIAGRAM_IMAGES+"RRECT", "Terminal Fim", tool));
			tool = new ClassTool(this, new Processing());
			jb.add(createToolButton(DIAGRAM_IMAGES+"RECT", "Processamento", tool));
			tool = new ClassTool(this, new InputData());
			jb.add(createToolButton(DIAGRAM_IMAGES+"INPUT", "Entrada de Dados", tool));
			tool = new ClassTool(this, new OutputData());
			jb.add(createToolButton(DIAGRAM_IMAGES+"CLASS", "Saída de Dados", tool));
			tool = new ClassTool(this, new Connector());
			jb.add(createToolButton(DIAGRAM_IMAGES+"ELLIPSE", "Conector", tool));
			tool = new ClassTool(this, new Decision());
			jb.add(createToolButton(DIAGRAM_IMAGES+"DIAMOND", "Decisão", tool));
			tool = new ClassTool(this, new OutPutDataImpress());
			jb.add(createToolButton(DIAGRAM_IMAGES+"CLASS", "Impressão", tool));
			tool = new ClassTool(this, new InputOutputData());
			jb.add(createToolButton(DIAGRAM_IMAGES+"CLASS", "Entrada/Saída", tool));
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	protected void createMenus(JMenuBar mb) {
		mb.add(createFileMenu());
		mb.add(createEditMenu());
		mb.add(createGeradorMenu());
	}
	
	protected JMenu createGeradorMenu() {
        JMenu menu = new JMenu("Gerar");
        JMenuItem m1 = new JMenuItem("em C++");
        JMenuItem m3 = new JMenuItem("em Pascal");
        JMenuItem m2 = new JMenuItem("A partir do Source");
        JMenu codigo = new JMenu("Código");
        m1.addActionListener( new ActionListener() {
        	public void actionPerformed(ActionEvent event) {
        		JFileChooser chooser = new JFileChooser();
        	    chooser.setCurrentDirectory(new java.io.File("."));
        	    chooser.setDialogTitle("Escolha um diretório de destino");
        	    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        	    chooser.setAcceptAllFileFilterUsed(false);
        	    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
        	    	try{
        	    		if(carregaBlocosDiagrama()) {
		        	    	Gerador gerador = new Gerador(diagram, chooser.getSelectedFile().getAbsolutePath(), "cc");
		        	    	gerador.gerarArquivo();
		        	    	JOptionPane.showMessageDialog(null, "Gerado com sucesso no diretório: "+chooser.getSelectedFile().getAbsolutePath());
        	    		}
        	    	}catch(Exception e){
        	    		JOptionPane.showMessageDialog(null, e.getMessage());
        	    	}
        	    }
        	    diagram = new Diagram();
        	} 
        });
        m2.addActionListener( new ActionListener() {
        	public void actionPerformed(ActionEvent event) {
        		JOptionPane.showMessageDialog(null, "TO DO!");
        	} 
        });
        m3.addActionListener( new ActionListener() {
        	public void actionPerformed(ActionEvent event) {
        		JFileChooser chooser = new JFileChooser();
        	    chooser.setCurrentDirectory(new java.io.File("."));
        	    chooser.setDialogTitle("Escolha um diretório de destino");
        	    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        	    chooser.setAcceptAllFileFilterUsed(false);
        	    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
        	    	try{
        	    		if(carregaBlocosDiagrama()) {
		        	    	Gerador gerador = new Gerador(diagram, chooser.getSelectedFile().getAbsolutePath(), "pascal");
		        	    	gerador.gerarArquivo();
		        	    	JOptionPane.showMessageDialog(null, "Gerado com sucesso no diretório: "+chooser.getSelectedFile().getAbsolutePath());
        	    		}
        	    	}catch(Exception e){
        	    		JOptionPane.showMessageDialog(null, e.getMessage());
        	    	}
        	    }
        	    diagram = new Diagram();
        	} 
        });
        codigo.add(m1);
        codigo.add(m3);
//        menu.add(m1);
        menu.add(codigo);
        menu.add(m2);
		return menu;
    } 

	
	protected MDI_DrawApplication getMDI_DrawApplication(){
		return this;
	}
	
	@Override
	protected void setView(DrawingView newView) {
		newView.setBackground(Color.WHITE);
		super.setView(newView);
	}

	@Override
	protected Drawing createDrawing() {
		Drawing dwg = super.createDrawing();
        dwg.setTitle("Novo Diagrama");
		return dwg;
	}
	
	@Override
	protected DrawingView createDrawingView(Drawing newDrawing) {
		Dimension d = getDrawingViewSize();
		DrawingView newDrawingView = new ZoomDrawingView(this, d.width, d.height);
		newDrawingView.setDrawing(newDrawing);
		return newDrawingView;
	}
	
	protected Tool createSelectionTool() {
        return new TextSelectionTool(this);
    }
	
	private boolean carregaBlocosDiagrama() {
		DrawingView drawingView = this.view();
		FigureEnumeration fe = drawingView.drawing().figures();
		Block aux;
		int i = 0;
		while(fe.hasNextFigure()){
			try{
				aux = (Block)fe.nextFigure();
				aux.getModellerClass().setID(i);
				i++;
				diagram.addBlock(aux);
			}catch (Exception e) {
				// passa se o objeto nao for uma instancia de block
			}
		}
		try {
			diagram.isValid();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Não foi possível gerar o código. Motivo: " + e.getMessage());
			return false;
		}
		return true;
	}
	
	public void setDiagram(Diagram diagram) {
		this.diagram = diagram;
	}

	public JDiabloApplication() {
		super("DiaBlo - Diagrama de Blocos");
		diagram = new Diagram();
	}
	
	public JDiabloApplication(String titulo) {
		super(titulo);
		diagram = new Diagram();
	}
	
	public static void main(String[] args) {
		JDiabloApplication window = new JDiabloApplication();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		window.open();
		window.setSize(screenSize.width, screenSize.height);
	}
}
