package beta.server.web;

import beta.server.eao.ContactEao;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * reactive search of contacts for every keypress.
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

    private String inputSearch;

    /**
     * gets the searched input.
     *
     * @return the searched input
     */
    public String getInputSearch() {
        return inputSearch;
    }

    /**
     * sets the search input.
     *
     * @param inputSearch
     */
    public void setInputSearch(String inputSearch) {
        this.inputSearch = inputSearch;
    }

    /**
     * finding all contacts with the searched input.
     */
    public void search() {

        contactController.setContact(contactEao.find(inputSearch));

    }
}
