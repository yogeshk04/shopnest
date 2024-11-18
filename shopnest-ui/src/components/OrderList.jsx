import React, { useEffect, useState } from 'react';
import { fetchOrders } from '../services/orderService';
import '../styles/OrderList.css';

const OrderList = () => {
  const [orders, setOrders] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const getOrders = async () => {
      try {
        const data = await fetchOrders();
        setOrders(data);
        setLoading(false);
      } catch (error) {
        setError(error);
        setLoading(false);
      }
    };

    getOrders();
  }, []);

  if (loading) {
    return <div>Loading...</div>;
  }

  if (error) {
    return <div>Error: {error.message}</div>;
  }

  return (
    <div className="order-list">
      <h2>Order List</h2>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Date</th>
            <th>Status</th>
            <th>Customer</th>
            <th>Product</th>
            <th>Revenue</th>
          </tr>
        </thead>
        <tbody>
          {orders.map((order) => (
            <tr key={order.id}>
              <td>{order.id}</td>
              <td>{new Date(order.date).toLocaleString()}</td>
              <td>{order.status}</td>
              <td>{order.customer}</td>
              <td>{order.product}</td>
              <td>{order.revenue}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default OrderList;