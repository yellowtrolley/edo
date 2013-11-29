package it.verding.edo.model;
import org.junit.Test;
import org.springframework.roo.addon.test.RooIntegrationTest;

@RooIntegrationTest(entity = Bar.class, transactional = false)
public class BarIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }
}
