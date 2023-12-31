package GUI;

import Comp_Decomp.compressor;
import Comp_Decomp.decompressor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AppFrame extends JFrame implements ActionListener {

    JButton compressButton;
    JButton decompressButton;

    AppFrame(String name){
        this.setTitle(name);

        Container c = this.getContentPane();
        c.setLayout(new BorderLayout());

        JPanel headingPanel = new JPanel(); // Create a panel for the heading
        headingPanel.setBackground(new Color(255, 183, 0)); // Set background color
        headingPanel.setPreferredSize(new Dimension(getWidth(), 80)); // Set preferred size

        JLabel headingLabel = new JLabel("Compressor And Decompressor");
        headingLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        headingLabel.setForeground(Color.black); // Set text color
        headingPanel.add(headingLabel); // Add the heading label to the heading panel

        JPanel buttonPanel = new JPanel(); // Create a panel for the buttons
        buttonPanel.setBackground(new Color(255, 255, 255)); // Set background color
        buttonPanel.setPreferredSize(new Dimension(getWidth(), 120)); // Set preferred size

        compressButton = new JButton("Select file to Compress");
        decompressButton = new JButton("Select file to Decompress");
        compressButton.setBackground(new Color(255, 255, 255)); // Set button background color
        decompressButton.setBackground(new Color(255, 255, 255)); // Set button background color
        compressButton.setForeground(Color.black); // Set button text color
        decompressButton.setForeground(Color.black); // Set button text color

        buttonPanel.add(compressButton);
        buttonPanel.add(decompressButton);

        c.add(headingPanel, BorderLayout.NORTH); // Add the heading panel to the top
        c.add(buttonPanel, BorderLayout.CENTER); // Add the button panel to the center

        compressButton.addActionListener(this);
        decompressButton.addActionListener(this);

        this.setSize(500, 300);
        this.getContentPane().setBackground(Color.white); // Set background color for the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); // Center the frame on the screen
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==compressButton){
            JFileChooser filechooser = new JFileChooser();
            int response =filechooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    compressor.method(file);
                }
                catch(Exception ee){
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
        }
        if(e.getSource()==decompressButton){
            JFileChooser filechooser = new JFileChooser();
            int response =filechooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    decompressor.method(file);
                }
                catch(Exception ee){
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
        }
    }
}