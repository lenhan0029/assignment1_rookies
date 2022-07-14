import { call, takeEvery, put } from 'redux-saga/effects'
import Axios from 'axios'
import { userAction } from './userSlice'
import API from '../../api/API'

export function* fetchUser(action) {
  try {
    // console.log(action.payload);
    let result = yield call(() =>
      API.callAPI({
        url: 'http://localhost:8088/api/auth/signin',
        method: "POST",
        data: action.payload
      })
    )
    // localStorage.setItem("token",result.accessToken);
    yield put(userAction.signInSuccess(result));
  } catch (e) {
    yield put(userAction.signInFail(e));
  }
}
export default function* userSaga() {
    yield takeEvery(userAction.fetchUser, fetchUser);
  }