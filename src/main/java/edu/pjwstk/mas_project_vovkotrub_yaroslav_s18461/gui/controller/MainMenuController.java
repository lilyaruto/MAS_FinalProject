package edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.gui.controller;

import edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.gui.view.MainMenu;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * MainMenuController controls the content of the MainMenu
 */
@Component
@RequiredArgsConstructor
public class MainMenuController {

    private final MainMenu mainMenu;
    private final ListSalonsController listSalonsController;
    private final AllVehiclesListController allVehiclesListController;

    /**
     * Sets the main frame visible
     */
    public void showUI() {
        mainMenu.setVisible(true);
    }

    @PostConstruct
    public void initMainMenuListeners() {
        mainMenu.getSalonsButton().addActionListener(
                e -> {
                    listSalonsController.showUI(this);
                }
        );

        mainMenu.getAllVehicleButton().addActionListener(
                e -> {
                    allVehiclesListController.showUI(this);
                }
        );

        mainMenu.getExitButton().addActionListener(
                e -> {
                    System.exit(0);
                }
        );
        SaveComponents();
    }

    /**
     * Shows the JPanel, which given as a parameter for content pane of the displayed frame
     * @param panel
     */
    public void showContent(JPanel panel) {
        mainMenu.getContentPane().removeAll();
        mainMenu.getContentPane().add(panel);
        mainMenu.setVisible(true);
        mainMenu.setSize(699, 519);
        mainMenu.setSize(700, 520);
    }



    public void showMainMenu() {

        mainMenu.getContentPane().removeAll();
        mainMenu.getContentPane().setLayout(new GridBagLayout());
        for (int i = 0; i < components.length; i++) {
            mainMenu.getContentPane().add(components[i], ctx.get(i));
        }
        mainMenu.setVisible(true);
        mainMenu.setSize(699, 519);
        mainMenu.setSize(700, 520);
    }
    private void SaveComponents() {
        LayoutManager layoutManager = mainMenu.getContentPane().getLayout();

        components = mainMenu.getContentPane().getComponents();
        ctx = new ArrayList<>();
        for (java.awt.Component component :
                components) {
            ctx.add(((GridBagLayout) layoutManager).getConstraints(component));
        }

    }

    private java.awt.Component[] components;
    private java.util.List<GridBagConstraints> ctx;
}
