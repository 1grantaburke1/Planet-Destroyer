import java.awt.*;
import java.awt.event.*;//necessary for buttons
import java.applet.*;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
public class ClickerGame extends Applet implements ActionListener 
{
	public static JFrame box = new JFrame();
	public static JPanel pan = new JPanel();
	public static JTextArea mess = new JTextArea();
	public static JButton mb = new JButton();
	
	
	//Declare a new string, and make a new "empty" mailbox
	String sMessage = new String("");
	public static int yInd = 1;
	public static int damage = 0;
	
	// declarations
	public static int planetsDestroyed = 0;						//Num of planet destroyed since game launched.
	public static int planetHP = 50;							// Planet current hp. Not a final value yet.
	public static int planetMaxHP = 50;
	public static double goldMult;
	public static long currentGold = 0;							// Player's current gold.
	public static double multiplyer = 1.4;						// Don't exactly know how to implement this yet.
	public static int damageU[] = {7, 270, 2400, 99970};			// damage each weapon can make
	public static int costs[] = {5, 170, 755, 80550};
	public static int inArc[] = {0, 0, 0 ,0};						// Num of each weapon in Arcenal.
	public static int unlPoints[] = {0,0,0,0};
	public static int up = 0;
	public static boolean r[] = {false,false, false};
	public static int mu = 0;
	public static int mm = 1;
	public static int md[] = {0,0,0,0,0,0};
	public static int togs[] = {1,1,1,1};
	
	public static boolean DD1[] = {false,false,false};
	public static boolean DD2[] = {false,false,false};
	public static boolean DD3[] = {false,false,false};
	public static boolean DD4[] = {false,false,false};
	
	//Declare new buttons
	public static Button Button1;
	public static Button Button2;
	public static Button Button3;
	public static Button Button4;
	
	public static Button toggle1;
	public static Button toggle2;
	public static Button toggle3;
	public static Button toggle4;
	
	
	public static Button bLaunch;
	
	public static TextField t0 = new TextField(20);	//gold
	
	public static TextField t1 = new TextField(20);	//gold
	public static TextField t2 = new TextField(20);	// # of TNT
	public static TextField t5 = new TextField(20);	// planet HP
	public static TextField t3 = new TextField(20);	//# of Nitro
	public static TextField t4 = new TextField(20);	//# of SLB
	public static TextField t6 = new TextField(20);	//# of SLB
	public static TextField units = new TextField(40);//Damage outputs.
	public static TextField units2 =new TextField(40);
	public static TextField DO =new TextField(20);
	
	public static TextField tag1 = new TextField(20);	//# of SLB
	public static TextField tag2 = new TextField(40);//Damage outputs.
	public static TextField tag3 =new TextField(40);
	public static TextField tag4 =new TextField(20);
	
	
	Font font1 = new Font("Times New Roman", Font.BOLD, 19);
	 
