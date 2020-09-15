package burp;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagLayout;
import javax.swing.JEditorPane;
import java.awt.GridBagConstraints;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Dialog extends JDialog {

    private final JPanel contentPanel = new JPanel();
    
    private GridBagLayout gbl_contentPanel = new GridBagLayout();

    /**
     * Create the dialog.
     */
    public Dialog() {
    	setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	setBounds(100, 100, 450, 218);
	getContentPane().setLayout(new BorderLayout());
	contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	getContentPane().add(contentPanel, BorderLayout.CENTER);
	gbl_contentPanel.columnWidths = new int[]{0, 0};
	gbl_contentPanel.rowHeights = new int[]{0, 0};
	gbl_contentPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
	gbl_contentPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};

    }
    
    public void setString(String str) {
	
	contentPanel.setLayout(gbl_contentPanel);
	{
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		contentPanel.add(scrollPane, gbc_scrollPane);
		{
			JTextArea txtrTest = new JTextArea();
			txtrTest.setText(str);
			txtrTest.setLineWrap(true);
			scrollPane.setViewportView(txtrTest);
		}
	}
    }

}