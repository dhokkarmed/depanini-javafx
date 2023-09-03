package javaapplication2.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javaapplication2.entities.Category;
import javaapplication2.entities.Service;
import javaapplication2.services.CategoryCrud;
import javaapplication2.services.ServiceCrud;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;

public class ServiceController implements Initializable {

    @FXML
    private Button btnAddService;

    @FXML
    private Button btnDeleteService;

    @FXML
    private Button btnUpdateService;
    @FXML
    private Button btnFindService;

    @FXML
    private ComboBox<String> categoryCombo;
       @FXML
    private TableColumn<Service, Integer> categoryId;

    @FXML
    private TableColumn<Service, Integer> serviceIDCol;

    @FXML
    private TableColumn<Service, String> serviceNameCol;

    @FXML
    private TableView<Service> servicesTable;

    @FXML
    private TextField tfServiceName;
     @FXML
    private TextField tfServiceNameSearch;

    private ServiceCrud serviceCrud;
    private CategoryCrud categoryCrud;

    private ObservableList<Category> categoryList;
    private ObservableList<Service> serviceList;

  @Override
public void initialize(URL location, ResourceBundle resources) {
    serviceCrud = new ServiceCrud();
    categoryCrud = new CategoryCrud();

    // Load categories into the ComboBox
    ObservableList<String> categoryNames = FXCollections.observableArrayList(categoryCrud.getCategoryNames());

    // Set the category names in the ComboBox
    categoryCombo.setItems(categoryNames);

    // Configure the TableView
    serviceIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
    serviceNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

    // Add this code to configure the categoryId column
    categoryId.setCellValueFactory((CellDataFeatures<Service, Integer> param) -> new SimpleObjectProperty<>(param.getValue().getCategory() != null ? param.getValue().getCategory().getId() : null));

    // Load services into the TableView
    loadServices();
}


 @FXML
void addService(ActionEvent event) {
    String serviceName = tfServiceName.getText();
    String categoryName = categoryCombo.getValue();

    if (serviceName != null && categoryName != null) {
        // Fetch the Category object corresponding to the selected category name
        Category selectedCategory = categoryCrud.getCategoryByName(categoryName);

        if (selectedCategory != null) {
            Service service = new Service();
            service.setName(serviceName);
            service.setCategory(selectedCategory);

            serviceCrud.ajouterService(service);

            // Clear the input fields
            tfServiceName.clear();

            // Reload the services in the TableView
            loadServices();
        } else {
            showAlert("Error", "Selected category not found.");
        }
    } else {
        showAlert("Error", "Please fill in all the required fields.");
    }
}

    @FXML
    void deleteService(ActionEvent event) {
        Service selectedService = servicesTable.getSelectionModel().getSelectedItem();

        if (selectedService != null) {
            serviceCrud.supprimerService(selectedService.getId());

            // Reload the services in the TableView
            loadServices();
        } else {
            showAlert("Error", "Please select a service to delete.");
        }
    }

 @FXML
void findService(ActionEvent event) {
    String serviceName = tfServiceNameSearch.getText();
    Service foundService = serviceCrud.chercherService(serviceName);

    if (foundService != null) {
        String message = "Service found with ID: " + foundService.getId() + "\nCategory: " + foundService.getCategory().getName();
        showAlert("Service Found", message);
    } else {
        showAlert("Service Not Found", "Service with the provided name not found.");
    }
}



@FXML
void updateService(ActionEvent event) {
    Service selectedService = servicesTable.getSelectionModel().getSelectedItem();
    String updatedServiceName = tfServiceName.getText();
    String categoryName = categoryCombo.getValue();

    if (selectedService != null && updatedServiceName != null && categoryName != null) {
        // Fetch the Category object corresponding to the selected category name
        Category updatedCategory = categoryCrud.getCategoryByName(categoryName);

        if (updatedCategory != null) {
            selectedService.setName(updatedServiceName);
            selectedService.setCategory(updatedCategory);

            serviceCrud.modifierService(selectedService.getId(), updatedServiceName, updatedCategory);

            // Clear the input fields
            tfServiceName.clear();

            // Reload the services in the TableView
            loadServices();

            showAlert("Service Updated", "Service has been updated successfully.");
        } else {
            showAlert("Error", "Selected category not found.");
        }
    } else {
        showAlert("Error", "Please select a service, and fill in all the required fields.");
    }
}

    private void loadServices() {
        // Load services from the serviceCrud and update the TableView
        serviceList = FXCollections.observableArrayList(serviceCrud.afficherServices());
        servicesTable.setItems(serviceList);
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