	public static int tt = 300;
	
	
	public static ImageIcon icon = new ImageIcon("240_F_90242231_BqwVlyCbQTh6KLx13WIxI6OKPOVlTyWU.jpg"); 
	public static JLabel thumb = new JLabel();
	
	
	
	
	public void init() 
        {
		Border blackline = BorderFactory.createLineBorder(Color.black, 2);
		Frame title = (Frame)this.getParent().getParent();
                title.setTitle("Planet Destroyer");
		/*thumb.setIcon(icon);
		thumb.setVisible(true);
		thumb.setBounds(135,0,400,200);
		thumb.setBorder(blackline);
		
		mess.setBackground(Color.pink);
		
		mess.setLineWrap(true);
		mess.setText("You have come to a decision!                                                                That you must destroy it. "
				+ "			                    You must destroy the universe!                                                             There is no backing away from it, now." +"\n"+ "Just one imporant rule here in this dimension." + "\n" +"DESTROY EVERY LAST PLANET !!!!!!!!!!!!!!" + "\n\n" + "Are you ready to take on the consequences for all existence?");
		mess.setBorder(blackline);
		Font font = new Font("Times New Rome", Font.CENTER_BASELINE, 20);
		mess.setFont(font);
		mess.setBounds(5, 180, 673, 220);
		//mess.setHorizontalAlignment(SwingConstants.CENTER);
		//mess.setVerticalAlignment(SwingConstants.CENTER);
		mess.setVisible(true);
		
		mb.setText("Sounds cool! Let's do it bro ! ! !");
		mb.setSize(220, 30);
		mb.setLocation(230,413);
		
		pan.setSize(700, 500);
		pan.setBackground(Color.pink);
		pan.setLocation(0, 0);
		pan.setLayout(null);
		box.setSize(700,500);
		box.setTitle("The Developer(Mr. MMB-aka Mad Man Burke) Makes His Entrance!!!");*/
	
		
		pan.setLayout(null);
		pan.add(mess);
		pan.add(mb);
		pan.add(thumb);
		box.add(pan);
		//box.setVisible(true);
		box.setDefaultCloseOperation(0);
		
		
		setBackground(Color.black);
		setForeground(Color.white);
		
		setSize(640,520);
		

		//Turn Layout manager off
		setLayout(null);
		
		//Initialize the buttons and give them names
		Button1 = new Button("Buy TNT");
		Button2 = new Button("Buy Nitroglycerin");
		Button3 = new Button("Buy Spaceship Laser Beam");
		Button4 = new Button("Buy Plazma Colision Meteor");
		
		tag1.setBounds(250,33, 45, 21);
		tag1.setBackground(Color.BLACK);
		tag1.setForeground(Color.WHITE);
		tag1.setText("x1");
		tag1.setEditable(false);
		
		tag2.setBounds(250,93, 45, 21);
		tag2.setBackground(Color.BLACK);
		tag2.setForeground(Color.WHITE);
		tag2.setText("x1");
		tag2.setEditable(false);
		tag2.setVisible(false);
		
		tag3.setBounds(250,153, 45, 21);
		tag3.setBackground(Color.BLACK);
		tag3.setForeground(Color.WHITE);
		tag3.setText("x1");
		tag3.setEditable(false);
		tag3.setVisible(false);
		
		tag4.setBounds(250,213, 45, 21);
		tag4.setBackground(Color.BLACK);
		tag4.setForeground(Color.WHITE);
		tag4.setText("x1");
		tag4.setEditable(false);
		tag4.setVisible(false);
		
		toggle1 = new Button ("<TNT>");
		toggle2 = new Button ("<Nitro>");
		toggle3 = new Button ("<SLB>");
		toggle4 = new Button ("<PCM>");
		
		toggle1.setVisible(false);
		toggle2.setVisible(false);
		toggle3.setVisible(false);
		toggle4.setVisible(false);
		
		toggle1.setBounds(310,30,45,28);
		toggle1.setBackground(Color.YELLOW);
		toggle1.setForeground(Color.BLUE);
		
		toggle2.setBounds(310,90,45,28);
		toggle2.setBackground(Color.YELLOW);
		toggle2.setForeground(Color.BLUE);
		
		toggle3.setBounds(310,150,45,28);
		toggle3.setBackground(Color.YELLOW);
		toggle3.setForeground(Color.BLUE);
		
		toggle4.setBounds(310,210,45,28);
		toggle4.setBackground(Color.YELLOW);
		toggle4.setForeground(Color.BLUE);
		
		bLaunch = new Button("Launch Arcenal at Planet");
		
		t0.setBounds(430, 166, 200, 21);
		t0.setText("# of PC : 0");
		t0.setForeground(Color.black);
		t0.setBackground(Color.green);
		t0.setVisible(false);
		
		t1.setBounds(430, 20, 200, 21);
		t1.setText("Gold: 0   x" + (planetsDestroyed+1));
		t1.setBackground(Color.black);
		t1.setForeground(Color.yellow);
		t1.setVisible(true);
		setGold();
		
		t2.setBounds(430, 70, 200, 21);
		t2.setText("# of TNT : 0");
		t2.setForeground(Color.black);
		t2.setBackground(Color.green);
		t2.setVisible(true);
		
		t3.setBounds(430, 102, 200, 21);
		t3.setText("# of Nitro : 0");
		t3.setForeground(Color.black);
		t3.setBackground(Color.green);
		t3.setVisible(false);
		
		t4.setBounds(430, 134, 200, 21);
		t4.setText("# of SLB : 0");
		t4.setForeground(Color.black);
		t4.setBackground(Color.green);
		t4.setVisible(false);
		
		DO.setBounds(380, 215, 250, 21);
		DO.setText("Current Arcenal Damage: " + damage);
		DO.setBackground(Color.gray);
		DO.setForeground(Color.WHITE);
		DO.setVisible(true);

		t5.setBounds(380, 240, 250, 21);
		t5.setText("Current Planet HP: 50");
		t5.setForeground(Color.red);
		t5.setBackground(Color.BLACK);
		t5.setVisible(true);
		
		t6.setBounds(380, 267, 250, 21);
		t6.setText("Planets Destroyed: " + planetsDestroyed);
		t6.setForeground(Color.green);
		t6.setBackground(Color.BLACK);
		t6.setVisible(true);
		
		units.setBounds(2, 462, 635, 21);
		units.setText("TNT damage = " + damageU[0] + "    ");
		units.setForeground(Color.white);
		units.setBackground(Color.black);
		units.setVisible(true);
		
		units2.setBounds(2, 486, 635, 21);
		units2.setText("TNT cost = 5    ");
		units2.setForeground(Color.white);
		units2.setBackground(Color.black);
		units2.setVisible(true);
		
		
		add(t1);
		add(t2);
		add(t3);
		add(t4);
		add(t5);
		add(t6);
		add(units);
		add(units2);
		add(tag1);
		add(tag2);
		add(tag3);
		add(tag4);
		add(toggle1);
		add(toggle2);
		add(toggle3);
		add(toggle4);
		add(DO);
		add(t0);
		
		
		
		//t1.setBounds(400,5,200,30);
		
		
		//add the buttons to the applet
		add(Button1); //TNT
		add(Button2); //NITRO
		add(Button3); //SPB
		add(Button4);
		add(bLaunch); //Launch
		
		Button2.setVisible(false);
		Button3.setVisible(false);
		Button4.setVisible(false);

		//Position Buttons(X, Y, Width, Height);
		Button1.setBounds(2,20,300,50);
		Button2.setBounds(2,80,300,50);
		Button3.setBounds(2,140,300,50);
		Button4.setBounds(2, 200,300,50);
		
		bLaunch.setBounds(2,300,635,150);
		
		//Change color of Buttons
		Button1.setBackground(Color.gray);
		Button2.setBackground(Color.gray);
		Button3.setBackground(Color.gray);
		Button4.setBackground(Color.gray);
		
		bLaunch.setBackground(Color.red);
		
		//Change color of text on Buttons
		Button1.setForeground(Color.white);
		Button2.setForeground(Color.white);
		Button3.setForeground(Color.white);
		Button4.setForeground(Color.white);
		
		
		bLaunch.setFont(font1);
		
		//Make a new method that "listens" for the button press
		Button1.addActionListener(this);
		Button2.addActionListener(this);
		Button3.addActionListener(this);
		Button4.addActionListener(this);
		bLaunch.addActionListener(this);
		mb.addActionListener(this);
		
		toggle1.addActionListener(this);
		toggle2.addActionListener(this);
		toggle3.addActionListener(this);
		toggle4.addActionListener(this);
		
		
		
		//Set interval
		java.util.Timer t = new java.util.Timer();
		t.schedule(new TimerTask() {

		            @Override
		            public void run() {
		               currentGold += ((planetsDestroyed + 1 + up)*mm);
		               t1.setText("Gold: " + currentGold + "   x"+(planetsDestroyed + 1 + up)*mm );
		               
		               if (currentGold >= costs[1]) {
		            	   
		            	   t3.setVisible(true);
		            	   tag2.setVisible(true);
		            	   
		            	   
		            	   if(r[0] ==false) {
		            	   units.setText("TNT damage = " + damageU[0] + "  <>  Nitro damage = "  + damageU[1]);
		            	   units2.setText("TNT cost = " + costs[0]+"  <>  Nitro cost = " + costs[1]);
		            	   r[0]=true;
		            	   }
		            	  
		            	   Button2.setVisible(true);
		            	   
		               }
		               if (currentGold >= costs[2]) {
		            	   t4.setVisible(true);
		            	   tag3.setVisible(true);
		            	   
		            	   if(r[1] == false) {
		            	   units.setText("TNT damage = " + damageU[0] + "  <>     Nitro damage = "  + damageU[1] + "  <>  SLB damage = " + damageU[2]);
		            	   units2.setText("TNT cost = " + costs[0]+"  <>  Nitro cost = " + costs[1]+ "  <>  SLB cost = " + costs[2]);
		            	   r[1]=true;
		            	   }
		            	   Button3.setVisible(true);
		               }
		               if (currentGold >= costs[3]) {
		            	   t0.setVisible(true);
		            	   tag4.setVisible(true);
		            	   
		            	   if(r[2] == false) {
		            	   units.setText("TNT damage = " + damageU[0] + "  <>  Nitro damage = "  + damageU[1] + "  <>  SLB damage = " + damageU[2] + "  <>  PCM damage = " + damageU[3]);
		            	   units2.setText("TNT cost = " + costs[0]+"  <>  Nitro cost = " + costs[1]+ "  <>  SLB cost = " + costs[2]+ "  <>  PCM cost = " + costs[3]);
		            	   r[2]=true;
		            	   }
		            	   Button4.setVisible(true);
		               }
		               
		               
		               repaint();
		            }
		        }, tt, tt);
		
		t.schedule(new TimerTask() {

            @Override
            public void run() {
               
               if (currentGold >= togs[0] * costs[0]) {
            	   t2.setBackground(Color.green);
               }else {
            	   t2.setBackground(Color.red);
               }
               
               if (currentGold >= togs[1] * costs[1]) {
            	   t3.setBackground(Color.green);
               }else {
            	   t3.setBackground(Color.red);
               }
               
               if (currentGold >= togs[2] * costs[2]) {
            	   t4.setBackground(Color.green);
               }else {
            	   t4.setBackground(Color.red);
               }
               
               if (currentGold >= togs[3] * costs[3]) {
            	   t0.setBackground(Color.green);
               }else {
            	   t0.setBackground(Color.red);
               }
               
               
               
               repaint();
            }
        }, 10, 10);
        }
		
	
	
	
	@Override
	public void actionPerformed(ActionEvent ae) 
        {
		
		//store the name of the button pressed in sString
		String sString = ae.getActionCommand();
		if (sString.equals("Buy TNT")) {
			getMoreTNT();
			setGold();
			t2.setText("# of TNT : " + inArc[0] );
			
			 if(r[2] == true) {
          	   units.setText("TNT damage = " + damageU[0] + "  <>  Nitro damage = "  + damageU[1] + "  <>  SLB damage = " + damageU[2] + "  <>  PCM damage = " + damageU[3]);
          	   units2.setText("TNT cost = " + costs[0]+"  <>  Nitro cost = " + costs[1]+ "  <>  SLB cost = " + costs[2]+ "  <>  PCM cost = " + costs[3]);}
          	   else if(r[1] ==true) {
	         	   units.setText("TNT damage = " + damageU[0] + "  <>  Nitro damage = "  + damageU[1] + "  <>  SLB damage = " + damageU[2]);
	         	   units2.setText("TNT cost = " + costs[0]+"  <>  Nitro cost = " + costs[1]+ "  <>  SLB cost = " + costs[2]);
				}
				else if(r[0] == true) {
	         	   
	         	  units.setText("TNT damage = " + damageU[0] + "  <>  Nitro damage = "  + damageU[1]);
	         	   units2.setText("TNT cost = " + costs[0]+"  <>  Nitro cost = " + costs[1]);
				}
				else {
					units.setText("TNT damage = " + damageU[0] + "    ");
					units2.setText("TNT cost = " + costs[0]);
				}
			setDO();
		}
		else if (sString.equals("Buy Nitroglycerin")) {
			getMoreNitro();
			setGold();
			t3.setText("# of Nitro : " + inArc[1] );
			units.setText("TNT damage = " + damageU[0] + "    " + "     <>     Nitro damage = "  + damageU[1]);
			
			 if(r[2] == true) {
	          	   units.setText("TNT damage = " + damageU[0] + "  <>  Nitro damage = "  + damageU[1] + "  <>  SLB damage = " + damageU[2] + "  <>  PCM damage = " + damageU[3]);
	          	   units2.setText("TNT cost = " + costs[0]+"  <>  Nitro cost = " + costs[1]+ "  <>  SLB cost = " + costs[2]+ "  <>  PCM cost = " + costs[3]);}
	          	   else if(r[1] ==true) {
	          		 units.setText("TNT damage = " + damageU[0] + "  <>  Nitro damage = "  + damageU[1] + "  <>  SLB damage = " + damageU[2]);
		         	   units2.setText("TNT cost = " + costs[0]+"  <>  Nitro cost = " + costs[1]+ "  <>  SLB cost = " + costs[2]);
				}
				else if(r[0] == true) {
	         	   
					 units.setText("TNT damage = " + damageU[0] + "  <>  Nitro damage = "  + damageU[1]);
		         	   units2.setText("TNT cost = " + costs[0]+"  <>  Nitro cost = " + costs[1]);
				}
				else {
					units.setText("TNT damage = " + damageU[0] + "    ");
					units2.setText("TNT cost = " + costs[0]);
				}
			setDO();
		}
		else if (sString.equals("Buy Spaceship Laser Beam")) {
			getMoreSLB();
			setGold();
			t4.setText("# of SLB : " + inArc[2] );
			units.setText("TNT damage = " + damageU[0] + "    " + "     <>     Nitro damage = "  + damageU[1] + "     <>     SLB damage = " + damageU[2]);
			
			if(r[2] == true) {
	          	   units.setText("TNT damage = " + damageU[0] + "  <>  Nitro damage = "  + damageU[1] + "  <>  SLB damage = " + damageU[2] + "  <>  PCM damage = " + damageU[3]);
	          	   units2.setText("TNT cost = " + costs[0]+"  <>  Nitro cost = " + costs[1]+ "  <>  SLB cost = " + costs[2]+ "  <>  PCM cost = " + costs[3]);}
	          	   else if(r[1] ==true) {
	          		 units.setText("TNT damage = " + damageU[0] + "  <>  Nitro damage = "  + damageU[1] + "  <>  SLB damage = " + damageU[2]);
		         	   units2.setText("TNT cost = " + costs[0]+"  <>  Nitro cost = " + costs[1]+ "  <>  SLB cost = " + costs[2]);
				}
				else if(r[0] == true) {
	         	   
					 units.setText("TNT damage = " + damageU[0] + "  <>  Nitro damage = "  + damageU[1]);
		         	   units2.setText("TNT cost = " + costs[0]+"  <>  Nitro cost = " + costs[1]);
				}
				else {
					units.setText("TNT damage = " + damageU[0] + "    ");
					units2.setText("TNT cost = " + costs[0]);
				}
			setDO();
		}
		else if (sString.equals("Launch Arcenal at Planet")) {
			launchArcenal();
			setGold();
			t5.setText("Current Planet HP: " +  planetHP );
			t6.setText("Planets Destroyed: " + planetsDestroyed);
			setDO();
		}
		else if (sString.equals("<TNT>")) {
			togg(0);
			tag1.setText("x" + togs[0]);
		}
		else if (sString.equals("<Nitro>")) {
			togg(1);
			tag2.setText("x" + togs[1]);
		}
		else if (sString.equals("<SLB>")) {
			togg(2);
			tag3.setText("x" + togs[2]);
		}
		else if (sString.equals("<PCM>")) {
			togg(3);
			tag4.setText("x" + togs[3]);
		}
		else if (sString.equals("Buy Plazma Colision Meteor")) {
			getPC();
			setGold();
			t0.setText("# of PCM : " + inArc[3] );
			units.setText("TNT damage = " + damageU[0] + "    " + "     <>     Nitro damage = "  + damageU[1] + "     <>     SLB damage = " + damageU[2]);
			
			if(r[2] == true) {
	          	   units.setText("TNT damage = " + damageU[0] + "  <>  Nitro damage = "  + damageU[1] + "  <>  SLB damage = " + damageU[2] + "  <>  PCM damage = " + damageU[3]);
	          	   units2.setText("TNT cost = " + costs[0]+"  <>  Nitro cost = " + costs[1]+ "  <>  SLB cost = " + costs[2]+ "  <>  PCM cost = " + costs[3]);}
	          	   else if(r[1] ==true) {
	          		 units.setText("TNT damage = " + damageU[0] + "  <>  Nitro damage = "  + damageU[1] + "  <>  SLB damage = " + damageU[2]);
		         	   units2.setText("TNT cost = " + costs[0]+"  <>  Nitro cost = " + costs[1]+ "  <>  SLB cost = " + costs[2]);
				}
				else if(r[0] == true) {
	         	   
					 units.setText("TNT damage = " + damageU[0] + "  <>  Nitro damage = "  + damageU[1]);
		         	   units2.setText("TNT cost = " + costs[0]+"  <>  Nitro cost = " + costs[1]);
				}
				else {
					units.setText("TNT damage = " + damageU[0] + "    ");
					units2.setText("TNT cost = " + costs[0]);
				}
			setDO();
		} 
		else if (sString.equals("Sounds cool! Let's do it bro ! ! !")) {
			box.setVisible(false);
		}
		//repaint();
		
	}
	

	
	public void paint (Graphics g) 
    {
		
				
					
	}
	
