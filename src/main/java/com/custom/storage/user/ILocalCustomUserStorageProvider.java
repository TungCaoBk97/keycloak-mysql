package com.custom.storage.user;

import org.keycloak.component.ComponentModel;
import org.keycloak.credential.CredentialInputValidator;
import org.keycloak.models.KeycloakSession;
import org.keycloak.storage.UserStorageProvider;
import org.keycloak.storage.user.UserLookupProvider;
import org.keycloak.storage.user.UserQueryProvider;

public interface ILocalCustomUserStorageProvider extends UserStorageProvider, UserLookupProvider,
		UserQueryProvider, CredentialInputValidator {

	void setModel(ComponentModel model);

	void setSession(KeycloakSession session);

}
