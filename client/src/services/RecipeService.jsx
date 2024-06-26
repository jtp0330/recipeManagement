import axios from 'axios'

const REST_API_URL = 'http://localhost:8080/recipes';

export const listRecipes = () => {
    return axios.get(REST_API_URL);
}