import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class TimerProgressBarDemo extends JFrame {

    // Tạo một Timer
    Timer timer;

    // Tạo một JProgressBar
    JProgressBar progressBar;

    // Tạo một JLabel
    JLabel label;

    // Tạo một biến int để lưu trữ dung lượng ban đầu
    int capacity;

    // Tạo một biến int để lưu trữ dung lượng đã copy
    int copied;

    // Constructor
    public TimerProgressBarDemo() {

        // Tạo một container
        Container container = getContentPane();
        setLocationRelativeTo(null);
        // Tạo một JPanel
        JPanel panel = new JPanel();

        // Thiết lập layout cho container
        container.setLayout(new FlowLayout());

        // Thiết lập tiêu đề cho JFrame
        setTitle("Timer-ProgressBar Demo");

        // Thiết lập kích thước cho JFrame
        setSize(300, 200);

        // Thiết lập hành động khi đóng cửa sổ
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Nhập vào dung lượng ban đầu (200MB)
        capacity = Integer.parseInt(JOptionPane.showInputDialog("Nhập vào dung lượng ban đầu (MB):"));

        // Khởi tạo dung lượng đã copy bằng 0
        copied = 0;

        // Tạo một JProgressBar với giá trị từ 0 đến 100
        progressBar = new JProgressBar(0, 100);

        // Thiết lập giá trị ban đầu cho JProgressBar bằng 0
        progressBar.setValue(0);

        // Hiển thị giá trị phần trăm trên JProgressBar
        progressBar.setStringPainted(true);

        // Tạo một JLabel để hiển thị dung lượng đã copy và dung lượng ban đầu
        label = new JLabel(copied + " MB / " + capacity + " MB");

        // Thêm JProgressBar và JLabel vào JPanel
        panel.add(progressBar);
        panel.add(label);

        // Thêm JPanel vào container
        container.add(panel);

        // Tạo một ActionListener cho Timer
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Tạo một số ngẫu nhiên từ 1 đến 5 bằng cách sử dụng lớp Random
                Random random = new Random();
                int randomNum = random.nextInt(5) + 1;

                // Cộng số ngẫu nhiên vào dung lượng đã copy
                copied += randomNum;

                // Kiểm tra nếu dung lượng đã copy vượt quá dung lượng ban đầu
                if (copied >= capacity) {

                    // Dừng Timer và hiển thị thông báo hoàn thành
                    timer.stop();
                    JOptionPane.showMessageDialog(null, "Copy hoàn thành!");

                } else {

                    // Nếu không, thì cập nhật giá trị của JProgressBar bằng tỉ lệ phần trăm của dung lượng đã copy trên dung lượng ban đầu
                    int percentage = (int) (((double) copied / capacity) * 100);
                    progressBar.setValue(percentage);

                    // Cập nhật nhãn với dung lượng đã copy và dung lượng ban đầu
                    label.setText(copied + " MB / " + capacity + " MB");
                }
            }
        };

        // Tạo một Timer với khoảng thời gian là 1000ms (1 giây)
        timer = new Timer(1000, action);

        // Bắt đầu Timer
        timer.start();

        // Hiển thị JFrame
        setVisible(true);
    }

    public static void main(String args[]) {

        // Tạo một đối tượng TimerProgressBarDemo
        new TimerProgressBarDemo();
    }
}
