package it.verding.edo.model;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.layers.repository.mongo.RooMongoEntity;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.roo.addon.json.RooJson;

@RooJavaBean
@RooToString
@RooMongoEntity
@RooJson
public class Foo {

    String string;

    Integer integer;

    BigDecimal bigdecimal;

    Bar bar;

    List<Bar> barlist;

    Set<Bar> barset;
}
