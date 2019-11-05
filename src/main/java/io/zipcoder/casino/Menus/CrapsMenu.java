package io.zipcoder.casino.Menus;

import io.zipcoder.casino.Craps.CrapsGame;
import io.zipcoder.casino.Interfaces.Menu;
import io.zipcoder.casino.Utilities.Console;

public class CrapsMenu implements Menu {

    private Console console;
    private String name = "Craps Menu";

    public CrapsMenu(CrapsGame crapsGame) {
        this.console = new Console (System.in, System.out);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void displayMenu() {
        console.clearScreen();

        console.println("Craaaaaps");
    }

    @Override
    public void handleChoice(int choice) {

    }

    public void displayPointRoll (Integer setThePointRoll){
        console.clearScreen();
        console.println(String.format("You have rolled a: %d on your first roll", setThePointRoll));
    }

}
