// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package it.verding.edo.domain;

import it.verding.edo.domain.TipoCaldaia;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Persistent;

privileged aspect TipoCaldaia_Roo_Mongo_Entity {
    
    declare @type: TipoCaldaia: @Persistent;
    
    @Id
    private ObjectId TipoCaldaia.id;
    
    public ObjectId TipoCaldaia.getId() {
        return this.id;
    }
    
    public void TipoCaldaia.setId(ObjectId id) {
        this.id = id;
    }
    
}