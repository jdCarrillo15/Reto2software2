import React, { Component } from "react";
import { Panel } from "primereact/panel";
import { DataTable } from "primereact/datatable";
import { Column } from "primereact/column";
import { Button } from "primereact/button";
import { InputText } from "primereact/inputtext";
import { OrderService } from "../service/OrderService";

export default class getOrderByCustomid extends Component {
  constructor() {
    super();
    this.state = {
      document: "",
      orders: null,
    };
    this.OrderService = new OrderService();
  }

  setDocument = (value) => {
    this.setState({ document: value });
  };

  handleFetchOrders = () => {
    this.OrderService.getOrderByCustomId(this.state.document).then((data) => {
      this.setState({ orders : data.data});
    });
  };

  render() {
    return (
      <Panel
        header="Get Order By Customer ID"
        style={{ width: "80%", marginTop: "100px", margin: "0 auto" }}
        className="Panel1"
      >
        <div style={{ marginBottom: "10px" }}>
          <label htmlFor="document">Customer ID</label>
          <InputText
            id="document"
            value={this.state.document}
            onChange={(e) => this.setDocument(e.target.value)}
          />
          <Button
            onClick={this.handleFetchOrders}
            label="Buscar"
            className="p-button-raised p-button-rounded"
          />
        </div>

        <DataTable value={this.state.orders} responsiveLayout="scroll">
          <Column field="orderid" header="Order ID" />
          <Column field="customerid" header="Customer ID" />
          <Column field="status.status" header="State" />
          <Column field="status.description" header="Description" />
        </DataTable>
      </Panel>
    );
  }
}
