module com.example.tme_4_part2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tme_4_part2 to javafx.fxml;
    exports com.example.tme_4_part2;
}