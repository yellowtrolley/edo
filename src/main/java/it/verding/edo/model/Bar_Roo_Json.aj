// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package it.verding.edo.model;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import it.verding.edo.model.Bar;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

privileged aspect Bar_Roo_Json {
    
    public String Bar.toJson() {
        return new JSONSerializer().exclude("*.class").serialize(this);
    }
    
    public String Bar.toJson(String[] fields) {
        return new JSONSerializer().include(fields).exclude("*.class").serialize(this);
    }
    
    public static Bar Bar.fromJsonToBar(String json) {
        return new JSONDeserializer<Bar>().use(null, Bar.class).deserialize(json);
    }
    
    public static String Bar.toJsonArray(Collection<Bar> collection) {
        return new JSONSerializer().exclude("*.class").serialize(collection);
    }
    
    public static String Bar.toJsonArray(Collection<Bar> collection, String[] fields) {
        return new JSONSerializer().include(fields).exclude("*.class").serialize(collection);
    }
    
    public static Collection<Bar> Bar.fromJsonArrayToBars(String json) {
        return new JSONDeserializer<List<Bar>>().use(null, ArrayList.class).use("values", Bar.class).deserialize(json);
    }
    
}
