import axios from 'axios';
import { path } from '../GeneralService'

export default class TableService {
    async getAllTables() {
        let data = null;
        await axios.get(`${path}/tables`)
        .then(res => {
            data = res.data;
        }).catch(function (error, e) {
            console.log(error);
        })
        
        return await data;
    }
}

