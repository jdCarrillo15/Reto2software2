// src/service/AuthService.js
const API_URL = 'http://localhost:9090/realms/spring-boot-real-dev/protocol/openid-connect/token'; // URL para obtener el token

const login = async (username, password) => {
  const body = new URLSearchParams({
    client_id: 'spring-client-api-rest',
    username: username,
    password: password,
    grant_type: 'password',
    client_secret: 'admin', // O tu secreto de cliente
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

const logout = () => {
  localStorage.removeItem('token');
};

const getToken = () => {
  return localStorage.getItem('token');
};

const isAuthenticated = () => {
  return !!getToken();
};

export { login, logout, getToken, isAuthenticated };
