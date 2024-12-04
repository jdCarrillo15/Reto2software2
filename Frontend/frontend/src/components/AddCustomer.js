import React, { useState, useRef } from "react";
import { Panel } from "primereact/panel";
import { Toast } from "primereact/toast";
import { Button } from "primereact/button";
import { InputText } from "primereact/inputtext";
import { CustomerService } from "../service/CustomerService";

function AddCustomer() {
  const [customer, setCustomer] = useState({
    document: "",
    firstname: "",
    lastname: "",
    address: {
      street: "",
      number: "",
      city: "",
      country: "",
    },
    phone: "",
    email: "",
  });
  const toast = useRef(null);

  // const handleChange = (e) => {
  //   setCustomer({ ...customer, [e.target.name]: e.target.value });
  // };


  const handleChange = (e) => {
    const { name, value } = e.target;
    if (name.includes("address.")) {
      const field = name.split(".")[1];
      setCustomer((prevCustomer) => ({
        ...prevCustomer,
        address: {
          ...prevCustomer.address,
          [field]: value,
        },
      }));
    } else {
      setCustomer({ ...customer, [name]: value });
    }
  };


  const RegisterCustomer = (e) => {
    e.preventDefault();
    new CustomerService().addCustomer(customer)
      .then((response) => {
        console.log(response.data);
        toast.current.show({
          severity: "success",
          summary: "Success",
          detail: "Customer created successfully",
        });
      })
      .catch((error) => {
        console.error(error);
        toast.current.show({
          severity: "error",
          summary: "Error",
          detail: "Failed to create customer",
        });
      });
  };

  return (
    <>
      <Toast ref={toast} />
      <Panel
        header="Add Customer"
        style={{ width: "80%", marginTop: "100px", margin: "0 auto" }}
        className="Panel1"
      >
        <form onSubmit={(e) => RegisterCustomer(e)}>
          <div className="p-fluid">
            <div className="p-field">
              <label htmlFor="document">Document</label>
              <InputText
                id="document"
                name="document"
                className="p-inputtext-sm"
                value={customer.document}
                onChange={handleChange}
              />
            </div>
            <div className="p-field">
              <label htmlFor="firstname">First Name</label>
              <InputText
                id="firstname"
                name="firstname"
                className="p-inputtext-sm"
                value={customer.first_name}
                onChange={handleChange}
              />
            </div>
            <div className="p-field">
              <label htmlFor="lastname">Last Name</label>
              <InputText
                id="lastname"
                name="lastname"
                className="p-inputtext-sm"
                value={customer.last_name}
                onChange={handleChange}
              />
            </div>
            <div className="p-field">
              <label htmlFor="address.street">Street</label>
              <InputText
                id="address.street"
                name="addresaddress.street"
                className="p-inputtext-sm"
                value={customer.address.street}
                onChange={handleChange}
              />
            </div>
            <div className="p-field">
              <label htmlFor="address.number">number</label>
              <InputText
                id="address.number"
                name="address.number"
                className="p-inputtext-sm"
                value={customer.address.number}
                onChange={handleChange}
              />
            </div>
            <div className="p-field">
              <label htmlFor="address.city">city</label>
              <InputText
                id="address.city"
                name="address.city"
                className="p-inputtext-sm"
                value={customer.address.city}
                onChange={handleChange}
              />
            </div>
            <div className="p-field">
              <label htmlFor="address.country">country</label>
              <InputText
                id="address.country"
                name="address.country"
                className="p-inputtext-sm"
                value={customer.address.country}
                onChange={handleChange}
              />
            </div>
            <div className="p-field">
              <label htmlFor="phone">Phone</label>
              <InputText
                id="phone"
                name="phone"
                className="p-inputtext-sm"
                value={customer.phone}
                onChange={handleChange}
              />
            </div>
            <div className="p-field">
              <label htmlFor="email">Email</label>
              <InputText
                id="email"
                name="email"
                type="email"
                className="p-inputtext-sm"
                value={customer.email}
                onChange={handleChange}
              />
            </div>
            <br></br>
            <Button
              type="submit"
              label="Create Customer"
              className="p-button-raised p-button-rounded"
            />
          </div>
        </form>
      </Panel>
    </>
  );
}

export default AddCustomer;
