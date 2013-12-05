package it.verding.edo.model;
import it.verding.edo.service.BarService;
import it.verding.edo.service.FooService;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RooIntegrationTest(entity = Foo.class, transactional = false)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/META-INF/spring/applicationContext*.xml")
public class MongoDBCascadeTest {
	@Autowired FooService fooService;
	@Autowired BarService barService;
	
    @Test
    public void testCascade() {

    	Bar aBar = new Bar();
    	aBar.setBirra("menabrea");
    	
    	Bar anotherBar = new Bar();
    	anotherBar.setBirra("peroni");
    	
    	Foo aFoo = new Foo();
    	aFoo.setBar(aBar);
    	
    	aFoo.setBarlist(new ArrayList<Bar>());
    	aFoo.getBarlist().add(aBar);
    	aFoo.getBarlist().add(anotherBar);
    	aFoo.setBarset(new HashSet<Bar>());
    	aFoo.getBarset().add(aBar);
    	aFoo.getBarset().add(anotherBar);
    	
    	fooService.saveFoo(aFoo);
    	
    	Assert.assertNotNull("aFoo was not saved!", aFoo.getId());
    	Assert.assertNotNull("aBar was not cascade saved!", aBar.getId());
    	Assert.assertNotNull("anotherBar was not cascade saved!", anotherBar.getId());
    	Assert.assertEquals("Number of Bars saved is not 2!", 2, barService.findAllBars().size());
    	
    	fooService.deleteFoo(aFoo);

    	Assert.assertEquals("aFoo was not deleted!", 0, fooService.findAllFoos().size());
    	
    	Assert.assertEquals("Bars were not cascade removed!", 0, aFoo.getBarlist().size());
    }
    
}
