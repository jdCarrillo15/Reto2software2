import React, { useState, useEffect } from 'react';
import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';
import Login from './components/Login';
import Register from './components/Register';
import AddCustomer from './components/AddCustomer';
import ShowCustomer from './components/ShowCustomer';
import Home from './components/Home';  
import Navigation from './components/Navigation';
import OrderForm from './components/OrderForm'; 
import OrderByCustomid from './components/OrderByCustomid';

const Menu = () => {
    const [isLoggedIn, setIsLoggedIn] = useState(false);

    useEffect(() => {
        const token = localStorage.getItem('token');
        setIsLoggedIn(!!token);
    }, []);

    const handleLoginSuccess = () => {
        setIsLoggedIn(true);
    };

    const handleLogout = () => {
        setIsLoggedIn(false);
        localStorage.removeItem('token');
    };

    return (
        <BrowserRouter>
            <Navigation isLoggedIn={isLoggedIn} onLogout={handleLogout} /> {
                }
            <Routes>
                <Route path="/" element={<Home />  } />
                <Route path="/login" element={isLoggedIn ? <Navigate to="/" /> : <Login onLoginSuccess={handleLoginSuccess} />} />
                <Route path="/register" element={<Register />} />
                <Route path="/addcustomer" element={<AddCustomer />} />
                <Route path="/showcustomer" element={<ShowCustomer />} />
                <Route path="/orderform" element={<OrderForm /> } />
                <Route path="/orderbycustomid" element={<OrderByCustomid />} />
                <Route path="*" element={<Navigate to="/" />} />
            </Routes>
        </BrowserRouter>
    );
};

export default Menu;
