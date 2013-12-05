package it.verding.edo.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.roo.addon.layers.repository.mongo.RooMongoEntity;
import org.springframework.roo.addon.tostring.RooToString;

import foo.pabloguerrero.mongo.mapping.Cascade;
import foo.pabloguerrero.mongo.mapping.CascadeType;

@RooJavaBean
@RooToString
@RooMongoEntity(identifierType = ObjectId.class)
@RooJson
@Document
public class Foo {

    String string;

    Integer integer;

    BigDecimal bigdecimal;

    @DBRef
    @Cascade(cascadeType = CascadeType.ALL)
    Bar bar;

    @DBRef
    @Cascade(cascadeType = CascadeType.ALL)
    List<Bar> barlist;

    @DBRef
    @Cascade(cascadeType = CascadeType.ALL)
    Set<Bar> barset;
}
