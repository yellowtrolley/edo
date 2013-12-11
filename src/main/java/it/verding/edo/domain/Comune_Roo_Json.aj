// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package it.verding.edo.domain;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import it.verding.edo.domain.Comune;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

privileged aspect Comune_Roo_Json {
    
    public String Comune.toJson() {
        return new JSONSerializer().exclude("*.class").serialize(this);
    }
    
    public String Comune.toJson(String[] fields) {
        return new JSONSerializer().include(fields).exclude("*.class").serialize(this);
    }
    
    public static Comune Comune.fromJsonToComune(String json) {
        return new JSONDeserializer<Comune>().use(null, Comune.class).deserialize(json);
    }
    
    public static String Comune.toJsonArray(Collection<Comune> collection) {
        return new JSONSerializer().exclude("*.class").serialize(collection);
    }
    
    public static String Comune.toJsonArray(Collection<Comune> collection, String[] fields) {
        return new JSONSerializer().include(fields).exclude("*.class").serialize(collection);
    }
    
    public static Collection<Comune> Comune.fromJsonArrayToComunes(String json) {
        return new JSONDeserializer<List<Comune>>().use(null, ArrayList.class).use("values", Comune.class).deserialize(json);
    }
    
}