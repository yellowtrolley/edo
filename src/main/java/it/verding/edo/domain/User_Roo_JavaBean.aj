// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package it.verding.edo.domain;

import it.verding.edo.domain.Message;
import it.verding.edo.domain.User;
import java.util.List;

privileged aspect User_Roo_JavaBean {
    
    public String User.getUsername() {
        return this.username;
    }
    
    public void User.setUsername(String username) {
        this.username = username;
    }
    
    public List<Message> User.getMessages() {
        return this.messages;
    }
    
    public void User.setMessages(List<Message> messages) {
        this.messages = messages;
    }
    
}
