import { UserManager } from 'oidc-client';

const settings = {
    authority: 'http://backend-keycloak-auth:8082/realms/shopnest/',
    client_id: 'shopnest-ui',
    redirect_uri: 'https://localhost:3000/callback',
    response_type: 'code',
    scope: 'openid profile message.read',
};

const userManager = new UserManager(settings);

export const getUser = () => {
    return userManager.getUser();
};

export const login = () => {
    return userManager.signinRedirect();
};

export const logout = () => {
    return userManager.signoutRedirect();
}