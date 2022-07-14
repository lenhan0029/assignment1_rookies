import { call, takeEvery, put } from 'redux-saga/effects'
import Axios from 'axios'
import { cartAction } from './cartSlice'
import API from '../../api/API'
// export const token = localStorage.getItem("token");
export function* fetchCart(action) {
  try {
    // console.log(action.payload);
    const token = localStorage.getItem("token");
    let result = yield call(() =>
      API.callAPI({
        url: 'http://localhost:8088/cart',
        method: "POST",
        data: {"accountid": action.payload},
        headers: {
            "Authorization": "Bearer " + token,
        }
      })
    )
    localStorage.setItem("cartid",result.data.id);
    console.log(token);
    yield put(cartAction.fetchCartSuccess(result));
  } catch (e) {
    yield put(cartAction.fetchCartFail(e));
  }
}
export function* fetchCartDetails(action) {
    try {
      // console.log(action.payload);
      const token = localStorage.getItem("token");
      let result = yield call(() =>
        API.callAPI({
          url: 'http://localhost:8088/cartdetail/cartid='+ action.payload,
          method: "GET",
          headers: {
            "Authorization": "Bearer " + token,
        }
        })
      )
      // localStorage.setItem("token",result.accessToken);
      yield put(cartAction.fetchCartDetailSuccess(result));
    } catch (e) {
      yield put(cartAction.fetchCartFail(e));
    }
  }
export default function* cartSaga() {
    yield takeEvery(cartAction.fetchCart, fetchCart);
    yield takeEvery(cartAction.fetchCartDetails, fetchCartDetails);
  }