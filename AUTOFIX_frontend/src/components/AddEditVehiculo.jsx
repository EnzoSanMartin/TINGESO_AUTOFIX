import { useState, useEffect } from "react";
import { Link, useParams, useNavigate } from "react-router-dom";
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import Button from "@mui/material/Button";
import FormControl from "@mui/material/FormControl";
import MenuItem from "@mui/material/MenuItem";
import SaveIcon from "@mui/icons-material/Save";
import vehiculoService from "../services/vehiculo.service";

const AddEditVehiculo = () => {
  const [patente, setPatente] = useState("");
  const [marca, setMarca] = useState("");
  const [modelo, setModelo] = useState("");
  const [tipo, setTipo] = useState("");
  const [tipoMotor, setTipoMotor] = useState("");
  const [añoFabricacion, setAñoFabricacion] = useState("");
  const [NAsientos, setNAsientos] = useState("");
  const [kilometros, setKilometros] = useState("");
  const { id } = useParams();
  const [titleVehiculoForm, setTitleVehiculoForm] = useState("");
  const navigate = useNavigate();

  const saveVehiculo = (e) => {
    e.preventDefault();

    const vehiculo = {patente, marca, modelo, tipo, tipoMotor, añoFabricacion, NAsientos, kilometros, id};
    if (id) {
      //Actualizar Datos Empelado
      vehiculoService
        .update(vehiculo)
        .then((response) => {
          console.log("El vehiculo ha sido actualizado.", response.data);
          navigate("/vehiculo/list");
        })
        .catch((error) => {
          console.log(
            "Ha ocurrido un error al intentar actualizar datos del vehiculo.",
            error
          );
        });
    } else {
      //Crear nuevo empleado
      vehiculoService
        .create(vehiculo)
        .then((response) => {
          console.log("El vehiculo ha sido añadido.", response.data);
          navigate("/vehiculo/list");
        })
        .catch((error) => {
          console.log(
            "Ha ocurrido un error al intentar crear nuevo vehiculo.",
            error
          );
        });
    }
  };

  useEffect(() => {
    if (id) {
      setTitleVehiculoForm("Editar Vehiculo");
      vehiculoService
        .getId(id)
        .then((vehiculo) => {
          setPatente(vehiculo.data.patente);
          setMarca(vehiculo.data.marca);
          setModelo(vehiculo.data.modelo);
          setTipo(vehiculo.data.tipo);
          setTipoMotor(vehiculo.data.tipoMotor);
          setAñoFabricacion(vehiculo.data.añoFabricacion);
          setNAsientos(vehiculo.data.NAsientos);
          setKilometros(vehiculo.data.kilometros);
        })
        .catch((error) => {
          console.log("Se ha producido un error.", error);
        });
    } else {
      setTitleVehiculoForm("Nuevo Vehiculo");
    }
  }, []);

  return (
    <Box
      display="flex"
      flexDirection="column"
      alignItems="center"
      justifyContent="center"
      component="form"
      bgcolor={'#FFFFFF'}
    >
      <h3> {titleVehiculoForm} </h3>
      <hr />
      <form>
        <FormControl fullWidth>
          <TextField
            id="patente"
            label="Patente"
            value={patente}
            variant="standard"
            onChange={(e) => setPatente(e.target.value)}
            helperText="Ej. ABCD01"
          />
        </FormControl>

        <FormControl fullWidth>
          <TextField
            id="marca"
            label="Marca"
            value={marca}
            variant="standard"
            onChange={(e) => setMarca(e.target.value)}
          />
        </FormControl>

        <FormControl fullWidth>
          <TextField
            id="modelo"
            label="Modelo"
            value={modelo}
            variant="standard"
            onChange={(e) => setModelo(e.target.value)}
          />
        </FormControl>

        <FormControl fullWidth>
          <TextField
            id="tipo"
            label="Tipo"
            value={tipo}
            variant="standard"
            onChange={(e) => setTipo(e.target.value)}
          />
        </FormControl>

        <FormControl fullWidth>
          <TextField
            id="tipoMotor"
            label="Tipo de Motor"
            value={tipoMotor}
            variant="standard"
            onChange={(e) => setTipoMotor(e.target.value)}
            helperText="Ej. gasolina"
          />
        </FormControl>

        <FormControl fullWidth>
          <TextField
            id="añoFabricacion"
            label="Año de Fabricacion"
            type="number"
            value={añoFabricacion}
            variant="standard"
            onChange={(e) => setAñoFabricacion(e.target.value)}
          />
        </FormControl>

        <FormControl fullWidth>
          <TextField
            id="nasientos"
            label="Numero de Asientos"
            type="number"
            value={NAsientos}
            variant="standard"
            onChange={(e) => setNAsientos(e.target.value)}
          />
        </FormControl>

        <FormControl fullWidth>
          <TextField
            id="kilometros"
            label="Kilometraje"
            type="number"
            value={kilometros}
            variant="standard"
            onChange={(e) => setKilometros(e.target.value)}
          />
        </FormControl>

        <FormControl>
          <br />
          <Button
            variant="contained"
            color="info"
            onClick={(e) => saveVehiculo(e)}
            style={{ marginLeft: "0.5rem" }}
            startIcon={<SaveIcon />}
          >
            Grabar
          </Button>
        </FormControl>
      </form>
      <hr />
      <Link to="/vehiculo/list">Back to List</Link>
    </Box>
  );
};

export default AddEditVehiculo;