
import javaapplication2.entities.Category;
import javaapplication2.entities.Service;
import javaapplication2.services.CategoryCrud;
import javaapplication2.services.ServiceCrud;
import javaapplication2.utils.MyConnection;

public class MainClass {
    public static void main(String[] args) {
        MyConnection mc = new MyConnection();
//        CategoryCrud crud = new CategoryCrud();
//        ServiceCrud scrud = new ServiceCrud();
        
//        // Create or retrieve the category from the database
//        Category category = crud.getCategoryByName("helo");
//        
//        if (category == null) {
//            // Category does not exist, create it
//            category = new Category();
//            category.setImage("aaa");
//            category.setName("helo");
//            crud.ajouterCategory2(category);
//        }
//        
//        // Now, you can add the service with the existing or newly created category
//        Service service = new Service();
//        service.setName("hhhh");
//        service.setCategory(category);
//        scrud.ajouterService(service);
        ////
//          ServiceCrud serviceCrud = new ServiceCrud();

        // Call chercherService with a service name you expect to find
//        String serviceNameToFind = "ffffff"; // Replace with an actual service name
//        Service foundService = serviceCrud.chercherService(serviceNameToFind);
//
//        // Check if the service was found
//        if (foundService != null) {
//            System.out.println("Service found with ID: " + foundService.getId());
//            System.out.println("Service Name: " + foundService.getName());
//            System.out.println("Category ID: " + foundService.getCategory().getId());
//            System.out.println("Category Name: " + foundService.getCategory().getName());
//        } else {
//            System.out.println("Service not found.");
//        }
        

    }
}
