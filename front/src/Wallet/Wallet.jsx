import React, { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { fetchWallets } from "./WalletSlice"; // Importez l'action fetchWallets depuis votre slice

const Wallet = () => {
  const dispatch = useDispatch();
  const wallets = useSelector((state) => state.wallets.wallets); // Accédez à l'état du store Redux

  useEffect(() => {
    // Dispatch de l'action fetchWallets lorsque le composant est monté
    dispatch(fetchWallets());
  }, [dispatch]);

  return (
    <div className="container">
      <h1 className="mt-4">Wallet</h1>
      <hr />
      <div className="row">
        <div className="col-md-6">
          <div className="card">
            <div className="card-body">
              <h5 className="card-title">Wallet Information</h5>
              {wallets.map((wallet) => (
                <div key={wallet.idWallet}>
                  <p className="card-text">ID: {wallet.idWallet}</p>
                  <p className="card-text">Crypto ID: {wallet.cryptoId}</p>
                </div>
              ))}
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Wallet;
