package edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.gui.controller;

import edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.gui.services.SalonService;
import edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.gui.view.ListSalons;
import edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.model.Salon;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ListSalonsController {

    private final ListSalons listSalons;
    private MainMenuController mainMenuController;
    private final SalonsVehicleListController salonsVehicleListController;

    private final SalonService salonService;

    /**
     * showUI is a method for ListSalonsController to get the required construction and a
     * reference to MainMenuController in order to invoke the display of this view
     * @param mainMenuController reference to MainMenuController
     */
    public void showUI(MainMenuController mainMenuController) {
        if (this.mainMenuController == null) {
            this.mainMenuController = mainMenuController;
        }
        showAllSalons();
        this.mainMenuController.showContent(listSalons.getSalonPanel());
    }

    private void showAllSalons() {
        List<Salon> allSalons = salonService.getAllSalons();
        DefaultListModel<Salon> model = listSalons.getSalonListModel();
        model.removeAllElements();
        allSalons.forEach(model::addElement);
    }

    @PostConstruct
    public void initListSalonsListener() {

        listSalons.getSalonList().addListSelectionListener(
                e -> {
                    salonsVehicleListController.showUI(listSalons.getSalonList().getSelectedValue(), mainMenuController);
                }
        );

        listSalons.getMainMenuButton().addActionListener(
                e -> {
                    mainMenuController.showMainMenu();
                }
        );
    }
}
