import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
*主界面
* */
public class Mainview extends JFrame implements ActionListener {
    JButton BookTickets;
    IndexView view;

    public Mainview(){
        setLayout(null);
        Container pane = this.getContentPane();
        pane.setLayout(null);
        //插入图片
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
        BookTickets=new JButton("进入订票大厅");
        BookTickets.setSize(120,35);
        BookTickets.setLocation(435,300);
        BookTickets.addActionListener(this);
        BookTickets.setOpaque(false);
        pane.add(BookTickets);
        view = new IndexView();
        view.setLocation(50,190);
        view.setSize(900,600);
        view.setOpaque(false);
        pane.add(view);

        JComboBox comboBox = new JComboBox();
        String[] strArray = { "学生", "军人", "工人" };
        for (String item : strArray)
        {
            comboBox.addItem(item);
        }
        comboBox.setLocation(450,500);
        comboBox.setSize(80,30);
        pane.add(comboBox);
        setSize(1000,800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
     }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (view.IntoBook()){
            JOptionPane.showMessageDialog(null,"进入成功","恭喜",JOptionPane.WARNING_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,"进入失败","抱歉",JOptionPane.WARNING_MESSAGE);
        }
    }
    public static void main(String[] args) {
        Mainview mainview = new Mainview();
        mainview.setTitle("主页面");
    }
}
