import React, { useEffect, useState } from 'react'
import { useParams } from "react-router-dom";
import { useDispatch,useSelector } from 'react-redux';
import { productAction, selectListProduct, selectProductDetail } from '../../saga/product/productSlide';
import Dropdown from 'react-bootstrap/Dropdown';
import DropdownButton from 'react-bootstrap/DropdownButton';
import { MDBIcon } from 'mdb-react-ui-kit';
import { Button } from 'react-bootstrap';
function ProductDetail() {
    const [size, updateSize] = useState(36);
    const [quantity, updateQuantity] = useState(0);
    const { id } = useParams();
    const products = useSelector(selectListProduct);
    let style = {
      display: 'flex',
      justifyContent: 'center',
      marginTop: 50
    }
    const handleChangeSize = (e) => {
       updateSize(e.target.value); 
       console.log(e.target.value);
    }
    const handleSelectSize = (e,evt) => {
      let rs = Number(e) + 35;
      updateSize(rs);
    }
    const handleChangeQuantity = (e) => {
      updateQuantity(e.target.value); 
    }
  return (
    <div >
    {
      products.map((productItem) => {
        if(productItem.id==id)
        return (
          <div key={productItem.id} style={style}>
            <div>
              <img src={process.env.PUBLIC_URL +"/assets/" + productItem.image} alt="no image" style={{width: 400}}></img>
              <div>
                <MDBIcon className='yellow-text pr-3'  icon="star" />
                <MDBIcon className='yellow-text pr-3'  icon="star" />
                <MDBIcon className='yellow-text pr-3'  icon="star" />
                <MDBIcon className='yellow-text pr-3'  icon="star" />
                <MDBIcon className='yellow-text pr-3'  far icon="star" />
              </div>
            </div>
            <div style={{width: 350, margin: 30}}>
              <h3>
                {productItem.productname}
              </h3>
              <div style={{display: 'flex'}}>
                Brand: 
                <h5 style={{marginLeft: 40}}>{productItem.brand.brandname}</h5>
              </div>
              <div style={{display: 'flex',marginBottom: 10}}>
                Category: 
                <h5 style={{marginLeft: 40}}>{productItem.category.categoryname}</h5>
              </div>
              <div style={{display: 'flex',marginBottom: 10}}>
                <div style={{display: 'flex',margin: 10}}>
                  <DropdownButton id="dropdown-basic-button" title="Size" onSelect={handleSelectSize}>
                    <Dropdown.Item eventKey="1">36</Dropdown.Item>
                    <Dropdown.Item eventKey="2">37</Dropdown.Item>
                    <Dropdown.Item eventKey="3">38</Dropdown.Item>
                    <Dropdown.Item eventKey="4">39</Dropdown.Item>
                    <Dropdown.Item eventKey="5">40</Dropdown.Item>
                    <Dropdown.Item eventKey="6">41</Dropdown.Item>
                    <Dropdown.Item eventKey="7">42</Dropdown.Item>
                    <Dropdown.Item eventKey="8">43</Dropdown.Item>
                    <Dropdown.Item eventKey="9">44</Dropdown.Item>
                  </DropdownButton>
                  <input type={'number'} name="size" id='size' placeholder='size' style={{width: 50}} value={size} onChange={handleChangeSize}></input>
                </div>
                <div style={{display: 'flex',margin: 10}}>
                  <label for="quantity" style={{background: '#1266f1',color: '#ffffff',padding: 5, marginLeft: 20}}>Quantity</label>
                  <input type={'number'} name="quantity" id='quantity' style={{width: 50}} value={quantity} onChange={handleChangeQuantity}></input>
                </div>
              </div>
              <div>{productItem.description}</div>
              <Button variant='success' style={{marginTop: 20}}>ADD TO CART</Button>
            </div>
          </div>
        )
      })
    }
      
    </div>
  )
}

export default ProductDetail