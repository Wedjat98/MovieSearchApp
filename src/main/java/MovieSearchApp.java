import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.lang.reflect.Field;
import java.util.*;

public class MovieSearchApp extends Application {

    public static String gakuban = "19EC601"; // 学籍番号を入力すること
    public static String yourname = "サイホウリン"; // 氏名を入力すること
    Class allData = MovieData.class;
    Label fromLabel = new Label("From           ");
    Label toLabel = new Label("         To");
    Label listLabel = new Label("順位");
    Label yearLabel = new Label("公開年");
    TextField textField1 = new TextField("");
    TextField textField2 = new TextField("");
    TextField textField3 = new TextField("");
    TextField textField4 = new TextField("");
    HBox hBox1 = new HBox(fromLabel, toLabel);
    HBox hBox2 = new HBox(listLabel, textField1, textField2);
    HBox hBox3 = new HBox(yearLabel, textField3, textField4);
    Button searchButton = new Button("検索");
    Button resetButton = new Button("リセット");
    HBox hBox4 = new HBox(searchButton, resetButton);
    public PieChart pieChart = new PieChart();
    VBox leftVBox = new VBox(hBox1, hBox2, hBox3, hBox4, pieChart);
    BorderPane bp = new BorderPane();
    TableView table = new TableView();
    ObservableList data = null;
    Movie[] movies;
    List<String> list = new ArrayList<>();
    Alert alert = new Alert(Alert.AlertType.ERROR, "入力した数字、もう一度チェックしてください！");

    String minRank;
    String maxRank;
    String minYear;
    String maxYear;
    PieChart.Data[] pieChartData;
    ObservableList<PieChart.Data> chartData;
    Map<String, Integer> treeMap = new TreeMap();

    @Override
    public void start(Stage stage) throws Exception {
        // プログラムを作成
        hBox1.setPadding(new Insets(0, 10, 10, 10));
        hBox2.setPadding(new Insets(0, 10, 10, 10));
        hBox3.setPadding(new Insets(0, 10, 10, 10));
        hBox4.setPadding(new Insets(0, 10, 10, 10));

        hBox1.setAlignment(Pos.CENTER);
        hBox2.setAlignment(Pos.CENTER);
        hBox3.setAlignment(Pos.CENTER);
        hBox4.setAlignment(Pos.CENTER);

        this.chartData =
                FXCollections.observableArrayList();

        Field f = allData.getField("data");
        String[] initData = (String[]) f.get(MovieData.data);
        movies = new Movie[initData.length];

        for (int i = 0; i < initData.length; i++) {
            String[] arr = initData[i].split(", ");
            movies[i] = new Movie(Integer.parseInt(arr[0]), arr[1], Integer.parseInt(arr[2]));
            list.add(String.valueOf(movies[i].getYear()));
        }
        data = FXCollections.observableArrayList(movies);


        for (String temp : list) {
            Integer count = treeMap.get(temp);
            treeMap.put(temp, (count == null) ? 1 : count + 1);
        }
        pieChartData = new PieChart.Data[treeMap.keySet().size()];
        int[] index = {0};
        treeMap.forEach((key, value) -> {
            pieChartData[index[0]] = new PieChart.Data(key, value);
            index[0]++;
        });

        searchButton.setOnAction(e -> {
            getValue();
            search(minRank, maxRank, minYear, maxYear);
        });
        resetButton.setOnAction(e -> {
            reset();
        });

        pieChart.setLegendVisible(false);
        pieChart.getData().addAll(pieChartData);
        pieChart.setStartAngle(90);
        bp.setLeft(leftVBox);
        TableColumn rankCol = new TableColumn("順位");
        TableColumn yearCol = new TableColumn("公開年");
        TableColumn nameCol = new TableColumn("タイトル");
        rankCol.setCellValueFactory(new PropertyValueFactory("rank"));
        yearCol.setCellValueFactory(new PropertyValueFactory("year"));
        nameCol.setCellValueFactory(new PropertyValueFactory("title"));
        nameCol.setMinWidth(300);
        table.getColumns().addAll(rankCol, yearCol, nameCol);
        table.setItems(data);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        VBox rightVBox = new VBox(table);
        bp.setRight(rightVBox);
        Scene scene = new Scene(bp, 1000, 500);
        stage.setScene(scene);
        stage.show();
    }

    public void search(String s1, String s2, String s3, String s4) {
        Movie[] resultMovies;
        data.clear();
        list.clear();
        chartData.clear();
        treeMap.clear();
        resultMovies = new Movie[movies.length];
        try {
            for (int i = (Integer.parseInt(s1) - 1); i < Integer.parseInt(s2); i++) {
                for (int j = Integer.parseInt(s3); j < Integer.parseInt(s4) + 1; j++) {
                    if (movies[i].getYear() == j && movies[i].getRank() == i + 1) {
                        resultMovies[i] = movies[i];
                        list.add(String.valueOf(resultMovies[i].getYear()));
                        data.add(resultMovies[i]);
                    }
                }
            }
        } catch (Exception e) {
            alert.showAndWait();
        }
        setPieChartData();
    }

    public void getValue() {
        minRank = textField1.getText();
        maxRank = textField2.getText();
        minYear = textField3.getText();
        maxYear = textField4.getText();
        if (minRank == null || minRank.length() == 0) {
            minRank = "1";
        }
        if (maxRank == null || maxRank.length() == 0) {
            maxRank = "100";
        }
        if (minYear == null || minYear.length() == 0) {
            minYear = "1975";
        }
        if (maxYear == null || maxYear.length() == 0) {
            maxYear = "2020";
        }
    }

    public void reset() {
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
        data.clear();
        list.clear();
        chartData.clear();
        treeMap.clear();
        pieChart.getData().clear();
    }

    public void setPieChartData() {
        for (String temp : list) {
            Integer count = treeMap.get(temp);
            treeMap.put(temp, (count == null) ? 1 : count + 1);
        }
        pieChartData = new PieChart.Data[treeMap.keySet().size()];
        treeMap.forEach((key, value) -> {
            addData(key, value);
        });
        pieChart.getData().clear();
        pieChart.getData().addAll(chartData);
    }


    public void addData(String name, int value) {
        for (javafx.scene.chart.PieChart.Data d : chartData) {
            if (d.getName().equals(name)) {
                d.setPieValue(value);
                return;
            }
        }
        chartData.add(new javafx.scene.chart.PieChart.Data(name, value));
    }

    public static void main(String[] args) {
        // アプリケーションを起動する
        Application.launch(args);
        System.out.println("完了--MovieSearchApp");
    }
}

/* 考察 -- 調査したこと、考慮したこと、工夫したことを記述
1.MovieDataを導入した時にリフレクションを使いました。そして入力したDataをStringのsplitメソードを使って、二次元配列になりました。
2.Listに全てのMovieDataの年のDataを保存されています。
3.「キー」と「値」の組によって扱うことのできるようにtreeMapを使いました。ここではtreeMapにデータを保存する時には
キーの重複を許さない点からcountという変数を使って、重複した年はcountに数えています。そして、pieChartに反映されています。
4.検索機能は2重for文で繰り返し構造の中で、さらに繰り返し処理を行いました。こういう操作で新しい配列resultMoviesにDataは入力しています。
 */
