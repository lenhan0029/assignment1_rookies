import { all } from 'redux-saga/effects'
import cartSaga from '../saga/cart/cartSaga'
import productSaga from '../saga/product/productSaga'
import userSaga from '../saga/user/userSaga'

export default function* rootSaga() {
  yield all([productSaga(),userSaga(),cartSaga()])
}