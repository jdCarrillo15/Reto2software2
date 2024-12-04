import React from 'react';
import './Home.css';

const Home = () => {
    return (
        <div className='home'>
            <h1>Arquitectura Hexagonal 2 50%</h1>
            <p>Se hace una inplementacion de la siguiente arquitectura</p>
            <img src={require('../img/img1.PNG')} alt="Arquitectura" />
        </div>
    );
};

export default Home;