	// increase TNT
	public static void getMoreTNT() {
		if (currentGold >= togs[0] * costs[0]){
			currentGold -= togs[0] * costs[0];
			damage += togs[0] * damageU[0];
			inArc[0] += togs[0]*1;
			DO.setText("Current Arcenal Damage: " + damage);

			
			unlPoints[0] += togs[0];
			

			if (unlPoints[0] >= 700 && DD1[0] == false) {
				up += 25;
				damageU[0] *= 5;
				costs[0] *= 5.5;
				//tt -= 50;
				Button1.setBackground(Color.black);
				DD1[0] = true;
			}
			else if (unlPoints[0] >= 400 && DD1[1] == false) {
				up += 15;
				damageU[0] *= 4;
				costs[0] *= 4.2;
				//tt -= 50;
				Button1.setBackground(Color.pink);
				DD1[1] = true;
			}
			else if (unlPoints[0] >= 100 && DD1[2] == false) {
				up += 5;
				damageU[0] *= 3;
				costs[0] *= 3;
				tt -= 50;
				Button1.setBackground(Color.blue);
				toggle1.setVisible(true);
				DD1[2] = true;
			}
		}
	}
	
	// increase Nitro
	public static void getMoreNitro() {
		if (currentGold >= togs[1] *costs[1]){
			currentGold -= togs[1] *costs[1];
			damage += togs[1] *damageU[1];
			inArc[1] += togs[1] *1;
			DO.setText("Current Arcenal Damage: " + damage);
			
			unlPoints[1] += togs[1];
			
			if (unlPoints[1] >= 700 && DD2[0] == false) {
				up += 25;
				damageU[1] *= 5;
				costs[1] *= 5.5;
				//tt -= 50;
				Button2.setBackground(Color.black);
				DD2[0] = true;
			}
			else if (unlPoints[1] >= 400 && DD2[1] == false) {
				up += 15;
				damageU[1] *= 4;
				costs[1] *= 4.2;
				//tt -= 50;
				Button2.setBackground(Color.pink);
				DD2[1] = true;
			}
			else if (unlPoints[1] >= 100 && DD2[2] == false) {
				up += 5;
				damageU[1] *= 3;
				costs[1] *= 3;
				tt -= 50;
				Button2.setBackground(Color.blue);
				toggle2.setVisible(true);
				DD2[2] = true;
			}
			
		}
	}
	
