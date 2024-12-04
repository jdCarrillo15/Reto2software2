import React, { Component } from "react";
import { Panel } from "primereact/panel";
import { DataTable } from "primereact/datatable";
import { Column } from "primereact/column";
import { CustomerService } from "../service/CustomerService";

export default class ShowCustomers extends Component {
  constructor() {
    super();
    this.state = {};
    this.CustomerService = new CustomerService();
  }

  componentDidMount() {
    this.CustomerService.getAll().then((data) => {
      const customers = data.map(item => JSON.parse(item));
      this.setState({ customers });
    });

  }

  render() {
    return (
      <Panel
        header="Show Customers"
        style={{ width: "80%", marginTop: "100px", margin: "0 auto" }}
        className="Panel1"
      >
        <DataTable value={this.state.customers} responsiveLayout="scroll">
          <Column field="document" header="ID" />
          <Column field="first_name" header="First Name" />
          <Column field="last_name" header="Last Name" />
          <Column field="address" header="Address" />
          <Column field="phone" header="Phone" />
          <Column field="email" header="Email" />
        </DataTable>
      </Panel>
    );
  }
}
