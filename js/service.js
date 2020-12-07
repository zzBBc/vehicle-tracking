//import axios from "../node_modules/axios/dist/axios.js";

const API_PATH = "http://localhost:8080/api/vehicle"

export const getDirection = () => {
    let url = API_PATH + "/getDirection";

    return axios.get(url);
}
