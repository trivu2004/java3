import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class JSliderDemo extends JFrame implements ChangeListener {

    // Tạo một JSlider
    JSlider slider;

    // Tạo một JLabel
    JLabel label;

    // Constructor
    public JSliderDemo() {

        // Tạo một container
        Container container = getContentPane();
        setLocationRelativeTo(null);

        // Tạo một JPanel
        JPanel panel = new JPanel();

        // Thiết lập layout cho container
        container.setLayout(new FlowLayout());

        // Thiết lập tiêu đề cho JFrame
        setTitle("JSlider Demo");

        // Thiết lập kích thước cho JFrame
        setSize(400, 200);

        // Thiết lập hành động khi đóng cửa sổ
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tạo một JSlider với hướng ngang và giá trị từ 0 đến 50
        slider = new JSlider(JSlider.HORIZONTAL, 0, 50, 45);

        // Thiết lập khoảng cách giữa các dấu gạch chính và phụ
        slider.setMajorTickSpacing(5);
        slider.setMinorTickSpacing(0);

        // Hiển thị các dấu gạch và nhãn trên JSlider
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        // Thêm ChangeListener cho JSlider
        slider.addChangeListener(this);

        // Tạo một JLabel để hiển thị giá trị của JSlider
        label = new JLabel("Giá trị hiện tại: " + slider.getValue());

        // Thêm JSlider và JLabel vào JPanel
        panel.add(slider);
        panel.add(label);

        // Thêm JPanel vào container
        container.add(panel);

        // Hiển thị JFrame
        setVisible(true);
    }

    // Phương thức xử lý sự kiện khi người dùng thay đổi giá trị của JSlider
    public void stateChanged(ChangeEvent e) {
        
        // Lấy nguồn của sự kiện (JSlider)
        JSlider source = (JSlider) e.getSource();

        // Nếu người dùng không đang điều chỉnh giá trị của JSlider
        if (!source.getValueIsAdjusting()) {

            // Lấy giá trị hiện tại của JSlider
            int value = source.getValue();

            // Cập nhật nhãn với giá trị mới
            label.setText("Giá trị hiện tại: " + value);
            
            // Có thể thực hiện các hành động khác với giá trị này

            
        }
    }

    public static void main(String args[]) {
        
        // Tạo một đối tượng JSliderDemo
        new JSliderDemo();
    }
}
