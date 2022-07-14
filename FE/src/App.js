
import './App.css';
import React, { useState,useEffect } from 'react'
import Navbars from './screens/Navbars';
import Home from './components/home';
import { Routes,Route } from 'react-router-dom';
import Content from './components/product/Content';
import 'bootstrap/dist/css/bootstrap.css';
import ProductDetail from './components/product/ProductDetail';
import Signup from './components/form/Signup';
import Login from './components/form/Login';
import Footer from './screens/Footer';
import 'mdb-react-ui-kit/dist/css/mdb.min.css'
import { useDispatch,useSelector } from 'react-redux';
import { productAction, selectListProduct } from '../src/saga/product/productSlide';
import { selectUser } from './saga/user/userSlice';
import { userAction } from './saga/user/userSlice';
import Cart from './components/cart/Cart';
import { cartAction, selectCart } from './saga/cart/cartSlice';
function App() {
  const dispatch = useDispatch();
  
  const [user,setUser] = useState();
  const [status,setStatus] = useState();
  useEffect(() => {
    dispatch(
      productAction.fetchListProduct()
    )
    setUser(account);
  },[]);
  const handleData = (data) => {
    setUser(data);
  }
  const handleStatus = (data) => {
    setStatus(data);
  }
  useEffect(() => {
    if(status==1){
      dispatch(
        userAction.fetchUser(user)
      );
    }
  },[status]);
  const account = useSelector(selectUser);
  if(account.id > 0){
    localStorage.setItem("token",account.accessToken);
    localStorage.setItem("user",JSON.stringify(account));
    dispatch(
      cartAction.fetchCart(account.id)
    );
      window.location.assign("http://localhost:3000/product");
  }
  return (
    <div className="App">
      <Navbars />
      <Routes>
        <Route path="/login" element={<Login selectData={handleData} selectStatus={handleStatus}/>}></Route>
        <Route path="/signup" element={<Signup/>}></Route>
        <Route path="/product" element={<Content />}></Route>
        <Route path="/product/:id" element={<ProductDetail />}></Route>
        <Route path="/cart" element={<Cart />}></Route>
        <Route path='/' element={<Home />}></Route>
      </Routes>
      <Footer />
    </div>
  );
}

export default App;
