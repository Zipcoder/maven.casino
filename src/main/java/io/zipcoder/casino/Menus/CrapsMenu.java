package io.zipcoder.casino.Menus;

import io.zipcoder.casino.Craps.CrapsGame;
import io.zipcoder.casino.Interfaces.Menu;
import io.zipcoder.casino.utilities.Console;

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

        console.print(" \n::::::::  :::::::::      :::     :::::::::   ::::::::  \n" +
                ":+:    :+: :+:    :+:   :+: :+:   :+:    :+: :+:    :+: \n" +
                "+:+        +:+    +:+  +:+   +:+  +:+    +:+ +:+        \n" +
                "+#+        +#++:++#:  +#++:++#++: +#++:++#+  +#++:++#++ \n" +
                "+#+        +#+    +#+ +#+     +#+ +#+               +#+ \n" +
                "#+#    #+# #+#    #+# #+#     #+# #+#        #+#    #+# \n" +
                " ########  ###    ### ###     ### ###         ########  \n\n\n");
    }

    @Override
    public void handleChoice(int choice) {

    }



}
