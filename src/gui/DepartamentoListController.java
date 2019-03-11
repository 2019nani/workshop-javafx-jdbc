//departamentolist controller
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import gui.util.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.entities.Departamento;
import model.services.DepartamentoServico;

public class DepartamentoListController implements Initializable {
	private DepartamentoServico servico;

	@FXML

	private TableView<Departamento> tableviewDepartamento;

	@FXML

	private TableColumn<Departamento, Integer> tableColumnId;

	@FXML

	private TableColumn<Departamento, String> tableColumnNome;

	@FXML

	private Button NovoDepartamento;
	
	private ObservableList<Departamento> obsList;

	@FXML
	public void onBtNovoDepartamentoAction(ActionEvent event) {
		Stage parentStage = Utils.currentStage(event);
		Departamento obj = new Departamento();
		createDialogForm(obj,"/gui/DepartamentoForma.fxml", parentStage);
	}

	public void setDepartamentoServico(DepartamentoServico servico) {
		this.servico = servico;
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();

	}

	private void initializeNodes() {
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		Stage stage = (Stage) Main.getMainScene().getWindow();
		// macete tableview acompanha tamanho janela
		tableviewDepartamento.prefHeightProperty().bind(stage.heightProperty());
	}
	
	public void updateTableView() {
		if(servico == null) {
			throw new IllegalStateException("service = nulo");
		}
		List<Departamento> list = servico.findAll();
		obsList = FXCollections.observableArrayList(list);
		tableviewDepartamento.setItems(obsList);
	}
	
	private void createDialogForm(Departamento obj,String absoluteName,Stage parentStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			Pane pane = loader.load();
			 
			DepartamentoFormaControle controller = loader.getController();
			controller.setDepartamento(obj);
			controller.updateFormData();
			
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Entre com os dados do departamento");
			dialogStage.setScene(new Scene(pane));
			dialogStage.setResizable(false);
			dialogStage.initOwner(parentStage);
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.showAndWait();
			
		}
		catch(IOException e) {
			
			Alerts.showAlert("IOException", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
	}

}
