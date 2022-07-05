package edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.gui.controller;

import edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.gui.services.VehicleService;
import edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.gui.view.SalonsVehicleList;
import edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.model.Salon;
import edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.model.Vehicle;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SalonsVehicleListController {

    private final SalonsVehicleList salonsVehicleList;
    private MainMenuController mainMenuController;

    private final VehicleService vehicleService;

    /**
     * showUI is a method for SalonsVehicleListController to get the required construction and a
     * reference to MainMenuController in order to invoke the display of this view
     * @param salon
     * @param mainMenuController reference to MainMenuController
     */
    public void showUI(Salon salon, MainMenuController mainMenuController) {
        if (this.mainMenuController == null) {
            this.mainMenuController = mainMenuController;
        }
        if (salon != null) {
            showVehicles(salon);
            showSalonName(salon);
            showSalonInfo(salon);
            this.mainMenuController.showContent(salonsVehicleList.getVehiclePanel());
        }
    }

    private void showSalonName(Salon salon) {
        salonsVehicleList.getSalonName().setText(salon.getName());
    }

    private void showVehicles(Salon salon){
        List<Vehicle> vehicles = vehicleService.getBySalon(salon);;
        DefaultListModel<Vehicle> model = salonsVehicleList.getVehicleListModel();
        model.removeAllElements();
        vehicles.forEach(model::addElement);
    }

    private void showSalonInfo(Salon salon) {
        String result = "Rating: " + salon.getRating() + "\n" +
                "Phone number: " + salon.getPhoneNumber() + "\n" +
                "Address: " + salon.getAddress().getStreet() + " " +
                salon.getAddress().getBuilding() + ", " + salon.getAddress().getCity();

        salonsVehicleList.getSalonInfoPane().setText(result);
    }

    private void showVehicleName(Vehicle vehicle) {
        String result = vehicle.getManufacturer().getName() + " " + vehicle.getModelName();
        salonsVehicleList.getVehicleName().setText(result);
    }

    private void showVehicleLogo(Vehicle vehicle) {
        ImageIcon logo = new ImageIcon(vehicle.getManufacturer().getLogo());
        Image img = logo.getImage();
        Image imgScale = img.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
        ImageIcon scaledLogo = new ImageIcon(imgScale);
        salonsVehicleList.getLogo().setIcon(scaledLogo);
    }

    private void showVehicleInfo(Vehicle vehicle) {
        String result = "Price: " + vehicle.getPrice() + "$\n" +
                "Year: " + vehicle.getProductionYear() + "\n" +
                "Power: " + vehicle.getHorsepower() + "hp\n" +
                "Mileage: " + vehicle.getKmAge() + " km";
        salonsVehicleList.getVehicleInfoPane().setText(result);
    }

    private void showServicePassport(Vehicle vehicle) {
        salonsVehicleList.getServicePassportPane().setText("Service: " + vehicle.getPassport().getServiceType());
    }

    @PostConstruct
    public void initListSalonsListener() {

        salonsVehicleList.getVehicleList().addListSelectionListener(
                e -> {
                    showVehicleName(salonsVehicleList.getVehicleList().getSelectedValue());
                    showVehicleLogo(salonsVehicleList.getVehicleList().getSelectedValue());
                    showVehicleInfo(salonsVehicleList.getVehicleList().getSelectedValue());
                    showServicePassport(salonsVehicleList.getVehicleList().getSelectedValue());
                }
        );

        salonsVehicleList.getMainMenuButton().addActionListener(
                e -> {
                    mainMenuController.showMainMenu();
                }
        );
    }
}
