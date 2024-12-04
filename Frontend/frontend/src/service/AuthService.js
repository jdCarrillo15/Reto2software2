import axios from "axios";


    const API_URL = "http://localhost:9092/auth/";

   
    const register = (username, password, email, name, lastName) => {
        return axios.post(API_URL + 'register', { username, password, email, name, lastName });
    };

    const login = (username, password) => {
        return axios.post(API_URL + 'login', { username, password });
    };

    export default {
        register,
        login,
    };

