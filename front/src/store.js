import { configureStore } from "@reduxjs/toolkit";
import MarketSlice from "./Market/MarketSlice";
import LoginSlice from "./Auth/LoginSlice";

const store = configureStore({
  reducer: {
    markets: MarketSlice,
    logins: LoginSlice,
  },
});

export default store;
