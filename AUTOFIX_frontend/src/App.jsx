import './App.css'
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom'
import Navbar from "./components/Navbar"
import Home from './components/Home';
import VehiculoList from './components/VehiculosList';
//import AddEditEmployee from './components/AddEditEmployee';
//import ExtraHoursList from './components/ExtraHoursList';
//import AddEditExtraHours from './components/AddEditExtraHours';
import NotFound from './components/NotFound';
//import PaycheckList from './components/PaycheckList';
//import PaycheckCalculate from './components/PaycheckCalculate';
//import AnualReport from './components/AnualReport';

function App() {
  return (
      <Router>
          <div className="container">
          <Navbar></Navbar>
            <Routes>
              <Route path="/home" element={<Home/>} />
              <Route path="/vehiculo/list" element={<VehiculoList/>} />
              <Route path="*" element={<NotFound/>} />
            </Routes>
          </div>
      </Router>
  );
}

export default App
