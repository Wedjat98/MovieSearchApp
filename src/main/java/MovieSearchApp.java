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
    Label fromLabel = new Label("From        ");
    Label toLabel = new Label("      To");
    Label listLabel = new Label("順位");
    Label yearLabel = new Label("公開年");
    TextField textField1 = new TextField();
    TextField textField2 = new TextField();
    TextField textField3 = new TextField();
    TextField textField4 = new TextField();
    HBox hBox1 = new HBox(fromLabel, toLabel);
    HBox hBox2 = new HBox(listLabel, textField1, textField2);
    HBox hBox3 = new HBox(yearLabel, textField3, textField4);
    Button searchButton = new Button("検索");
    Button resetButton = new Button("リセット");
    HBox hBox4 = new HBox(searchButton, resetButton);
    public PieChart pieChart = new PieChart();
    VBox leftVBox = new VBox(hBox1, hBox2, hBox3, hBox4,pieChart);
    BorderPane bp = new BorderPane();
    TableView table = new TableView();
    ObservableList data = null;
    TreeSet<String> sites = new TreeSet<String>();
//    Iterator<String> itr;
    List<String> list = new ArrayList<>();
    int[] frequency;
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

        Field f = allData.getField("data");
        String[] initData = (String[]) f.get(MovieData.data);
        Movie[] movies = new Movie[initData.length];

        for (int i = 0; i < initData.length; i++) {
            String[] arr = initData[i].split(", ");
            movies[i] = new Movie(Integer.parseInt(arr[0]), arr[1], Integer.parseInt(arr[2]));
            list.add(String.valueOf(movies[i].getYear()));
//            getYear(arr[2]);
            data = FXCollections.observableArrayList(movies);
        }
//      itr = sites.iterator();
        Map<String, Integer> treeMap = new TreeMap();
        for (String temp : list) {
            Integer count = (Integer) treeMap.get(temp);
            treeMap.put(temp, (count == null) ? 1 : count + 1);
        }
        PieChart.Data[] pieChartData = new PieChart.Data[treeMap.keySet().size()];
        int[] index = {0};
        treeMap.forEach((key, value)->{
//            System.out.println(key+"--"+value);
            pieChartData[index[0]] = new PieChart.Data(key, value);
            index[0]++;
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
        table.getColumns().addAll(rankCol, yearCol, nameCol);
        table.setItems(data);
        nameCol.setMinWidth(300);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        VBox rightVBox = new VBox(table);
        bp.setRight(rightVBox);
        Scene scene = new Scene(bp, 1000, 500);
        stage.setScene(scene);
        stage.show();
    }

    public void getYear(String arr) {
        sites.add(arr);
    }
    public static void main(String[] args) {
        // アプリケーションを起動する
        Application.launch(args);
        System.out.println("完了--MovieSearchApp");
    }
}

/* 考察 -- 調査したこと、考慮したこと、工夫したことを記述




 */
