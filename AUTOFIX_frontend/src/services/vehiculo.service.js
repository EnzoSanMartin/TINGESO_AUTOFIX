import httpClient from "../http-common";

const getAll = () => {
    return httpClient.get('/autofix/v1/vehiculos/');
}
const getMarca = marca => {
    return httpClient.get(`/autofix/v1/hehiculos/${marca}`);
}
const getModelo = modelo => {
    return httpClient.get(`/autofix/v1/hehiculos/${modelo}`);
}
const getTipo = tipo => {
    return httpClient.get(`/autofix/v1/hehiculos/${tipo}`);
}
const getTipoMotor = tipoMotor => {
    return httpClient.get(`/autofix/v1/hehiculos/${tipoMotor}`);
}
const getAñoFabricacion = añoFrabricacion => {
    return httpClient.get(`/autofix/v1/hehiculos/${añoFrabricacion}`);
}
const getKilometros = kilometros => {
    return httpClient.get(`/autofix/v1/hehiculos/${kilometros}`);
}
const getAsientos = asientos => {
    return httpClient.get(`/autofix/v1/hehiculos/${asientos}`);
}
const getId = id => {
    return httpClient.get(`/autofix/v1/hehiculos/${id}`);
}
const getPatente = patente => {
    return httpClient.get(`/autofix/v1/hehiculos/${patente}`);
}

const getAñosBetween = (añoI, añoF) => {
    return httpClient.get(`/autofix/v1/hehiculos/${añoI}${añoF}`);
}
const getKilometrajeBetwwen = (kilometrosI, kilometrosF) => {
    return httpClient.get(`/autofix/v1/hehiculos/${kilometrosI}${kilometrosF}`);
}
const getAsientosBetween = (asientosI, asientosF) => {
    return httpClient.get(`/autofix/v1/hehiculos/${asientosI}${asientosF}`);
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