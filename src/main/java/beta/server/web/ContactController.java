/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beta.server.web;
import java.io.Serializable;
import beta.server.eao.ContactEao;
import beta.server.entity.Contact;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
/**
 * Controller for Contact
 *
 * @author jens.papenhagen
 */
@Named
@ViewScoped
public class ContactController implements Serializable {
@Inject
    ContactEao contactEao;
    
    @Getter private List <Contact> contacts;
    
    @PostConstruct
    private void contactControllerInit (){
        this.contacts = contactEao.findAll();
                }
}
