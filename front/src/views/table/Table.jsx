import React, { Component } from 'react';

import TableService from '../../services/table/TableService';
import TableModal from './TableModal';
import swal from 'sweetalert';

import {
  Card, 
  Row,
  Col,
  CardHeader,
  CardBody,
  Button,
  Table,
} from "reactstrap";

export default class RestaurantTable extends Component {

  constructor(props) {
    super(props);
    this.tableService = new TableService();

    this.state = {
      statusModal: false,
      tables: [],
      table: {},
      update: false
    };

    this.modal = this.modal.bind(this);
    this.getAllTable = this.getAllTable.bind(this);
    this.updateData = this.updateData.bind(this)
    this.putTable = this.putTable.bind(this)
    this.postTable = this.postTable.bind(this)
    this.deleteTable = this.deleteTable.bind(this)
    this.executeEvent = this.executeEvent.bind(this)

    this.getAllTable()
  }

  getAllTable(){
    this.tableService.getAllTables().then(val => this.setState({
      tables: val
    }))
  }

  async putTable(table){
    await this.tableService.putTable(table)
    await this.getAllTable()
    this.modal()
  }

  async postTable(table){
    await this.tableService.postTable(table)
    await this.getAllTable()
    this.modal()
  }

  async deleteTable(table){
    await this.tableService.deleteTable(table)
    await this.getAllTable()
  }

  saveTable(){
    this.setState({
      update: false
    })
  }

  updateTable(){
    this.setState({
      update: true
    })
  }

  updateData(value){
    this.setState({
      table: {
        ...this.state.table,
        number: value.target.value
      }
    })
  }

  executeEvent(table){ 
    if(this.state.update === false)
      this.postTable(table)
    else  
      this.putTable(table)
  }

  modal(table){
    if(table == null)
      this.setState({
        statusModal: !this.state.statusModal,
        table: {
          number: ''
        },
        update: false
      })
    else
    this.setState({
      statusModal: !this.state.statusModal,
      table: table
    })
  }

  removeTable(table){
    swal({
      title: 'Tem certeza que deseja excluir essa mesa?',
      icon: 'warning',
      buttons: {
        cancel: 'Não, cancelar',
        confirm: {
          text: 'Sim, desejo deletar!',
          className: "btn-warning"
          }
      }
    }).then((result) => {
      if(result){
        this.deleteTable(table)
      }
    })
  }

  render() {
    return (
      
      <div className="content">
            <Col xs="12">
              <Card className="card-chart">
                <CardHeader>
                <Row>
                  <Col sm="6">
                    <h4 className="title">Mesas Atuais</h4>
                  </Col>
                  <Col sm="6">
                    <Button tag="label"
                            className="btn-simple float-right"
                            color="warning"
                            size="md"
                            onClick={() => { this.modal(); this.saveTable() } }>
                            Nova Mesa
                      </Button>
                    </Col>
                  </Row>
                </CardHeader>
                <CardBody>
                  <Table hover>
                    <thead>
                      <tr>
                        <th className="text-center">Numero</th>
                        <th className="text-center">Remover</th>
                      </tr>
                    </thead>
                    <tbody>
                    { 
                      this.state.tables.map((table, index) => {
                          return (
                            <tr key={index}>
                              <td className="text-center hover-point" onClick={() => { this.modal(table); this.updateTable()} }>{table.number}</td>
                              <td className="text-center"><a href="#" className="text-danger" onClick={() => this.removeTable(table)}><i className="tim-icons icon-trash-simple"></i></a></td>
                            </tr>
                          )
                      })
                    }
                    </tbody>
                  </Table>
                </CardBody>
            </Card>
          </Col>
          <TableModal statusModal={this.state.statusModal} 
                      modal={this.modal} 
                      table={this.state.table}
                      event={this.executeEvent}
                      updateData={this.updateData}
                      update={this.state.update}></TableModal>
      </div>
    )
  }
}
