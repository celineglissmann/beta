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
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;

/**
 * Controller for Contact
 * splits the adresses in city, zipcode,country, street 
 * collect all communications from contact 
 * @author celine.glissmann
 */
@Named
@ViewScoped
public class ContactController implements Serializable {

    @Inject
    ContactEao contactEao;

    @Getter
    private List<Contact> contacts;
/**
 * intializes a list 
 */
    @PostConstruct
    private void contactControllerInit() {
        this.contacts = contactEao.findAll();
    }
/**
 * 
 * @param contact
 * @return the Zip-Code from the adresses
 */
    public String zipCode(Contact contact) {
        return contact.getAddresses()
               .stream()
               .map(add -> add.getZipCode())
               .collect(Collectors.joining("</br>"));
         

    }
    /**
     * 
     * @param contact
     * @return the city from the adresses 
     */
    public String city(Contact contact) {
        return contact.getAddresses()
                .stream()
                .map(add -> add.getCity())
                .collect(Collectors.joining("</br>"));

    }
    /**
     * 
     * @param contact
     * @return the country from the adresses
     */
    public String country(Contact contact) {
        return contact.getAddresses()
                .stream()
                .map(add -> add.getCountry().getCountryName())
                .collect(Collectors.joining("</br>"));

    }
    /**
     * 
     * @param contact
     * @return the street from the adresses
     */
    public String street(Contact contact) {
        return contact.getAddresses()
                .stream()
                .map(add -> add.getStreet())
                .collect(Collectors.joining("</br>"));

    }
    /**
     * 
     * @param contact
     * @return all communication ways from the contacts
     */
    public String communication(Contact contact){
        return contact.getCommunications()
                .stream()
                .map(com -> com.getType()+ ": " + com.getIdentifier())
                .collect(Collectors.joining("</br>"));
}
}

