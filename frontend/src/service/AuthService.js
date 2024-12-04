// src/service/AuthService.js
const API_URL = 'http://localhost:9090/realms/spring-boot-real-dev/protocol/openid-connect/token'; // URL para obtener el token
const KEYCLOAK_API_URL = 'http://localhost:11080/keycloak/user/create'; // URL de la API de Keycloak

export const login = async (username, password) => {
  const body = new URLSearchParams({
    client_id: 'spring-client-api-rest',
    username: username,
    password: password,
    grant_type: 'password',
    client_secret: '9abKSrefv1FfulvUyEcZ9qIyf5RLoCfp', // O tu secreto de cliente
  });

  const response = await fetch(API_URL, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded',
    },
    body: body.toString(),
  });

  if (response.ok) {
    const data = await response.json();
    localStorage.setItem('token', data.access_token); // Guardar el token
    return data;
  } else {
    throw new Error('Login failed');
  }
};

const register = async (username, password, email, firstName, lastName) => {
  const token = localStorage.getItem('token');
  
  if (!token) {
    throw new Error('No token found, please log in first');
  }

  const response = await fetch(KEYCLOAK_API_URL, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${token}`,
    },
    body: JSON.stringify({
      username: username,
      email: email,
      firstName: firstName,
      lastName: lastName,
      password: password,
    }),
  });

  if (!response.ok) {
    const data = await response.json();
    return data;
  } 
};



const logout = () => {
  localStorage.removeItem('token');
};

const getToken = () => {
  return localStorage.getItem('token');
};

const isAuthenticated = () => {
  return !!getToken();
};

export default { login, logout, getToken, isAuthenticated , register};
