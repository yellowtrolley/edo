package it.verding.edo.model;
import it.verding.edo.service.FooService;

import java.net.UnknownHostException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.roo.addon.test.RooIntegrationTest;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

@RooIntegrationTest(entity = Foo.class, transactional = false)
public class FooIntegrationTest {
	@Autowired FooService fooService;
	
//    @Test
    public void testMarkerMethod() {

/*
  		Mongo m;
		try {
			m = new Mongo( "paulo.mongohq.com" , 10061 );
			DB db = m.getDB("HPmSfc7ACHvgZQ7IRfZSQ"); 
			boolean auth = db.authenticate("test", "test".toCharArray());
			Assert.assertTrue("Unable to authenticate!!!", auth);
		} catch (UnknownHostException | MongoException e) {
			e.printStackTrace();
		}

    	Foo foo = new Foo(); 
    	fooService.saveFoo(foo);
    	Assert.assertTrue (fooService.countAllFoos() > 0);

    	Foo foo2 = fooService.findFoo(foo.getId());
    	Assert.assertEquals( foo.getId(), foo2.getId());
    	foo.getBarlist().add(new Bar());
    	Assert.assertEquals(1, foo.getBarlist().size() == 1);

*/
    }
}
