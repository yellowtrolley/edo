// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package it.verding.edo.model;

import it.verding.edo.model.Foo;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Persistent;

privileged aspect Foo_Roo_Mongo_Entity {
    
    declare @type: Foo: @Persistent;
    
    @Id
    private ObjectId Foo.id;
    
    public ObjectId Foo.getId() {
        return this.id;
    }
    
    public void Foo.setId(ObjectId id) {
        this.id = id;
    }
    
}
