import { useState } from "react";
import {useLocation, useNavigate, useSearchParams} from 'react-router-dom';
import axios from "axios";


function Verify() {
    const location = useLocation();
    const navigate = useNavigate();
    async function verify(event) {
        event.preventDefault();
        try {
            await axios.post("http://localhost:8080/verify"+location.search);
            alert("Verification successful!");
            navigate('/login');

        } catch (err) {
            alert("Verification successful! Now you can log in!")
            navigate('/login');
        }
    }
    return (
        <div>
            <button type="submit" className="btn btn-primary mt-4" onClick={verify}>Verify!</button>
        </div>
    );
}
export default Verify;