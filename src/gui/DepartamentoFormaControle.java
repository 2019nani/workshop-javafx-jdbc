package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Departamento;

public class DepartamentoFormaControle implements Initializable {
	private Departamento entity;

	@FXML
	private TextField txtId;
	
	@FXML
	private TextField txtNome;
	
	@FXML
	private Label labelerrorNome;
	
	@FXML
	private Button btSave;
	
	@FXML
	private Button btCancela;
	
	public void setDepartamento(Departamento entity) {
		this.entity = entity;
	}
	
	@FXML
	public void onbtSaveAction() {
		System.out.println("Save");
	}
	
	@FXML
	public void onbtCancelaAction() {
		System.out.println("Cancela");
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
		initializeNodes();
	}
	
	private void initializeNodes() {
		
		Constraints.setTextFieldInteger(txtId);
		Constraints.setTextFieldMaxLength(txtNome, 30);
	}
	public void updateFormData() {
		if(entity == null) {
			throw new IllegalStateException("entity was off");
		}
		txtId.setText(String.valueOf(entity.getId()));
		txtNome.setText(entity.getNome());
		
	}

}
