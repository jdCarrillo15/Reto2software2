import axios from "axios";

export class CustomerService {
  commandUrl = "http://localhost:11080";
  queryUrl = "http://localhost:12080";

  // Método para obtener el token almacenado en el localStorage
  getAuthHeader() {
    const token = localStorage.getItem("token");
    return {
      headers: {
        Authorization: `Bearer ${token}`, // Agregar el token JWT en la cabecera de Authorization
      },
    };
  }

  getAll() {
    return axios
      .get(`${this.commandUrl}/customers`, this.getAuthHeader())
      .then((res) => res.data);
  }

  addCustomer(values) {
    return axios.post(
      `${this.commandUrl}/addcustomer`,
      values,
      this.getAuthHeader()
    );
  }

  getCustomer(document) {
    return axios
      .get(`${this.queryUrl}/getcustomerbyid/${document}`, this.getAuthHeader())
      .then((res) => res.data);
  }

  modifyCustomer(document, values) {
    return axios.put(
      `${this.commandUrl}/modifycustomer/${document}`,
      values,
      this.getAuthHeader()
    );
  }
}
