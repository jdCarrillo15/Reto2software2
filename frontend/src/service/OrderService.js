import axios from "axios";

export class OrderService {
  commandURL = "http://localhost:11080";
  queryURL = "http://localhost:12080";

  createOrder = async (data) => {
    return await axios.post(`${this.commandURL}/createorder`, data);
  };

  getOrderByCustomId = async (document) => {
    return await axios
      .get(`${this.queryURL}/searchorderbycustomerid/${document}`)
      .then((res) => res.data);
  };

  getAllOrders = async () => {
    return await axios
      .get(`${this.commandURL}/allorders`)
      .then((res) => res.data);
  };
}
