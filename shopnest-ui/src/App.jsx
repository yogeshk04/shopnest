import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Login from "./components/Login";
import OrderList from "./components/OrderList";

function App() {
  return (
    <Router>
      <div className="App">
        <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/orders" element={<OrderList />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;