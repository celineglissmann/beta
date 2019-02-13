/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beta.server.web;

import beta.server.eao.ContactEao;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author celine.glissmann
 */
@Named
@ViewScoped
public class SearchController implements Serializable {

     
    @Inject
    ContactEao contactEao;

    @Inject
    ContactController contactController;

    private String inputSearch ;

    public String getInputSearch() {
        return inputSearch;
    }

    public void setInputSearch(String inputSearch) {
        this.inputSearch = inputSearch;
    }

    public void search() {
        
        contactController.setContact(contactEao.find(inputSearch));

    }
}
