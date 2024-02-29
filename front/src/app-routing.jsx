import { createBrowserRouter } from "react-router-dom";
import App from "./App";
import ErrorPage from "./ErrorPage";
import ProtectedRoute from "./ProtectedRoute";
import Market from "./Market/Market";
import FormLogin from "./Auth/FormLogin";
import Wallet from "./Wallet/Wallet";

const router = createBrowserRouter([
  {
    element: <App />,
    errorElement: <ErrorPage />,
    children: [
      {
        path: "/",
        element: <Market />,
      },
      {
        path: "/login",
        element: <FormLogin />,
      },

      {
        path: "/Wallet",
        element: (
          <ProtectedRoute>
            <Wallet />
          </ProtectedRoute>
        ),
      },
    ],
  },
]);

export default router;
