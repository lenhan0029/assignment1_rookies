import React,{ useEffect} from 'react'
import Banner from './Banner'
import NewProduct from './NewProduct';
import { useDispatch,useSelector } from 'react-redux';
import { productAction, selectListProduct } from '../../saga/product/productSlide';

export default function Home() {
  const products = useSelector(selectListProduct);
  let styletitle ={
    fontBold: 600,
    margin: 50,
    marginTop: 100
  }
  return (
    <>
        <Banner />

        <h3 style={styletitle}>New Product</h3>
        <NewProduct products={products}/>

        <h3 style={styletitle}>Top Sale</h3>
        <NewProduct products={products}/>
    </>
  )
}
