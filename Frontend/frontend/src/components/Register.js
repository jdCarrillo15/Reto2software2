// src/components/Register.js
import React, { useState } from 'react';
import { InputText } from 'primereact/inputtext';
import { Password } from 'primereact/password';
import { Button } from 'primereact/button';
import AuthService from '../service/AuthService';
import './Register.css'; // Asegúrate de que el CSS sea opcional

const Register = () => {
    const [formData, setFormData] = useState({
        username: '',
        password: '',
        email: '',
        name: '',
        lastName: '',
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            await AuthService.register(
                formData.username,
                formData.password,
                formData.email,
                formData.name,
                formData.lastName
            );
            alert('Registro exitoso');
        } catch (error) {
            alert('Error en el registro');
        }
    };

    return (
        <div className="register">
            <h1 className="title">Register</h1>
            <form onSubmit={handleSubmit}>
                <div className="p-field">
                    <InputText
                        id="username"
                        name="username"
                        placeholder="Username"
                        onChange={handleChange}
                        required
                    />
                </div>
                <div className="p-field">
                    <Password
                        id="password"
                        name="password"
                        placeholder="Password"
                        onChange={handleChange}
                        required
                    />
                </div>
                <div className="p-field">
                    <InputText
                        id="email"
                        name="email"
                        placeholder="Email"
                        onChange={handleChange}
                        required
                    />
                </div>
                <div className="p-field">
                    <InputText
                        id="name"
                        name="name"
                        placeholder="Name"
                        onChange={handleChange}
                        required
                    />
                </div>
                <div className="p-field">
                    <InputText
                        id="lastName"
                        name="lastName"
                        placeholder="Last Name"
                        onChange={handleChange}
                        required
                    />
                </div>
                <Button className='button' label="Register" icon="pi pi-user-plus" type="submit" />
            </form>
        </div>
    );
};

export default Register;
