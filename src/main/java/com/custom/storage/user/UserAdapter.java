package com.custom.storage.user;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.keycloak.common.util.MultivaluedHashMap;
import org.keycloak.component.ComponentModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.storage.StorageId;
import org.keycloak.storage.adapter.AbstractUserAdapterFederatedStorage;

public class UserAdapter extends AbstractUserAdapterFederatedStorage {
    protected UserEntity entity;
    protected String keycloakId;

    public UserAdapter(KeycloakSession session, RealmModel realm, ComponentModel model,
                       UserEntity entity) {
        super(session, realm, model);
        this.entity = entity;
        keycloakId = StorageId.keycloakId(model, entity.getId());
    }

    @Override
    public String getUsername() {
        return entity.getLoginName();
    }

    @Override
    public void setUsername(String username) {
        entity.setLoginName(username);
    }

    @Override
    public String getFirstName() {
        System.out.println("Get First Name: " + entity.getFirstName());
        return entity.getFirstName();
    }

    @Override
    public void setFirstName(String fullName) {
        System.out.println("Set First Name: " + fullName);
        entity.setFirstName(fullName);
    }
    

    @Override
    public String getLastName() {
        System.out.println("Get Last Name: " + entity.getLastName());
        return entity.getLastName();
    }

    @Override
    public void setLastName(String lastName) {
        System.out.println("Set Last Name: " + lastName);
        entity.setLastName(lastName);
    }

    @Override
    public void setEmail(String email) {
        entity.setEmail(email);
    }

    @Override
    public String getEmail() {
        return entity.getEmail();
    }

    @Override
    public String getId() {
        return keycloakId;
    }

    @Override
    public void setSingleAttribute(String name, String value) {
        if (name.equals("passWord")) {
            entity.setPassWord(value);
        } else if (name.equals("firstName")) {
            entity.setFirstName(value);
        } else if (name.equals("lastName")) {
            entity.setFirstName(value);
        } else {
            super.setSingleAttribute(name, value);
        }
    }

    @Override
    public void removeAttribute(String name) {
        if (name.equals("passWord")) {
            entity.setPassWord(null);
        } else {
            super.removeAttribute(name);
        }
    }

    @Override
    public void setAttribute(String name, List<String> values) {
        if (name.equals("passWord")) {
            entity.setPassWord(values.get(0));
        } else {
            super.setAttribute(name, values);
        }
    }

    @Override
    public String getFirstAttribute(String name) {
        if (name.equals("passWord")) {
            return entity.getPassWord();
        } else if (name.equals("firstName")) {
            return entity.getFirstName();
        } else if (name.equals("lastName")) {
            return entity.getLastName();
        } else {
            return super.getFirstAttribute(name);
        }
    }

    @Override
    public Map<String, List<String>> getAttributes() {
        Map<String, List<String>> attrs = super.getAttributes();
        MultivaluedHashMap<String, String> all = new MultivaluedHashMap<>();
        all.putAll(attrs);
        all.add("passWord", entity.getPassWord());
        all.add("firstName", entity.getFirstName());
        all.add("lastName", entity.getLastName());
        return all;
    }

    @Override
    public List<String> getAttribute(String name) {
        if (name.equals("passWord")) {
            List<String> phone = new LinkedList<>();
            phone.add(entity.getPassWord());
            return phone;
        } else {
            return super.getAttribute(name);
        }
    }
}
