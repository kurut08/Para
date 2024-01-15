import React, { Component } from "react";
import { Navigate } from "react-router-dom";
import AuthService from "../../services/auth.service";

export default class Profile extends Component {
    constructor(props) {
        super(props);

        this.state = {
            redirect: null,
            userReady: false,
            currentUser: { username: "" }
        };
    }

    componentDidMount() {
        const currentUser = AuthService.getCurrentUser();

        if (!currentUser) this.setState({ redirect: "/home" });
        this.setState({ currentUser: currentUser, userReady: true })
    }

    render() {
        if (this.state.redirect) {
            return <Navigate to={this.state.redirect} />
        }

        const { currentUser } = this.state;

        return (
            <div className="container">
                {(this.state.userReady) ?
                    <div>
                        <header className="jumbotron">
                            <h3>
                                <strong>{currentUser.username}</strong> Profile
                            </h3>
                        </header>
                        <p>
                            <strong>Token:</strong>{" "}
                            {currentUser.jwt.substring(0, 20)} ...{" "}
                            {currentUser.jwt.substr(currentUser.jwt.length - 20)}
                        </p>
                        <p>
                            <strong>Id:</strong>{" "}
                            {currentUser.user.userId}
                        </p>
                        <p>
                            <strong>Email:</strong>{" "}
                            {currentUser.user.email}
                        </p>
                        <strong>Authorities:</strong>
                        <ul>
                            {currentUser.user.authorities.authority &&
                                currentUser.user.authorities.authority.map((authority, roleId) => <li key={roleId}>{authority}</li>)}
                        </ul>
                    </div>: null}
            </div>
        );
    }
}