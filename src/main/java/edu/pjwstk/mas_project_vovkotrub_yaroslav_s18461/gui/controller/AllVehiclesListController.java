package edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.gui.controller;

import edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.gui.services.VehicleService;
import edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.gui.view.AllVehiclesList;
import edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.model.Vehicle;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AllVehiclesListController {

    private final AllVehiclesList allVehiclesList;
    private MainMenuController mainMenuController;

    private final VehicleService vehicleService;
    private final ExtendedVehicleInfoController extendedVehicleInfoController;

    public void showUI(MainMenuController mainMenuController) {
        if (this.mainMenuController == null) {
            this.mainMenuController = mainMenuController;
        }
        showAllVehicles();
        this.mainMenuController.showContent(allVehiclesList.getPanel());
    }

    private void showAllVehicles() {
        List<Vehicle> allVehicles = vehicleService.getAllVehicles();
        DefaultListModel<Vehicle> model = allVehiclesList.getAllVehicleListModel();
        model.removeAllElements();
        allVehicles.forEach(model::addElement);
    }

    @PostConstruct
    public void initListSalonsListener() {

        allVehiclesList.getAllVehiclesList().addListSelectionListener(
                e -> {
                   extendedVehicleInfoController.showUI(allVehiclesList.getAllVehiclesList().getSelectedValue(), mainMenuController);
                }
        );

        allVehiclesList.getMainMenuButton().addActionListener(
                e -> {
                    mainMenuController.showMainMenu();
                }
        );
    }
}
