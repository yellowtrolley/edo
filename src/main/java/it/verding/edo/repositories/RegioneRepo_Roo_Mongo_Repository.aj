// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package it.verding.edo.repositories;

import it.verding.edo.model.Regione;
import it.verding.edo.repositories.RegioneRepo;
import org.bson.types.ObjectId;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

privileged aspect RegioneRepo_Roo_Mongo_Repository {
    
    declare parents: RegioneRepo extends PagingAndSortingRepository<Regione, ObjectId>;
    
    declare @type: RegioneRepo: @Repository;
    
}
