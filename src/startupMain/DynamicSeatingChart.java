import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class DynamicSeatingChart {

    private int rows = 10;
    private int columns = 10;
    private Icon res = (UIManager.getIcon("OptionPane.errorIcon"));

    public DynamicSeatingChart() {
        JPanel panel = new JPanel(new GridLayout(columns, rows));
        for (int row = 1; row < rows; row++) {
            for (int column = 1; column < columns; column++) {
                final JToggleButton button = new JToggleButton("Row " + row + " Seat " + column);
                button.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
                        boolean selected = abstractButton.getModel().isSelected();
                        if (selected) {
                            button.setIcon(res);
                        } else {
                            button.setIcon(null);
                        }
                    }
                });
                panel.add(button);
            }
        }
        final JFrame frame = new JFrame("Please select available seats");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setLocation(150, 150);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                DynamicSeatingChart dynamicSeatingChart = new DynamicSeatingChart();
            }
        });
    }
}
