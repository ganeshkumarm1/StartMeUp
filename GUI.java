import javax.swing.*;
import java.awt.*;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class GUI
{
		int var=0;
		String user_email;
		
		//panels and frames
		JPanel welcome_panel=new JPanel();
		JPanel login_panel=new JPanel();
		JPanel register_panel=new JPanel();
		JPanel menu_panel=new JPanel();
		JPanel upload_panel=new JPanel();
		JPanel apply_panel=new JPanel();
		JPanel container=new JPanel();
		JFrame main_frame=new JFrame("Start Me Up");

		//Welocme panel
		JButton start;
		
		//loginpanel
		JLabel l_log_email;
		JLabel l_log_password;
		JTextField t_log_email;
		JPasswordField t_log_password;
		JButton b_log_login;
		JButton b_log_register;

		//register panel
		JLabel l_reg_email;
		JLabel l_reg_name;
		JLabel l_reg_password;
		JLabel l_reg_mobile;
		JLabel l_reg_country;
		JTextField t_reg_email;
		JPasswordField t_reg_password;
		JTextField t_reg_name;
		JTextField t_reg_mobile;
		JTextField t_reg_country;
		JButton b_reg_register;
		JButton b_reg_cancel;

		//menu panel
		JButton b_men_apply;
		JButton b_men_upload;
		JButton b_men_logout;

		//upload panel
		JLabel l_upl_job;
		JLabel l_upl_category;
		JLabel l_upl_details;
		JTextField t_upl_job;
		JButton b_upl_upload;
		JButton b_upl_cancel;
		JTextArea t_upl_details;
		JTextField t_upl_category;
		JButton l_upl_upload;
		JButton l_upl_cancel;
		
		//apply
		JLabel l_app_search;
		JTextField t_app_search;
		JLabel l_app_details;
		JTextArea t_app_details;
		JScrollPane s_app_scroll;
		JButton b_app_search;
		JLabel l_app_id;
		JTextField t_app_id;
		JButton b_app_apply;
		JButton b_app_cancel;

		CardLayout cards;
		Color c;
		
		public GUI()
		{
		
		//CardLayout
		cards=new CardLayout();
		container.setLayout(cards);
	
		//GridBagLayout
		GridBagLayout grids=new GridBagLayout();
		login_panel.setLayout(grids);
		register_panel.setLayout(grids);
		menu_panel.setLayout(grids);
		upload_panel.setLayout(grids);
		apply_panel.setLayout(grids);
		GridBagConstraints g=new GridBagConstraints();
		g.fill=GridBagConstraints.BOTH;

		//Main Frame
		main_frame.add(container);
		main_frame.show();
		main_frame.setBackground( Color.BLACK );
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main_frame.setSize(1000,1000);
		main_frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		main_frame.setVisible(true);

		//Login Panel
		l_log_email=new JLabel("Email");
		l_log_email.setPreferredSize(new Dimension(100,35));
		g.gridx=0;
		g.gridy=0;
		g.gridwidth=1;
		g.gridheight=1;
		g.insets = new Insets(3,3,3,3);
		grids.setConstraints(l_log_email,g);
		login_panel.add(l_log_email);	
		
		t_log_email=new JTextField(30);
		t_log_email.setPreferredSize(new Dimension(100,35));
		g.gridx=1;
		g.gridy=0;
		g.gridwidth=1;
		g.gridheight=1;
		g.insets = new Insets(5,5,5,5);
		grids.setConstraints(t_log_email,g);
		login_panel.add(t_log_email);	
		

		l_log_password=new JLabel("Password");
		l_log_password.setPreferredSize(new Dimension(100,35));
		g.gridx=0;
		g.gridy=1;
		g.gridwidth=1;
		g.gridheight=1;
		g.insets = new Insets(3,3,3,3);
		grids.setConstraints(l_log_password,g);
		login_panel.add(l_log_password);

		t_log_password=new JPasswordField(30);
		t_log_email.setPreferredSize(new Dimension(100,35));
		g.gridx=1;
		g.gridy=1;
		g.gridwidth=1;
		g.gridheight=1;
		g.insets = new Insets(5,5,5,5);
		grids.setConstraints(t_log_password,g);
		login_panel.add(t_log_password);	

		b_log_register=new JButton("Register");
		b_log_register.setPreferredSize(new Dimension(50,35));
		g.gridx=0;
		g.gridy=2;
		g.gridwidth=1;
		g.gridheight=1;
		g.insets = new Insets(5,5,5,5);
		grids.setConstraints(b_log_register,g);
		login_panel.add(b_log_register);
		b_log_register.setForeground(Color.WHITE);
		c = new Color(0x4169e1);
		b_log_register.setBackground(c);
		b_log_register.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				cards.show(container,"Register Panel");
			}
		});

		b_log_login=new JButton("Login");
		b_log_login.setPreferredSize(new Dimension(50,35));
		g.gridx=1;
		g.gridy=2;
		g.gridwidth=1;
		g.gridheight=1;
		g.insets = new Insets(3,3,3,3);
		grids.setConstraints(b_log_login,g);
		login_panel.add(b_log_login);	
		b_log_login.setForeground(Color.WHITE);
		c = new Color(0x4169e1);
		b_log_login.setBackground(c);
		b_log_login.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				
				DB db=new DB();
				String email=t_log_email.getText();
				String password=t_log_password.getText();
				if(email.equals("")||password.equals(""))
				{
					JOptionPane.showMessageDialog(null, "No field can be empty");	
				}
				else
				{
					user_email=db.login(email,password);

				if(user_email.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Wrong Username or Password");
				
				}
				else
				{
					cards.show(container,"Menu Panel");	
				}
			}
			}
		});


		//Register Panel
		l_reg_name=new JLabel("Name");
		l_reg_name.setPreferredSize(new Dimension(100,35));
		g.gridx=0;
		g.gridy=0;
		g.gridwidth=1;
		g.gridheight=1;
		g.insets = new Insets(3,3,3,3);
		grids.setConstraints(l_reg_name,g);
		register_panel.add(l_reg_name);	
		
		t_reg_name=new JTextField(30);
		t_reg_name.setPreferredSize(new Dimension(100,35));
		g.gridx=1;
		g.gridy=0;
		g.gridwidth=1;
		g.gridheight=1;
		g.insets = new Insets(3,3,3,3);
		grids.setConstraints(t_reg_name,g);
		register_panel.add(t_reg_name);
		

		l_reg_email=new JLabel("Email");
		l_reg_email.setPreferredSize(new Dimension(100,35));
		g.gridx=0;
		g.gridy=1;
		g.gridwidth=1;
		g.gridheight=1;
		g.insets = new Insets(3,3,3,3);
		grids.setConstraints(l_reg_email,g);
		register_panel.add(l_reg_email);	
		
		t_reg_email=new JTextField(30);
		t_reg_email.setPreferredSize(new Dimension(100,35));
		g.gridx=1;
		g.gridy=1;
		g.gridwidth=1;
		g.gridheight=1;
		g.insets = new Insets(3,3,3,3);
		grids.setConstraints(t_reg_email,g);
		register_panel.add(t_reg_email);


		l_reg_password=new JLabel("Password");
		l_reg_password.setPreferredSize(new Dimension(100,35));
		g.gridx=0;
		g.gridy=2;
		g.gridwidth=1;
		g.gridheight=1;
		g.insets = new Insets(3,3,3,3);
		grids.setConstraints(l_reg_password,g);
		register_panel.add(l_reg_password);	
		
		t_reg_password=new JPasswordField(30);
		t_reg_password.setPreferredSize(new Dimension(100,35));
		g.gridx=1;
		g.gridy=2;
		g.gridwidth=1;
		g.gridheight=1;
		g.insets = new Insets(3,3,3,3);
		grids.setConstraints(t_reg_password,g);
		register_panel.add(t_reg_password);

		l_reg_mobile=new JLabel("Mobile");
		l_reg_mobile.setPreferredSize(new Dimension(100,35));
		g.gridx=0;
		g.gridy=3;
		g.gridwidth=1;
		g.gridheight=1;
		g.insets = new Insets(3,3,3,3);
		grids.setConstraints(l_reg_mobile,g);
		register_panel.add(l_reg_mobile);	
		
		t_reg_mobile=new JTextField(30);
		t_reg_mobile.setPreferredSize(new Dimension(100,35));
		g.gridx=1;
		g.gridy=3;
		g.gridwidth=1;
		g.gridheight=1;
		g.insets = new Insets(3,3,3,3);
		grids.setConstraints(t_reg_mobile,g);
		register_panel.add(t_reg_mobile);

		l_reg_country=new JLabel("Country");
		l_reg_country.setPreferredSize(new Dimension(100,35));
		g.gridx=0;
		g.gridy=4;
		g.gridwidth=1;
		g.gridheight=1;
		g.insets = new Insets(3,3,3,3);
		grids.setConstraints(l_reg_country,g);
		register_panel.add(l_reg_country);	
		
		t_reg_country=new JTextField(30);
		t_reg_country.setPreferredSize(new Dimension(100,35));
		g.gridx=1;
		g.gridy=4;
		g.gridwidth=1;
		g.gridheight=1;
		g.insets = new Insets(3,3,3,3);
		grids.setConstraints(t_reg_country,g);
		register_panel.add(t_reg_country);	

		b_reg_cancel=new JButton("Cancel");
		b_reg_cancel.setPreferredSize(new Dimension(100,35));
		g.gridx=0;
		g.gridy=5;
		g.gridwidth=1;
		g.gridheight=1;
		g.insets = new Insets(3,3,3,3);
		grids.setConstraints(b_reg_cancel,g);
		register_panel.add(b_reg_cancel);
		b_reg_cancel.setForeground(Color.WHITE);
		c = new Color(0x4169e1);
		b_reg_cancel.setBackground(c);
		b_reg_cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				cards.show(container,"Login Panel");
				t_log_email.setText("");
				t_log_password.setText("");
			}
		});
		

		b_reg_register=new JButton("Register");
		b_reg_register.setPreferredSize(new Dimension(100,35));
		g.gridx=1;
		g.gridy=5;
		g.gridwidth=1;
		g.gridheight=1;
		g.insets = new Insets(3,3,3,3);
		grids.setConstraints(b_reg_register,g);
		register_panel.add(b_reg_register);		
		b_reg_register.setForeground(Color.WHITE);
		c = new Color(0x4169e1);
		b_reg_register.setBackground(c);
		b_reg_register.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
	
				DB db=new DB();
				String name=t_reg_name.getText();
				String email=t_reg_email.getText();
				String password=t_reg_password.getText();
				String mobile=t_reg_mobile.getText();
				String country=t_reg_country.getText();
				if(email.equals("")||password.equals("")||name.equals("")||mobile.equals("")||country.equals(""))
				{
					JOptionPane.showMessageDialog(null, "No Field Can Be Empty");	
				}
				else
				{
					var=db.register(name,email,password,mobile,country);
				if(var==1)
				{
				JOptionPane.showMessageDialog(null, "Registered Successfully");
				cards.show(container,"Login Panel");
				t_log_email.setText("");
				t_log_password.setText("");
				t_reg_email.setText("");
				t_reg_country.setText("");
				t_reg_password.setText("");
				t_reg_mobile.setText("");
				t_reg_name.setText("");
				}
				else if(var==2)
				{
					JOptionPane.showMessageDialog(null, "Already Registered");
				}
				else if(var<0)
				{
					JOptionPane.showMessageDialog(null, "Registeration Failure");
				}
				}
				
			}
		});
		

		//Menu Panel
		b_men_upload=new JButton("Upload");
		b_men_upload.setPreferredSize(new Dimension(100,100));
		g.gridx=0;
		g.gridy=0;
		g.gridwidth=1;
		g.gridheight=1;
		g.insets = new Insets(10,10,10,10);
		grids.setConstraints(b_men_upload,g);
		menu_panel.add(b_men_upload);
		b_men_upload.setForeground(Color.WHITE);
		c = new Color(0x4169e1);
		b_men_upload.setBackground(c);
		b_men_upload.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				cards.show(container,"Upload Panel");
				t_upl_job.setText("");
				t_upl_category.setText("");
				t_upl_details.setText("");
			}
		});

		b_men_apply=new JButton("Apply");
		b_men_apply.setPreferredSize(new Dimension(100,100));
		g.gridx=1;
		g.gridy=0;
		g.gridwidth=1;
		g.gridheight=1;
		g.insets = new Insets(10,10,10,10);
		grids.setConstraints(b_men_apply,g);
		menu_panel.add(b_men_apply);
		b_men_apply.setForeground(Color.WHITE);
		c = new Color(0x4169e1);
		b_men_apply.setBackground(c);
		b_men_apply.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				cards.show(container,"Apply Panel");
				t_app_id.setText("");
				t_app_details.setText("");
				t_app_search.setText("");
							}
		});

		b_men_logout=new JButton("Logout");
		b_men_logout.setPreferredSize(new Dimension(100,100));
		g.gridx=2;
		g.gridy=0;
		g.gridwidth=1;
		g.gridheight=1;
		g.insets = new Insets(10,10,10,10);
		grids.setConstraints(b_men_logout,g);
		menu_panel.add(b_men_logout);
		b_men_logout.setForeground(Color.WHITE);
		c = new Color(0x4169e1);
		b_men_logout.setBackground(c);
		b_men_logout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				cards.show(container,"Login Panel");
				t_log_email.setText("");
				t_log_password.setText("");
			}
		});

		//Upload Panel
		l_upl_job=new JLabel("Job Title");
		l_upl_job.setPreferredSize(new Dimension(100,35));
		g.gridx=0;
		g.gridy=0;
		g.gridwidth=1;
		g.gridheight=1;
		g.insets = new Insets(3,3,3,3);
		grids.setConstraints(l_upl_job,g);
		upload_panel.add(l_upl_job);	
		
		t_upl_job=new JTextField(30);
		t_upl_job.setPreferredSize(new Dimension(100,35));
		g.gridx=1;
		g.gridy=0;
		g.gridwidth=1;
		g.gridheight=1;
		g.insets = new Insets(3,3,3,3);
		grids.setConstraints(t_upl_job,g);
		upload_panel.add(t_upl_job);

		l_upl_category=new JLabel("Category");
		l_upl_category.setPreferredSize(new Dimension(100,35));
		g.gridx=0;
		g.gridy=1;
		g.gridwidth=1;
		g.gridheight=1;
		g.insets = new Insets(3,3,3,3);
		grids.setConstraints(l_upl_category,g);
		upload_panel.add(l_upl_category);	
		
		t_upl_category=new JTextField(30);
		t_upl_category.setPreferredSize(new Dimension(100,35));
		g.gridx=1;
		g.gridy=1;
		g.gridwidth=1;
		g.gridheight=1;
		g.insets = new Insets(3,3,3,3);
		grids.setConstraints(t_upl_category,g);
		upload_panel.add(t_upl_category);
		
		l_upl_details=new JLabel("Details");
		l_upl_details.setPreferredSize(new Dimension(100,35));
		g.gridx=0;
		g.gridy=2;
		g.gridwidth=1;
		g.gridheight=1;
		g.insets = new Insets(3,3,3,3);
		grids.setConstraints(l_upl_details,g);
		upload_panel.add(l_upl_details);	
		
		t_upl_details=new JTextArea();
		t_upl_details.setPreferredSize(new Dimension(100,200));
		g.gridx=1;
		g.gridy=2;
		g.gridwidth=1;
		g.gridheight=1;
		g.insets = new Insets(3,3,3,3);
		grids.setConstraints(t_upl_details,g);
		upload_panel.add(t_upl_details);
		

		JScrollPane s_upl_scroll = new JScrollPane(t_upl_details);
		JScrollBar upl_bar = new JScrollBar();
		s_upl_scroll.setBounds(23, 40, 394, 191);
		s_upl_scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		s_upl_scroll.add(upl_bar);
		grids.setConstraints(s_upl_scroll,g);
		upload_panel.add(s_upl_scroll);
		s_upl_scroll.setVisible(true);

		b_upl_upload=new JButton("Upload");
		b_upl_upload.setPreferredSize(new Dimension(100,35));
		g.gridx=1;
		g.gridy=3;
		g.gridwidth=1;
		g.gridheight=1;
		g.insets = new Insets(3,3,3,3);
		grids.setConstraints(b_upl_upload,g);
		upload_panel.add(b_upl_upload);
		b_upl_upload.setForeground(Color.WHITE);
		c = new Color(0x4169e1);
		b_upl_upload.setBackground(c);
		b_upl_upload.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				int x;
				DB db=new DB();
				String title=t_upl_job.getText();
				String category=t_upl_category.getText();
				String details=t_upl_details.getText();
				if(title.equals("")&&category.equals("")&&details.equals(""))
				{
					JOptionPane.showMessageDialog(null, "No Field Can Be Empty");
				}
				else
				{
				x=db.upload(title,category,details);
				if(x==1)
				{
					JOptionPane.showMessageDialog(null, "Job Uploaded Successfully");
				
			}
		}
		
			}
		});


		b_upl_cancel=new JButton("Cancel");
		b_upl_cancel.setPreferredSize(new Dimension(100,35));
		g.gridx=0;
		g.gridy=3;
		g.gridwidth=1;
		g.gridheight=1;
		g.insets = new Insets(3,3,3,3);
		grids.setConstraints(b_upl_cancel,g);
		upload_panel.add(b_upl_cancel);
		b_upl_cancel.setForeground(Color.WHITE);
		c = new Color(0x4169e1);
		b_upl_cancel.setBackground(c);
		b_upl_cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				cards.show(container,"Menu Panel");
			}
		});

		
		//Apply Panel
		l_app_search=new JLabel("Category");
		l_app_search.setPreferredSize(new Dimension(100,35));
		g.gridx=0;
		g.gridy=0;
		g.gridwidth=1;
		g.gridheight=1;
		g.insets = new Insets(3,3,3,3);
		grids.setConstraints(l_app_search,g);
		apply_panel.add(l_app_search);

		t_app_search=new JTextField(30);
		t_app_search.setPreferredSize(new Dimension(100,35));
		g.gridx=1;
		g.gridy=0;
		g.gridwidth=1;
		g.gridheight=1;
		g.insets = new Insets(3,3,3,3);
		grids.setConstraints(t_app_search,g);
		apply_panel.add(t_app_search);

		b_app_search=new JButton("Search");
		b_app_search.setPreferredSize(new Dimension(100,35));
		g.gridx=1;
		g.gridy=1;
		g.gridwidth=1;
		g.gridheight=1;
		g.insets = new Insets(5,5,5,5);
		grids.setConstraints(b_app_search,g);
		apply_panel.add(b_app_search);
		b_app_search.setForeground(Color.WHITE);
		c = new Color(0x4169e1);
		b_app_search.setBackground(c);
		b_app_search.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				DB db=new DB();
				String details;
				String category=t_app_search.getText();
				details=db.search(category);
				t_app_details.setText(details);
			
			}
		});

		l_app_details=new JLabel("Details");
		l_app_details.setPreferredSize(new Dimension(100,35));
		g.gridx=0;
		g.gridy=2;
		g.gridwidth=1;
		g.gridheight=1;
		g.insets = new Insets(3,3,3,3);
		grids.setConstraints(l_app_details,g);
		apply_panel.add(l_app_details);

		t_app_details=new JTextArea();
		t_app_details.setPreferredSize(new Dimension(100,200));
		g.gridx=1;
		g.gridy=2;
		g.gridwidth=1;
		g.gridheight=1;
		g.insets = new Insets(3,3,3,3);
		grids.setConstraints(t_app_details,g);
		apply_panel.add(t_app_details);

		s_app_scroll = new JScrollPane(t_app_details);
		JScrollBar bar = new JScrollBar();
		s_app_scroll.setBounds(23, 40, 394, 191);
		s_app_scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		s_app_scroll.add(bar);
		grids.setConstraints(s_app_scroll,g);
		apply_panel.add(s_app_scroll);
		s_app_scroll.setVisible(true);

		
		l_app_id=new JLabel("Job Id");
		l_app_id.setPreferredSize(new Dimension(100,35));
		g.gridx=0;
		g.gridy=3;
		g.gridwidth=1;
		g.gridheight=1;
		g.insets = new Insets(3,3,3,3);
		grids.setConstraints(l_app_id,g);
		apply_panel.add(l_app_id);

		t_app_id=new JTextField();
		t_app_id.setPreferredSize(new Dimension(100,35));
		g.gridx=1;
		g.gridy=3;
		g.gridwidth=1;
		g.gridheight=1;
		g.insets = new Insets(3,3,3,3);
		grids.setConstraints(t_app_id,g);
		apply_panel.add(t_app_id);

		b_app_apply=new JButton("Apply");
		b_app_apply.setPreferredSize(new Dimension(100,35));
		g.gridx=1;
		g.gridy=4;
		g.gridwidth=1;
		g.gridheight=1;
		g.insets = new Insets(3,3,3,3);
		grids.setConstraints(b_app_apply,g);
		apply_panel.add(b_app_apply);
		b_app_apply.setForeground(Color.WHITE);
		c = new Color(0x4169e1);
		b_app_apply.setBackground(c);
		b_app_apply.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				int x;
				DB db=new DB();
				String details;
				String id=t_app_id.getText();
				if(id.equals(""))
				{
						JOptionPane.showMessageDialog(null, "Please Enter a Job Id");
				}
				else
				{
				x=db.apply(id,user_email);
				if(x<0)
				{
					JOptionPane.showMessageDialog(null, "Error Applying For Job");	
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Jop Applied Successfully");		
				}
			}
				//t_app_details.setText(details);
			
			}
		});		

		b_app_cancel=new JButton("Cancel");
		b_app_cancel.setPreferredSize(new Dimension(100,35));
		g.gridx=0;
		g.gridy=4;
		g.gridwidth=1;
		g.gridheight=1;
		g.insets = new Insets(3,3,3,3);
		grids.setConstraints(b_app_cancel,g);
		apply_panel.add(b_app_cancel);
		b_app_cancel.setForeground(Color.WHITE);
		c = new Color(0x4169e1);
		b_app_cancel.setBackground(c);
		b_app_cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				cards.show(container,"Menu Panel");
			
			}
		});

		
		//Welcome Screen
		login_panel.setBackground(Color.WHITE);
		ImageIcon icon = new ImageIcon("welcome.jpg"); 
		JLabel thumb = new JLabel();
		thumb.setIcon(icon);
		welcome_panel.add(thumb);

		//adding panels
		register_panel.setBackground(Color.WHITE);
		menu_panel.setBackground(Color.WHITE);
		upload_panel.setBackground(Color.WHITE);
		apply_panel.setBackground(Color.WHITE);
		container.add(welcome_panel,"Welcome Panel");
		container.add(login_panel,"Login Panel");
		container.add(register_panel,"Register Panel");
		container.add(menu_panel,"Menu Panel");
		container.add(upload_panel,"Upload Panel");
		container.add(apply_panel,"Apply Panel");	

		//Display Welcome Screen
		cards.show(container,"Welcome Panel");
		try 
		{
    			Thread.sleep(5000);               
		} 
		catch(InterruptedException ex) 
		{
    			Thread.currentThread().interrupt();
		}
		
		//Display Login Panel
		cards.show(container,"Login Panel");
	}
	
	
}