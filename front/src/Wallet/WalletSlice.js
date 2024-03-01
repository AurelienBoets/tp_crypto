import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import axios from "axios";

const BASE_API_URL = "http://localhost:8083/wallets";
export const fetchWallets = createAsyncThunk(
  "wallet/fetchUserWallet",
  async () => {
    try {
      const response = await axios.get(
        `${BASE_API_URL}/${localStorage.getItem("user")}`
      );
      return response.data;
    } catch (error) {
      throw error;
    }
  }
);

export const postWallet = createAsyncThunk(
  "wallet/postWallets",
  async (newWallet) => {
    try {
      const response = await axios.post(
        `${BASE_API_URL}/wallet/${localStorage.getItem("user")}`,
        newWallet
      );
      return response.data;
    } catch (error) {
      throw error;
    }
  }
);

export const fetchWalletById = createAsyncThunk(
  "wallet/fetchWalletById",
  async (walletId) => {
    try {
      const response = await axios.get(`${BASE_API_URL}/wallet/${walletId}`);
      return response.data;
    } catch (error) {
      throw error;
    }
  }
);

export const postTransaction = createAsyncThunk(
  "wallet/postTransaction",
  async (newTransaction, walletId) => {
    try {
      const response = await axios.post(
        `${BASE_API_URL}/wallet/${walletId}/transaction`,
        newTransaction
      );
      return response.data;
    } catch (error) {
      throw error;
    }
  }
);

const walletSlice = createSlice({
  name: "wallet",
  initialState: {
    wallets: [],
  },
  reducers: {},
  extraReducers: (builder) => {
    builder.addCase(fetchWallets.fulfilled, (state, action) => {
      state.wallets = action.payload;
    });
    builder.addCase(postWallet.fulfilled, (state, action) => {
      state.wallets.push(action.payload);
    });
    builder.addCase(fetchWalletById.fulfilled, (state, action) => {
      state.selectedwallet = action.payload;
    });
    builder.addCase(postTransaction.fulfilled, (state, action) => {
      state.wallets.push = action.payload;
    });
  },
});

export default walletSlice.reducer;
