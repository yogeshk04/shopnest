import React from 'react';
import { Link } from 'react-router-dom';
import '../styles/Layout.css';

const Layout = ({ children }) => {
  return (
    <div className="layout-container">
      <aside className="side-nav">
        <h2>ShopNest</h2>
        <nav>
          <ul>
            <li><Link to="/">Home</Link></li>
            <li><Link to="/orders">Orders</Link></li>
            <li><Link to="/account">Account</Link></li>
          </ul>
        </nav>
      </aside>
      <main className="main-content">
        {children}
      </main>
    </div>
  );
};

export default Layout;