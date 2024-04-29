import { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import vehiculoService from "../services/vehiculo.service";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell, { tableCellClasses } from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";
import Button from "@mui/material/Button";
import PersonAddIcon from "@mui/icons-material/PersonAdd";
import EditIcon from "@mui/icons-material/Edit";
import DeleteIcon from "@mui/icons-material/Delete";

const VehiculoList = () => {
  const [vehiculos, setVehiculo] = useState([]);

  const navigate = useNavigate();

  const init = () => {
    vehiculoService
      .getAll()
      .then((response) => {
        console.log("Mostrando listado de todos los vehiculos", response.data);
        setVehiculo(response.data);
      })
      .catch((error) => {
        console.log(
          "Se ha producido un error al intentar mostrar listado de todos los vehiculos.",
          error
        );
      });
  };

  useEffect(() => {
    init();
  }, []);

  const handleDelete = (id) => {
    console.log("Printing id", id);
    const confirmDelete = window.confirm(
      "¿Esta seguro que desea borrar este vehiculo?"
    );
    if (confirmDelete) {
      vehiculoService
        .remove(id)
        .then((response) => {
          console.log("El vehiculo ha sido eliminado.", response.data);
          init();
        })
        .catch((error) => {
          console.log(
            "Se ha producido un error al intentar eliminar al vehiculo",
            error
          );
        });
    }
  };

  const handleEdit = (id) => {
    console.log("Printing id", id);
    navigate(`/vehiculo/edit/${id}`);
  };

  return (
    <TableContainer component={Paper}>
      <br />
      <Link
        to="/vehiculo/add"
        style={{ textDecoration: "none", marginBottom: "1rem" }}
      >
        <Button
          variant="contained"
          color="primary"
          startIcon={<PersonAddIcon />}
        >
          Registrar Vehiculo
        </Button>
      </Link>
      <br /> <br />
      <Table sx={{ minWidth: 650 }} size="small" aria-label="a dense table">
        <TableHead>
          <TableRow>
            <TableCell align="left" sx={{ fontWeight: "bold" }}>
              Patente
            </TableCell>
            <TableCell align="left" sx={{ fontWeight: "bold" }}>
              Marca
            </TableCell>
            <TableCell align="right" sx={{ fontWeight: "bold" }}>
              Modelo
            </TableCell>
            <TableCell align="right" sx={{ fontWeight: "bold" }}>
              Tipo
            </TableCell>
            <TableCell align="right" sx={{ fontWeight: "bold" }}>
              TipoMotor
            </TableCell>
            <TableCell align="left" sx={{ fontWeight: "bold" }}>
              AñoFabricacion
            </TableCell>
            <TableCell align="left" sx={{ fontWeight: "bold" }}>
                NumeroAsientos
            </TableCell>
            <TableCell align="left" sx={{ fontWeight: "bold" }}>
                Kilometraje
            </TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {vehiculos.map((vehiculo) => (
            <TableRow
              key={vehiculo.id}
            >
              <TableCell align="left">{vehiculo.patente}</TableCell>
              <TableCell align="left">{vehiculo.marca}</TableCell>
              <TableCell align="right">{vehiculo.modelo}</TableCell>
              <TableCell align="right">{vehiculo.tipo}</TableCell>
              <TableCell align="right">{vehiculo.tipoMotor}</TableCell>
              <TableCell align="right">{vehiculo.añoFabricacion}</TableCell>
              <TableCell align="right">{vehiculo.NAsientos}</TableCell>
              <TableCell abbr="right">{vehiculo.kilometros}</TableCell>
              <TableCell>
                <Button
                  variant="contained"
                  color="info"
                  size="small"
                  onClick={() => handleEdit(vehiculo.id)}
                  style={{ marginLeft: "0.5rem" }}
                  startIcon={<EditIcon />}
                >
                  Editar
                </Button>

                <Button
                  variant="contained"
                  color="error"
                  size="small"
                  onClick={() => handleDelete(vehiculo.id)}
                  style={{ marginLeft: "0.5rem" }}
                  startIcon={<DeleteIcon />}
                >
                  Eliminar
                </Button>
              </TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
};

export default VehiculoList;