import httpClient from "../http-common";

const getAll = () => {
    return httpClient.get('/autofix/v1/vehiculos/');
}
const getMarca = marca => {
    return httpClient.get(`/autofix/v1/vehiculos/${marca}`);
}
const getModelo = modelo => {
    return httpClient.get(`/autofix/v1/vehiculos/${modelo}`);
}
const getTipo = tipo => {
    return httpClient.get(`/autofix/v1/vehiculos/${tipo}`);
}
const getTipoMotor = tipoMotor => {
    return httpClient.get(`/autofix/v1/vehiculos/${tipoMotor}`);
}
const getAñoFabricacion = añoFrabricacion => {
    return httpClient.get(`/autofix/v1/vehiculos/${añoFrabricacion}`);
}
const getKilometros = kilometros => {
    return httpClient.get(`/autofix/v1/vehiculos/${kilometros}`);
}
const getAsientos = asientos => {
    return httpClient.get(`/autofix/v1/vehiculos/${asientos}`);
}
const getId = id => {
    return httpClient.get(`/autofix/v1/vehiculos/${id}`);
}
const getPatente = patente => {
    return httpClient.get(`/autofix/v1/vehiculos/${patente}`);
}

const getAñosBetween = (añoI, añoF) => {
    return httpClient.get(`/autofix/v1/vehiculos/${añoI}${añoF}`);
}
const getKilometrajeBetwwen = (kilometrosI, kilometrosF) => {
    return httpClient.get(`/autofix/v1/vehiculos/${kilometrosI}${kilometrosF}`);
}
const getAsientosBetween = (asientosI, asientosF) => {
    return httpClient.get(`/autofix/v1/vehiculos/${asientosI}${asientosF}`);
}


const create = data => {
    return httpClient.post("/autofix/v1/vehiculos/", data);
}

const update = data => {
    return httpClient.put('/autofix/v1/vehiculos/', data);
}

const remove = id => {
    return httpClient.delete(`/autofix/v1/vehiculos/${id}`);
}
export default { getAll, getMarca, getModelo, getTipo, getTipoMotor, getAñoFabricacion, getKilometros, getAsientos, getId, getPatente, getAñosBetween, getKilometrajeBetwwen, getAsientosBetween, create, update, remove };