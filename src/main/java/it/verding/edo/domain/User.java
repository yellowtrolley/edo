package it.verding.edo.domain;

import java.util.List;

import org.bson.types.ObjectId;
import org.pgg.mongo.mapping.Cascade;
import org.pgg.mongo.mapping.CascadeType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.layers.repository.mongo.RooMongoEntity;
import org.springframework.roo.addon.tostring.RooToString;

@Document
@RooJavaBean
@RooToString
@RooMongoEntity(identifierType = ObjectId.class)
public class User {

	private String username;
	private String password;
	private String name;
	private List<String> roles;
	private String email;
	
	public User(){};
	
	public User(String username, String password, String name, List<String> roles,
			String email) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.roles = roles;
		this.email = email;
	}

}
