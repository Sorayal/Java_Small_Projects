package starleague.widget;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class WidgetApp extends Application {

  private final Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();

  public static void main(String[] args) {
    launch();
  }

  @Override
  public void start(Stage primaryStage) {

    HBox root = buildRoot();
    List<Button> controlButtons = buildControlButtons();
    root.getChildren().addAll(controlButtons);
    Scene mainScene = buildMainScene(root);

    primaryStage.setScene(mainScene);
    primaryStage.setX((screenSize.getWidth() / 2) - 170);
    primaryStage.setY(0.0);
    primaryStage.initStyle(StageStyle.TRANSPARENT);
    primaryStage.show();
  }

  private HBox buildRoot() {
    HBox root = new HBox();
    root.setPrefSize(340.0, 64.5);
    root.setSpacing(10.0);
    root.setPadding(new Insets(0, 10, 0, 10));
    root.setAlignment(Pos.CENTER);
    return root;
  }

  private List<Button> buildControlButtons() {
    Button btn1 = new Button();
    Button btn2 = new Button();
    Button btn3 = new Button();
    Button btn4 = new Button();
    Button btn5 = new Button();

    btn1.setOnAction(event -> getHostServices().showDocument("https://www.youtube.com/"));
    btn2.setOnAction(event -> getHostServices().showDocument("https://www.amazon.com/"));
    btn3.setOnAction(event -> getHostServices().showDocument("https://www.facebook.com/"));
    btn4.setOnAction(event -> getHostServices().showDocument("https://www.twitter.com/"));
    btn5.setOnAction(event -> Platform.exit());

    List<Button> buttons = Arrays.asList(btn1, btn2, btn3, btn4, btn5);

    AtomicInteger i = new AtomicInteger(1);
    buttons.forEach(button -> {
      button.setPrefSize(64.5, 64.5);
      button.getStyleClass().add("btn" + i);
      i.getAndIncrement();
    });
    return buttons;
  }

  private Scene buildMainScene(HBox root) {
    Scene scene = new Scene(root);
    scene.setFill(Color.TRANSPARENT);
    try{
      scene.getStylesheets()
          .add(Objects.requireNonNull(getClass().getResource("/css/app.css")).toExternalForm());
    }catch (NullPointerException e){
      e.printStackTrace();
    }
    return scene;
  }
}