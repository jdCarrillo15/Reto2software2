import React, { Component } from "react";
import { Panel } from "primereact/panel";
import { DataTable } from "primereact/datatable";
import { Column } from "primereact/column";
import { Button } from "primereact/button";
import { InputText } from "primereact/inputtext";
import { CustomerService } from "../service/CustomerService";

export default class ShowCustomer extends Component {
  constructor() {
    super();
    this.state = {
      document: "",
      customers: null,
      error: "",
      loading: false,
    };
    this.CustomerService = new CustomerService();
  }

  setDocument = (value) => {
    this.setState({ document: value });
  };

  // handleFetchCustomer = () => {
  //   this.setState({ loading: true, error: "" });
  //   this.CustomerService.getCustomer(this.state.document)
  //     .then((data) => {
  //       this.setState({ customers: JSON.parse(data), loading: false });
  //     })
  //     .catch((err) => {
  //       this.setState({ error: "Error al obtener el cliente", loading: false });
  //       console.error(err);
  //     });
  // };

  handleFetchCustomer = () => {
    this.setState({ loading: true, error: "" });
    this.CustomerService.getCustomer(this.state.document)
      .then((data) => {
        // Procesar el formato del cliente recibido
        const parsedData = data;
        const customer = {
          ...parsedData,
          address: `Calle ${parsedData.address.street} numero ${parsedData.address.number}\nCiudad: ${parsedData.address.city}, Pais: ${parsedData.address.country}`,
        };
        this.setState({ customers: customer, loading: false });
      })
      .catch((err) => {
        this.setState({ error: "Error al obtener el cliente", loading: false });
        console.error(err);
      });
  };

  render() {
    const { document, customers, error, loading } = this.state;

    return (
      <Panel
        header="Show Customer"
        style={{ width: "80%", marginTop: "100px", margin: "0 auto" }}
        className="Panel1"
      >
        <InputText
          className="p-inputtext p-component"
          value={document}
          onChange={(e) => this.setDocument(e.target.value)}
          placeholder="Ingrese el documento del cliente"
        />
        <Button
          onClick={this.handleFetchCustomer}
          label="Buscar"
          className="p-button-raised p-button-rounded"
        />

        {loading && <p>Cargando...</p>}
        {error && <p style={{ color: "red" }}>{error}</p>}

        {customers && (
          <DataTable value={[customers]} responsiveLayout="scroll">
            <Column field="document" header="ID" />
            <Column field="firstname" header="First Name" />
            <Column field="lastname" header="Last Name" />
            <Column field="address" header="Address" />
            <Column field="phone" header="Phone" />
            <Column field="email" header="Email" />
          </DataTable>
        )}
      </Panel>
    );
  }
}
