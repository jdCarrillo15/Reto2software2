// src/components/Login.js
import React, { useState } from 'react';
import { InputText } from 'primereact/inputtext';
import { Password } from 'primereact/password';
import { Button } from 'primereact/button';
import AuthService from '../service/AuthService';
import './Login.css'; // Asegúrate de que el CSS sea opcional

const Login = ({ onLoginSuccess }) => {
    const [credentials, setCredentials] = useState({
        username: '',
        password: '',
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setCredentials({ ...credentials, [name]: value });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await AuthService.login(credentials.username, credentials.password);
            localStorage.setItem('token', response.data.token); // Guarda el token en localStorage
            onLoginSuccess(); // Llama a la función para actualizar el estado en el Menu
        } catch (error) {
            alert('Error en el inicio de sesión');
        }
    };

    return (
        <div className="login">
            <h1 className="title">Login</h1>
            <form onSubmit={handleSubmit}>
                <div className="p-field">
                    <InputText id="username" name="username" placeholder="Username" onChange={handleChange} required />
                </div>
                <div className="p-field">
                    <Password id="password" name="password" placeholder="Password" onChange={handleChange} required />
                </div>
                <Button className='button' label="Login" icon="pi pi-sign-in" type="submit" />
            </form>
        </div>
    );
};

export default Login;
