import {  useState } from "react";
import axios from "axios";
import {Toggle} from'./toggle/Toggle';
import {Footer} from'./footer/Footer';
import {useNavigate} from 'react-router-dom';
import './Register.css';
function Register() {

    const [username, setUsername] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();


    async function save(event) {
        event.preventDefault();
        try {
            await axios.post("http://localhost:8080/auth/register_email", {
                email: email,
                username: username,
                password: password,
            });
            alert("Registation Successful! Check your email!");

        } catch (err) {
            alert(err);
        }
    }
    const navigateToHome = () => {
        navigate('/');
    };

    return (
        <div className="main-container">
            <div className="logo-container">
                <div onClick={navigateToHome}>
                    <img src="/path/to/your/logo.png" alt="App Logo" className="app-logo"/>
                </div>
                <div className="switch-container">
                    <Toggle/>
                </div>
            </div>
            <div class="container">
                <div class="card">
                    <h1>User Registration</h1>

                    <form>
                        <div class="form-group">
                            <label>Username:</label>
                            <input type="text" class="form-control" id="username" placeholder="Enter your Username"

                                   value={username}
                                   onChange={(event) => {
                                       setUsername(event.target.value);
                                   }}
                            />

                        </div>

                        <div class="form-group">
                            <label>email</label>
                            <input type="email" class="form-control" id="email" placeholder="Enter Email"

                                   value={email}
                                   onChange={(event) => {
                                       setEmail(event.target.value);
                                   }}

                            />

                        </div>

                        <div class="form-group">
                            <label>password</label>
                            <input type="password" class="form-control" id="password" placeholder="Enter password"

                                   value={password}
                                   onChange={(event) => {
                                       setPassword(event.target.value);
                                   }}

                            />
                        </div>

                        <button type="submit" class="btn btn-primary mt-4" onClick={save}>Register and verify your
                            email
                        </button>

                    </form>
                </div>
            </div>
            <Footer/>
        </div>
    );
}

export default Register;