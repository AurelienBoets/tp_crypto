import { configureStore } from "@reduxjs/toolkit";
import MarketSlice from "./Market/MarketSlice";

const store = configureStore({
  reducer: {
    markets: MarketSlice,
  },
});

export default store;
