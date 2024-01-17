import { useState } from "react";
import {useLocation, useNavigate, useSearchParams} from 'react-router-dom';
import axios from "axios";
import { useTranslation } from "react-i18next";

function Verify() {
    const location = useLocation();
    const navigate = useNavigate();
    const { t, i18n } = useTranslation();


    async function verify(event) {
        event.preventDefault();
        try {
            await axios.post("http://localhost:8080/verify"+location.search);
            alert(t("verificationSuccessful.label"));
            navigate('/login');

        } catch (err) {
            alert(t("verificationSuccessfulLogIn.label"))
            navigate('/login');
        }
    }
    return (
        <div>
            <button type="submit" className="btn btn-primary mt-4" onClick={verify}>{t("verify.label")}</button>
        </div>
    );
}
export default Verify;