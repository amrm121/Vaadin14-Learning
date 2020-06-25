package com.vaadin.training.layouting.exercises.ex2;

import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.dom.ElementFactory;
import com.vaadin.flow.router.Route;
import com.vaadin.training.layouting.exercises.MainLayout;

@Route(value = UseFormLayout.ROUTE, layout = MainLayout.class)
public class UseFormLayout extends VerticalLayout {
    public static final String ROUTE = "ex2";
    public static final String TITLE = "Exercise 2";

    public UseFormLayout(){
        setSizeFull();

        FormLayout formLayout = new FormLayout(); //formLayout é a interface Layout. Nesse caso, o layout de formulário específico

        TextField firstName = new TextField();
        firstName.setWidth("100%");
        formLayout.addFormItem(firstName, "First Name"); //adiciono o text de variavel firstName ao Layout do formulario, formLayout.

        TextField lastName = new TextField();
        lastName.setWidth("100%");
        formLayout.addFormItem(lastName, "Last Name");

        TextField email = new TextField();
        email.setWidth("100%");
        formLayout.addFormItem(email, "Email").getElement().setAttribute("colspan", "2"); //Ler a documentação sobre atributos em formLayout * colspan

        FlexLayout phoneLayout = new FlexLayout();
        phoneLayout.setAlignItems(Alignment.END);
        phoneLayout.setWidth("100%");
        TextField phone = new TextField();

        phoneLayout.add(phone, new Checkbox("Do not call"));
        phoneLayout.expand(phone);
        FormLayout.FormItem item = formLayout.addFormItem(phoneLayout, "Phone");
        item.getElement().setAttribute("colspan", "2");

        PasswordField password = new PasswordField();
        password.setWidth("100%");
        formLayout.addFormItem(password, "Password");

        formLayout.getElement().appendChild(ElementFactory.createBr());
        /**
         * or use html br component
         * formLayout.add(new Html("<br/>"));
         */

        PasswordField repeatPassword = new PasswordField();
        repeatPassword.setWidth("100%");
        formLayout.addFormItem(repeatPassword, "Repeat Password");

        add(formLayout);

        Div div = new Div();
        div.setText("Replace me with a form layout");
        div.add();
        add(div);
    }
}
