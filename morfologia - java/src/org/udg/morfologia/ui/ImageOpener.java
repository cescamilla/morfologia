package org.udg.morfologia.ui;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;

import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import org.udg.morfologia.filtros.*;


public class ImageOpener {

	private JFrame frame;
	private BufferedImage displayImage;
	private BufferedImage originalImage;	
	MyFilter blurFilter = new BlurFilter();
	MyFilter SharpenFilter = new SharpenFilter();
	MyFilter InvertFilter = new InvertFilter();
	MyFilter colorFilter = new ColorFilter();
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImageOpener window = new ImageOpener();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ImageOpener() {
		initialize();
	}
	
	
	 public void applyFilter(MyFilter filter) {
		    displayImage = filter.processImage(displayImage);
		  }


	 
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		


		
	
		
		
		JButton btnNewButton = new JButton("Open Image");
        final JLabel lblNewLabel = new JLabel();

		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				int result = fileChooser.showOpenDialog(fileChooser);
				if (result == JFileChooser.APPROVE_OPTION) {
				    File selectedFile = fileChooser.getSelectedFile();
				    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
				    try
			        {
				    	originalImage = ImageIO.read(new File(selectedFile.getAbsolutePath()));
				    	displayImage = originalImage;
			        }
			        catch (Exception exc)
			        {
			          exc.printStackTrace();
			          System.exit(1);
			        }
				      ImageIcon imageIcon = new ImageIcon(displayImage);
				        lblNewLabel.setIcon(imageIcon);
			        
				    
				    
				}
			}
		});
		frame.getContentPane().add(lblNewLabel, BorderLayout.CENTER);
		frame.getContentPane().add(btnNewButton, BorderLayout.SOUTH);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenuItem mntmInverfilter = new JMenuItem("InverFilter");
		mntmInverfilter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				displayImage = originalImage;
				applyFilter(InvertFilter);
				 ImageIcon imageIcon = new ImageIcon(displayImage);
			        lblNewLabel.setIcon(imageIcon);
			        System.out.println("filter applied");
				
			}
		});
		menuBar.add(mntmInverfilter);
		
		JMenuItem mntmBlurfilter = new JMenuItem("BlurFilter");
		mntmBlurfilter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				displayImage = originalImage;
				applyFilter(blurFilter);
				 ImageIcon imageIcon = new ImageIcon(displayImage);
			        lblNewLabel.setIcon(imageIcon);
			        System.out.println("filter applied");
			}
		});
		menuBar.add(mntmBlurfilter);
		
		JMenuItem mntmColorfilter = new JMenuItem("ColorFilter");
		mntmColorfilter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				displayImage = originalImage;
				applyFilter(colorFilter);
				 ImageIcon imageIcon = new ImageIcon(displayImage);
			        lblNewLabel.setIcon(imageIcon);
			        System.out.println("filter applied");
			}
		});
		menuBar.add(mntmColorfilter);
		
		JMenuItem mntmSharpenfilter = new JMenuItem("SharpenFilter");
		mntmSharpenfilter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				displayImage = originalImage;
				applyFilter(SharpenFilter);
				 ImageIcon imageIcon = new ImageIcon(displayImage);
			        lblNewLabel.setIcon(imageIcon);
			        System.out.println("filter applied");
			}
		});
		menuBar.add(mntmSharpenfilter);
		
		JMenuItem mntmOriginal = new JMenuItem("Original");
		mntmOriginal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				 ImageIcon imageIcon = new ImageIcon(originalImage);
			        lblNewLabel.setIcon(imageIcon);
			}
		});
		menuBar.add(mntmOriginal);
	}

}
