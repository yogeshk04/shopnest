import axios from "axios";
import { getUser } from "./auth_helper_service";

const _callApi = (token) => {
    const headers = {
        Accept: "application/json",
        Authorization: "Bearer" + token
    };
    return axios.get("http://shopnest-gateway:8081/messages", { headers });
}

export const callApi = async () => {
    return getUser().then((user) => {
        if (user && user.access_token) {
            return _callApi(user.access_token).catch((error) => {
                throw error;
            });
        } else {
            throw new Error("User not authenticated");
        }        
    });
}
