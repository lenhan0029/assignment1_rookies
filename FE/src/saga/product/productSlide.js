import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  loading: false,
  // product: {},
  listProduct: []
};

export const productSlice = createSlice({
  name: 'product',
  initialState,
  reducers: {
    fetchListProduct: (state, action) => {
      state.loading=true;
    },
    fetchListProductSuccess: (state, action) => {
      state.loading=false;
      state.listProduct=action.payload.data;
    },
    fetchListProductFail: (state, action) => {
      state.loading=false;
    },
    // fetchProductDetail: (state,action) => {
    //   state.product=action.payload.data;
    // }
  }
});

export const productAction = productSlice.actions;

export const selectListProduct = (state) => state.product.listProduct;
// export const selectProductDetail = (state) => state.product.product;
export const selectLoading = (state) => state.product.loading;
const productReducer = productSlice.reducer
export default productReducer;