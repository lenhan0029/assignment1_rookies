import { call, takeEvery, put } from 'redux-saga/effects'
import Axios from 'axios'
import { productAction } from './productSlide'
import API from '../../api/API'

export function* fetchListProduct() {
  try {
    let result = yield call(() =>
      API.callAPI({
        url: 'http://localhost:8088/product',
        method: "GET",
      })
    )
    yield put(productAction.fetchListProductSuccess(result));
  } catch (e) {
    yield put(productAction.fetchListProductFail(e));
  }
}
export default function* productSaga() {
    yield takeEvery(productAction.fetchListProduct, fetchListProduct);
  }