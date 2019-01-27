import axios from 'axios';
import { path } from '../GeneralService';
import swal from 'sweetalert';

export default class TableService {
    async getAllTables() {
        let data = null;
        await axios.get(`${path}/tables`)
        .then(res => {
            data = res.data;
        }).catch(function (error, e) {
            swal({
                title: error,
                icon: "error",
            });
        })
        
        return await data;
    }

    async putTable(table) {
        await axios.put(`${path}/tables/${table.id}`, table, {
            headers: {
                'Content-Type': 'application/json'
            }
        })
        .then(() => {
            swal({
                title: "Atualizado com Sucesso",
                icon: "success",
              });
        }).catch(function (error, e) {
            if(undefined === error.response.data.errors){
                swal({
                    title: error.response.data,
                    icon: "error",
                });
            } else {
                let errors = "";
                error.response.data.errors.map((err) => {
                    errors += err.defaultMessage
                })
                swal({
                    title: "Erro na requisição",
                    text: errors,
                    icon: "error",
                });
            }
        })
    }

    async postTable(table) {
        await axios.post(`${path}/tables`, table, {
            headers: {
                'Content-Type': 'application/json'
            }
        })
        .then(res => {
            swal({
                title: "Cadastrado com Sucesso",
                icon: "success",
            });
        }).catch(function (error, e) {
            if(undefined === error.response.data.errors){
                swal({
                    title: error.response.data,
                    icon: "error",
                });
            } else {
                let errors = "";
                error.response.data.errors.map((err) => {
                    errors += err.defaultMessage
                })
                swal({
                    title: "Erro na requisição",
                    text: errors,
                    icon: "error",
                });
            }
        })
    }

    async deleteTable(table) {
        await axios.delete(`${path}/tables/${table.id}`)
        .then(() => {
            swal({
                title: "Deletado com Sucesso",
                icon: "success",
            });
        }).catch(function (error, e) {
            swal({
                title: error.response.data,
                icon: "error",
            });
        })
    }
}

