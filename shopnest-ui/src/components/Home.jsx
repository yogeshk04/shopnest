// src/components/Home.jsx
import React from 'react';
import { Link } from 'react-router-dom';
import '../styles/Home.css';

const Home = () => {
  return (
    <div className="home-container">
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
        <header className="header">
          <div className="account-section">
            <span>Welcome, User</span>
            <Link to="/account">Account</Link>
          </div>
        </header>
        <section className="content">
          <h1>Welcome to ShopNest</h1>
          <p>Explore our wide range of products and enjoy shopping!</p>
        </section>
      </main>
    </div>
  );
};

export default Home;