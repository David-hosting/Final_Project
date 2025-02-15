
const currentIP = window.location.hostname;

const API_URL_Backend = `http://${currentIP}:8080/ifm_api`;

const API_URL_Mailing = `http://${currentIP}:8081/api`;

const API_URL_Ai = `http://${currentIP}:5000`;

export { API_URL_Backend, API_URL_Mailing as API_URL_RabbitMQ, API_URL_Ai, currentIP };
