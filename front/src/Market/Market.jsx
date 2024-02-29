import { useDispatch, useSelector } from "react-redux";
import { useEffect } from "react";
import { fetchMarkets } from "./MarketSlice";
import React from "react";

const Market = () => {
  const markets = useSelector((state) => state.markets.markets);
  const dispatch = useDispatch();

  useEffect(() => {
    dispatch(fetchMarkets());
  }, [dispatch]);


  return (
    <div className="container">
      <h1>Cryptos</h1>
      <table className="table table-striped">
        <thead>
          <tr>
            <th scope="col">Nom de la crypto</th>
            <th scope="col">Valeur</th>
          </tr>
        </thead>
        <tbody>
          {markets.map((market, index) => (
            <tr
              key={index}
              className={index % 2 === 0 ? "bg-dark text-white" : ""}
            >
              <td>{market.name}</td>
              <td>{market.price}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default Market;
