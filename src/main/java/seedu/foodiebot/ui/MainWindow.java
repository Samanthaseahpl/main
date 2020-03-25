package seedu.foodiebot.ui;

import java.io.IOException;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextInputControl;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import seedu.foodiebot.commons.core.GuiSettings;
import seedu.foodiebot.commons.core.LogsCenter;
import seedu.foodiebot.logic.Logic;
import seedu.foodiebot.logic.commands.CommandResult;
import seedu.foodiebot.logic.commands.DirectionsCommandResult;
import seedu.foodiebot.logic.commands.EnterCanteenCommand;
import seedu.foodiebot.logic.commands.ExitCommand;
import seedu.foodiebot.logic.commands.FavoritesCommand;
import seedu.foodiebot.logic.commands.ListCommand;
import seedu.foodiebot.logic.commands.exceptions.CommandException;
import seedu.foodiebot.logic.parser.ParserContext;
import seedu.foodiebot.logic.parser.exceptions.ParseException;

/**
 * The Main Window. Provides the basic application layout containing a menu bar and space where
 * other JavaFX elements can be placed.
 */
public class MainWindow extends NoResultDisplayWindow {

    private static final String FXML = "MainWindow.fxml";

    private final Logger logger = LogsCenter.getLogger(getClass());


    // Independent Ui parts residing in this Ui container
    private CanteenListPanel canteenListPanel;
    private ResultDisplay resultDisplay;
    @FXML
    private StackPane resultDisplayPlaceholder;

    private Logic logic;

    public MainWindow(Stage primaryStage, Logic logic) {
        super(primaryStage, logic, FXML);
        this.logic = logic;
        primaryStage.getScene().setRoot(loadFxmlFile("MainScene.fxml"));
        new MainScene(primaryStage, logic, helpMenuItem);
    }
}
