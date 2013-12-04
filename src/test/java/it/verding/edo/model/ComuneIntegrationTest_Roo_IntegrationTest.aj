// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package it.verding.edo.model;

import it.verding.edo.model.ComuneDataOnDemand;
import it.verding.edo.model.ComuneIntegrationTest;
import it.verding.edo.repositories.ComuneRepository;
import java.util.Iterator;
import java.util.List;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.bson.types.ObjectId;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

privileged aspect ComuneIntegrationTest_Roo_IntegrationTest {
    
    declare @type: ComuneIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: ComuneIntegrationTest: @ContextConfiguration(locations = "classpath*:/META-INF/spring/applicationContext*.xml");
    
    @Autowired
    ComuneDataOnDemand ComuneIntegrationTest.dod;
    
    @Autowired
    ComuneRepository ComuneIntegrationTest.comuneRepository;
    
    @Test
    public void ComuneIntegrationTest.testCount() {
        Assert.assertNotNull("Data on demand for 'Comune' failed to initialize correctly", dod.getRandomComune());
        long count = comuneRepository.count();
        Assert.assertTrue("Counter for 'Comune' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void ComuneIntegrationTest.testFind() {
        Comune obj = dod.getRandomComune();
        Assert.assertNotNull("Data on demand for 'Comune' failed to initialize correctly", obj);
        ObjectId id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Comune' failed to provide an identifier", id);
        obj = comuneRepository.findOne(id);
        Assert.assertNotNull("Find method for 'Comune' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'Comune' returned the incorrect identifier", id, obj.getId());
    }
    
    @Test
    public void ComuneIntegrationTest.testFindAll() {
        Assert.assertNotNull("Data on demand for 'Comune' failed to initialize correctly", dod.getRandomComune());
        long count = comuneRepository.count();
        Assert.assertTrue("Too expensive to perform a find all test for 'Comune', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<Comune> result = comuneRepository.findAll();
        Assert.assertNotNull("Find all method for 'Comune' illegally returned null", result);
        Assert.assertTrue("Find all method for 'Comune' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void ComuneIntegrationTest.testFindEntries() {
        Assert.assertNotNull("Data on demand for 'Comune' failed to initialize correctly", dod.getRandomComune());
        long count = comuneRepository.count();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<Comune> result = comuneRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
        Assert.assertNotNull("Find entries method for 'Comune' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'Comune' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    public void ComuneIntegrationTest.testSave() {
        Assert.assertNotNull("Data on demand for 'Comune' failed to initialize correctly", dod.getRandomComune());
        Comune obj = dod.getNewTransientComune(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'Comune' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'Comune' identifier to be null", obj.getId());
        try {
            comuneRepository.save(obj);
        } catch (final ConstraintViolationException e) {
            final StringBuilder msg = new StringBuilder();
            for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                final ConstraintViolation<?> cv = iter.next();
                msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
            }
            throw new IllegalStateException(msg.toString(), e);
        }
        Assert.assertNotNull("Expected 'Comune' identifier to no longer be null", obj.getId());
    }
    
    @Test
    public void ComuneIntegrationTest.testDelete() {
        Comune obj = dod.getRandomComune();
        Assert.assertNotNull("Data on demand for 'Comune' failed to initialize correctly", obj);
        ObjectId id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Comune' failed to provide an identifier", id);
        obj = comuneRepository.findOne(id);
        comuneRepository.delete(obj);
        Assert.assertNull("Failed to remove 'Comune' with identifier '" + id + "'", comuneRepository.findOne(id));
    }
    
}
