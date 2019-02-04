/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beta.web.presenter;
import java.io.Serializable;
import beta.server.eao.ContactEao;
import beta.server.entity.Contact;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import lombok.Getter;
/**
 * Controller for Contract
 *
 * @author jens.papenhagen
 */
public class ContactController implements Serializable {
@Inject
    ContactEao contactEao;
    
    @Getter private List <Contact> contacts;
    
    @PostConstruct
    private void contactControllerInit (){
        this.contacts = contactEao.findAll();
                }
}
