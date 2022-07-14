import React,{ useState,useEffect} from 'react'
import Table from 'react-bootstrap/Table';
import API from '../../api/API'
import axios from 'axios'
import { useDispatch,useSelector } from 'react-redux';
import { cartAction, selectCart, selectCartDetails } from '../../saga/cart/cartSlice';
function Cart() {
  const cartid = localStorage.getItem("cartid");
  const token = localStorage.getItem("token");
  const [cartdetails,setCartDetails] = useState([]);
  const dispatch = useDispatch();
  async function fetchCartDetails(){
    const result = await API.callAPI({
      url: 'http://localhost:8088/cartdetail/cartid=' + cartid,
      method: "GET",
      headers: {
        "Authorization": "Bearer " + token,
    }
    })
    setCartDetails(result.data);
    console.log(result);
  }
  useEffect(() => {
    
    fetchCartDetails();
  }, []);
  console.log(cartdetails);
  return (
    <Table striped bordered hover>
      <thead>
        <tr>
          <th>Image</th>
          <th>Name</th>
          <th>quantity</th>
          <th>size</th>
          <th>Price</th>
        </tr>
      </thead>
      <tbody>
          {cartdetails.map((cartItem) => (
            <tr key={cartItem.id}>
              <th><img src={process.env.PUBLIC_URL+"assets/" + cartItem.quantitys.product.image} style={{width: 100}}/></th>
              <th>{cartItem.quantitys.product.image}</th>
              <th>{cartItem.quantity}</th>
              <th>{cartItem.quantitys.size.size}</th>
              <th>{cartItem.quantitys.product.price}</th>
            </tr>
          ))}
        {/* <tr>
          <td>Total</td>
          <td colSpan={4}>Total</td>
          <td>@twitter</td>
        </tr> */}
      </tbody>
    </Table>
  )
}

export default Cart