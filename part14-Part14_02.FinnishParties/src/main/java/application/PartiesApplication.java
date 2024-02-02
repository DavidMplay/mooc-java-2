package application;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class PartiesApplication extends Application {

    public void start(Stage stage) {
        Map<String, Map<Integer, Double>> values = new HashMap<>();
        ArrayList<Integer> years = new ArrayList<>();
        double maxValue = 0;

        try {
            Scanner scanner = new Scanner(Paths.get("partiesdata.tsv"));
            while (scanner.hasNext()) {
                String[] row = scanner.nextLine().split("\t");
                if (row[0].equals("Party")) {
                    List<String> yearStr = Arrays.asList(Arrays.copyOfRange(row, 1, row.length));
                    years = yearStr.stream().map(s -> Integer.valueOf(s)).collect(Collectors.toCollection(ArrayList::new));
                } else {
                    Map<Integer, Double> partyValues = new HashMap<>();
                    for (int i = 1; i < row.length; i++) {
                        if (row[i].equals("-")) {
                            continue;
                        }
                        Double value = Double.valueOf(row[i]);
                        if (value > maxValue) {
                            maxValue = value;
                        }
                        partyValues.put(years.get(i - 1), value);
                    }
                    values.put(row[0], partyValues);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        NumberAxis xAxis = new NumberAxis(years.get(0), years.get(years.size() - 1), 4);
        NumberAxis yAxis = new NumberAxis(0, Math.ceil(maxValue / 10) * 10, 5);

        xAxis.setLabel("Year");
        yAxis.setLabel("Relative Support (%)");

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Relative support in the years 1968-2008");

        values.keySet().stream().forEach(party -> {
            XYChart.Series data = new XYChart.Series();
            data.setName(party);

            values.get(party).entrySet().stream().forEach(pair -> {
                data.getData().add(new XYChart.Data(pair.getKey(), pair.getValue()));
            });
            lineChart.getData().add(data);
        });
        Scene view = new Scene(lineChart, 640, 480);
        stage.setScene(view);
        stage.show();
    }

    public static void main(String[] args) {
        launch(PartiesApplication.class);
    }

}
