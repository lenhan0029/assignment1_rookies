import React from 'react'
import { useDispatch,useSelector } from 'react-redux';

function CartItem() {
    const cartdetails = useSelector(selectCartDetails);
  return (
    <div>{cartdetails}</div>
  )
}

export default CartItem