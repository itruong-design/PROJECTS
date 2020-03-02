package Student;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import javax.swing.*;

public class SwingStudent {
	private final JFrame container = new JFrame("Student Information Form");
	private final JPanel panel1 = new JPanel();// used to hold all JPanels // parent panel
	private final JTextField studentNumbertf = new JTextField(10);// student number text field
	private final JTextField firstNametf = new JTextField(10);// first name text field
	private final JTextField lastNametf = new JTextField(10);;// last name tect field
	private final JTextArea courseta = new JTextArea(20, 35); // length - width; courses text area
	private final JPanel buttonPanel = new JPanel();// set up button panel
	private final JFrame outputContainer = new JFrame("Student Information");// output frame
	private final JTextArea output = new JTextArea(5, 10);// Text area for deserialized object
	private Student obj = new Student();
	private File file;// used to serialize and deserialize object

	public SwingStudent(File file) throws FileReadException {
		if (file.exists()) {
			this.file = file;
		} else {
			throw new FileReadException("File could not be found");
		}

	}

	public void createGUI() {
		
		container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		container.setSize(400, 300);// width - length
		
		// set layout for each panel to be set on new line
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));

		createStudentNumberPanel();
		createFirstNamePanel();	
		createLastNamePanel();	
		createCoursesPanel();	
		
		buttonPanel.setLayout(new FlowLayout());		
		
		createSubmitButton();
		
		createReadButton();	
		
		panel1.add(buttonPanel);//add button panel to parent panel
		container.add(panel1);//added parent panel to JFrame container
		container.setLocationRelativeTo(null);//set to open in middle of screen
		container.setVisible(true);
	}
	
	
	public void createStudentNumberPanel() {
		JPanel studentNumberPanel = new JPanel();
		studentNumberPanel.setLayout(new FlowLayout());
		JLabel studentNumberlabel = new JLabel("Student Number:     ");
		studentNumberPanel.add(studentNumberlabel);
		studentNumberPanel.add(studentNumbertf);
		panel1.add(studentNumberPanel);
	}
	
	public void createFirstNamePanel() {
		JPanel firstNamePanel = new JPanel();
		firstNamePanel.setLayout(new FlowLayout());
		JLabel firstNamelabel = new JLabel("First Name:              ");
		firstNamePanel.add(firstNamelabel);
		firstNamePanel.add(firstNametf);
		panel1.add(firstNamePanel);
	}
		
	public void createLastNamePanel() {
		JPanel lastNamePanel = new JPanel();
		lastNamePanel.setLayout(new FlowLayout());
		JLabel lastNamelabel = new JLabel("Last Name:               ");
		lastNamePanel.add(lastNamelabel);
		lastNamePanel.add(lastNametf);
		panel1.add(lastNamePanel);
	}
	
	public void createCoursesPanel() {
		JPanel coursePanel = new JPanel();
		coursePanel.setLayout(new FlowLayout());
		JLabel courseLabel = new JLabel("<html>Courses<br/>*press Enter to put more than one course*</html>", SwingConstants.CENTER);	//	JLabel info = new JLabel("press Enter to put more than one course");
		coursePanel.add(courseLabel);
		//coursePanel.add(info);
		coursePanel.add(courseta);
		panel1.add(coursePanel);
		}
	
	public void createSubmitButton() {
		JButton button = new JButton("Write");
		buttonPanel.add(button);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {

				try {

					ArrayList<String> courses = new ArrayList<String>();
					String[] course = null;
				
					obj.setStdID(Integer.parseInt(studentNumbertf.getText()));
					obj.setFirstName(firstNametf.getText());
					obj.setLastName(lastNametf.getText());
					// find delimiter
					if (courseta.getText().indexOf(" ") >= 0) {
						course = courseta.getText().split("\\ ");
					} else if (courseta.getText().indexOf("\n") >= 0) {
						course = courseta.getText().split("\\\n");// split string with new line as delimiter into array
						for (String i : course) {
							courses.add(i);// add string array to ArrayList one by one
						}
						obj.setCourses(courses);// set courses for Student object
					}
					JOptionPane.showMessageDialog(buttonPanel, String.format(
				            "You pressed %s and submitted student information", event.getActionCommand()));
					
					try {
						writeFile(file, obj);// call writefile
					} catch (IOException | FileWriteException e1) {
						e1.printStackTrace();
					}
					

				} catch (StudentException message) {
					System.out.println(message.getMessage());
				}

			}
		});
		
	}
	
	public void createReadButton() {
		JButton button2 = new JButton("Read");
		buttonPanel.add(button2);
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				try {
					readFile(file);

				} catch (ClassNotFoundException | FileReadException | IOException e) {
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(outputContainer, String.format(
			            "You pressed %s to display student information", event.getActionCommand() ));
			}
		});
	}
	
	
	public void writeFile(File file, Student obj) throws FileNotFoundException, IOException, FileWriteException {
		FileWrite fw = new FileWrite(file);
		fw.serializeObject(obj);// serialize object into a file
	}

		public void readFile(File file)
			throws FileReadException, StreamCorruptedException, ClassNotFoundException, IOException {
		FileRead fr = new FileRead(file);
		outputContainer.setSize(400, 300);//set size of output frame
		output.setEditable(false);
		output.setText(Integer.toString(fr.deserializeObject().getStdID()) + "\n");//set text
		output.append(fr.deserializeObject().getFirstName() + "\n");//deserializeObect returns a Student object
		output.append(fr.deserializeObject().getLastName() + "\n");//used to call getters in Student class
		output.append("[ ");//format
		for (int i = 0; i < fr.deserializeObject().getCourses().size(); ++i) {
			if (i != fr.deserializeObject().getCourses().size() - 1) {//used to stop adding comma after last element
				output.append(fr.deserializeObject().getCourses().get(i) + ", ");
			} else {
				output.append(fr.deserializeObject().getCourses().get(i));
			}
		}
		output.append(" ]");
		outputContainer.add(output);
		outputContainer.setLocationRelativeTo(null);
		outputContainer.setVisible(true);
	}

	public static void main(String[] args) {
		File file = new File(args[0]);
		SwingStudent ss = null;
		try {
			ss = new SwingStudent(file);
		} catch (FileReadException e) {
			e.printStackTrace();
		}
		ss.createGUI();

	}

}