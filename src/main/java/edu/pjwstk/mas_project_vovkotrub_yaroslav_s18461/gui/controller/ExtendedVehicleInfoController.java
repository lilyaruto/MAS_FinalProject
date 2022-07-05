package edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.gui.controller;

import edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.gui.view.ExtendedVehicleInfo;
import edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.model.Vehicle;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class ExtendedVehicleInfoController {

    private MainMenuController mainMenuController;
    private final ExtendedVehicleInfo extendedVehicleInfo;

    public void showUI(Vehicle vehicle, MainMenuController mainMenuController) {
        if (this.mainMenuController == null) {
            this.mainMenuController = mainMenuController;
        }
        if (vehicle != null) {
            showVehicleName(vehicle);
            showVehicleInfo(vehicle);
            showVehiclePassport(vehicle);
            this.mainMenuController.showContent(extendedVehicleInfo.getPanel());
        }
    }

    private void showVehicleName(Vehicle vehicle) {
        String result = vehicle.getManufacturer().getName() + " " + vehicle.getModelName();
        extendedVehicleInfo.getVehicleNamePane().setText(result);
    }

    private void showVehicleInfo(Vehicle vehicle) {
        if (vehicle.getOwner() == null) {
            String result = "Price: " + vehicle.getPrice() + "$\n" +
                    "Year: " + vehicle.getProductionYear() + "\n" +
                    "Power: " + vehicle.getHorsepower() + "hp\n" +
                    "Salon: " + vehicle.getSalon().getName() + "hp\n" +
                    "Power unit: " + vehicle.getPowerUnit().getName() + "\n" +
                    "Mileage: " + vehicle.getKmAge() + " km";
            extendedVehicleInfo.getVehicleInfoPane().setText(result);
        } else {
            String result = "Price: " + vehicle.getPrice() + "$\n" +
                    "Year: " + vehicle.getProductionYear() + "\n" +
                    "Power: " + vehicle.getHorsepower() + "hp\n" +
                    "Owner: " + vehicle.getOwner().getSurname() + " " + vehicle.getOwner().getName() + "\n" +
                    "Power unit: " + vehicle.getPowerUnit().getName() + "\n" +
                    "Mileage: " + vehicle.getKmAge() + " km";
            extendedVehicleInfo.getVehicleInfoPane().setText(result);
        }
    }

    private void showVehiclePassport(Vehicle vehicle) {
        String result = "Service type: " + vehicle.getPassport().getServiceType() + "\n" +
                "Service centre: " + vehicle.getPassport().getServiceCentre().getName() + "\n" +
                "Date of service: " + vehicle.getPassport().getDate() + "\n";
                extendedVehicleInfo.getVehicleInfoPane2().setText(result);
    }

    @PostConstruct
    public void initListSalonsListener() {

        extendedVehicleInfo.getMainMenuButton().addActionListener(
                e -> {
                    mainMenuController.showMainMenu();
                }
        );
    }
}
