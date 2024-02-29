import { configureStore } from "@reduxjs/toolkit";
import MarketSlice from "./Market/MarketSlice";
import LoginSlice from "./Auth/LoginSlice";
import WalletSlice from "./Wallet/WalletSlice";

const store = configureStore({
  reducer: {
    markets: MarketSlice,
    logins: LoginSlice,
    wallets: WalletSlice,
  },
});

export default store;
