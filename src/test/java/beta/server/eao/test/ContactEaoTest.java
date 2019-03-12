package beta.server.eao.test;

import beta.server.eao.ContactEao;
import static org.assertj.core.api.Assertions.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author celine.glissmann
 */
public class ContactEaoTest {

    private ContactEao eao = new ContactEao();

    @Before
    public void init() {
        eao.findAll();
    }

    /**
     * validate the find all in range method from the contact eao
     */
    @Test
    public void findAllInRange() {

        assertThat(eao.findAll(0, 10).size()).as("find all from 0-10 returns 10 entrys").isEqualTo(10);
    }
}
