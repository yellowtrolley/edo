// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package it.verding.edo.domain;

import it.verding.edo.domain.QuestionarioRiscaldamento;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Persistent;

privileged aspect QuestionarioRiscaldamento_Roo_Mongo_Entity {
    
    declare @type: QuestionarioRiscaldamento: @Persistent;
    
    @Id
    private ObjectId QuestionarioRiscaldamento.id;
    
    public ObjectId QuestionarioRiscaldamento.getId() {
        return this.id;
    }
    
    public void QuestionarioRiscaldamento.setId(ObjectId id) {
        this.id = id;
    }
    
}