package com.example.oop0029;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Scene1DataGenController
{
    @javafx.fxml.FXML
    public void initialize() {
        resCB.getItems().addAll("HD", "HD+", "Full-HD", "QHD");
        diaCB.getItems().addAll(17, 19, 22, 24);

        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        resCol.setCellValueFactory(new PropertyValueFactory<>("resolution"));
        diaCol.setCellValueFactory(new PropertyValueFactory<>("diagonal"));
        ppiCol.setCellValueFactory(new PropertyValueFactory<>("ppi"));

        monTableView.setItems(monitorList);

        addMonLabel.setText("");
        addMonLabel.setVisible(false);

    }

    @javafx.fxml.FXML
    public void addMonBtn(ActionEvent actionEvent) {
        if (nameTF.getText().isEmpty() || resCB.getValue() == null || diaCB.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("All fields must be filled!");
            alert.show();
            return;
        }

        Monitor_2320676 monitor = new Monitor_2320676 (nameTF.getText(), resCB.getValue(), diaCB.getValue());

        monitorList.add(monitor);

        addMonLabel.setText("Monitor added successfully!");
        addMonLabel.setVisible(true);

        nameTF.clear();
        resCB.setValue(null);
        diaCB.setValue(null);
    }

    @FXML
    public void saveBtn(ActionEvent actionEvent) {
        try {
            FileOutputStream fos = new FileOutputStream("monitors.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(monitorList);
            oos.close();
            fos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void scene2Btn(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene2DataGenFXML.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) monTableView.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}