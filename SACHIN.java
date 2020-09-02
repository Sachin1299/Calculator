/*<applet code="SACHIN" width="300" height="200"></applet>*/
import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class SACHIN extends Applet implements Runnable
{
    
    Thread th1,th2;
    @Override
    public void run()
    {
        th2=Thread.currentThread();
        while(th1==th2)
        {
            repaint();
            try{
                Thread.sleep(1000);
            }catch(Exception k){}
                
        }
    }
    @Override
    public void start()
    {
        th1=new Thread(this);
        th1.start();
    }
    public void paint(Graphics g)
    {
        Calendar cal=new GregorianCalendar();
        String sec=String.valueOf(cal.get(Calendar.SECOND));
        String min=String.valueOf(cal.get(Calendar.MINUTE));
        String hour=String.valueOf(cal.get(Calendar.HOUR));
        g.drawString(hour+":"+min+":"+sec, 110,10);
        g.setColor(Color.red);
    }
    TextField t1;
    TextField t2;
    
    Label l1;
    Label l2;
    Label l3;
    
    Button b1;
   
    @Override
    public void init() 
    {
        resize(300,200);
        t1=new TextField();
        t2=new TextField();
        
        l1=new Label("Enter no");
        l2=new Label("Enter no");
        l3=new Label();
        
        b1=new Button("ADD");
        setLayout(null);
        l1.setBounds(20,20,90,30);
        l2.setBounds(20,60,90,30);
        t1.setBounds(130,20,90,30);
        t2.setBounds(130,60,90,30);
        b1.setBounds(70,100,90,30);
        l3.setBounds(70,140,90,30);
        
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(b1);
        add(l3);
        
        b1.addActionListener(new Addition());
        t1.setBackground(Color.red);
        t2.setBackground(Color.red);
        //setBackground(Color.BITMASK);
    }
 
    public class Addition implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int a,b,c;
                a=Integer.parseInt(t1.getText());
                b=Integer.parseInt(t2.getText());
                c=a+b;
                String v=String.valueOf(c);
                l3.setText("SUM is :"+v);
                
                
            }
        }
    
}
    

