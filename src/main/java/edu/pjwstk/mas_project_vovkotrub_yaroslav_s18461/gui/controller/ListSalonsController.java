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
                    System.out.println(listSalons.getSalonList().getSelectedValue());
                }
        );

        listSalons.getMainMenuButton().addActionListener(
                e -> {
                    mainMenuController.showMainMenu();
                }
        );
    }
}
