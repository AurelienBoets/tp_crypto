import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import axios from "axios";

const BASE_API_URL = "http://localhost:8082";

export const postLogin = createAsyncThunk(
  "login/postlogins",
  async (newLogin) => {
    try {
      const response = await axios.post(`${BASE_API_URL}`, newLogin);
      return response.data;
    } catch (error) {
      throw error;
    }
  }
);

export const postConnexion = createAsyncThunk(
  "login/postConnexions",
  async (newLogin) => {
    try {
      const response = await axios.post(`${BASE_API_URL}/login`, newLogin);
      return response.data;
    } catch (error) {
      throw error;
    }
  }
);

export const fetchLoginById = createAsyncThunk(
  "login/fetchloginById",
  async (loginId) => {
    try {
      const response = await axios.get(`${BASE_API_URL}/${loginId}`);
      return response.data;
    } catch (error) {
      throw error;
    }
  }
);

const LoginSlice = createSlice({
  name: "login",
  initialState: {
    logins: [],
  },
  reducers: {},
  extraReducers: (builder) => {
    builder.addCase(postLogin.fulfilled, (state, action) => {
      state.logins.push(action.payload);
    });

    builder.addCase(postConnexion.fulfilled, (state, action) => {
      localStorage.setItem("user", action.payload.id);
    });

    builder.addCase(fetchLoginById.fulfilled, (state, action) => {
      state.selectedlogin = action.payload;
    });
  },
});

export default LoginSlice.reducer;
