import axios from "axios";

const API_URL = "http://localhost:8080/auth/";

class AuthService {
    login(username, password) {
        return axios.post(API_URL + "login", {
            username: username,
            password: password
        })
            .then(response => {
                if (response.data) {
                    localStorage.setItem("user", JSON.stringify(response.data));
                }
                return response.data;
            });
    }

    logout() {
        localStorage.removeItem("user");
    }

    register(email, username, password) {
        return axios.post(API_URL + "register_email", {
            email: email,
            username: username,
            password: password
        });
    }
    getCurrentUser() {
        return JSON.parse(localStorage.getItem('user'));;
    }
}

export default new AuthService();