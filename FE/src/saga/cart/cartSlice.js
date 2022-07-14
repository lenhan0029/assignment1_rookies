import { createSlice } from '@reduxjs/toolkit';

  const initialState = {
    cart: [],
    cartdetails: []
  };
  export const cartSlice = createSlice({
    name: 'cart',
    initialState,
    reducers: {
        fetchCart: (state,action) => {
        },
        fetchCartFail: (state,action) => {
        },
        fetchCartSuccess: (state,action) => {
            state.cart=action.payload.data;
        },
        fetchCartDetails: (state,action) => {

        },
        fetchCartDetailSuccess: (state,action) => {
          state.cart=action.payload.data;
        }
    },
  });
  

  export const cartAction = cartSlice.actions;
  export const selectCart = (state) => state.cart.cart;
  export const selectCartDetails = (state) => state.cart.cartdetails;
  const cartReducer = cartSlice.reducer;
  export default cartReducer;