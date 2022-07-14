import { createSlice } from '@reduxjs/toolkit';

  const initialState = {
    isLogin: false,
    account: []
  };
  export const userSlice = createSlice({
    name: 'user',
    initialState,
    reducers: {
        fetchUser: (state,action) => {
        },
        signInFail: (state,action) => {
            state.isLogin=false;
        },
        signInSuccess: (state,action) => {
            state.isLogin=true;
            state.account=action.payload.data;
        }
    },
  });
  

  export const userAction = userSlice.actions;
  export const selectUser = (state) => state.user.account;
  const userReducer = userSlice.reducer;
  export default userReducer;