import React, { Component } from 'react'

import {
    Modal, ModalHeader, ModalBody,
    ModalFooter,
    Input,
    Button
} from "reactstrap";

export default class TableModal extends Component {
    constructor(props){
        super(props);
        this.state = {
            error: false,
            message: ''
        }

        this.tableValidation = this.tableValidation.bind(this)
        this.noError = this.noError.bind(this);

    }

    noError(){
        this.setState({
            error: false
        })
    }

    render() {
        return (
            <Modal isOpen={this.props.statusModal} toggle={() => {this.props.modal(); this.noError()}}>
                <form onSubmit={this.tableValidation}>
                    <ModalHeader>{(this.props.update === true)? "Atualizar Mesa" : "Nova Mesa"}</ModalHeader>
                    <ModalBody>
                        <Input type="number" id="numberTable" value={this.props.table.number} onChange={this.props.updateData}></Input>
                        {   
                           (this.state.error === true) ? <span className="text-danger">{this.state.message}</span> : <></>
                        }
                    </ModalBody>
                    <ModalFooter>
                        <Button color="second" onClick={() => {this.props.modal(); this.noError()}}>Cancelar</Button>
                        <Button color="warning" type="submit">Salvar</Button>
                    </ModalFooter>
                </form>
            </Modal>
        )
    }

    tableValidation(e){
        e.preventDefault()
        let number = document.getElementById("numberTable").value
        if(!/\d/.test(number)){
            this.setState({
                error: true,
                message: "O numero da mesa é obrigatório"
            })
        } else if(number < 1) {
            this.setState({
                error: true,
                message: "Insira um numero positivo"
            })
        } else {
            this.noError()
            this.props.event(this.props.table)
        }
    }
}
