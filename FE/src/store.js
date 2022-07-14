import createSagaMiddleware from 'redux-saga';
import { configureStore} from '@reduxjs/toolkit';
import rootSaga from './app/saga';
import productReducer from './saga/product/productSlide';
import userReducer from './saga/user/userSlice';
import cartReducer from './saga/cart/cartSlice';

// disalbe thunk and add redux-saga middleware
const sagaMiddleware = createSagaMiddleware();
const middleware = [sagaMiddleware];

export default configureStore({
  reducer: {
    product: productReducer,
    user: userReducer,
    cart: cartReducer
  },
  middleware: (getDefaultMiddleware) =>
  getDefaultMiddleware({
    serializableCheck: false
  }).concat(middleware)
  
});

sagaMiddleware.run(rootSaga);
