import { useState } from "react";
import { useNavigate } from 'react-router-dom';
import axios from "axios";


function Login() {

    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();


    async function login(event) {
        event.preventDefault();
        try {
            await axios.post("http://localhost:8080/auth/loginMess", {
                username: username,
                password: password,
            }).then((res) =>
            {

                console.log(res.data);

                if (res.data.message === "Username not exits")
                {
                    alert("Username not exits");
                }
                else if(res.data.message === "Login Success")
                {
                    navigate('/home');
                }
                else
                {
                    alert("Given credentials does not match");
                }
            }, fail => {
                console.error(fail); // Error!
            });
        }


        catch (err) {
            alert(err);
        }

    }

    return (
        <div>
            <div class="container">
                <div class="row">
                    <h2>Login</h2>
                    <hr/>
                </div>

                <div class="row">
                    <div class="col-sm-6">

                        <form>
                            <div class="form-group">
                                <label>Username</label>
                                <input type="email"  class="form-control" id="username" placeholder="Enter Username"

                                       value={username}
                                       onChange={(event) => {
                                           setUsername(event.target.value);
                                       }}

                                />

                            </div>

                            <div class="form-group">
                                <label>password</label>
                                <input type="password"  class="form-control" id="password" placeholder="Enter Password"

                                       value={password}
                                       onChange={(event) => {
                                           setPassword(event.target.value);
                                       }}

                                />
                            </div>
                            <button type="submit" class="btn btn-primary" onClick={login} >Login</button>
                        </form>

                    </div>
                </div>
            </div>

        </div>
    );
}

export default Login;