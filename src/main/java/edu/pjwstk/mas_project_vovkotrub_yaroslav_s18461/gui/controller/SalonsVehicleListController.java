package edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.gui.controller;

import edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.gui.services.VehicleService;
import edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.gui.view.SalonsVehicleList;
import edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.model.Salon;
import edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.model.Vehicle;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SalonsVehicleListController {

    private final SalonsVehicleList salonsVehicleList;
    private ListSalonsController listSalonsController;
    private MainMenuController mainMenuController;

    private final VehicleService vehicleService;

    public void showUI(Salon salon, MainMenuController mainMenuController) {
        if (this.mainMenuController == null) {
            this.mainMenuController = mainMenuController;
        }
        if (salon != null) {
            showVehicles(salon);
            this.mainMenuController.showContent(salonsVehicleList.getVehiclePanel());
        }
    }

    private void showVehicles(Salon salon){
        List<Vehicle> vehicles = vehicleService.getBySalon(salon);;
        DefaultListModel<Vehicle> model = salonsVehicleList.getVehicleListModel();
        model.removeAllElements();
        vehicles.forEach(model::addElement);
    }

    @PostConstruct
    public void initListSalonsListener() {

        salonsVehicleList.getMainMenuButton().addActionListener(
                e -> {
                    mainMenuController.showMainMenu();
                }
        );
    }
}
