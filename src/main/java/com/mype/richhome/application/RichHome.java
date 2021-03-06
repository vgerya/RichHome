package com.mype.richhome.application;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.mype.richhome.application.guice.RichHomeModule;
import com.mype.richhome.ui.view.GeneralView;
import com.mype.richhome.ui.view.GeneralViewImpl;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * @author Vitaliy Gerya
 */
public class RichHome extends Application {
    private Pane generalView;

    public static void main(String[] args) {
        Application.launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Injector injector = Guice.createInjector(new RichHomeModule());
        GeneralView generalView = injector.getInstance(GeneralViewImpl.class);
        Scene scene = new Scene(this.generalView = generalView.getView());
        scene.getStylesheets().addAll(RichHome.class.getResource("/fx/css/GeneralView.css").toExternalForm());

//        this.generalView.prefWidthProperty().bind(scene.widthProperty());
//        this.generalView.prefHeightProperty().bind(scene.heightProperty());

        stage.setScene(scene);
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(final WindowEvent event) {
                // TODO save position and size of window from here, session information, last opened tab.
            }
        });
        stage.show();
    }
}