	// increase SLB
	public static void getMoreSLB() {
		if (currentGold >= togs[2] * costs[2]){
			currentGold -= togs[2] *costs[2];
			damage += togs[2] *damageU[2];
			inArc[2] += togs[2] *1;
			DO.setText("Current Arcenal Damage: " + damage);
			
			unlPoints[2] += togs[2];
			
			if (unlPoints[2] >= 700 && DD3[0] == false) {
				up += 25;
				damageU[2] *= 5;
				costs[2] *= 5.5;
				//tt -= 50;
				Button3.setBackground(Color.black);
				DD3[0] = true;
			}
			else if (unlPoints[2] >= 400 && DD3[1] == false) {
				up += 15;
				damageU[2] *= 4;
				costs[2] *= 4.2;
				//tt -= 50;
				Button3.setBackground(Color.pink);
				DD3[1] = true;
			}
			else if (unlPoints[2] >= 100 && DD3[2] == false) {
				up += 5;
				damageU[2] *= 3;
				costs[2] *= 3;
				tt -= 50;
				Button3.setBackground(Color.blue);
				toggle3.setVisible(true);
				DD3[2] = true;
			}
		}
	}
	
	public static void getPC() {
		if (currentGold >= togs[3] *costs[3]){
			currentGold -= togs[3] *costs[3];
			damage += togs[3] *damageU[3];
			inArc[3] += togs[3] *1;
			DO.setText("Current Arcenal Damage: " + damage);
			
			unlPoints[3] += togs[3];
			
			if (unlPoints[3] >= 700 && DD4[0] == false) {
				up += 25;
				damageU[3] *= 5;
				costs[3] *= 5.5;
				//tt -= 50;
				Button4.setBackground(Color.black);
				DD4[0] = true;
			}
			else if (unlPoints[3] >= 400 && DD4[1] == false) {
				up += 15;
				damageU[3] *= 4;
				costs[3] *= 4.2;
				//tt -= 50;
				Button4.setBackground(Color.pink);
				DD4[1] = true;
			}
			else if (unlPoints[3] >= 100 && DD4[2] == false) {
				up += 5;
				damageU[3] *= 3;
				costs[3] *= 3;
				tt -= 50;
				Button4.setBackground(Color.blue);
				toggle4.setVisible(true);
				DD4[2] = true;
			}
		}
	}
	
