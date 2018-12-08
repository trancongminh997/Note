import javax.swing.*;  
import java.awt.event.*;  
import java.awt.*;

public class FileBrowser extends JApplet implements ActionListener{
	int userId;
	int row = 5;
	int col = 1;
	//c1
    JButton newNote = new JButton("New");
    //c2
    JButton calendar = new JButton("Calendar");
    //c3
    JButton logOut = new JButton("Log Out");
    JButton[] noteBut;
    Container cp = getContentPane();
    GroupLayout layout;
	public FileBrowser(int userId) { 
		this.userId = userId;
		layout = new GroupLayout(cp);
	    cp.setLayout(layout) ; //not needed as container default is BorderLayout
	    //c4
	    JPanel jp = new JPanel();
	    jp.setLayout( new GridLayout( row, 1 ) ) ;
		this.noteBut = new 	JButton[row];
	    for(int i = 0 ; i < row ; i++) {
	    		    
	    	noteBut[i] = new JButton("Button "+i);
	      noteBut[i].addActionListener(this);
		  jp.add(noteBut[i]);
	    }
	    int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED ;
	    int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED ;
	    JScrollPane js = new JScrollPane( jp, v, h ) ;

	    
	    layout.setAutoCreateGaps(true);
	    layout.setAutoCreateContainerGaps(true);
	    
	    layout.setVerticalGroup(
	    		   layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	    		      .addGroup(layout.createSequentialGroup()
	    		           .addComponent(newNote)
	    		           .addComponent(calendar)
	    		           .addComponent(logOut))
	    		      .addComponent(js)
	    		);
	    layout.setHorizontalGroup(
	    		   layout.createSequentialGroup()
	    		      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	    		           .addComponent(newNote)
	    		           .addComponent(calendar)
	    		           .addComponent(logOut))
	    		      .addComponent(js)
	    		);
	    newNote.addActionListener(this);
	    calendar.addActionListener(this);
	    logOut.addActionListener(this);
	
	  }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == newNote) {
			//get parent is login 
			Login login = (Login) getParent();
			// add new object is EditingNote()
			login.add(new EditingNote(0,userId),"EN");
			// show object out
			login.cl.show(login, "EN");
		}
		else if (e.getSource() == calendar) {
			System.out.println("Halo "+e.getSource().toString());
		}
		else if (e.getSource() == logOut) {
			Login login = (Login) getParent();
			login.cl.show(login, "login");
		}
		else
			{
				System.out.println("Halo "+e.getSource().toString());
			}
	}  
} 