// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package it.verding.edo.repositories;

import it.verding.edo.model.Comune;
import it.verding.edo.repositories.ComuneRepository;
import org.bson.types.ObjectId;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

privileged aspect ComuneRepository_Roo_Mongo_Repository {
    
    declare parents: ComuneRepository extends PagingAndSortingRepository<Comune, ObjectId>;
    
    declare @type: ComuneRepository: @Repository;
    
}
