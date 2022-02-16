import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
* 订票界面
* */
public class BookingView extends JFrame implements ActionListener {
    JButton BookTicket,ReturnTicket;
    JTextArea ShowMessage;
    JComboBox comboBox;


    public BookingView(){
        setLayout(null);
        Container pane = this.getContentPane();
        pane.setLayout(null);
        ImageIcon icon1=new ImageIcon("G:\\JavaProtect_Swing\\resources\\demo2.jpg" );
        //添加JLabel 放置图片
        JLabel label1=new JLabel(icon1);
        //设置label的位置、大小，label大小为图片的大小
        label1.setBounds(0,0,icon1.getIconWidth(),icon1.getIconHeight());
        //在窗口底层容器添加label
        this.getLayeredPane().add(label1,new Integer(Integer.MIN_VALUE));
        JPanel panelTop;
        panelTop=(JPanel)this.getContentPane();
        panelTop.setOpaque(false);
        BookTicket =new JButton("订票");
        BookTicket.setSize(120,35);
        BookTicket.setLocation(435,300);
        pane.add(BookTicket);
        ReturnTicket = new JButton("退票");
        ReturnTicket.setSize(120, 35);
        ReturnTicket.setLocation(300,400);
        pane.add(ReturnTicket);
        ShowMessage =new JTextArea();
        ShowMessage.setSize(200,100);
        ShowMessage.setLocation(570, 500);
        pane.add(ShowMessage);
        comboBox = new JComboBox();
        String[] strArray = {"长津湖之水门桥","奇迹.笨小孩","新蜘蛛侠","狙击手","王牌特工:源起","这个杀手不太冷静","喜羊羊与灰太狼之匡出未来","雷神4"};
        for (String item : strArray)
        {
            comboBox.addItem(item);
        }
        comboBox.setLocation(400,500);
        comboBox.setSize(150,30);
//        Label label2 = new Label("电影:");
//        label2.setSize(50,25);
//        label2.setLocation(100,500);
//        pane.add(label2);
//        pane.add(comboBox);
//        setSize(900,900);
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        setVisible(true);
//        setLocationRelativeTo(null);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        BookingView bookingView = new BookingView();
        bookingView.setTitle("订票");
    }
}
