package com.example.oop0029;

public class Scene2DataGenController
{
    @javafx.fxml.FXML
    public void initialize() {

        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        resCol.setCellValueFactory(new PropertyValueFactory<>("resolution"));
        diaCol.setCellValueFactory(new PropertyValueFactory<>("diagonal"));
        ppiCol.setCellValueFactory(new PropertyValueFactory<>("ppi"));

        monTableView.setItems(monitorList);
        statusLabel.setText("");
    }

    // ---------- LOAD FROM BIN ----------
    @FXML
    public void loadFromBinBtn(ActionEvent actionEvent) {

        try {
            FileInputStream fis = new FileInputStream("monitors.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);

            monitorList.clear();
            monitorList.addAll((ObservableList<Monitor_2320676>) ois.readObject());

            ois.close();
            fis.close();

            statusLabel.setText("Data loaded successfully!");

        } catch (Exception e) {
            statusLabel.setText("Failed to load data!");
            e.printStackTrace();
        }
    }

    // ---------- BACK TO SCENE 1 ----------
    @FXML
    public void scene1Btn(ActionEvent actionEvent) {

        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("Scene1DataGenFXML.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) monTableView.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
