import React, { useState, useRef } from "react";
import { Button } from "primereact/button";
import { InputText } from "primereact/inputtext";
import { Dropdown } from "primereact/dropdown";
import { Panel } from "primereact/panel";
import { Toast } from "primereact/toast";
import { OrderService } from "../service/OrderService";

const OrderForm = () => {
  const [order, setOrderData] = useState({
    customerid: "",
    orderid: "",
    status:{
      status:"",
      description:"",
    }
  });
  const toast = useRef(null);

  const orderStatus = [
    { label: "Received", value: "Received" },
    { label: "In progress", value: "In progress" },
    { label: "Sended", value: "Sended" },
  ];

  // const handleChange = (e) => {
  //   setOrderData({ ...order, [e.target.name]: [e.target.value] });
  // };

  // const handleSubmit = (e) => {
  //   e.preventDefault();
  //   new OrderService()
  //     .createOrder(order)
  //     .then((response) => {
  //       console.log(response.data);
  //       toast.current.show({
  //         severity: "success",
  //         summary: "Success",
  //         detail: "Order created successfully",
  //       });
  //     })
  //     .catch((error) => {
  //       console.error(error);
  //       toast.current.show({
  //         severity: "error",
  //         summary: "Error",
  //         detail: "Failed to create order",
  //       });
  //     });
  // };

  const handleChange = (e) => {
    const { name, value } = e.target;

    if (name.includes("status.")) {
      const field = name.split(".")[1]; // Extraer el subcampo (e.g., "status")
      setOrderData((prevOrder) => ({
        ...prevOrder,
        status: {
          ...prevOrder.status,
          [field]: value,
        },
      }));
    } else {
      setOrderData({ ...order, [name]: value });
    }
  };

  // Enviar formulario
  const handleSubmit = (e) => {
    e.preventDefault();
    new OrderService()
      .createOrder(order) // Enviar el objeto `order` directamente
      .then((response) => {
        console.log(response.data);
        toast.current.show({
          severity: "success",
          summary: "Success",
          detail: "Order created successfully",
        });
      })
      .catch((error) => {
        console.error(error);
        toast.current.show({
          severity: "error",
          summary: "Error",
          detail: "Failed to create order",
        });
      });
  };

  return (
    <>
      <Toast ref={toast} />
      <Panel
        header="Create Order"
        style={{ width: "100vh", marginTop: "100px", margin: "0 auto" }}
        className="Panel1"
      >
        <form
          onSubmit={handleSubmit}
          style={{ width: "100%", marginTop: "100px", margin: "0 auto" }}
        >
          <InputText
            type="text"
            name="customerid"
            placeholder="Customer ID"
            value={order.customerid}
            onChange={handleChange}
            required
          />
          <InputText
            type="text"
            name="orderid"
            placeholder="Order ID"
            value={order.orderid}
            onChange={handleChange}
            required
          />
          <Dropdown
            name="status.status"
            value={order.status.status}
            options={orderStatus}
            optionLabel="label"
            placeholder="Select a Status"
            onChange={handleChange}
            required
          />
          <InputText
            type="text"
            name="status.description"
            placeholder="Order Status Description"
            value={order.status.description}
            onChange={handleChange}
          />
          <Button type="submit">{"Create"}</Button>
        </form>
      </Panel>
    </>
  );
};

export default OrderForm;
