import React, { Component } from 'react'

import {
    Modal, ModalHeader, ModalBody,
    ModalFooter,
    Input,
    Button
} from "reactstrap";

export default class TableModal extends Component {
    render() {
        return (
            <Modal isOpen={this.props.statusModal} toggle={this.props.modal}>
                <ModalHeader>Nova Mesa</ModalHeader>
                <ModalBody>
                <form>
                    <Input type="number" value={this.props.table.number} onChange={this.props.updateData}></Input>
                </form>
                </ModalBody>
                <ModalFooter>
                <Button color="second" onClick={this.props.modal}>Cancelar</Button>
                <Button color="warning" onClick={() => this.props.event(this.props.table)}>Salvar</Button>
            </ModalFooter>
        </Modal>
        )
    }
}
