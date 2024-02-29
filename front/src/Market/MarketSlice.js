import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import axios from "axios";

const BASE_API_URL = "http://localhost:8083/markets";
export const fetchMarkets = createAsyncThunk(
  "market/fetchMarkets",
  async () => {
    try {
      const response = await axios.get(`${BASE_API_URL}`);
      return response.data;
    } catch (error) {
      throw error;
    }
  }
);

export const postMarket = createAsyncThunk(
  "market/postMarkets",
  async (newMarket) => {
    try {
      const response = await axios.post(`${BASE_API_URL}`, newMarket);
      return response.data;
    } catch (error) {
      throw error;
    }
  }
);

export const fetchMarketById = createAsyncThunk(
  "market/fetchMarketById",
  async (marketId) => {
    try {
      const response = await axios.get(`${BASE_API_URL}/${marketId}`);
      return response.data;
    } catch (error) {
      throw error;
    }
  }
);

export const deleteMarket = createAsyncThunk(
  "market/deleteMarket",
  async (marketId) => {
    try {
      await axios.delete(`${BASE_API_URL}${marketId}`);
      return marketId;
    } catch (error) {
      throw error;
    }
  }
);

const marketSlice = createSlice({
  name: "market",
  initialState: {
    markets: [],
  },
  reducers: {},
  extraReducers: (builder) => {
    builder.addCase(fetchMarkets.fulfilled, (state, action) => {
      state.markets = action.payload;
    });
    builder.addCase(postMarket.fulfilled, (state, action) => {
      state.markets.push(action.payload);
    });
    builder.addCase(deleteMarket.fulfilled, (state, action) => {
      state.markets = state.markets.filter(
        (market) => market.id !== action.payload
      );
    });
    //   builder.addCase(updateMarket.fulfilled, (state, action) => {
    //     const index = state.markets.findIndex(
    //       (market) => market.id === action.payload.id
    //     );
    //     if (index !== -1) {
    //       state.markets[index] = action.payload;
    //     }
    //   });
    builder.addCase(fetchMarketById.fulfilled, (state, action) => {
      state.selectedmarket = action.payload;
    });
  },
});

export default marketSlice.reducer;
