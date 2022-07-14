import React from 'react'
import { Card,Button } from 'react-bootstrap'
import { Link } from 'react-router-dom'
import {
  MDBIcon
} from 'mdb-react-ui-kit';
export default function ProductItem({productItem}) {
  let link = "/product/" + productItem.id;
  return (
    <Card style={{ width: '18rem' }}>
      <Link to={link}>
      <Card.Img variant="top" src={process.env.PUBLIC_URL+"assets/" + productItem.image} />
      </Link>
      <Card.Body>
        <Card.Title style={{fontSize: 15}}>{productItem.productname}</Card.Title>
        <Card.Text>
          {productItem.price} $
        </Card.Text>
        <Card.Text>
          <MDBIcon className='yellow-text pr-3'  icon="star" />
          <MDBIcon className='yellow-text pr-3'  icon="star" />
          <MDBIcon className='yellow-text pr-3'  icon="star" />
          <MDBIcon className='yellow-text pr-3'  icon="star" />
          <MDBIcon className='yellow-text pr-3'  far icon="star" />
        </Card.Text>
        <Button variant="primary">ADD TO CART</Button>
      </Card.Body>
    </Card>
  )
}
