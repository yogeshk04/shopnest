import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Login from "./components/Login";
import OrderList from "./components/OrderList";
import Home from "./components/Home";

function App() {
  return (
    <Router>
      <div className="App">
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/login" element={<Login />} />
          <Route path="/orders" element={<OrderList />} />
          <Route path="/account" element={<Login />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;