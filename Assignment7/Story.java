import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

/**
 * Story class, extends JFrame. Houses all of the Swing components to achieve the desired GUI
 * @author athen
 * class attributes are : 
 *  - a combo box to hold story options.
 *  - arrays to hold image names and captions.
 *  - a button group and 4 JRadioButtons.
 *  - a new Post button.
 *  - a label for the picture.
 *  - panels to put components on.
 *  - an instance of the radiobuttonhandler class.
 *  - an arraylist to hold button objects
 */
public class Story extends JFrame{

	private JComboBox storiesBox;

	private String stories[] = {"Story 1 : Switzerland","Story 2 : Chelsea"};
	private String s1Imgs[] = {"mountains.jpg","snow.jpg","village.jpg"};
	private String s2Imgs[] = {"chels.jpg","timo.jpg","cl.jpg","kaihavertz.jpg"};
	private String[] captions = {"<html>Switzerland looks like a great country, I would love to visit there one day, especially Lake Lucerne.</html>","The football team I support, Chelsea."};
	
	private ButtonGroup picSelect = new ButtonGroup();
	private JButton newPost;
	
	private Icon icons[] = {new ImageIcon(s1Imgs[0]),new ImageIcon(s1Imgs[1]), new ImageIcon(s1Imgs[2])};
	private Icon icons2[] = {new ImageIcon(s2Imgs[0]),new ImageIcon(s2Imgs[1]), new ImageIcon(s2Imgs[2]), new ImageIcon(s2Imgs[3])};
	
	private JLabel picture;
	
	private JPanel captionPanel = new JPanel();
	private JPanel imagePanel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	private JPanel storyPanel = new JPanel();
	private JPanel newPostPanel = new JPanel();
	
	private JRadioButton b1 = new JRadioButton();
	private JRadioButton b2 = new JRadioButton();
	private JRadioButton b3 = new JRadioButton();
	private JRadioButton b4 = new JRadioButton();
	private RadioButtonHandler rbh = new RadioButtonHandler();
	private ArrayList<JRadioButton> btns = new ArrayList<>();
	
	/**
	 * Story constructor, super class.
	 * sets up and combines all of the elements of the GUI.
	 * - gets the contentPane of the frame.
	 * - sets layout for contentPane and panels.
	 * - sets size and colour for the necessary elements.
	 * - adds item listener as anon inner class for combo box.
	 * - creates the correct number of buttons based on the post being viewed.
	 * - positions all elements in the gui and adds them to panels and then to the contentPane.
	 * - also changes fonts, borders etc if desired.
	 * - sets frame size and visibility.
	 * 
	 */
	public Story()
	{
		super("Instagram");
		List<Image> taskbarIcon = new ArrayList<Image>();
		taskbarIcon.add(new ImageIcon("insta.png").getImage());
		setIconImages(taskbarIcon);
		
		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		captionPanel.setLayout(new GridLayout(2,1));
		imagePanel.setLayout(new BorderLayout());
		storyPanel.setLayout(new BorderLayout());
		buttonPanel.setLayout(new FlowLayout());
		imagePanel.setBackground(Color.gray);
		captionPanel.setBackground(Color.gray);
		buttonPanel.setBackground(Color.gray);
		imagePanel.setBackground(Color.gray);
		newPostPanel.setBackground(Color.gray);
		
		buttonPanel.add(b1);
		buttonPanel.add(b2);
		buttonPanel.add(b3);
		b1.addActionListener(rbh);
		b2.addActionListener(rbh);
		b3.addActionListener(rbh);
		b1.setName("b1");
		b2.setName("b2");
		b3.setName("b3");
		b1.setBackground(Color.gray);
		b2.setBackground(Color.gray);
		b3.setBackground(Color.gray);
		picSelect.add(b1);
		picSelect.add(b2);
		picSelect.add(b3);


		JLabel caption = new JLabel(captions[0]);
		caption.setFont(new Font("Times New Roman",Font.ITALIC,20));
		caption.setHorizontalAlignment(SwingConstants.CENTER);
		caption.setSize(650,150);
		caption.setForeground(Color.green);
	    Border black = BorderFactory.createLineBorder(Color.black);
		caption.setBorder(black);
		
		
		storiesBox = new JComboBox(stories);
		storiesBox.setMaximumRowCount(3);
		storiesBox.setForeground(Color.black);
		storiesBox.addItemListener(
				
		        new ItemListener() {
			        public void itemStateChanged( ItemEvent event)
			            {

				            if(event.getStateChange() == ItemEvent.SELECTED)
				            	if(buttonPanel != null)
				            		buttonPanel.removeAll();

				    		if(storiesBox.getSelectedIndex() == 0)
				        	{
				        		buttonChange();	    
				        		caption.setForeground(Color.green);
				        		picture.setIcon(icons[0]);
				        		caption.setText(captions[0]);
				        	}
				        	else if(storiesBox.getSelectedIndex() == 1)
				    	    {
				        		buttonChange();
				        		caption.setForeground(Color.blue);
				        		picture.setIcon(icons2[0]);
				        		caption.setText(captions[1]);
				    	    }
			            }
		        });
		
		storyPanel.add(storiesBox);
		container.add(storyPanel,BorderLayout.NORTH);
		
		picture = new JLabel(icons[0]);
		picture.setSize(520,340);
		imagePanel.add(picture,BorderLayout.CENTER);
		
		imagePanel.add(buttonPanel,BorderLayout.SOUTH);
		
		newPost = new JButton("Add Post");
		newPostPanel.add(newPost);
		ButtonHandler handler2 = new ButtonHandler();
		newPost.addActionListener(handler2);
		
		captionPanel.add(caption,BorderLayout.NORTH);
		container.add(imagePanel,BorderLayout.CENTER);
		captionPanel.add(newPostPanel,BorderLayout.SOUTH);
		container.add(captionPanel,BorderLayout.SOUTH);
		
		setSize(700,700);
		setVisible(true);
	}
	