	//Launch Arcenal
	public static void launchArcenal(){
		mu += damage;
		if (mu >= 7000000 && md[4] == 0) {
			mm++;
			md[5] = 1;
		}
		else if (mu >= 5000000 && md[4] == 0){
			mm++;
			md[4] = 1;
		}
		else if (mu >= 400000 && md[3] == 0){
			mm++;
			md[3] = 1;
		}
		else if (mu >= 300000 && md[2] == 0){
			mm++;
			md[2] = 1;
		}
		else if (mu >= 100000 && md[1] == 0){
			mm++;
			md[1] = 1;
		}
		else if (mu >= 10000 && md[0] == 0){
			mm++;
			md[0] = 1;
		}
		
		else
	if (damage >0) {
		planetHP -= damage;		// Subract Arcenal Damage from planet.
		damage = 0;				// Arcenal becomes empty.

		if (planetHP <= 0){			// if the planet has not more hp, planet is destroyed		planetMaxHP = 200			// reset the hp for next planet
			planetsDestroyed += 1;		// One more planet has been destroyed.
			planetMaxHP *= multiplyer;
			planetHP = planetMaxHP;
			
			
		}
		for (int a=0; a<inArc.length; a++) {
			inArc[a] = 0;
		}
		DO.setText("Current Arcenal Damage: " + damage);
		resetTB();
	}
	
	}
	
	public static void resetTB() {
		t2.setText("# of TNT : " + inArc[0]);
		t3.setText("# of Nitro : " + inArc[1]);
		t4.setText("# of SLB : " + inArc[2]);
		t0.setText("# of PCM : " + inArc[3]);
	}
	
	//set gold in t1
	public static void setGold() {
		t1.setText("Gold: "+ currentGold + "   x"+(planetsDestroyed + 1 + up)*mm);
	}
	
	public static void setDO() {
		if (damage >= planetHP) {
			DO.setBackground(Color.red);
			DO.setForeground(Color.blue);
		}else {
			DO.setBackground(Color.gray);
			DO.setForeground(Color.white);
		}
	}
	
	public static void togg(int ind) {
		if (togs[ind] == 1) {
			togs[ind] = 5;
		}
		else if (togs[ind] == 5) {
			togs[ind] = 20;
		}
		else if (togs[ind] == 20) {
			togs[ind] = 50;
		}
		else if (togs[ind] == 50) {
			togs[ind] = 100;
		}
		else if (togs[ind] == 100) {
			togs[ind] = 1;
		}
	}
}


