import React from 'react'
import Carousel from 'react-bootstrap/Carousel';
import ProductItem from '../product/ProductItem'
import { Container,Row,Col } from 'react-bootstrap'

function NewProduct(props) {

  return (
    <div>
        <Container> 
        <Row xl={'auto'}>
          
          {props.products.map((productItem) => {
            if(productItem.id < 5)
            return (
            <Col>
            <ProductItem
              key={productItem.id}
              productItem={productItem}
            />
            </Col>
          )}
          )}
          
        </Row>
      </Container>
    </div>
  )
}

export default NewProduct