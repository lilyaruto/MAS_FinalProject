package edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.gui.view;

import edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.model.Vehicle;
import lombok.Data;
import org.springframework.stereotype.Controller;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.util.Locale;

@Data
@Controller
public class SalonsVehicleList {
    private JButton mainMenuButton;
    private JPanel vehiclePanel;
    private JList<Vehicle> vehicleList;
    private DefaultListModel<Vehicle> vehicleListModel;

    private void createUIComponents() {
        vehicleListModel = new DefaultListModel<>();
        vehicleList = new JList<>(vehicleListModel);
        vehicleList.setCellRenderer(new VehicleListCellRender());
    }

    private class VehicleListCellRender extends JLabel implements ListCellRenderer<Vehicle> {

        public VehicleListCellRender() {
            setOpaque(true);
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends Vehicle> jList, Vehicle vehicle, int i, boolean b, boolean b1) {
            setText(vehicle.getManufacturer().getName() + " " + vehicle.getModelName());
            setFont(new Font("Century Gothic", Font.BOLD, 18));
            if (b) {
                setBackground(jList.getSelectionBackground());
                setForeground(jList.getSelectionForeground());
            } else {
                setBackground(jList.getBackground());
                setForeground(jList.getForeground());
            }
            return this;
        }
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        vehiclePanel = new JPanel();
        vehiclePanel.setLayout(new GridBagLayout());
        vehiclePanel.setMaximumSize(new Dimension(700, 520));
        vehiclePanel.setMinimumSize(new Dimension(700, 520));
        vehiclePanel.setPreferredSize(new Dimension(700, 520));
        mainMenuButton = new JButton();
        mainMenuButton.setBackground(new Color(-16728833));
        Font mainMenuButtonFont = this.$$$getFont$$$("Century Gothic", Font.BOLD, 20, mainMenuButton.getFont());
        if (mainMenuButtonFont != null) mainMenuButton.setFont(mainMenuButtonFont);
        mainMenuButton.setForeground(new Color(-1));
        mainMenuButton.setMaximumSize(new Dimension(196, 60));
        mainMenuButton.setMinimumSize(new Dimension(196, 60));
        mainMenuButton.setPreferredSize(new Dimension(196, 60));
        mainMenuButton.setText("Main menu");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(15, 0, 15, 0);
        vehiclePanel.add(mainMenuButton, gbc);
        final JScrollPane scrollPane1 = new JScrollPane();
        scrollPane1.setMaximumSize(new Dimension(300, 600));
        scrollPane1.setMinimumSize(new Dimension(300, 600));
        scrollPane1.setPreferredSize(new Dimension(300, 600));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(15, 0, 0, 0);
        vehiclePanel.add(scrollPane1, gbc);
        vehicleList.setMaximumSize(new Dimension(300, 600));
        vehicleList.setMinimumSize(new Dimension(300, 600));
        vehicleList.setPreferredSize(new Dimension(300, 600));
        scrollPane1.setViewportView(vehicleList);
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return vehiclePanel;
    }

}
