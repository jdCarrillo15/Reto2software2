import React, { Component } from "react";
import { Panel } from "primereact/panel";
import { DataTable } from "primereact/datatable";
import { Column } from "primereact/column";
import { OrderService } from "../service/OrderService";

export default class OrderList extends Component {
  constructor() {
    super();
    this.state = {};
    this.OrderService = new OrderService();
  }

  componentDidMount() {
    this.OrderService.getAllOrders().then((data) => {
      this.setState({ orders: data });
    });
  }

  render() {
    return (
      <>
        <Panel
          header="Orders"
          style={{ width: "80%", marginTop: "100px", margin: "0 auto" }}
          className="Panel1"
        >
          <DataTable value={this.state.orders} responsiveLayout="scroll">
            <Column field="customerID" header="Customer ID" />
            <Column field="orderID" header="Order ID" />
            <Column field="status" header="Status" />
          </DataTable>
        </Panel>
      </>
    );
  }
}
