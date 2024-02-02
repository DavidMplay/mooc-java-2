package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application {

    public void start(Stage stage) {
        BorderPane layout = new BorderPane();
        VBox sliders = new VBox();
        BorderPane topSlider = new BorderPane();
        BorderPane bottomSlider = new BorderPane();
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis(0, 100, 10);

        Label monthlySavings = new Label("Monthly savings");
        Label annualInterestRates = new Label("Yearly interest rate");

        Slider monthsSlider = new Slider(25, 250, 25);
        Slider annualRateSlider = new Slider(0, 10, 3);

        Label currentMonthValue = new Label(monthsSlider.getValue() + "");
        Label currentAnnualRate = new Label(annualRateSlider.getValue() + "");

        monthsSlider.setMajorTickUnit(25);
        monthsSlider.setSnapToTicks(true);

        annualRateSlider.setMajorTickUnit(1);
        annualRateSlider.setSnapToTicks(true);

        monthsSlider.setShowTickLabels(true);
        monthsSlider.setShowTickMarks(true);
        annualRateSlider.setShowTickLabels(true);
        annualRateSlider.setShowTickMarks(true);

        Savings account = new Savings(monthsSlider.getValue(), annualRateSlider.getValue());

        topSlider.setLeft(monthlySavings);
        topSlider.setCenter(monthsSlider);
        topSlider.setRight(currentMonthValue);
        bottomSlider.setLeft(annualInterestRates);
        bottomSlider.setCenter(annualRateSlider);
        bottomSlider.setRight(currentAnnualRate);
        topSlider.setPadding(new Insets(20, 10, 10, 20));
        bottomSlider.setPadding(new Insets(20, 10, 10, 20));

        sliders.getChildren().addAll(topSlider, bottomSlider);
        layout.setTop(sliders);
        layout.setCenter(createLineChart(account));

        annualRateSlider.valueProperty().addListener(event -> {
            currentAnnualRate.setText((double) Math.round(annualRateSlider.getValue() * 100) / 100 + "");
            account.setMonthlyRecord(monthsSlider.getValue());
            account.setInterestRate(annualRateSlider.getValue());
            layout.setCenter(createLineChart(account));
        });
        monthsSlider.valueProperty().addListener(event -> {
            currentMonthValue.setText((double) Math.round(monthsSlider.getValue()) + "");
            account.setMonthlyRecord(monthsSlider.getValue());
            account.setInterestRate(annualRateSlider.getValue());
            layout.setCenter(createLineChart(account));
        });
        
        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();
    }

    private LineChart<Number, Number> createLineChart(Savings account) {
        NumberAxis yAxis = new NumberAxis();
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        LineChart<Number, Number> savingsLineChart = new LineChart(xAxis, yAxis);
        savingsLineChart.setTitle("Savings Calculator");
        XYChart.Series annualSavings = new XYChart.Series();
        XYChart.Series annualSavingsWithoutInterest = new XYChart.Series();
        annualSavings.setName("Savings with Interest");
        annualSavingsWithoutInterest.setName("Savings without Interest");

        for (int i = 0; i <= 30; i++) {
            annualSavingsWithoutInterest.getData().add(new XYChart.Data(i, account.getBalanceWithoutInterest()));
            annualSavings.getData().add(new XYChart.Data(i, account.getBalance()));
            account.increaseYear();
        }
        savingsLineChart.getData().add(annualSavingsWithoutInterest);
        savingsLineChart.getData().add(annualSavings);
        return savingsLineChart;
    }

    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }

}
