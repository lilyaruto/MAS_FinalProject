package edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461;

import edu.pjwstk.mas_project_vovkotrub_yaroslav_s18461.gui.controller.MainMenuController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;

@SpringBootApplication
public class MasProjectVovkotrubYaroslavS18461Application {

    public static void main(String[] args) {
        //SpringApplication.run(MasProjectVovkotrubYaroslavS18461Application.class, args);
        ConfigurableApplicationContext cac =
                new SpringApplicationBuilder(MasProjectVovkotrubYaroslavS18461Application.class).headless(false).run(args);
        SwingUtilities.invokeLater(()->{
            cac.getBean(MainMenuController.class).showUI();
        });
    }

}
