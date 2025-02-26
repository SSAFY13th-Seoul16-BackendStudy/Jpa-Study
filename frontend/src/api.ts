import axios from 'axios';

const instance = axios.create({
  baseURL: 'http://localhost:8080/',
});
export const getAPI = () =>
  instance
    .get('')
    .then((response) => {
      console.log(response);
    })
    .catch((error) => {
      console.log(error);
    });
