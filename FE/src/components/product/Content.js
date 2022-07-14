import React, { useState,useEffect } from 'react'
import { useDispatch,useSelector } from 'react-redux';
import { productAction, selectListProduct } from '../../saga/product/productSlide';
import ProductItem from './ProductItem';
import { Container,Row,Col } from 'react-bootstrap'
import ProductNav from './ProductNav';
import API from '../../api/API';

function Content() {
  const products = useSelector(selectListProduct);
  return (
    <div>
    
      <ProductNav />
      <Container> 
        <Row xl={'auto'}>
          
          {products.map((productItem) => (
            <Col>
            <ProductItem
              key={productItem.id}
              productItem={productItem}
            />
            </Col>
          ))}
          
        </Row>
      </Container>
    </div>
  )
}

export default Content