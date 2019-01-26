import React, { Component } from 'react';

import {
  Card, 
  Row,
  Col,
  CardHeader,
  CardBody,
  Button,
  Table,
  Modal, ModalHeader, ModalBody, ModalFooter,
  Input
} from "reactstrap";

export default class RestaurantTable extends Component {
  constructor(props) {
    super(props);
    this.state = {
      statusModal: false
    };
    this.modal = this.modal.bind(this);
  }

  modal(){
    this.setState({
      statusModal: !this.state.statusModal
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
                    <h5 className="title">Mesas Atuais</h5>
                  </Col>
                  <Col sm="6">
                    <Button tag="label"
                            className="btn-simple float-right"
                            color="warning"
                            size="md"
                            onClick={this.modal}>
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
                      <tr>
                        <td className="text-center">20</td>
                        <td className="text-center"><i className="tim-icons icon-trash-simple"></i></td>
                      </tr>
                      <tr>
                        <td className="text-center">30</td>
                        <td className="text-center"><i className="tim-icons icon-trash-simple"></i></td>
                      </tr>
                      <tr>
                        <td className="text-center">40</td>
                        <td className="text-center"><i className="tim-icons icon-trash-simple"></i></td>
                      </tr>
                    </tbody>
                  </Table>
                </CardBody>
            </Card>
          </Col>
          <Modal isOpen={this.state.statusModal} toggle={this.modal}>
            <ModalHeader>Nova Mesa</ModalHeader>
            <ModalBody>
              <form>
                <Input type="number"></Input>
              </form>
            </ModalBody>
            <ModalFooter>
              <Button color="second" onClick={this.modal}>Cancelar</Button>
              <Button color="warning" onClick={this.modal}>Salvar</Button>
          </ModalFooter>
          </Modal>
      </div>
    )
  }
}