	/**
	 * private class ButtonHandler, implements the ActionListener interface.
	 * @author athen
	 * - prints out a string when the button is pressed.
	 */
	private class ButtonHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("The Add Post Button has been pressed.");
		}
	}
	
	/**
	 * class RadioButtonHandler, also implements the ActionListener interface.
	 * @author athen
	 * - changes the displayed picture based on the selected story and which radio button is selected
	 */
	class RadioButtonHandler implements ActionListener {			 
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JRadioButton b = (JRadioButton) e.getSource();
			String name = b.getName();
			if(storiesBox.getSelectedIndex() == 0)
			{
				
				if(name.equals("b1"))
				{
					picture.setIcon(icons[0]);
				}
				if(name.equals("b2"))
				{
					picture.setIcon(icons[1]);
				} if(name.equals("b3"))
				{
					picture.setIcon(icons[2]);
				}
			}
			if(storiesBox.getSelectedIndex() == 1)
			{
				
				if(name.equals("b1"))
				{
					picture.setIcon(icons2[0]);
				}
				if(name.equals("b2"))
				{
					picture.setIcon(icons2[1]);
				} if(name.equals("b3"))
				{
					picture.setIcon(icons2[2]);
				}
				if(name.equals("b4"))
				{
					picture.setIcon(icons2[3]);
				}
			}
		}

		
	}
	
	/**
	 * Method to change the amount of buttons visible on screen at any given point.
	 * Called by the combo box item listener.
	 *  - Sets an integer variable to the number of pictures in the current story.
	 *  - Loops for that amount of buttons, instantiating an button object for every picture.
	 *  - Finally, connects the newly created button objects with the class attribute buttons.
	 * 
	 */
	public void buttonChange()
	{
		int size;
		if(storiesBox.getSelectedIndex() == 0)
			size = 3;
		else 
			size = 4;
		
		for(int i=1;i<size+1;i++)
		{
			b1 = new JRadioButton();
			b1.setName(String.format("b%d",i ));
			b1.setBackground(Color.gray);
			picSelect.add(b1);
			b1.addActionListener(rbh);
			buttonPanel.add(b1);
			btns.add(b1);
		}
		b1 = btns.get(0);
    	b2 = btns.get(1);
    	b3 = btns.get(2);
    	if(b4 != null)
    		b4 = btns.get(3);
	}

	/**
	 * Main method , used to run and test the GUI
	 * @param args
	 * - sets default close operation as Exit on close
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Story story = new Story();
		story.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
