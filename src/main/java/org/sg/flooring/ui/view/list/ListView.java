package org.sg.flooring.ui.view.list;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import org.sg.flooring.dtos.Customer;
import org.sg.flooring.service.CustomerService;
import org.sg.flooring.service.OrderService;
import org.sg.flooring.ui.MainLayout;


@Route(value = "", layout = MainLayout.class)
@PageTitle("Contacts | SWC Corp")
@PWA(name = "Project Base for Vaadin", shortName = "Project Base", enableInstallPrompt = false)
public class ListView extends VerticalLayout {

    private Grid<Customer> grid = new Grid<>(Customer.class);
    private CustomerService customerService;
    private TextField filterText = new TextField();
    private CustomerForm customerForm;

    public ListView(CustomerService customerService, OrderService orderService) {
        this.customerService = customerService;
        addClassName("list-view");
        setSizeFull();
        configureGrid();
//        configureFilter();

        customerForm = new CustomerForm(orderService.getOrders());
        customerForm.addListener(CustomerForm.SaveEvent.class, this::saveCustomer);
        customerForm.addListener(CustomerForm.DeleteEvent.class, this::deleteCustomer);
        customerForm.addListener(CustomerForm.CloseEvent.class, e -> closeEditor());
        Div content = new Div(grid, customerForm);
        content.addClassName("content");
        content.setSizeFull();

        add(getToolBar(), content);
        updateList();
        closeEditor();
    }

    private void deleteCustomer(CustomerForm.DeleteEvent evt) {
        customerService.deleteCustomer(evt.getCustomer().getCustomerId());
        updateList();
        closeEditor();
    }

    private void saveCustomer(CustomerForm.SaveEvent evt) {
        customerService.saveCustomer(evt.getCustomer());
        updateList();
        closeEditor();
    }

    private HorizontalLayout getToolBar() {
        filterText.setPlaceholder("Search by last name...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> updateList());

        Button addCustomerButton = new Button("Add customer", click -> addCustomer());

        HorizontalLayout toolbar = new HorizontalLayout(filterText, addCustomerButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private void addCustomer() {
        grid.asSingleSelect().clear();
        editCustomer(new Customer());
    }

    private void configureGrid() {
        grid.addClassName("customer-grid");
        grid.setSizeFull();
        grid.setColumns("customerId", "firstName", "lastName", "email");

        grid.getColumns().forEach(col -> col.setAutoWidth(true));

        grid.asSingleSelect().addValueChangeListener(e ->
                editCustomer(e.getValue()));
    }


    public void editCustomer(Customer customer) {
        if (customer == null) {
            closeEditor();
        } else {
            customerForm.setCustomer(customer);
            customerForm.setVisible(true);
            addClassName("editing");
        }
    }

    private void closeEditor() {
        customerForm.setCustomer(null);
        customerForm.setVisible(false);
        removeClassName("editing");
    }

//    private void configureFilter() {
//        filterText.setPlaceholder("Search by Last Name");
//        filterText.setClearButtonVisible(true);
//        // text field will notify when changes are made
//        filterText.setValueChangeMode(ValueChangeMode.LAZY);
//        filterText.addValueChangeListener(e -> updateList());
//    }

    private void updateList() {
        grid.setItems(customerService.getCustomers(filterText.getValue()));
    }
}
