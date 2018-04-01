package com.dex.fridge;

import com.dex.fridge.views.MainView;
import com.dex.fridge.views.RecipeView;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.layout.layer.SidePopupView;
import com.gluonhq.charm.glisten.visual.Swatch;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class FridgeDex extends MobileApplication {

    public static final String MAIN_VIEW = HOME_VIEW;
    public static final String RECIPE_VIEW = "Recipe View";
    public static final String MENU_LAYER = "Side Menu";
    
    @Override
    public void init() {
        addViewFactory(MAIN_VIEW, () -> new MainView(MAIN_VIEW));
        addViewFactory(RECIPE_VIEW, () -> new RecipeView(RECIPE_VIEW));
        addLayerFactory(MENU_LAYER, () -> new SidePopupView(new DrawerManager().getDrawer()));
    }

    @Override
    public void postInit(Scene scene) {
        Swatch.GREEN.assignTo(scene);

        scene.getStylesheets().add(FridgeDex.class.getResource("style.css").toExternalForm());
        ((Stage) scene.getWindow()).getIcons().add(new Image(FridgeDex.class.getResourceAsStream("/icon.png")));
    }
}
